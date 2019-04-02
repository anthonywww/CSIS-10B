package assignment2.FileDemo;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
 
 
public class StudentReadFile { 
    
  public static void main(String[] args) { 
    System.out.println("\f");   
    
    // declare any data structures you will use to hold data from the file before the try block
    
    Student [] roster = new Student[200];  // array that holds 200 student objects
    int size=0;                              // number of items array actually holds
    
    File file = new File("Student100.txt"); // refers to the file we will read
    
    try {  
        Scanner fileInput = new Scanner(file);   // this could fail so we put it in a try block        
        int k=0;  
        while (fileInput.hasNextLine()) { 
            
            Student temp = new Student(fileInput);  // read into a temp student reference            
            roster[k] = temp;                       // assign the student to next cell in array
                                                    //  myList.add(temp) would add to a list
            System.out.println(roster[k]);
            k++;
        } 
        size = k;  
    } catch (FileNotFoundException e) { 
        e.printStackTrace(); 
    } 

                                 // store the last value of k in size 


    System.out.println("We read " + size + " + students from the file");
    for (int k=0; k<size; k++)
        System.out.println(roster[k]);
  } 
}
