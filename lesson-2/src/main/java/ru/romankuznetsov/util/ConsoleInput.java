package ru.romankuznetsov.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Cart;

import java.util.Scanner;

@Component
public class ConsoleInput {

    private final Cart cart;

    public ConsoleInput(Cart cart) {
        this.cart = cart;
    }

    public void scanConsoleInput(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("EXIT")){
                break;
            }
            cart.receiveRequest(input);
        }
    }

}
