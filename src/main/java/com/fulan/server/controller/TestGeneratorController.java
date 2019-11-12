package com.fulan.server.controller;

import com.fulan.server.model.eo.TestGeneratorEO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
* Controller - 
* ============================================================================
* 版权所有 2019 。
*
* @author qinjie
* @version 1.0 2019-11-12
* ============================================================================
*/
@Slf4j
@Controller
@RequestMapping("/testGeneratorEO")
public class TestGeneratorController {

    @RequestMapping(value = "/index",method= RequestMethod.GET)
    public String indexPage(HttpServletRequest request){
        TestGeneratorEO testGeneratorEo=new TestGeneratorEO();
        request.setAttribute("TestGeneratorEO",testGeneratorEo);
        return "index";
    }

}