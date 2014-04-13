import java.awt.Color;
import java.awt.EventQueue;
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


public class New_Pet {
	
	private JFrame frame;
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

	/**
	 * Launch the application.
	 */

public static void run() {
	try {
		New_Pet window = new New_Pet();
		window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JCalendar calendar = new JCalendar();    
		
		txt_PetName = new JTextField();
		txt_PetName.setBounds(268, 56, 130, 20);
		frame.getContentPane().add(txt_PetName);
		txt_PetName.setColumns(10);
		
		txt_Breed = new JTextField();
		txt_Breed.setColumns(10);
		txt_Breed.setBounds(268, 177, 130, 20);
		frame.getContentPane().add(txt_Breed);
		
		rdbtnDog = new JRadioButton("Dog");
		rdbtnDog.setSelected(true);
		buttonGroup.add(rdbtnDog);
		rdbtnDog.setBounds(268, 83, 51, 23);
		frame.getContentPane().add(rdbtnDog);
		
		rdbtnCat = new JRadioButton("Cat");
		buttonGroup.add(rdbtnCat);
		rdbtnCat.setBounds(334, 83, 51, 23);
		frame.getContentPane().add(rdbtnCat);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		buttonGroup_1.add(rdbtnMale);
		rdbtnMale.setBounds(268, 129, 51, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale);
		rdbtnFemale.setBounds(334, 129, 64, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		combo_size = new JComboBox();
		combo_size.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		combo_size.setBounds(268, 226, 130, 20);
		frame.getContentPane().add(combo_size);
		
		txt_Color = new JTextField();
		txt_Color.setBounds(268, 278, 130, 20);
		frame.getContentPane().add(txt_Color);
		txt_Color.setColumns(10);
		
		DOB = new JDateChooser();
		DOB.setToolTipText("Date of Birth");
		DOB.setBounds(268, 330, 130, 20);
		frame.getContentPane().add(DOB);
		DOB.setLocale(Locale.US);
		
		txt_Comments = new JTextPane();
		txt_Comments.setBounds(266, 365, 191, 85);
		frame.getContentPane().add(txt_Comments);
		
		JButton btnOkay = new JButton("Submit");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				CheckValues();
			}
		});
		btnOkay.setBounds(508, 427, 89, 23);
		frame.getContentPane().add(btnOkay);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(181, 59, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(181, 87, 46, 14);
		frame.getContentPane().add(lblAnimal);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(181, 133, 46, 14);
		frame.getContentPane().add(lblSex);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setBounds(181, 180, 46, 14);
		frame.getContentPane().add(lblBreed);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(181, 229, 46, 14);
		frame.getContentPane().add(lblSize);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(181, 281, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(181, 330, 77, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(181, 365, 75, 14);
		frame.getContentPane().add(lblComments);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main_Menu.run();
				frame.dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.setBounds(10, 420, 150, 31);
		frame.getContentPane().add(btnMainMenu);
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
		
	
		String commandText = "INSERT INTO 'PetRecord'('OwnerID','Name','Animal','Sex','Breed','Size','Color','DOB','Comments') VALUES (" +
							Main_Menu.OwnerID + " ," + "'" + Name + "' ," + "'" + Animal + "' ," + "'" + Sex + "' ,"
							+ "'" + Breed + "' ," + "'" + Size + "' ," + "'" + Color + "' ," + "'" + DOB + "' ," + "'" + Comments + "')";
				
				
		SQL.UpdateResultSet(commandText);
		String message = Name + " has been successfully added to the database.";
		JOptionPane.showMessageDialog(null, message);		
		Main_Menu.run();
		frame.dispose();
		
	}
}
