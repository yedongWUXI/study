package com.design.demo.mapper;

import com.design.demo.domain.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

/**
 * @author yedong
 */
public interface CarMapper {

    @Insert("insert into car(make,model,year) values(#{make},#{model},#{year})")
    void insert(Car car);

    @Select("select * from car")
    Collection<Car> selectAll();

}
