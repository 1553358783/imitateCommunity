package com.example.imitatecommunity.controller;

import com.example.imitatecommunity.dto.QuestionDTO;
import com.example.imitatecommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;
import java.security.PrivateKey;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2020/1/6
 */

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getQuestionById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
