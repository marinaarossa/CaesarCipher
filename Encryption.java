package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Encryption {

    public static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    private static ArrayList<String> textToEncryption = new ArrayList();
    private static ArrayList<String> encryptionText = new ArrayList();
    public static int key;
    public static int index;
    public static Scanner scanner = new Scanner(System.in);
    public static String error = "Ошибка! Файл не найден!";

    public static void encrypt() {
        acceptFile(textToEncryption);
        acceptKey();
        shiftingSymbol(textToEncryption);
        writeToFile(encryptionText);
    }

    protected static void acceptFile(ArrayList<String> text) {
        // Принимаем пользовательский текст и выводим его на экран
        System.out.println("Введите путь к файлу.");
        try {
            BufferedReader usersText = new BufferedReader(new FileReader(scanner.nextLine()));
            String str;
            while ((str = usersText.readLine()) != null) {
                if (!str.isEmpty())
                    text.add(str);
                System.out.println("Твой текст:" + '\n' + str);
            }
        } catch (Exception e) {
            System.out.println(error);
            System.exit(0);
        }
    }

    protected static void acceptKey() {
        System.out.println("Укажи сдвиг(ключ).");
        key = scanner.nextInt();
        System.out.println("Твой ключ:" + key + '\n' + "Приступаю к работе!");
    }
    private static void shiftingSymbol(ArrayList<String> text) {
        char[] array;
        array = text.toString().toCharArray(); //Преобразуем лист с текстом в массив чар
        for (int i = 1; i < array.length - 1; i++) {
            if (ALPHABET.contains(array[i])) { // Проверяем, есть ли символ в алфавите
                index = ALPHABET.indexOf(array[i]); // Ищем позицию символа
                String result = ALPHABET.get((index + key) % 41).toString(); // Вычисляем новую позицию символа с учётом сдвига и преобрузуем в Стринг
                encryptionText.add(result);
            } else continue;
        }
        System.out.println("Зашифрованный текст:");
        for (String a : encryptionText) {
            System.out.print(a);
        }
    }
    protected static void writeToFile(ArrayList<String> resultText) {
        System.out.println('\n' + "Введите путь к файлу в формате .txt, в который хотите сохранить результат.");
        String res = String.join("", resultText); //Запишем зашифрованный текст из листа в стринг
        //Запишем зашифрованный текст из Стринг в Файл
        Scanner scan = new Scanner(System.in);
        try {
            BufferedWriter result = new BufferedWriter(new FileWriter(scan.nextLine()));
            result.write(res);
            result.flush();
        } catch (Exception e) {
            System.out.println(error);
            System.exit(0);
        }
        System.out.println("Файл сохранён!");
        System.exit(0);
    }
}

