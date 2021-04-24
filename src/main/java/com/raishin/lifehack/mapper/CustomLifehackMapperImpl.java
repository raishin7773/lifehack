package com.raishin.lifehack.mapper;

import com.raishin.lifehack.domain.Lifehack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomLifehackMapperImpl extends CustomLifehackMapper {

}