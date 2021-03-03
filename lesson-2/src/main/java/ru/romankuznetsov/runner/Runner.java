package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.print.Print;
import ru.romankuznetsov.singleton.SingletonExample;

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
        SingletonExample singletonExample = SingletonExample.getInstance();
        SingletonExample singletonExample1 = SingletonExample.getInstance();
        System.out.println(singletonExample);
        System.out.println(singletonExample1);
        System.out.println(SingletonExample.getValue());
    }

}