package org.example.algoritms;

import java.util.ArrayList;
import java.util.List;

public abstract class Algoritm {

    public abstract List<String> encryption(List<String> lines , String path3);

    public abstract List<String> decryption(List<String> lines , String path3);

    public abstract String encryptionText(String text , String path3);

    public abstract String decryptionText(String text , String path3);

    public abstract boolean checkKey(String text);

    public abstract String szyfruj(String text , String key);

    public abstract String odszyfruj(String text , String key);


}
