package org.example.algoritms;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

public class PrzestawienieMacierzowe1 {

    public List<String> encryption(List<String> lines , String path3){
        List<String> lista = new ArrayList<>();
        for (String line :
                lines) {
            lista.add(szyfruj(line , prepereString(path3))) ;

        }
        return lista;

    }

    public List<String> decryption(List<String> lines , String path3){

        //path3 to klucz
        List<String> output = lines;

        //tutaj zakodowujemy lines

        return output;

    }

    public String encryptionText(String text , String path3){

        //path3 to klucz


        //tutaj zakodowujemy lines

        return odszyfruj(text , prepereString(path3));

    }

    public boolean checkKey(String text){
        int count = text.length();

        if(count%2 == 0){

            return false;
        }
        char[] list = text.toCharArray();
        boolean[] numbers = new boolean[(count/2)+1];
        for (boolean value:numbers) {
            value=false;
        }

        for(int number = 0; number<count ; number++){
            if(number%2 == 0){
                int checkedValue;
                try {
                    checkedValue = Integer.parseInt(String.valueOf(list[number]));
                }catch (Exception e){
                    return false;
                }
                if(checkedValue<= numbers.length){
                    System.out.println(checkedValue);
                    if(numbers[checkedValue -1] == true){
                        return false;
                    }else {
                        numbers[checkedValue -1] = true;
                    }
                }else{
                    return false;
                }

            }else{
                if(list[number] == '-'){
                    // pętla idzie dalej
                }
                else{
                    return false;
                }
            }
        }
        return true;

    }

    public String prepereString(String key){
        String keyy = "";
        for (int counter=0 ; counter<key.length();counter++){
            if(counter%2==0){
                keyy= keyy + key.charAt(counter);
            }
        }
        return keyy;
    }

    public String szyfruj(String text , String key){


        int rows = text.length() / key.length();


        if((text.length())%(key.length()) >0){

            rows++;
        }

        int longs = key.length();




        char[][] tab = new char[rows][longs];
        int number1=0;
        int number2=0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
               tab[number1][number2] = '.';
            }
        }




        int m=0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                if(m<text.length()){
                    tab[number1][number2] = text.charAt(m);
                    m++;
                }

            }


        }





        // odczzzytywanie z tablicy
        String returnText = "";
        int position = 0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                int getValueFromString = key.charAt(position)-49;

                if(tab[number1][getValueFromString] != '.'){
                    System.out.println("DDDDDDDDDDDD");
                    returnText += tab[number1][getValueFromString];
                }
                position++;
            }
            position = 0;

        }

        return returnText;

    }

    public String odszyfruj(String text , String key){
        int rows = text.length() / key.length();


        if((text.length())%(key.length()) >0){

            rows++;
        }

        int longs = key.length();




        char[][] tab = new char[rows][longs];
        int number1=0;
        int number2=0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                tab[number1][number2] = '.';
            }
        }




        int m=0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                if(m<text.length()){
                    tab[number1][number2] = text.charAt(m);
                    m++;
                }

            }


        }

        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                System.out.println(tab[number1][number2]);

            }


        }






        // odczzzytywanie z tablicy
        String returnText = "";
        int position = 0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                for(int number3=0; number3<longs;number3++ ){

                    int getValueFromString = key.charAt(number3)-49;
                    if(getValueFromString == number2){
                        if(tab[number1][number3] !='.'){
                        returnText += tab[number1][number3];}
                        else{
                            number2++;
                        }
                    }
                }


            }


        }

        return returnText;
    }
}
