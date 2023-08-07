package me.albymong.devspringboot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.albymong.devspringboot.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api") //공통되는 URL을 사용하기 위해 
public class GetController {
    
    //@RequestMapping(value="/hello", method=RequestMethod.GET)
    //@RequestMapping 고전적인 방법으로 사용하지 않음
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello(){
        return "hello World!";
    }

    //@GetMapping : 별도의 파라미터 없이 GET API를 호출하는 경우 사용되는 방법
    //http://localhost:8080/api/v1/get-api/name
    @GetMapping("/name")
    public String name(){
        return "World!";
    }

    //@PathVariable : GET형식으 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
    //http://localhost:8080/api/v1/get-api/variable1/{String값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    //변수의 관리의 용이를 위해 사용하는 방식
    //http://localhost:8080/api/v1/get-api/variable2/{String값}
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //@RequestParam : '?'를 기준으로 우측에 {키}={값}의 형태로 전달
    //http://localhost:8080/api/v1/get-api/request1?name=aaa&email=aaa.gmail.com&organization=aaagnd
    @GetMapping(value="/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization){
        return name+" "+email+" "+organization;
    }

    //@RequestParam 
    //http://localhost:8080/api/v1/get-api/request2?name=aaa&email=aaa.gmail.com&organization=aaagnd
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }
    //@RequestParam 
    //DTO 사용 : 받아야할 파라미터가 많을 경우 DTO 객체를 사용한 방식
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){

        return memberDTO.toString();
    }

}
