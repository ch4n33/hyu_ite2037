package com.company;
import java.util.Scanner;

public class PriceListApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        PriceList priceList = new PriceList();
        String S;
        int i, j=0;
        boolean endCoin = true;
        while(endCoin) {
            menu();
            i = keyboard.nextInt();
            keyboard.nextLine();
            switch (i) {
                case 1: {

                    try {
                        if (j != 0) {
                            throw new FullArrayException("list is full");
                        }
                    } catch (FullArrayException exception) {
                        System.out.println(exception.getMessage());
                        System.out.println("try to expand..");
                        System.out.println("how much will you expand?");
                        priceList.extendList(keyboard.nextInt());
                        keyboard.nextLine();
                        System.out.println("List is extended.");
                    }
                    while (j < priceList.getVertical()) {
                        System.out.print("company :");
                        S = keyboard.nextLine();
                        System.out.print("supply price :");
                        i = keyboard.nextInt();
                        keyboard.nextLine();
                        Gasoline G = new Gasoline(i, S);
                        priceList.setPriceList(j, 0, G);
                        System.out.println("gasoline added");

                        System.out.print("company :");
                        S = keyboard.nextLine();
                        System.out.print("supply price :");
                        i = keyboard.nextInt();
                        keyboard.nextLine();
                        Diesel D = new Diesel(i, S);
                        priceList.setPriceList(j, 1, D);
                        System.out.println("diesel added");

                        j++;
                    }
                    break;
                }
                case 2:
                    System.out.println("region number to view : ");
                    i = keyboard.nextInt();
                    keyboard.nextLine();
                    if (i >= priceList.getVertical() || i < 0) {
                        System.out.println("out of index!");
                        break;
                    }
                    System.out.println(priceList.getRegionInfo(i));
                case 3:
                    try {
                        priceList.printList();
                        break;
                    } catch (Exception e) {
                        System.out.println("no data");
                    } finally {
                        break;
                    }
                case 4: {
                    System.out.println("exit application");
                    endCoin = false;
                    break;
                }
                default: {
                    System.out.println("insert 1~4");
                    break;
                }
            }
        }
        keyboard.close();

    }
    public static void menu(){
        System.out.println("===========main menu===========");
        System.out.println("(1) Add a oil to price list");
        System.out.println("(2) View Region Information");
        System.out.println("(3) Print the entire price list");
        System.out.println("(4) Exit the program");
        System.out.println("===============================");
        System.out.print(  "choose a menu :");
    }
}
