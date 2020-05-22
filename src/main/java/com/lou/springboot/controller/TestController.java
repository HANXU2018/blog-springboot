package com.lou.springboot.controller;

import com.lou.springboot.entity.SaleGoods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/get/httpmessageconverter",method = RequestMethod.GET)
    public SaleGoods httpmessageconverter(){
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setGoodsName("华为手机");
        saleGoods.setId(1);
        saleGoods.setOnSale(true);
        saleGoods.setWeight(200);
        System.out.println(saleGoods);
        return saleGoods;
    }
}
