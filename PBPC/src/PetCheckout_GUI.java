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
import java.awt.Toolkit;


public class PetCheckout_GUI {
	public static JList<Pets> petList;
	public static DefaultListModel<Pets> petListModel;
	public static JList<Tickets> ticketList;
	public static DefaultListModel<Tickets> ticketListModel;
	public static String animalSize = "";
	public static String animalType = "";
	public static int petID;
	public static boolean petCheckout;
	private JFrame frmPetCheckout;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					PetCheckout_GUI window = new PetCheckout_GUI();
					window.frmPetCheckout.setVisible(true);
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
		frmPetCheckout = new JFrame();
		frmPetCheckout.getContentPane().setBackground(Color.WHITE);
		frmPetCheckout.setIconImage(Toolkit.getDefaultToolkit().getImage(PetCheckout_GUI.class.getResource("/General_Images/GI_icon.png")));
		frmPetCheckout.setTitle("Pet Checkout");
		frmPetCheckout.setBounds(100, 100, 800, 600);
		frmPetCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetCheckout.getContentPane().setLayout(null);
		
		JScrollPane PetscrollPane = new JScrollPane();
		PetscrollPane.setBounds(10, 49, 241, 214);
		PetscrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		frmPetCheckout.getContentPane().add(PetscrollPane);
		
		petList = new JList();
		PetscrollPane.setViewportView(petList);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel label = new JLabel("Pets:");
		label.setBounds(10, 11, 218, 37);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmPetCheckout.getContentPane().add(label);
		
		JButton btnFelineServices = new JButton("Services");
		btnFelineServices.setBounds(497, 323, 172, 56);
		btnFelineServices.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		frmPetCheckout.getContentPane().add(btnFelineServices);
		
		JButton btnImmunizations = new JButton("Immunizations");
		btnImmunizations.setBounds(308, 323, 172, 56);
		btnImmunizations.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		frmPetCheckout.getContentPane().add(btnImmunizations);
		
		JButton btnBoarding = new JButton("Boarding");
		btnBoarding.setBounds(114, 323, 172, 56);
		btnBoarding.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		frmPetCheckout.getContentPane().add(btnBoarding);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(529, 49, 245, 214);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		frmPetCheckout.getContentPane().add(scrollPane);
		
		ticketList = new JList<Tickets>();
		scrollPane.setViewportView(ticketList);
		ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setBounds(529, 11, 218, 37);
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmPetCheckout.getContentPane().add(lblTicket);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 585, 89, 23);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
					try
					{
						ClearTicket();
					}
					catch(Exception e1)
					{}
				frmPetCheckout.dispose();
			}
		});
		frmPetCheckout.getContentPane().add(btnBack);
		
		JButton btnCashout = new JButton("Cashout");
		btnCashout.setBounds(333, 585, 89, 23);
		btnCashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PetCashout_GUI.run();
				frmPetCheckout.dispose();
			}
		});
		frmPetCheckout.getContentPane().add(btnCashout);
		
		JButton btnFelineProducts = new JButton("Feline Products");
		btnFelineProducts.setBounds(191, 407, 172, 56);
		btnFelineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		frmPetCheckout.getContentPane().add(btnFelineProducts);
		
		JButton btnCanineProducts = new JButton("Canine Products");
		btnCanineProducts.setBounds(422, 407, 172, 56);
		btnCanineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		frmPetCheckout.getContentPane().add(btnCanineProducts);
		
		JButton button = new JButton("Remove");
		button.setBounds(162, 566, 89, 31);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveFromTicket();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmPetCheckout.getContentPane().add(button);
		
		JButton btnBackToClients = new JButton("Back to Main Menu");
		btnBackToClients.setBounds(22, 510, 243, 41);
		btnBackToClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClearTicket();
				frmPetCheckout.dispose();
			}
		});
		btnBackToClients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmPetCheckout.getContentPane().add(btnBackToClients);
		
		JButton Cashout = new JButton("Cashout");
		Cashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PetCashout_GUI.run();
				frmPetCheckout.dispose();
			}
		});
		Cashout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Cashout.setBounds(514, 510, 243, 41);
		frmPetCheckout.getContentPane().add(Cashout);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RemoveFromTicket();
			}
		});
		btnRemove.setBounds(610, 271, 104, 30);
		frmPetCheckout.getContentPane().add(btnRemove);
		
		PopulatePets();
		PopulateTicket();
		
	}
	
	public static void InsertServiceToTicket(int item_id, String item_name, double item_price)
	{
		Connection.Connect();
		String cmd = "SELECT Taxable FROM Price WHERE ItemID = " + item_id;
		int taxable = 0;
		ResultSet rs = SQL.ExecuteResultSet(cmd);
		try {
			while ((rs!=null) && (rs.next()))
			{	
			taxable = rs.getInt("Taxable");
			}
			}
			catch (SQLException e)
			{
				System.out.println(e.toString());
			}
		
		String name = petList.getSelectedValue().getname() + " : " + item_name;
		String commandText = "INSERT INTO SingleSale (ID,Service,Price, PetID, Taxable)" +
				"VALUES ('" + item_id + "', '" +
				name + "', '" + item_price + "'," + "'" + petID + "'," + "'" + taxable + "')";
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
	
	public static void RemoveFromTicket()
	{
		Connection.Connect();
		Tickets tmp = ticketList.getSelectedValue();
		String name = tmp.getitem();		
		String commandText = "DELETE FROM SingleSale WHERE SingleSale.Service = (SELECT Service FROM SingleSale WHERE Service = " + "'" + name + "' LIMIT 1)";
		SQL.UpdateResultSet(commandText);
		PopulateTicket();
	}
}
