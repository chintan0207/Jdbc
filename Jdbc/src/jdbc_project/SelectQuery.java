package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectQuery {
	
	//.................................read data from mydb.customer table..........
	Scanner sc = new Scanner(System.in);
	
	public void readData(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver myDriver = new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(myDriver);
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String q1 = "select * from customer";
			ResultSet rs = statement.executeQuery(q1);
			
			
			while(rs.next()) {
				System.out.println("CustomerId= " + rs.getInt("customerId"));
			}
			
		} catch (Exception e) {
			System.out.println("e:"+e);
		}
	}
	
	
	//.................delete data from mydb.customer table by customerId...............................
	
	public void deleteData() {
		
		
		System.out.println("Enter the customerId to be deleted: ");
		int customerId = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			
			String q1 = "delete from customer where customerId ="+ customerId +" ;";
			statement.executeUpdate(q1);
			System.out.println("delete Query executed successfully");
			con.close();
			
		} catch (Exception e) {
			System.out.println("e:"+e);
		}
	}
	
	
	//.................read data from sakila.country table by country_id...................................
	
	public void selectCountry() {
		
		String country;
		System.out.println("Enter the CountryId to View: ");
		int country_id = sc.nextInt();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String q2 = "select*from country where country_id ="+ country_id  +";";
			ResultSet rs = statement.executeQuery(q2);
			
			while(rs.next()) {
				country = rs.getString("country");
				country_id = rs.getInt("country_id");
				
				System.out.println(country+" "+country_id);
			}
			
		} catch (Exception e) {
			System.out.println("e:"+e);
		}
	}

	//..........................................................................
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectQuery s1 = new SelectQuery();
//		s1.deleteData();
        s1.readData();
        s1.selectCountry();
	}

}
