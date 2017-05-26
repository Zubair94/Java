package fantasyfootball;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connector {

	Connection con = null;
	Statement st = null;
	ResultSet rs =null;
	ResultSet rs1 = null;
	Statement st1 =null;
			public Connector(){}

			public Connection Database_Connector(){
					try{
						String Driver = "com.mysql.jdbc.Driver";
						Class.forName(Driver);
						con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/user","root","");
						//JOptionPane.showMessageDialog(null, "Connection to Server Successful");
						return con;
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Connection Failed");
						return null;

						}
			}

}
