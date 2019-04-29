import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class WordFrequency {
	
	public static void main(String[] args) {
		
		SortedArrayDictionary<String, Integer> wordTable = new SortedArrayDictionary<String, Integer>();
		String fileName = "src/MobyDickChapter1.txt"; // or file name could be read
		
		try {
			Scanner inputFile = new Scanner(new File(fileName));
			inputFile.useDelimiter("\\W+"); // skip reading blanks and punctuation marks from file (only read words)
			
			while (inputFile.hasNext()) {
				/* comment out before solving */
				//System.out.println(inputFile.next().toLowerCase());

				// assign to String nextWord the next word in the file
				String nextWord = inputFile.next();
				
				// convert nextWord to lowercase
				nextWord = nextWord.toLowerCase();
				
				if (!wordTable.contains(nextWord)) {
					wordTable.add(nextWord, 0);
				}
				
				// assign to Integer frequency the frequency count of nextWord retrieved from
				int value = wordTable.getValue(nextWord);
				wordTable.add(nextWord, value+1);
				
				// dictionary wordTable
				
				
				// if frequency is null (nextWord wasn't in dictionary)
				
				
				// add nextWord as a new entry to wordTable otherwise,
				// update nextWord in the wordTable with a new frequency one greater than the
				// current value
				
			}
			
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}

		// print the word frequency counts
		Iterator<String> keys = wordTable.getKeyIterator();
		Entry[] entries = new Entry[wordTable.getSize()];
		
		for (int i=0; i<entries.length; i++) {
			String name = keys.next();
			int value = wordTable.getValue(name);
			entries[i] = new Entry(name, value);
		}
		
		Arrays.sort(entries);
		
		for (Entry e : entries) {
			System.out.printf("%s: %d\n", e.getName(), e.getValue());
		}
		
	}
	
	private static class Entry implements Comparable<Entry> {
		private String name;
		private int value;
		
		Entry(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}
		
		@Override
		public int compareTo(Entry other) {
			if (value > other.value) {
				return -1;
			} else if (value < other.value) {
				return 1;
			}
			return 0;
		}
	}
	
}
