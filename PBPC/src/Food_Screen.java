import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public class Food_Screen {

	JFrame frmFoodScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food_Screen window = new Food_Screen();
					window.frmFoodScreen.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Food_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodScreen = new JFrame();
		frmFoodScreen.getContentPane().setBackground(Color.WHITE);
		frmFoodScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(BoardingCalendar.class.getResource("/General_images/GI_icon.png")));
		frmFoodScreen.setTitle("Weekly Food Required");
		frmFoodScreen.setBounds(100, 100, 800, 600);
		frmFoodScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodScreen.getContentPane().setLayout(null);
		
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
	    int year = c.get(Calendar.YEAR);
	    int month = c.get(Calendar.MONTH);
	    int day = c.get(Calendar.DAY_OF_MONTH);
		int day_of_week = c.get(Calendar.DAY_OF_WEEK);
		ResultSet rs;
		String start = "";
		String end = "";
		Vector<Integer> vector = new Vector<Integer>();
		int id1 = 0;
		
		if(day_of_week == 1)
				day -= 6;
		else if (day_of_week == 3)
			day -= 1;
		else if (day_of_week == 4)
			day -= 2;
		else if (day_of_week == 5)
			day -= 3;
		else if (day_of_week == 6)
			day -= 4;
		else if (day_of_week == 7)
			day -= 5;
		
		double snrDog = 0;
		double adlDog = 0;
		double yngDog = 0;
		double snrCat = 0;
		double adlCat = 0;
		double yngCat = 0;
		
		for (int i = 0; i < 7; i++){
			c.set(year, month, day+i);
			
			String CommandText = "SELECT StartDate, EndDate, PETID from Boarding ";
			
			try{
				rs = SQL.ExecuteResultSet(CommandText);
				while (rs.next()) {
					start = rs.getString("StartDate");
					end = rs.getString("EndDate");
					id1 = rs.getInt("PetID");
					String[] sTimes = start.split("-");
					int sYr = Integer.parseInt(sTimes[2]);
					int sMo = Integer.parseInt(sTimes[0]);
					int sDy = Integer.parseInt(sTimes[1]);					
					String[] eTimes = end.split("-");
					int eYr = Integer.parseInt(eTimes[2]);
					int eMo = Integer.parseInt(eTimes[0]);
					int eDy = Integer.parseInt(eTimes[1]);	
					Calendar c1 = Calendar.getInstance();
					c1.set(sYr, sMo, sDy);
					Calendar c2 = Calendar.getInstance();
					c2.set(eYr, eMo, eDy);
					if (c.before(c2) && c.after(c1))
						vector.add(id1);
				}
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		
		
		String animal;
		double size;
		String birth;
		int sdy = 8;
		int ady = 1;
		int scy = 11;
		int acy = 1;
		double cup = 0;
		Calendar cSD = Calendar.getInstance();
		cSD.set(year-sdy, month, day+6);
		Calendar cAD = Calendar.getInstance();
		cSD.set(year-ady, month, day+6);
		Calendar cSC = Calendar.getInstance();
		cSD.set(year-scy, month, day+6);
		Calendar cAC = Calendar.getInstance();
		cSD.set(year-acy, month, day+6);
		
		for (int i = 0; i < vector.size(); i++){
			String CommandText = "SELECT Animal, Size, DOB from PetRecord WHERE PetID = " + vector.get(i);
			
			try{
				rs = SQL.ExecuteResultSet(CommandText);
				while (rs.next()) {
					animal = rs.getString("Animal");
					size = rs.getDouble("Size");
					birth = rs.getString("DOB");
					String[] bTimes = birth.split("-");
					int bYr = Integer.parseInt(bTimes[2]);
					int bMo = Integer.parseInt(bTimes[0]);
					int bDy = Integer.parseInt(bTimes[1]);
					Calendar age = Calendar.getInstance();
					age.set(bYr, bMo, bDy);
					
					if(animal.equalsIgnoreCase("dog")){
						if (size >= 100)
							cup = 4.5;
						else if (size >= 80)
							cup = 4.0;
						else if (size >= 60)
							cup = 3.25;
						else if (size >= 40)
							cup = 2.5;
						else if (size >= 30)
							cup = 2.0;
						else if (size >= 20)
							cup = 1.5;
						else if (size >= 10)
							cup = 1.0;
						else
							cup = 0.5;
						
						if(age.before(cSD)){
							snrDog += cup;
						}
						else if (age.before(cAD)){
							adlDog += cup;
						}
						else{
							yngDog += cup;
						}
					}
					else{	//cat
						if (size >= 10)
							cup = 1.0;
						else if (size >= 5)
							cup = 0.75;
						else
							cup = 0.5;
						
						if(age.before(cSC)){
							snrCat += cup;
						}
						else if (age.before(cAC)){
							adlCat += cup;
						}
						else{
							yngCat += cup;
						}
					}
				}
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}

		String snrD = String.format("%d cups", snrDog);
		String adlD = String.format("%d cups", adlDog);
		String yngD = String.format("%d cups", yngDog);
		String snrC = String.format("%d cups", snrCat);
		String adlC = String.format("%d cups", adlCat);
		String yngC = String.format("%d cups", yngCat);
		
		JLabel lblComingSoon = new JLabel("Senior Dog Food:");
		lblComingSoon.setFont(new Font("Dialog", Font.BOLD, 20));
		lblComingSoon.setBounds(22, 27, 210, 60);
		frmFoodScreen.getContentPane().add(lblComingSoon);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitFoodScreen();
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBounds(22, 485, 210, 44);
		frmFoodScreen.getContentPane().add(btnBack);
		
		JLabel lblAdultDogFood = new JLabel("Adult Dog Food:");
		lblAdultDogFood.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdultDogFood.setBounds(22, 98, 210, 60);
		frmFoodScreen.getContentPane().add(lblAdultDogFood);
		
		JLabel lblPuppyFood = new JLabel("Puppy Food:");
		lblPuppyFood.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPuppyFood.setBounds(22, 169, 210, 60);
		frmFoodScreen.getContentPane().add(lblPuppyFood);
		
		JLabel lblSeniorCatFood = new JLabel("Senior Cat Food:");
		lblSeniorCatFood.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSeniorCatFood.setBounds(22, 240, 210, 60);
		frmFoodScreen.getContentPane().add(lblSeniorCatFood);
		
		JLabel lblAdultCatFood = new JLabel("Adult Cat Food:");
		lblAdultCatFood.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdultCatFood.setBounds(22, 311, 210, 60);
		frmFoodScreen.getContentPane().add(lblAdultCatFood);
		
		JLabel lblKittenFood = new JLabel("Kitten Food:");
		lblKittenFood.setFont(new Font("Dialog", Font.BOLD, 20));
		lblKittenFood.setBounds(22, 382, 210, 60);
		frmFoodScreen.getContentPane().add(lblKittenFood);
		
		JLabel label = new JLabel(snrD);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(564, 27, 210, 60);
		frmFoodScreen.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(adlD);
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(564, 98, 210, 60);
		frmFoodScreen.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(yngD);
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(564, 169, 210, 60);
		frmFoodScreen.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(snrC);
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(564, 240, 210, 60);
		frmFoodScreen.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(adlC);
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBounds(564, 311, 210, 60);
		frmFoodScreen.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(yngC);
		label_5.setFont(new Font("Dialog", Font.BOLD, 20));
		label_5.setBounds(564, 382, 210, 60);
		frmFoodScreen.getContentPane().add(label_5);
	}
	
	//This method will restart the boarders screen and destroy this instance of the food screen
	private void exitFoodScreen() {			

		BoardingCalendar Board_GUI_Instance = new BoardingCalendar();
		Board_GUI_Instance.frmBoardingCalendar.setVisible(true);
		frmFoodScreen.dispose();		
	}
}
