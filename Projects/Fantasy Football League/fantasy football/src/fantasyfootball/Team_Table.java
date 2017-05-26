package fantasyfootball;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class Team_Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Connection con=null;
	Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    private JTable Team_Ranking;

	public Team_Table() {
		setTitle("Team Rankings");
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Team_Ranking= new JTable();
		Team_Ranking.setBackground(Color.WHITE);
		Team_Ranking.setBounds(0, 0, 245, 561);
		contentPane.add(Team_Ranking);

		JButton btnShowTable = new JButton("Show Team Ranking");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
				Connector c= new Connector();
				con=c.Database_Connector();
				st= con.createStatement();
				String query="SELECT Team_Name, 3*(Player1GS + Player2GS + Player3GS + Player4GS + Player5GS + Player6GS + Player7GS  + Player8GS + Player9GS + Player10GS + Player11GS) AS Total_Points FROM `team` ORDER BY Total_Points DESC ";

				ps = con.prepareStatement(query);

				rs=ps.executeQuery();

				Team_Ranking.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception e1)
			 {

				e1.printStackTrace();
			 }
			}
		});
		btnShowTable.setBounds(255, 254, 188, 23);
		contentPane.add(btnShowTable);

		JButton btnNewButtonBack = new JButton("Back");
		btnNewButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//MainWindow m=new MainWindow();
				//m.mainFrame.setVisible(true);
			}
		});
		btnNewButtonBack.setBounds(257, 289, 186, 25);
		contentPane.add(btnNewButtonBack);
	}
}