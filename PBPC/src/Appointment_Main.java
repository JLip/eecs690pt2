import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Appointment_Main {

	
	JTextArea currentDateField;
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
		textMon1.setText("Set: 25 \r\nOpen: 15");
		textMon1.setEditable(false);
		textMon1.setBackground(Color.LIGHT_GRAY);
		textMon1.setBounds(117, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon1);
		
		JTextArea textTue1 = new JTextArea();
		textTue1.setText("Set: 5\r\nOpen: 35");
		textTue1.setEditable(false);
		textTue1.setBackground(Color.LIGHT_GRAY);
		textTue1.setBounds(227, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue1);
		
		JTextArea textWed1 = new JTextArea();
		textWed1.setText("Set: 35 \r\nOpen: 5");
		textWed1.setEditable(false);
		textWed1.setBackground(Color.LIGHT_GRAY);
		textWed1.setBounds(331, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed1);
		
		JTextArea textThu1 = new JTextArea();
		textThu1.setText("Set: 12\r\nOpen: 28");
		textThu1.setEditable(false);
		textThu1.setBackground(Color.LIGHT_GRAY);
		textThu1.setBounds(442, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu1);
		
		JTextArea textFri1 = new JTextArea();
		textFri1.setText("Set: 18\r\nOpen: 22");
		textFri1.setEditable(false);
		textFri1.setBackground(Color.LIGHT_GRAY);
		textFri1.setBounds(546, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri1);
		
		JTextArea textSat1 = new JTextArea();
		textSat1.setText("Set: 6\r\nOpen: 10");
		textSat1.setEditable(false);
		textSat1.setBackground(Color.LIGHT_GRAY);
		textSat1.setBounds(652, 69, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat1);
		
		JTextArea textMon2 = new JTextArea();
		textMon2.setText("Set: 10\r\nOpen: 30");
		textMon2.setEditable(false);
		textMon2.setBackground(Color.LIGHT_GRAY);
		textMon2.setBounds(117, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon2);
		
		JTextArea textTue2 = new JTextArea();
		textTue2.setText("Set: 25 \r\nOpen: 15");
		textTue2.setEditable(false);
		textTue2.setBackground(Color.LIGHT_GRAY);
		textTue2.setBounds(227, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue2);
		
		JTextArea textWed2 = new JTextArea();
		textWed2.setText("Set: 15 \r\nOpen: 25");
		textWed2.setEditable(false);
		textWed2.setBackground(Color.LIGHT_GRAY);
		textWed2.setBounds(331, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed2);
		
		JTextArea textThu2 = new JTextArea();
		textThu2.setText("Set: 35 \r\nOpen: 5");
		textThu2.setEditable(false);
		textThu2.setBackground(Color.LIGHT_GRAY);
		textThu2.setBounds(442, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu2);
		
		JTextArea textFri2 = new JTextArea();
		textFri2.setText("Set: 1\r\nOpen: 39");
		textFri2.setEditable(false);
		textFri2.setBackground(Color.LIGHT_GRAY);
		textFri2.setBounds(546, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri2);
		
		JTextArea textSat2 = new JTextArea();
		textSat2.setText("Set: 10\r\nOpen: 6");
		textSat2.setEditable(false);
		textSat2.setBackground(Color.LIGHT_GRAY);
		textSat2.setBounds(652, 184, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat2);
		
		JTextArea textMon3 = new JTextArea();
		textMon3.setText("Set: 0\r\nOpen: 10");
		textMon3.setEditable(false);
		textMon3.setBackground(Color.LIGHT_GRAY);
		textMon3.setBounds(117, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textMon3);
		
		JTextArea textTue3 = new JTextArea();
		textTue3.setText("Set: 8\r\nOpen: 2");
		textTue3.setEditable(false);
		textTue3.setBackground(Color.LIGHT_GRAY);
		textTue3.setBounds(227, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textTue3);
		
		JTextArea textWed3 = new JTextArea();
		textWed3.setText("Set: 5\r\nOpen: 5");
		textWed3.setEditable(false);
		textWed3.setBackground(Color.LIGHT_GRAY);
		textWed3.setBounds(331, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textWed3);
		
		JTextArea textThu3 = new JTextArea();
		textThu3.setText("Set: 8 \r\nOpen: 2");
		textThu3.setEditable(false);
		textThu3.setBackground(Color.LIGHT_GRAY);
		textThu3.setBounds(442, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textThu3);
		
		JTextArea textFri3 = new JTextArea();
		textFri3.setText("Set: 5\r\nOpen: 5");
		textFri3.setEditable(false);
		textFri3.setBackground(Color.LIGHT_GRAY);
		textFri3.setBounds(546, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textFri3);
		
		JTextArea textSat3 = new JTextArea();
		textSat3.setText("Set: 1\r\nOpen: 3");
		textSat3.setEditable(false);
		textSat3.setBackground(Color.LIGHT_GRAY);
		textSat3.setBounds(652, 295, 82, 64);
		frmAppointmentMain.getContentPane().add(textSat3);
		
		
		frmAppointmentMain.setTitle("Appointments");
		frmAppointmentMain.setBackground(Color.WHITE);
		frmAppointmentMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Appointment_Main.class.getResource("/General_Images/GI_icon.png")));
		frmAppointmentMain.setBounds(100, 100, 800, 600);
		frmAppointmentMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//loadAppointments();
		
	}


	private void loadAppointments() {
		// TODO Auto-generated method stub
		
		//Get the current date.		
		 Calendar c = new GregorianCalendar();
		 c.set(Calendar.HOUR_OF_DAY, 0);
		 c.set(Calendar.MINUTE, 0);
		 c.set(Calendar.SECOND, 0);
		 java.util.Date current_date = c.getTime(); 
		 
		//We'll want to pull appointments from the database for the current date
		 String commandText = "SELECT * FROM Appointments WHERE Date='"+ current_date + ";";
		 
		 
		 //Set text within the appropriate text box with the correct appointments made and remaining info
		    
		//Pull appointments for other dates of the week depending on what the current date is
		
		
		
	}
}
