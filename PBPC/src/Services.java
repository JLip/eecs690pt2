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
		frmServices.setTitle("Pet Services");
		frmServices.setIconImage(Toolkit.getDefaultToolkit().getImage(Services.class.getResource("/General_Images/GI_icon.png")));
		frmServices.getContentPane().setBackground(Color.WHITE);
		frmServices.setBounds(100, 100, 450, 321);
		frmServices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServices.getContentPane().setLayout(null);
		
		JButton btnOfficeVisit = new JButton("Office Visit");
		btnOfficeVisit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOfficeVisit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
				
					
					if(PetCheckout_GUI.animalSize.compareTo("Small") == 0)
					{
						item_id = 1;
					}
					else if(PetCheckout_GUI.animalSize.compareTo("Medium") == 0)
					{
						item_id = 42;
						
					}
					else 
					{
						item_id = 43;
					}
				}
				else
				{
					
					
					if(PetCheckout_GUI.animalSize.compareTo("Small") == 0)
					{
						item_id = 50;
					}
					else if(PetCheckout_GUI.animalSize.compareTo("Medium") == 0)
					{
						item_id = 44;
						
					}
					else 
					{
						item_id = 45;
					}
										
				}
				
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnOfficeVisit.setBounds(26, 45, 179, 31);
		frmServices.getContentPane().add(btnOfficeVisit);
		
		JButton btnSpayNeuter = new JButton("Spay/Neuter");
		btnSpayNeuter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSpayNeuter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 4;
					
				}
				else
				{
					item_id = 13;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmServices.dispose();
			}
		});
		
		btnSpayNeuter.setBounds(229, 45, 179, 31);
		frmServices.getContentPane().add(btnSpayNeuter);
		
		JButton btnMicroChipping = new JButton("Microchipping");
		btnMicroChipping.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMicroChipping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 2;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnMicroChipping.setBounds(26, 87, 179, 31);
		frmServices.getContentPane().add(btnMicroChipping);
		
		JButton btnLabWork = new JButton("Lab Work");
		btnLabWork.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLabWork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(PetCheckout_GUI.animalSize.compareTo("Small") == 0)
				{
					item_id = 5;
				}
				else if(PetCheckout_GUI.animalSize.compareTo("Medium") == 0)
				{
					item_id = 46;
					
				}
				else 
				{
					item_id = 47;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnLabWork.setBounds(229, 87, 179, 31);
		frmServices.getContentPane().add(btnLabWork);
		
		JButton btnHeartworm = new JButton("Heartworm Testing");
		btnHeartworm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHeartworm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 3;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				
				frmServices.dispose();
			}
		});
		btnHeartworm.setBounds(26, 129, 179, 31);
		frmServices.getContentPane().add(btnHeartworm);
		
		JButton btnDentalCleaning = new JButton("Dental Cleaning");
		btnDentalCleaning.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDentalCleaning.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(PetCheckout_GUI.Cat())
				{
					item_id = 6;
					
				}
				else
				{
					item_id = 15;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmServices.dispose();
			}
		});
		btnDentalCleaning.setBounds(229, 129, 179, 31);
		frmServices.getContentPane().add(btnDentalCleaning);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServices.setBounds(183, 11, 74, 14);
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
		btnXray.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 7;
					
				}
				else
				{
					item_id = 16;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmServices.dispose();
				
			}
		});
		btnXray.setBounds(26, 171, 179, 31);
		frmServices.getContentPane().add(btnXray);
	}
	
	
	
}
