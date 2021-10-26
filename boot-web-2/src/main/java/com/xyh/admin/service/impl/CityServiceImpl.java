package com.xyh.admin.service.impl;

import com.xyh.admin.bean.City;
import com.xyh.admin.mapper.CityMapper;
import com.xyh.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2021/10/25 11:05
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }
    @Override
    public City getById(Long id) {
      return   cityMapper.getById(id);
    }
    @Override
    public void saveCity(City city){
        counter.increment();
        cityMapper.insert(city);
    }
}
