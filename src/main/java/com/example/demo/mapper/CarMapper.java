package com.example.demo.mapper;

import com.example.demo.domain.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

/**
 * @author yedong
 */
@Mapper
public interface CarMapper {

    @Insert("insert into car(make,model,year) values(#{make},#{model},#{year})")
    void insert(Car car);

    @Select("select * from car")
    Collection<Car> selectAll();

}
