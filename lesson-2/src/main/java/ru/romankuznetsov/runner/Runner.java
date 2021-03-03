package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.print.Print;
import ru.romankuznetsov.print.PrintAll;
import ru.romankuznetsov.singleton.SingletonExample;

import java.util.List;

@Service
public class Runner implements CommandLineRunner {

    private final PrintAll printAll;

    public Runner(PrintAll printAll){
        this.printAll = printAll;
    }

    @Override
    public void run(String... args) throws Exception {
        printAll.print();
    }

}