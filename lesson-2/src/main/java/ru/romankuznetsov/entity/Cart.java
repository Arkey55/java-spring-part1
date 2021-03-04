package ru.romankuznetsov.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final ProductRepository productRepository;
    private final List<Product> cart;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.cart = new ArrayList<>();
    }

    public void receiveRequest(String s){
        String[] cmd = s.split("\\s");
        switch (cmd[0].toUpperCase()) {
            case "ADD":
                if (cmd.length == 2) {
                    addToCart(cmd[1]);
                } else printErrorMsg();
                break;
            case "DEL":
                if (cmd.length == 2) {
                    removeFromCart(cmd[1]);
                } else printErrorMsg();
                break;
            case "CART":
                if (cmd.length == 1) {
                    if (cart.size() == 0) {
                        System.out.println("Корзина пуста...");
                    } else {
                        showCart();
                    }
                } else printErrorMsg();
                break;
            case "LIST":
                if (cmd.length == 1) {
                    productRepository.showProductsInRepo();
                } else {
                    printErrorMsg();
                }
                break;
            default:
                printErrorMsg();
                break;
        }
    }

    private void addToCart(String s){
        int id = Integer.parseInt(s);
        if (cart.stream().noneMatch(product -> product.getId().equals(id))) {
            if (productRepository.getProductByID(id) != null){
                cart.add(productRepository.getProductByID(id));
                System.out.println(productRepository.getProductByID(id) + " добавлен в корзину");
            } else {
                System.out.println("Данный продукт не найден");
            }
        } else {
            System.out.println("Товар уже в корзине");
        }
    }

    private void removeFromCart(String s){
        int id = Integer.parseInt(s);
        if (cart.removeIf(product -> product.getId().equals(id))){
            System.out.println("Товар удален из корзины: " + productRepository.getProductByID(id));
        } else {
            System.out.println("Товар не найден");
        }

    }

    private void showCart(){
        cart.forEach(System.out::println);
    }

    private void printErrorMsg(){
        System.out.println("Неизвестная команда");
    }

}
