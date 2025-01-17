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
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private SingninService singninService;

    // 회원가입 페이지
    @GetMapping("")
    public String getRegister() {
        return "register/signup"; // templates/register/signup.html
    }

    // 회원가입 처리
    @PostMapping("/process")
    public String processRegister(@RequestParam String userId, @RequestParam String userPasswd, Model model) {
        MemberDto member = new MemberDto();
        member.setUserId(userId);
        member.setUserPasswd(userPasswd);
        singninService.registerMember(member);

        // 성공 메시지 전달
        model.addAttribute("message", "회원가입이 완료되었습니다!");
        return "common/success"; // templates/common/success.html
    }
}

