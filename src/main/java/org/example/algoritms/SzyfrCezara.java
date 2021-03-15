package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class SzyfrCezara extends Algoritm {

    public static int eno1(char z, int k) {
        return z+k;
    }

    public static int eno2(char z, int k) {
        return z-26+k;
    }

    public static int deo1(char z, int k) {
        int w1 = z-(65+k);
        if (w1<0) w1 = 26 - Math.abs(w1);
        return w1+65;
    }

    public static int deo2(char z, int k) {
        int w2 = z-(97+k);
        if (w2<0) w2 = 26-Math.abs(w2);
        return w2+97;
    }

    @Override
    public List<String> encryption(List<String> lines, String path3) {
        List<String> lista = new ArrayList<>();
        //path3 to klucz
        for (String line : lines) {

            lista.add(szyfruj(usunSpacje(line) , path3)) ;
        }

        return lista;
    }

    @Override
    public List<String> decryption(List<String> lines, String path3) {
        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line : lines) {

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
        int variable;
        try {
            variable = Integer.parseInt(text);
        }catch (NumberFormatException e){
            return  false;
        }
        // ustawienie max klucza na 26
        if(0<=variable && variable <=26) {
            return  true;
        } else {
            return false;
        }
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
        int keyInt =  Integer.parseInt(key);
        String sB = "";
        for (int i=0; i<text.length(); i++) {
            if (text.charAt(i)>=65 && text.charAt(i)<=90-keyInt) {
                char w = (char) eno1(text.charAt(i), keyInt);
                sB+=w;
            }
            else if (text.charAt(i)>=90-keyInt && text.charAt(i)<= 90) {
                char w = (char) eno2(text.charAt(i), keyInt);
                sB+=w;
            }
            else if (text.charAt(i)>=97 && text.charAt(i)<=122-keyInt) {
                char w = (char) eno1(text.charAt(i), keyInt);
                sB+=w;
            }
            else if (text.charAt(i)>=123-keyInt && text.charAt(i)<=122) {
                char w = (char) eno2(text.charAt(i), keyInt);
                sB+=w;
            }
        }
        return sB;
    }

    @Override
    public String odszyfruj(String text, String key) {
        int keyInt =  Integer.parseInt(key);
        String sB="";
        for (int i=0; i<text.length(); i++) {
            if (text.charAt(i)>=65 && text.charAt(i)<=90) {
                char g = (char) deo1(text.charAt(i), keyInt);
                sB+=g;
            }
            else if (text.charAt(i)>=97 && text.charAt(i)<=122) {
                char g = (char) deo2(text.charAt(i), keyInt);
                sB+=g;
            }
        }
        return sB;

    }
}
