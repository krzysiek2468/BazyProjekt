package org.example.cryptography;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

//można pokombinować i zrobić tą klsę abstrakcyjną albo zrobić w niej metody otwierania i zapisywania do plików a kodowanie gdzie indziej

public class FirstCryptoAlgorytm {

    public void encrytpion(String path , String path2){

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            // tutaj trzeba dodać algorytm krypto

            FileWriter writer = new FileWriter(path2);
            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
