package com.kenedzel.dbconn.java;
import java.sql.*;
//import java.util.*;
public class TestOracleDBConnection {

	static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String username = "hr";
	static final String password = "hr";
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Boundary: ");
//		double sal = sc.nextDouble();
		
		String sql = "select * from Employees where Salary < ? and Department_Id = ?";
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = null;
		try 						
		{
			prepareStatement(pstmt, 10000, 50);
			System.out.println("---------------------------------");
			prepareStatement(pstmt, 3000, 50);

			//update and add an item
//			rs.absolute(6);
//			
//			rs.updateString("Department_Name", "Information Technology");
//			rs.updateRow();
//			System.out.println("Record Updated Successfully");
//			
//			rs.moveToInsertRow();
//			rs.updateInt("Department_Id", 9999);
//			rs.updateString("Department_Name", "Training");
//			rs.updateInt("Manager_Id", 200);
//			rs.updateInt("Location_Id", 1800);
//			
//			rs.insertRow();
//			
//			System.out.println("Record added successfully.");
	
		} 
		catch (SQLException e) 
		{
			DBUtil.showErrorMessage(e);
		}
	}
	private static void prepareStatement(PreparedStatement pstmt, double salary, int department_id)throws SQLException {
		ResultSet rs;
		pstmt.setDouble(1, salary);
		pstmt.setInt(2, department_id);
		rs = pstmt.executeQuery();
		
		String format = "%-4s%-20s%-25s%-10f\n";
		while(rs.next())
		{
			System.out.format(format, rs.getString("Employee_Id"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getFloat("Salary"));
		}
		rs.last();
		System.out.println("Total Employees: " + rs.getRow());
	}

}
