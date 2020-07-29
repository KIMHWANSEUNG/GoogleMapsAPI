package com.poiproject.study.Controller;

import com.poiproject.study.Repository.VO.MapVO;
import com.poiproject.study.Service.MapService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Log4j2
@Controller
public class HomeController {

    @Autowired
    MapService mapService;

    @GetMapping("/")
    public String home(Model model) {

        List<MapVO> googleMap=mapService.selectMap();



        return "home";
    }

    @GetMapping("/google")
    public String google(){

        return "google";
    }
}
