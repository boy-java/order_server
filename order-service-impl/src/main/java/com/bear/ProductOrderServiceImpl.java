package com.bear;

import com.bear.entity.Product;
import com.bear.entity.ProductOrder;
import com.bear.mapper.OrderMapper;
import com.bear.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Author XiaoXiong.Li
 * @Date 22:33 2020/5/20 
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Resource
    public ProductMapper mapper;
    @Resource
    public OrderMapper productMapper;
    @Resource
    public RestTemplate restTemplate;

    @Override
    public int save(String userId, String productId) {

        Product product = restTemplate.getForObject("http://product-server/findById?"+productId, Product.class);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setId(UUID.randomUUID().toString());
        productOrder.setCreateTime(new Date());
        productOrder.setPrice("999");
        productOrder.setProductName(product.getName());
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setUserId("1");
        productOrder.setUserName("tom");
        return productMapper.inser(productOrder);
    }
}
