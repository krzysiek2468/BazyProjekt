package org.example.algoritms;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SteamCipher {



    public boolean checkKeys( String ziarno, String wielomian) {
        int counter = 0;
        if(wielomian.length() == ziarno.length() )
        {
            for(int i=0;i<ziarno.length();i++){
                if(wielomian.charAt(i) != '1' && wielomian.charAt(i) != '0' && ziarno.charAt(i)!='1' && ziarno.charAt(i)!='0'){
                    return false;
                }
                else if(ziarno.charAt(i) == '1'){
                    counter++;
                }
                else {

                }
            }
            if(counter<2){ return false; }
            else{ return true; }
        }
        else{
            return false;
        }
    }

    private int xor(int first , int second){
        if((first == 0 && second ==1 )||(first==1 && second ==0) ){
            return 1;
        }else{
            return 0;
        }
    }
    private  String getWordFromBytes(String bytes) {
        String answer = "";
        for (int i = 0; i < bytes.length(); i += 7) {
            String subByte = bytes.substring(i, i + 7);
            int ascii = Integer.parseInt(subByte, 2);
            String letter = Character.toString((char) ascii);
            answer+=letter;

        }
        return answer;

    }

    public String algoritm(String text, String text1, String text2){
        StringBuilder bytesText = new StringBuilder();
        for(int i=0;i<text.length();i++){
            String letter = text;

            byte[] letterInBytes = letter.getBytes(Charset.forName("UTF-8"));

            Integer bin = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(String.valueOf(letterInBytes[i]))));

            if (bin.toString().length() < 7) {
                for (int z = 0; z < 7 - bin.toString().length(); z++) {
                    bytesText.append(0);
                }
            }

            bytesText.append(bin);
        }
        LFSR algorytm = new LFSR();
        String kod = text2;
        String  zwracanaTablica ="";
        zwracanaTablica += xor( Integer.parseInt(String.valueOf(kod.charAt(0))),Integer.parseInt(String.valueOf(bytesText.charAt(0)))) ;

        for(int i=1;i<bytesText.length();i++) {
            kod = algorytm.algoritm2(kod, text1);
            int result =xor( Integer.parseInt(String.valueOf(kod.charAt(0))),Integer.parseInt(String.valueOf(bytesText.charAt(i)))) ;
            zwracanaTablica += result;
        }

        return  getWordFromBytes(zwracanaTablica);
    }

    public String encode(String text, String text1, String text2){
        return  algoritm(text ,text1 ,text2);
    }






    public String decode(String text, String text1, String text2){
        return  algoritm(text ,text1 ,text2);
    }

    // text wielomian // text1 ziarno // text2 do odczytu text3 do zapisu
    public void encodeFile(String text, String text1, String text2, String text3) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(text1));
        List<String> lista = new ArrayList<>();
        for (String line : lines) {

            lista.add(algoritm(line , text1, text)) ;

        }

        FileWriter writer = new FileWriter(text2);
        for(String str: lista) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }



    public void decodeFile(String text, String text1, String text2, String text3) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(text1));
        List<String> lista = new ArrayList<>();
        for (String line : lines) {

            lista.add(algoritm(line , text1, text)) ;

        }

        FileWriter writer = new FileWriter(text2);
        for(String str: lista) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}

