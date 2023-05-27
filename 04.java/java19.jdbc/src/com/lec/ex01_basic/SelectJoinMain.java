package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectJoinMain {

	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
		// 실습. jOptionPane으로 부서번호 입력받아서 부서명출력하기(join)
		// select emp.empno, emp.ename, emp.deptno, dpt.dname 
		// from emp emp , dept dpt 
		// where emp.deptno = ?
		//   and emp.deptno = dpt.deptno;
		// 사원번호, 사원이름, 부서번호, 부서이름
		

		try {
			
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			String sql = "select emp.empno, emp.ename, emp.deptno, dpt.dname from emp emp , dept dpt where emp.deptno = ? and emp.deptno = dpt.deptno";
			int row = 0;
			
			String dptno = JOptionPane.showInputDialog("부서번호 입력하세요");
			int dptno1 = Integer.parseInt(dptno);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dptno1);
			rs = pstmt.executeQuery();
			
			System.out.println("사원번호   사원명   부서번호   부서명");
			System.out.println("=====================================");
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				System.out.print(empno + "\t");
				System.out.print(ename + "\t");
				System.out.print(deptno + "\t");
				System.out.print(dname + "\t");
				System.out.println();
				
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
