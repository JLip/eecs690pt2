import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;


public class Immunizations {

	private JFrame frmImmunizations;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Immunizations window = new Immunizations();
					window.frmImmunizations.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}		
	}

	/**
	 * Create the application.
	 */
	public Immunizations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImmunizations = new JFrame();
		frmImmunizations.setIconImage(Toolkit.getDefaultToolkit().getImage(Immunizations.class.getResource("/General_Images/GI_icon.png")));
		frmImmunizations.getContentPane().setBackground(Color.WHITE);
		frmImmunizations.setTitle("Immunizations");
		frmImmunizations.setBounds(100, 100, 311, 277);
		frmImmunizations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImmunizations.getContentPane().setLayout(null);
		
		JLabel lblImmunizations = new JLabel("Immunizations");
		lblImmunizations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImmunizations.setBounds(94, 11, 119, 14);
		frmImmunizations.getContentPane().add(lblImmunizations);
		
		JButton btnRabies = new JButton("Rabies");
		btnRabies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 8;
					
				}
				else
				{
					item_id = 17;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmImmunizations.dispose();
			}
		});
		btnRabies.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRabies.setBounds(57, 52, 179, 31);
		frmImmunizations.getContentPane().add(btnRabies);
		
		JButton btnDistemper = new JButton("Distemper");
		btnDistemper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 9;
					
				}
				else
				{
					item_id = 18;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmImmunizations.dispose();
			}
		});
		btnDistemper.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDistemper.setBounds(57, 99, 179, 31);
		frmImmunizations.getContentPane().add(btnDistemper);
		
		JButton btnBordatella = new JButton("Bordetella");
		btnBordatella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PetCheckout_GUI.Cat())
				{
					item_id = 10;
					
				}
				else
				{
					item_id = 19;
				}
				item_price = Query.PriceQuery(item_id);
				item_name = Query.ItemQuery(item_id);
				PetCheckout_GUI.InsertServiceToTicket(item_id, item_name, item_price);				
				frmImmunizations.dispose();
				
			}
		});
		btnBordatella.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBordatella.setBounds(57, 152, 179, 31);
		frmImmunizations.getContentPane().add(btnBordatella);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmImmunizations.dispose();
			}
		});
		btnBack.setBounds(105, 197, 89, 31);
		frmImmunizations.getContentPane().add(btnBack);
	}
}
