package com.example.imitatecommunity.service;

import com.example.imitatecommunity.dto.QuestionDto;
import com.example.imitatecommunity.mapper.QuestionMapper;
import com.example.imitatecommunity.mapper.UserMapper;
import com.example.imitatecommunity.model.Question;
import com.example.imitatecommunity.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/25
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<QuestionDto> list(){
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questionList = questionMapper.list();
        for (Question question : questionList) {
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            User user = userMapper.findById(question.getCreator());
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }
}
