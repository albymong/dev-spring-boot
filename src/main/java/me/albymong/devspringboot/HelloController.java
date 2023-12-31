package me.albymong.devspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    Myproperties myProperties;

    @GetMapping("/")
    public String home(){
        return  "index";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(){
        //return "Spring Boot 개발툴";
        return myProperties.getMessage();
    }    
}
