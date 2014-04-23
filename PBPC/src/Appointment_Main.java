import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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
		lblMonday.setBounds(127, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTuesday.setBounds(235, 33, 82, 26);
		frmAppointmentMain.getContentPane().add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWednesday.setBounds(326, 32, 109, 26);
		frmAppointmentMain.getContentPane().add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThursday.setBounds(448, 32, 82, 26);
		frmAppointmentMain.getContentPane().add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFriday.setBounds(561, 31, 82, 26);
		frmAppointmentMain.getContentPane().add(lblFriday);
		
		JLabel lblSatuday = new JLabel("Satuday");
		lblSatuday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSatuday.setBounds(663, 32, 82, 26);
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
		
		JTextArea textMon1 = new JTextArea();
		textMon1.setBackground(Color.LIGHT_GRAY);
		textMon1.setBounds(117, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon1);
		
		JTextArea textTue1 = new JTextArea();
		textTue1.setBackground(Color.LIGHT_GRAY);
		textTue1.setBounds(227, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue1);
		
		JTextArea textWed1 = new JTextArea();
		textWed1.setBackground(Color.LIGHT_GRAY);
		textWed1.setBounds(331, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed1);
		
		JTextArea textThu1 = new JTextArea();
		textThu1.setBackground(Color.LIGHT_GRAY);
		textThu1.setBounds(442, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu1);
		
		JTextArea textFri1 = new JTextArea();
		textFri1.setBackground(Color.LIGHT_GRAY);
		textFri1.setBounds(546, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri1);
		
		JTextArea textSat1 = new JTextArea();
		textSat1.setBackground(Color.LIGHT_GRAY);
		textSat1.setBounds(652, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat1);
		
		JTextArea textMon2 = new JTextArea();
		textMon2.setBackground(Color.LIGHT_GRAY);
		textMon2.setBounds(117, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon2);
		
		JTextArea textTue2 = new JTextArea();
		textTue2.setBackground(Color.LIGHT_GRAY);
		textTue2.setBounds(227, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue2);
		
		JTextArea textWed2 = new JTextArea();
		textWed2.setBackground(Color.LIGHT_GRAY);
		textWed2.setBounds(331, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed2);
		
		JTextArea textThu2 = new JTextArea();
		textThu2.setBackground(Color.LIGHT_GRAY);
		textThu2.setBounds(442, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu2);
		
		JTextArea textFri2 = new JTextArea();
		textFri2.setBackground(Color.LIGHT_GRAY);
		textFri2.setBounds(546, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri2);
		
		JTextArea textSat2 = new JTextArea();
		textSat2.setBackground(Color.LIGHT_GRAY);
		textSat2.setBounds(652, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat2);
		
		JTextArea textMon3 = new JTextArea();
		textMon3.setBackground(Color.LIGHT_GRAY);
		textMon3.setBounds(117, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon3);
		
		JTextArea textTue3 = new JTextArea();
		textTue3.setBackground(Color.LIGHT_GRAY);
		textTue3.setBounds(227, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue3);
		
		JTextArea textWed3 = new JTextArea();
		textWed3.setBackground(Color.LIGHT_GRAY);
		textWed3.setBounds(331, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed3);
		
		JTextArea textThu3 = new JTextArea();
		textThu3.setBackground(Color.LIGHT_GRAY);
		textThu3.setBounds(442, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu3);
		
		JTextArea textFri3 = new JTextArea();
		textFri3.setBackground(Color.LIGHT_GRAY);
		textFri3.setBounds(546, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri3);
		
		JTextArea textSat3 = new JTextArea();
		textSat3.setBackground(Color.LIGHT_GRAY);
		textSat3.setBounds(652, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat3);
		
		JButton btnViewMon = new JButton("View Day");
		btnViewMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getDayView(1);
			}


		});
		btnViewMon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewMon.setBounds(115, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewMon);
		
		JButton btnViewTue = new JButton("View Day");
		btnViewTue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getDayView(2);
			}
		});
		btnViewTue.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewTue.setBounds(227, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewTue);
		
		JButton btnViewWed = new JButton("View Day");
		btnViewWed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getDayView(3);
			}
		});
		btnViewWed.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewWed.setBounds(334, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewWed);
		
		JButton btnViewThu = new JButton("View Day");
		btnViewThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getDayView(4);
			}
		});
		btnViewThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewThu.setBounds(442, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewThu);
		
		JButton btnViewFri = new JButton("View Day");
		btnViewFri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getDayView(5);
			}
		});
		btnViewFri.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewFri.setBounds(544, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewFri);
		
		JButton btnViewSat = new JButton("View Day");
		btnViewSat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getDayView(6);
			}
		});
		btnViewSat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewSat.setBounds(652, 400, 89, 31);
		frmAppointmentMain.getContentPane().add(btnViewSat);
		frmAppointmentMain.setTitle("Appointments");
		frmAppointmentMain.setBackground(Color.WHITE);
		frmAppointmentMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Appointment_Main.class.getResource("/General_Images/GI_icon.png")));
		frmAppointmentMain.setBounds(100, 100, 800, 600);
		frmAppointmentMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	protected void getDayView(int i) {
		// TODO Auto-generated method stub
		//Based on th day being passed in
		//1 == mon, 2 == tues, etc
		//Generate a view from the appointment_Day_View screen of that day's appointments
		
	}
}
