import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		frmFelineProducts.setBounds(100, 100, 450, 300);
		frmFelineProducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFelineProducts.getContentPane().setLayout(null);
		
		JButton btnHeartwormPrevention = new JButton("Heartworm Prevention");
		btnHeartwormPrevention.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 26;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnHeartwormPrevention.setBounds(72, 45, 152, 23);
		frmFelineProducts.getContentPane().add(btnHeartwormPrevention);
		
		JButton btnFleatickPrevention = new JButton("Flea/Tick Prevention");
		btnFleatickPrevention.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 27;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnFleatickPrevention.setBounds(72, 79, 152, 23);
		frmFelineProducts.getContentPane().add(btnFleatickPrevention);
		
		JButton btnKittenFood = new JButton("Kitten Food ");
		btnKittenFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 28;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnKittenFood.setBounds(72, 113, 152, 23);
		frmFelineProducts.getContentPane().add(btnKittenFood);
		
		JButton btnAdultCatFood = new JButton("Adult Cat Food");
		btnAdultCatFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 29;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnAdultCatFood.setBounds(72, 147, 152, 23);
		frmFelineProducts.getContentPane().add(btnAdultCatFood);
		
		JButton btnReducedFatAdult = new JButton("Reduced Fat Adult Cat Food");
		btnReducedFatAdult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 30;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnReducedFatAdult.setBounds(72, 181, 179, 23);
		frmFelineProducts.getContentPane().add(btnReducedFatAdult);
		
		JButton btnSeniorAdultCat = new JButton("Senior Adult Cat Food");
		btnSeniorAdultCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 31;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmFelineProducts.dispose();
			}
		});
		btnSeniorAdultCat.setBounds(72, 215, 179, 23);
		frmFelineProducts.getContentPane().add(btnSeniorAdultCat);
		
		JLabel lblFelineProducts = new JLabel("Feline Products");
		lblFelineProducts.setBounds(178, 11, 128, 14);
		frmFelineProducts.getContentPane().add(lblFelineProducts);
	}

}
