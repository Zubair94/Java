package fantasyfootball;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MainWindow {

	JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Fantasy Football League");
		mainFrame.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		mainFrame.setBounds(100, 100, 800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.getContentPane().setLayout(null);

		JButton btnNewButtonLogin = new JButton("Login");
		btnNewButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				Login lf = new Login();
				lf.setVisible(true);
			}
		});


		btnNewButtonLogin.setBounds(110, 438, 135, 33);
		mainFrame.getContentPane().add(btnNewButtonLogin);

		JButton btnNewButtonSignUp = new JButton("Sign Up");
		btnNewButtonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				SignUp sp = new SignUp();
				sp.setVisible(true);
			}
		});
		btnNewButtonSignUp.setBounds(340, 438, 135, 33);
		mainFrame.getContentPane().add(btnNewButtonSignUp);

		JButton btnNewButtonInfo = new JButton("Rankings");
		btnNewButtonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.dispose();
				Team_Table t = new Team_Table();
				t.setVisible(true);
			}
		});
		btnNewButtonInfo.setBounds(580, 438, 135, 33);
		mainFrame.getContentPane().add(btnNewButtonInfo);

		JLabel labelImage = new JLabel("");
		Image mainimg = new ImageIcon(this.getClass().getResource("/mainwindow.jpg")).getImage();
		labelImage.setIcon(new ImageIcon(mainimg));
		labelImage.setBounds(0, 0, 800, 565);
		mainFrame.getContentPane().add(labelImage);

}

}