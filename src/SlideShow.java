//--------------------------------------------------------------------
//
//  Laboratory 7, In-lab Exercise 3                   SlideShow.jshl
//
//  (Shell) Slide show program
//
//  The student is to complete all missing or incomplete method 
//     implementations for each class
//
//--------------------------------------------------------------------

// Displays a slide show.
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class SlideShow   // see below for class Slide
{
    static final int NUM_LINES = 50;    // Number of lines on the screen

    public static void main ( String[ ] args )   throws InterruptedException, FileNotFoundException
                                                       
    {
        LList slideShow = new LList( );     // Slide show
        Slide currSlide;                    // Slide
        String filename;                    // Name of slide show file
        Scanner keyboard;                   // a scanner connected to keyboard
        Scanner inputFile = null;           // a scanner connected to the file containing slides
        File slideFile = null;   // The slide input file
        boolean succeeded = false;          // Succeeded in opening file

        //-----------------------------------------------------------------
        // Initialize Scanner - To read filename from keyboard
        keyboard = new Scanner(System.in);

        // Open the specified slide file.
        while ( !succeeded )
        {
            System.out.print("\nEnter the name of the slide show file : ");
            filename = keyboard.nextLine( );
            try
            {
                slideFile = new File(filename);     // create a File associated with filename
                inputFile = new Scanner(slideFile); // connect a Scanner to the File               
                succeeded = true;           // Assume file is found
            }
            catch (FileNotFoundException e)
            {
                System.out.print("File Not Found: " + filename);
                succeeded = false;          // File was not found
            }
        }

        // Test File Read (delete after verifying)
        String test = inputFile.nextLine();
        System.out.println("Test read from file: " + test);
        // Read in the slides one-by-one & insert in list.







        // Close the file.

        
        // Display the slide show slide-by-slide.

    
    
    
    
    
    
    
    
    
    
    } // main
    
} // class SlideShow


class Slide
{
    // constants
    static final int SLIDE_HEIGHT = 10;   // Slide dimensions
    static final int SLIDE_WIDTH  = 36;

    // Data members
    private String [] image =            // Slide image
            new String [SLIDE_HEIGHT];
    private long pause;                  // Seconds to pause after
                                         //  displaying slide
    
    public boolean read ( Scanner inputFile ) 
        // Read a slide from inFile. Returns false at EOF.
    {
        return true;
    }

    public void display ( )  throws InterruptedException                 
        // Display a slide and sleep.
    {

    }
} // class Slide