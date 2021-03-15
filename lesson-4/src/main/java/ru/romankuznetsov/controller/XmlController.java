package ru.romankuznetsov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romankuznetsov.entity.XmlProduct;

@RestController
public class XmlController {
    @GetMapping("/get/xml")
    public XmlProduct getProduct() {
        XmlProduct product = new XmlProduct();
        product.setId(2);
        product.setName("xml_product");
        product.setPrice(6472);
        return product;
    }
}
