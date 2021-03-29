package org.example.algoritms;

public class SteamCipher {

    

    public boolean checkKeys( String wielomian, String ziarno) {
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

    public String encode(String text, String text1, String text2){
        return "ss";
    }

    public String decode(String text, String text1, String text2){
        return "ss";
    }


    public void encodeFile(String text, String text1, String text2, String text3) {
        System.out.println("DDDDDD");
    }

    public void decodeFile(String text, String text1, String text2, String text3) {
        System.out.println("EEEEEE");
    }
}
