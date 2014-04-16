import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class New_Appointment {

	private JFrame frmNewAppointment;

	/**
	 * Launch the application.
	 */

		public static void run() {
			try {
				New_Appointment window = new New_Appointment();
				window.frmNewAppointment.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



	/**
	 * Create the application.
	 */
	public New_Appointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAppointment = new JFrame();
		frmNewAppointment.setTitle("New Appointment");
		frmNewAppointment.setIconImage(Toolkit.getDefaultToolkit().getImage(New_Appointment.class.getResource("/General_Images/GI_icon.png")));
		frmNewAppointment.getContentPane().setBackground(Color.WHITE);
		frmNewAppointment.getContentPane().setLayout(null);
		
		JButton btnBackToAppointments = new JButton("Back to Appointments");
		btnBackToAppointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmNewAppointment.dispose();
			}
		});
		btnBackToAppointments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackToAppointments.setBounds(25, 510, 243, 41);
		frmNewAppointment.getContentPane().add(btnBackToAppointments);
		
		JButton btnLogAppointment = new JButton("Log Appointment");
		btnLogAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnLogAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogAppointment.setBounds(513, 510, 243, 41);
		frmNewAppointment.getContentPane().add(btnLogAppointment);
		frmNewAppointment.setBackground(Color.WHITE);
		frmNewAppointment.setBounds(100, 100, 800, 600);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
