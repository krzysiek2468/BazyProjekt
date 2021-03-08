package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public class PrzestawienieMacierzowe2 {

    public List<String> encryption(List<String> lines , String path3){

        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(szyfruj(line , path3)) ;


        }


        return lista;

    }

    public List<String> decryption(List<String> lines , String path3){

        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line :
                lines) {

            lista.add(odszyfruj(line , path3)) ;


        }


        return lista;

    }

    public String encryptionText(String text , String path3){




        return szyfruj(text , path3);

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

    public String szyfruj(String text , String path){

        int rows = text.length() / path.length();


        if((text.length())%(path.length()) >0){

            rows++;
        }

        int longs = path.length();




        char[][] tab = new char[rows][longs];
        int number1=0;
        int number2=0;
        int m=0;

        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                if(m<text.length()){
                    tab[number1][number2] = text.charAt(m);
                    m++;
                }
            }
        }
        List<String> lista = new ArrayList<>();
        int z=0;
        String returnText = "";
        for(number1 = 0; number1<longs;number1++){
            for(number2=0;number2<rows;number2++){
                if(tab[number2][number1] !='.'){
                   returnText+= tab[number2][number1];
                }
            }
            lista.add(returnText);
            returnText="";
        }

        char[] tabela = new char[path.length()];
        char[] tabela2 = new char[path.length()];
        int[] tabela3 = new int[path.length()];
        for(int i=0;i<path.length();i++){
            tabela[i] = path.charAt(i);

        }
        int count = path.length();
        char value = 0;
        int number = 0;
        int i=0;
        for (int j=0;j<path.length();j++){
            for(i=0;i<count;i++){
                if(tabela[number]!='.') {
                    if (value < tabela[i]) {
                        value = path.charAt(i);
                        number = i;
                    }
                }

            }

            tabela2[j]=value;
            tabela[number]='.';

          //  tabela3[i]=j;


        }

        for (int j=0;j<path.length();j++) {
            System.out.println(tabela2[j]);
        }



        return  text;
    }

    public String odszyfruj(String text, String path){


        return  text;
    }
}
