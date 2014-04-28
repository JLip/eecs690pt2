import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;


public class Checkout_Boarding {

	private JFrame frmCheckoutBoarding;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Checkout_Boarding window = new Checkout_Boarding();
					window.frmCheckoutBoarding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Checkout_Boarding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckoutBoarding = new JFrame();
		frmCheckoutBoarding.getContentPane().setBackground(Color.WHITE);
		frmCheckoutBoarding.setIconImage(Toolkit.getDefaultToolkit().getImage(Checkout_Boarding.class.getResource("/General_Images/GI_icon.png")));
		frmCheckoutBoarding.setBounds(100, 100, 351, 288);
		frmCheckoutBoarding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckoutBoarding.getContentPane().setLayout(null);
		
		JLabel Boarding = new JLabel("Boarding");
		Boarding.setFont(new Font("Tahoma", Font.BOLD, 15));
		Boarding.setBounds(130, 11, 82, 14);
		frmCheckoutBoarding.getContentPane().add(Boarding);
		
		JButton btnDailyRate = new JButton("Daily Rate");
		btnDailyRate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDailyRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tmp;
				tmp = JOptionPane.showInputDialog("# of Days");
				int days = Integer.parseInt(tmp);
				if(PetCheckout_GUI.Cat())
				{
					item_id = 20;
					
				}
				else
				{
					if(PetCheckout_GUI.animalSize.compareTo("Small") == 0)
					{
						item_id = 23;
					}
					else if(PetCheckout_GUI.animalSize.compareTo("Medium") == 0)
					{
						item_id = 40;
						
					}
					else 
					{
						item_id = 41;
					}
					
				}
				
				
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				item_price = item_price * days;
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);		
				frmCheckoutBoarding.dispose();
				
				
			}
		});
		btnDailyRate.setBounds(76, 49, 181, 31);
		frmCheckoutBoarding.getContentPane().add(btnDailyRate);
		
		JButton btnBathinggrooming = new JButton("Bathing/Grooming");
		btnBathinggrooming.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBathinggrooming.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 21;
					
				}
				else
				{
					item_id = 24;					
				}
				
				
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);				
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);		
				frmCheckoutBoarding.dispose();
			}
		});
		btnBathinggrooming.setBounds(76, 91, 181, 31);
		frmCheckoutBoarding.getContentPane().add(btnBathinggrooming);
		
		JButton btnNewButton = new JButton("Additional Play Time");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tmp;
				tmp = JOptionPane.showInputDialog("# of Days");
				int days = Integer.parseInt(tmp);
				if(PetCheckout_GUI.Cat())
				{
					item_id = 22;
					
				}
				else
				{
					item_id = 25;
					
				}				
				
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				item_price = item_price * days;
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);		
				frmCheckoutBoarding.dispose();
				
			}
		});
		btnNewButton.setBounds(76, 138, 181, 31);
		frmCheckoutBoarding.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmCheckoutBoarding.dispose();
			}
		});
		button.setBounds(123, 208, 89, 31);
		frmCheckoutBoarding.getContentPane().add(button);
	}
}
