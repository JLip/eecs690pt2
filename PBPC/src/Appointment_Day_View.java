import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Appointment_Day_View {

	private JFrame frmDayView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment_Day_View window = new Appointment_Day_View();
					window.frmDayView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Appointment_Day_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDayView = new JFrame();
		frmDayView.getContentPane().setBackground(Color.WHITE);
		frmDayView.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back to Appointments");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmDayView.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(18, 510, 243, 41);
		frmDayView.getContentPane().add(button);
		frmDayView.setTitle("Day View");
		frmDayView.setIconImage(Toolkit.getDefaultToolkit().getImage(Appointment_Day_View.class.getResource("/General_Images/GI_icon.png")));
		frmDayView.setBounds(100, 100, 800, 600);
		frmDayView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
