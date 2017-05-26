package fantasyfootball;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 5882661280975667416L;
	Connection con = null;
	Statement st = null;
	ResultSet rs =null;
	ResultSet rs1 = null;
	Statement st1 =null;
	private String t1,t2;
	private JPanel contentPane;
	private JTextField textFieldGoal1;
	private JTextField textFieldGoal2;
	private JTextField textFieldGoal3;
	private JTextField textFieldGoal4;
	private JTextField textFieldGoal5;
	private JTextField textFieldGoal6;
	private JTextField textFieldGoal7;
	private JTextField textFieldGoal8;
	private JTextField textFieldGoal9;
	private JTextField textFieldGoal10;
	private JTextField textFieldTeam1;
	private JTextField textFieldTeam2;
	private JComboBox<String> comboBoxTeam1;
	private JComboBox<String> comboBoxTeam2;
	private JComboBox<String> comboBoxPTeam1;
	private JComboBox<String> comboBoxPTeam2;
	private JButton btnNewButtonCancelChoice;
	private JButton btnNewButtonFinishSet;
	private String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;


	/**
	 * Create the frame.
	 */
	public Admin() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Admin Set Goal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldGoal1 = new JTextField();
		textFieldGoal1.setBounds(551, 74, 194, 19);
		contentPane.add(textFieldGoal1);
		textFieldGoal1.setColumns(10);

		textFieldGoal2 = new JTextField();
		textFieldGoal2.setBounds(551, 105, 194, 19);
		contentPane.add(textFieldGoal2);
		textFieldGoal2.setColumns(10);

		textFieldGoal3 = new JTextField();
		textFieldGoal3.setBounds(551, 140, 194, 19);
		contentPane.add(textFieldGoal3);
		textFieldGoal3.setColumns(10);

		textFieldGoal4 = new JTextField();
		textFieldGoal4.setBounds(551, 171, 194, 19);
		contentPane.add(textFieldGoal4);
		textFieldGoal4.setColumns(10);

		textFieldGoal5 = new JTextField();
		textFieldGoal5.setBounds(551, 202, 194, 19);
		contentPane.add(textFieldGoal5);
		textFieldGoal5.setColumns(10);

		textFieldGoal6 = new JTextField();
		textFieldGoal6.setBounds(551, 233, 194, 19);
		contentPane.add(textFieldGoal6);
		textFieldGoal6.setColumns(10);

		textFieldGoal7 = new JTextField();
		textFieldGoal7.setBounds(551, 262, 194, 19);
		contentPane.add(textFieldGoal7);
		textFieldGoal7.setColumns(10);

		textFieldGoal8 = new JTextField();
		textFieldGoal8.setBounds(551, 291, 194, 19);
		contentPane.add(textFieldGoal8);
		textFieldGoal8.setColumns(10);

		textFieldGoal9 = new JTextField();
		textFieldGoal9.setBounds(551, 323, 194, 19);
		contentPane.add(textFieldGoal9);
		textFieldGoal9.setColumns(10);

		textFieldGoal10 = new JTextField();
		textFieldGoal10.setBounds(551, 354, 194, 19);
		contentPane.add(textFieldGoal10);
		textFieldGoal10.setColumns(10);

		textFieldTeam1 = new JTextField();
		textFieldTeam1.setEditable(false);
		textFieldTeam1.setBounds(34, 202, 140, 19);
		contentPane.add(textFieldTeam1);
		textFieldTeam1.setColumns(10);

		textFieldTeam2 = new JTextField();
		textFieldTeam2.setEditable(false);
		textFieldTeam2.setBounds(34, 323, 140, 19);
		contentPane.add(textFieldTeam2);
		textFieldTeam2.setColumns(10);

		comboBoxPTeam1 = new JComboBox<String>();
		comboBoxPTeam1.setBounds(211, 199, 275, 24);
		comboBoxPTeam1.setEditable(false);
		comboBoxPTeam1.addItem("Choose..");
		inputcombobox1();
		contentPane.add(comboBoxPTeam1);

		comboBoxPTeam2 = new JComboBox<String>();
		comboBoxPTeam2.setBounds(211, 320, 275, 24);
		comboBoxPTeam2.setEditable(false);
		comboBoxPTeam2.addItem("Choose..");
		inputcombobox2();
		contentPane.add(comboBoxPTeam2);


		comboBoxTeam1 = new JComboBox<String>();
		comboBoxTeam1.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxTeam1.setBounds(34, 69, 223, 24);
		comboBoxTeam1.setEditable(false);
		comboBoxTeam1.addItem("Choose..");
		comboBoxTeam1.addItem("Arsenal ");
		comboBoxTeam1.addItem("Chelsea");
		comboBoxTeam1.addItem("Everton");
		comboBoxTeam1.addItem("Liverpool");
		comboBoxTeam1.addItem("Manchester United");
		comboBoxTeam1.addItem("Manchester City");
		comboBoxTeam1.addItem("Tottenham");
		contentPane.add(comboBoxTeam1);

		comboBoxTeam2 = new JComboBox<String>();
		comboBoxTeam2.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxTeam2.setBounds(288, 69, 216, 24);
		comboBoxTeam2.setEditable(false);
		comboBoxTeam2.addItem("Choose..");
		comboBoxTeam2.addItem("Arsenal ");
		comboBoxTeam2.addItem("Chelsea");
		comboBoxTeam2.addItem("Everton");
		comboBoxTeam2.addItem("Liverpool");
		comboBoxTeam2.addItem("Manchester United");
		comboBoxTeam2.addItem("Manchester City");
		comboBoxTeam2.addItem("Tottenham");
		contentPane.add(comboBoxTeam2);

		JButton btnNewButtonChooseTeam = new JButton("Choose Team");
		btnNewButtonChooseTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tt=(String)comboBoxTeam1.getSelectedItem();
				String tt1=(String)comboBoxTeam2.getSelectedItem();
				textFieldTeam1.setText(tt);
				textFieldTeam2.setText(tt1);
				t1 = textFieldTeam1.getText();
				t2 = textFieldTeam2.getText();
				inputcombobox1();

				inputcombobox2();

				}
		});
		btnNewButtonChooseTeam.setBounds(34, 102, 140, 25);
		contentPane.add(btnNewButtonChooseTeam);

		JButton btnNewButtonChooseP1 = new JButton("Set Goal");
		btnNewButtonChooseP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldGoal1.getText().equals("") && textFieldGoal2.getText().equals("") && textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
					&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal1.setText(tt);
				}
				else if(textFieldGoal2.getText().equals("") && textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
						&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal2.setText(tt);
				}
				else if(textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
						&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal3.setText(tt);
				}
				else if(textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
						&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal4.setText(tt);
				}
				else if(textFieldGoal5.getText().equals("") && textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal5.setText(tt);
				}
				else if(textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal6.setText(tt);
				}
				else if(textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal7.setText(tt);
				}
				else if(textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal8.setText(tt);
				}
				else if(textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal9.setText(tt);
				}
				else if(textFieldGoal10.getText().equals(""))
				{
					String tt=(String)comboBoxPTeam1.getSelectedItem();
					textFieldGoal10.setText(tt);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Goal Already Set");
				}

			}
		});
		btnNewButtonChooseP1.setBounds(34, 230, 117, 25);
		contentPane.add(btnNewButtonChooseP1);

		JButton btnNewButtonChooseP2 = new JButton("Set Goal");
		btnNewButtonChooseP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldGoal1.getText().equals("") && textFieldGoal2.getText().equals("") && textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
						&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal1.setText(tt);
					}
					else if(textFieldGoal2.getText().equals("") && textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
							&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal2.setText(tt);
					}
					else if(textFieldGoal3.getText().equals("") && textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
							&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal3.setText(tt);
					}
					else if(textFieldGoal4.getText().equals("") && textFieldGoal5.getText().equals("")
							&& textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal4.setText(tt);
					}
					else if(textFieldGoal5.getText().equals("") && textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal5.setText(tt);
					}
					else if(textFieldGoal6.getText().equals("") && textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal6.setText(tt);
					}
					else if(textFieldGoal7.getText().equals("") && textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal7.setText(tt);
					}
					else if(textFieldGoal8.getText().equals("") && textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal8.setText(tt);
					}
					else if(textFieldGoal9.getText().equals("") && textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal9.setText(tt);
					}
					else if(textFieldGoal10.getText().equals(""))
					{
						String tt=(String)comboBoxPTeam2.getSelectedItem();
						textFieldGoal10.setText(tt);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Goal Already Set");
					}
			}
		});
		btnNewButtonChooseP2.setBounds(34, 354, 117, 25);
		contentPane.add(btnNewButtonChooseP2);

		btnNewButtonCancelChoice = new JButton("Cancel Choice");
		btnNewButtonCancelChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
				ad.setVisible(true);
			}
		});
		btnNewButtonCancelChoice.setBounds(186, 102, 151, 25);
		contentPane.add(btnNewButtonCancelChoice);

		btnNewButtonFinishSet = new JButton("Finish");
		btnNewButtonFinishSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connector c = new Connector();
				con=c.Database_Connector();
				g1=textFieldGoal1.getText();
				g2=textFieldGoal2.getText();
				g3=textFieldGoal3.getText();
				g4=textFieldGoal4.getText();
				g5=textFieldGoal5.getText();
				g6=textFieldGoal6.getText();
				g7=textFieldGoal7.getText();
				g8=textFieldGoal8.getText();
				g9=textFieldGoal9.getText();
				g10=textFieldGoal10.getText();
				/*g1="1";
				g2="2";
				g3="3";
				g4="4";
				g5="5";
				g6="6";
				g7="7";
				g8="8";
				g9="9";
				g10="10";*/
				try {

					//String query=
					String query1="SELECT Team_Name FROM team WHERE (Player1='"+g1+"' or Player1='"+g2+"' or Player1='"+g3+"' or Player1='"+g4+"' or Player1='"+g5+"' or Player1='"+g6+"' or Player1='"+g7+"' or Player1='"+g8+"' or Player1='"+g9+"' or Player1='"+g10+"') "
							+ "or (Player2='"+g1+"' or Player2='"+g2+"' or Player2='"+g3+"' or Player2='"+g4+"' or Player2='"+g5+"' or Player2='"+g6+"' or Player2='"+g7+"' or Player2='"+g8+"' or Player2='"+g9+"' or Player2='"+g10+"') "
									+ "or (Player3='"+g1+"' or Player3='"+g2+"' or Player3='"+g3+"' or Player3='"+g4+"' or Player3='"+g5+"' or Player3='"+g6+"' or Player3='"+g7+"' or Player3='"+g8+"' or Player3='"+g9+"' or Player3='"+g10+"') "
												+ "or (Player4='"+g1+"' or Player4='"+g2+"' or Player4='"+g3+"' or Player4='"+g4+"' or Player4='"+g5+"' or Player4='"+g6+"' or Player4='"+g7+"' or Player4='"+g8+"' or Player4='"+g9+"' or Player4='"+g10+"') "
															+ "or (Player5='"+g1+"' or Player5='"+g2+"' or Player5='"+g3+"' or Player5='"+g4+"' or Player5='"+g5+"' or Player5='"+g6+"' or Player5='"+g7+"' or Player5='"+g8+"' or Player5='"+g9+"' or Player5='"+g10+"') "
																	+ "or (Player6='"+g1+"' or Player6='"+g2+"' or Player6='"+g3+"' or Player6='"+g4+"' or Player6='"+g5+"' or Player6='"+g6+"' or Player6='"+g7+"' or Player6='"+g8+"' or Player6='"+g9+"' or Player6='"+g10+"') "
																			+ "or (Player7='"+g1+"' or Player7='"+g2+"' or Player7='"+g3+"' or Player7='"+g4+"' or Player7='"+g5+"' or Player7='"+g6+"' or Player7='"+g7+"' or Player7='"+g8+"' or Player7='"+g9+"' or Player7='"+g10+"') "
																					+ "or (Player8='"+g1+"' or Player8='"+g2+"' or Player8='"+g3+"' or Player8='"+g4+"' or Player8='"+g5+"' or Player8='"+g6+"' or Player8='"+g7+"' or Player8='"+g8+"' or Player8='"+g9+"' or Player8='"+g10+"') "
																							+ "or (Player9='"+g1+"' or Player9='"+g2+"' or Player9='"+g3+"' or Player9='"+g4+"' or Player1='"+g5+"' or Player9='"+g6+"' or Player9='"+g7+"' or Player9='"+g8+"' or Player9='"+g9+"' or Player9='"+g10+"') "
																									+ "or (Player10='"+g1+"' or Player10='"+g2+"' or Player10='"+g3+"' or Player10='"+g4+"' or Player10='"+g5+"' or Player10='"+g6+"' or Player10='"+g7+"' or Player10='"+g8+"' or Player10='"+g9+"' or Player10='"+g10+"') "
																											+ "or (Player11='"+g1+"' or Player11='"+g2+"' or Player11='"+g3+"' or Player11='"+g4+"' or Player11='"+g5+"' or Player11='"+g6+"' or Player11='"+g7+"' or Player11='"+g8+"' or Player11='"+g9+"' or Player11='"+g10+"')";

					st=con.createStatement();

					PreparedStatement p1 = con.prepareStatement(query1);

					rs=p1.executeQuery();
					while(rs.next())
					{
						String result=rs.getString("Team_Name");
						JOptionPane.showMessageDialog(null, result);
					}

					JOptionPane.showMessageDialog(null,"Success");
					p1.close();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButtonFinishSet.setBounds(288, 421, 117, 25);
		contentPane.add(btnNewButtonFinishSet);
	}

	public void inputcombobox1()
	{

		//t1="Arsenal";
		Connector c = new Connector();
		con=c.Database_Connector();
		try {
			st= con.createStatement();
			String query="Select Concat(Player_Name,' (',Player_Position ,')','(',Player_Club,')') as 'Player_ClubName' from player_profile_ffl where Player_Club='"+t1+"' order by Player_ClubName ASC";
			PreparedStatement p = con.prepareStatement(query);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PName = rs.getString("Player_ClubName");
				comboBoxPTeam1.addItem(PName);
			}
			contentPane.repaint();
			p.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}
	public void inputcombobox2()
	{

		//t2="Chelsea";
		Connector c = new Connector();
		con=c.Database_Connector();
		try {
			st= con.createStatement();
			String query="Select Concat(Player_Name,' (',Player_Position ,')','(',Player_Club,')') as 'Player_ClubName' from player_profile_ffl where Player_Club='"+t2+"' order by Player_ClubName ASC";
			PreparedStatement p = con.prepareStatement(query);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PName = rs.getString("Player_ClubName");
				comboBoxPTeam2.addItem(PName);
			}

			p.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}
}
