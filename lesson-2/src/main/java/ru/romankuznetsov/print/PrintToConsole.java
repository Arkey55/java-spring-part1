package ru.romankuznetsov.print;

import org.springframework.stereotype.Component;

@Component
public class PrintToConsole implements Print {

    @Override
    public void print(String text) {
        System.out.println(text);
    }

}
