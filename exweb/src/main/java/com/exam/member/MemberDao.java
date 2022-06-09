package com.exam.member;

import java.util.List;

public interface MemberDao {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	int delMember(String id);

	MemberVo selectMember(String memId);

	int updateMember(MemberVo vo);

	MemberVo selectLoginMember(MemberVo vo);

}