package com.exam;

import java.util.ArrayList;

public class ExList {
    public static void main(String[] args) {
    	// ArrayList : 다수의 값을 저장할 수 있는 배열과 유사한 목록
    	ArrayList<String> list = new ArrayList<String>(); //문자열 여러개를 저장할 수 있는 목록 생성
    	
    	list.add("고길동"); //목록의 마지막에 "고길동"을 저장(추가)
    	list.add("둘리"); //목록의 마지막에 "둘리"을 저장(추가)
    	list.add("마이콜");// 목록의 마지막에 "마이콜"을 저장(추가)
    	
    	System.out.println(list.size() ); //현재 list에 저장된 데이터 수
    	
    	System.out.println( list.get(0) ); //list의 0번칸에 저장된 데이터 읽기
    	System.out.println( list.get(1) ); //list의 1번칸에 저장된 데이터 읽기
    	System.out.println( list.get(2) ); //list의 2번칸에 저장된 데이터 읽기
    }
}
