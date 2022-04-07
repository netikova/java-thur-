package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ExJdbc2 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 서버 주소
		String user = "web"; //데이터베이스 사용자 아이디
		String password = "web01"; //데이터베이스 사용자 비밀번호
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pass = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("포인트 : ");
		int point = Integer.parseInt(sc.nextLine() );
		
		String insertSql = "INSERT INTO member"
				+ "(mem_id, mem_pass, mem_name, mem_point)"
				+ "VALUES(?, ?, ?, ?)";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(insertSql);
		) {
			// ?에 주이할 값의 타입에 따라서 setXXX() 메서드 사용
			pstmt.setString(1, id); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입
			pstmt.setString(2, pass); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입
			pstmt.setString(3, name); //pstmt에 담긴 SQL문의 첫번째 ?에 name 값을 주입
			pstmt.setInt(4, point); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입			
			int num = pstmt.executeUpdate(); //SLQ문 실행결과 변경된 레코드 수를 반환
			System.out.println( num + "개의 레코드 추가");			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		String selectSql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				
				
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				
				ResultSet rs = pstmt.executeQuery();
		) {
			
			
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
		
		// "삭제할 회원 아이디를 입력하세요"라고 출력하고,
		// 키보드로 입력한 아이디의 회원을 삭제하도록 구현
		// 삭제 SQL문 : DELETE FROM member WHERE mem_id = 'b001';
		
	}
}
