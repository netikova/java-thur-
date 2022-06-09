package com.exam.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null; //다른코드에서 이용하기 위해서 선언분리
	
    static {
		
		try {
			String resource = "mybatis/mybatis-config.xml"; //마이바티스 설정 파일 위치
			InputStream inputStream = Resources.getResourceAsStream(resource); //마이바티스 설정파일을 읽을 수 있는 입력 스트림
			
			//마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
    
}
