package ru.romankuznetsov.print;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class PrintToFile implements Print {
    private String string = "all was printed";
    @Override
    public void print() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\testDir\\test.txt"))){
            bw.write(string);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
