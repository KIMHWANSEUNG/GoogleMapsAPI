package com.poiproject.study.Controller;

import com.poiproject.study.Repository.VO.MapVO;
import com.poiproject.study.Repository.VO.PositionVO;
import com.poiproject.study.Service.MapService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Log4j2
@Controller
public class HomeController {

    @Autowired
    MapService mapService;

    @GetMapping("/")
    public String home(Model model) {


        return "home";
    }

    @ResponseBody
    @GetMapping("/places.ajax")
    public HashMap<String,HashMap>getplace() {
        List<MapVO> googleMap_data = mapService.selectMap();

        HashMap<PositionVO, MapVO> ko_total_data = new HashMap<>();
        HashMap<PositionVO, MapVO> en_total_data = new HashMap<>();

        for (MapVO temp_data : googleMap_data) {
            PositionVO positionVO = new PositionVO(temp_data.getMapPositionX(), temp_data.getMapPositionY());

            if (temp_data.getLangCodeId().equals("ko")) {
                ko_total_data.put(positionVO, temp_data);
            } else if (temp_data.getLangCodeId().equals("en")) {
                en_total_data.put(positionVO, temp_data);
            }
        }
        HashMap<String, HashMap> total_data = new HashMap<>();
        total_data.put("ko",ko_total_data);
        total_data.put("en",en_total_data);


        return total_data;
    }


/*    @GetMapping("/good")
    public HashMap<String, HashMap<LatLngVo, HwPoiVo>> good(){
        List<HwPoiVo> poiList = hwPoiMapper.selectPoiList();
        HashMap<String, HashMap<LatLngVo, HwPoiVo>> map = new HashMap<>();

        for(HwPoiVo tmpPoi : poiList) {
            if(map.get(tmpPoi.getLangCodeId()) == null) {
                map.put(tmpPoi.getLangCodeId(), new HashMap<LatLngVo, HwPoiVo>());
            }
            HashMap<LatLngVo, HwPoiVo> abc =  map.get(tmpPoi.getLangCodeId());
            LatLngVo cde = new LatLngVo(tmpPoi.getMapPositionY(), tmpPoi.getMapPositionX());
            abc.put(cde, tmpPoi);

            map.get(tmpPoi.getLangCodeId()).put(new LatLngVo(tmpPoi.getMapPositionY(), tmpPoi.getMapPositionX()), tmpPoi);
        }

        return map;
    }*/

    @GetMapping("/google")
    public String google() {

        return "google";
    }
}
