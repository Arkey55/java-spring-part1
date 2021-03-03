package ru.romankuznetsov.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAll {
    private final PrintToConsole printToConsole;
    private final PrintToFile printToFile;

    public PrintAll(PrintToConsole printToConsole, PrintToFile printToFile) {
        this.printToConsole = printToConsole;
        this.printToFile = printToFile;
    }

    public void print(){
        printToConsole.print();
        printToFile.print();
    }

}
