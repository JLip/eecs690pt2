import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class BoardingCalendar {

	JFrame frmBoardingCalendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardingCalendar window = new BoardingCalendar();
					window.frmBoardingCalendar.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardingCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBoardingCalendar = new JFrame();
		frmBoardingCalendar.getContentPane().setBackground(Color.WHITE);
		frmBoardingCalendar.setIconImage(Toolkit.getDefaultToolkit().getImage(BoardingCalendar.class.getResource("/General_images/GI_icon.png")));
		frmBoardingCalendar.setTitle("Boarder Monthly Calendar");
		frmBoardingCalendar.setBounds(100, 100, 800, 600);
		frmBoardingCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBoardingCalendar.getContentPane().setLayout(null);
		
		JLabel lblComingSoon = new JLabel("Data Coming Soon");
		lblComingSoon.setFont(new Font("Dialog", Font.BOLD, 20));
		lblComingSoon.setBounds(288, 82, 210, 60);
		frmBoardingCalendar.getContentPane().add(lblComingSoon);
		
		JButton btnAddBoarder = new JButton("Add Boarder");
		btnAddBoarder.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddBoarder.setBounds(288, 420, 210, 44);
		frmBoardingCalendar.getContentPane().add(btnAddBoarder);
		
		JButton btnWeeklyFood = new JButton("Weekly Food");
		btnWeeklyFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open food screen
				Food_Screen Food_GUI_Instance = new Food_Screen();
				Food_GUI_Instance.frmFoodScreen.setVisible(true);
				
				
			}
		});
		btnWeeklyFood.setFont(new Font("Dialog", Font.BOLD, 20));
		btnWeeklyFood.setBounds(564, 420, 210, 44);
		frmBoardingCalendar.getContentPane().add(btnWeeklyFood);
		
		JButton btnBack = new JButton("Back");
/*		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitBoardScreen();
			}
		});
*/		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBounds(10, 420, 210, 44);
		frmBoardingCalendar.getContentPane().add(btnBack);
	}
/*	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitManagerScreen() {
		
		
		Main_Screen Main_GUI_Instance = new Main_Screen();
		Main_GUI_Instance.frmMAIN.setVisible(true);
		frmBoardingCalendar.dispose();		
	}
*/
}
