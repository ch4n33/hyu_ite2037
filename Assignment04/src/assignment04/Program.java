package assignment04;

import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program{

    public static void main(String[] args) {
        DictionaryArray dictionaryArray = new DictionaryArray();
        Scanner keyboard = new Scanner(System.in);
        int i;
        String string1, string2;
        boolean endCoin = true;
        while (endCoin) {
            System.out.println("============Main Menu============");
            System.out.println("(1) Add word to dictionary");
            System.out.println("(2) Show definition of word");
            System.out.println("(3) Show word list");
            System.out.println("(4) Remove word");
            System.out.println("(5) Print all contents");
            System.out.println("(6) Exit Program");
            System.out.println("=================================");
            System.out.print("choose a menu : ");
            i = keyboard.nextInt();
            keyboard.nextLine();
            switch (i) {
                case 1: {
                    System.out.print("word : ");
                    string1 = keyboard.nextLine();
                    System.out.print("definition : ");
                    string2 = keyboard.nextLine();
                    try {
                        dictionaryArray.insertEntry(string1, string2);
                    }catch(AlreadyExistsInDicException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.print("word for searching : ");
                    string1 = keyboard.nextLine();
                    try{
                        dictionaryArray.getDefinition(string1);
                    }catch (EmptyException e){
                        System.out.println(e.getMessage());
                    }catch (NotInDicException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        dictionaryArray.printWord();
                    }catch(EmptyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {

                    System.out.print("word to remove : ");
                    string1 = keyboard.nextLine();
                    try{
                        dictionaryArray.removeWord(string1);
                    }catch (EmptyException e){
                        System.out.println(e.getMessage());
                    }catch (NotInDicException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    try{
                        dictionaryArray.printAll();
                    }catch (EmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter a file name : ");
                    string1 = keyboard.nextLine();
                    PrintWriter printWriter = null;
                    try {
                        printWriter = new PrintWriter(new FileOutputStream(string1));
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    ArrayList<WordDefinitionPair> DicList = dictionaryArray.getDicList();
                    i = 1;
                    for (WordDefinitionPair word : DicList){
                        printWriter.println(i++ + ". word       : " + word.getWord());
                        printWriter.println(     "   definition : " + word.getDefinition());
                        printWriter.println();
                    }
                    printWriter.close();
                    keyboard.close();
                    System.out.println("exit program");
                    endCoin = false;
                }
                default: {
                    System.out.println("Insert 1 ~ 6");
                    break;
                }
            }
        }
    }
}
