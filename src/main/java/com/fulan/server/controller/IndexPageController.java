package com.fulan.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 13862
 */
@Controller
public class IndexPageController {

    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }
}
