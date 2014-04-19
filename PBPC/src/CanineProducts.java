import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		frmCanineProducts.setBounds(100, 100, 450, 300);
		frmCanineProducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCanineProducts.getContentPane().setLayout(null);
		
		JButton btnHeartwormSmallMed = new JButton("Heartworm (Sm/Med)");
		btnHeartwormSmallMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 32;
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);		
				Simple_Product_Sale.InsertItem(item_id, item_name, item_price);
				
				frmCanineProducts.dispose();
			}
		});
		btnHeartwormSmallMed.setBounds(63, 39, 153, 23);
		frmCanineProducts.getContentPane().add(btnHeartwormSmallMed);
		
		JButton btnHeartwormLarge = new JButton("Heartworm (Large)");
		btnHeartwormLarge.setBounds(63, 73, 153, 23);
		frmCanineProducts.getContentPane().add(btnHeartwormLarge);
		
		JButton btnFleatickPrevention = new JButton("Flea/Tick Prevention");
		btnFleatickPrevention.setBounds(59, 107, 157, 23);
		frmCanineProducts.getContentPane().add(btnFleatickPrevention);
		
		JButton btnPuppyFoodsmall = new JButton("Puppy Food (small)");
		btnPuppyFoodsmall.setBounds(63, 140, 153, 23);
		frmCanineProducts.getContentPane().add(btnPuppyFoodsmall);
		
		JButton btnPuppyFoodmedlarge = new JButton("Puppy Food (Med/Large)");
		btnPuppyFoodmedlarge.setBounds(59, 173, 157, 23);
		frmCanineProducts.getContentPane().add(btnPuppyFoodmedlarge);
		
		JButton btnAdultDogFood = new JButton("Adult Dog Food ");
		btnAdultDogFood.setBounds(59, 207, 157, 23);
		frmCanineProducts.getContentPane().add(btnAdultDogFood);
		
		JButton btnReducedFatAdult = new JButton("Reduced Fat Adult Dog Food");
		btnReducedFatAdult.setBounds(233, 107, 179, 23);
		frmCanineProducts.getContentPane().add(btnReducedFatAdult);
		
		JButton btnSeniorAdultDog = new JButton("Senior Adult Dog Food ");
		btnSeniorAdultDog.setBounds(231, 140, 181, 23);
		frmCanineProducts.getContentPane().add(btnSeniorAdultDog);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(179, 241, 89, 23);
		frmCanineProducts.getContentPane().add(btnBack);
		
		JLabel lblCanineProducts = new JLabel("Canine Products");
		lblCanineProducts.setBounds(185, 14, 100, 14);
		frmCanineProducts.getContentPane().add(lblCanineProducts);
	}

}
