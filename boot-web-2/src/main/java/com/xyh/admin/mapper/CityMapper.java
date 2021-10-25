package com.xyh.admin.mapper;

import com.xyh.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author xyh
 * @date 2021/10/25 11:02
 */
//@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    @Insert("insert into city (name ,state ,country) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);
}

