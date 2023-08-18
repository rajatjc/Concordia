package Assignment.Assignnment1.Submission;
// ____________________________
// Assignment 1
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

/*
 * This java program defines a class Vaccine with different attributes corresponding to the information regarding the Vaccine.
 * The Vaccine class also has multiple accessors and mutators in order to provide flexibility during object creation and modification.
 * There are also methods to convert object to string and to compare different Vaccine objects
 * */

import java.time.LocalDate;
/**
 * an enumerator object containing constant values for different brands of Vaccines
 * @author mukeshangrish
 */
enum Brand {
	MODERNA("Moderna"),
	PFIZER("Pfizer"),
	ASTRAZENECA("AstraZeneca"),
	JANSSEN("Janssen"),
	NOVAVAX("Novavax");

	private final String brand;
	
	/**
	 * enum constructor that takes string and stores it into the enum attribute
	 * @param brand the brand of the Vaccine
	 */
	private Brand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * returns the String version of the brand of a Vaccine
	 * @return the String version of the brand of a Vaccine
	 */
	public String getBrand() {
		return brand;
	}
};

/**
 * This java program defines a class Vaccine with different attributes corresponding to the information regarding the Vaccine.
 * @author mukeshangrish
 * The Vaccine class also has multiple accessors and mutators in order to provide flexibility during object creation and modification.
 * There are also methods to convert object to string and to compare different Vaccine objects
 */
public class Vaccine {
	private Brand brand;
	private double dose;
	private String expiry_date;
	private final long id;
	private double price;
	private static int numberOfCreatedVaccines = 0;
	
	/**
	 * default constructor that calls corresponding mutators of the object for different attributes with default values
	 * also increments the numberOfCreatedVaccines static attribute by 1
	 */
	public Vaccine() {
		// initialize default values
		this.id = numberOfCreatedVaccines++;
		getBrand();
		setDose(1.0);
		
		LocalDate today = LocalDate.now();
		setExpiryDate(today.plusMonths(3).toString());
		
		setPrice(100.0);
	}
	
	/**
	 * parameterized constructor that takes multiple attributes and called the corresponding mutators of the object
	 * also increments the numberOfCreatedVaccines static attribute by 1
	 * @param brand the brand name of the vaccine
	 * @param dose the amount of dose of the vaccine
	 * @param expiry_date the expiry date of the vaccine
	 * @param price the price of the vaccine in CAD
	 */
	public Vaccine(Brand brand, double dose, String expiry_date, double price) {
		// set the given values
		this.id = numberOfCreatedVaccines++;
		setBrand(brand);
		setDose(dose);
		setExpiryDate(expiry_date);
		setPrice(price);
	}
	
	/**
	 * returns a String that is the brand of the current Vaccine object
	 * @return a String that is the brand of the current Vaccine object
	 */
	public String getBrand() {
		return brand.getBrand();
	}
	
	/**
	 * sets the brand attribute of the current Vaccine object to the value passed to the method
	 * @param brand the brand of the vaccine (one of the constant values of the enum object Brand)
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	/**
	 * gets the amount of dose of the Vaccine
	 * @return the amount of dose of the Vaccine
	 */
	public double getDose() {
		return dose;
	}
	
	/**
	 * sets the dose attribute of the current Vaccine object to the value passed to the method
	 * @param dose the amount of dose of the Vaccine
	 */
	public void setDose(double dose) {
		this.dose = dose;
	}
	
	/**
	 * returns the expiry_date corresponding to the current Vaccine object
	 * @return the expiry_date corresponding to the current Vaccine object
	 */
	public String getExpiryDate() {
		return expiry_date;
	}
	
	/**
	 * sets the expiry_date attribute of the current Vaccine object to the value passed to the method
	 * @param expiry_date the expiry date of the Vaccin
	 */
	public void setExpiryDate(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	/**
	 * returns the id corresponding to the current Vaccine object
	 * id is always unique
	 * @return the id corresponding to the current Vaccine object
	 */
	public long getID() {
		return id;
	}
	
	/**
	 * returns the price of the current Vaccine object in CAD
	 * @return the price of the current Vaccine object in CAD
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * sets the price attribute of the current Vaccine object to the value (in CAD) passed to the method
	 * @param price the double value (CAD) passed to the method
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * converts a Vaccine object to a String so that it is easier to describe it in text.
	 * @return a string containing vaccine information on "brand", "id", "dose", "expiry_date", and "price"
	 */
	public String toString() {
		return "\nVaccine Details:\nBrand: " + this.brand.getBrand() + "\nID: " + getID() + "\nDose: " + getDose() +
				"\nExpiry Date: " + getExpiryDate() + "\nPrice: " + getPrice() + "\n\n";
	}
	
	/**
	 * compares one Vaccine object to another and returns true if they are equal. Otherwise, returns false.
	 * @param V1 The other Vaccine object we want to compare this object with
	 * @return true if both Vaccine objects have the same "brand" and "dose" attributes
	 */
	public boolean equals(Vaccine V1) {
		if ( (this.brand.getBrand() == V1.brand.getBrand()) && (getDose() == V1.getDose()) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * finds the number of vaccines created so far
	 * @return the number of vaccines created
	 */
	public static int findNumberOfCreatedVaccines() {
		return numberOfCreatedVaccines;
	}
	
}
