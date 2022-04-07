package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExMemJdbc {

    public static void main(String[] args) {
    	MemberDao memberDao = new MemberDao();
    	// ArrayList : 다수의 값을 저장할 수 있는 배열과 유사한 목록
        // ArrayList<MemberVo> list = new ArrayList<MemberVo>(); 		
		
    	Scanner sc = new Scanner(System.in);
    	boolean flag = true;
		while (flag) {
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": {
				
				ArrayList<MemberVo> list = memberDao.selectList(); 
			    for(int i = 0 ; i < list.size(); i++) {
			    	MemberVo vo = list.get(i);
				    System.out.println(vo.getMemId() +" : "+vo.getMemPass()+ " : " +vo.getMemName()+ " : " +vo.getMemPoint());
				    //list에 저장되어 있는 회원이름들을 모두 출력
			    }
				/*
					 * finally { // try{} 내부에서 오류 발생 여부와 상관없이 무조건 실행 if(rs!=null)rs.close(); //사용이
					 * 끝나면 ResultSet의 자원을 반납 if(pstmt!=null)pstmt.close();//사용이 끝나면
					 * PreparedStatement의 자원을 반납 if(conn!=null)conn.close(); //데이터베이스 연결 종료
					 * 
					 * 
					 * }
					 */
			    break;
			}
			// 데이터베이스 member 테이블의 정보를 select하여 출력
//		    for(String n :list) {
//		    	System.out.println(n);
//		    }
		    // 데이터베이스 member 테이블의 정보를 select하여 출력
	   	  
		 
			case "2": {	
		
				  MemberVo vo = new MemberVo();
				  System.out.println("회원이름 : ");
				  vo.setMemId(sc.nextLine()); 
				  System.out.println("회원비밀번호 : ");
				  vo.setMemPass(sc.nextLine()); 
				  System.out.println("회원이름 : ");
				  vo.setMemName(sc.nextLine()); 
				  System.out.println("회원포인트 : ");
				  vo.setMemPoint(Integer.parseInt(sc.nextLine()));
				  //Refactor의 Extract method를 누르면 method화 한다.
				  int num = memberDao.insert(vo); 			
				  System.out.println( num + "개의 레코드 추가");
				  
				break;
			}
			case "3":{
//				MemberVo vo = new MemberVo(); 
				System.out.println("삭제할 회원아이디 : ");
//				vo.setMemId(sc.nextLine());
//				System.out.println("아이디 : ");
				String id = sc.nextLine();
//				System.out.println("비밀번호 : ");
//				String pass = sc.nextLine();
//				System.out.println("이름 : ");
//				String name = sc.nextLine();
//				System.out.println("포인트 : ");
//				int point = Integer.parseInt(sc.nextLine() );
//				String insertSql = "INSERT INTO member"
//						+ "(mem_id, mem_pass, mem_name, mem_point)"
//						+ "VALUES(?, ?, ?, ?)";
				
				int num = memberDao.delete(id); 
				System.out.println( num + "개의 레코드 삭제");				
				break;
			}
			case "4":
				flag = false;  //종료
				break;
			default:
				System.out.println("알 수 없는 메뉴");
				break;

			}
			//목록 출력
			//목록에 데이터 추가
			//목록의 데이터 삭제
		}

    }
}

