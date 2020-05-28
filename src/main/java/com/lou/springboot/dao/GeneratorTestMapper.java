package com.lou.springboot.dao;

import com.lou.springboot.entity.GeneratorTest;
import org.springframework.stereotype.Component;

@Component
public interface GeneratorTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GeneratorTest record);

    int insertSelective(GeneratorTest record);

    GeneratorTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GeneratorTest record);

    int updateByPrimaryKey(GeneratorTest record);
}
