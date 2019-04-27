package com.wcy.audio_visual_club_membership_service_system.service.impl;

import com.wcy.audio_visual_club_membership_service_system.mapper.ProductMapper;
import com.wcy.audio_visual_club_membership_service_system.pojo.Product;
import com.wcy.audio_visual_club_membership_service_system.pojo.ProductExample;
import com.wcy.audio_visual_club_membership_service_system.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public long countByExample(ProductExample example) {
        return productMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Product record, ProductExample example) {
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Product record, ProductExample example) {
        return productMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }
}
