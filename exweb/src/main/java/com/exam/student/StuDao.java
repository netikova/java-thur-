package com.exam.student;

import java.util.List;

public interface StuDao {

	List<StuVo> selectStuList();

	int insertStu(StuVo vo);

	int delStu(String stu_no);

	StuVo selectStu(String stu_no);

	int updateStu(StuVo vo);

}