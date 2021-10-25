package com.xyh.admin.service;

import com.xyh.admin.bean.City;
import com.xyh.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2021/10/25 11:05
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
      return   cityMapper.getById(id);
    }
    public void saveCity(City city){
        cityMapper.insert(city);
    }
}
