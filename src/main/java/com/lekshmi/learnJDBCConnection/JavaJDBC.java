package com.lekshmi.learnJDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaJDBC {

	public static void main(String[] args) throws SQLException {
		Connection connection;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resource","root","root");
		
		ResultSet resultset;
		
		Statement statement=connection.createStatement();
		
		System.out.println("Connection Established");
		
		String queryToGetMinAndMaxSalary ="SELECT MAX(salary) , MIN(salary) FROM  employee";
	
		resultset = statement.executeQuery(queryToGetMinAndMaxSalary);
		
		while(resultset.next()) {
			int minSalary = resultset.getInt(2);
			System.out.println("Minimum salary is "+minSalary);
			int maxSalary = resultset.getInt(1);
			System.out.println("Maximum salary is "+maxSalary);					
		}
		
		String queryToGetSecondHighestSalary="SELECT DISTINCT salary FROM Employee ORDER BY Salary DESC limit 1,1;";
		
		resultset=statement.executeQuery(queryToGetSecondHighestSalary);
		
		while(resultset.next()) {
			int secondHighestSalary = resultset.getInt(1);
			System.out.println("Second Highest Salary is "+secondHighestSalary);					
		}
		
		connection.close();
		
	}

}
