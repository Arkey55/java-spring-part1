package ru.romankuznetsov.vebinar.controller;

import org.springframework.web.bind.annotation.*;
import ru.romankuznetsov.vebinar.entity.Product;

@RestController
public class JsonController {
    @RequestMapping("/get/json")
    public @ResponseBody Product getProduct() {
        return new Product(1, "some_product", 1142);
    }
}
