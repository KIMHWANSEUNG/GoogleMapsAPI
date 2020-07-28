package com.poiproject.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("greeting","안녕하세요");
        return "home";
    }
}
