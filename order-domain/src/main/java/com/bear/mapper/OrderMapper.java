package com.bear.mapper;

import com.bear.entity.ProductOrder;
import org.apache.ibatis.annotations.Insert;
import org.aspectj.weaver.ast.Or;

public interface OrderMapper {

    @Insert("INSERT INTO `order`(id,product_name,trade_no,price,create_time,user_id,user_name) VALUES(#{id},#{productName},#{tradeNo},#{price},#{createTime},#{userId}，#{userName})")
    int inser(ProductOrder order);
}
