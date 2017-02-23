package com.AE;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobileClass mobileList = new MobileClass();


    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobileList.printContactsList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;


            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of Names and Phone numbers.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for a item in the list.");
        System.out.println("\t 6 - To process list to an Array.");
        System.out.println("\t 7 - To quit the application.");
    }

    public static void addItem() {
        System.out.println("Please enter the mobile item: ");
        mobileList.addContact(scanner.nextLine().toLowerCase());
    }

    public static void modifyItem() {
        System.out.println("Current item name: ");
        String itemNo = scanner.nextLine().toLowerCase();
        scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine().toLowerCase();
        mobileList.modifyContactItem(itemNo, newItem);

    }

    public static void removeItem() {
        System.out.println("Enter item name: ");
        String itemNo = scanner.nextLine().toLowerCase();
        scanner.nextLine();
        mobileList.removeContactItem(itemNo);
    }

    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine().toLowerCase();
        if (mobileList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in your contacts list.");
        } else {
            System.out.println(searchItem + " is not your contacts list.");
        }
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(mobileList.getContactsList());


//        System.out.println(newArray);

        Contacts contacts = new Contacts(newArray);
//        System.out.println(newArray);
        System.out.println(contacts.getNameAndPhoneNumber());


    }
}

