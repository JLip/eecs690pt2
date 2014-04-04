import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


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
		btnBack.setBounds(288, 479, 210, 44);
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
		
		JLabel label = new JLabel("Data Coming Soon");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(564, 27, 210, 60);
		frmFoodScreen.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Data Coming Soon");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(564, 98, 210, 60);
		frmFoodScreen.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Data Coming Soon");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(564, 169, 210, 60);
		frmFoodScreen.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Data Coming Soon");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(564, 240, 210, 60);
		frmFoodScreen.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Data Coming Soon");
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBounds(564, 311, 210, 60);
		frmFoodScreen.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Data Coming Soon");
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
