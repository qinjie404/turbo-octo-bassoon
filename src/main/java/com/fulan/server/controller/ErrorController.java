package com.fulan.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 13862
 */
@RestController
public class ErrorController {

    @RequestMapping(value = "/error/{number}")
    public String index(@PathVariable int number){
        System.out.println(20 / number);
        return "get index page successfully.";
    }
}
