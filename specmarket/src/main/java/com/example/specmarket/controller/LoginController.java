package com.example.specmarket.controller;

import com.example.specmarket.dto.MemberDto;
import com.example.specmarket.service.SingninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SingninService singninService;

    // 로그인 페이지
    @GetMapping("")
    public String getLogin() {
        return "login/signin"; // templates/login/signin.html
    }

    // 로그인 처리
    @PostMapping("/process")
    public String processLogin(@RequestParam String userId, @RequestParam String userPasswd, Model model) {
        try {
            MemberDto member = singninService.loginMember(userId, userPasswd);
            model.addAttribute("message", "로그인에 성공했습니다!");
            return "common/success"; // templates/common/success.html
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login/signin"; // 로그인 실패 시 다시 로그인 페이지로
        }
    }
}




