package com.Merlin.hello.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.Merlin.hello.model.User;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM CITY WHERE state = #{state}")
//    City findByState(@Param("state") String state);
    @Insert("insert into student (sno,sname,ssex,sage,sdept) values(#{sno},#{sname},#{ssex},#{sage},#{sdept})")
    void insert(User user);

}
