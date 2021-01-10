
/**
 * @author Stephanie Shinn
 * 
 * The Driver class is the main class.
 * It instantiates GuitarArrayBag with a
 * specified size for the array of Guitars,
 * aka the collection of Guitars.
 * The Driver class inserts Guitar objects of
 * brand, weight, and year into the GuitarArrayBag.
 * 
 * The Driver calls the following methods from GuitarArrayBag:
 * 
 *		insert(brand, weight, year) - to insert Guitar objects into array
 *		setBrand(brand) - sets brand of a specific guitar for search purposes
 *		size() - calls the size of Guitar collection
 *		toString - prints Guitar collection in columns of BRAND, WEIGHT, and YEAR
 *		findFirst(brand) - calls first Guitar object of specified brand
 *		findLast(brand) - calls last Guitar object of specified brand
 *		countOccurrences(brand) - counts the number of times specified brand appears in Guitar collection
 *		contains(brand) - returns true if specified brand exists in Guitar collection
 *		total() - calculates the total weight of collection in pounds
 *		countRange (weight, weight) - counts the number of objects within specified weight range
 *		delete(brand) - deletes object(s) of specified brand if found in collection,
 *						returns true if deleted or false if object of specified brand is not found
 *		toString() - prints Guitar collection in columns of BRAND, WEIGHT, and YEAR after
 *						delete(brand) method is called
 */
public class Driver {
	
	public static void main(String[] args) {
		
		GuitarArrayBag g = new GuitarArrayBag(10);
		
		g.insert("Martin", 6, 2012);
		g.insert("Taylor", 5, 2019);
		g.insert("Gibson", 9, 2008);
		g.insert("Ovation", 6, 1993);
		g.insert("Cordoba", 5, 2020);
		
		Guitar taylor = new Guitar();
		taylor.setBrand("taylor");
		Guitar ovation = new Guitar();
		ovation.setBrand("ovation");

		System.out.println("\nNumber of Guitars: " + g.size() + "\n");
		System.out.println(g.toString() + "\n");
		System.out.println(g.findFirst("gibson"));
		System.out.println(g.findLast("cordoba"));
		System.out.println("\nOvation occurs " + g.countOccurrences("ovation") + " time(s).");
		System.out.println("Collection contains Taylor: " + g.contains(taylor));
		System.out.println("Total Weight of Guitars: " + g.total() + " pounds");
		System.out.println("Guitars within weight range 6 to 9 lbs: " + g.countRange(6, 9));
		System.out.println("Ovation deleted: " + g.delete(ovation));
		
		//confirms delete method in list form
		System.out.println("\n" + g.toString() + "\n");
		
	}

}
