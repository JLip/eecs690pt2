import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;


public class New_Client {

	
	JFrame frmNewClient;	
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

public static void run() {
				try {
					New_Client window = new New_Client();
					window.frmNewClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		frmNewClient = new JFrame();
		frmNewClient.getContentPane().setBackground(Color.WHITE);
		frmNewClient.setBackground(Color.WHITE);
		frmNewClient.setBounds(100, 100, 800, 600);
		frmNewClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewClient.getContentPane().setLayout(null);
		
		txt_FirstName = new JTextField();
		txt_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_FirstName.setBounds(360, 20, 123, 33);
		frmNewClient.getContentPane().add(txt_FirstName);
		txt_FirstName.setColumns(10);
		
		txt_LastName = new JTextField();
		txt_LastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_LastName.setBounds(360, 74, 123, 33);
		frmNewClient.getContentPane().add(txt_LastName);
		txt_LastName.setColumns(10);
		
		txt_Address = new JTextField();
		txt_Address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Address.setColumns(10);
		txt_Address.setBounds(360, 126, 123, 33);
		frmNewClient.getContentPane().add(txt_Address);
		
		txt_City = new JTextField();
		txt_City.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_City.setColumns(10);
		txt_City.setBounds(360, 187, 123, 33);
		frmNewClient.getContentPane().add(txt_City);
		
		txt_State = new JTextField();
		txt_State.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_State.setColumns(10);
		txt_State.setBounds(360, 249, 123, 33);
		frmNewClient.getContentPane().add(txt_State);
		
		txt_ZipCode = new JTextField();
		txt_ZipCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ZipCode.setColumns(10);
		txt_ZipCode.setBounds(360, 307, 123, 33);
		frmNewClient.getContentPane().add(txt_ZipCode);
		
		txt_Phone = new JTextField();
		txt_Phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Phone.setBounds(360, 363, 123, 33);
		frmNewClient.getContentPane().add(txt_Phone);
		txt_Phone.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CheckValues();
				
				//InsertRecord();
			}
		});
		btnNext.setBounds(650, 518, 110, 33);
		frmNewClient.getContentPane().add(btnNext);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(274, 27, 76, 14);
		frmNewClient.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(274, 81, 76, 14);
		frmNewClient.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(274, 133, 76, 14);
		frmNewClient.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCity.setBounds(274, 194, 76, 14);
		frmNewClient.getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblState.setBounds(274, 256, 76, 14);
		frmNewClient.getContentPane().add(lblState);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		lblZipcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblZipcode.setBounds(274, 314, 76, 14);
		frmNewClient.getContentPane().add(lblZipcode);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhone.setBounds(274, 370, 76, 14);
		frmNewClient.getContentPane().add(lblPhone);
		
		JButton btnNewButton = new JButton("Return To Main Menu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				frmNewClient.dispose();
				
			}
		});
		btnNewButton.setBounds(22, 510, 243, 41);
		frmNewClient.getContentPane().add(btnNewButton);
	}
	
	public void CheckValues()
	{
		if(txt_FirstName.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "First Name is Required.");
			txt_FirstName.setBackground(Color.red);
			return;
		}
		else if(txt_LastName.getText().isEmpty())
		{
			txt_LastName.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Last Name is Required.");
			return;
		}		
		else if(txt_Address.getText().isEmpty())
		{
			txt_Address.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Address is Required.");
			return;
		}
		else if (txt_City.getText().isEmpty())
		{
			txt_City.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "City is Required.");
			return;
		}
		else if (txt_State.getText().isEmpty())
		{
			txt_State.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "State is Required.");
			return;
		}
		else if (txt_ZipCode.getText().isEmpty())
		{
			txt_ZipCode.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Zip Code is Required.");
			return;
			
		}
		else if (txt_Phone.getText().isEmpty())
		{
			txt_Phone.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Phone Number is Required.");
			return;
			
		}
		else
		{
			InsertRecord();
		}
		
	}
	
	public void GetID()
	{
		
		String commandText = "SELECT ID FROM PetOwner ORDER BY ID desc LIMIT 1";
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		
		try
		{
			while ((rs!=null) && (rs.next()))
			{
				Main_Menu.OwnerID = rs.getInt("ID");
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());		
		}
		New_Pet.run();
		frmNewClient.dispose();
		
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

		GetID();
	}
}
