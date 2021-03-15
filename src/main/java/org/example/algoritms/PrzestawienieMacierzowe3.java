package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class PrzestawienieMacierzowe3 extends Algoritm{
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
        return text;
    }

    @Override
    public String odszyfruj(String text, String key) {
        return text;
    }
}
