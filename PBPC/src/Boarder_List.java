import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

//TODO: Change SQL calls for weight instead of size
/*TODO: OPTIONAL
		Space out buttons for an "update database" button;
			should only be able to alter start/end date and extra services
			*/
public class Boarder_List {

	JFrame frmBoarderList;
	private JTextField textField_animal;
	private JTextField textField_size;
	private JTextField textField_owner;
	private JTextField textField_start;
	private JTextField textField_end;
	private JTextArea txtrCommentText;
	private JLabel lblPlay;
	private JCheckBox chckbxDental;
	private JCheckBox chckbxBathing;
	private JCheckBox chckbxPlayTime;
	private JLabel lblKennel;

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
	public Boarder_List() {
		initialize();
	}
	
void update(int petID){
		String start = "";
		String end = "";
		String comment = "";
		int play = 0;
		int dent = 0;
		int groom = 0;
		int ken = -1;
		String animal = "";
		String owner = "";
		int oID = -1;
		int bigness = -1;
		String size = "";
		ResultSet rs;
		
		String CommandText = "SELECT * FROM Boarding WHERE PETID = " + petID;		
		try{
			rs = SQL.ExecuteResultSet(CommandText);
			while (rs.next()) {
				start = rs.getString("StartDate");
				end = rs.getString("EndDate");
				comment = rs.getString("Comments");
				ken = rs.getInt("Kennel");
				play = rs.getInt("PlayTime");
				dent = rs.getInt("Dental");
				groom = rs.getInt("Grooming");
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		CommandText = "SELECT OwnerID, Animal, Size FROM PetRecord WHERE PetID = " + petID;		
		try{
			rs = SQL.ExecuteResultSet(CommandText);
			while (rs.next()) {
				oID = rs.getInt("OwnerID");
				animal = rs.getString("Animal");
				size = rs.getString("Size");
//				bigness = rs.getInt("Weight");
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		CommandText = "SELECT FirstName, LastName FROM PetOwner WHERE ID = " + oID;		
		try{
			rs = SQL.ExecuteResultSet(CommandText);
			while (rs.next()) {
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				owner = first + " " + last;
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		textField_animal.setText(animal);
		textField_size.setText(bigness + "lbs. : " + size);
		textField_owner.setText(owner);
		textField_start.setText(start);
		textField_end.setText(end);
		lblKennel.setText(""+ken);
		txtrCommentText.setText(comment);
		if (play > 0){
			lblPlay.setText(""+play);
			chckbxPlayTime.setSelected(true);
		}
		else{
			lblPlay.setText("");
			chckbxPlayTime.setSelected(false);
		}
		if (dent > 0)
			chckbxDental.setSelected(true);
		else
			chckbxDental.setSelected(false);
		if (groom > 0)
			chckbxBathing.setSelected(true);
		else
			chckbxBathing.setSelected(false);
		lblPlay.repaint();
		chckbxPlayTime.repaint();
		chckbxDental.repaint();
		chckbxBathing.repaint();
		txtrCommentText.repaint();
		lblKennel.repaint();
		textField_animal.repaint();
		textField_size.repaint();
		textField_owner.repaint();
		textField_start.repaint();
		textField_end.repaint();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBoarderList = new JFrame();
		frmBoarderList.getContentPane().setBackground(Color.WHITE);
		frmBoarderList.setIconImage(Toolkit.getDefaultToolkit().getImage(BoardingCalendar.class.getResource("/General_images/GI_icon.png")));
		frmBoarderList.setTitle("Boarders List View");
		frmBoarderList.setBounds(100, 100, 800, 600);
		frmBoarderList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBoarderList.getContentPane().setLayout(null);
		
		JButton btnAddBoarder = new JButton("Add Boarder");
		btnAddBoarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				addBoardScreen();
			}
		});
		btnAddBoarder.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddBoarder.setBounds(564, 507, 210, 44);
		frmBoarderList.getContentPane().add(btnAddBoarder);
		
		JButton btnBack = new JButton("Back to Calendar");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitListScreen();
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBounds(344, 507, 210, 44);
		frmBoarderList.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 320, 540);
		frmBoarderList.getContentPane().add(scrollPane);
		
		int pID = -1;
		String pName = " ";
		String displayable;
		ResultSet rs;
		ResultSet secondary;
		
		Vector<String> board = new Vector<String>();
		Connection.Connect();
		String CommandText = "SELECT * from Boarding";
		try{
			rs = SQL.ExecuteResultSet(CommandText);
			while (rs.next() && rs!=null) {
				pID = rs.getInt("PETID");
				String SecondaryText = "SELECT Name FROM PetRecord WHERE PetID = " + pID;
				secondary = SQL.ExecuteResultSet(SecondaryText);
				while(secondary.next()){
					pName = secondary.getString("Name");
				}
				displayable = pName + "-" + pID;
			    board.add(displayable);
			    secondary.close();
			}
			rs.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		final JList list = new JList(board);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String selected = list.getSelectedValue().toString();
				String[] selects = selected.split("-");
				int pID = Integer.parseInt(selects[1]);
				update(pID);
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Animal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(344, 13, 140, 44);
		frmBoarderList.getContentPane().add(lblNewLabel);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSize.setBounds(344, 68, 140, 44);
		frmBoarderList.getContentPane().add(lblSize);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOwner.setBounds(344, 123, 140, 44);
		frmBoarderList.getContentPane().add(lblOwner);
		
		textField_animal = new JTextField();
		textField_animal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_animal.setBounds(564, 10, 210, 44);
		frmBoarderList.getContentPane().add(textField_animal);
		textField_animal.setColumns(10);
		
		textField_size = new JTextField();
		textField_size.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_size.setColumns(10);
		textField_size.setBounds(564, 65, 210, 44);
		frmBoarderList.getContentPane().add(textField_size);
		
		textField_owner = new JTextField();
		textField_owner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_owner.setColumns(10);
		textField_owner.setBounds(564, 123, 210, 44);
		frmBoarderList.getContentPane().add(textField_owner);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartDate.setBounds(344, 178, 140, 44);
		frmBoarderList.getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndDate.setBounds(344, 233, 140, 44);
		frmBoarderList.getContentPane().add(lblEndDate);
		
		textField_start = new JTextField();
		textField_start.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_start.setColumns(10);
		textField_start.setBounds(564, 178, 210, 44);
		frmBoarderList.getContentPane().add(textField_start);
		
		textField_end = new JTextField();
		textField_end.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_end.setColumns(10);
		textField_end.setBounds(564, 233, 210, 44);
		frmBoarderList.getContentPane().add(textField_end);
		
		JLabel lblKennelNumber = new JLabel("Kennel Number");
		lblKennelNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKennelNumber.setBounds(344, 288, 140, 44);
		frmBoarderList.getContentPane().add(lblKennelNumber);
		
		JLabel lblKennel = new JLabel("");
		lblKennel.setBounds(564, 288, 210, 44);
		frmBoarderList.getContentPane().add(lblKennel);
		
		JLabel lblExtraServices = new JLabel("Extra Services");
		lblExtraServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExtraServices.setBounds(344, 343, 140, 44);
		frmBoarderList.getContentPane().add(lblExtraServices);
		
		JCheckBox chckbxPlayTime = new JCheckBox("Extra Play Time");
		chckbxPlayTime.setBounds(564, 343, 119, 23);
		frmBoarderList.getContentPane().add(chckbxPlayTime);
		
		JLabel lblPlay = new JLabel("");
		lblPlay.setBounds(689, 343, 85, 23);
		frmBoarderList.getContentPane().add(lblPlay);
		
		JCheckBox chckbxBathing = new JCheckBox("Bathing/Grooming");
		chckbxBathing.setBounds(564, 369, 210, 23);
		frmBoarderList.getContentPane().add(chckbxBathing);
		
		JCheckBox chckbxDental = new JCheckBox("Dental Cleaning");
		chckbxDental.setBounds(564, 395, 210, 23);
		frmBoarderList.getContentPane().add(chckbxDental);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComments.setBounds(344, 423, 140, 44);
		frmBoarderList.getContentPane().add(lblComments);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(494, 423, 280, 67);
		frmBoarderList.getContentPane().add(scrollPane_1);
		
		JTextArea txtrCommentText_1 = new JTextArea();
		txtrCommentText_1.setText("");
		scrollPane_1.setViewportView(txtrCommentText_1);
	}
	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitListScreen() {
		
		
		BoardingCalendar Board_GUI_Instance = new BoardingCalendar();
		Board_GUI_Instance.frmBoardingCalendar.setVisible(true);
		frmBoarderList.dispose();		
	}
	
	//This method will begin the chain of screens necessary to add a boarder
	private void addBoardScreen() {
		
		
		BoarderOwners Own_GUI_Instance = new BoarderOwners();
		Own_GUI_Instance.frmBoardOwner.setVisible(true);
		frmBoarderList.dispose();		
	}
}
