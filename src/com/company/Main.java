package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 0 && args[0].equals("nogui")) {
            nogui();
        }
        else {
            new MainWindow();
        }
    }

    public static void nogui() {
        String str;
        int shift;
        System.out.print("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.print("Enter shift: ");
        shift = scanner.nextInt();
        System.out.println("1.Encrypt\n2.Decrypt");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println(MainLogic.encryptText(str.toUpperCase(), shift));
                break;
            case 2:
                System.out.println(MainLogic.decryptText(str.toUpperCase(), shift));
                break;
        }

    }
}
