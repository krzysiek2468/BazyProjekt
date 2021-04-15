package org.example.cryptography;

import org.example.Files2Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ThirdAlgorithms {

    public void encryption(String path, String path2) {


        //List<String> encrypted = lines;
//            if(zeroForEncryptionOneForDecryption == 0){
//                if (state == Files2Controller.STATE.FIRSTALGORITM) {
//                    //pierwszy algorytm szyfrowanie
//                    encrypted = alg.encryption(lines , path3);
//
//                } else if(state == Files2Controller.STATE.SECONDALGORITM) {
//                    //drugi algorytm szyfrowanie
//                    encrypted = alg2.encryption(lines,path3);
//                } else {
//                    encrypted = alg3.encryption(lines,path3);
//                }
//            } else {
//                if(state == Files2Controller.STATE.FIRSTALGORITM){
//                    encrypted = alg.decryption(lines,path3);
//                }else if(state == Files2Controller.STATE.SECONDALGORITM){
//                    encrypted = alg2.decryption(lines,path3);
//                }else{
//                    encrypted = alg3.decryption(lines,path3);
//                }


        // tutaj trzeba dodać algorytm krypto

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            DataOutputStream strumień2 = new DataOutputStream(new FileOutputStream(path2));
            System.out.println(lines.get(0));
            strumień2.writeUTF(lines.get(0));

            strumień2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Błąd wejścia-wyjścia");
        }
    }
}





