import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;


public class New_Appointment {

	private JFrame frmNewAppointment;
	private JButton btnDeleteApp;
	private JDateChooser AppointmentDate;
	private JTextField txtTime;
	
	private JSpinner serviceSpin;
	private JSpinner roomSpin;
	@SuppressWarnings("rawtypes")
	private JList txtApps;
	public Vector<appItem> apps = new Vector<appItem>();
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
	
	public class appItem{
		public int ExamRoom = -1;
		public int StartTime = -1;
		public Date AppDate = new Date(0L);
		public int ID = -1;
		public appItem(int ER, int ST, int id, Date AP){
			ExamRoom = ER;
			StartTime = ST;
			ID = id;
			AppDate = AP;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	private void initialize() {
		frmNewAppointment = new JFrame();
		frmNewAppointment.setTitle("New Appointment");
		frmNewAppointment.setIconImage(Toolkit.getDefaultToolkit().getImage(New_Appointment.class.getResource("/General_Images/GI_icon.png")));
		frmNewAppointment.getContentPane().setBackground(Color.WHITE);
		frmNewAppointment.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment Date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 27, 154, 33);
		frmNewAppointment.getContentPane().add(lblNewLabel);
		
		JLabel lblAppointmentTime = new JLabel("Appointment Time:");
		lblAppointmentTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppointmentTime.setBounds(340, 27, 154, 33);
		frmNewAppointment.getContentPane().add(lblAppointmentTime);
		
		JLabel lblNewLabel_1 = new JLabel("Appoints That Day:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 128, 141, 33);
		frmNewAppointment.getContentPane().add(lblNewLabel_1);
		
		
		
		JButton btnLogAppointment = new JButton("Log Appointment");
		btnLogAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddAppToCal();
			}
		});
		
		JButton btnBackToAppointments = new JButton("Back to Appointments");
		btnBackToAppointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmNewAppointment.dispose();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Room:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 71, 47, 19);
		frmNewAppointment.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Service:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(400, 71, 62, 26);
		frmNewAppointment.getContentPane().add(lblNewLabel_3);
		btnBackToAppointments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackToAppointments.setBounds(25, 510, 243, 41);
		frmNewAppointment.getContentPane().add(btnBackToAppointments);
		btnLogAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogAppointment.setBounds(513, 510, 243, 41);
		frmNewAppointment.getContentPane().add(btnLogAppointment);
		
		
		AppointmentDate = new JDateChooser();
		AppointmentDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				getAppsForDate(AppointmentDate.getDate());
			}
		});
		AppointmentDate.setToolTipText("Appointment Date");
		AppointmentDate.setBounds(189, 27, 130, 33);
		frmNewAppointment.getContentPane().add(AppointmentDate);
		AppointmentDate.setLocale(Locale.US);
		
		JScrollPane appScroll = new JScrollPane();
		appScroll.setBounds(25, 172, 731, 310);
		frmNewAppointment.getContentPane().add(appScroll);
		
		txtApps = new JList();
		txtApps.setModel(new AbstractListModel() {
			public int getSize() {
				return apps.size();
			}
			public Object getElementAt(int index) {
				String appInfo = printInfo(apps.get(index));
				return appInfo;
			}
			private String printInfo(appItem appItem) {
				// TODO Print line of appItem info
				return null;
			}
		});
		txtApps.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		appScroll.setViewportView(txtApps);
		
		btnDeleteApp = new JButton("Delete Selected");
		btnDeleteApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				removeSelectedApp();
				btnDeleteApp.setEnabled(false);
			}
		});
		btnDeleteApp.setEnabled(false);
		btnDeleteApp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteApp.setBounds(275, 510, 228, 41);
		frmNewAppointment.getContentPane().add(btnDeleteApp);
		
		txtTime = new JTextField();
		txtTime.setBounds(483, 27, 166, 33);
		frmNewAppointment.getContentPane().add(txtTime);
		txtTime.setColumns(10);
		frmNewAppointment.setBackground(Color.WHITE);
		frmNewAppointment.setBounds(100, 100, 800, 600);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppointmentDate.setMinSelectableDate(new Date());
		
		serviceSpin = new JSpinner();
		serviceSpin.setBounds(483, 69, 207, 26);
		frmNewAppointment.getContentPane().add(serviceSpin);
		
		roomSpin = new JSpinner();
		roomSpin.setBounds(82, 71, 207, 26);
		frmNewAppointment.getContentPane().add(roomSpin);
	}



	protected void AddAppToCal() {
		if(CheckFieldsFilled()){
			//TODO Add appointment to calendar
			getAppsForDate(AppointmentDate.getDate());
		}
		else{
			//TODO create error message;
		}
	}



	private boolean CheckFieldsFilled() {
		// TODO make sure all fields are filled.
		
		return false;
	}



	protected void getAppsForDate(Date date) {
		if(date != null){
			//TODO get Appointments for that date and update txtApps
		}
		else {
			//TODO set txtApps to empty
		}
	}



	protected void removeSelectedApp() {
		// TODO Auto-generated method stub
		
	}
}
