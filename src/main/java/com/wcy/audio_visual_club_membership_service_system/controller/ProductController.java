package com.wcy.audio_visual_club_membership_service_system.controller;

import com.wcy.audio_visual_club_membership_service_system.pojo.Product;
import com.wcy.audio_visual_club_membership_service_system.pojo.ProductExample;
import com.wcy.audio_visual_club_membership_service_system.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("/product")
    public ModelAndView product(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("product");
        if (id != -1) {
            Product product = productService.selectByPrimaryKey(id);
            modelAndView.addObject("product", product);
        }
        return modelAndView;
    }

    @RequestMapping("/product/delete")
    public void delete(@RequestParam("pid") int id) {
        productService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/product/add")
    public ModelAndView add(Product product) {
        productService.insertSelective(product);
        return product(product.getId());
    }

    @RequestMapping("/product/modify")
    public ModelAndView modify(Product product) {
        productService.updateByPrimaryKeySelective(product);
        return product(product.getId());
    }

    @RequestMapping("/products")
    public ModelAndView products(@RequestParam("type") String type, @RequestParam("value") String value) {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("type", type);
        modelAndView.addObject("value", value);
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("release_date DESC");
        ProductExample.Criteria criteria = productExample.createCriteria();
        switch (type) {
            case "type":
                criteria.andTypeEqualTo(value);
                break;
            case "place":
                criteria.andProductionPlaceEqualTo(value);
                break;
            case "price":
                switch (value) {
                    case "0-10":
                        criteria.andPriceBetween(0.0, 10.0);
                        break;
                    case "10-50":
                        criteria.andPriceBetween(10.0, 50.0);
                        break;
                    case "50-100":
                        criteria.andPriceBetween(50.0, 100.0);
                        break;
                    case ">100":
                        criteria.andPriceGreaterThan(100.0);
                        break;
                }
                break;
            case "date":
                switch (value) {
                    case "<1990":
                        criteria.andReleaseDateLessThan(new Date(90, 0, 1));
                        break;
                    case "1990-2000":
                        criteria.andReleaseDateBetween(new Date(90, 0, 1), new Date(99, 11, 31));
                        break;
                    case "2000-2010":
                        criteria.andReleaseDateBetween(new Date(100, 0, 1), new Date(109, 11, 31));
                        break;
                    case ">2010":
                        criteria.andReleaseDateGreaterThan(new Date(110, 0, 1));
                        break;
                }
                break;
            case "keyword":
                criteria.andNameLike("%" + value + "%");
        }
        List<Product> products = productService.selectByExample(productExample);
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
