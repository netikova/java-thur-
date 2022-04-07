package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// JDBC(Java DataBase Connectivity)
// JAVA 프로그래밍언어를 사용하여 데이터 베이스에 연결하고
// SQL 명령문을 실행하기 위하여 사용하는 사용하는 규칙
public class ExJdbc {

	public static void main(String[] args) {
		// 오라클 JDBC 드라이버 클래스를 메모리에 로드
		// 데이터베이스 연결 전에 최초 1회만 실행 필요
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 서버 주소
		String user = "web"; //데이터베이스 사용자 아이디
		String password = "web01"; //데이터베이스 사용자 비밀번호
		
		String selectSql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				//명령문객체에 담겨있는 SQL문을 실행
				//실행 후 결과 데이터를 받는 SQL(select)문은 executeQuery() 사용
				//실행 후 결과 데이터가 없는 SQL(insert,update,delete)은 executeUpdate()사용
				ResultSet rs = pstmt.executeQuery();
		) {
			
			//SELECT 실행 결과 데이터가 저장되어 있는 ResultSet은
			//처음에는 첫 레코드(행) 이전을 가리키고 있고,
			//다음 레코드를 가리키도록 한 다음, 해당 레코드의 컬럼 값을 조회
			
			//rs.next()는 다음 레코드를 가리키는 명령문
			//다음레코드가 있으면 true를 반환, 없으면 false를 반환
			//SELECT 실행 결과 데이터가 저장되어 있는 ResultSet은
			//처음에는 첫 레코드(행) 이전을 가리키고 있고,
			//다음 레코드를 가리키도록 한 다음, 해당 레코드의 컬럼 값을 조회
			// rs.next();  다음 레코드를 가리키도록
			while (rs.next()) {
								
				//컬럼값의 타입에 따라서 .getXXX("컬럼명") 을 사용하여
				//현재 ResultSet이 가리키는 레코드의 컬럼값을 읽기
				String memId = rs.getString("mem_id"); //현재 가리키는 레코드의 mem_id 컬럼값 읽기
				String memPass = rs.getString("mem_pass"); //현재 가리키는 레코드의 mem_pass 컬럼값 읽기
				String memName = rs.getString("mem_name"); //현재 가리키는 레코드의 mem_name 컬럼값 읽기
				int memPoint = rs.getInt("mem_point"); //현재 가리키는 레코드의 mem_point 컬럼값 읽기
				System.out.println(memId + "," + memPass + "," + memName + "," + memPoint);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		/*
			 * finally { // try{} 내부에서 오류 발생 여부와 상관없이 무조건 실행 if(rs!=null)rs.close(); //사용이
			 * 끝나면 ResultSet의 자원을 반납 if(pstmt!=null)pstmt.close();//사용이 끝나면
			 * PreparedStatement의 자원을 반납 if(conn!=null)conn.close(); //데이터베이스 연결 종료
			 * 
			 * 
			 * }
			 */
		String insertSql = "INSERT INTO member"
				+ "(mem_id, mem_pass, mem_name, mem_point)"
				+ "VALUES('a003', '9012', '도우너', 80)";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(insertSql);
		) {
			
			//명령문객체에 담겨있는 SQL문을 실행
			//실행 후 결과 데이터를 받는 SQL(select)문은 executeQuery() 사용
			//실행 후 결과 데이터가 없는 SQL(insert,update,delete)은 executeUpdate()사용
			int num = pstmt.executeUpdate(); //SQL문 실행결과 변경된 레코드 수를 반환
			
			System.out.println( num + "개의 레코드 추가 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
