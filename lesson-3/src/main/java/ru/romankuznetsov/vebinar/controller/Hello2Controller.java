package ru.romankuznetsov.vebinar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {
    @GetMapping("/test")
    public String getJson(){
        return "test";
    }

    @GetMapping("/json")
    public Json getJson1(){
        Json json = new Json();
        json.setCount(10011L);
        json.setName("roman");
        json.setSurname("kuznetsov");
        return json;
    }

    public static class Json{
        private String name;
        private Long count;
        private String surname;

        public void setName(String name) {
            this.name = name;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }

    @GetMapping("/statham")
    public String getJson2(){
        return "statham";
    }
}
