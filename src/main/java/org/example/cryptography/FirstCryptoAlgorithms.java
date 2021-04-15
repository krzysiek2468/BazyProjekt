package org.example.cryptography;

import org.example.FilesController;
import org.example.TextController;
import org.example.algoritms.PrzestawienieMacierzowe1;
import org.example.algoritms.PrzestawienieMacierzowe2;
import org.example.algoritms.RailFence;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//można pokombinować i zrobić tą klsę abstrakcyjną albo zrobić w niej metody otwierania i zapisywania do plików a kodowanie gdzie indziej

public class FirstCryptoAlgorithms {
    public final  RailFence alg;
    public final PrzestawienieMacierzowe1 alg2;
    public final PrzestawienieMacierzowe2 alg3;

    public FirstCryptoAlgorithms() {
        this.alg  = new RailFence();
        this.alg2  =new PrzestawienieMacierzowe1();
        this.alg3 = new PrzestawienieMacierzowe2();

    }

    public void encryption(String path , String path2 , String path3 , int zeroForEncryptionOneForDecryption, FilesController.STATE state){

        // nie wiem czy to moża zostawić w jednym try catxh
        // te algorytmy mają pobierać tą listę lines i zwracać List<String>  tu można to co się zwróci zamiast lines dać for(String str: lines)
        // trzeba sprawdzić czy te adresy do plików są prawidłowe bo teraz jak wpiszesz a czy cos innego zamiast ścierzki to ten exception wywala
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            String line = Files.readString(Paths.get(path));
            List<String> encrypted;
            if(zeroForEncryptionOneForDecryption == 0){
                if(state == FilesController.STATE.FIRSTALGORITHM){
                    //pierwszy algorytm szyfrowanie
                     encrypted = alg.encryption(lines , path3);

                }else if(state == FilesController.STATE.SECONDALGORITHM){
                    //drugi algorytm szyfrowanie
                     encrypted = alg2.encryption(lines,path3);
                }else{
                     encrypted = alg3.encryption(lines,path3);
                }
            }else{
                if(state == FilesController.STATE.FIRSTALGORITHM){
                    encrypted = alg.decryption(lines,path3);
                }else if(state == FilesController.STATE.SECONDALGORITHM){
                    encrypted = alg2.decryption(lines,path3);
                }else{
                    encrypted = alg3.decryption(lines,path3);
                }
            }


            // tutaj trzeba dodać algorytm krypto

            FileWriter writer = new FileWriter(path2);
            for(String str: encrypted) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    // te algorytmy można w oddzielnym pakiecie zrobić

    public String encrytpionText(String text, String text1, TextController.STATE state) {
        String returnedText;
        if(state == TextController.STATE.FIRSTALGORITHM){
            returnedText = alg.encryptionText(text,text1);
        }else if(state == TextController.STATE.SECONDALGORITHM){
            returnedText = alg2.encryptionText(text,text1);
        }else{
            returnedText = alg3.encryptionText(text,text1);
        }



       return returnedText;
    }
}
