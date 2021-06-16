/**
 * @author Stephanie Shinn
 * 
 * Invariant of this GuitarArrayBag implementation:
 * 
 * 1- The number of items contained in the bag is stored 
 *	  in an instance variable called manyItems
 * 2- The bag entries are stored in an instance 
 *    array variable called items, 
 *    from position data[0] to position data[manyItems-1]
 * 
 * This class instantiates the Guitar array items[] of size manyItems.
 * Guitar objects are then inserted into items[] in alphabetical order.
 * This class also:
 * 		determines the size of the Guitar collection
 * 		formats collection of Guitars into columns for brand, weight, and year
 * 		finds first and last occurrences of specified Guitars in the collection
 * 		counts the number of times a specified Guitar appears in the collection
 * 		determines whether a specific Guitar appears in the collection
 * 		calculates the total number of Guitars in the collection
 * 		counts the number of guitars within a weight range of two specified weights
 * 		deletes a specified Guitar from the collection
 */
public class GuitarArrayBag {
	private Guitar items[];
	private int manyItems;
	
	/**
	 * Constructor for GuitarArrayBag with a given capacity of maxItems.
	 * @param manyItems is the number of Guitars in items[].
	 * 			manyItems is initialized at 0 and increases by one
	 * 			for each Guitar object added to collection, or
	 * 			decreases by one for each Guitar object removed from collection.
	 */
	public GuitarArrayBag(int maxItems) {
		items = new Guitar[maxItems];
		manyItems = 0;
	}

	/**
	 * Instantiates a new Guitar of specified brand,
	 * weight, and year.
	 * Places each guitar into items in alphabetical order,
	 * based on brand.
	 * 
	 * @param brand is the brand of Guitar object in collection,
	 * 				specified in Driver class.
	 * @param weight is the Guitar object's weight in pounds,
	 * 				specified in Driver class.
	 * @param year is the Guitar object's year of creation,
	 * 				specified in Driver class.
	 */
	public void insert(String brand, int weight, int year) {
		Guitar guitar = new Guitar();
		guitar.setBrand(brand);
		guitar.setWeight(weight);
		guitar.setYear(year);
		int current = manyItems;

		if (manyItems == 0) {
			items[0] = guitar;
			manyItems++;
		} else {
			for (int i = manyItems - 1; i >= 0; i--) {
				if (guitar.compareTo(items[i]) < 0) {
					items[i + 1] = items[i];
					current = i;
				}
			}
			manyItems++;
			items[current] = guitar;
		}
	}

	/**
	 * Calculates number of Guitar objects collection in items.
	 * 
	 * @param size is the number of Guitar objects in collection.
	 * 				size is initialized with 0 and increases by 1
	 * 				for each Guitar object found in collection.
	 * 
	 * @return the number of Guitar objects in collection.
	 */
	public int size() {
		int size = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				size++;
			}
		}
		return size;
	}

	/**
	 * Formats rows of Guitar objects into
	 * columns of BRAND, WEIGHT, and YEAR.
	 * 
	 * @param s is a String that formats a row of Guitar object into
	 * 				columns of BRAND, WEIGHT, and YEAR by using tab spacing.
	 * 
	 * @return returns a row comprised of columns for BRAND, WEIGHT, and YEAR
	 * 				of each Guitar object in collection.
	 */
	public String toString() {
		String s;
		s = ("\tBrand\t\tWeight\t\tYear\n\t------------------------------------");

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				s = (s + "\n" + items[i].toString());
			}
		}
		return s;
	}

	/**
	 * Receives a string input of brand, and
	 * determines the first Guitar object in the
	 * Guitar collection that has the the same brand, or
	 * returns null if brand is not in Guitar collection.
	 * 
	 * @param str is a String input of specified brand from Driver class.
	 * @return the first Guitar object that matches specified brand
	 * 				from Driver class if found, or
	 * 				returns null if not found
	 */
	public Guitar findFirst(String str) {
		for (int i = 0; i < manyItems; i++) {
			if ((items[i].getBrand().equalsIgnoreCase(str))) {
				return items[i];
			}
		}
		return null;
	}

	/**
	 * Receives a string input of brand, and
	 * determines the last Guitar object in the
	 * Guitar collection that has the the same brand, or
	 * returns null if brand is not in Guitar collection.
	 * 
	 * @param str is a String input of specified brand from Driver class.
	 * @return the last Guitar object that matches specified brand
	 * 				from Driver class if found, or
	 * 				returns null if not found
	 */
	public Guitar findLast(String str) {
		for (int i = manyItems - 1; i >= 0; i--) {
			if ((items[i].getBrand().equalsIgnoreCase(str))) {
				return items[i];
			}
		}
		return null;
	}

	/**
	 * Counts the number of times a specified brand
	 * appears in Guitar collection.
	 * 
	 * @param str is a String input of specified brand from Driver class.
	 * @return number of times Guitar objects in collection match the 
	 * 			specified brand from Driver class.
	 */
	public int countOccurrences(String str) {
		int count = 0;

		for (int i = 0; i < manyItems; i++) {
			if (items[i].getBrand().equalsIgnoreCase(str)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @param g is the Guitar object specified in Driver class that
	 * 				is compared to Guitar objects in existing collection
	 * @return true if collection contains Guitar object specified in Driver
	 * 				class, or
	 * 				false if specified Guitar object is not found in collection
	 */
	public boolean contains(Guitar g) {
		for (int i = 0; i < manyItems; i++) {
			if (items[i].compareTo(g) == 0) {
				return true;
			}
			}
		return false;
		}

	/**
	 * Calculates the total weight of all Guitar
	 * objects in the collection.
	 * 
	 * @param weight is initialized to zero and then
	 * 			becomes the weight of Guitar object index
	 * 			for each index iterated
	 * @param numItems is the number of items in Guitar collection,
	 * 			is initialized to zero and then incremented by
	 * 			1 for each occupied index
	 * @param w is initialized to zero and then Guitar object
	 * 			weight is added to it for each index iteration
	 * @return the total weight of the Guitar collection
	 */	
	public int total() {
		int weight = 0;
		int numItems = 0;
		int w = 0;

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				weight = items[numItems].getWeight();
				w = w + weight;
				numItems++;
			}
		}
		return w;
	}

	/**
	 * Counts the number of Guitar objects that have a
	 * weight within specified weight range.
	 * 
	 * @param w1 is the first specified weight in the weight range
	 * @param w2 is the second specified weight in the weight range
	 * @param countRange counts the number of Guitar objects in collection
	 * 			that have a weight within the specified weight range
	 * @return the total number of Guitar objects in collection that
	 * 			have a weight within the specified weight range
	 */
	public int countRange(int w1, int w2) {
		int countRange = 0;

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (((w1 <= items[i].getWeight()) && (w2 >= items[i].getWeight()))) {
					countRange++;
				}
			}
		}
		return countRange;
	}

	/**
	 * Determines whether specified Guitar is in items.
	 * If the Guitar is in items, it is then deleted from
	 * the collection.
	 * 
	 * @param g is the Guitar object to be deleted
	 * @param manyItems is the number of items in the Guitar collection.
	 * 			Each time a Guitar object is deleted, manyItems decrements by 1.
	 * @return true if Guitar object specified in Driver
	 * 			is deleted from Guitar collection, or 
	 * 			false if the Guitar object specified in Driver
	 * 			is not found
	 */
	public boolean delete(Guitar g) {		
		for (int i = 0; i < manyItems; i++) {
			if (items[i].compareTo(g) == 0) {
				items[i] = items[i+1];
				items[i+1] = items[i+2];
				return true;
			}
		}
		manyItems--;
		return false;
	}
}
