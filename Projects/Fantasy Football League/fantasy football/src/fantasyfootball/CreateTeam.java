package fantasyfootball;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CreateTeam extends JFrame {

	/**
	 *
	 */
	private String PValuein;
	private String PlayerVal;
	private int total,p,z;
	private String u;
	Connection con =null;
	Statement st =null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Statement st1 =null;
	private static final long serialVersionUID = 8414364845961600547L;
	protected static final String Connector = null;
	private JPanel contentPane;
	private JTextField textFieldTeamName;
	private JTextField textFieldGK;
	private JTextField textFieldDef1;
	private JTextField textFieldDef2;
	private JTextField textFieldDef3;
	private JTextField textFieldDef4;
	private JTextField textFieldMid1;
	private JTextField textFieldMid2;
	private JTextField textFieldMid3;
	private JTextField textFieldMid4;
	private JTextField textFieldAtk1;
	private JTextField textFieldAtk2;
	private JLabel lblNewLabelSelectPlayer;
	private JButton btnNewButtonCancel2;
	private JButton btnNewButtonFinish1;
	private JButton btnNewButtonChoose;
	private JComboBox<String> comboBoxPosition;
	private JComboBox<String> comboBoxPlayer;
	private JLabel lblNewLabelPosition;
	private JTextField textFieldPlayerValue;
	private JTextField textFieldBalance1;
	private String initTMoney="200000000";
	private String TMoney;
	private String outMoney;
	private JButton RemoveGK;
    private JButton RemoveDF2;
    private JButton RemoveDF1;
    private JButton RemoveDF3;
    private JButton RemoveDF4;
    private JButton RemoveMF1;
    private JButton RemoveMF2;
    private JButton RemoveMF3;
    private JButton RemoveMF4;
    private JButton RemoveCF1;
    private JButton RemoveCF2;

	/**
	 * Create the frame.
	 */
	public CreateTeam(String username) {
		u=username;
		TMoney=initTMoney;
		setFont(new Font("Comfortaa", Font.BOLD, 14));
		setTitle("Create Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxPlayer = new JComboBox<String>();
		comboBoxPlayer.setMaximumRowCount(10);
		comboBoxPlayer.setEditable(false);
		comboBoxPlayer.setFont(new Font("Dialog", Font.BOLD, 13));
		comboBoxPlayer.setBounds(23, 205, 320, 24);
		comboBoxPlayer.addItem("Choose..");
		inputcombobox();

		contentPane.add(comboBoxPlayer);

		JLabel lblNewLabelTName = new JLabel("Team Name");
		lblNewLabelTName.setBounds(39, 25, 90, 15);
		contentPane.add(lblNewLabelTName);

		textFieldTeamName = new JTextField();
		textFieldTeamName.setBounds(147, 23, 176, 19);
		contentPane.add(textFieldTeamName);
		textFieldTeamName.setColumns(10);

		JLabel lblNewLabelGK = new JLabel("Goalkeeper");
		lblNewLabelGK.setBounds(361, 50, 93, 15);
		contentPane.add(lblNewLabelGK);

		JLabel lblNewLabelDef1 = new JLabel("Defender 1");
		lblNewLabelDef1.setBounds(361, 90, 93, 15);
		contentPane.add(lblNewLabelDef1);

		JLabel lblNewLabelDef2 = new JLabel("Defender 2");
		lblNewLabelDef2.setBounds(361, 130, 93, 15);
		contentPane.add(lblNewLabelDef2);

		JLabel lblNewLabelDef3 = new JLabel("Defender 3");
		lblNewLabelDef3.setBounds(361, 170, 93, 15);
		contentPane.add(lblNewLabelDef3);

		JLabel lblNewLabelDef4 = new JLabel("Defender 4");
		lblNewLabelDef4.setBounds(361, 210, 93, 15);
		contentPane.add(lblNewLabelDef4);

		JLabel lblNewLabelMid1 = new JLabel("Midfielder 1");
		lblNewLabelMid1.setBounds(361, 250, 93, 15);
		contentPane.add(lblNewLabelMid1);

		JLabel lblNewLabelMid2 = new JLabel("Midfielder 2");
		lblNewLabelMid2.setBounds(361, 290, 93, 15);
		contentPane.add(lblNewLabelMid2);

		JLabel lblNewLabelMid3 = new JLabel("Midfielder 3");
		lblNewLabelMid3.setBounds(361, 330, 93, 15);
		contentPane.add(lblNewLabelMid3);

		JLabel lblNewLabelMid4 = new JLabel("Midfielder 4");
		lblNewLabelMid4.setBounds(361, 370, 93, 15);
		contentPane.add(lblNewLabelMid4);

		JLabel lblNewLabelAtk1 = new JLabel("Attacker 1");
		lblNewLabelAtk1.setBounds(361, 410, 93, 15);
		contentPane.add(lblNewLabelAtk1);

		JLabel lblNewLabelAtk2 = new JLabel("Attacker 2");
		lblNewLabelAtk2.setBounds(361, 450, 93, 15);
		contentPane.add(lblNewLabelAtk2);

		textFieldGK = new JTextField();
		textFieldGK.setBounds(472, 50, 250, 19);
		contentPane.add(textFieldGK);
		textFieldGK.setText("Choose..");
		textFieldGK.setEditable(false);
		textFieldGK.setColumns(10);

		textFieldDef1 = new JTextField();
		textFieldDef1.setBounds(472, 88, 250, 19);
		textFieldDef1.setText("Choose..");
		textFieldDef1.setEditable(false);
		contentPane.add(textFieldDef1);
		textFieldDef1.setColumns(10);

		textFieldDef2 = new JTextField();
		textFieldDef2.setBounds(472, 128, 250, 19);
		textFieldDef2.setText("Choose..");
		textFieldDef2.setEditable(false);
		contentPane.add(textFieldDef2);
		textFieldDef2.setColumns(10);

		textFieldDef3 = new JTextField();
		textFieldDef3.setBounds(472, 168, 250, 19);
		textFieldDef3.setText("Choose..");
		textFieldDef3.setEditable(false);
		contentPane.add(textFieldDef3);
		textFieldDef3.setColumns(10);

		textFieldDef4 = new JTextField();
		textFieldDef4.setBounds(472, 208, 250, 19);
		textFieldDef4.setText("Choose..");
		textFieldDef4.setEditable(false);
		contentPane.add(textFieldDef4);
		textFieldDef4.setColumns(10);

		textFieldMid1 = new JTextField();
		textFieldMid1.setBounds(472, 248, 250, 19);
		textFieldMid1.setText("Choose..");
		textFieldMid1.setEditable(false);
		contentPane.add(textFieldMid1);
		textFieldMid1.setColumns(10);

		textFieldMid2 = new JTextField();
		textFieldMid2.setBounds(472, 288, 250, 19);
		textFieldMid2.setText("Choose..");
		textFieldMid2.setEditable(false);
		contentPane.add(textFieldMid2);
		textFieldMid2.setColumns(10);

		textFieldMid3 = new JTextField();
		textFieldMid3.setBounds(472, 328, 250, 19);
		textFieldMid3.setText("Choose..");
		textFieldMid3.setEditable(false);
		contentPane.add(textFieldMid3);
		textFieldMid3.setColumns(10);

		textFieldMid4 = new JTextField();
		textFieldMid4.setBounds(472, 368, 250, 19);
		textFieldMid4.setText("Choose..");
		textFieldMid4.setEditable(false);
		contentPane.add(textFieldMid4);
		textFieldMid4.setColumns(10);

		textFieldAtk1 = new JTextField();
		textFieldAtk1.setBounds(472, 408, 250, 19);
		textFieldAtk1.setText("Choose..");
		textFieldAtk1.setEditable(false);
		contentPane.add(textFieldAtk1);
		textFieldAtk1.setColumns(10);

		textFieldAtk2 = new JTextField();
		textFieldAtk2.setBounds(472, 448, 250, 19);
		textFieldAtk2.setText("Choose..");
		textFieldAtk2.setEditable(false);
		contentPane.add(textFieldAtk2);
		textFieldAtk2.setColumns(10);

		lblNewLabelSelectPlayer = new JLabel("Select Player");
		lblNewLabelSelectPlayer.setBounds(23, 184, 102, 15);
		contentPane.add(lblNewLabelSelectPlayer);

		btnNewButtonCancel2 = new JButton("Cancel");
		btnNewButtonCancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryd="Delete from user_info where Username='"+u+"'";
				try {
					st=con.createStatement();
					PreparedStatement pd=con.prepareStatement(queryd);
					pd.execute();
					pd.close();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,"Returning to MainWindow");
					MainWindow m=new MainWindow();
					m.mainFrame.setVisible(true);
					e2.printStackTrace();
				}

				dispose();
				MainWindow window = new MainWindow();
				window.mainFrame.setVisible(true);
			}
		});
		btnNewButtonCancel2.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButtonCancel2.setBounds(361, 501, 117, 25);
		contentPane.add(btnNewButtonCancel2);

		btnNewButtonFinish1 = new JButton("Finish");
		btnNewButtonFinish1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				Connector c = new Connector();
				con=c.Database_Connector();
				if(textFieldGK.getText().equals("Choose..")||textFieldDef1.getText().equals("Choose..")||textFieldDef2.getText().equals("Choose..")
						||textFieldDef3.getText().equals("Choose..")||textFieldDef4.getText().equals("Choose..")||textFieldMid1.getText().equals("Choose..")
						||textFieldMid2.getText().equals("Choose..")||textFieldMid3.getText().equals("Choose..")||textFieldMid4.getText().equals("Choose..")
						||textFieldAtk1.getText().equals("Choose..")||textFieldAtk2.getText().equals("Choose.."))
				{
						JOptionPane.showMessageDialog(null, "Please Insert All Fields");
				}
				else
				{
				try {
					outMoney=textFieldBalance1.getText();
					st=con.createStatement();
					String query1="INSERT INTO team (Username,Team_Name,Player1,Player2,Player3,Player4,Player5,Player6,Player7,Player8,Player9,Player10,Player11) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					String query2="UPDATE user_info set Transfer_Balance='"+outMoney+"' where Username='"+u+"'";




					PreparedStatement p1 = con.prepareStatement(query1);
					p1.setString(1,u);
					p1.setString(2,textFieldTeamName.getText());
					p1.setString(3,textFieldGK.getText());
					p1.setString(4,textFieldDef1.getText());
					p1.setString(5,textFieldDef2.getText());
					p1.setString(6,textFieldDef3.getText());
					p1.setString(7,textFieldDef4.getText());
					p1.setString(8,textFieldMid1.getText());
					p1.setString(9,textFieldMid2.getText());
					p1.setString(10,textFieldMid3.getText());
					p1.setString(11,textFieldMid4.getText());
					p1.setString(12,textFieldAtk1.getText());
					p1.setString(13,textFieldAtk2.getText());

					p1.execute();
					JOptionPane.showMessageDialog(null,"Success");
					p1.close();
					PreparedStatement p2 = con.prepareStatement(query2);
					//System.out.println(outMoney);
					//p2.setString(1,outMoney);
					p2.execute();
					p2.close();
					dispose();
					MainWindow m=new MainWindow();
					m.mainFrame.setVisible(true);
				} catch (Exception e1) {
						e1.printStackTrace();
				}
				}
			}
		});
		btnNewButtonFinish1.setBounds(576, 501, 117, 25);
		contentPane.add(btnNewButtonFinish1);

		btnNewButtonChoose = new JButton("Choose");
		btnNewButtonChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x =(String)comboBoxPlayer.getSelectedItem();
				if(textFieldGK.getText().equals(x)||textFieldDef1.getText().equals(x)||textFieldDef2.getText().equals(x)||textFieldDef3.getText().equals(x)||textFieldDef4.getText().equals(x)
						||textFieldMid1.getText().equals(x)||textFieldMid2.getText().equals(x)||textFieldMid3.getText().equals(x)||textFieldMid4.getText().equals(x)
						||textFieldAtk1.getText().equals(x)||textFieldAtk2.getText().equals(x))
				{
					JOptionPane.showMessageDialog(null, "Please Insert a Different Player");
				}
				else{
				if(comboBoxPosition.getSelectedItem()==lblNewLabelGK.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldGK.getText().equals("Choose.."))
					{
						textFieldGK.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}

				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelDef1.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldDef1.getText().equals("Choose.."))
					{
						textFieldDef1.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelDef2.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldDef2.getText().equals("Choose.."))
					{
						textFieldDef2.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelDef3.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldDef3.getText().equals("Choose.."))
					{
						textFieldDef3.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelDef4.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldDef4.getText().equals("Choose.."))
					{
						textFieldDef4.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelMid1.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldMid1.getText().equals("Choose.."))
					{
						textFieldMid1.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelMid2.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldMid2.getText().equals("Choose.."))
					{
						textFieldMid2.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelMid3.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldMid3.getText().equals("Choose.."))
					{
						textFieldMid3.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelMid4.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldMid4.getText().equals("Choose.."))
					{
						textFieldMid4.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelAtk1.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldAtk1.getText().equals("Choose.."))
					{
						textFieldAtk1.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else if(comboBoxPosition.getSelectedItem()==lblNewLabelAtk2.getText() && !textFieldPlayerValue.getText().equals(""))
				{
					if(textFieldAtk2.getText().equals("Choose.."))
					{
						textFieldAtk2.setText((String) comboBoxPlayer.getSelectedItem());
						add();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Remove Player First");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Choose a Positon and Player/Press Show Button for Player Value");
				}
				}

			}
		});
		btnNewButtonChoose.setBounds(23, 501, 117, 25);
		contentPane.add(btnNewButtonChoose);

		comboBoxPosition = new JComboBox<String>();
		comboBoxPosition.setMaximumRowCount(10);
		comboBoxPosition.setFont(new Font("Dialog", Font.BOLD, 13));
		comboBoxPosition.setBounds(23, 445, 320, 24);
		comboBoxPosition.setEditable(false);
		comboBoxPosition.addItem("Choose..");
		comboBoxPosition.addItem("Attacker 1");
		comboBoxPosition.addItem("Attacker 2");
		comboBoxPosition.addItem("Defender 1");
		comboBoxPosition.addItem("Defender 2");
		comboBoxPosition.addItem("Defender 3");
		comboBoxPosition.addItem("Defender 4");
		comboBoxPosition.addItem("Goalkeeper");
		comboBoxPosition.addItem("Midfielder 1");
		comboBoxPosition.addItem("Midfielder 2");
		comboBoxPosition.addItem("Midfielder 3");
		comboBoxPosition.addItem("Midfielder 4");
		contentPane.add(comboBoxPosition);

		lblNewLabelPosition = new JLabel("Position");
		lblNewLabelPosition.setBounds(25, 410, 70, 15);
		contentPane.add(lblNewLabelPosition);

		textFieldPlayerValue = new JTextField();
		textFieldPlayerValue.setBounds(23, 310, 320, 19);
		textFieldPlayerValue.setColumns(10);
		textFieldPlayerValue.setEditable(false);
		contentPane.add(textFieldPlayerValue);


		textFieldBalance1 = new JTextField();
		textFieldBalance1.setText(TMoney);
		textFieldBalance1.setBounds(147, 65, 176, 19);
		contentPane.add(textFieldBalance1);
		textFieldBalance1.setColumns(10);
		textFieldBalance1.setEditable(false);



		JLabel lblNewLabelPlayerValue = new JLabel("Player Value");
		lblNewLabelPlayerValue.setBounds(23, 283, 117, 15);
		contentPane.add(lblNewLabelPlayerValue);

		JLabel lblNewLabelBalance = new JLabel("Balance");
		lblNewLabelBalance.setBounds(39, 67, 70, 15);
		contentPane.add(lblNewLabelBalance);

		JButton btnNewButtonValue = new JButton("Show");
		btnNewButtonValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outPValue();
			}
		});
		btnNewButtonValue.setBounds(23, 341, 117, 25);
		contentPane.add(btnNewButtonValue);
		String c="Choose..";
		RemoveGK = new JButton("");
		RemoveGK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldGK.setText(c);
				remove();
			}
		});

		RemoveGK.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveGK.setBounds(729, 50, 15, 15);
		contentPane.add(RemoveGK);

		RemoveDF2 = new JButton("");
		RemoveDF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDef2.setText(c);
				remove();
			}
		});
		RemoveDF2.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveDF2.setBounds(729, 132, 15, 15);
		contentPane.add(RemoveDF2);

		RemoveDF1 = new JButton("");
		RemoveDF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textFieldDef1.setText(c);
				remove();
			}
		});
		RemoveDF1.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveDF1.setBounds(729, 90, 15, 15);
		contentPane.add(RemoveDF1);

		RemoveDF3 = new JButton("");
		RemoveDF3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textFieldDef3.setText(c);
				remove();
			}
		});
		RemoveDF3.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveDF3.setBounds(729, 166, 15, 15);
		contentPane.add(RemoveDF3);

		RemoveDF4 = new JButton("");
		RemoveDF4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textFieldDef4.setText(c);
				remove();
			}
		});
		RemoveDF4.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveDF4.setBounds(729, 210, 15, 15);
		contentPane.add(RemoveDF4);

		RemoveMF1 = new JButton("");
		RemoveMF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMid1.setText(c);
				remove();
			}
		});
		RemoveMF1.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveMF1.setBounds(729, 250, 15, 15);
		contentPane.add(RemoveMF1);

		RemoveMF2 = new JButton("");
		RemoveMF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMid2.setText(c);
				remove();
			}
		});
		RemoveMF2.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveMF2.setBounds(729, 286, 15, 15);
		contentPane.add(RemoveMF2);

		RemoveMF3 = new JButton("");
		RemoveMF3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMid3.setText(c);
				remove();
			}
		});
		RemoveMF3.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveMF3.setBounds(729, 330, 15, 15);
		contentPane.add(RemoveMF3);

		RemoveMF4 = new JButton("");
		RemoveMF4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMid4.setText(c);
				remove();
			}
		});
		RemoveMF4.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveMF4.setBounds(729, 370, 15, 15);
		contentPane.add(RemoveMF4);

		RemoveCF1 = new JButton("");
		RemoveCF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAtk1.setText(c);
				remove();
			}
		});
		RemoveCF1.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveCF1.setBounds(729, 410, 15, 15);
		contentPane.add(RemoveCF1);

		RemoveCF2 = new JButton("");
		RemoveCF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAtk2.setText(c);
				remove();
			}
		});
		RemoveCF2.setIcon(new ImageIcon("/home/zubair/eclipse/workspace/Fantasy Football/src/remove.png"));
		RemoveCF2.setBounds(729, 446, 15, 15);
		contentPane.add(RemoveCF2);

		JLabel labelImage2 = new JLabel("");
		Image ctimg = new ImageIcon(getClass().getResource("/barclays-premier-league-logo-wallpaper-2014-2015.jpg")).getImage();
		labelImage2.setIcon(new ImageIcon(ctimg));
		labelImage2.setBounds(0, 0, 800, 565);
		getContentPane().add(labelImage2);

	}
	public void inputcombobox()
	{
		Connector c = new Connector();
		con=c.Database_Connector();
		try {
			st= con.createStatement();
			String query="Select Concat(Player_Name,' (',Player_Position ,')','(',Player_Club,')') as 'Player_ClubName' from player_profile_ffl order by Player_ClubName ASC";
			PreparedStatement p = con.prepareStatement(query);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PName = rs.getString("Player_ClubName");
				comboBoxPlayer.addItem(PName);
			}
			p.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}
	public void outPValue()
	{

		try {
			String pn=(String) comboBoxPlayer.getSelectedItem();
			st= con.createStatement();
			String query1="Select Player_Values from player_profile_ffl where (Select Concat(Player_Name,' (',Player_Position ,')','(',Player_Club,')') as 'Player_ClubName')='"+pn+"'";
			PreparedStatement p = con.prepareStatement(query1);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PValue = rs.getString("Player_Values");
				//System.out.println(PValue);
				PValuein=PValue;
				textFieldPlayerValue.setText(PValue);
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public int conIntPValue()
	{
		return Integer.parseInt(PValuein);
	}
	public int conIntTMoney()
	{
		return Integer.parseInt(textFieldBalance1.getText());
	}
	public void delPValue()
	{
		try {
			String pn=(String) comboBoxPlayer.getSelectedItem();
			st= con.createStatement();
			String query1="Select Player_Values from player_profile_ffl where (Select Concat(Player_Name,' (',Player_Position ,')','(',Player_Club,')') as 'Player_ClubName')='"+pn+"'";
			PreparedStatement p = con.prepareStatement(query1);
			rs=p.executeQuery();

			while(rs.next())
			{
				String PValue = rs.getString("Player_Values");
				PlayerVal=PValue;
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void add()
	{

		p=conIntPValue();
		total=conIntTMoney();
		if(total<p)
		{
			JOptionPane.showMessageDialog(null, "Exceeded Transfer Balance");
		}
		else
		{
			z=total-p;
			TMoney=(Integer.toString(z));
			textFieldBalance1.setText(TMoney);
		}
	}
	public void remove()
	{
		delPValue();
		p=Integer.parseInt(PlayerVal);
		total=conIntTMoney();
		z=total+p;
		TMoney=(Integer.toString(z));
		textFieldBalance1.setText(TMoney);
	}

}
