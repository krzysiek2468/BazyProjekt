package org.example.algoritms;

import javafx.scene.control.TextArea;
import org.example.Text3Controller;

import java.util.ArrayList;
import java.util.List;

public class LFSR {
    ArrayList<Integer> positionList = new ArrayList<>();
    int[] w;
    int[] z;
    private static void converse1(int[] t1, String text1) {
        for (int i = 0; i < text1.length(); i++) {
            t1[i] = Integer.parseInt(String.valueOf(text1.charAt(i)));
        }
    }
    private static void converse2(int[] t2, String text2) {
        for (int i = 0; i < text2.length(); i++) {
            t2[i] = Integer.parseInt(String.valueOf(text2.charAt(i)));
        }
    }
    private static void position(int[] t2, ArrayList<Integer> pL, int size) {
        for (int i = 0; i < size; i++) {
            if (t2[i] == 1) {
                pL.add(i);
            }
        }
    }
    private static int xorOperation(int []t, ArrayList<Integer> pL) {
        int xorResult = t[pL.get(0)], c=1;
        while (c<pL.size()) {
            xorResult = (xorResult + t[pL.get(c)])%2;
            c++;
        }
        return xorResult;
    }
    public boolean checkKeys(String wielomian, String ziarno) {
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
           if (counter<2) {
               return false;
           }
           else {
               return true;
           }
       }
       else{
           return false;
       }
    }

    public void algorithm (String text, String text1, TextArea algorithmOutput, Text3Controller.STATE state) throws InterruptedException {
        List<String> lines = new ArrayList<>();
        w = new int[text.length()];
        z = new int[text1.length()];
        converse2(z, text1);
        position(z, positionList, text1.length());
        lines.add(text);
        Thread thread = new Thread(() -> {
            while(Text3Controller.state != Text3Controller.STATE.STOP){
                algorithmOutput.setText(algorithmOutput.getText() +"\n" + lines.get(lines.size()-1));
                lines.add(code(lines.get(lines.size()-1)));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            algorithmOutput.clear();
        });
        thread.start();
    }

    public String code(String text) {
        String result = "";
        converse1(w, text);
        int xorNumber = xorOperation(w, positionList);
        result += xorNumber;
        int pom = 0;
        while (pom<text.length()-1) {
            result += String.valueOf(w[pom]);
            pom++;
        }
        return result;
    }
}