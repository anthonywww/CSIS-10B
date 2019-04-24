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
package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PacketReader {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// SortedAList<Packet> message = new SortedAList<Packet>( ); // message is a
		// sorted list of packets
		Packet currPacket; // Packet
		String filename; // Name of packet file
		Scanner keyboard; // a scanner connected to keyboard
		Scanner inputFile = null; // a scanner connected to the file containing packets
		File packetFile = null; // The packet input file
		boolean succeeded = false; // Succeeded in opening file

		// -----------------------------------------------------------------
		// Initialize Scanner - To read filename from keyboard
		keyboard = new Scanner(System.in);

		// Open the specified slide file.
		while (!succeeded) {
			System.out.print("\nEnter the name of the slide show file : ");
			filename = keyboard.nextLine();
			try {
				packetFile = new File(filename); // create a File associated with filename
				inputFile = new Scanner(packetFile); // connect a Scanner to the File
				succeeded = true; // Assume file is found
			} catch (FileNotFoundException e) {
				System.out.print("File Not Found: " + filename);
				succeeded = false; // File was not found
			}
		}

		// Test File Read (delete after verifying)
		String test = inputFile.nextLine();
		System.out.println("Test read from file: " + test);
		// Read in the packets one-by-one & insert in list.

		// Close the file.

		// Display the packet show packet-by-packet.
		
		
		
		keyboard.close();
	}

}

class Packet {
	// Data members
	private String text; // Packet data
	private int sequenceNumber; // Sequence number of packet

	// Read a packet from inFile. Returns false at EOF.
	public boolean read(Scanner inputFile) {
		return true;
	}

	// Display a packet
	public void display() {

	}

	// any other methods you may need

}