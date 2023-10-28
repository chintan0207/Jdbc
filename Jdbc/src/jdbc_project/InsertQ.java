package jdbc_project;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertQ {
	
	public void DoConnection() {
		
	//..................insert data in mydb.customer table......................
		
     try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver myDriver = new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(myDriver);
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "insert into customer values ( 10, 'kishan','up',204715, 'India' ) ";
			statement.executeUpdate(MyQuery);
			System.out.println("Query Executed--->"+MyQuery);
			con.close();
			
		} 
		catch(Exception e) {
			System.out.println("e:"+e);
		}		
	}	
	
	//.............................insert data read by customerId.........................
	
	public void ConfirmInsert() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
//			String MyQuery = "insert into customer values ( 13, 'Miraj','delhi',304515, 'India' ) ";
//			statement.executeUpdate(MyQuery);
//			System.out.println("Query Executed--->"+MyQuery);
//			 
			String q2 ="select*from customer where customerId = 10;";
			ResultSet rs = statement.executeQuery(q2);
			
			while(rs.next()) {
				System.out.println("customerName="+rs.getString("customerName"));
			}
			
			
			con.close();
			
			
		} catch (Exception e) {
			
			System.out.println("e:"+e);
		}
	}

	//.......................update data by customerId
	
	public void updateData() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "update customer set city = 'Pune' where customerId=13;";
			statement.executeUpdate(MyQuery);
			System.out.println("update Query Executed--->"+MyQuery);
			
			String q2 ="select*from customer where customerId = 13;";
			ResultSet rs = statement.executeQuery(q2);
			
			while(rs.next()) {
				System.out.println("Updated city="+rs.getString("city"));
			}
			
			
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("e: " + e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         InsertQ con = new InsertQ();
         
		 con.DoConnection();
         con.ConfirmInsert();
         con.updateData();
	}

}
