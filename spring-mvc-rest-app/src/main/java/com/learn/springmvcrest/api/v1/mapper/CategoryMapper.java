package com.learn.springmvcrest.api.v1.mapper;

import com.learn.springmvcrest.api.v1.model.CategoryDTO;
import com.learn.springmvcrest.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
