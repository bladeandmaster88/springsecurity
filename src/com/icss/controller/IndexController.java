package com.icss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class IndexController {
   @RequestMapping
   public String index(HttpServletRequest request){
      return "page/index";
   }
}

