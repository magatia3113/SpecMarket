package com.example.specmarket.service;

import com.example.specmarket.dto.MemberDto;
import com.example.specmarket.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingninService {

    @Autowired
    private MemberMapper memberMapper;

    // 회원가입
    public void registerMember(MemberDto memberDto) {
        memberMapper.setSignup(memberDto);
    }

    // 로그인
    public MemberDto loginMember(String userId, String userPasswd) {
        MemberDto member = memberMapper.getUserById(userId);
        if (member != null && member.getUserPasswd().equals(userPasswd)) {
            return member;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
}
