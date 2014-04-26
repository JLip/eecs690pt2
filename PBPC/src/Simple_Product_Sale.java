import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Toolkit;


public class Simple_Product_Sale {

	private JFrame frmSimpleSale;
	public static JList<Tickets> ticketList;
	public static DefaultListModel<Tickets> ticketListModel;
	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Simple_Product_Sale window = new Simple_Product_Sale();
					window.frmSimpleSale.setVisible(true);
					PopulateTicket();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Simple_Product_Sale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimpleSale = new JFrame();
		frmSimpleSale.setIconImage(Toolkit.getDefaultToolkit().getImage(Simple_Product_Sale.class.getResource("/General_Images/GI_icon.png")));
		frmSimpleSale.setTitle("Product Sale");
		frmSimpleSale.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		frmSimpleSale.getContentPane().setBackground(Color.WHITE);
		frmSimpleSale.setBounds(100, 100, 800, 600);
		frmSimpleSale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimpleSale.getContentPane().setLayout(null);
		PetCheckout_GUI.petCheckout = false;
		JButton btnMainMenu = new JButton("Return to Main Menu");
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Simple_Product_Sale.ClearTicket();
				}
				catch(Exception e1)
				{}
					frmSimpleSale.dispose();
			}
		});
		btnMainMenu.setBounds(34, 507, 232, 41);
		frmSimpleSale.getContentPane().add(btnMainMenu);
		
		JButton btnFelineProducts = new JButton("Feline Products");
		btnFelineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFelineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FelineProducts.run();
				//frmSimpleSale.dispose();
			}
			
		});
		btnFelineProducts.setBounds(464, 65, 186, 56);
		frmSimpleSale.getContentPane().add(btnFelineProducts);
		
		JButton btnCanineProducts = new JButton("Canine Products");
		btnCanineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCanineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CanineProducts.run();
			//	frmSimpleSale.dispose();
			}
		});
		btnCanineProducts.setBounds(464, 176, 186, 56);
		frmSimpleSale.getContentPane().add(btnCanineProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 71, 245, 239);
		frmSimpleSale.getContentPane().add(scrollPane);
		
		ticketList = new JList<Tickets>();
		ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ticketList);
		JLabel lblCurrentTicket = new JLabel("Current Ticket:");
		lblCurrentTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentTicket.setBounds(54, 15, 186, 45);
		frmSimpleSale.getContentPane().add(lblCurrentTicket);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveFromTicket();
			}
		});
		btnRemove.setBounds(100, 321, 89, 31);
		frmSimpleSale.getContentPane().add(btnRemove);
		
		JButton btnCashout = new JButton("Cashout");
		btnCashout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cashout_Screen.run();
				frmSimpleSale.dispose();
			}
		});
		btnCashout.setBounds(627, 513, 118, 41);
		frmSimpleSale.getContentPane().add(btnCashout);
	}
	
	
	public static void InsertItem(int item_id, String item_name, double item_price)
	{
	String commandText = "INSERT INTO SingleSale (ID,Service,Price)" +
	"VALUES ('" + item_id + "', '" +
	item_name + "', '" + item_price +
	"')";
	SQL.UpdateResultSet(commandText);
	PopulateTicket();

	}
	
	public static void PopulateTicket()
	{

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
	
	public static void RemoveFromTicket()
	{
		Connection.Connect();
		Tickets tmp = ticketList.getSelectedValue();
		String name = tmp.getitem();		
		String commandText = "DELETE FROM SingleSale WHERE SingleSale.Service = (SELECT Service FROM SingleSale WHERE Service = " + "'" + name + "' LIMIT 1)";
		SQL.UpdateResultSet(commandText);
		PopulateTicket();
	}
	
	
	public static void ClearTicket()
	{
		Connection.Connect();
		
		String commandText = "DELETE FROM SingleSale";
		SQL.UpdateResultSet(commandText);
		PopulateTicket();
	}
}
