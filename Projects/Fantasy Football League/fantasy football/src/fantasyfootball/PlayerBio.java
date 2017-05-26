package fantasyfootball;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PlayerBio extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 2229504657285139037L;
	private JPanel contentPane;
	private JTextField textFieldPValue;
	private JTextField textFieldPPos;
	private JTextField textFieldPTeam;
	private JTextField textFieldPName;
	private JTextField textFieldPAge;
	private JTextField textFieldPCountry;
	JComboBox<String> comboBoxPlayer1;
	Connection con =null;
	Statement st =null;
	ResultSet rs = null;




	/**
	 * Create the frame.
	 */
	public PlayerBio() {
		setFont(new Font("Comfortaa", Font.BOLD, 14));
		setTitle("Player Bio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButtonBack = new JButton("Back");
		btnNewButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButtonBack.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonBack.setBounds(449, 329, 117, 25);
		contentPane.add(btnNewButtonBack);

		JLabel lblNewLabelPlayerPic = new JLabel("");
		lblNewLabelPlayerPic.setBounds(30, 25, 150, 150);
		contentPane.add(lblNewLabelPlayerPic);

		JLabel lblNewLabelPName = new JLabel("Player Name");
		lblNewLabelPName.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelPName.setBounds(250, 25, 101, 15);
		contentPane.add(lblNewLabelPName);

		JLabel lblNewLabelPTeam = new JLabel("Team");
		lblNewLabelPTeam.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelPTeam.setBounds(250, 75, 70, 15);
		contentPane.add(lblNewLabelPTeam);

		JLabel lblNewLabelPOS = new JLabel("Position");
		lblNewLabelPOS.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelPOS.setBounds(250, 125, 70, 15);
		contentPane.add(lblNewLabelPOS);

		JLabel lblNewLabelPValue = new JLabel("Transfer Value");
		lblNewLabelPValue.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelPValue.setBounds(250, 175, 117, 15);
		contentPane.add(lblNewLabelPValue);

		textFieldPValue = new JTextField();
		textFieldPValue.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldPValue.setBounds(385, 173, 181, 19);
		contentPane.add(textFieldPValue);
		textFieldPValue.setColumns(10);

		textFieldPPos = new JTextField();
		textFieldPPos.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldPPos.setBounds(385, 123, 181, 19);
		contentPane.add(textFieldPPos);
		textFieldPPos.setColumns(10);

		textFieldPTeam = new JTextField();
		textFieldPTeam.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldPTeam.setBounds(385, 73, 181, 19);
		contentPane.add(textFieldPTeam);
		textFieldPTeam.setColumns(10);

		textFieldPName = new JTextField();
		textFieldPName.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldPName.setBounds(385, 23, 181, 19);
		contentPane.add(textFieldPName);
		textFieldPName.setColumns(10);

		JLabel lblNewLabelAge = new JLabel("Age");
		lblNewLabelAge.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelAge.setBounds(250, 225, 70, 15);
		contentPane.add(lblNewLabelAge);

		JLabel lblNewLabelCountry = new JLabel("Country");
		lblNewLabelCountry.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabelCountry.setBounds(250, 275, 70, 15);
		contentPane.add(lblNewLabelCountry);

		textFieldPAge = new JTextField();
		textFieldPAge.setBounds(385, 223, 181, 19);
		contentPane.add(textFieldPAge);
		textFieldPAge.setColumns(10);

		textFieldPCountry = new JTextField();
		textFieldPCountry.setBounds(385, 273, 181, 19);
		contentPane.add(textFieldPCountry);
		textFieldPCountry.setColumns(10);

		comboBoxPlayer1 = new JComboBox<String>();
		comboBoxPlayer1.setBounds(30, 299, 211, 24);
		comboBoxPlayer1.setEditable(false);
		comboBoxPlayer1.addItem("Choose..");
		inputcombobox1();
		contentPane.add(comboBoxPlayer1);

		JButton btnNewButtonShow = new JButton("Show");
		btnNewButtonShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connector c = new Connector();
				con=c.Database_Connector();
				try {
					String checkp=(String) comboBoxPlayer1.getSelectedItem();
					st= con.createStatement();
					String queryp="Select * from player_profile_ffl where Player_Name='"+checkp+"'";
					PreparedStatement p1 = con.prepareStatement(queryp);
					rs=p1.executeQuery();
					while(rs.next())
					{
						String  PName = rs.getString("Player_Name");
						textFieldPName.setText(PName);

						String PPos = rs.getString("Player_Position");
						textFieldPPos.setText(PPos);

						String PCountry = rs.getString("Player_Country");
						textFieldPCountry.setText(PCountry);

						int PAge = rs.getInt("Player_Age");
						String s=Integer.toString(PAge);
						textFieldPAge.setText(s);

						String PTeam = rs.getString("Player_Club");
						textFieldPTeam.setText(PTeam);

						int PValue = rs.getInt("Player_Values");
						String s1=Integer.toString(PValue);
						textFieldPValue.setText(s1);

					}
					p1.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButtonShow.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonShow.setBounds(307, 329, 117, 25);
		contentPane.add(btnNewButtonShow);
	}
	public void inputcombobox1()
	{
		Connector c = new Connector();
		con=c.Database_Connector();
		try {
			st= con.createStatement();
			String query="Select Player_Name from player_profile_ffl order by Player_Name ASC";
			PreparedStatement p = con.prepareStatement(query);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PName = rs.getString("Player_Name");
				comboBoxPlayer1.addItem(PName);
			}
			p.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

}