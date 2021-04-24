package com.raishin.lifehack.mapper;

import com.raishin.lifehack.domain.Lifehack;
import com.raishin.lifehack.domain.LifehackExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CustomLifehackMapper {
    @Select({
        "select",
        "id, title, category, description",
        "from lifehack",
        "limit 100"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<Lifehack> selectAllLimit();
}