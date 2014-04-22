import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;


public class Appointment_Main {

	private JFrame frmAppointmentMain;

	/**
	 * Launch the application.
	 */	
		public static void run() {
			try {
				Appointment_Main window = new Appointment_Main();
				window.frmAppointmentMain.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	/**
	 * Create the application.
	 */
	public Appointment_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppointmentMain = new JFrame();
		frmAppointmentMain.getContentPane().setBackground(Color.WHITE);
		frmAppointmentMain.getContentPane().setLayout(null);
		
		JButton button = new JButton("Return To Main Menu");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmAppointmentMain.dispose();
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(22, 510, 243, 41);
		frmAppointmentMain.getContentPane().add(button);
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMonday.setBounds(133, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTuesday.setBounds(227, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWednesday.setBounds(321, 32, 109, 26);
		frmAppointmentMain.getContentPane().add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThursday.setBounds(442, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFriday.setBounds(536, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblFriday);
		
		JLabel lblSatuday = new JLabel("Satuday");
		lblSatuday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSatuday.setBounds(630, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblSatuday);
		
		JLabel lblExam = new JLabel("Exam 1");
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExam.setBounds(25, 91, 82, 26);
		frmAppointmentMain.getContentPane().add(lblExam);
		
		JLabel lblExam_1 = new JLabel("Exam 2");
		lblExam_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExam_1.setBounds(22, 205, 82, 26);
		frmAppointmentMain.getContentPane().add(lblExam_1);
		
		JLabel lblOr = new JLabel("O.R.");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOr.setBounds(22, 324, 82, 26);
		frmAppointmentMain.getContentPane().add(lblOr);
		
		JButton btnNewAppointment = new JButton("New/Remove Appointment");
		btnNewAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				New_Appointment.run();
			}
		});
		btnNewAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewAppointment.setBounds(471, 510, 284, 41);
		frmAppointmentMain.getContentPane().add(btnNewAppointment);
		frmAppointmentMain.setTitle("Appointments");
		frmAppointmentMain.setBackground(Color.WHITE);
		frmAppointmentMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Appointment_Main.class.getResource("/General_Images/GI_icon.png")));
		frmAppointmentMain.setBounds(100, 100, 800, 600);
		frmAppointmentMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
