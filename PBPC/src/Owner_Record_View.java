import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class Owner_Record_View {

	JFrame frmOwnerRecordView;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtPhoneNum;
	
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblPhoneNum;
	
	private JButton btnNewPet;
	private JButton btnViewPet;
	private JButton btnSave;
	private JButton btnDiscard;
	private JButton btnEditAccount;
	private JButton btnBack;
	

	public Vector<petItem> pets = new Vector<petItem>();
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TODO: test args to make sure one and only on is being pasted in.
					Owner_Record_View window = new Owner_Record_View(Integer.parseInt(args[0]));
					window.frmOwnerRecordView.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * Create the application.
	 * @param ID 
	 */
	public Owner_Record_View(int ID) {
		initialize(ID);
	}


	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize(final int ID) {
		frmOwnerRecordView = new JFrame();
		frmOwnerRecordView.getContentPane().setBackground(Color.WHITE);
		frmOwnerRecordView.setTitle("Owner Record Viewer");
		frmOwnerRecordView.setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Menu.class.getResource("/General_Images/GI_icon.png")));
		frmOwnerRecordView.setBounds(100, 100, 800, 600);
		frmOwnerRecordView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOwnerRecordView.getContentPane().setLayout(null);
		
		JLabel lblPets = new JLabel("Pets:");
		lblPets.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPets.setBounds(10, 11, 218, 37);
		frmOwnerRecordView.getContentPane().add(lblPets);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(314, 73, 72, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(314, 104, 72, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Street:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(339, 135, 47, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(288, 251, 98, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel_3);
		
		JLabel lblGen = new JLabel("City:");
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGen.setBounds(356, 166, 30, 20);
		frmOwnerRecordView.getContentPane().add(lblGen);
		
		JLabel lblNewLabel_4 = new JLabel("State:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(345, 197, 41, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Zip:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(363, 226, 23, 20);
		frmOwnerRecordView.getContentPane().add(lblNewLabel_5);
		
		JScrollPane petScroll = new JScrollPane();
		petScroll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		petScroll.setBounds(10, 56, 241, 430);
		frmOwnerRecordView.getContentPane().add(petScroll);
		
		@SuppressWarnings("rawtypes")
		final JList petList = new JList();
		createPetList(ID);
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
		petList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnViewPet.setEnabled(true);
			}
		});
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		petScroll.setViewportView(petList);
		
		lblFirstName = new JLabel("");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(396, 73, 369, 20);
		frmOwnerRecordView.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("");
		lblLastName.setBounds(396, 104, 369, 20);
		frmOwnerRecordView.getContentPane().add(lblLastName);
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(396, 136, 369, 20);
		frmOwnerRecordView.getContentPane().add(lblAddress);
		
		lblCity = new JLabel("");
		lblCity.setBounds(396, 170, 378, 16);
		frmOwnerRecordView.getContentPane().add(lblCity);
		
		lblState = new JLabel("");
		lblState.setBounds(396, 201, 378, 20);
		frmOwnerRecordView.getContentPane().add(lblState);
		
		lblZip = new JLabel("");
		lblZip.setBounds(396, 226, 378, 20);
		frmOwnerRecordView.getContentPane().add(lblZip);
		
		lblPhoneNum = new JLabel("");
		lblPhoneNum.setBounds(396, 251, 378, 20);
		frmOwnerRecordView.getContentPane().add(lblPhoneNum);
		
		txtFirstName = new JTextField();
		txtFirstName.setEnabled(false);
		txtFirstName.setEditable(false);
		txtFirstName.setBounds(396, 74, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setEnabled(false);
		txtLastName.setEditable(false);
		txtLastName.setBounds(396, 105, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEnabled(false);
		txtAddress.setEditable(false);
		txtAddress.setBounds(396, 136, 378, 19);
		frmOwnerRecordView.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setEnabled(false);
		txtCity.setBounds(396, 167, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setEditable(false);
		txtState.setEnabled(false);
		txtState.setBounds(396, 197, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtState);
		txtState.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setEditable(false);
		txtZip.setEnabled(false);
		txtZip.setBounds(396, 227, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtZip);
		txtZip.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setEnabled(false);
		txtPhoneNum.setEditable(false);
		txtPhoneNum.setBounds(396, 252, 378, 20);
		frmOwnerRecordView.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmOwnerRecordView.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBounds(639, 501, 135, 37);
		frmOwnerRecordView.getContentPane().add(btnBack);
		
		btnViewPet = new JButton("View Pet");
		btnViewPet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pet_Record_View Pet_Record_Instance = new Pet_Record_View(pets.get((petList.getSelectedIndex())).ID);
			}
		});
		btnViewPet.setEnabled(false);
		btnViewPet.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnViewPet.setBounds(68, 497, 121, 37);
		frmOwnerRecordView.getContentPane().add(btnViewPet);
		
		btnSave = new JButton("Save Changes");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(allFieldsFiled()){
					String commandText = "UPDATE `PetOwner` SET `ZipCode`="+txtZip.getText()
						+ ", `City`=\""+txtCity.getText()+"\", `State`=\""+txtState.getText()+"\", "
						+ " `FirstName`=\""+txtFirstName.getText()+"\", `LastName`=\""+ txtLastName.getText()
						+ "\", `Address`=\""+txtAddress.getText()+"\", `Phone`=\""+txtPhoneNum.getText()+"\""
						+ " WHERE `ID`="+ ID +";";
					exitEditMode();
					//update DB and lbls
					SQL.UpdateResultSet(commandText);
					grabTextToLabel();
				}
			}

			private void grabTextToLabel() {
				//grab text in txt's and put in lbl's (should be the same as DB if successfull)
				lblFirstName.setText(txtFirstName.getText());
				lblLastName.setText(txtLastName.getText());
				lblAddress.setText(txtAddress.getText());
				lblCity.setText(txtCity.getText());
				lblState.setText(txtState.getText());
				lblZip.setText(txtZip.getText());
				lblPhoneNum.setText(txtPhoneNum.getText());
			}
		});
		
		btnNewPet = new JButton("New Pet");
		btnNewPet.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewPet.setBounds(494, 501, 135, 37);
		frmOwnerRecordView.getContentPane().add(btnNewPet);
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.setBounds(396, 325, 151, 37);
		frmOwnerRecordView.getContentPane().add(btnSave);
		
		btnDiscard = new JButton("Discard Changes");
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitEditMode();
			}
		});
		btnDiscard.setEnabled(false);
		btnDiscard.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDiscard.setBounds(557, 325, 181, 37);
		frmOwnerRecordView.getContentPane().add(btnDiscard);
		
		btnEditAccount = new JButton("Edit Account");
		btnEditAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				startEditMode();
				grabLabelsToText();
			}

			private void grabLabelsToText() {
				//Grab text in lbl's and put in txt
				txtFirstName.setText(lblFirstName.getText());
				txtLastName.setText(lblLastName.getText());
				txtAddress.setText(lblAddress.getText());
				txtState.setText(lblState.getText());
				txtCity.setText(lblCity.getText());
				txtZip.setText(lblZip.getText());
				txtPhoneNum.setText(lblPhoneNum.getText());
			}

			private void startEditMode() {
					lblFirstName.setVisible(false);
					lblLastName.setVisible(false);
					lblAddress.setVisible(false);
					lblCity.setVisible(false);
					lblState.setVisible(false);
					lblZip.setVisible(false);
					lblPhoneNum.setVisible(false);
					
					txtFirstName.setVisible(true);
					txtLastName.setVisible(true);
					txtAddress.setVisible(true);
					txtCity.setVisible(true);
					txtState.setVisible(true);
					txtZip.setVisible(true);
					txtPhoneNum.setVisible(true);
					
					txtFirstName.setEnabled(true);
					txtLastName.setEnabled(true);
					txtAddress.setEnabled(true);
					txtCity.setEnabled(true);
					txtState.setEnabled(true);
					txtZip.setEnabled(true);
					txtPhoneNum.setEnabled(true);
					
					txtFirstName.setEditable(true);
					txtLastName.setEditable(true);
					txtAddress.setEditable(true);
					txtCity.setEditable(true);
					txtState.setEditable(true);
					txtZip.setEditable(true);
					txtPhoneNum.setEditable(true);
					
					txtFirstName.setText(lblFirstName.getText());
					txtLastName.setText(lblLastName.getText());
					txtAddress.setText(lblAddress.getText());
					txtPhoneNum.setText(lblPhoneNum.getText());
					
					btnBack.setEnabled(false);
					btnNewPet.setEnabled(false);
					btnViewPet.setEnabled(false);
					btnSave.setEnabled(true);
					btnDiscard.setEnabled(true);
					btnEditAccount.setEnabled(false);
					
					btnSave.setVisible(true);
					btnDiscard.setVisible(true);
			}
		});
		btnEditAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEditAccount.setBounds(329, 501, 155, 37);
		frmOwnerRecordView.getContentPane().add(btnEditAccount);
		
		//Initial available buttons
		btnSave.setVisible(false);
		btnDiscard.setVisible(false);
		
		populateLabels(ID);
		exitEditMode();
		
	}

	private void populateLabels(int iD) {
		// TODO Auto-generated method stub
		String CommandText = "SELECT * FROM `PetOwner` WHERE `ID`=" + iD;
		ResultSet rs = SQL.ExecuteResultSet(CommandText);
		
		try {
			if(rs.next()){
				lblFirstName.setText(rs.getString("FirstName"));
				lblLastName.setText(rs.getString("LastName"));
				lblCity.setText(rs.getString("City"));
				lblState.setText(rs.getString("State"));
				lblZip.setText(Integer.toString(rs.getInt("ZipCode")));
				lblAddress.setText(rs.getString("Address"));
				lblPhoneNum.setText(rs.getString("Phone"));
			}
			else{
				//TODO: display error
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected boolean allFieldsFiled() {
		boolean test = true;
		if(txtCity.getText().isEmpty() || txtState.getText().isEmpty()
				|| txtZip.getText().isEmpty() || txtFirstName.getText().isEmpty()
				|| txtLastName.getText().isEmpty() || txtAddress.getText().isEmpty()
				|| txtPhoneNum.getText().isEmpty()){
			test = false;
		}
		return test;
	}

	protected void exitEditMode() {
			lblFirstName.setVisible(true);
			lblLastName.setVisible(true);
			lblAddress.setVisible(true);
			lblCity.setVisible(true);
			lblState.setVisible(true);
			lblZip.setVisible(true);
			lblPhoneNum.setVisible(true);
			
			txtFirstName.setVisible(false);
			txtLastName.setVisible(false);
			txtAddress.setVisible(false);
			txtCity.setVisible(false);
			txtState.setVisible(false);
			txtZip.setVisible(false);
			txtPhoneNum.setVisible(false);
			
			txtFirstName.setEnabled(false);
			txtLastName.setEnabled(false);
			txtAddress.setEnabled(false);
			txtCity.setEnabled(false);
			txtState.setEnabled(false);
			txtZip.setEnabled(false);
			txtPhoneNum.setEnabled(false);
			
			txtFirstName.setEditable(false);
			txtLastName.setEditable(false);
			txtAddress.setEditable(false);
			txtCity.setEditable(false);
			txtState.setEditable(false);
			txtZip.setEditable(false);
			txtPhoneNum.setEditable(false);
			
			btnBack.setEnabled(true);
			btnNewPet.setEnabled(true);
			btnViewPet.setEnabled(true);
			btnSave.setEnabled(true);
			btnDiscard.setEnabled(false);
			btnEditAccount.setEnabled(true);
			
			btnSave.setVisible(false);
			btnDiscard.setVisible(false);
	}
	
	protected void createPetList(int ID) {
		//select all pets names and ID and create pet list
		String commandStr = "SELECT PetID, Name FROM PetRecord WHERE OwnerID ="+ ID+" ORDER BY Name;";
		
		//TODO this needs to be changed once the SQL methods have been made
		java.sql.Connection c;
	    Statement stmt;
	    try {
	        Class.forName("org.sqlite.JDBC");        
	        stmt = Connection.con.createStatement();
	        ResultSet rs = stmt.executeQuery( commandStr );
	      
	        //Iterate through the results and populate pet's tempList
	        while ( rs.next() ) {
	        	String tempName = rs.getString("Name");
	        	int tempID = rs.getInt("PetID");
	        	petItem tempItem = new petItem(tempName, tempID);
	        	pets.add(tempItem);
	        }
	        rs.close();
	        stmt.close();
	        
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        JOptionPane.showMessageDialog(null,  e.getClass().getName() + ": " + e.getMessage() );	
	        e.printStackTrace();
	        //System.exit(0);
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
