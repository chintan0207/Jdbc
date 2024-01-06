package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx {

	public static void main(String[] args) {
	
		try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			if(con.isClosed()) {
				System.out.println("connection is closed");
			}else {
				System.out.println("connection is created");
			}
			
		}catch(Exception e) {
			System.out.println("erroe" + e);
		}

	}

}
