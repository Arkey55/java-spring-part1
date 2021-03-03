package ru.romankuznetsov.print;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class PrintToFile implements Print {

    @Override
    public void print(String text) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\testDir\\test.txt"))){
            bw.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
