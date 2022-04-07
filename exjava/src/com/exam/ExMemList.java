package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ExMemList {
    public static void main(String[] args) {
    	// ArrayList : 다수의 값을 저장할 수 있는 배열과 유사한 목록
    	ArrayList<MemberVo> list = new ArrayList<MemberVo>(); 
    	
    	Scanner sc = new Scanner(System.in);
    	boolean flag = true;
		while (flag) {
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": {
//		    for(String n :list) {
//		    	System.out.println(n);
//		    }
		    for(int i = 0 ; i < list.size(); i++) {
		    	MemberVo vo = list.get(i);
			    System.out.println(vo.getMemId() +" : "+vo.getMemPass()+ " : " +vo.getMemName()+ " : " +vo.getMemPoint());
			    //list에 저장되어 있는 회원이름들을 모두 출력
		    }
	   	    break;
		 }
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
				list.add(vo);	               //추가할 회원이름을 입력받아서 list에 저장(추가)
				break;
			}
			case "3":{
		        System.out.println("삭제할 회원아이디 : ");
		        String memId = sc.nextLine();
		        //list.remove(Del_name);             //삭제할 회원이름을 입력받아서 list에 삭제
		        for(int i = 0; i<list.size(); i++) {
		        	MemberVo vo = list.get(i);
		        	if(memId.equals( vo.getMemId() )) {
		        		list.remove(i);
		        		break;
		        	}
		        }
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
