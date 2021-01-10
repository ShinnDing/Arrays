/**
 * @author Stephanie Shinn
 *
 * This class represents a Guitar's
 * specified brand, weight, and year.
 */

public class Guitar {

	private String brand;
	private int weight;
	private int year;

	//Getters and Setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @return formatted string of brand, weight, and year,
	 * separated by tabs to format columns.
	 */
	public String toString() {

		return ("\t" + brand + "\t\t  " + weight + "\t\t" + year);
	}

	/**
	 * @param Guitar other indicates the new guitar being compared to.
	 * @return	-1 if other Guitar object brand alphabetically (lexicographically)
	 * 				precedes the existing Guitar object in the array
	 * 			0 if other Guitar object brand is the alphabetical (lexicographical)
	 * 				equivalent to the existing Guitar object in the array
	 * 			1 if other Guitar object brand alphabetically (lexicographically)
	 * 				follows the existing Guitar object in the array
	 */
	public int compareTo(Guitar other) {

		return this.brand.compareToIgnoreCase(other.brand);
	}

}
