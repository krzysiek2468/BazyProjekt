package org.example.cryptography;

import org.example.FilesController;
import org.example.TextController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

//można pokombinować i zrobić tą klsę abstrakcyjną albo zrobić w niej metody otwierania i zapisywania do plików a kodowanie gdzie indziej

public class FirstCryptoAlgorytm {

    public void encrytpion(String path , String path2 , String path3 , int zeroForEncryptionOneForDecryption, FilesController.STATE state){

        // nie wiem czy to moża zostawić w jednym try catxh
        // te algorytmy mają pobierać tą listę lines i zwracać List<String>  tu można to co się zwróci zamiast lines dać for(String str: lines)
        // trzeba sprawdzić czy te adresy do plików są prawidłowe bo teraz jak wpiszesz a czy cos innego zamiast ścierzki to ten exception wywala
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            if(zeroForEncryptionOneForDecryption == 0){
                if(state == FilesController.STATE.FIRSTALGORITM){
                    //pierwszy algorytm szyfrowanie
                }else if(state == FilesController.STATE.SECONDALGORITM){
                    //drugi algorytm szyfrowanie
                }else{
                    // trzeci algorytm szyfrowanie
                }
            }else{
                if(state == FilesController.STATE.FIRSTALGORITM){
                    //pierwszy algorytm deszyfrowanie
                }else if(state == FilesController.STATE.SECONDALGORITM){
                    //drugi algorytm deszyfrownie
                }else{
                    // trzeci algorytm deszyfrownanie
                }
            }


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
    // te algorytmy można w oddzielnym pakiecie zrobić

    public String encrytpionText(String text, String text1, TextController.STATE state) {

        if(state == TextController.STATE.FIRSTALGORITM){
            //pierwszy algorytm
        }else if(state == TextController.STATE.SECONDALGORITM){
            //drugi algorytm
        }else{
            // trzeci algorytm
        }

        // tutaj trzeba algorytm zastosować żeby przerobił teskt

       return text;
    }
}
