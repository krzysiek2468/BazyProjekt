package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class PrzestawienieMacierzowe2 {

    public List<String> encryption(List<String> lines , String path3){

        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(szyfruj(usunSpacje(line) , path3)) ;


        }


        return lista;

    }

    public List<String> decryption(List<String> lines , String path3){

        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(odszyfruj(usunSpacje(line) , path3)) ;


        }


        return lista;

    }

    public String encryptionText(String text , String path3){




        return szyfruj(usunSpacje(text) , path3);

    }

    public boolean checkKey(String text){
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;

    }

    public String szyfruj(String text , String key){


        int pom=0;

        String sB = "";

        ArrayList<Integer> positions = new ArrayList<>();

        for (char c='a'; c<='z'; c++) {
            for (int i = 0; i<key.length(); i++) {
                if (key.charAt(i) == Character.toUpperCase(c) || key.charAt(i) == Character.toLowerCase(c)) {
                    positions.add(i);
                }
            }
        }

        int poems = text.length()/key.length();
        int columns = key.length();
        String[][] table;
        if (text.length()%key.length() != 0) {
            ++poems;
        }


        table = new String[poems][columns];
        for (int i = 0; i < poems; i++) {
            for (int j = 0; j < columns; j++) {
                if (pom<text.length())
                {
                    table[i][j] = String.valueOf((text.charAt(pom)));
                    pom++;
                }
                else {
                    table[i][j] = String.valueOf('.');
                }
            }
        }



        for (int j=0; j<columns; j++) {
            int k = positions.get(j);
            for (int i = 0; i < poems; i++) {
                if (!(table[i][k].equals("."))) {
                    sB+=(table[i][k]);
                }
            }
            sB+= " ";
        }
        positions.clear();





        return  sB;
    }

    public String odszyfruj(String text, String key){



        String sB = "";

        ArrayList<Integer> positions = new ArrayList<>();

        for (char c='a'; c<='z'; c++) {
            for (int i = 0; i<key.length(); i++) {
                if (key.charAt(i) == Character.toUpperCase(c) || key.charAt(i) == Character.toLowerCase(c)) {
                    positions.add(i);
                }
            }
        }

        int poems = text.length()/key.length();
        int columns = key.length();
        String[][] table;
        int numberOfFileldsWithMoreLetters = 0;
        if (text.length()%key.length() != 0) {
            numberOfFileldsWithMoreLetters = text.length()%key.length();
            ++poems;
        }
        ArrayList<Integer> positions2 = new ArrayList<>();
        for(int p=0;p<numberOfFileldsWithMoreLetters;p++){
            positions2.add(positions.get(p));

        }

        System.out.println("positions.get(i)");
        System.out.println(positions2.size());

        int pom=0;
        table = new String[poems][columns];
        for (int i = 0; i < columns; i++) {

            for (int j = 0; j < poems; j++) {
                    if(pom<text.length()){
                    if (positions2.contains(i)) {
                        table[j][positions.get(i)] = String.valueOf((text.charAt(pom)));
                        pom++;
                    } else {
                        if (i != columns - 2) {
                            table[j][positions.get(i)] = String.valueOf((text.charAt(pom)));
                            pom++;
                        } else {
                            table[j][positions.get(i)] = String.valueOf('.');
                        }
                    }


                }
                System.out.println(positions.get(i));

            }


        }

        for (int j=0; j<columns; j++) {

            for (int i = 0; i < poems; i++) {
               System.out.println(table[i][j]);
            }

        }



        for (int j=0; j<columns; j++) {
            int k = positions.get(j);
            for (int i = 0; i < poems; i++) {
                if (!(table[i][k].equals("."))) {
                    sB+=(table[i][k]);
                }
            }
            if(j<=columns-2){
            sB+= " ";}
        }
        positions.clear();





        return  sB;
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
}
