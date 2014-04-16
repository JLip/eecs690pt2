import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class New_Appointment {

	private JFrame frmNewAppointment;
	private JTextField timefld;

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
		
		
		JDateChooser AppointmentDate = new JDateChooser();
		AppointmentDate.setToolTipText("Appointment Date");
		AppointmentDate.setBounds(189, 27, 130, 33);
		frmNewAppointment.getContentPane().add(AppointmentDate);
		AppointmentDate.setLocale(Locale.US);
		
		
		
		JButton btnLogAppointment = new JButton("Log Appointment");
		btnLogAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnLogAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogAppointment.setBounds(513, 510, 243, 41);
		frmNewAppointment.getContentPane().add(btnLogAppointment);
		
		JLabel lblNewLabel = new JLabel("Appointment Date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 27, 154, 33);
		frmNewAppointment.getContentPane().add(lblNewLabel);
		
		JLabel lblAppointmentTime = new JLabel("Appointment Time:");
		lblAppointmentTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppointmentTime.setBounds(340, 27, 154, 33);
		frmNewAppointment.getContentPane().add(lblAppointmentTime);
		
		timefld = new JTextField();
		timefld.setBounds(492, 27, 124, 33);
		frmNewAppointment.getContentPane().add(timefld);
		timefld.setColumns(10);
		frmNewAppointment.setBackground(Color.WHITE);
		frmNewAppointment.setBounds(100, 100, 800, 600);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
