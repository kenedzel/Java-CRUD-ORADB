package com.kenedzel.dbconn.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class insertPreparedStatement {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		int emp_id;
		String emp_name, email;
		Date hire_date;
		double salary;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id: ");
		emp_id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Employee Name: ");
		emp_name = sc.nextLine();
		
		System.out.println("Enter Employee Email: ");
		email = sc.nextLine();
		
		System.out.println("Enter Hire Date: ");
		hire_date = Date.valueOf(sc.nextLine());
		
		System.out.println("Enter Salary: ");
		salary = sc.nextDouble();
		
		String sql = "insert into NewEmployees values (?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, emp_id);
		pstmt.setString(2, emp_name);
		pstmt.setString(3, email);
		pstmt.setDate(4, hire_date);
		pstmt.setDouble(5, salary);
		
		int result = pstmt.executeUpdate();
		if(result == 1)
		{
			System.out.println("Record inserted succesfully.");
		}
		else
		{
			System.err.println("Error while adding the record.");
		}
		
		sc.close();
		pstmt.close();
		conn.close();
	}

}
