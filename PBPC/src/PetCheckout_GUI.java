import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


import com.mysql.jdbc.Statement;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;


public class PetCheckout_GUI {
	public static JList<Pets> petList;
	public static DefaultListModel<Pets> petListModel;
	private JFrame frame;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					PetCheckout_GUI window = new PetCheckout_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public PetCheckout_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane PetscrollPane = new JScrollPane();
		PetscrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		PetscrollPane.setBounds(10, 49, 241, 214);
		frame.getContentPane().add(PetscrollPane);
		
		petList = new JList();
		PetscrollPane.setViewportView(petList);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel label = new JLabel("Pets:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(10, 11, 218, 37);
		frame.getContentPane().add(label);
		
		JButton btnFelineServices = new JButton("Feline Services");
		btnFelineServices.setBounds(310, 50, 112, 37);
		frame.getContentPane().add(btnFelineServices);
		
		JButton btnCanineServices = new JButton("Canine Services");
		btnCanineServices.setBounds(442, 50, 112, 37);
		frame.getContentPane().add(btnCanineServices);
		
		JButton btnFelineImmunizations = new JButton("Feline Immunizations");
		btnFelineImmunizations.setBounds(310, 98, 112, 37);
		frame.getContentPane().add(btnFelineImmunizations);
		
		JButton btnCanineImmunizations = new JButton("Canine immunizations");
		btnCanineImmunizations.setBounds(442, 98, 112, 37);
		frame.getContentPane().add(btnCanineImmunizations);
		
		JButton btnFelineBoarding = new JButton("Feline Boarding");
		btnFelineBoarding.setBounds(310, 146, 112, 37);
		frame.getContentPane().add(btnFelineBoarding);
		
		JButton btnCanineBoarding = new JButton("Canine Boarding");
		btnCanineBoarding.setBounds(442, 146, 112, 37);
		frame.getContentPane().add(btnCanineBoarding);
		
		JButton btnFelineProducts = new JButton("Feline Products");
		btnFelineProducts.setBounds(310, 194, 112, 37);
		frame.getContentPane().add(btnFelineProducts);
		
		JButton btnCanineProducts = new JButton("Canine Products");
		btnCanineProducts.setBounds(442, 194, 112, 37);
		frame.getContentPane().add(btnCanineProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 245, 239);
		frame.getContentPane().add(scrollPane);
		
		JList<Tickets> list = new JList<Tickets>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		PopulatePets();
		
	}
	
	
	
	public static void PopulatePets()
	{

	petListModel = new DefaultListModel<Pets>();
	String commandStr = "SELECT PetID, Name FROM PetRecord WHERE OwnerID ="+ Main_Menu.OwnerID +" ORDER BY Name;";
	ResultSet rs = SQL.ExecuteResultSet(commandStr);	
	String name = "";
	int petID = 0;
	try {
	while ((rs!=null) && (rs.next()))
	{	
	name = rs.getString("Name");
	petID = rs.getInt("PetID");
	Pets tick = new Pets(name, petID);	
	petListModel.addElement(tick);

	}
	}
	catch (SQLException e)
	{
	JOptionPane.showMessageDialog(null, e.toString());
	}

	petList.setModel(petListModel);


	}
}
