package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Decryption extends Encryption {

    private static ArrayList<String> textToDecryption = new ArrayList();
    private static ArrayList<String> decryptionText = new ArrayList();

    public static void decrypt() {
        acceptFile(textToDecryption);
        acceptKey();
        shiftingSymbol(textToDecryption);
        writeToFile(decryptionText);
    }
private static void shiftingSymbol(ArrayList<String> text)
    {
        char[] textToDecryptionArray;
        textToDecryptionArray = text.toString().toCharArray();
        for (int i = 0; i < textToDecryptionArray.length; i++) {
            if (ALPHABET.contains(textToDecryptionArray[i])) {
                index = ALPHABET.indexOf(textToDecryptionArray[i]);
                int position = (index - key) % 42; // Вычисляем новую позицию символа с учётом сдвига
                if (position < 0) { // Проверка позиции на отрицательность
                    position = ALPHABET.size() + (position);
                }
                String result = ALPHABET.get(position).toString();
                decryptionText.add(result); // Добавляем расшифрованный символ в лист с результатом
            } else continue;
        }
        System.out.println("Расшифрованный текст:");
        for (String a : decryptionText) {
            System.out.print(a);
        }
    }
}
