package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuDaoJdbc implements StuDao {

    String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 서버 주소
	String user = "web"; //데이터베이스 사용자 아이디
	String password = "web01"; //데이터베이스 사용자 비밀번호
	//static = 객체를 생성하지 않아도 사용이 가능하다. class는 static이 아니기 때문에 에러가 나서 static을 선언해줘야한다. 

//	{
//    	try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	public ArrayList<StuVo> selectList() {
		ArrayList<StuVo> list = new ArrayList<StuVo>();
		String selectSql = "SELECT stu_no, stu_name, stu_score FROM student";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				//명령문객체에 담겨있는 SQL문을 실행
				//실행 후 결과 데이터를 받는 SQL(select)문은 executeQuery() 사용
				//실행 후 결과 데이터가 없는 SQL(insert,update,delete)은 executeUpdate()사용
				ResultSet rs = pstmt.executeQuery();
		) {					

			while (rs.next()) {								
				StuVo vo = new StuVo();
				vo.setStu_no(rs.getString("stu_no"));
				vo.setStu_name(rs.getString("stu_name"));				
				vo.setStu_score(rs.getInt("stu_score"));
				list.add(vo);						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insert(StuVo vo) {
		// 데이터베이스 member 테이블에 회원정보를 insert list.add(vo);
		 	               //추가할 회원이름을 입력받아서 list에 저장(추가)
		int num = 0;
		String insertSql = "INSERT INTO student"
				+ "(stu_no, stu_name, stu_score)"
				+ "VALUES(?, ?, ?)";
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(insertSql);
		) {
			// ?에 주이할 값의 타입에 따라서 setXXX() 메서드 사용
			pstmt.setString(1, vo.getStu_no()); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입
			pstmt.setString(2, vo.getStu_name()); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입			
			pstmt.setInt(3, vo.getStu_score()); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입			
			num = pstmt.executeUpdate(); //SLQ문 실행결과 변경된 레코드 수를 반환
						
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int delete(String id) {
			int num = 0;
			String delSql = "DELETE FROM student WHERE  stu_no = ?";
					
			
			try (
					Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
					//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
					
					PreparedStatement pstmt = conn.prepareStatement(delSql);
			) {
				
				// ?에 주이할 값의 타입에 따라서 setXXX() 메서드 사용
				pstmt.setString(1, id); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입			
//						pstmt.setString(2, pass); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입
//						pstmt.setString(3, name); //pstmt에 담긴 SQL문의 첫번째 ?에 name 값을 주입
//						pstmt.setInt(4, point); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입			
				num = pstmt.executeUpdate(); //SLQ문 실행결과 변경된 레코드 수를 반환, 실행쿼리문을 업데이트						
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}
	
	public int update(StuVo vo) {
		int num = 0;
		String updateSql = "Update student set stu_name=?, stu_score=? WHERE  stu_no = ? )";
		                   
				
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
				//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
				
				PreparedStatement pstmt = conn.prepareStatement(updateSql);
		) {
			
			// ?에 주이할 값의 타입에 따라서 setXXX() 메서드 사용
						pstmt.setString(1, vo.getStu_name()); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입			
						pstmt.setInt(2, vo.getStu_score()); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입		
						pstmt.setString(3, vo.getStu_no()); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입
						num = pstmt.executeUpdate(); //SLQ문 실행결과 변경된 레코드 수를 반환				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
		
	
}
