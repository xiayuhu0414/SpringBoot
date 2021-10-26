package com.xyh.admin.service;

import com.xyh.admin.bean.City;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2021/10/25 19:59
 */

public interface CityService {
    public City getById(Long id);

    public void saveCity(City city);

}
