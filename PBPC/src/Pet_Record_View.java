import java.awt.EventQueue;

import javax.swing.JFrame;


public class Pet_Record_View {

	JFrame frmPetRecordView;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TODO: add test to make sure args has one and only one argument.
					Pet_Record_View window = new Pet_Record_View(Integer.parseInt(args[0]));
					window.frmPetRecordView.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param ID 
	 */
	public Pet_Record_View(int ID) {
		initialize();
	}

	/**
	 * Initialize the contents of the frmPetRecordView.
	 */
	private void initialize() {
		frmPetRecordView = new JFrame();
		frmPetRecordView.setBounds(100, 100, 450, 300);
		frmPetRecordView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
