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


public class DayDisplay {

	private JFrame frmDay;
	/**
	 * Launch the application.
	 */

			public static void run(dayItem instance) {
				try {
					DayDisplay window = new DayDisplay(instance);
					window.frmDay.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public DayDisplay(dayItem instance) {
		day = instance;
		initialize();
	}

	dayItem day;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDay = new JFrame();
		frmDay.setTitle("Feline Products");
		frmDay.setIconImage(Toolkit.getDefaultToolkit().getImage(FelineProducts.class.getResource("/General_Images/GI_icon.png")));
		frmDay.getContentPane().setBackground(Color.WHITE);
		frmDay.setBounds(100, 100, 450, 300);
		frmDay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDay.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmDay.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(172, 220, 89, 31);
		frmDay.getContentPane().add(button);
		
		JLabel lblKen11 = new JLabel("Kennel 11 : ");
		lblKen11.setBounds(10, 11, 59, 14);
		frmDay.getContentPane().add(lblKen11);
		
		JLabel lblKen12 = new JLabel("Kennel 12 : ");
		lblKen12.setBounds(10, 34, 59, 14);
		frmDay.getContentPane().add(lblKen12);
		
		JLabel lblKen13 = new JLabel("Kennel 13 : ");
		lblKen13.setBounds(10, 59, 59, 14);
		frmDay.getContentPane().add(lblKen13);
		
		JLabel lblKen14 = new JLabel("Kennel 14 : ");
		lblKen14.setBounds(10, 84, 59, 14);
		frmDay.getContentPane().add(lblKen14);
		
		JLabel lblKen15 = new JLabel("Kennel 15 : ");
		lblKen15.setBounds(10, 109, 59, 14);
		frmDay.getContentPane().add(lblKen15);
		
		JLabel lblKen16 = new JLabel("Kennel 16 : ");
		lblKen16.setBounds(10, 134, 59, 14);
		frmDay.getContentPane().add(lblKen16);
		
		JLabel lblPet11 = new JLabel(day.ken11);
		lblPet11.setBounds(79, 11, 127, 14);
		frmDay.getContentPane().add(lblPet11);
		
		JLabel lblPet12 = new JLabel(day.ken12);
		lblPet12.setBounds(79, 34, 127, 14);
		frmDay.getContentPane().add(lblPet12);
		
		JLabel lblPet13 = new JLabel(day.ken13);
		lblPet13.setBounds(79, 59, 127, 14);
		frmDay.getContentPane().add(lblPet13);
		
		JLabel lblPet14 = new JLabel(day.ken14);
		lblPet14.setBounds(79, 84, 127, 14);
		frmDay.getContentPane().add(lblPet14);
		
		JLabel lblPet15 = new JLabel(day.ken15);
		lblPet15.setBounds(79, 109, 127, 14);
		frmDay.getContentPane().add(lblPet15);
		
		JLabel lblPet16 = new JLabel(day.ken16);
		lblPet16.setBounds(79, 134, 127, 14);
		frmDay.getContentPane().add(lblPet16);
		
		JLabel lblKen21 = new JLabel("Kennel 21 : ");
		lblKen21.setBounds(228, 11, 59, 14);
		frmDay.getContentPane().add(lblKen21);
		
		JLabel lblKen22 = new JLabel("Kennel 22 : ");
		lblKen22.setBounds(228, 34, 59, 14);
		frmDay.getContentPane().add(lblKen22);
		
		JLabel lblKen23 = new JLabel("Kennel 23 : ");
		lblKen23.setBounds(228, 59, 59, 14);
		frmDay.getContentPane().add(lblKen23);
		
		JLabel lblKen24 = new JLabel("Kennel 24 : ");
		lblKen24.setBounds(228, 84, 59, 14);
		frmDay.getContentPane().add(lblKen24);
		
		JLabel lblKen25 = new JLabel("Kennel 25 : ");
		lblKen25.setBounds(228, 109, 59, 14);
		frmDay.getContentPane().add(lblKen25);
		
		JLabel lblKen26 = new JLabel("Kennel 26 : ");
		lblKen26.setBounds(228, 134, 59, 14);
		frmDay.getContentPane().add(lblKen26);
		
		JLabel lblKen27 = new JLabel("Kennel 27 : ");
		lblKen27.setBounds(228, 159, 59, 14);
		frmDay.getContentPane().add(lblKen27);
		
		JLabel lblKen28 = new JLabel("Kennel 28 : ");
		lblKen28.setBounds(228, 184, 59, 14);
		frmDay.getContentPane().add(lblKen28);
		
		JLabel lblPet21 = new JLabel(day.ken21);
		lblPet21.setBounds(297, 11, 127, 14);
		frmDay.getContentPane().add(lblPet21);
		
		JLabel lblPet22 = new JLabel(day.ken22);
		lblPet22.setBounds(297, 34, 127, 14);
		frmDay.getContentPane().add(lblPet22);
		
		JLabel lblPet23 = new JLabel(day.ken23);
		lblPet23.setBounds(297, 59, 127, 14);
		frmDay.getContentPane().add(lblPet23);
		
		JLabel lblPet24 = new JLabel(day.ken24);
		lblPet24.setBounds(297, 84, 127, 14);
		frmDay.getContentPane().add(lblPet24);
		
		JLabel lblPet25 = new JLabel(day.ken25);
		lblPet25.setBounds(297, 109, 127, 14);
		frmDay.getContentPane().add(lblPet25);
		
		JLabel lblPet26 = new JLabel(day.ken26);
		lblPet26.setBounds(297, 134, 127, 14);
		frmDay.getContentPane().add(lblPet26);
		
		JLabel lblPet27 = new JLabel(day.ken27);
		lblPet27.setBounds(297, 159, 127, 14);
		frmDay.getContentPane().add(lblPet27);
		
		JLabel lblPet28 = new JLabel(day.ken28);
		lblPet28.setBounds(297, 184, 127, 14);
		frmDay.getContentPane().add(lblPet28);
	}
}
