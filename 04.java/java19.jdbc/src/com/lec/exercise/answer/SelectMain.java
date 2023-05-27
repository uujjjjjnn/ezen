package com.lec.exercise.answer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {

	final static String DRV = "org.mariadb.jdbc.Driver";
	final static String URL = "jdbc:mariadb://localhost:3306/board";
	final static String USR = "root";
	final static String PWD = "12345";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			String sql = "select empno, ename, job, deptno from emp where deptno = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
			
			System.out.println("사원번호   사원명   직급   부서번호");
			System.out.println("===================================");
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getNString("ename");
				String job = rs.getNString("job");
				String deptno = rs.getNString("deptno");
				
				System.out.print(empno + "\t");
				System.out.print(ename + "\t");
				System.out.print(job + "\t");
				System.out.println(deptno + "\t");
				
			}
		
		} catch (Exception e) {
			System.out.println("DB연결실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			
		}
		

	}

}
