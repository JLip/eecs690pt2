import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

public class Add_Boarder {

	JFrame frmAddBoard;
	private JTextField textField_animal;
	private JTextField textField_weight;
	private JTextField textField_owner;
	private JTextPane txtrCommentText;
	private JComboBox comboBoxPlay;
	private JCheckBox chckbxDental;
	private JCheckBox chckbxBathing;
	private JCheckBox chckbxPlayTime;
	private JComboBox comboBoxKennel;
	private static JDateChooser startDay;
	private static JDateChooser endDay;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Boarder_List window = new Boarder_List();
					window.frmBoarderList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Add_Boarder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddBoard = new JFrame();
		frmAddBoard.getContentPane().setBackground(Color.WHITE);
		frmAddBoard.setIconImage(Toolkit.getDefaultToolkit().getImage(BoardingCalendar.class.getResource("/General_images/GI_icon.png")));
		frmAddBoard.setTitle("Add A Boarder");
		frmAddBoard.setBounds(100, 100, 800, 600);
		frmAddBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddBoard.getContentPane().setLayout(null);
		
		JButton btnAddBoarder = new JButton("Add Boarder");
		btnAddBoarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckValues();
			}
		});
		btnAddBoarder.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddBoarder.setBounds(481, 507, 280, 44);
		frmAddBoard.getContentPane().add(btnAddBoarder);
		
		JButton btnBack = new JButton("Back to Owner List");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitAddScreen();
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBounds(20, 507, 280, 44);
		frmAddBoard.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Animal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 10, 140, 44);
		frmAddBoard.getContentPane().add(lblNewLabel);
		
		textField_animal = new JTextField();
		textField_animal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_animal.setBounds(160, 10, 172, 44);
		textField_animal.setEditable(false);
		frmAddBoard.getContentPane().add(textField_animal);
		textField_animal.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWeight.setBounds(20, 65, 140, 44);
		frmAddBoard.getContentPane().add(lblWeight);
		
		textField_weight = new JTextField();
		textField_weight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_weight.setColumns(10);
		textField_weight.setBounds(160, 65, 172, 44);
		textField_weight.setEditable(false);
		frmAddBoard.getContentPane().add(textField_weight);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOwner.setBounds(20, 120, 140, 44);
		frmAddBoard.getContentPane().add(lblOwner);
		
		textField_owner = new JTextField();
		textField_owner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_owner.setColumns(10);
		textField_owner.setBounds(160, 120, 172, 44);
		textField_owner.setEditable(false);
		frmAddBoard.getContentPane().add(textField_owner);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartDate.setBounds(372, 10, 140, 44);
		frmAddBoard.getContentPane().add(lblStartDate);
		
		startDay = new JDateChooser();
		startDay.setToolTipText("Date of Check-In");
		startDay.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        public void propertyChange(PropertyChangeEvent e) {
			        	CheckKennel();
			        	CheckPlay();
	        }
	    });
		startDay.setBounds(589, 10, 172, 44);
		frmAddBoard.getContentPane().add(startDay);
		startDay.setLocale(Locale.US);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndDate.setBounds(372, 65, 140, 44);
		frmAddBoard.getContentPane().add(lblEndDate);
		
		endDay = new JDateChooser();
		endDay.setToolTipText("Date of Check-Out");
		endDay.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        public void propertyChange(PropertyChangeEvent e) {
			        	CheckKennel();
			        	CheckPlay();
	        }
	    });
		endDay.setBounds(589, 65, 172, 44);
		frmAddBoard.getContentPane().add(endDay);
		endDay.setLocale(Locale.US);
				
		JLabel lblKennelNumber = new JLabel("Kennel Number");
		lblKennelNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKennelNumber.setBounds(372, 120, 140, 44);
		frmAddBoard.getContentPane().add(lblKennelNumber);
		
		comboBoxKennel = new JComboBox();
		comboBoxKennel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				CheckKennel();
				
			}
		});
		comboBoxKennel.setBounds(589, 120, 172, 44);
		frmAddBoard.getContentPane().add(comboBoxKennel);
		
		JLabel lblExtraServices = new JLabel("Extra Services");
		lblExtraServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExtraServices.setBounds(20, 175, 140, 44);
		frmAddBoard.getContentPane().add(lblExtraServices);
		
		chckbxPlayTime = new JCheckBox("Extra Play Time");
		chckbxPlayTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckPlay();
			}
		});
		chckbxPlayTime.setBounds(160, 196, 172, 23);
		frmAddBoard.getContentPane().add(chckbxPlayTime);
		
		comboBoxPlay = new JComboBox();
		comboBoxPlay.setBounds(372, 196, 172, 23);
		frmAddBoard.getContentPane().add(comboBoxPlay);
		comboBoxPlay.setEnabled(false);
		
		chckbxBathing = new JCheckBox("Bathing/Grooming");
		chckbxBathing.setBounds(160, 226, 172, 23);
		frmAddBoard.getContentPane().add(chckbxBathing);
		
		chckbxDental = new JCheckBox("Dental Cleaning");
		chckbxDental.setBounds(370, 226, 172, 23);
		frmAddBoard.getContentPane().add(chckbxDental);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComments.setBounds(20, 256, 140, 44);
		frmAddBoard.getContentPane().add(lblComments);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 311, 723, 185);
		frmAddBoard.getContentPane().add(scrollPane_1);
		
		txtrCommentText = new JTextPane();
		scrollPane_1.setViewportView(txtrCommentText);
		txtrCommentText.setText("");		
		txtrCommentText.setEditable(true);

		
		//Initialization Functions
		pullFromDB(Main_Menu.PetID);
	}
	
	private void pullFromDB(int iD) {
		//Pull Pet info from the DB and update lbl
		String commandText = "SELECT * FROM PetRecord WHERE PetID = "+ iD+";";
		Connection.Connect();
		String Owner = "";
		String animal = "";
		int weight = -1;
		String Comment = "";
		int ownerID = 0;
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		
		try {
	        while ( rs != null && rs.next() ) {
				animal = rs.getString("Animal");
				ownerID = rs.getInt("OwnerID");
				Comment = rs.getString("Comments");
				weight = Integer.parseInt(rs.getString("Weight"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Pull Owner name from DB and update lbl
		commandText = "SELECT FirstName, LastName FROM PetOwner WHERE ID = "+ownerID+";";
		Connection.Connect();
		rs = SQL.ExecuteResultSet(commandText);
		
		try {
	        while ( rs != null && rs.next() ) {
				Owner = rs.getString("LastName") +", "+ rs.getString("FirstName");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//SET THE LBL's
		textField_animal.setText(animal);
		textField_weight.setText(""+weight);
		textField_owner.setText(Owner);
		if ( !(Comment.isEmpty() || Comment == null) ){
			txtrCommentText.setText(Comment);
		}
		
	}
	
	public void CheckPlay(){
		
		if(startDay.getDate() != null && endDay.getDate() != null && chckbxPlayTime.isSelected()){

			int days = 0;
			Date start = startDay.getDate();	
			Date end = endDay.getDate();
			String DOS = String.format("%1$td-%1$tm-%1$tY", start);
			String DOE = String.format("%1$td-%1$tm-%1$tY", end);
			String[] sTimes = DOS.split("-");
			String[] eTimes = DOE.split("-");
			int sYr = Integer.parseInt(sTimes[2]);
			int sMo = Integer.parseInt(sTimes[1]);
			int sDy = Integer.parseInt(sTimes[0]);
			int eYr = Integer.parseInt(eTimes[2]);
			int eMo = Integer.parseInt(eTimes[1]);
			int eDy = Integer.parseInt(eTimes[0]);
			
			if (sYr == eYr){
				if(sMo == eMo){
					days = eDy-sDy;
				}
				else{
					for(int i = sMo; i < eMo; i++){
						if (i == 4 || i == 6 || i == 9 || i == 10)
							days += 30;
						else if (i == 2 && (sYr%4 == 0) )
							days += 29;
						else if (i == 2)
							days += 28;
						else
							days += 31;
					}
					
					days += eDy-sDy;
				}
			}
			else{
				if(sMo < eMo){
					for(int i = sYr; i < eYr; i++){
						if (i%4 == 0)
							days += 366;
						else
							days += 365;
					}
						
					for(int i = sMo; i < eMo; i++){
						if (i == 4 || i == 6 || i == 9 || i == 10)
							days += 30;
						else if (i == 2 && (eYr%4 == 0) )
							days += 29;
						else if (i == 2)
							days += 28;
						else
							days += 31;
					}
					
					days += eDy-sDy;
				}
				else{
					for(int i = sYr; i < eYr-1; i++){
						if (i%4 == 0)
							days += 366;
						else
							days += 365;
					}
					
					for(int i = sMo; i < 13; i++){
						if (i == 4 || i == 6 || i == 9 || i == 10)
							days += 30;
						else if (i == 2 && (sYr-1%4 == 0) )
							days += 29;
						else if (i == 2)
							days += 28;
						else
							days += 31;
					}
				
					days -= sDy;
				
					for(int i = 1; i < eMo; i++){
						if (i == 4 || i == 6 || i == 9 || i == 10)
							days += 30;
						else if (i == 2 && (sYr-1%4 == 0) )
							days += 29;
						else if (i == 2)
							days += 28;
						else
							days += 31;
					}
			
					days += eDy;
				}
			}
				
			comboBoxPlay.removeAllItems();
			for (int i = days; i > 0; i--)
				comboBoxPlay.addItem((Integer)i);
			
			comboBoxPlay.setEnabled(true);
		}
		else
			comboBoxPlay.setEnabled(false);
	}
	
	public void CheckKennel(){
		if(startDay.getDate() != null && endDay.getDate() != null){
			//Calculate kennel, populate that as a drop-down
			//			6 cat				- 11-16
			//			4 small dog			- 21-24
			//			4 mid-large dog		- 25-28

			Date start = startDay.getDate();	
			Date end = endDay.getDate();
			String DOS = String.format("%1$td-%1$tm-%1$tY", start);
			String DOE = String.format("%1$td-%1$tm-%1$tY", end);
			String[] sTimes = DOS.split("-");
			String[] eTimes = DOE.split("-");
			int sYr = Integer.parseInt(sTimes[2]);
			int sMo = Integer.parseInt(sTimes[1]);
			int sDy = Integer.parseInt(sTimes[0]);
			int eYr = Integer.parseInt(eTimes[2]);
			int eMo = Integer.parseInt(eTimes[1]);
			int eDy = Integer.parseInt(eTimes[0]);
			int startKen = 0;
			int lastKen = 0;
			
			Calendar cStart = Calendar.getInstance();
			cStart.set(sYr, sMo, sDy);
			Calendar cEnd = Calendar.getInstance();
			cEnd.set(eYr, eMo, eDy);
			
			String commandText = "SELECT Size, Animal FROM PetRecord WHERE PetID = "+ Main_Menu.PetID+";";
			Connection.Connect();
			String Size = "";
			String animal = "";
			ResultSet rs = SQL.ExecuteResultSet(commandText);
			
			try {
		        while ( rs != null && rs.next() ) {
					animal = rs.getString("Animal");
					Size = rs.getString("Size");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (animal.equalsIgnoreCase("cat")){
				startKen = 11;
				lastKen = 16;
			}
			else if (Size.equalsIgnoreCase("small")){
				startKen = 21;
				lastKen = 24;
			}
			else{
				startKen = 25;
				lastKen = 28;
			}
			comboBoxKennel.removeAllItems();

			String sDate = "";
			String eDate = "";
			for( int i = startKen; i <= lastKen; i++){
				commandText = "SELECT StartDate, EndDate FROM Boarding WHERE Kennel = "+ i+";";
				Connection.Connect();
				rs = SQL.ExecuteResultSet(commandText);
				
				try {
			        while ( rs != null && rs.next() ) {
			        	sDate = rs.getString("StartDate");
			        	eDate = rs.getString("EndDate");
			        	
						String[] tsTimes = sDate.split("-");
						int tsYr = Integer.parseInt(tsTimes[2]);
						int tsMo = Integer.parseInt(tsTimes[1]);
						int tsDy = Integer.parseInt(tsTimes[0]);					
						String[] teTimes = eDate.split("-");
						int teYr = Integer.parseInt(teTimes[2]);
						int teMo = Integer.parseInt(teTimes[1]);
						int teDy = Integer.parseInt(teTimes[0]);	
						Calendar tStart = Calendar.getInstance();
						tStart.set(tsYr, tsMo, tsDy);
						Calendar tEnd = Calendar.getInstance();
						tEnd.set(teYr, teMo, teDy);
						
						if ( (tStart.after(cStart) || tStart.equals(cStart)) && tStart.before(cEnd) ){
							continue;
						}
						if ( tEnd.after(cStart) && (tEnd.before(cEnd) || tEnd.equals(cEnd)) ){
							continue;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				comboBoxKennel.addItem((Integer)i);
			}
			
			int kenSize = comboBoxKennel.getSize().height;
			if( kenSize == 0)
				JOptionPane.showMessageDialog(null, "There are no kennels available for the entire selected stay.");
		}
	}
	
	public void CheckValues()
	{
		
		if(startDay.getDate() == null)
		{
			startDay.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Date of Check-In is Required.");		
			return;
		}
		else if(endDay.getDate() == null)
		{
			endDay.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Date of Check-Out is Required.");		
			return;
		}
		else
		{
			
			InsertRecord();
		}
	}
	
	
	public void InsertRecord()
	{
		
		Connection.Connect();
		Date start = startDay.getDate();	
		Date end = endDay.getDate();
		int tooth = 0;
		int bath = 0;
		int play = 0;
		int kennel = 0;

		String DOS = String.format("%1$td-%1$tm-%1$tY", start);
		String DOE = String.format("%1$td-%1$tm-%1$tY", end);
		String Comments = txtrCommentText.getText();
		if(chckbxDental.isSelected())
		{	
			tooth = 10;
		}
		else
		{
			tooth = 0;			
		}
		
		if(chckbxBathing.isSelected())
		{	
			bath = 10;
		}
		else
		{
			bath = 0;			
		}
		
		if(chckbxPlayTime.isSelected())
		{	
			play = Integer.parseInt(comboBoxPlay.getSelectedItem().toString());
		}
		else
		{
			play = 0;			
		}
		kennel = Integer.parseInt(comboBoxKennel.getSelectedItem().toString());
		
	
		String commandText = "INSERT INTO 'Boarding'('Dental','Grooming','PlayTime','PETID','StartDate','EndDate','Comments','Kennel') VALUES (" +
							tooth + " ," + "'" + bath + "' ," + "'" + play + "' ," + "'" + Main_Menu.PetID + "' ,"
							+ "'" + DOS + "' ," + "'" + DOE + "' ," + "'" + Comments + "' ," + "'" + kennel + "')";
				
				
		SQL.UpdateResultSet(commandText);
		String message = "Boarder been successfully added to the database.";
		JOptionPane.showMessageDialog(null, message);		
		exitAddScreen();
		
	}
	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitAddScreen() {
		
		Connection.Close();
		BoarderOwners Own_GUI_Instance = new BoarderOwners();
		Own_GUI_Instance.frmBoardOwner.setVisible(true);
		frmAddBoard.dispose();		
	}
}
