package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("Hello, " + name);

        int myNum = rand.nextInt(100) + 1;
        System.out.println("Cheat: " + myNum);

        for (int i = 0; i < 10; i++) {
            int userNum = askGuess();

            if (myNum < userNum) {
                System.out.println("My number is less then yours");
            } else if (myNum > userNum) {
                System.out.println("My number is greater then yours");
            } else {
                System.out.println("You win!");
                break;
            }
        }

    }

    static int askGuess() {
        for (; ; ) {
            System.out.println("Enter your guess");
            int num = scan.nextInt();
            if (num >= 1 && num <= 100) {
                return num;
            } else {
                System.out.println("Please enter a number from 1 to 100");
            }
        }
    }

}
