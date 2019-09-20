package com.wan.communtify.controller;

import com.wan.communtify.dto.CommentDTO;
import com.wan.communtify.dto.QuestionDTO;
import com.wan.communtify.mapper.QuestionMapper;
import com.wan.communtify.model.Comment;
import com.wan.communtify.service.CommentService;
import com.wan.communtify.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("question/{id}")
    public String question(@PathVariable("id") Long id, Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        List<CommentDTO> comments= commentService.listByQuestionId(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("comments",comments);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
