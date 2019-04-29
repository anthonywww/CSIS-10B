package lab9;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArrayList<T extends Comparable<? super T>> extends ArrayList<T> {
	public SortedArrayList() {
		super();
	}
	
	@Override
	public boolean add(T entry) {
		if (isEmpty()) {
			super.add(entry);
			return true;
		}
		
		int index = Arrays.binarySearch(this.toArray(), entry);
		
		// array: 4 8 12 18 24
		// index: 0 1 2  3  4
		// pos:   1 2 3  4  5
		
		// item NOT in array
		// newEntry    (-(insertion point)-1)     posToAdd    
		// 10          -3                         3
		// 30          -6                         6
		// 2           -1                         1
		
		// items in array
		// newEntry     index       posToAdd
		// 8            1           3
		
		if (index >= 0) {
			// new entry is in list, add duplicate
			this.add(index, entry);
		} else {
			this.add(-index-1, entry);
		}
		
		return true;
	}
	
	@Override
	public boolean remove(Object o) {
		
		if (this.isEmpty()) {
			return false;
		}
		
		if (!this.contains(o)) {
			return false;
		}
		
		int index = Arrays.binarySearch(this.toArray(), o);
		
		if (index >= 0) {
			this.remove(index);
		} else {
			this.remove(-index);
		}
		
		return true;
	}
	
	public int getPosition(T entry) {
		for (int i=0; i<super.size(); i++) {
			if (super.get(i).equals(entry)) {
				return i;
			}
		}
		
		return -1;
	}
	
}
