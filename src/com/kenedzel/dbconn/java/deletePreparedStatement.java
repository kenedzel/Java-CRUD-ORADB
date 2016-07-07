package com.kenedzel.dbconn.java;
import java.util.*;
import java.sql.*;
public class deletePreparedStatement {

	public static void main(String[] args) throws SQLException 
	{	int emp_id;
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "Delete from NewEmployees where Employee_Id = ?";
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter Employee Id that you want to remove: ");
		emp_id = Integer.parseInt(scanner.nextLine());
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, emp_id);
		
		int result = pstmt.executeUpdate();
		if(result == 1)
		{
			System.out.println("Employee deleted successfully.");
		}
		else
		{
			System.out.println("Error while deleting the employee.");
		}
		
		scanner.close();
		pstmt.clearParameters();
		conn.close();
	}

}
