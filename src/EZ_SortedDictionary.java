

public class EZ_SortedDictionary<K extends Comparable <? super K>, V extends Comparable <? super V>> extends EZ_Dictionary<K, V> {
	
	private SortType sortType;
	
	public EZ_SortedDictionary(SortType sortType) {
		super();
		this.sortType = sortType;
	}
	
	@Override
	public V add(K key, V value) {
		
		if (keys.contains(key) && sortType == SortType.ASCENDING_KEYS) {
			int location = keys.indexOf(key);
			V temp = values.get(location);
			values.set(location, value);
			return temp;
		}
		
		
		else if (keys.contains(key) && sortType == SortType.DESCENDING_VALUES) {
			int location = keys.indexOf(key);
			V temp = values.get(location);
			remove(key);
			add(key, value);
			return temp;
		}
		
		// Adding a new k/v pair at the correct location
		else {
			int location = findLocation(key, value);
			keys.add(location, key);
			values.add(location, value);
			return null;			
		}
		
	}
	
	
	public int findLocation(K key, V value) {
		if (sortType == SortType.ASCENDING_KEYS) {
			int k = 0;
			while (k<keys.size() && keys.get(k).compareTo(key) < 0) {
				k++;
			}
			return k;
		} else if (sortType == SortType.DESCENDING_VALUES) {
			int k = 0;
			while (k<keys.size() && values.get(k).compareTo(value) > 0) {
				k++;
			}
			return k;
		}
		return -1;
	}
	
}
