package com.poiproject.study.Service;

import com.poiproject.study.Repository.VO.MapVO;
import com.poiproject.study.Repository.VO.PositionVO;
import com.poiproject.study.Repository.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService{
    @Autowired
    private MapMapper mapMapper;

    public List<MapVO> selectMap(){


        return mapMapper.selectMap();
    }


}
