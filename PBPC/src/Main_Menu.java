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

import javax.swing.UIManager.*;




public class Main_Menu {
	
	
	public static int OwnerID;
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
	
	
	public static void run() {
		try {
			
			Main_Menu window = new Main_Menu();
			window.frmMainMenu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				New_Client New_Client_GUI_Instance = new New_Client();
				New_Client_GUI_Instance.frmNewClient.setVisible(true);
			}
		});
		btnNewClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewClient.setBounds(412, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnNewClient);
		
		JButton btnExsistingClient = new JButton("Exsisting Client");
		btnExsistingClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Launch an instance of the Pet_Owner screen
				Pet_Owner_List Pet_Owner_List_Instance = new Pet_Owner_List();
				Pet_Owner_List_Instance.frmPetOwnerList.setVisible(true);
				
			}
		});
		btnExsistingClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExsistingClient.setBounds(163, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnExsistingClient);
		
		JButton btnProductSale = new JButton("Product Sale");
		btnProductSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				BoardingCalendar BoardingCalendar_Instance = new BoardingCalendar();
				BoardingCalendar_Instance.frmBoardingCalendar.setVisible(true);
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
			}
		});
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAppointments.setBounds(291, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnAppointments);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main_Menu.class.getResource("/General_Images/Logo.jpg")));
		lblNewLabel.setBounds(220, 26, 303, 136);
		frmMainMenu.getContentPane().add(lblNewLabel);
	}
}
