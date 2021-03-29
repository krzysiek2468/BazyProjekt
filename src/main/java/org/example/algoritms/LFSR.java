package org.example.algoritms;

import javafx.scene.control.TextArea;
import org.example.Text3Controller;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LFSR {

    public boolean checkKeys(String wielomian , String ziarno) {
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





    public void algoritm( String text, String text1, TextArea algoritmOutput, Text3Controller.STATE state) throws InterruptedException {



        List<String> lines = new ArrayList<>();
        lines.add(text);

                Thread thread = new Thread(() -> {

            while(true){
                    algoritmOutput.setText(algoritmOutput.getText() +"\n" + lines.get(lines.size()-1));
                    lines.add(code(lines.get(lines.size()-1), text1));


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(state == Text3Controller.STATE.STOPT){
                    break;
                }
            }

        });

        thread.start();



    }

    public String code(String text , String text1){
        return text;
    }
}
