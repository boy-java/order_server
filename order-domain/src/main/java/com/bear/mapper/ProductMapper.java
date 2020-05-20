package com.bear.mapper;

import com.bear.entity.Product;
import org.apache.ibatis.annotations.Select;

public interface ProductMapper {
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product FindById(String id);
}
