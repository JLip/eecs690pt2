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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;


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
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(150, 520, 117, 31);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Exit cashout screen without closing ticket
				Simple_Product_Sale.run();
				frmCashoutTable.dispose();
				
			}
		});
		frmCashoutTable.getContentPane().setLayout(null);
		frmCashoutTable.getContentPane().add(btnBack);
		
		JLabel lblTicket = new JLabel("Products");
		lblTicket.setBounds(59, 47, 183, 25);
		lblTicket.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTicket.setVerticalAlignment(SwingConstants.BOTTOM);
		frmCashoutTable.getContentPane().add(lblTicket);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Dialog", Font.BOLD, 20));
		textPane_1.setEditable(false);
		textPane_1.setBounds(173, 291, 86, 25);
		textPane_1.setBackground(Color.LIGHT_GRAY);
		frmCashoutTable.getContentPane().add(textPane_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(93, 301, 70, 15);
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		frmCashoutTable.getContentPane().add(lblTotal);
		
		JButton btnCash = new JButton("Cash");
		btnCash.setBounds(10, 409, 117, 47);
		btnCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				RemoveFromDatabase();				
				frmCashoutTable.dispose();
			}
		});
		btnCash.setFont(new Font("Dialog", Font.BOLD, 20));
		frmCashoutTable.getContentPane().add(btnCash);
		
		JButton btnCc = new JButton("CC");
		btnCc.setBounds(150, 409, 117, 47);
		btnCc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RemoveFromDatabase();
				
				frmCashoutTable.dispose();
			}
		});
		btnCc.setFont(new Font("Dialog", Font.BOLD, 20));
		frmCashoutTable.getContentPane().add(btnCc);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheck.setBounds(288, 409, 117, 47);
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RemoveFromDatabase();
				
				frmCashoutTable.dispose();
			}
		});
		btnCheck.setFont(new Font("Dialog", Font.BOLD, 20));
		frmCashoutTable.getContentPane().add(btnCheck);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 83, 294, 196);
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
		String tmp2 = "$" + tmp;
		textPane_1.setText(tmp2);
		
	
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


