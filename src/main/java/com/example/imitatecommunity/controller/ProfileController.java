package com.example.imitatecommunity.controller;

import com.example.imitatecommunity.dto.PagInationDTO;
import com.example.imitatecommunity.model.User;
import com.example.imitatecommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/30
 */

@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/profile/{action}")
    public String proflie(@PathVariable(name = "action")String action,
                          Model model,
                          HttpServletRequest httpServletRequest,
                          @RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "5")Integer size){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的问题");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PagInationDTO pagInationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", pagInationDTO);
        return "profile";
    }
}
