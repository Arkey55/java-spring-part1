package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.print.Print;

import java.util.List;

@Service
public class Runner implements CommandLineRunner {

    private final Print printToConsole;
    private final Print printToFile;
    private final List<String> names;

    public Runner(Print printToConsole,
                  Print printToFile,
                  List<String> names
    ){
        this.printToConsole = printToConsole;
        this.printToFile = printToFile;
        this.names = names;
    }

    @Override
    public void run(String... args) throws Exception {
        printToConsole.print("hello");
        printToFile.print("world!");
        System.out.println(names.get(0));
    }

}