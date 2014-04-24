import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CanineProducts {

	private JFrame frmCanineProducts;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					CanineProducts window = new CanineProducts();
					window.frmCanineProducts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public CanineProducts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCanineProducts = new JFrame();
		frmCanineProducts.setTitle("Canine Products");
		frmCanineProducts.setIconImage(Toolkit.getDefaultToolkit().getImage(CanineProducts.class.getResource("/General_Images/GI_icon.png")));
		frmCanineProducts.getContentPane().setBackground(Color.WHITE);
		frmCanineProducts.setBounds(100, 100, 450, 300);
		frmCanineProducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCanineProducts.getContentPane().setLayout(null);
		
		JButton btnHeartwormSmallMed = new JButton("Heartworm (Sm/Med)");
		btnHeartwormSmallMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHeartwormSmallMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 32;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnHeartwormSmallMed.setBounds(20, 38, 179, 31);
		frmCanineProducts.getContentPane().add(btnHeartwormSmallMed);
		
		JButton btnHeartwormLarge = new JButton("Heartworm (Large)");
		btnHeartwormLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHeartwormLarge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				item_id = 33;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnHeartwormLarge.setBounds(233, 38, 179, 31);
		frmCanineProducts.getContentPane().add(btnHeartwormLarge);
		
		JButton btnFleatickPrevention = new JButton("Flea/Tick Prevention");
		btnFleatickPrevention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFleatickPrevention.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				item_id = 34;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnFleatickPrevention.setBounds(20, 80, 179, 31);
		frmCanineProducts.getContentPane().add(btnFleatickPrevention);
		
		JButton btnPuppyFoodsmall = new JButton("Puppy Food (small)");
		btnPuppyFoodsmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPuppyFoodsmall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 35;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnPuppyFoodsmall.setBounds(20, 122, 179, 31);
		frmCanineProducts.getContentPane().add(btnPuppyFoodsmall);
		
		JButton btnPuppyFoodmedlarge = new JButton("Puppy Food (Med/Large)");
		btnPuppyFoodmedlarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPuppyFoodmedlarge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 36;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnPuppyFoodmedlarge.setBounds(233, 122, 179, 31);
		frmCanineProducts.getContentPane().add(btnPuppyFoodmedlarge);
		
		JButton btnAdultDogFood = new JButton("Adult Dog Food ");
		btnAdultDogFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 37;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnAdultDogFood.setBounds(233, 80, 179, 31);
		frmCanineProducts.getContentPane().add(btnAdultDogFood);
		
		JButton btnReducedFatAdult = new JButton("Reduced Fat Adult Dog Food");
		btnReducedFatAdult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 38;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnReducedFatAdult.setBounds(233, 164, 179, 31);
		frmCanineProducts.getContentPane().add(btnReducedFatAdult);
		
		JButton btnSeniorAdultDog = new JButton("Senior Adult Dog Food ");
		btnSeniorAdultDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeniorAdultDog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 39;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				if(PetCheckout_GUI.petCheckout)
				{					
					PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);
				}
				else
				{
					Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				}
				
				frmCanineProducts.dispose();
			}
		});
		btnSeniorAdultDog.setBounds(20, 164, 179, 31);
		frmCanineProducts.getContentPane().add(btnSeniorAdultDog);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCanineProducts.dispose();
			}
		});
		btnBack.setBounds(171, 220, 89, 31);
		frmCanineProducts.getContentPane().add(btnBack);
		
		JLabel lblCanineProducts = new JLabel("Canine Products");
		lblCanineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCanineProducts.setBounds(148, 14, 131, 13);
		frmCanineProducts.getContentPane().add(lblCanineProducts);
	}

}
