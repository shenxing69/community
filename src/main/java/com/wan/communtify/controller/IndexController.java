package com.wan.communtify.controller;

import com.wan.communtify.mapper.Usermapper;
import com.wan.communtify.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private Usermapper usermapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
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
        }}
        return "index";
    }
}
