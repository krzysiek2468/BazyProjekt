package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class SzyfrVigenerea extends Algoritm{
    @Override
    public List<String> encryption(List<String> lines, String path3) {
        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(szyfruj(usunSpacje(line) , path3)) ;


        }


        return lista;
    }

    @Override
    public List<String> decryption(List<String> lines, String path3) {
        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(odszyfruj(usunSpacje(line) , path3)) ;


        }


        return lista;
    }

    @Override
    public String encryptionText(String text, String path3) {

        return szyfruj(usunSpacje(text) , path3);
    }

    @Override
    public String decryptionText(String text, String path3) {

        return odszyfruj(usunSpacje(text) , path3);
    }

    @Override
    public boolean checkKey(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public String usunSpacje(String text){
        String returnText = "";
        for(int i=0;i<text.length();i++){
            if(text.charAt(i) != ' '){
                returnText+=text.charAt(i);
            }
        }
        return returnText;
    }


    @Override
    public String szyfruj(String text, String key) {

        if(text.length() != key.length()){
            return text + " i " + key + " nie mają takiej samej długośic";
        }
        char[][] table = new char['z' + 1]['z' + 1];
        for (char a = 'a'; a <= 'z'; a++) {
            char b = a;
            for (int z = 'a'; z <= 'z'; z++) {
                if (b == 'z' + 1) {
                    b = 'a';
                }
                table[a][z] = b;

                b++;

            }

        }
        String returnText="";
        for (int i = 0; i < text.length(); i++) {
           returnText+= table[text.charAt(i)][key.charAt(i)];
        }
        return returnText;
    }

    @Override
    public String odszyfruj(String text, String key) {

        if(text.length() != key.length()){
            return text + " i " + key + " nie mają takiej samej długośic";
        }
        char[][] table = new char['z' + 1]['z' + 1];
        for (char a = 'a'; a <= 'z'; a++) {

            char b = a;
            for (int z = 'a'; z <= 'z'; z++) {
                if (b == 'z' + 1) {
                    b = 'a';
                }
                table[a][z] = b;

                b++;

            }

        }
        String returnedText = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                for (int z = 'a'; z <= 'z'; z++) {
                    if (text.charAt(i) == table[key.charAt(i)][z]) {
                        returnedText+= table['a'][z];

                    }
                }
            } else {

            }
        }

        return returnedText;
    }
}
