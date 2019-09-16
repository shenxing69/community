package com.wan.communtify.service;

import com.wan.communtify.dto.QuestionDTO;
import com.wan.communtify.mapper.QuestionMapper;
import com.wan.communtify.mapper.Usermapper;
import com.wan.communtify.model.Question;
import com.wan.communtify.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private QuestionMapper questionMapper;
    public List<QuestionDTO> list() {
        //尝试使用联合查询代替循环赋值，P23
        // 算了如果使用级联查询还需要设置resultMap，用注解不好写，不想创建mapper，而且user级联属性还很多，手写要累死
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user= usermapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}