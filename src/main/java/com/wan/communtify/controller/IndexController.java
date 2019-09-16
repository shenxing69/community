package com.wan.communtify.controller;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        //使用token作为自定义cookies，避免因服务器重启导致sessionid失效
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0){
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token=cookie.getValue();
                User user=usermapper.findByToken(token);
                if(user !=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        }
        List<QuestionDTO> questionList=questionService.list();
        model.addAttribute("questions",questionList);
        System.out.println(questionList.toString());
        return "index";
    }
}
