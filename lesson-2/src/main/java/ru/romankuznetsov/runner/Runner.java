package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.service.ProductRepository;
import ru.romankuznetsov.util.ConsoleInput;
import ru.romankuznetsov.util.InfoMessage;


@Service
public class Runner implements CommandLineRunner {
    private final ProductRepository productRepo;
    private final ConsoleInput consoleInput;
    private final InfoMessage info;

    public Runner(ProductRepository productRepo,
                  ConsoleInput consoleInput,
                  InfoMessage info) {
        this.productRepo = productRepo;
        this.consoleInput = consoleInput;
        this.info = info;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepo.formRepository();
        info.printInfoMsg();
        consoleInput.scanConsoleInput();
    }


}