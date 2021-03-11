package ru.romankuznetsov.vebinar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.romankuznetsov.vebinar.entity.XmlProduct;

@RestController
public class XmlController {
    @RequestMapping("/get/xml")
    public @ResponseBody XmlProduct getProduct() {
        XmlProduct product = new XmlProduct();
        product.setId(2);
        product.setName("xml_product");
        product.setPrice(6472);
        return product;
    }
}
