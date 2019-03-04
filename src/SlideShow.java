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

public class SlideShow {
	
	private static final int NUM_LINES = 50; // Number of lines on the screen

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		LList<Slide> slideShow = new LList<Slide>(); // Slide show
		Slide currSlide; // Slide
		String filename; // Name of slide show file
		Scanner keyboard; // a scanner connected to keyboard
		Scanner inputFile = null; // a scanner connected to the file containing slides
		File slideFile = null; // The slide input file
		boolean succeeded = false; // Succeeded in opening file

		// -----------------------------------------------------------------
		// Initialize Scanner - To read filename from keyboard
		keyboard = new Scanner(System.in);

		// Open the specified slide file.
		while (!succeeded) {
			System.out.println("Enter the name of the slide show file: ");
			filename = keyboard.nextLine();
			try {
				slideFile = new File(filename); // create a File associated with filename
				inputFile = new Scanner(slideFile); // connect a Scanner to the File
				succeeded = true; // Assume file is found
			} catch (FileNotFoundException e) {
				System.err.println("File Not Found: " + filename);
				succeeded = false; // File was not found
			}
		}
		keyboard.close();

		// Test File Read (delete after verifying)
//		String test = inputFile.nextLine();
//		System.out.println("Test read from file: " + test);
		
		// Read in the slides one-by-one & insert in list.
		while (true) {
			Slide slide = new Slide();
			if (!slide.read(inputFile)) {
				break;
			}
			slideShow.add(slide);
		}
		
		
		// Close the file.
		inputFile.close();

		// Display the slide show slide-by-slide.
		for (int i=0; i<slideShow.getLength(); i++) {
			Slide slide = slideShow.remove(i);
			if (slide != null && slide instanceof Slide) {
				slide.display();
			}
		}
	}
}


class Slide {
	// constants
	private static final int SLIDE_HEIGHT = 10;
	private static final int SLIDE_WIDTH = 36;

	private String[] image = new String[SLIDE_HEIGHT]; // Slide image
	private long pause; // Seconds to pause after
						// displaying slide

	public boolean read(Scanner inputFile) {
		// Read a slide from inFile. Returns false at EOF.
		try {
			
			if (!inputFile.hasNextLine()) {
				return false;
			}
			
			String delayStr = inputFile.nextLine();
			pause = Integer.parseInt(delayStr);
			
			// read 10 lines of text and put into image array
			for (int i=0; i<SLIDE_HEIGHT; i++) {
				image[i] = inputFile.nextLine();
			}
			
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public void display() throws InterruptedException {
		// Display a slide and sleep
		// clear virtual terminal
		System.out.println("\f");
		
		for (int i=0; i<image.length; i++) {
			System.out.println(image[i]);
		}
		
		Thread.sleep(pause * 1000);
	}
	
}



/*
Enter the name of the slide show file: 
resources/slides.txt
. . . . . . . . . . . . . . . . . 1
.                                 .
.                                 .
.                                 .
.          THE BEGINNING          .
.                                 .
.                                 .
.                                 .
.                                 .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . 3
.                                 .
.     DA                   TA     .
.                                 .
.                                 .
.                                 .
.                                 .
.    STRUC               TURES    .
.                                 .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . 5
.                                 .
.                                 .
.                                 .
.              DATA               .
.           STRUCTURES            .
.                                 .
.                                 .
.                                 .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . 7
.                                 .
.                                 .
.                                 .
.               AT                .
.             RD TA  S            .
.           S  UC U E             .
.            T     R              .
.                                 .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . 9
.                                 .
.                                 .
.                                 .
.                                 .
.                                 .
.               A                 .
.              D  A               .
.             R AT   E            .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . .11
.             THE END             .
.                                 .
.                                 .
.                                 .
.                                 .
.                                 .
.                                 .
.             THE END             .
. . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . .13
.                                 .
.                                 .
.             THE END             .
.                                 .
.                                 .
.             THE END             .
.                                 .
.                                 .
. . . . . . . . . . . . . . . . . .
*/