package assignment2.FileDemo;

import java.util.Scanner;

/**
 * Write a description of class ScannerDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileInputDemo
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("hello what is your name?");
        String name = keyboard.next();
        System.out.println(name+" is a nice name"); 
        
        // add code to read a users age and GPA
        
        
        // read all the data from the bankData.txt file
        //1  create a File object initialized to bankData.txt
        //2  open a try block
        //3  create a new Scanner object initialized to file
        //4  close try block and catch FileNotFoundException
        //5  read a string then a double from your new scanner
        //6  print each record until end of file
        //7  compute the total sum of bank account balances
    }
}
