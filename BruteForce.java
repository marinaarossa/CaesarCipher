package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BruteForce extends Encryption {

    private static ArrayList<String> textToDecryption = new ArrayList();
    private static ArrayList<String> decryptionText = new ArrayList();


    public static void bruteForce() {
        acceptFile(textToDecryption);
        shiftingSymbol(textToDecryption);
        writeToFile(decryptionText);
    }
    private static void shiftingSymbol(ArrayList<String> text){
        char[] textToDecryptionArray;
        textToDecryptionArray = text.toString().toCharArray();
        for (int key = 1; key < ALPHABET.size(); key++) { // Перебираем ключ
            String shifting = "Сдвиг "+ key + ": ";
            decryptionText.add("\n" + shifting);
        for (int i = 0; i < textToDecryptionArray.length; i++) {
                if (ALPHABET.contains(textToDecryptionArray[i])) {
                    index = ALPHABET.indexOf(textToDecryptionArray[i]);
                    int position = (index - key) % 42;
                    if (position < 0) {
                        position = ALPHABET.size() + ((index - key) % 42);
                    }
                    String res = ALPHABET.get(position).toString();
                    decryptionText.add(res);
                } else continue;
            }
        }
        System.out.println("Варианты расшифровки:");
        for (String a : decryptionText) {
            System.out.print(a);
        }
    }
}
