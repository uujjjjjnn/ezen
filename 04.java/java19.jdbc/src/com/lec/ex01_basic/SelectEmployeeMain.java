package com.lec.ex01_basic;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmployeeMain {
	
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		// 실습. select empno, ename, job from emp;
		// 사원정보를 employee.html(table태그) 출력파일로 저장
		
		try {
			
			Path path = Paths.get("src\\com\\lec\\ex01_basic\\SelectEmployeeMain.html");
			
			FileChannel fc = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			String sql = "select empno, ename, job from emp";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			String data = "<table border=\"1\">";
			data += "<thead><tr><td>사원번호</td><td>사원이름</td><td>직급</td></tr></thead>";
			
			while(rs.next()) {
				
				int empno = rs.getInt(1);
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				
				data += "<tr>";
				data += ("<td>" + empno + "</td>");
				data += ("<td>" + ename + "</td>");
				data += ("<td>" + job + "</td>");
				data += "</tr>";
		
			}
			
			
			data += "</table>";
		
			Charset cs = Charset.defaultCharset();
			ByteBuffer buffer = cs.encode(data);
			
			int byteCount = fc.write(buffer);
			System.out.println("SelectEmployeeMain.html : " + byteCount + " bytes 쓰기 성공");
			
			fc.close();
			
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
