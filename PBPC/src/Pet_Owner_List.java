import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


public class Pet_Owner_List {

	JFrame frmPetOwnerList;
	private JTextField searchBar;
	public Vector<ownerItem> owners = new Vector<ownerItem>();
	public Vector<petItem> pets = new Vector<petItem>();
	public Vector<ownerItem> filteredOwners = new Vector<ownerItem>();
	public Vector<petItem> filteredPets = new Vector<petItem>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TODO: remove once DB methods have been made
					Connection.Connect();
					Pet_Owner_List window = new Pet_Owner_List();
					window.frmPetOwnerList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pet_Owner_List() {
		initialize();
	}

	//These are use as structs for the JLists that are populated on opening
	public class ownerItem{
		public String FirstName = "";
		public String LastName = "";
		public int ID = -1;
		public ownerItem(String f, String l, int i){
			FirstName = f;
			LastName = l;
			ID = i;
		}
	}
	
	public class petItem{
		public String Name = "";
		public int ID = -1; //pet's ID
		public petItem(String n, int i){
			Name = n;
			ID = i;
		}
	}
	
	protected void createPetList() {
		//select all pets names and ID and create pet list
		String commandStr = "SELECT PetID, Name FROM PetRecord ORDER BY Name;";
		
		//TODO this needs to be changed once the SQL methods have been made
		java.sql.Connection c;
	    Statement stmt;
	    try {
	        Class.forName("org.sqlite.JDBC");        
	        stmt = Connection.con.createStatement();
	        ResultSet rs = stmt.executeQuery( commandStr );
	      
	        //Iterate through the results and populate pet's tempList
	        while ( rs.next() ) {
	        	String tempName = rs.getString("Name");
	        	int tempID = rs.getInt("PetID");
	        	petItem tempItem = new petItem(tempName, tempID);
	        	pets.add(tempItem);
	        }
	        rs.close();
	        stmt.close();
	        
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        JOptionPane.showMessageDialog(null,  e.getClass().getName() + ": " + e.getMessage() );	
	        e.printStackTrace();
	        //System.exit(0);
	      }
	}


	protected void createOwnerList() {
		//select all owners FirstNames, LastNames, and IDs and create a owner list
		
		String commandStr = "SELECT FirstName, LastName, OwnerID FROM PetOwner ORDER BY LastName;";
		
		//TODO this needs to be changed once the SQL methods have been made
		java.sql.Connection c;
	    Statement stmt;
	    try {
	        Class.forName("org.sqlite.JDBC");        
	        stmt = Connection.con.createStatement();
	        ResultSet rs = stmt.executeQuery( commandStr );
	        
	        //Iterate through the results and populate owner's tempList
	        while ( rs.next() ) {
	        	String tempFirst = rs.getString("FirstName");
	        	String tempLast = rs.getString("LastName");
	        	int tempID = rs.getInt("OwnerID");
	        	ownerItem tempItem = new ownerItem(tempFirst, tempLast, tempID);
	        	owners.add(tempItem);
	        }
	        rs.close();
	        stmt.close();
	        
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        JOptionPane.showMessageDialog(null,  e.getClass().getName() + ": " + e.getMessage() );	
	        e.printStackTrace();
	        //System.exit(0);
	      }
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frmPetOwnerList = new JFrame();
		frmPetOwnerList.getContentPane().setBackground(Color.WHITE);
		//frmPetOwnerList.setIconImage(Toolkit.getDefaultToolkit().getImage(Pet_Owner_List.class.getResource("/General_images/GI_icon.png")));
		frmPetOwnerList.setTitle("Pet and Owner Lists");
		frmPetOwnerList.setBounds(100, 100, 800, 600);
		frmPetOwnerList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetOwnerList.getContentPane().setLayout(null);
		
		JLabel lblOwnerList = new JLabel("Owner List:");
		lblOwnerList.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOwnerList.setBounds(117, 11, 113, 31);
		frmPetOwnerList.getContentPane().add(lblOwnerList);
		
		JLabel lblPetList = new JLabel("Pet List:");
		lblPetList.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPetList.setBounds(542, 15, 113, 22);
		frmPetOwnerList.getContentPane().add(lblPetList);
		
		final JButton btnViewOwner = new JButton("View Record");
		btnViewOwner.setEnabled(false);
		btnViewOwner.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewOwner.setBounds(117, 431, 113, 23);
		frmPetOwnerList.getContentPane().add(btnViewOwner);
		
		final JScrollPane ownerScroll = new JScrollPane();
		ownerScroll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		ownerScroll.setBounds(10, 49, 359, 370);
		frmPetOwnerList.getContentPane().add(ownerScroll);
		
		final JList ownerList = new JList();
		createOwnerList();
		ownerList.setModel(new AbstractListModel() {
			public int getSize() {
				return owners.size();
			}
			public Object getElementAt(int index) {
				ownerItem tempItem = owners.get(index);
				String listedName = tempItem.LastName + ", " +tempItem.FirstName;
				return listedName;
			}
		});
		ownerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnViewOwner.setEnabled(true);
			}
		});
		ownerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ownerScroll.setViewportView(ownerList);
		
		final JButton btnViewPet = new JButton("View Record");
		btnViewPet.setEnabled(false);
		btnViewPet.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewPet.setBounds(542, 431, 113, 23);
		frmPetOwnerList.getContentPane().add(btnViewPet);
		
		final JScrollPane petScroll = new JScrollPane();
		petScroll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		petScroll.setBounds(423, 45, 351, 369);
		frmPetOwnerList.getContentPane().add(petScroll);
		
		final JList petList = new JList();
		createPetList();
		petList.setModel(new AbstractListModel() {
			public int getSize() {
				return pets.size();
			}
			public Object getElementAt(int index) {
				petItem tempItem = pets.get(index);
				String tempName = tempItem.Name;
				return tempName;
			}
		});
		petList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnViewPet.setEnabled(true);
			}
		});
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		petScroll.setViewportView(petList);
		
		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				//Update the JList with what is currently being searched.
				
				//first populate the filtered lists
				filterLists(searchBar.getText());
				//Then change the display to match.
				petList.setModel(new AbstractListModel(){
					public Object getElementAt(int index) {
						String tempName = filteredPets.get(index).Name;
						return tempName;
					}
					public int getSize() {
						return filteredPets.size();
					}
					public int getID(int index){
						return filteredPets.get(index).ID;
					}
					
				});
				petScroll.setViewportView(petList);
				
				
				ownerList.setModel(new AbstractListModel(){
					public Object getElementAt(int index) {
						String tempName = filteredOwners.get(index).LastName + ", " + filteredOwners.get(index).FirstName;
						return tempName;
					}
					public int getSize() {
						return filteredOwners.size();
					}
					public int getID(int index){
						return filteredOwners.get(index).ID;
					}
					
				});
				ownerScroll.setViewportView(ownerList);
			}
		});
		searchBar.setBounds(23, 465, 702, 22);
		frmPetOwnerList.getContentPane().add(searchBar);
		searchBar.setColumns(10);
		
		JButton btnReturnToMain = new JButton("Return To Main Menu");
		btnReturnToMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmPetOwnerList.dispose();
				
			}
		});
		btnReturnToMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnToMain.setBounds(23, 520, 225, 31);
		frmPetOwnerList.getContentPane().add(btnReturnToMain);
		
		
		//ACTION LISTENER FOR VIEW PET RECORD
		btnViewPet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open record view of selected animal's record
				petList.getSelectedValue();
			}
		});
		
		//ACTION LISTENER FOR VIEW OWNER RECORD
		btnViewOwner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//open owner record view for selected owner's record.
			}
		});
	}

	protected void filterLists(String text) {
		//This may be inefficient, but it should work
		
		//clear current lists
		filteredOwners.clear();
		filteredPets.clear();
		
		//now populate the list following the search.
		for(int i = 0; i < owners.size(); ++i){
			if(owners.get(i).FirstName.contains(text) || owners.get(i).LastName.contains(text)){
				filteredOwners.add(owners.get(i));
			}
		}
		
		for(int i = 0; i < pets.size(); ++i){
			if(pets.get(i).Name.contains(text)){
				filteredPets.add(pets.get(i));
			}
		}
		
	}
	



}
