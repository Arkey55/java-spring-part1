package ru.romankuznetsov.print;

import org.springframework.stereotype.Component;

@Component
public class PrintToConsole implements Print {
    private String string = "all was printed";

    @Override
    public void print() {
        System.out.println(string);
    }

}
