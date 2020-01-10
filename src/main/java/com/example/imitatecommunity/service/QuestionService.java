package com.example.imitatecommunity.service;

import com.example.imitatecommunity.dto.PagInationDTO;
import com.example.imitatecommunity.dto.QuestionDTO;
import com.example.imitatecommunity.mapper.QuestionMapper;
import com.example.imitatecommunity.mapper.UserMapper;
import com.example.imitatecommunity.model.Question;
import com.example.imitatecommunity.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PagInationDTO getQuestionList(Integer page, Integer size){
        Integer offset = (page - 1) * 5;
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        PagInationDTO pagInationDTO = new PagInationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagInationDTO.setQuestions(questionDTOS);
        Integer totalCount = questionMapper.count();
        pagInationDTO.setPagination(totalCount,page,size);
        return pagInationDTO;
    }


    public PagInationDTO list(Integer userId, Integer page, Integer size) {
        PagInationDTO pagInationDTO = new PagInationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        pagInationDTO.setPagination(totalCount,page,size);
        if(page < 1){
            page = 1;
        }
        if(page > pagInationDTO.getTotalPage()){
            page = pagInationDTO.getTotalPage();
        }
        Integer offset = (page - 1) * size;
        List<Question> questions = questionMapper.listByCreator(userId,offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagInationDTO.setQuestions(questionDTOS);
        return pagInationDTO;
    }


    public QuestionDTO getQuestionById(Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.getById(id);
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}


