package fantasyfootball;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame {

	/**
	 *
	 */

	String usr;
	String pass;
	Connection con =null;
	Statement st =null;
	ResultSet rs = null;
	private static final long serialVersionUID = 6169784536741518995L;
	private JPanel contentPane;
	private JTextField textFieldUsr;
	private JPasswordField passwordFieldPass;



	/**
	 * Create the frame.
	 */

	public Login() {
		setFont(new Font("Comfortaa", Font.PLAIN, 16));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButtonLogin1 = new JButton("Login");
		btnNewButtonLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connector c = new Connector();
					con=c.Database_Connector();
					st= con.createStatement();
					usr=textFieldUsr.getText();
					pass=String.valueOf(passwordFieldPass.getPassword());


					String query="SELECT Username,Password from user_info " +
			                   "where Username='"+usr+"' and Password='"+pass+"'";

					PreparedStatement pat = con.prepareStatement(query);

					rs = pat.executeQuery();
					//JOptionPane.showMessageDialog(null,"Query Success");

					;
					int count=0;
					while(rs.next())
					{
						count = count+1;

					}
					if(count == 1)
					{
						if(!usr.equals("admin"))
						{
							JOptionPane.showMessageDialog(null,"Login Success");
							dispose();
							//System.out.println(usr);
							User_Profile up = new User_Profile(usr);
							up.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Login Success");
							dispose();
							Admin ad = new Admin();
							ad.setVisible(true);
						}
					}else if(count > 1)
					{
						JOptionPane.showMessageDialog(null,"Same Username Password");

					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username or Password Incorrect Try Again");

					}

					rs.close();
					pat.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});
		btnNewButtonLogin1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButtonLogin1.setBounds(145, 260, 117, 25);
		contentPane.add(btnNewButtonLogin1);

		JButton btnNewButtonCancel = new JButton("Cancel");
		btnNewButtonCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButtonCancel.setBounds(376, 260, 117, 25);
		contentPane.add(btnNewButtonCancel);
		btnNewButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainWindow window = new MainWindow();
				window.mainFrame.setVisible(true);
			}
		});

		textFieldUsr = new JTextField();
		textFieldUsr.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldUsr.setBounds(260, 66, 180, 40);
		contentPane.add(textFieldUsr);
		textFieldUsr.setColumns(10);

		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordFieldPass.setBounds(260, 117, 180, 40);
		contentPane.add(passwordFieldPass);

		JLabel lblNewLabelUsr = new JLabel("UserName");
		lblNewLabelUsr.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelUsr.setBounds(111, 73, 105, 28);
		contentPane.add(lblNewLabelUsr);

		JLabel lblNewLabelPass = new JLabel("Password");
		lblNewLabelPass.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelPass.setBounds(111, 129, 105, 28);
		contentPane.add(lblNewLabelPass);

	}

}
