package ru.romankuznetsov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romankuznetsov.entity.JsonProduct;

@RestController
public class JsonController {
    @GetMapping("/get/json")
    public JsonProduct getProduct() {
        return new JsonProduct(1, "json_product", 1142);
    }
}
