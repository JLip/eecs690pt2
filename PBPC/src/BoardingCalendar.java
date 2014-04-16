import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/*TODO:	Populate a Google Calendar
			notification of how many kennels full
			Click a day for pop-up of which kennels full
*/

public class BoardingCalendar {

	JFrame frmBoardingCalendar;

	/**
	 * Launch the application.
	 */

public static void run() {
				try {
					BoardingCalendar window = new BoardingCalendar();
					window.frmBoardingCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		
		JButton btnListView = new JButton("Boarder List View");
		btnListView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open boarder list screen
				Boarder_List List_GUI_Instance = new Boarder_List();
				List_GUI_Instance.frmBoarderList.setVisible(true);
				frmBoardingCalendar.dispose();	
				
				
			}
		});
		btnListView.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListView.setBounds(274, 507, 237, 44);
		frmBoardingCalendar.getContentPane().add(btnListView);

		JButton btnListBoarder = new JButton("List of Boarders");
		btnListBoarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open food screen
				Boarder_List List_GUI_Instance = new Boarder_List();
				List_GUI_Instance.frmBoarderList.setVisible(true);
				frmBoardingCalendar.dispose();	
				
				
			}
		});
		btnListBoarder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListBoarder.setBounds(274, 507, 237, 41);
		frmBoardingCalendar.getContentPane().add(btnListBoarder);
		
		JButton btnWeeklyFood = new JButton("Weekly Food");
		btnWeeklyFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open food screen
				Food_Screen Food_GUI_Instance = new Food_Screen();
				Food_GUI_Instance.frmFoodScreen.setVisible(true);
				frmBoardingCalendar.dispose();	
				
				
			}
		});
		btnWeeklyFood.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnWeeklyFood.setBounds(537, 507, 237, 41);
		frmBoardingCalendar.getContentPane().add(btnWeeklyFood);
		
		JButton btnBack = new JButton("Return To Main Menu");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitBoardScreen();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(10, 507, 243, 41);
		frmBoardingCalendar.getContentPane().add(btnBack);
	}
	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitBoardScreen() {
		

		frmBoardingCalendar.dispose();		
	}

}
