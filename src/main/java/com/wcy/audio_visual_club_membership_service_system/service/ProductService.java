package com.wcy.audio_visual_club_membership_service_system.service;

import com.wcy.audio_visual_club_membership_service_system.pojo.Product;
import com.wcy.audio_visual_club_membership_service_system.pojo.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}