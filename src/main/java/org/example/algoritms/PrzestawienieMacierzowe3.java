package org.example.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrzestawienieMacierzowe3 extends Algorithm {
    @Override
    public List<String> encryption(List<String> lines, String path3) {
        List<String> lista = new ArrayList<>();
        //path3 to klucz

        for (String line : lines) {

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
     //Konwersja tablicy charów na Character ponieważ Comperator musi uzywac Obiektów
        Character[] convertedCharArrayToCharacterArray= key.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        ArrayIndexComparator comparator = new ArrayIndexComparator(convertedCharArrayToCharacterArray);
        //Otrzymujemy posortowaną tablicę przechowującą indeksy liter klucza w odpowiedniej kolejności np. gdy pierwsza litera jest na pozycji 5 to tablica[0] = 5 i tyle wynosi dlugosc wiersza
        Integer[] lengthInRow = comparator.createIndexArray();
        Arrays.sort(lengthInRow, comparator);
    //Ustalenie ilości wierszy
        int size=0;
        int rows=0;
        while(size<text.length()){
            if(rows<lengthInRow.length)
            {
                size+=(lengthInRow[rows]+1); // tutaj plus jeden poniewaz  przechowujemy index a nie długość
                rows++;
            }else
            {
                return "Błąd!! za krótki klucz";
            }
        }
        //dorzucenie kropek aby dokonczyć ostatni wiersz do odpowiedniego momentu
        while(size!=text.length()){
            text+=".";
        }
        //Wpisanie danych w wiersz
        List<String> textInRow=new ArrayList<String>();
        int index=0;
        for(int i =0;i<rows;i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0;j<=lengthInRow[i];j++){ //wpisujemy po prostu w indeksy do maksymalnej dlugosci wiersza
                if(index<text.length()) {
                    stringBuilder.append(text.charAt(index));
                    index++;
                }
            }
            textInRow.add(stringBuilder.toString());
        }
        //Skladanie wyniku
        StringBuilder resultsBuilder = new StringBuilder();
        for(int i=0;i<key.length();i++){
            for(int j=0;j<rows;j++){
                if(lengthInRow[i]<(textInRow.get(j).length())){
                    resultsBuilder.append(textInRow.get(j).charAt(lengthInRow[i])); //Bierzemy tu kolejne wiersze oraz znak z kolumny, tej która jesk kolejna w posortowaej liście indeksów
                }
            }
            resultsBuilder.append(" ");
        }
        return resultsBuilder.toString();
    }


    @Override
    public String odszyfruj(String text, String key) {
        //Konwersja tablicy charów na Character ponieważ Comperator musi uzywac Obiektów
        Character[] convertedCharToCharacterArray= key.chars().mapToObj(c ->
                (char)c).toArray(Character[]::new);
        ArrayIndexComparator comparator = new
                ArrayIndexComparator(convertedCharToCharacterArray);
//Otrzymujemy posortowaną tablicę przechowującą indeksy liter klucza w odpowiedniej kolejności
        Integer[] lengthInRow = comparator.createIndexArray();
        Arrays.sort(lengthInRow, comparator);
//Ustalenie ilości wierszy
        int size=0;
        int rows=0;
        while(size<text.length()){
            if(rows<lengthInRow.length){
                size+=(lengthInRow[rows]+1); // tutaj plus jeden ponieważ przechowujemy index a nie długość
                rows++;
            }else{
                return "Błąd!!! za krótki klucz";
            }
        }
//Wpisanie danych
        char[][] textMatrix = new char[rows][key.length()];
        int index=0;
        for(int x=0;x<key.length();x++)
        {
            for(int i=0;i<rows;i++){
                if(index<text.length()){
                    if(lengthInRow[x]>lengthInRow[i]){ //Jeśli indeks kolumny do której wpisujemy jest wyzszy niz dlugość wiersza to wpisujemy spacje
                        textMatrix[i][lengthInRow[x]]=' ';
                    } else
                    {
                        textMatrix[i][lengthInRow[x]]=text.charAt(index);
                        index++;
                    }
                }
            }
        }
//Stworzenie pierwotnego tekstu
        String returnText = "";
        for(int i =0;i<rows;i++){
            for(int j=0;j<key.length();j++){
                if(!Character.isWhitespace(textMatrix[i][j])) {
                    if(returnText.length()<text.length()){
                        returnText+=textMatrix[i][j];
                    }
                }
            }
        }
        return returnText;

    }
}
