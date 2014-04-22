import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Services {

	private JFrame frmServices;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	
	
	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Services window = new Services();
					window.frmServices.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Services() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServices = new JFrame();
		frmServices.setTitle("Feline Products");
		frmServices.setIconImage(Toolkit.getDefaultToolkit().getImage(Services.class.getResource("/General_Images/GI_icon.png")));
		frmServices.getContentPane().setBackground(Color.WHITE);
		frmServices.setBounds(100, 100, 450, 321);
		frmServices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServices.getContentPane().setLayout(null);
		
		JButton btnOfficeVisit = new JButton("Office Visit");
		btnOfficeVisit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOfficeVisit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 1;
				
				if(PetCheckout_GUI.animalSize.compareTo("Small") == 0)
				{
					item_price = 25;
				}
				else if(PetCheckout_GUI.animalSize.compareTo("Medium") == 0)
				{
					item_price = 35;
					
				}
				else 
				{
					item_price = 45;
				}
				
				//item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnOfficeVisit.setBounds(26, 45, 179, 31);
		frmServices.getContentPane().add(btnOfficeVisit);
		
		JButton btnSpayNeuter = new JButton("Spay/Neuter");
		btnSpayNeuter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSpayNeuter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 27;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnSpayNeuter.setBounds(229, 45, 179, 31);
		frmServices.getContentPane().add(btnSpayNeuter);
		
		JButton btnMicroChipping = new JButton("Microchipping");
		btnMicroChipping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 28;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnMicroChipping.setBounds(26, 87, 179, 31);
		frmServices.getContentPane().add(btnMicroChipping);
		
		JButton btnLabWork = new JButton("Lab Work");
		btnLabWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLabWork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 29;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnLabWork.setBounds(229, 87, 179, 31);
		frmServices.getContentPane().add(btnLabWork);
		
		JButton btnHeartworm = new JButton("Heartworm Testing");
		btnHeartworm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 30;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnHeartworm.setBounds(26, 140, 179, 31);
		frmServices.getContentPane().add(btnHeartworm);
		
		JButton btnDentalCleaning = new JButton("Dental Cleaning");
		btnDentalCleaning.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 31;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnDentalCleaning.setBounds(229, 140, 179, 31);
		frmServices.getContentPane().add(btnDentalCleaning);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServices.setBounds(152, 11, 128, 14);
		frmServices.getContentPane().add(lblServices);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmServices.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(168, 241, 89, 31);
		frmServices.getContentPane().add(button);
		
		JButton btnXray = new JButton("X-Ray");
		btnXray.setBounds(26, 184, 179, 31);
		frmServices.getContentPane().add(btnXray);
	}
}
