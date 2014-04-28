import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BoardingCalendar {

	JFrame frmBoardingCalendar;
	static JLabel lblMonth;
	static JTable tblCalendar;
	static DefaultTableModel mtblCalendar; //Table model
	static JFrame frmMain;
	static Container pane;
	static JScrollPane stblCalendar; //The scrollpane
	static JPanel pnlCalendar;
	static int realYear, realMonth, realDay, currentYear, currentMonth;

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
	

//TODO:		Test this listener
	public class SelectionListener implements ListSelectionListener {
	    JTable table;

	    // It is necessary to keep the table since it is not possible
	    // to determine the table from the event's source
	    SelectionListener(JTable table) {
	        this.table = table;
	    }
	    public void valueChanged(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting()) {
	            // The mouse button has not yet been released
	        }
	        
	        int row = table.getSelectedRow();
	        int column = table.getSelectedColumn();
	        int day = (int) table.getValueAt(row, column);
	        dayItem pass = days[day-1];
	        
	        DayDisplay.run(pass);
	    }
	}
	
	public static dayItem[] days = new dayItem[31];
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

		lblMonth = new JLabel ("January");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(10, 11, 774, 35);
		frmBoardingCalendar.getContentPane().add(lblMonth);
		
		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		stblCalendar.setBounds(10, 50, 774, 441);
		frmBoardingCalendar.getContentPane().add(stblCalendar);
		
		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;
		
		String[] headers = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; //All headers
		for (int i=0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
		}
		
		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		//Single cell selection
		tblCalendar.setCellSelectionEnabled(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		SelectionListener listener = new SelectionListener(tblCalendar);
		tblCalendar.getSelectionModel().addListSelectionListener(listener);
		tblCalendar.getColumnModel().getSelectionModel()
		    .addListSelectionListener(listener);

		//Set row/column count
		tblCalendar.setRowHeight(69);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

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
		
		//Refresh calendar
		drawCalendar (realMonth, realYear); //Refresh calendar
	}
	
	public static void drawCalendar(int month, int year){
		//Variables
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som;
		lblMonth.setText(months[month]); //Refresh the month label (at the top)
		//lblMonth.setBounds(10, 50, 605, 345);
		
		//Clear table
		for (int i=0; i<6; i++){
			for (int j=0; j<7; j++){
				mtblCalendar.setValueAt(null, i, j);
			}
		}
		
		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		/*TODO: Verify this algorithm
		for each in Boarding
			if (start <= beginning of month and finish >= bom) or (start <= end of month and finish >= eom)
				for i from start to finish
					array[i].ken(rs.kennel) = rs.petName
		*/

		//Pull Pet info from the DB and update lbl
		String commandText = "SELECT StartDate, EndDate, PETID, Kennel FROM Boarding";
		Connection.Connect();
		String start = "";
		String end = "";
		int id = -1;
		int kennel = 0;
		Calendar cCur = Calendar.getInstance();
	    int yr = cCur.get(Calendar.YEAR);
	    int mo = cCur.get(Calendar.MONTH);
	    int fDay = 1;
	    int lDay = -1;
	    if( yr%4 == 0 && mo == 2)
	    	lDay = 29;
	    else if(mo == 2)
	    	lDay = 28;
	    else if(mo == 4 || mo == 6 || mo == 9 || mo == 11)
	    	lDay = 30;
	    else
	    	lDay = 31;
	    
	    int first = 0;
	    int last = 0;
	    
	    Calendar cFirst = Calendar.getInstance();
	    Calendar cLast = Calendar.getInstance();
	    cFirst.set(yr, mo, fDay);
	    cLast.set(yr, mo, lDay);
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		
		try {
	        while ( rs != null && rs.next() ) {
				start = rs.getString("StartDate");
				end = rs.getString("EndDate");
				id = rs.getInt("PETID");
				kennel = Integer.parseInt(rs.getString("Kennel"));
				

				String[] sTimes = start.split("-");
				int sYr = Integer.parseInt(sTimes[2]);
				int sMo = Integer.parseInt(sTimes[1]);
				int sDy = Integer.parseInt(sTimes[0]);					
				String[] eTimes = end.split("-");
				int eYr = Integer.parseInt(eTimes[2]);
				int eMo = Integer.parseInt(eTimes[1]);
				int eDy = Integer.parseInt(eTimes[0]);	
				Calendar cStart = Calendar.getInstance();
				cStart.set(sYr, sMo, sDy);
				Calendar cEnd = Calendar.getInstance();
				cEnd.set(eYr, eMo, eDy);
				
				
				if (cFirst.after(cEnd) || cLast.before(cStart)){					
				}
				else{
					if(cFirst.before(cStart))
						first = cStart.get(Calendar.DAY_OF_MONTH);
					else
						first = cFirst.get(Calendar.DAY_OF_MONTH);
					
					if(cLast.before(cEnd))
						last = cLast.get(Calendar.DAY_OF_MONTH);
					else
						last = cEnd.get(Calendar.DAY_OF_MONTH);
					
					for( int i = first; i <= last; i++){
						String secondComm = "SELECT Name FROM PetRecord WHERE PetID = " + id;
						String name = "";
						ResultSet r2 = SQL.ExecuteResultSet(secondComm);
						
						while(r2 != null && rs.next() ) {
							name = r2.getString("Name");
						}

						if( kennel == 11)
							days[i-1].ken11 = name;
						else if( kennel == 12)
							days[i-1].ken12 = name;
						else if( kennel == 13)
							days[i-1].ken13 = name;
						else if( kennel == 14)
							days[i-1].ken14 = name;
						else if( kennel == 15)
							days[i-1].ken12 = name;
						else if( kennel == 16)
							days[i-1].ken12 = name;
						
						else if( kennel == 21)
							days[i-1].ken21 = name;
						else if( kennel == 22)
							days[i-1].ken22 = name;
						else if( kennel == 23)
							days[i-1].ken23 = name;
						else if( kennel == 24)
							days[i-1].ken24 = name;
						else if( kennel == 25)
							days[i-1].ken25 = name;
						else if( kennel == 26)
							days[i-1].ken26 = name;
						else if( kennel == 27)
							days[i-1].ken27 = name;
						else
							days[i-1].ken28 = name;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Draw calendar
		for (int i=1; i<=nod; i++){
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			mtblCalendar.setValueAt(i, row, column);
		}

		//Apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}

	static class tblCalendarRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);

			/*TODO Verify date coloration
			int[] kennels = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 27, 28};
			for each date in the month:
				for( int i = 0; i < kennels.length; i++){
					if kennel[i] has a boarder
						dateDataHolder.add boarder.name
				}
				if date.isFull
					turn date red
	*/
/*			if (column == 0 || column == 6){ //Week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //Week */
				setBackground(new Color(255, 255, 255));
//			}
			if (value != null){
				int day = Integer.parseInt(value.toString());
				if (day == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
					if(days[day-1].isEmpty())
						setBackground(new Color(220, 220, 255));
					else if(days[day-1].isFull())
						setBackground(new Color(245, 210, 210));
					else
						setBackground(new Color(210, 245, 210));
						
				}
				else if (days[day-1].isEmpty())
					setBackground(new Color(255, 255, 255));
				else if (days[day-1].isFull())
					setBackground(new Color(255, 220, 220));
				else
					setBackground(new Color(220, 255, 220));
					
			}
			setBorder(null);
			setForeground(Color.black);
			return this;  
		}
	}
	
	//This method will restart the main screen and destroy this instance of the boarders menu
	private void exitBoardScreen() {
		

		frmBoardingCalendar.dispose();		
	}

}
