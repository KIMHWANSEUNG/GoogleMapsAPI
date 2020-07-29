package com.poiproject.study.Repository.mapper;

import com.poiproject.study.Repository.VO.MapVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MapMapper {
    List<MapVO> selectMap();
}
