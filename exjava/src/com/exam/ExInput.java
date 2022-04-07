package com.exam;

import java.util.Scanner;

public class ExInput {

	public static void main(String[] args) {
		//현재 시스템(컴퓨터)의 입력(키보드)로부터 
		//입력을 받을 수 있는 스캐너 생성 
		Scanner sc = new Scanner(System.in);
		//스캐너로부터 한줄의 문자열을 입력받아서 변수 s에 저장
		String s = sc.nextLine();
		System.out.println( s );
	}

}





