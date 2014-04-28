import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;


public class PetCashout_GUI {

	private JFrame frmPetCashout;
	public static DefaultListModel<Tickets> serviceListModel;
	public static DefaultListModel<Tickets> productListModel;
	public static JList<Tickets> listProducts = new JList<Tickets>();
	public static JList<Tickets> listServices = new JList<Tickets>();
	public static double totalServices;
	public static double totalProducts;
	public static double Grandtotal;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					PetCashout_GUI window = new PetCashout_GUI();
					window.frmPetCashout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public PetCashout_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPetCashout = new JFrame();
		frmPetCashout.setTitle("Pet Cashout");
		frmPetCashout.setIconImage(Toolkit.getDefaultToolkit().getImage(PetCashout_GUI.class.getResource("/General_Images/GI_icon.png")));
		frmPetCashout.getContentPane().setBackground(Color.WHITE);
		frmPetCashout.setBounds(100, 100, 811, 541);
		frmPetCashout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetCashout.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 77, 294, 196);
		frmPetCashout.getContentPane().add(scrollPane);
		
		
		listProducts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listProducts);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 77, 294, 196);
		frmPetCashout.getContentPane().add(scrollPane_1);
		
		
		listServices.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(listServices);
		
		JButton button = new JButton("Cash");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PopulateMedicalRecords();								
				PetCheckout_GUI.ClearTicket();
				frmPetCashout.dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setBounds(191, 445, 117, 47);
		frmPetCashout.getContentPane().add(button);
		
		JButton button_1 = new JButton("CC");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateMedicalRecords();								
				PetCheckout_GUI.ClearTicket();
				frmPetCashout.dispose();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.setBounds(331, 445, 117, 47);
		frmPetCashout.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Check");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateMedicalRecords();								
				PetCheckout_GUI.ClearTicket();
				frmPetCashout.dispose();
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		button_2.setBounds(469, 445, 117, 47);
		frmPetCashout.getContentPane().add(button_2);
		
		JLabel label = new JLabel("Products");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(26, 41, 183, 25);
		frmPetCashout.getContentPane().add(label);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setVerticalAlignment(SwingConstants.BOTTOM);
		lblServices.setFont(new Font("Dialog", Font.BOLD, 20));
		lblServices.setBounds(430, 41, 183, 25);
		frmPetCashout.getContentPane().add(lblServices);
		
		JLabel label_2 = new JLabel("Total:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(82, 295, 70, 15);
		frmPetCashout.getContentPane().add(label_2);
		
		JTextPane ProductTotal = new JTextPane();
		ProductTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		ProductTotal.setText("0");
		ProductTotal.setBackground(Color.LIGHT_GRAY);
		ProductTotal.setBounds(170, 284, 117, 41);
		frmPetCashout.getContentPane().add(ProductTotal);
		
		JLabel label_3 = new JLabel("Total:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(492, 295, 70, 15);
		frmPetCashout.getContentPane().add(label_3);
		
		JTextPane ServiceTotal = new JTextPane();
		ServiceTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		ServiceTotal.setText("0");
		ServiceTotal.setBackground(Color.LIGHT_GRAY);
		ServiceTotal.setBounds(580, 284, 106, 41);
		frmPetCashout.getContentPane().add(ServiceTotal);
		
		JLabel lblGrandTotal = new JLabel("Grand Total:");
		lblGrandTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGrandTotal.setBounds(216, 384, 130, 15);
		frmPetCashout.getContentPane().add(lblGrandTotal);
		
		JTextPane GrandTotal = new JTextPane();
		GrandTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		GrandTotal.setText("0");
		GrandTotal.setBackground(Color.LIGHT_GRAY);
		GrandTotal.setBounds(364, 373, 84, 41);
		frmPetCashout.getContentPane().add(GrandTotal);
		
		JButton button_3 = new JButton("Back");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PetCheckout_GUI.run();
				frmPetCashout.dispose();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(10, 461, 117, 31);
		frmPetCashout.getContentPane().add(button_3);
		
		PopulateTickets();
		GetTotal();
		String tmp = new DecimalFormat("#.##").format(totalServices);
		String tmp2 = "$" + tmp;
		String tmp3 = new DecimalFormat("#.##").format(totalProducts);
		String tmp4 = "$" + tmp3;
		String tmp5 = new DecimalFormat("#.##").format(Grandtotal);
		String tmp6 = "$" + tmp5;
		
		ProductTotal.setText(tmp4);
		ServiceTotal.setText(tmp2);
		GrandTotal.setText(tmp6);
	
		
	}
	
	
	public static void PopulateTickets()
	{
	Connection.Connect();
	serviceListModel = new DefaultListModel<Tickets>();
	productListModel = new DefaultListModel<Tickets>();
	String commandText = "SELECT * from SingleSale";
	ResultSet rs = SQL.ExecuteResultSet(commandText);
	double price = 0;
	int id;
	int petID;
	int taxable;
	String name = "";
	try {
		while ((rs!=null) && (rs.next()))
		{
			id = rs.getInt("ID");
			price = rs.getDouble("Price");
			taxable = rs.getInt("Taxable");
			name = rs.getString("Service");
			
			if(taxable == 0) //service
			{
				Tickets tick = new Tickets(name,price);	
				serviceListModel.addElement(tick);			
				
			}
			else
			{
				Tickets tick = new Tickets(name,price);	
				productListModel.addElement(tick);
				
			}
		}
	}
	catch (SQLException e)
	{
	JOptionPane.showMessageDialog(null, e.toString());
	}
		
	listServices.setModel(serviceListModel);
	listProducts.setModel(productListModel);
	}
	
	public static void GetTotal()
	{
		String commandText = "SELECT * from SingleSale";
		ResultSet rs = SQL.ExecuteResultSet(commandText); 
		int taxable =0;
		double tmpprice = 0;
		
		totalServices = 0;
		totalProducts = 0;
		try {
			while ((rs!=null) && (rs.next()))
			{		
				
				tmpprice = rs.getDouble("price");
				taxable = rs.getInt("Taxable");
				
				if(taxable == 0) //service
				{
					totalServices = totalServices + tmpprice;
					
				}
				else
				{
					totalProducts = totalProducts + tmpprice;
				}
				
								
				
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
		totalProducts = totalProducts + (totalProducts *.075);
		Grandtotal = totalProducts + totalServices;
		
	}
	

	public void PopulateMedicalRecords()
	{
		String commandText = "SELECT * from SingleSale WHERE Taxable = 0 ORDER BY PetID asc";
		ResultSet rs = SQL.ExecuteResultSet(commandText); 
		String service;		 
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Date date2 = null;
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		
		int petid = 0;
		int itemid = 0;
		try {
			while ((rs!=null) && (rs.next()))
			{		
				service = rs.getString("Service");
				String delims = " :";
				String[] tokens = service.split(delims);
				String tmptoken = tokens[1].trim();
				itemid = rs.getInt("ID");
				petid = rs.getInt("PetID");
				
				
				String cmd = "INSERT INTO MedicalRecords (PetID,Service,Date,ItemID)" +
						"VALUES ('" + petid + "', '" +
						tmptoken + "', '" + date + "'," + "'" + itemid + "')";
						SQL.UpdateResultSet(cmd);	
								
				
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}
	
	
}
