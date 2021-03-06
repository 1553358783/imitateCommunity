package com.example.imitatecommunity.controller;

import com.example.imitatecommunity.mapper.QuestionMapper;
import com.example.imitatecommunity.model.Question;
import com.example.imitatecommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/20
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String goPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            HttpServletRequest request,
                            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "/publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error","内容不能为空");
            return "/publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error","标签不能为空");
            return "/publish";
        }
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","您暂未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setTag(tag);
        question.setDescription(description);
        question.setCreator(user.getId());
        question.setGmtCreated(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreated());
        questionMapper.create(question);
        return "redirect:/";
    }
}
