import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;


public class FelineProducts {

	private JFrame frmFelineProducts;

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
		btnHeartwormPrevention.setBounds(72, 45, 152, 23);
		frmFelineProducts.getContentPane().add(btnHeartwormPrevention);
		
		JButton btnFleatickPrevention = new JButton("Flea/Tick Prevention");
		btnFleatickPrevention.setBounds(72, 79, 152, 23);
		frmFelineProducts.getContentPane().add(btnFleatickPrevention);
		
		JButton btnKittenFood = new JButton("Kitten Food ");
		btnKittenFood.setBounds(72, 113, 152, 23);
		frmFelineProducts.getContentPane().add(btnKittenFood);
		
		JButton btnAdultCatFood = new JButton("Adult Cat Food");
		btnAdultCatFood.setBounds(72, 147, 152, 23);
		frmFelineProducts.getContentPane().add(btnAdultCatFood);
		
		JButton btnReducedFatAdult = new JButton("Reduced Fat Adult Cat Food");
		btnReducedFatAdult.setBounds(72, 181, 179, 23);
		frmFelineProducts.getContentPane().add(btnReducedFatAdult);
		
		JButton btnSeniorAdultCat = new JButton("Senior Adult Cat Food");
		btnSeniorAdultCat.setBounds(72, 215, 179, 23);
		frmFelineProducts.getContentPane().add(btnSeniorAdultCat);
		
		JLabel lblFelineProducts = new JLabel("Feline Products");
		lblFelineProducts.setBounds(178, 11, 128, 14);
		frmFelineProducts.getContentPane().add(lblFelineProducts);
	}

}
