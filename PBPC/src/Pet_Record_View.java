import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Pet_Record_View {

	JFrame frmPetRecordView;
	private  JTextField txtName;
	private  JTextField txtType;
	private  JTextField txtSex;
	private  JTextField txtSize;
	private  JTextField txtDOB;
	private  JTextField txtColor;
	private  JTextPane txtComment;
	private  JTextPane txtRecord;
	
	private  JLabel lblName;
	private  JLabel lblOwner;
	private  JLabel lblType;
	private  JLabel lblSex;
	private  JLabel lblSize;
	private  JLabel lblDOB;
	private  JLabel lblColor;
	
	private  JButton btnBack;
	private  JButton btnSave;
	private  JButton btnDiscard;
	private  JButton btnEdit;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					//TODO: add test to make sure args has one and only one argument.
					Pet_Record_View window = new Pet_Record_View();
					window.frmPetRecordView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public Pet_Record_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frmPetRecordView.
	 * @param iD 
	 */
	private void initialize() {
		frmPetRecordView = new JFrame();
		frmPetRecordView.getContentPane().setBackground(Color.WHITE);
		frmPetRecordView.setIconImage(Toolkit.getDefaultToolkit().getImage(Pet_Record_View.class.getResource("/General_images/GI_icon.png")));
		frmPetRecordView.setTitle("Pet and Owner Lists");
		frmPetRecordView.setBounds(100, 100, 800, 600);
		frmPetRecordView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetRecordView.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner's Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 49, 130, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(93, 69, 47, 27);
		frmPetRecordView.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sex:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(103, 98, 37, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Size:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(98, 130, 42, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DOB:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(95, 162, 45, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Color:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(89, 194, 51, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Comments:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(58, 349, 97, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Record:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(74, 235, 66, 21);
		frmPetRecordView.getContentPane().add(lblNewLabel_7);
		
		JScrollPane commentScroll = new JScrollPane();
		commentScroll.setBounds(58, 381, 716, 71);
		frmPetRecordView.getContentPane().add(commentScroll);
		
		txtComment = new JTextPane();
		txtComment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		commentScroll.setViewportView(txtComment);
		txtComment.setEditable(false);
		
		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmPetRecordView.dispose();
				Connection.Close();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBounds(23, 510, 120, 41);
		frmPetRecordView.getContentPane().add(btnBack);
		
		btnEdit = new JButton("Edit Record");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enterEditMode();
				populateFields();
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEdit.setBounds(630, 510, 131, 41);
		frmPetRecordView.getContentPane().add(btnEdit);
		
		btnSave = new JButton("Save Changes");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateDB(Main_Menu.PetID);
				emptyFields();
				exitEditMode();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.setBounds(195, 463, 156, 27);
		frmPetRecordView.getContentPane().add(btnSave);
		
		btnDiscard = new JButton("Discard Changes");
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emptyFields();
				exitEditMode();
			}
		});
		btnDiscard.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDiscard.setBounds(366, 463, 175, 27);
		frmPetRecordView.getContentPane().add(btnDiscard);
		
		lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(10, 11, 764, 27);
		frmPetRecordView.getContentPane().add(lblName);
		
		lblOwner = new JLabel("");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOwner.setBounds(150, 49, 624, 21);
		frmPetRecordView.getContentPane().add(lblOwner);
		
		lblType = new JLabel("");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType.setBounds(150, 69, 624, 27);
		frmPetRecordView.getContentPane().add(lblType);
		
		lblSex = new JLabel("");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSex.setBounds(150, 98, 624, 27);
		frmPetRecordView.getContentPane().add(lblSex);
		
		lblSize = new JLabel("");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSize.setBounds(150, 124, 624, 27);
		frmPetRecordView.getContentPane().add(lblSize);
		
		lblDOB = new JLabel("");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDOB.setBounds(150, 156, 624, 27);
		frmPetRecordView.getContentPane().add(lblDOB);
		
		lblColor = new JLabel("");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblColor.setBounds(150, 188, 624, 27);
		frmPetRecordView.getContentPane().add(lblColor);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 764, 27);
		frmPetRecordView.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtType.setEnabled(false);
		txtType.setEditable(false);
		txtType.setBounds(150, 69, 624, 27);
		frmPetRecordView.getContentPane().add(txtType);
		txtType.setColumns(10);
		
		txtSex = new JTextField();
		txtSex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSex.setEditable(false);
		txtSex.setEnabled(false);
		txtSex.setBounds(150, 98, 624, 27);
		frmPetRecordView.getContentPane().add(txtSex);
		txtSex.setColumns(10);
		
		txtSize = new JTextField();
		txtSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSize.setEnabled(false);
		txtSize.setEditable(false);
		txtSize.setBounds(150, 130, 624, 27);
		frmPetRecordView.getContentPane().add(txtSize);
		txtSize.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setEditable(false);
		txtDOB.setEnabled(false);
		txtDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDOB.setBounds(150, 162, 624, 27);
		frmPetRecordView.getContentPane().add(txtDOB);
		txtDOB.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtColor.setEnabled(false);
		txtColor.setEditable(false);
		txtColor.setBounds(150, 192, 624, 27);
		frmPetRecordView.getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		JScrollPane recordScroll = new JScrollPane();
		recordScroll.setBounds(58, 264, 716, 83);
		frmPetRecordView.getContentPane().add(recordScroll);
		
		txtRecord = new JTextPane();
		txtRecord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRecord.setEditable(false);
		recordScroll.setViewportView(txtRecord);
		
		//Initialization Functions
		pullFromDB(Main_Menu.PetID);
		exitEditMode();
	}

	private void pullFromDB(int iD) {
		Connection.Connect();
		//Pull Pet info from the DB and update lbl
		SimpleDateFormat DateForm = new SimpleDateFormat("YYYY-MM-DD");
		String commandText = "SELECT * FROM PetRecord WHERE PetID="+ iD+";";
		String Name = "";
		String Owner = "";
		String Type = "";
		String Sex = "";
		String DOB = "";
		
		String Color = "";
		String Size = "";
		String Comment = "";
		String Rabies = "";
		String Distemper = "";
		String Bordetella = "";
		String PreVisit = "";
		
		String Prescriptions = "NONE";
		String Record = "";
		int ownerID = 0;
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		
		try {
			while(rs.next()){
				Name = rs.getString("Name");
				ownerID = rs.getInt("OwnerID");
				Type = rs.getString("Animal");
				Sex = rs.getString("Sex");
				DOB = rs.getString("DOB");
				Color = rs.getString("Color");
				Comment = rs.getString("Comments");
				Size = rs.getString("Size");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Pull Owner name from DB and update lbl
		commandText = "SELECT FirstName, LastName FROM PetOwner WHERE ID="+ownerID+";";
		rs = SQL.ExecuteResultSet(commandText);
		
		try {
			while(rs.next()){
				Owner = rs.getString("LastName") +", "+ rs.getString("FirstName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commandText = "SELECT * FROM MedicalRecords WHERE PetID = " + iD + " ORDER BY Date asc";
		rs = SQL.ExecuteResultSet(commandText);
		int tmpid = 0;
		try
		{
			while((rs != null) && (rs.next()))
			{
				tmpid = rs.getInt("ItemID");
				
						if(tmpid == 10 || tmpid == 19) //Bordetella
						{
							Bordetella = rs.getString("Date");
						}
						else if (tmpid == 9 || tmpid == 18) //Distemper
						{
							Distemper = rs.getString("Date");
						}
						else if (tmpid == 8 || tmpid == 17) //Rabies
						{
							Rabies = rs.getString("Date");							
						}
						else if (tmpid == 1 || tmpid == 42 || tmpid == 43 || tmpid == 44 || tmpid == 45 || tmpid == 50)
						{
							PreVisit = rs.getString("Date");
							
						}
			}
			
			Record = "Rabies Vaccine: " + Rabies + "\n"
					+"Distemper Vaccine: " + Distemper + "\n"
					+"Bordetella: " + Bordetella + "\n"
					+"Previous Visit: " + PreVisit + "\n"
					+"Prescriptions: " + Prescriptions;
			
			//SET THE LBL's
			lblName.setText(Name);
			lblType.setText(Type);
			lblOwner.setText(Owner);
			lblSex.setText(Sex);
			lblDOB.setText(DOB);
			lblColor.setText(Color);
			txtRecord.setText(Record);
			txtComment.setText(Comment);
			lblSize.setText(Size);
			
			//Check Alerts
			
			
			try {
				String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				Date dtCurrent = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
				
				Date dtRabies;				
				dtRabies = new SimpleDateFormat("yyyy-MM-dd").parse(Rabies);
				Date RabiesComp = new Date(dtCurrent.getTime() - 1096L * 24 * 3600 * 1000);
				
				Date dtBordetella;				
				dtBordetella = new SimpleDateFormat("yyyy-MM-dd").parse(Bordetella);
				Date BordetellaComp = new Date(dtCurrent.getTime() - 1096L * 24 * 3600 * 1000);
				
				Date dtDistemper;				
				dtDistemper = new SimpleDateFormat("yyyy-MM-dd").parse(Distemper);
				Date DistemperComp = new Date(dtCurrent.getTime() - 1096L * 24 * 3600 * 1000);
				
				
				if(dtRabies.before(RabiesComp))
				{
					JOptionPane.showMessageDialog(null,Name + " is due for Rabies shot!");
				}
				
				if(dtBordetella.before(BordetellaComp))
				{
					JOptionPane.showMessageDialog(null,Name + " is due for Bordetella shot!");
				}
				

				if(dtDistemper.before(DistemperComp))
				{
					JOptionPane.showMessageDialog(null,Name + " is due for Distemper shot!");
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			
			}
			
			
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		Connection.Close();
			
	}

	protected void populateFields() {
		//copy lbls into the txts
		txtName.setText(lblName.getText());
		txtType.setText(lblType.getText());
		txtSex.setText(lblSex.getText());
		txtDOB.setText(lblDOB.getText());
		txtColor.setText(lblColor.getText());
		txtSize.setText(lblSize.getText());
	}

	protected void updateDB(int ID) {
		if(FieldsFilled()){
			//TODO Update DB with new fields
			String commandString = "UPDATE PetRecord SET Name=\""+txtName.getText()+"\", Animal=\""+
					txtType.getText()+"\", Sex=\""+txtSex.getText()+"\", Size=\""+ txtSize.getText() +
					"\", DOB=\""+txtDOB.getText()+"\", Comments=\""+txtComment.getText()+"\", Color=\""+txtColor.getText()+
					"\" WHERE PetID="+ID+";";
			SQL.UpdateResultSet(commandString);
			//Copy info from txt's to lbl's. It should be the same info as what is on the DB.
			lblName.setText(txtName.getText());
			lblType.setText(txtType.getText());
			lblSex.setText(txtSex.getText());
			lblDOB.setText(txtDOB.getText());
			lblColor.setText(txtColor.getText());
		}
		else{
			//TODO generate error message
		}
		
	}

	private boolean FieldsFilled() {
		//if a field is empty return false else true
		boolean FieldsFilled = true;
		if(txtName.getText().isEmpty() || txtType.getText().isEmpty() || txtSex.getText().isEmpty() ||
				txtDOB.getText().isEmpty() || txtColor.getText().isEmpty()) FieldsFilled = false;
		
		return FieldsFilled;
	}

	protected void emptyFields() {
		//empty txts
		txtName.setText("");
		txtType.setText("");
		txtSex.setText("");
		txtDOB.setText("");
		txtColor.setText("");
		
	}

	protected void exitEditMode() {		
		//disable buttons
		btnSave.setEnabled(false);
		btnDiscard.setVisible(false);
		btnSave.setVisible(false);
		btnDiscard.setVisible(false);

		
		//Enable usable buttons
		btnBack.setEnabled(true);
		btnEdit.setEnabled(true);
		
		//Make txts unedible
		txtName.setEditable(false);
		txtType.setEditable(false);
		txtSex.setEditable(false);
		txtDOB.setEditable(false);
		txtColor.setEditable(false);
		txtComment.setEditable(false);
		txtSize.setEditable(false);
		
		//Disable txts
		txtName.setEnabled(false);
		txtType.setEnabled(false);
		txtSex.setEnabled(false);
		txtDOB.setEnabled(false);
		txtColor.setEnabled(false);
		txtComment.setEnabled(false);
		txtSize.setEnabled(false);
		
		//Make txts invisible
		txtName.setVisible(false);
		txtType.setVisible(false);
		txtSex.setVisible(false);
		txtDOB.setVisible(false);
		txtColor.setVisible(false);
		txtSize.setVisible(false);
		
		//Make lbls visible
		lblName.setVisible(true);
		lblType.setVisible(true);
		lblSex.setVisible(true);
		lblDOB.setVisible(true);
		lblColor.setVisible(true);
		lblSize.setVisible(true);
	}

	protected void enterEditMode() {
		//Disable buttons
		btnBack.setEnabled(false);
		btnEdit.setEnabled(false);
		
		//enable usable buttons
		btnSave.setVisible(true);
		btnDiscard.setVisible(true);
		btnSave.setEnabled(true);
		btnDiscard.setVisible(true);
		
		//Make lbls invisible
		lblName.setVisible(false);
		lblType.setVisible(false);
		lblSex.setVisible(false);
		lblDOB.setVisible(false);
		lblColor.setVisible(false);
		lblSize.setVisible(false);
		
		//Make txts edible
		txtName.setEditable(true);
		txtType.setEditable(true);
		txtSex.setEditable(true);
		txtDOB.setEditable(true);
		txtColor.setEditable(true);
		txtComment.setEditable(true);
		txtSize.setEditable(true);
		
		//Enable txts
		txtName.setEnabled(true);
		txtType.setEnabled(true);
		txtSex.setEnabled(true);
		txtDOB.setEnabled(true);
		txtColor.setEnabled(true);
		txtComment.setEnabled(true);
		txtSize.setEnabled(true);
		
		//Make txts visible
		txtName.setVisible(true);
		txtType.setVisible(true);
		txtSex.setVisible(true);
		txtDOB.setVisible(true);
		txtColor.setVisible(true);
		txtSize.setVisible(true);
	}
}
