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


public class FelineProducts {

	private JFrame frmFelineProducts;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	
	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					FelineProducts window = new FelineProducts();
					window.frmFelineProducts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public FelineProducts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFelineProducts = new JFrame();
		frmFelineProducts.setTitle("Feline Products");
		frmFelineProducts.setIconImage(Toolkit.getDefaultToolkit().getImage(FelineProducts.class.getResource("/General_Images/GI_icon.png")));
		frmFelineProducts.getContentPane().setBackground(Color.WHITE);
		frmFelineProducts.setBounds(100, 100, 450, 300);
		frmFelineProducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFelineProducts.getContentPane().setLayout(null);
		
		JButton btnHeartwormPrevention = new JButton("Heartworm Prevention");
		btnHeartwormPrevention.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHeartwormPrevention.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 26;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnHeartwormPrevention.setBounds(26, 45, 179, 31);
		frmFelineProducts.getContentPane().add(btnHeartwormPrevention);
		
		JButton btnFleatickPrevention = new JButton("Flea/Tick Prevention");
		btnFleatickPrevention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFleatickPrevention.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 27;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnFleatickPrevention.setBounds(229, 45, 179, 31);
		frmFelineProducts.getContentPane().add(btnFleatickPrevention);
		
		JButton btnKittenFood = new JButton("Kitten Food ");
		btnKittenFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 28;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnKittenFood.setBounds(26, 87, 179, 31);
		frmFelineProducts.getContentPane().add(btnKittenFood);
		
		JButton btnAdultCatFood = new JButton("Adult Cat Food");
		btnAdultCatFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdultCatFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 29;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnAdultCatFood.setBounds(229, 87, 179, 31);
		frmFelineProducts.getContentPane().add(btnAdultCatFood);
		
		JButton btnReducedFatAdult = new JButton("Reduced Fat Adult Cat Food");
		btnReducedFatAdult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 30;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnReducedFatAdult.setBounds(26, 140, 179, 31);
		frmFelineProducts.getContentPane().add(btnReducedFatAdult);
		
		JButton btnSeniorAdultCat = new JButton("Senior Adult Cat Food");
		btnSeniorAdultCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 31;
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
				
				frmFelineProducts.dispose();
			}
		});
		btnSeniorAdultCat.setBounds(229, 140, 179, 31);
		frmFelineProducts.getContentPane().add(btnSeniorAdultCat);
		
		JLabel lblFelineProducts = new JLabel("Feline Products");
		lblFelineProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFelineProducts.setBounds(152, 11, 128, 14);
		frmFelineProducts.getContentPane().add(lblFelineProducts);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmFelineProducts.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(172, 220, 89, 31);
		frmFelineProducts.getContentPane().add(button);
	}
}
