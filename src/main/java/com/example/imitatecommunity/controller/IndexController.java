package com.example.imitatecommunity.controller;

import com.example.imitatecommunity.dto.QuestionDto;
import com.example.imitatecommunity.mapper.UserMapper;
import com.example.imitatecommunity.model.User;
import com.example.imitatecommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/17
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest,
                        Model model){
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        httpServletRequest.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        List<QuestionDto> questionDtoList = questionService.list();
        model.addAttribute("questions",questionDtoList);
        return "index";
    }
}
