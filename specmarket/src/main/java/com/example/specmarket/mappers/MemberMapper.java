package com.example.specmarket.mappers;

import com.example.specmarket.dto.MemberDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    // 회원가입 SQL
    @Insert("INSERT INTO member (idx, user_Id, user_Passwd) VALUES (NULL, #{userId}, #{userPasswd})")
    void setSignup(MemberDto memberDto);

    // 로그인 시 사용자 정보 조회 SQL
    @Select("SELECT user_Id, user_Passwd FROM member WHERE user_Id = #{userId}")
    MemberDto getUserById(String userId);
}
