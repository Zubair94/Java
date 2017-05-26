package fantasyfootball;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	/**
	 *
	 */

	Connection con =null;
	Statement st =null;
	ResultSet rs = null;
	String usrname;
	private static final long serialVersionUID = 9139229929500509119L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUSR;
	private JTextField textFieldEmail;
	private JTextField textFieldAge;
	private JPasswordField passwordField1;
	private JPasswordField passwordFieldconfirm;



	/**
	 * Create the frame.
	 */
	public SignUp() {
		setFont(new Font("Comfortaa", Font.BOLD, 14));
		setTitle("Sign Up to Fantasy Football League");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldName.setBounds(355, 44, 330, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldUSR = new JTextField();
		textFieldUSR.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldUSR.setBounds(355, 92, 330, 24);
		contentPane.add(textFieldUSR);
		textFieldUSR.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldEmail.setBounds(355, 137, 330, 24);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldAge = new JTextField();
		textFieldAge.setBounds(355, 179, 114, 24);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);

		JComboBox<String> comboBoxGender = new JComboBox<String>();
		comboBoxGender.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxGender.setBounds(355, 221, 114, 24);

		comboBoxGender.setEditable(false);
		comboBoxGender.addItem("Choose..");
		comboBoxGender.addItem("Male");
		comboBoxGender.addItem("Female");
		contentPane.add(comboBoxGender);

		JComboBox<String> comboBoxfTeam = new JComboBox<String>();
		comboBoxfTeam.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxfTeam.setBounds(355, 264, 330, 24);
		comboBoxfTeam.setEditable(false);
		comboBoxfTeam.addItem("Choose..");
		comboBoxfTeam.addItem("Arsenal ");
		comboBoxfTeam.addItem("Chelsea");
		comboBoxfTeam.addItem("Everton");
		comboBoxfTeam.addItem("Liverpool");
		comboBoxfTeam.addItem("Manchester United");
		comboBoxfTeam.addItem("Manchester City");
		comboBoxfTeam.addItem("Tottenham");
		contentPane.add(comboBoxfTeam);

		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordField1.setBounds(355, 308, 330, 24);
		contentPane.add(passwordField1);

		passwordFieldconfirm = new JPasswordField();
		passwordFieldconfirm.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordFieldconfirm.setBounds(355, 354, 330, 25);
		contentPane.add(passwordFieldconfirm);

		JButton btnNewButtonNext = new JButton("Next");
		btnNewButtonNext.addActionListener((ActionEvent e) -> {
                    try{
                        Connector c = new Connector();
                        con=c.Database_Connector();
                        st= con.createStatement();
                        
                        
                        if(textFieldName.getText().equals("")||textFieldUSR.getText().equals("")||textFieldEmail.getText().equals("")
                                ||textFieldAge.getText().equals("")||comboBoxGender.getSelectedItem().equals("Choose..")||comboBoxfTeam.getSelectedItem().equals("Choose.."))
                        {
                            JOptionPane.showMessageDialog(null, "Please Insert All Fields");
                            dispose();
                            SignUp st = new SignUp();
                            st.setVisible(true);
                        }
                        else
                        {
                            String p=String.valueOf(passwordField1.getPassword());
                            String pconfirm=String.valueOf(passwordFieldconfirm.getPassword());
                            if(!p.equals(pconfirm))
                            {
                                JOptionPane.showMessageDialog(null, "Passwords do not Match");
                                dispose();
                                SignUp s=new SignUp();
                                s.setVisible(true);
                            }
                            else{
                                String agec=textFieldAge.getText();
                                boolean flag=true;
                                while(flag)
                                {
                                    try{
                                        Integer.parseInt(agec);
                                        flag=false;
                                    }catch(NumberFormatException f){
                                        agec=JOptionPane.showInputDialog("Insert a valid age");
                                    }
                                }
                                
                                usrname=textFieldUSR.getText();
                                try{
                                    String queryc="Select Username from user_info where Username='"+usrname+"'";
                                    PreparedStatement ps=con.prepareStatement(queryc);
                                    rs=ps.executeQuery();
                                    while(rs.next())
                                    {
                                        JOptionPane.showInputDialog("Duplicate Username: Enter Another");
                                        rs.close();
                                        break;
                                    }
                                }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, "Got some Errors!");
                                }
                                
                                String query="INSERT INTO user_info (Name,Username,Email,Age,Gender,Favourite_Team,Password) " +
                                        "VALUES (?,?,?,?,?,?,?)";
                                
                                PreparedStatement pat = con.prepareStatement(query);
                                pat.setString(1,textFieldName.getText());
                                pat.setString(2,usrname);
                                pat.setString(3,textFieldEmail.getText());
                                
                                pat.setString(4,agec);
                                pat.setString(5,(String)comboBoxGender.getSelectedItem());
                                pat.setString(6,(String)comboBoxfTeam.getSelectedItem());
                                //JOptionPane.showMessageDialog(null,passwordFieldconfirm.getPassword());
                                char[] pwd=passwordFieldconfirm.getPassword();
                                for(int i=0;i<100;i++)
                                {
                                    pat.setString(7,new String(pwd));
                                }
                                //pat.setString(8,"TESTTEAM");
                                //st.executeUpdate(query);
                                pat.execute();
                                JOptionPane.showMessageDialog(null,"Success");
                                pat.close();
                                
                            }
                            dispose();
                            CreateTeam ct = new CreateTeam(usrname);
                            ct.setVisible(true);
                        }
                        
                    }catch(SQLException | HeadlessException ex){
                        
                    }
                    
                    
                    
                });
		btnNewButtonNext.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButtonNext.setBounds(355, 470, 117, 35);
		contentPane.add(btnNewButtonNext);

		JButton btnNewButtonCancel1 = new JButton("Cancel");
		btnNewButtonCancel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow window = new MainWindow();
				window.mainFrame.setVisible(true);
			}
		});
		btnNewButtonCancel1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButtonCancel1.setBounds(501, 470, 117, 35);
		contentPane.add(btnNewButtonCancel1);

		JLabel lblNewLabelName = new JLabel("Name");
		lblNewLabelName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelName.setBounds(130, 48, 107, 15);
		contentPane.add(lblNewLabelName);

		JLabel lblNewLabelUSR = new JLabel("Username");
		lblNewLabelUSR.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelUSR.setBounds(130, 96, 152, 15);
		contentPane.add(lblNewLabelUSR);

		JLabel lblNewLabelemail = new JLabel("Email");
		lblNewLabelemail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelemail.setBounds(130, 141, 124, 15);
		contentPane.add(lblNewLabelemail);

		JLabel lblNewLabelGender = new JLabel("Gender");
		lblNewLabelGender.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelGender.setBounds(130, 221, 152, 15);
		contentPane.add(lblNewLabelGender);

		JLabel lblNewLabelAge = new JLabel("Age");
		lblNewLabelAge.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelAge.setBounds(130, 179, 152, 15);
		contentPane.add(lblNewLabelAge);

		JLabel lblNewLabelfTeam = new JLabel("Favourite Team");
		lblNewLabelfTeam.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelfTeam.setBounds(130, 264, 152, 15);
		contentPane.add(lblNewLabelfTeam);

		JLabel lblNewLabelpass = new JLabel("Password");
		lblNewLabelpass.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelpass.setBounds(130, 308, 152, 15);
		contentPane.add(lblNewLabelpass);

		JLabel lblNewLabelconfirm = new JLabel("Confirm Password");
		lblNewLabelconfirm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelconfirm.setBounds(130, 354, 152, 15);
		contentPane.add(lblNewLabelconfirm);

		JButton btnNewButtonFinish = new JButton("Finish");
		btnNewButtonFinish.setEnabled(false);
		btnNewButtonFinish.setBounds(644, 470, 117, 35);
		contentPane.add(btnNewButtonFinish);

		JLabel labelImage1 = new JLabel("");
		Image suimg = new ImageIcon(getClass().getResource("/premier-league-logo.jpg")).getImage();
		labelImage1.setIcon(new ImageIcon(suimg));
		labelImage1.setBounds(0, 0, 800, 565);
		getContentPane().add(labelImage1);
	}
}