import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.UIManager;

import java.awt.Toolkit;


public class New_Pet {
	
	private JFrame frmNewPet;
	private static JTextField txt_PetName;
	private static JTextField txt_Breed;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private static JTextField txt_Color;
	private static JDateChooser DOB;
	private static JRadioButton rdbtnCat;
	private static JRadioButton rdbtnDog;
	private static JComboBox combo_size;
	private static JRadioButton rdbtnMale;
	private static JRadioButton rdbtnFemale;
	private static JTextPane txt_Comments;
	private JTextField txt_Weight;

	/**
	 * Launch the application.
	 */

public static void run() {
	try {
		New_Pet window = new New_Pet();
		window.frmNewPet.setVisible(true);
		} catch (Exception e) {
		e.printStackTrace();
		}
}
		

	/**
	 * Create the application.
	 */
	public New_Pet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewPet = new JFrame();
		frmNewPet.setTitle("New Pet");
		frmNewPet.setIconImage(Toolkit.getDefaultToolkit().getImage(New_Pet.class.getResource("/General_Images/GI_icon.png")));
		frmNewPet.getContentPane().setBackground(Color.WHITE);
		frmNewPet.setBounds(100, 100, 634, 610);
		frmNewPet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewPet.getContentPane().setLayout(null);
		
		//JCalendar calendar = new JCalendar();    
		
		txt_PetName = new JTextField();
		txt_PetName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_PetName.setBounds(268, 28, 130, 33);
		frmNewPet.getContentPane().add(txt_PetName);
		txt_PetName.setColumns(10);
		
		txt_Breed = new JTextField();
		txt_Breed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Breed.setColumns(10);
		txt_Breed.setBounds(268, 173, 130, 33);
		frmNewPet.getContentPane().add(txt_Breed);
		
		rdbtnDog = new JRadioButton("Dog");
		rdbtnDog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDog.setSelected(true);
		buttonGroup.add(rdbtnDog);
		rdbtnDog.setBounds(255, 83, 51, 23);
		frmNewPet.getContentPane().add(rdbtnDog);
		
		rdbtnCat = new JRadioButton("Cat");
		rdbtnCat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rdbtnCat);
		rdbtnCat.setBounds(334, 83, 51, 23);
		frmNewPet.getContentPane().add(rdbtnCat);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setSelected(true);
		buttonGroup_1.add(rdbtnMale);
		rdbtnMale.setBounds(255, 129, 64, 23);
		frmNewPet.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_1.add(rdbtnFemale);
		rdbtnFemale.setBounds(334, 129, 77, 23);
		frmNewPet.getContentPane().add(rdbtnFemale);
		
		combo_size = new JComboBox();
		combo_size.setFont(new Font("Tahoma", Font.PLAIN, 15));
		combo_size.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		combo_size.setBounds(268, 220, 130, 33);
		frmNewPet.getContentPane().add(combo_size);
		
		txt_Color = new JTextField();
		txt_Color.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Color.setBounds(268, 308, 130, 33);
		frmNewPet.getContentPane().add(txt_Color);
		txt_Color.setColumns(10);
		
		DOB = new JDateChooser();
		DOB.setToolTipText("Date of Birth");
		DOB.setBounds(268, 359, 130, 33);
		frmNewPet.getContentPane().add(DOB);
		DOB.setLocale(Locale.US);
		
		txt_Comments = new JTextPane();
		txt_Comments.setBackground(Color.LIGHT_GRAY);
		txt_Comments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Comments.setBounds(266, 420, 191, 85);
		frmNewPet.getContentPane().add(txt_Comments);
		
		JButton btnOkay = new JButton("Submit");
		btnOkay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				CheckValues();
			}
		});
		btnOkay.setBounds(505, 492, 103, 41);
		frmNewPet.getContentPane().add(btnOkay);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(163, 35, 46, 14);
		frmNewPet.getContentPane().add(lblName);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnimal.setBounds(163, 87, 46, 14);
		frmNewPet.getContentPane().add(lblAnimal);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSex.setBounds(163, 133, 46, 14);
		frmNewPet.getContentPane().add(lblSex);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBreed.setBounds(163, 180, 46, 14);
		frmNewPet.getContentPane().add(lblBreed);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSize.setBounds(163, 229, 46, 14);
		frmNewPet.getContentPane().add(lblSize);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColor.setBounds(163, 317, 46, 14);
		frmNewPet.getContentPane().add(lblColor);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateOfBirth.setBounds(163, 368, 95, 14);
		frmNewPet.getContentPane().add(lblDateOfBirth);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComments.setBounds(163, 427, 75, 14);
		frmNewPet.getContentPane().add(lblComments);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Main_Menu.run();
				frmNewPet.dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.setBounds(10, 492, 150, 41);
		frmNewPet.getContentPane().add(btnMainMenu);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWeight.setBounds(163, 268, 46, 24);
		frmNewPet.getContentPane().add(lblWeight);
		
		txt_Weight = new JTextField();
		txt_Weight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Weight.setColumns(10);
		txt_Weight.setBounds(268, 264, 130, 33);
		frmNewPet.getContentPane().add(txt_Weight);
	}
	
	public void CheckValues()
	{
		
		if(txt_PetName.getText().isEmpty())
		{
			txt_PetName.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Pet Name is Required.");		
			return;
		}
		else if (txt_Breed.getText().isEmpty())
		{
			txt_Breed.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Breed is Required.");		
			return;
			
		}
		else if (txt_Weight.getText().isEmpty())
		{
			txt_Weight.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Weight is required");
			return;
		}
		else if (txt_Color.getText().isEmpty())
		{
			txt_Color.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Color is required is Required.");		
			return;
		}
		else if(DOB.getDate() == null)
		{
			DOB.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Date of Birth is Required.");		
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
		Date DateofBirth = DOB.getDate();	
		String Name = txt_PetName.getText();		
		String Breed = txt_Breed.getText();
		String Color = txt_Color.getText();
		String Weight = txt_Weight.getText();
		
		String DOB = String.format("%1$td-%1$tm-%1$tY", DateofBirth);
		String Animal;
		String Sex;
		String Comments = txt_Comments.getText();
		if(rdbtnDog.isSelected())
		{	
			Animal = "Dog";
		}
		else
		{
			Animal = "Cat";			
		}
		
		if(rdbtnMale.isSelected())
		{
			Sex = "Male";
		}
		else
		{			
			Sex = "Female";
		}
		String Size = combo_size.getSelectedItem().toString();
		
	
		String commandText = "INSERT INTO 'PetRecord'('OwnerID','Name','Animal','Sex','Breed','Size','Weight','Color','DOB','Comments') VALUES (" +
							Main_Menu.OwnerID + " ," + "'" + Name + "' ," + "'" + Animal + "' ," + "'" + Sex + "' ,"
							+ "'" + Breed + "' ," + "'" + Size + "' ," + "'" + Weight + "'," + "'" + Color + "' ," + "'" + DOB + "' ," + "'" + Comments + "')";
				
				
		SQL.UpdateResultSet(commandText);
		String message = Name + " has been successfully added to the database.";
		JOptionPane.showMessageDialog(null, message);		
		//Main_Menu.run();
		frmNewPet.dispose();
	
		
		
		
	}
}
