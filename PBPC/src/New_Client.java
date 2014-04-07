import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class New_Client {

	private JFrame frame;
	private static JTextField txt_FirstName;
	private static JTextField txt_LastName;
	private static JTextField txt_Address;
	private static JTextField txt_City;
	private static JTextField txt_State;
	private static JTextField txt_ZipCode;
	private static JTextField txt_Phone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Client window = new New_Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public New_Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_FirstName = new JTextField();
		txt_FirstName.setBounds(197, 11, 123, 20);
		frame.getContentPane().add(txt_FirstName);
		txt_FirstName.setColumns(10);
		
		txt_LastName = new JTextField();
		txt_LastName.setBounds(197, 47, 123, 20);
		frame.getContentPane().add(txt_LastName);
		txt_LastName.setColumns(10);
		
		txt_Address = new JTextField();
		txt_Address.setColumns(10);
		txt_Address.setBounds(197, 78, 123, 20);
		frame.getContentPane().add(txt_Address);
		
		txt_City = new JTextField();
		txt_City.setColumns(10);
		txt_City.setBounds(197, 109, 123, 20);
		frame.getContentPane().add(txt_City);
		
		txt_State = new JTextField();
		txt_State.setColumns(10);
		txt_State.setBounds(197, 145, 123, 20);
		frame.getContentPane().add(txt_State);
		
		txt_ZipCode = new JTextField();
		txt_ZipCode.setColumns(10);
		txt_ZipCode.setBounds(197, 176, 123, 20);
		frame.getContentPane().add(txt_ZipCode);
		
		txt_Phone = new JTextField();
		txt_Phone.setBounds(197, 207, 123, 20);
		frame.getContentPane().add(txt_Phone);
		txt_Phone.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsertRecord();
			}
		});
		btnNext.setBounds(409, 295, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(79, 14, 76, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(79, 50, 76, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(79, 81, 76, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(79, 112, 76, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(79, 148, 76, 14);
		frame.getContentPane().add(lblState);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		lblZipcode.setBounds(79, 179, 76, 14);
		frame.getContentPane().add(lblZipcode);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(79, 210, 76, 14);
		frame.getContentPane().add(lblPhone);
	}
	
	public void InsertRecord()
	{
		Connection.Connect();		
		String FirstName = txt_FirstName.getText();
		String LastName = txt_LastName.getText();
		String Address = txt_Address.getText();
		String City = txt_City.getText();
		String State = txt_State.getText();
		String ZipCode = txt_ZipCode.getText();
		String Phone = txt_Phone.getText();
		
		String commandText = "INSERT INTO 'PetOwner'('FirstName','LastName','Address','City','State','ZipCode','Phone') VALUES ('" +
							FirstName + "' ," + "'" + LastName + "' ," + "'" + Address + "' ," + "'" + City + "' ,"
							+ "'" + State + "' ," + "'" + ZipCode + "' ," + "'" + Phone + "')";
				
				
		SQL.UpdateResultSet(commandText);

		
	}
	
	
	
}
