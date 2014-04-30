import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;







import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.UIManager.*;




public class Main_Menu {
	
	
	public static int OwnerID;
	public static int PetID;
	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection.Connect();
					Main_Menu window = new Main_Menu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Main_Menu() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setBackground(Color.WHITE);
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Menu.class.getResource("/General_Images/GI_icon.png")));
		frmMainMenu.setBounds(100, 100, 800, 600);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JButton btnNewClient = new JButton("New Client");
		btnNewClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Launch an instance of new client screen
				New_Client.run();
				
			}
		});
		btnNewClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewClient.setBounds(431, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnNewClient);
		
		JButton btnExsistingClient = new JButton("Exsisting Client");
		btnExsistingClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Launch an instance of the Pet_Owner screen
				Pet_Owner_List.run();
				
				
			}
		});
		btnExsistingClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExsistingClient.setBounds(163, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnExsistingClient);
		
		JButton btnProductSale = new JButton("Product Sale");
		btnProductSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
				Simple_Product_Sale.ClearTicket();
				}
				catch(Exception e1)
				{}				
				Simple_Product_Sale.run();
				
			}
		});
		btnProductSale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProductSale.setBounds(54, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnProductSale);
		
		JButton btnBoarderCalender = new JButton("Boarder Calender");
		btnBoarderCalender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				
				//Launch an instance of the boarding calendar screen
				BoardingCalendar.run();
				
			}
		});
		btnBoarderCalender.setText("<html><center>"+"Boarder"+"<br>"+"Calender"+"</center></html>");
		btnBoarderCalender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBoarderCalender.setBounds(525, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnBoarderCalender);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Appointment_Main.run();
			}
		});
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAppointments.setBounds(291, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnAppointments);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main_Menu.class.getResource("/General_Images/Logo.jpg")));
		lblNewLabel.setBounds(237, 25, 303, 136);
		frmMainMenu.getContentPane().add(lblNewLabel);
		
		
	}
}
