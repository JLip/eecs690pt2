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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PetCheckout_GUI {
	public static JList<Pets> petList;
	public static DefaultListModel<Pets> petListModel;
	public static JList<Tickets> ticketList;
	public static DefaultListModel<Tickets> ticketListModel;
	public static String animalSize = "";
	public static String animalType = "";
	public static int petID;
	public static boolean petCheckout;
	private JFrame PetCheckout;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					PetCheckout_GUI window = new PetCheckout_GUI();
					window.PetCheckout.setVisible(true);
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
		PetCheckout = new JFrame();
		PetCheckout.setTitle("Pet Checkout");
		PetCheckout.setBounds(100, 100, 594, 657);
		PetCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PetCheckout.getContentPane().setLayout(null);
		
		JScrollPane PetscrollPane = new JScrollPane();
		PetscrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		PetscrollPane.setBounds(10, 49, 241, 214);
		PetCheckout.getContentPane().add(PetscrollPane);
		
		petList = new JList();
		PetscrollPane.setViewportView(petList);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel label = new JLabel("Pets:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(10, 11, 218, 37);
		PetCheckout.getContentPane().add(label);
		
		JButton btnFelineServices = new JButton("Services");
		btnFelineServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if(petList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Please select a pet first");
					return;
					
				}
				
				UpdateVariables();
				Services.run();
				
				
			}
		});
		btnFelineServices.setBounds(310, 50, 112, 37);
		PetCheckout.getContentPane().add(btnFelineServices);
		
		JButton btnImmunizations = new JButton("Immunizations");
		btnImmunizations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(petList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Please select a pet first");
					return;
					
				}
				
				UpdateVariables();
				Immunizations.run();
			}
		});
		btnImmunizations.setBounds(442, 50, 112, 37);
		PetCheckout.getContentPane().add(btnImmunizations);
		
		JButton btnBoarding = new JButton("Boarding");
		btnBoarding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(petList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Please select a pet first");
					return;
					
				}
				
				UpdateVariables();
				Checkout_Boarding.run();
			}
		});
		btnBoarding.setBounds(310, 98, 112, 37);
		PetCheckout.getContentPane().add(btnBoarding);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		scrollPane.setBounds(10, 316, 245, 239);
		PetCheckout.getContentPane().add(scrollPane);
		
		ticketList = new JList<Tickets>();
		ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ticketList);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTicket.setBounds(10, 268, 218, 37);
		PetCheckout.getContentPane().add(lblTicket);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 585, 89, 23);
		PetCheckout.getContentPane().add(btnBack);
		
		JButton btnCashout = new JButton("Cashout");
		btnCashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(ticketList.getSelectedValue().
			}
		});
		btnCashout.setBounds(333, 585, 89, 23);
		PetCheckout.getContentPane().add(btnCashout);
		
		JButton btnFelineProducts = new JButton("Feline Products");
		btnFelineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(petList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Please select a pet first");
					return;
					
				}
				
				UpdateVariables();
				FelineProducts.run();
			}
		});
		btnFelineProducts.setBounds(310, 157, 112, 37);
		PetCheckout.getContentPane().add(btnFelineProducts);
		
		JButton btnCanineProducts = new JButton("Canine Products");
		btnCanineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(petList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Please select a pet first");
					return;
					
				}
				
				UpdateVariables();
				CanineProducts.run();
			}
		});
		btnCanineProducts.setBounds(452, 157, 116, 37);
		PetCheckout.getContentPane().add(btnCanineProducts);
		ClearTicket();
		PopulatePets();
		
	}
	
	public static void InsertServiceToTicket(int item_id, String item_name, double item_price)
	{
		Connection.Connect();
		
		String name = petList.getSelectedValue().getname() + " : " + item_name;
		String commandText = "INSERT INTO SingleSale (ID,Service,Price, PetID)" +
				"VALUES ('" + item_id + "', '" +
				name + "', '" + item_price + "'," + "'" + PetCheckout_GUI.petID + "')";
				SQL.UpdateResultSet(commandText);				
				PopulateTicket();

	}
	
	public static void UpdateVariables()
	{
		animalSize = petList.getSelectedValue().getsize();
		animalType = petList.getSelectedValue().getanimal();
		petID = petList.getSelectedValue().getID();
		petCheckout = true;
	}
	
	public static void PopulateTicket()
	{
	Connection.Connect();
	ticketListModel = new DefaultListModel<Tickets>();
	String commandText = "SELECT * from SingleSale";
	ResultSet rs = SQL.ExecuteResultSet(commandText);
	double price = 0;
	String name = "";
	try {
	while ((rs!=null) && (rs.next()))
	{	
	name = rs.getString("Service");
	price = rs.getDouble("Price");
	Tickets tick = new Tickets(name,price);	
	ticketListModel.addElement(tick);

	}
	}
	catch (SQLException e)
	{
	JOptionPane.showMessageDialog(null, e.toString());
	}
		
	ticketList.setModel(ticketListModel);


	}
	
	public static void PopulatePets()
	{
	Connection.Connect();
	petListModel = new DefaultListModel<Pets>();
	String commandStr = "SELECT * FROM PetRecord WHERE OwnerID ="+ Main_Menu.OwnerID +" ORDER BY Name;";
	ResultSet rs = SQL.ExecuteResultSet(commandStr);	
	String name = "";
	String size = "";
	String animal = "";
	int petID;
	try {
	while ((rs!=null) && (rs.next()))
		{	
			name = rs.getString("Name");
			petID = rs.getInt("PetID");
			size = rs.getString("Size");
			animal = rs.getString("Animal");
			Pets tick = new Pets(name, petID,animal,size);	
			petListModel.addElement(tick);

		}
	}
	catch (SQLException e)
	{
	JOptionPane.showMessageDialog(null, e.toString());
	}

	petList.setModel(petListModel);


	}
	
	public static void ClearTicket()
	{
		try{
		Connection.Connect();
		
		String commandText = "DELETE FROM SingleSale";
		SQL.UpdateResultSet(commandText);
		
		}
		catch(Exception e2)
		{
		}
	}
	
	public static boolean Cat()
	{
		if(PetCheckout_GUI.animalType.compareTo("Cat") == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
