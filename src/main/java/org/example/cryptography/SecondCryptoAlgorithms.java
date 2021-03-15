package org.example.cryptography;
import org.example.Files2Controller;
import org.example.Text2Controller;
import org.example.algoritms.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SecondCryptoAlgorithms {
    public final PrzestawienieMacierzowe3 alg;
    public final SzyfrCezara alg2;
    public final SzyfrVigenerea alg3;

    public SecondCryptoAlgorithms() {
        this.alg  = new PrzestawienieMacierzowe3();
        this.alg2  =new SzyfrCezara();
        this.alg3 = new SzyfrVigenerea();

    }

    public void encryption(String path , String path2 , String path3 , int zeroForEncryptionOneForDecryption, Files2Controller.STATE state){

       try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            String line = Files.readString(Paths.get(path));
            List<String> encrypted;
            if(zeroForEncryptionOneForDecryption == 0){
                if (state == Files2Controller.STATE.FIRSTALGORITM) {
                    //pierwszy algorytm szyfrowanie
                    encrypted = alg.encryption(lines , path3);

                } else if(state == Files2Controller.STATE.SECONDALGORITM) {
                    //drugi algorytm szyfrowanie
                    encrypted = alg2.encryption(lines,path3);
                } else {
                    encrypted = alg3.encryption(lines,path3);
                }
            } else {
                if(state == Files2Controller.STATE.FIRSTALGORITM){
                    encrypted = alg.decryption(lines,path3);
                }else if(state == Files2Controller.STATE.SECONDALGORITM){
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

    public String encryptionText(String text, String text1, Text2Controller.STATE state) {
        String returedText;
        if(state == Text2Controller.STATE.FIRSTALGORITM) {
            returedText = alg.encryptionText(text,text1);
        } else if(state == Text2Controller.STATE.SECONDALGORITM) {
            returedText = alg2.encryptionText(text,text1);
        } else {
            returedText = alg3.encryptionText(text,text1);
        }
        return returedText;
    }

    public String decryptionText(String text, String text1, Text2Controller.STATE state) {
        String returnedText;
        if (state == Text2Controller.STATE.FIRSTALGORITM) {
            returnedText = alg.decryptionText(text,text1);

        } else if (state == Text2Controller.STATE.SECONDALGORITM) {
            returnedText = alg2.decryptionText(text,text1);

        } else{
            returnedText = alg3.decryptionText(text,text1);
        }
        return returnedText;
    }
}

