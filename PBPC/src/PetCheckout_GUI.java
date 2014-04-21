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
		frame.setBounds(100, 100, 594, 481);
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
