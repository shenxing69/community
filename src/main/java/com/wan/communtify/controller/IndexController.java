package com.wan.communtify.controller;

import com.wan.communtify.dto.PaginationDTO;
import com.wan.communtify.dto.QuestionDTO;
import com.wan.communtify.mapper.QuestionMapper;
import com.wan.communtify.mapper.Usermapper;
import com.wan.communtify.model.Question;
import com.wan.communtify.model.User;
import com.wan.communtify.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(Model model, @RequestParam(name="page",defaultValue = "1")Integer page,
                        @RequestParam(name="size",defaultValue = "5")Integer size){
        PaginationDTO pagination=questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
