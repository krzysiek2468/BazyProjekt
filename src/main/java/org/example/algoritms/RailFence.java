package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class RailFence {

    public List<String> encryption(List<String> lines , String path3){
        List<String> lista = new ArrayList<>();
        //path3 to klucz
        int key =Integer.parseInt(path3);
        for (String line : lines) {

           lista.add(szyfruj(usunSpacje(line) , key)) ;

        }

        return lista;

    }

    public List<String> decryption(List<String> lines , String path3){
        List<String> lista = new ArrayList<>();
        //path3 to klucz
        int key =Integer.parseInt(path3);
        for (String line :
                lines) {
            lista.add(rozszyfruj(usunSpacje(line) , key)) ;
        }

        return lista;

    }

    public String encryptionText(String text , String path3){

        //path3 to klucz
        String output = text;

        //tutaj zakodowujemy lines

        return szyfruj(usunSpacje(text) , Integer.parseInt(path3));

    }

    public boolean checkKey(String text){
        int variable;
        try {
             variable = Integer.parseInt(text);
        }catch(NumberFormatException e){
            return  false;
        }
        // ustawienie max klucza na 100
        if(0<variable && variable <100 ){
            return  true;
        }else{
            return false;
        }


    }

    public  String szyfruj(String message, int k){
        String[][] tab = new String[k][message.length()];
        String returnedMessage= "";


        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length; j++){
                tab[i][j]=".";
            }
        }

        for(int i=0; i<k; i++){
            for(int j=i; j<k; j++){

                while(j<message.length()){
                    tab[i][j] = message.substring(j, j+1);
                    j = j+((2*k)-2);
                }


                int o = k;
                int h = k-1;
                for(int l=k-2; l>0; l--){
                    h = h+1;
                    while(o<message.length()){
                        tab[l][o]=message.substring(o, o+1);
                        o=o+((2*k)-2);
                    }
                    o = h+1;
                }
            }
        }

        for(int i=0; i<k; i++){
            for(int j=0; j<message.length(); j++){
                if(tab[i][j] != "."){

                    returnedMessage= returnedMessage + tab[i][j];
                }
            }
        }

        return returnedMessage;
    }

    public  String rozszyfruj(String message, int k) {
        char[][] tab = new char[k][message.length()];
        String returnedMessage = "";


        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length; j++){
                tab[i][j]='.';
            }
        }

        for(int i=0; i<k; i++){
            for(int j=i; j<k; j++){

                while(j<message.length()){
                    tab[i][j] = '*';
                    j = j+((2*k)-2);
                }

                int o = k;
                int h = k-1;
                for(int l=k-2; l>0; l--){
                    h = h+1;
                    while(o<message.length()){
                        tab[l][o] = '*';
                        o=o+((2*k)-2);
                    }
                    o = h+1;
                }
            }
        }


        char[] szyfr = message.toCharArray();
        int m = 0;

        for(int i=0; i<k; i++){
            for(int j=0; j<message.length(); j++){
                if(tab[i][j] == '*'){
                    tab[i][j] = szyfr[m];

                    m = m+1;
                }
            }
        }

        char[] odszyfrowana = new char[message.length()];

        for(int i=0; i<k; i++){
            for(int j=i; j<k; j++){

                while(j<message.length()){
                    odszyfrowana[j] = tab[i][j];
                    j = j+((2*k)-2);
                }

                int o = k;
                int h = k-1;
                for(int l=k-2; l>0; l--){
                    h = h+1;
                    while(o<message.length()){
                        odszyfrowana[o] = tab[l][o];
                        o=o+((2*k)-2);
                    }
                    o = h+1;
                }
            }
        }

        for(int i=0; i<odszyfrowana.length; i++){
            returnedMessage= returnedMessage + odszyfrowana[i];
        }

        return returnedMessage;

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
