package com.infinite.jdbcDemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentInsertMain {
	
	private static final int Gender = 0;

	public static void main(String[] args) {
		
		String name,city,gender;
		int maritalStatus;
		double premium;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name ");
		name = sc.next();
		System.out.println("Enter City name ");
		city=sc.next();
		System.out.println("Enter tye Gender  ");
		gender = sc.next();
		System.out.println("Enter MaritalStatus ");
		maritalStatus = sc.nextInt();
		System.out.println("Enter Premium  ");
		premium =sc.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","india@123");
			String cmd = "insert into agent(name,city,gender,maritalStatus,premium)"+"value(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, name);
			pst.setString(2, city);
			pst.setString(3, gender);
			pst.setInt(4, maritalStatus);
			pst.setDouble(5, premium);
			pst.executeUpdate();
			System.out.println("Agent Record Inserted...");
			 	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
