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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JCheckBox;


public class Boarder_List {

	JFrame frmBoarderList;
	private JTextField textField_animal;
	private JTextField textField_size;
	private JTextField textField_owner;
	private JTextField textField_strtDate;
	private JTextField textField_endDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boarder_List window = new Boarder_List();
					window.frmBoarderList.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Boarder_List() {
		initialize();
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
		btnAddBoarder.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddBoarder.setBounds(564, 507, 210, 44);
		frmBoarderList.getContentPane().add(btnAddBoarder);
		
		JButton btnBack = new JButton("Back");
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
		int oID = -1;
		String pName = " ";
		String oName = " ";
		String displayable;
		ResultSet rs;
		ResultSet secondary;
		
		Vector<String> board = new Vector<String>();
		String CommandText = "SELECT PETID from Boarding ";
		try{
			rs = SQL.ExecuteResultSet(CommandText);
			while (rs.next()) {
				pID = rs.getInt("PETID");
				String SecondaryText = "SELECT OwnerID, Name from PetRecord WHERE PetID = " + pID;
				secondary = SQL.ExecuteResultSet(SecondaryText);
				while(secondary.next()){
					pName = secondary.getString("Name");
					oID = secondary.getInt("OwnerID");
				}
				SecondaryText = "SELECT FirstName, LastName from PetOwner WHERE ID = " + oID;
				while(secondary.next()){
					oName = secondary.getString("FirstName") + " " + secondary.getString("LastName");
				}
				displayable = oName + "-" + pName;
			    board.add(displayable);
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		JList list = new JList(board);
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
		
		JLabel lblKennelNumber = new JLabel("Kennel Number");
		lblKennelNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKennelNumber.setBounds(344, 288, 140, 44);
		frmBoarderList.getContentPane().add(lblKennelNumber);
		
		JLabel lblExtraServices = new JLabel("Extra Services");
		lblExtraServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExtraServices.setBounds(344, 343, 140, 44);
		frmBoarderList.getContentPane().add(lblExtraServices);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComments.setBounds(344, 423, 140, 44);
		frmBoarderList.getContentPane().add(lblComments);
		
		textField_strtDate = new JTextField();
		textField_strtDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_strtDate.setColumns(10);
		textField_strtDate.setBounds(564, 178, 210, 44);
		frmBoarderList.getContentPane().add(textField_strtDate);
		
		textField_endDate = new JTextField();
		textField_endDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_endDate.setColumns(10);
		textField_endDate.setBounds(564, 233, 210, 44);
		frmBoarderList.getContentPane().add(textField_endDate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(494, 423, 280, 67);
		frmBoarderList.getContentPane().add(scrollPane_1);
		
		JTextArea txtrCommentText = new JTextArea();
		txtrCommentText.setText("Sample comment text.");
		scrollPane_1.setViewportView(txtrCommentText);
		
		JCheckBox chckbxPlayTime = new JCheckBox("Extra Play Time");
		chckbxPlayTime.setBounds(564, 343, 210, 23);
		frmBoarderList.getContentPane().add(chckbxPlayTime);
		
		JCheckBox chckbxBathing = new JCheckBox("Bathing/Grooming");
		chckbxBathing.setBounds(564, 369, 210, 23);
		frmBoarderList.getContentPane().add(chckbxBathing);
		
		JCheckBox chckbxDental = new JCheckBox("Dental Cleaning");
		chckbxDental.setBounds(564, 395, 210, 23);
		frmBoarderList.getContentPane().add(chckbxDental);
	}
	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitListScreen() {
		
		
		BoardingCalendar Board_GUI_Instance = new BoardingCalendar();
		Board_GUI_Instance.frmBoardingCalendar.setVisible(true);
		frmBoarderList.dispose();		
	}
}
