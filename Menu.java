package com.company;
import java.util.Scanner;

public class Menu {
        public static String encryption = "Введи 1, если хочешь зашифровать сообщение.";
    private static String decryption = "Введи 2, если хочешь расшифровать сообщение с помощью ключа.";
    private static String bruteForce = "Введи 3, если хочешь расшифровать сообщение c помощью Brute Force.";
    private static String exit = "Введи 4, если хочешь завершить работу программы.";
    private static Scanner sc = new Scanner(System.in);

    public static void main (String[] args){
        System.out.println(encryption + '\n' + decryption + '\n' + bruteForce + '\n' + exit);
       menu(sc.nextInt());
    }
    private static int menu(int decision) {

        int i = 0;
        switch (decision){
            case 1 : Encryption.encrypt();
            case 2 : Decryption.decrypt();
            case 3 : BruteForce.bruteForce();
            case 4 : System.exit(0);
        }
        return i;
    }
}
