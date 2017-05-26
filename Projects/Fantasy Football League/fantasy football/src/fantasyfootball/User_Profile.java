package fantasyfootball;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Profile extends JFrame {


	/**
	 *
	 */
	private static final long serialVersionUID = -3273704699660424661L;

	private String user;
	Connection con =null;
	Statement st =null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUSR;
	private JTextField textFieldAGE;
	private JTextField textFieldFT;
	private JTextField textFieldEmail;
	private String balance;
	private JTextField textFieldBalance;






	/**
	 * Create the frame.
	 */
	public User_Profile(String usr) {
		setTitle("User Profile");
		setFont(new Font("Dialog", Font.BOLD, 14));
		user=usr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(10, 11, 200, 14);
		contentPane.add(lblName);

		JLabel lblUsername = new JLabel("Uername");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(10, 85, 200, 14);
		contentPane.add(lblUsername);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAge.setBounds(10, 163, 200, 14);
		contentPane.add(lblAge);

		JLabel lblFavouriteTeam = new JLabel("Favourite Team");
		lblFavouriteTeam.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFavouriteTeam.setBounds(10, 239, 200, 14);
		contentPane.add(lblFavouriteTeam);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContact.setBounds(10, 314, 200, 14);
		contentPane.add(lblContact);

		textFieldName = new JTextField();
		textFieldName.setForeground(Color.BLACK);
		textFieldName.setBackground(Color.WHITE);
		textFieldName.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldName.setEditable(false);
		textFieldName.setBounds(170, 8, 200, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldUSR = new JTextField();
		textFieldUSR.setBackground(Color.WHITE);
		textFieldUSR.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldUSR.setEditable(false);
		textFieldUSR.setBounds(170, 83, 200, 20);
		contentPane.add(textFieldUSR);
		textFieldUSR.setColumns(10);

		textFieldAGE = new JTextField();
		textFieldAGE.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldAGE.setBackground(Color.WHITE);
		textFieldAGE.setEditable(false);
		textFieldAGE.setBounds(170, 161, 200, 20);
		contentPane.add(textFieldAGE);
		textFieldAGE.setColumns(10);

		textFieldFT = new JTextField();
		textFieldFT.setBackground(Color.WHITE);
		textFieldFT.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldFT.setEditable(false);
		textFieldFT.setBounds(170, 237, 200, 20);
		contentPane.add(textFieldFT);
		textFieldFT.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(170, 312, 200, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JButton btnNewButtonViewTeam = new JButton("View Team");
		btnNewButtonViewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test_Team_info tti=new Test_Team_info(usr);
				tti.setVisible(true);
			}
		});
		btnNewButtonViewTeam.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonViewTeam.setBounds(80, 477, 117, 25);
		contentPane.add(btnNewButtonViewTeam);

		JButton btnNewButtonViewRankings = new JButton("View Rankings");
		btnNewButtonViewRankings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team_Table t = new Team_Table();
				t.setVisible(true);
			}
		});
		btnNewButtonViewRankings.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonViewRankings.setBounds(250, 477, 152, 25);
		contentPane.add(btnNewButtonViewRankings);

		JButton btnNewButtonPlayerBio = new JButton("Player Bio");
		btnNewButtonPlayerBio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerBio pb = new PlayerBio();
				pb.setVisible(true);
				}
		});
		btnNewButtonPlayerBio.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonPlayerBio.setBounds(461, 477, 117, 25);
		contentPane.add(btnNewButtonPlayerBio);


		JButton btnNewButtonBack2 = new JButton("Back");
		btnNewButtonBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainWindow mw=new MainWindow();
				mw.mainFrame.setVisible(true);
			}
		});
		btnNewButtonBack2.setBounds(630, 477, 117, 25);
		contentPane.add(btnNewButtonBack2);

		textFieldBalance = new JTextField();
		textFieldBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldBalance.setBackground(Color.WHITE);
		textFieldBalance.setEditable(false);
		textFieldBalance.setBounds(170, 380, 200, 19);
		contentPane.add(textFieldBalance);
		textFieldBalance.setColumns(10);

		JLabel lblNewLabelBalance = new JLabel("Balance");
		lblNewLabelBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelBalance.setBounds(10, 382, 70, 15);
		contentPane.add(lblNewLabelBalance);

		JLabel labelImage1 = new JLabel("");
		Image uimg = new ImageIcon(getClass().getResource("/barclays-premier-league-logo-wallpaper-2014-2015.jpg")).getImage();
		labelImage1.setIcon(new ImageIcon(uimg));
		labelImage1.setBounds(0, 0, 800, 565);
		getContentPane().add(labelImage1);

		try{
			//System.out.println(user);
			Connector c= new Connector();
			con=c.Database_Connector();
			st= con.createStatement();
			String query ="SELECT * FROM user_info "+
							"where Username='"+user+"'";

			PreparedStatement ps = con.prepareStatement(query);

			//JOptionPane.showMessageDialog(null,"USER_SUUCCESS");

			rs=ps.executeQuery(query);

			while(rs.next())
			{
				String  Name = rs.getString("Name");
				textFieldName.setText(Name);

				String Usr = rs.getString("Username");
				textFieldUSR.setText(Usr);

				String email = rs.getString("Email");
				textFieldEmail.setText(email);

				int age = rs.getInt("Age");
				String s=Integer.toString(age);
				textFieldAGE.setText(s);

				String ft = rs.getString("Favourite_Team");
				textFieldFT.setText(ft);

				balance=rs.getString("Transfer_Balance");
				textFieldBalance.setText(balance);
			}

			ps.close();

		}catch(Exception ex){

			ex.printStackTrace();
		}

	}
}
