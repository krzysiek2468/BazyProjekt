package org.example.algoritms;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

public class PrzestawienieMacierzowe1 {

    public List<String> encryption(List<String> lines , String path3){
        List<String> lista = new ArrayList<>();
        for (String line :
                lines) {

            lista.add(szyfroj(usunSpacje(line) , prepereString(path3))) ;


        }
        return lista;

    }

    public List<String> decryption(List<String> lines , String path3){

        List<String> lista = new ArrayList<>();
        for (String line :
                lines) {

            lista.add(odszyfroj(usunSpacje(line) , prepereString(path3))) ;


        }
        return lista;
    }

    public String encryptionText(String text , String path3){

        //path3 to klucz


        //tutaj zakodowujemy lines

        return szyfroj(usunSpacje(text) , prepereString(path3));

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

    public String szyfroj(String text , String key){


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






        String returnText = "";
        int position = 0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                int getValueFromString = key.charAt(position)-49;

                if(tab[number1][getValueFromString] != '.'){

                    returnText += tab[number1][getValueFromString];
                }
                position++;
            }
            position = 0;

        }

        return returnText;

    }

    public String odszyfroj(String text , String key){
        int rows = text.length() / key.length();
        int numbersOfEmptyFiled =key.length() - text.length()%(key.length());

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

        int a=0;
        for(int z=0;z<numbersOfEmptyFiled;z++){
            int number = key.length()-a;


            for(int i=0;i<key.length()-1;i++){
                if(key.charAt(i) -48 ==number){
                    tab[rows-1][i]='=';
                }
            }
            a++;


//            int variable =key.charAt(key.length()-1-a)-48;
//            tab[rows-1][variable-1]='=';
//            System.out.println("DDDDDDDDDDDDDDDD");
//            a++;

        }

        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){

                System.out.println(tab[number1][number2]);

            }


        }

        int m=0;
        for(number1 = 0; number1<rows;number1++){
            for(number2=0;number2<longs;number2++){
                if(tab[number1][number2]!='='){
                if(m<text.length()){
                    tab[number1][number2] = text.charAt(m);
                    m++;
                }
                }else{
                    tab[number1][number2] = '.';
                }

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

                        }
                    }
                }


            }


        }

        return returnText;
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
