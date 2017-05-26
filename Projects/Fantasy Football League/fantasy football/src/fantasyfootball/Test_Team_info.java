package fantasyfootball;

import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fantasyfootball.Connector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
public class Test_Team_info extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField DF1;
	private JTextField MF1;
	private JTextField MF2;
	private JTextField MF3;
	private JTextField MF4;
	private JTextField DF2;
	private JTextField DF3;
	private JTextField DF4;
	private JTextField CF1;
	private JTextField CF2;
	private JTextField GK;
	Connection con;
	Statement st=null;
	ResultSet rs=null;
    PreparedStatement ps=null;
    private String user;
    private JTextField textFieldTeamName;


	/**
	 * Create the frame.
	 */
	public Test_Team_info(String u) {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("My Team ");
		user=u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGk = new JLabel("GK");
		lblGk.setBounds(489, 35, 46, 14);
		contentPane.add(lblGk);

		JLabel lblDefender1 = new JLabel("Defender1");
		lblDefender1.setBounds(115, 150, 105, 14);
		contentPane.add(lblDefender1);

		DF1 = new JTextField();
		DF1.setBackground(Color.WHITE);
		DF1.setEditable(false);
		DF1.setBounds(7, 171, 300, 20);
		contentPane.add(DF1);
		DF1.setColumns(10);

		JLabel lblDefender2 = new JLabel("Defender 2");
		lblDefender2.setBounds(247, 92, 105, 14);
		contentPane.add(lblDefender2);

		JLabel lblDefender3 = new JLabel("Defender 3");
		lblDefender3.setBounds(605, 95, 105, 14);
		contentPane.add(lblDefender3);

		JLabel lblDefender = new JLabel("Defender4");
		lblDefender.setBounds(860, 150, 105, 14);
		contentPane.add(lblDefender);

		MF1 = new JTextField();
		MF1.setBackground(Color.WHITE);
		MF1.setEditable(false);
		MF1.setBounds(7, 311, 300, 20);
		contentPane.add(MF1);
		MF1.setColumns(10);

		JLabel lblMidfielder1 = new JLabel("Midfielder 1");
		lblMidfielder1.setBounds(95, 286, 105, 14);
		contentPane.add(lblMidfielder1);

		MF2 = new JTextField();
		MF2.setBackground(Color.WHITE);
		MF2.setEditable(false);
		MF2.setBounds(133, 234, 300, 20);
		MF2.setColumns(10);
		contentPane.add(MF2);

		JLabel lblMidfielder2 = new JLabel("Midfielder 2");
		lblMidfielder2.setBounds(247, 209, 105, 14);
		contentPane.add(lblMidfielder2);

		MF3 = new JTextField();
		MF3.setBackground(Color.WHITE);
		MF3.setEditable(false);
		MF3.setBounds(502, 234, 300, 20);
		contentPane.add(MF3);
		MF3.setColumns(10);

		JLabel lblMidfielde3 = new JLabel("Midfielder 3");
		lblMidfielde3.setBounds(600, 209, 110, 14);
		contentPane.add(lblMidfielde3);

		JLabel lblMidfielder4 = new JLabel("Midfielder 4");
		lblMidfielder4.setBounds(715, 286, 99, 14);
		contentPane.add(lblMidfielder4);

		MF4 = new JTextField();
		MF4.setBackground(Color.WHITE);
		MF4.setEditable(false);
		MF4.setBounds(599, 311, 300, 20);
		MF4.setColumns(10);
		contentPane.add(MF4);

		DF2 = new JTextField();
		DF2.setBackground(Color.WHITE);
		DF2.setEditable(false);
		DF2.setBounds(133, 118, 300, 20);
		contentPane.add(DF2);
		DF2.setColumns(10);

		DF3 = new JTextField();
		DF3.setEditable(false);
		DF3.setBackground(Color.WHITE);
		DF3.setBounds(502, 119, 300, 20);
		DF3.setColumns(10);
		contentPane.add(DF3);

		DF4 = new JTextField();
		DF4.setBackground(Color.WHITE);
		DF4.setEditable(false);
		DF4.setBounds(758, 171, 300, 20);
		DF4.setColumns(10);
		contentPane.add(DF4);

		JLabel lblForward1 = new JLabel("Forward 1");
		lblForward1.setBounds(446, 476, 93, 14);
		contentPane.add(lblForward1);

		CF1 = new JTextField();
		CF1.setEditable(false);
		CF1.setBackground(Color.WHITE);
		CF1.setBounds(340, 500, 300, 20);
		CF1.setColumns(10);
		contentPane.add(CF1);

		JLabel lblForward2 = new JLabel("Forward 2");
		lblForward2.setBounds(446, 392, 105, 14);
		contentPane.add(lblForward2);

		CF2 = new JTextField();
		CF2.setEditable(false);
		CF2.setBackground(Color.WHITE);
		CF2.setBounds(340, 418, 300, 20);
		contentPane.add(CF2);
		CF2.setColumns(10);

		GK = new JTextField();
		GK.setBackground(Color.WHITE);
		GK.setEditable(false);
		GK.setBounds(342, 56, 302, 20);
		contentPane.add(GK);
		GK.setColumns(10);

		textFieldTeamName = new JTextField();
		textFieldTeamName.setBackground(Color.WHITE);
		textFieldTeamName.setEditable(false);
		textFieldTeamName.setBounds(21, 11, 199, 19);
		contentPane.add(textFieldTeamName);
		textFieldTeamName.setColumns(10);

		JButton btnNewButtonBack = new JButton("Back");
		btnNewButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButtonBack.setBounds(465, 580, 117, 25);
		contentPane.add(btnNewButtonBack);


		try{
			//System.out.println(user);
			Connector c= new Connector();
			con=c.Database_Connector();
			st= con.createStatement();
			String query ="SELECT * FROM team  WHERE Username='"+user+"'";
			 ps = con.prepareStatement(query);

			//JOptionPane.showMessageDialog(null,"USER_SUUCCESS");

			rs=ps.executeQuery();


			while(rs.next())
			{


				String gk = rs.getString("Player1");
				GK.setText(gk);

				String df1 = rs.getString("Player2");
				DF1.setText(df1);

				String df2 = rs.getString("Player3");
				DF2.setText(df2);

				String df3 = rs.getString("Player4");
				DF3.setText(df3);

				String df4 = rs.getString("Player5");
				DF4.setText(df4);

				String mf1 = rs.getString("Player6");
				MF1.setText(mf1);

				String mf2 = rs.getString("Player7");
				MF2.setText(mf2);

				String mf3 = rs.getString("Player8");
				MF3.setText(mf3);

				String mf4 = rs.getString("Player9");
				MF4.setText(mf4);

				String cf1 = rs.getString("Player10");
				CF1.setText(cf1);

				String cf2 = rs.getString("Player11");
				CF2.setText(cf2);

				String tn = rs.getString("Team_Name");
				textFieldTeamName.setText(tn);
			}
			ps.close();
			st.close();
		}catch(Exception ex){

			ex.printStackTrace();
		}

	}
}