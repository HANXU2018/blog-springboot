package com.lou.springboot.controller;

import com.lou.springboot.entity.SaleGoods;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/test/httpmessageconverter", method = RequestMethod.POST)
    @ResponseBody
    public SaleGoods httpMessageConverterTest2(@RequestBody SaleGoods saleGoods) {
        System.out.println(saleGoods.toString());
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("商品名：" + saleGoods.getGoodsName());
        return saleGoods;
    }
}
