// ____________________________
// Assignment 1
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

/*
 *  Driver of the Vaccine class implemented in Vaccine.java file
	 * Multiple functions:
	 * 1. entering a stock of vaccines
	 * 2. modifying its information of vaccines by number
	 * 3. displaying vaccines by brand
	 * 4. displaying vaccines less than a certain price
 */

import java.util.Scanner;

/**
 * Vaccine driver implements an inventory system that allows user to manage a stock of vaccines
 * @author mukeshangrish
 * allows entering a stock of vaccines, modifying its information of vaccines by number, displaying vaccines by brand and vaccines less than a certain price
 */
public class VaccineDriver {
	private static Scanner userInput = new Scanner(System.in);
//	public static void closeInput1() {
//		userInput.close();
//	}

	/**
	 * returns a String that contains the text to be displayed when user is at the main menu of the Vaccine Inventory Software
	 * @return a String that contains the text to be displayed when user is at the main menu of the Vaccine Inventory Software
	 */
	public static String mainMenu() {
		return "\nWhat do you want to do?\n"+
			   "1. Enter new vaccines (password required)\n"+
			   "2. Change information of a vaccine (password required)\n"+
			   "3. Display all vaccines by a specific brand\n"+
			   "4. Display all vaccines under a certain a price.\n"+
			   "5. Quit\n"+
			   "\nPlease enter your choice > ";
	}
	
	/**
	 * return a String of the details of a vaccine
	 * @param V the vaccine object whose information is returned as a string
	 * @param number the vaccine number in which the vaccine is ordered in inventory
	 * @return a String of the details of a vaccine
	 */
	public static String displayVaccineInfo(Vaccine V, int number) {
		return "\nVaccine: # " + number + "\n"+
			   "ID: " + V.getID() + "\n"+
			   "Brand: " + V.getBrand() + "\n"+
			   "Dose: " + V.getDose() + "\n"+
			   "Expiry: " + V.getExpiryDate() + "\n"+
			   "Price: $ " + V.getPrice()+ "\n";
	}
	
	/**
	 * Driver of the Vaccine class implemented in Vaccine.java file
	 * @param args String array of commandline inputs - (not used)
	 * Multiple functions:
	 * 1. entering a stock of vaccines
	 * 2. modifying its information of vaccines by number
	 * 3. displaying vaccines by brand
	 * 4. displaying vaccines less than a certain price
	 */
	public static void main(String[] args) {
		System.out.print("Welcome to the Vaccine Inventory Software.\n\n");
		System.out.print("Please enter the maximum number of vaccines your store can contain : ");
		
		int maxVaccines;
		
		if(userInput.hasNextInt()) {
			while(true) {
				maxVaccines = userInput.nextInt();
				if(maxVaccines > 0) {
					break;
				} else {
					System.out.print("Please enter a positive integer: ");
				}
			}
			// int maxVaccines = userInput.nextInt();
			Vaccine[] inventory = new Vaccine[maxVaccines];
			
			// variable to keep track of failed attempts to enter the correct password
			int failedAttempts = 0;
		
			// repeatedly display a main menu of options to the user until the user selects the exit option
			while(true) {
				System.out.print(mainMenu());
				
				int choice = userInput.nextInt();
				
				if((1<=choice && choice<= 5)) {
					// constant variable called password with a value of "password"
					final String password = "password";
	
					switch(choice) {
						case 1:
							// prompt the user to enter the password.
							while(true) {
								System.out.print("Enter the password to enter the system: ");
								String enteredPassword = userInput.next();
								if(enteredPassword.equals(password)) { // if the user enters the correct password, ask user to enter how many vaccines to add
									System.out.print("Enter the number of vaccines you want to add: ");
									int numVaccines = userInput.nextInt();
									if(numVaccines > maxVaccines-Vaccine.findNumberOfCreatedVaccines()) { // if number of vaccines is more than the remaining space in the inventory, inform user about the remaining space
										System.out.print("You can only add " + (maxVaccines-Vaccine.findNumberOfCreatedVaccines()) + " vaccines.\n");
										break;
									} else { // else ask user to enter the vaccine information for each vaccine and add to inventory
										for(int index=0; index<numVaccines; index++) {
											// let the user know which vaccine is being added
											System.out.print("\nEnter the information for vaccine " + (index+1) + " - \n");
											
											Brand brand = Brand.ASTRAZENECA; // #TODO Edit this to work without default value
											boolean enteredValidBrand = false;
											do {
												// ask user to enter the brand name of the vaccine
												System.out.print("Enter the Vaccine brand: ");
												String enteredBrand = userInput.next();
												for(Brand brandName : Brand.values()) {
													if(brandName.getBrand().toLowerCase().substring(0, 3).equals(enteredBrand.toLowerCase().substring(0, 3))) {
														// if the brand name entered by the user is a valid brand name, break out of the loop
														brand = brandName;
														enteredValidBrand = true;
														break;
													}
												}
												
												// if the brand name entered by the user is not a valid brand name, inform user and ask to re-enter the brand name
												if(!enteredValidBrand) 
													System.out.print("Invalid brand name. Please re-enter the brand name: ");
											} while(!enteredValidBrand);

											// ask user to enter the vaccine dose, expiry_date and price and initialize the Vaccine object
											System.out.print("Enter the vaccine dose: ");
											double dose = userInput.nextDouble();
											System.out.print("Enter the vaccine expiry date in format(yyyy-mm-dd): ");
											String expiryDate = userInput.next();
											System.out.print("Enter the vaccine price: ");
											double price = userInput.nextDouble();
											
											// initialize the Vaccine object with the user input and add to inventory
											inventory[index] = new Vaccine(brand, dose, expiryDate, price);
										}
										break;
									}
								} else {
									failedAttempts++; // if the user entered the incorrect password, increment failedAttempts
									if(failedAttempts == 12) { // if failedAttempts is 12, exit the program
										System.out.print("Program detected suspicious activities and will terminate immediately!\n");
//										closeInput1();
										System.exit(0);
									} else if(failedAttempts % 3 == 0) { // if failedAttempts is multiple of 3, go back to main menu display
										System.out.print("You have entered the incorrect password too many times. Please try again later.\n");
										break;
									} else {
										System.out.print("You have entered the incorrect password. Please try again.\n\n");
										continue;
									}
								}
							}
							break;
						case 2:
							// prompt the user to enter the password.
							while(true) {
								System.out.print("Enter the password to enter the system: ");
								String enteredPassword = userInput.next();
								if(enteredPassword.equals(password)) { // if the user enters the correct password, ask user to enter the vaccine index to change
									System.out.print("Enter the vaccine number that you wish to change: ");
									int index = userInput.nextInt();
									// check if there is a Vaccine object at the index
									if(inventory[index-1] == null) { // if no vaccine is found at the index, ask user if they wish to re-add another vaccine
										System.out.print("There is no vaccine at index " + index + ".\n");
										System.out.print("Do you want to re-add a vaccine? Please enter Y\n"+
														 "Enter any other keyword to go back to the main menu\n"); // or if they wish to quit to main menu
										String reAddChoice = userInput.next();
										if(reAddChoice.toLowerCase().equals("y")) {
											System.out.print("Enter the information for the vaccine: \n");
											
											Brand brand = Brand.ASTRAZENECA; // #TODO Edit this to work without default value
											boolean enteredValidBrand = false;
											do {
												// ask user to enter the brand name of the vaccine
												System.out.print("Enter the Vaccine brand: ");
												String enteredBrand = userInput.next();
												for(Brand brandName : Brand.values()) {
													if(brandName.getBrand().toLowerCase().substring(0, 3).equals(enteredBrand.toLowerCase().substring(0, 3))) {
														// if the brand name entered by the user is a valid brand name, break out of the loop
														brand = brandName;
														enteredValidBrand = true;
														break;
													}
												}
												
												// if the brand name entered by the user is not a valid brand name, inform user and ask to re-enter the brand name
												if(!enteredValidBrand) 
													System.out.print("Invalid brand name. Please re-enter the brand name: ");
											} while(!enteredValidBrand);
											
											System.out.print("Enter the vaccine dose: ");
											double dose = userInput.nextDouble();
											System.out.print("Enter the vaccine expiry date in format(yyyy-mm-dd): ");
											String expiryDate = userInput.next();
											System.out.print("Enter the vaccine price: ");
											double price = userInput.nextDouble();
											inventory[index-1] = new Vaccine(brand, dose, expiryDate, price);
											break;
										} else {
											break;
										}
									} else { // if the vaccine is found, display the vaccine information
										System.out.print(displayVaccineInfo(inventory[index-1], index));
										Byte updateChoice=-1;
										while(updateChoice!=5) { // then ask the user which attribute they wish to change
											System.out.print("\nWhat information would you like to change?\n");
											System.out.print("1. Brand\n");
											System.out.print("2. Dose\n");
											System.out.print("3. Expiry\n");
											System.out.print("4. Price\n");
											System.out.print("5. Quit\n");
											System.out.print("\nPlease enter your choice > ");
											
											if(userInput.hasNextInt()) {
												updateChoice = userInput.nextByte();
												switch(updateChoice) {
													case 1:
														Brand brand = Brand.ASTRAZENECA; // #TODO Edit this to work without default value
														boolean enteredValidBrand = false;
														do {
															// ask user to enter the brand name of the vaccine
															System.out.print("Enter the Vaccine brand: ");
															String enteredBrand = userInput.next();
															for(Brand brandName : Brand.values()) {
																if(brandName.getBrand().toLowerCase().substring(0, 3).equals(enteredBrand.toLowerCase().substring(0, 3))) {
																	// if the brand name entered by the user is a valid brand name, break out of the loop
																	brand = brandName;
																	enteredValidBrand = true;
																	break;
																}
															}
															
															// if the brand name entered by the user is not a valid brand name, inform user and ask to re-enter the brand name
															if(!enteredValidBrand) 
																System.out.print("Invalid brand name. Please re-enter the brand name: ");
														} while(!enteredValidBrand);
														inventory[index-1].setBrand(brand);
														System.out.print(displayVaccineInfo(inventory[index-1], index));
														break;
													case 2:
														// ask user to enter the dose of the vaccine and update the dose at index-1 in the inventory array
														System.out.print("Enter the vaccine dose: ");
														double dose = userInput.nextDouble();
														inventory[index-1].setDose(dose);
														System.out.print(displayVaccineInfo(inventory[index-1], index));
														break;
													case 3:
														// ask user to enter the expiry date of the vaccine and update the expiry date at index-1 in the inventory array
														System.out.print("Enter the vaccine expiry date: ");
														String expiryDate = userInput.next();
														inventory[index-1].setExpiryDate(expiryDate);
														System.out.print(displayVaccineInfo(inventory[index-1], index));
														break;
													case 4:
														// ask user to enter the price of the vaccine and update the price at index-1 in the inventory array
														System.out.print("Enter the vaccine price: ");
														double price = userInput.nextDouble();
														inventory[index-1].setPrice(price);
														System.out.print(displayVaccineInfo(inventory[index-1], index));
														break;
													case 5:
														break;
													default:
														System.out.print("Please only enter a number next to the option name. Any other input is invalid.\n");
														break;
												}
											}
										}
									}
								} else {
									failedAttempts++; // if the user entered the incorrect password, increment failedAttempts
									if(failedAttempts % 3 == 0) { // if failedAttempts is multiple of 3, go back to main menu display
										System.out.print("You have entered the incorrect password too many times. Please try again later.\n");
										break;
									} else {
										System.out.print("You have entered the incorrect password. Please try again.\n\n");
										continue;
									}
								}
							}
							break;
						case 3:
							// ask the user for brand name of the vaccines to be searched
							// display the vaccines with the same brand name
							System.out.print("Enter the brand name of the vaccine to be searched: ");
							String enteredBrand = userInput.next();
							for(int index=0; index<inventory.length; index++) {
								if(inventory[index] != null && inventory[index].getBrand().toLowerCase().substring(0, 3).equals(enteredBrand.toLowerCase().substring(0, 3))) {
									System.out.print(displayVaccineInfo(inventory[index], index+1));
								}
							}
							break;
						case 4:
							// ask the user for the vaccine price to be searched
							// display all the vaccines with price less than the entered price
							System.out.print("Enter the price of the vaccine to be searched: ");
							double enteredPrice = userInput.nextDouble();
							for(int index=0; index<inventory.length; index++) {
								if(inventory[index] != null && inventory[index].getPrice() < enteredPrice) {
									System.out.print(displayVaccineInfo(inventory[index], index+1));
								}
							}
						case 5:
							System.out.print("Thank you for using the Vaccine Inventory Software.\n");
//							closeInput1();
							System.exit(0);
							break;
						default:
							System.out.print("Please only enter a number next to the option name. Any other input is invalid.\n");
							break;
					}
				} else {
					System.out.print("Please only enter a number next to the option name. Any other input is invalid.\n");
				}
			}
		}

//		closeInput();
	}

}
