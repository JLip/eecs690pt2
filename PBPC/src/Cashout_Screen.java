import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class Cashout_Screen {

	JFrame frmCashoutTable;
	public static DefaultListModel<Tickets> ticketListModel2;	
	public static double total;

	/**
	 * Launch the application.
	 */
	
			public static void run() {
				try {
					Cashout_Screen window = new Cashout_Screen();
					window.frmCashoutTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Cashout_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashoutTable = new JFrame();
		frmCashoutTable.setIconImage(Toolkit.getDefaultToolkit().getImage(Cashout_Screen.class.getResource("/General_images/GI_icon.png")));
		frmCashoutTable.getContentPane().setBackground(Color.WHITE);
		frmCashoutTable.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Exit cashout screen without closing ticket
				Simple_Product_Sale.run();
				frmCashoutTable.dispose();
				
			}
		});
		btnBack.setBounds(136, 0, 117, 25);
		frmCashoutTable.getContentPane().add(btnBack);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTicket.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTicket.setBounds(59, 47, 70, 25);
		frmCashoutTable.getContentPane().add(lblTicket);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(181, 290, 144, 41);
		frmCashoutTable.getContentPane().add(textPane_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal.setBounds(93, 301, 70, 15);
		frmCashoutTable.getContentPane().add(lblTotal);
		
		JButton btnCash = new JButton("Cash");
		btnCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				RemoveFromDatabase();
				//Simple_Product_Sale.run();
				frmCashoutTable.dispose();
			}
		});
		btnCash.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCash.setBounds(10, 409, 117, 47);
		frmCashoutTable.getContentPane().add(btnCash);
		
		JButton btnCc = new JButton("CC");
		btnCc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RemoveFromDatabase();
				//Simple_Product_Sale.run();
				frmCashoutTable.dispose();
			}
		});
		btnCc.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCc.setBounds(136, 409, 117, 47);
		frmCashoutTable.getContentPane().add(btnCc);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RemoveFromDatabase();
				//Simple_Product_Sale.run();
				frmCashoutTable.dispose();
			}
		});
		btnCheck.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCheck.setBounds(260, 409, 117, 47);
		frmCashoutTable.getContentPane().add(btnCheck);
		
		JButton btnDiscount = new JButton("Discount");
		btnDiscount.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDiscount.setBounds(46, 494, 294, 47);
		frmCashoutTable.getContentPane().add(btnDiscount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 83, 294, 196);
		frmCashoutTable.getContentPane().add(scrollPane);
		
		JList<Tickets> list = new JList<Tickets>();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setModel(Simple_Product_Sale.ticketListModel);
		
		
		frmCashoutTable.setTitle("Cashout Table");
		frmCashoutTable.setBounds(100, 100, 431, 600);
		frmCashoutTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GetTotal();
		String tmp = new DecimalFormat("#.##").format(total);
		//String tmp = String.valueOf(total2);
		textPane_1.setText(tmp);
		
	
	}
	
	public static void GetTotal()
	{
		String commandText = "SELECT * from SingleSale";
		ResultSet rs = SQL.ExecuteResultSet(commandText); 
		double tmpprice = 0;
		total = 0;
		try {
			while ((rs!=null) && (rs.next()))
			{			
				
				tmpprice = rs.getDouble("price");
				total = tmpprice + total;
				
				
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
		total = total + (total *.075);
		
	}
	
	



public static void RemoveFromDatabase()
{
	Simple_Product_Sale.ClearTicket();
	
	
}

}


