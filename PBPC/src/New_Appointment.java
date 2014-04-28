import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;


public class New_Appointment {

	private JFrame frmNewAppointment;
	private JButton btnDeleteApp;
	private JDateChooser AppointmentDate;
	private JTextField txtTime;
	
	private JSpinner serviceSpin;
	private JSpinner roomSpin;
	@SuppressWarnings("rawtypes")
	public JList txtApps;
	public Vector<appItem> apps = new Vector<appItem>();
	public Vector<petItem> pets = new Vector<petItem>();
	
	@SuppressWarnings("rawtypes")
	public JList petList;
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
		lblNewLabel_1.setBounds(25, 270, 141, 33);
		frmNewAppointment.getContentPane().add(lblNewLabel_1);
		
		
		
		final JButton btnLogAppointment = new JButton("Log Appointment");
		btnLogAppointment.setEnabled(false);
		btnLogAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AddAppToCal();
					Connection.Close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
		appScroll.setBounds(25, 314, 731, 168);
		frmNewAppointment.getContentPane().add(appScroll);
		
		txtApps = new JList();
		txtApps.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnDeleteApp.setEnabled(true);
			}
		});
		txtApps.setModel(new AbstractListModel() {
			public int getSize() {
				return apps.size();
			}
			public Object getElementAt(int index) {
				String appInfo = "ERROR";
				try {
					appInfo = printInfo(apps.get(index));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Returning appInfo = " + appInfo);
				return appInfo;
			}
			private String printInfo(appItem appItem) throws SQLException {
				//Print line of appItem info
				int	hours = appItem.StartTime / 100;
				int minutes = appItem.StartTime % 100;
				String name = "N/A";
				String commandText = "SELECT Name FROM PetRecord WHERE PetID ="+ appItem.ID + ";";
				ResultSet rs = SQL.ExecuteResultSet(commandText);
				
				if(rs.next()){
					name = rs.getString("Name");
					if(rs.wasNull()) name = "N/A";
				}
				
				String finale = "Room: " + parseRoom(appItem.ExamRoom) + " " + hours + ":" + minutes + " for " + name;
				return finale;
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
			public void removeSelectedApp() {
				Connection.Connect();
				appItem tempApp = apps.get(txtApps.getSelectedIndex());
				java.sql.Date convDate = new java.sql.Date(tempApp.AppDate.getTime());
				String commandText = "DELETE FROM Appointments WHERE PetID=" +tempApp.ID +
						" AND StartTime=" 
						+ tempApp.StartTime +
						" AND ExamRoom=" + tempApp.ExamRoom +
						" AND Date='"+ convDate+"';";
				
				SQL.UpdateResultSet(commandText);
				
				apps.clear();
				getAppsForDate(tempApp.AppDate);
				Connection.Close();
				
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
		serviceSpin.setModel(new SpinnerListModel(new String[] {"Check Up", "Surgery"}));
		serviceSpin.setBounds(483, 69, 207, 26);
		frmNewAppointment.getContentPane().add(serviceSpin);
		
		roomSpin = new JSpinner();
		roomSpin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roomSpin.setModel(new SpinnerListModel(new String[] {"O.R.", "Exam Room 1", "Exam Room 2"}));
		roomSpin.setBounds(82, 71, 207, 26);
		frmNewAppointment.getContentPane().add(roomSpin);
		
		JLabel lblNewLabel_4 = new JLabel("Pets:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 101, 47, 26);
		frmNewAppointment.getContentPane().add(lblNewLabel_4);
		
		JScrollPane petScroll = new JScrollPane();
		petScroll.setBounds(25, 138, 731, 132);
		frmNewAppointment.getContentPane().add(petScroll);
		
		petList = new JList();
		petList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnLogAppointment.setEnabled(true);
			}
		});
		petScroll.setViewportView(petList);
		createPetList(Main_Menu.OwnerID);
		petList.setModel(new AbstractListModel() {
			public int getSize() {
				return pets.size();
		}
			public Object getElementAt(final int index) {
				final petItem tempItem = pets.get(index);
				final String tempName = tempItem.Name;
				return tempName;
		}
	});
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		petScroll.setViewportView(petList);
	}



	protected String parseRoom(int examRoom) {
		String parsed = "";
		if(examRoom == 1){
			parsed = "Exam 1";
		}
		else if(examRoom == 2){
			parsed = "Exam 2";
		}
		else{
			parsed = "O.R.";
		}
		return parsed;
	}



	protected void AddAppToCal() throws SQLException {
		if(CheckFieldsFilled()){
			int tme = Integer.parseInt(txtTime.getText());
			int ownerID = -1;
			petItem tempPet = pets.get(petList.getSelectedIndex());
			java.sql.Date convDate = new java.sql.Date(AppointmentDate.getDate().getTime());
			if(tme >= 0 &&  tme < 2400){
			//Add appointment to calendar
				Connection.Connect();
				String commandText = "SELECT * FROM Appointments WHERE Date='"+convDate +"' AND StartTime BETWEEN "+
							(tme - 100) + " AND " + (tme + 100) + ";";
				ResultSet rs = SQL.ExecuteResultSet(commandText);
				
				if(rs.next()){
					//TODO time must be an hour apart
				}
				else{
					commandText = "SELECT OwnerID FROM PetRecord WHERE PetID ="+pets.get(petList.getSelectedIndex()).ID +";";
					rs = SQL.ExecuteResultSet(commandText);
					if(rs.next()){
						ownerID = rs.getInt("OwnerID");
						commandText = "INSERT INTO Appointments" 
									+"(PetID, StartTime, OwnerID, ExamRoom, Date, Services) VALUES "
									+"("+tempPet.ID +", "+txtTime.getText()+", "+ ownerID+ ", "+ parseRoomInt() +", '"+convDate 
									+"', '" + (String)serviceSpin.getValue()+"')"+";";
						SQL.UpdateResultSet(commandText);
						Connection.Close();
					}
				}
				
				getAppsForDate(AppointmentDate.getDate());
			}
			else{
				//TODO create time range error message
			}
		}
		else{
			//TODO create error message;
		}
	}


	private int parseRoomInt() {
		int selected = 0;
		String selString = (String)roomSpin.getValue();
		if(selString.contains("1")){
			selected = 1;
		}
		else if(selString.contains("2")){
			selected = 2;
		}
		else{
			selected = 3;
		}
		
		return selected;
	}



	protected void createPetList(int ID) {
		//select all pets names and ID and create pet list
		String commandStr = "SELECT PetID, Name FROM PetRecord ORDER BY Name;";
		Connection.Connect();
		
		try {
		ResultSet rs = SQL.ExecuteResultSet(commandStr);
		
		//Iterate through the results and populate pet's tempList
		while ( rs.next() ) {
			String tempName = rs.getString("Name");
			int tempID = rs.getInt("PetID");
			petItem tempItem = new petItem(tempName, tempID);
			pets.add(tempItem);
		}
		rs.close();		
		
		} catch ( Exception e ) {
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );	
		e.printStackTrace();
		//System.exit(0);
		}
	}

	private boolean CheckFieldsFilled() {
		//make sure all fields are filled
		boolean filled = true;
		
		if(txtTime.getText().isEmpty() || AppointmentDate.getDate() == null) filled = false;
		
		return filled;
	}



	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	protected void getAppsForDate(Date date) {

		if(date != null){
			Connection.Connect();
			apps.clear();
			
			int ER = -1;
			int ST = -1;
			int id = -1;
			java.sql.Date convDate = new java.sql.Date(date.getTime());
			String commandStr = "SELECT * FROM Appointments WHERE DATE(Date)='"+ convDate +"' ORDER BY StartTime;";

		    try {
		        ResultSet rs = SQL.ExecuteResultSet(commandStr);

		        while ( rs.next() ) {
		        	ER = rs.getInt("ExamRoom");
		        	ST = rs.getInt("StartTime");
		        	id = rs.getInt("PetID");
		        	appItem tempItem = new appItem(ER, ST, id, date);
		        	apps.add(tempItem);
		        }
		        rs.close();
		        Connection.Close();
		      } catch ( Exception e ) {
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        JOptionPane.showMessageDialog(null,  e.getClass().getName() + ": " + e.getMessage() );	
		        e.printStackTrace();
		        //System.exit(0);
		      }
		    txtApps.setModel(new AbstractListModel() {
				public int getSize() {
					return apps.size();
				}
				public Object getElementAt(int index) {
					String appInfo = "ERROR";
					try {
						appInfo = printInfo(apps.get(index));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Connection.Close();
					return appInfo;
				}
				private String printInfo(appItem appItem) throws SQLException {
					Connection.Connect();
					//Print line of appItem info
					int	hours = appItem.StartTime / 100;
					int minutes = appItem.StartTime % 100;
					String name = "N/A";
					String commandText = "SELECT Name FROM PetRecord WHERE PetID ="+ appItem.ID + ";";
					ResultSet rs = SQL.ExecuteResultSet(commandText);
					
					if(rs.next()){
						name = rs.getString("Name");
						if(rs.wasNull()) name = "N/A";
					}
					Connection.Close();
					String finale = "Room: " + parseRoom(appItem.ExamRoom) + " " + hours + ":" + minutes + " for " + name;
					return finale;
				}
			});
		}
		else {
			//TODO set txtApps to empty
		}
	}

	
	public class petItem{
		public String Name = "";
		public int ID = -1; //pet's ID
			public petItem(String n, int i){
			Name = n;
			ID = i;
			}
		}
}
