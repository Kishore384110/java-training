package com.infinite.jdbcDemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearchMain {
	public static void main(String[] args) {	
		int agentid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter agentid ");
		agentid = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","india@123");
			String cmd = "select * from agent where Agentid= ? ";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, agentid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){		
				System.out.println("AgentId  "+rs.getInt("agentid"));
				System.out.println("Agent Name  "+rs.getString("name"));
				System.out.println("City   "+rs.getString("city"));
				System.out.println("MaritalStatus "+rs.getInt("MaritalStatus"));
				System.out.println("Premium  "+rs.getDouble("Premium"));
				System.out.println("GENDER  "+ rs.getString("gender"));
				System.out.println("-------------------------------");
			}else{
				System.out.println("*** No Reocrd Found ***");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
