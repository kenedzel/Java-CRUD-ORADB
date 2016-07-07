package com.kenedzel.dbconn.java;
import java.util.*;
import java.sql.*;
import java.sql.Date;
public class updatePreparedStatement {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		int emp_id;
		double salary;
		
		String sql = "Update NewEmployees set Salary = ? where Employee_Id = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id: ");
		emp_id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter new Salary: ");
		salary = Double.parseDouble(sc.nextLine());
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setDouble(1, salary);
		pstmt.setInt(2 , emp_id);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1)
		{
			System.out.println("Salary updated Successfully");
		}
		else
		{
			System.out.println("Error while updating data.");
		}

		sc.close();
		pstmt.close();
		conn.close();
		
	}

}
