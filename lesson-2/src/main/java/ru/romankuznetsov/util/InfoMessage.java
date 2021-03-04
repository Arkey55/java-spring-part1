package ru.romankuznetsov.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoMessage {

    public void printInfoMsg(){
        List<String> list = new ArrayList<>();
        list.add("Список достуных комманд:");
        list.add("list - для просмотра доступных товаров");
        list.add("add [id] - для добавления товара в корзину");
        list.add("del [id] - для удаление товара из корзины");
        list.add("cart - для просмотра товаров в корзине");
        list.add("exit - для выхода из приложения");
        list.forEach(System.out::println);
    }
}
