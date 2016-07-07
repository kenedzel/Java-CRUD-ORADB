package com.kenedzel.dbconn.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class TestStoredProcedure {

	public static void main(String[] args) throws SQLException 
	{
	 try(
			 Connection conn = DBUtil.getConnection(DBType.ORADB);
			 CallableStatement callableStatement = conn.prepareCall("{call AddNewEmployee(?,?,?,?,?)}");
		)
		{
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
			
			callableStatement.setInt(1, emp_id);
			callableStatement.setString(2, emp_name);
			callableStatement.setString(3, email);
			callableStatement.setDate(4, hire_date);
			callableStatement.setDouble(5, salary);
			
			callableStatement.execute();
			
			System.out.println("Record Added Successfully");
		}
	 catch(SQLException ex)
	 {
		 DBUtil.showErrorMessage(ex);
	 }
				

	}

}
