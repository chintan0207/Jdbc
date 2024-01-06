package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class JdbcAllOperation {

    Connection con;
    PreparedStatement pstmt;
    ResultSet res;

    public Connection getMyConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydb";
            String UserName = "root";
            String Password = "root";
            con = DriverManager.getConnection(url, UserName, Password);
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection Created");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // Insert Operation
    public void insertRec(int id, String name,int salary,String job) throws SQLException {
        con = getMyConnection();
        pstmt = con.prepareStatement("insert into employee values(?,?,?,?)");
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, salary);
        pstmt.setString(4, job);
        int result = pstmt.executeUpdate();
        System.out.println(result + " Record is Inserted");
        con.close();
    }

    // Select Operation by ID
    public void selectById(int id) throws SQLException {
        con = getMyConnection();
        pstmt = con.prepareStatement("select * from employee where id = ?");
        pstmt.setInt(1, id);
        res = pstmt.executeQuery();

        if (res.next()) {
            System.out.println("Employee ID: " + res.getInt("id"));
            System.out.println("Employee Name: " + res.getString("name"));
            System.out.println("Employee Salary: " + res.getInt("salary"));
            System.out.println("Employee job: " + res.getString("job"));
        } else {
            System.out.println("Record not found for ID: " + id);
        }

        con.close();
    }

    // Update Operation
    public void updateRec(int id, String name,int salary,String job) throws SQLException {
        con = getMyConnection();
        pstmt = con.prepareStatement("update employee set name=?,salary=?, job=? where id=?");
        pstmt.setString(1, name);
        pstmt.setInt(2, salary);
        pstmt.setString(3, job);
        pstmt.setInt(4, id);
        int result = pstmt.executeUpdate();
        System.out.println(result + " Record is Updated");
        con.close();
    }

    // Delete Operation
    public void deleteRec(int id) throws SQLException {
        con = getMyConnection();
        pstmt = con.prepareStatement("delete from employee where id=?");
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println(result + " Record is Deleted");
        con.close();
    }

    public static void main(String[] args) throws SQLException {
        JdbcAllOperation Jao = new JdbcAllOperation();

        // Insert record
        Jao.insertRec(110, "Rahul", 30, "Java Devloper");

        // Select record by ID
        Jao.selectById(110);

        // Update record
        Jao.updateRec(110, "Rahul Thakur",75000,"Full Stack");
        Jao.selectById(110);

        // Delete record
//        Jao.deleteRec(110);
    }
}

