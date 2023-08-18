
// ____________________________
// Assignment 2
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________


/*
 * This class allows filtering unique records from within each file in a directory tree and writes the filtered records to outputFile
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.*;

/**
 * This class allows filtering unique records from within each file in a directory tree and writes the filtered records to outputFile
 * @author Mukesh Kumar Angrish
 *
 */
public class SalesDatabase {
	// SalesDatabase class has the following attributes:
	private static Sales[] salesArr;
	private static int salesArrSize;
	private static int salesArrCapacity;

	/**
	 * recursively explores the directory and sub-directories and lists all directories and files in the logFile file
	 * @param dir the directory to be explored
	 * @param logFile the file to be written to
	 * @throws IOException if an I/O error occurs, usually due to an invalid file
	 */
	public static void listAllFiles(File dir, File logFile) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("directory:" + file.getCanonicalPath());
				bw.newLine();
				bw.close();
				fw.close();
				listAllFiles(file, logFile);
			} else {
				FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("     file:" + file.getCanonicalPath());
				bw.newLine();
				bw.close();
				fw.close();
			}
		}
	}

	/**
	 * adds a new sales record to the salesArr of the SalesDatabase class if the record does not already exist
	 * @param s the sales record to be added
	 * @throws DuplicateRecordException if the record already exists
	 */
	public static void addRecords(Sales s) throws DuplicateRecordException {
		// if salesArr is not initialized, initialize it and add the first record
		if (salesArr == null) {
			salesArr = new Sales[1];
			salesArr[0] = s;
			salesArrSize = 1;
			salesArrCapacity = 1;
		} else {
			// if s is already in the salesArr[], do not add it again
			// get the order_ID of s
			long order_ID = s.getOrder_ID();
			int index = sequentialSaleSearch(order_ID);
//			int index = binarySaleSearch(order_ID);
			// if the order_ID is not found, add s to the salesArr[]
//			if (order_ID == 700874793L) {
//				System.out.println("700874793");
//				System.out.println(index);
//				return;
//			}
			if (index == -1) {
				// if the salesArr[] is full, increase the size of the salesArr[]
				if (salesArrSize == salesArrCapacity) {
					Sales[] temp = new Sales[salesArrCapacity + 1];
					for (int i = 0; i < salesArrSize; i++) {
						temp[i] = salesArr[i];
					}
					salesArr = temp;
					salesArrCapacity++;
				}
				salesArr[salesArrSize] = s;
				salesArrSize++;
			} else {
				System.out.println("The order_ID " + order_ID + " is already in the database.");
				throw new DuplicateRecordException(order_ID);
			}
		}
		
	}


	/**
	 * displays the files content line by line
	 * @param file the file to be read
	 * @throws IOException if an I/O error occurs, usually due to an invalid file
	 */
	public static void displayFileContents(FileInputStream file) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	/**
	 * finds the index of a sales record in the salesArr[] using binary search
	 * @param order_ID the order_ID of the sales record to be searched for
	 * @return the index of the order_ID in the salesArr[]
	 */
	public static int binarySaleSearch(long order_ID) {
		Arrays.sort(salesArr);
		int low = 0;
		int high = salesArrSize - 1;
		int mid = 0;
		int iterations = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (salesArr[mid].getOrder_ID() == order_ID) {
				System.out.println("Order ID " + order_ID + " found in " + iterations + " iterations");
				return mid;
			} else if (salesArr[mid].getOrder_ID() < order_ID) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			iterations++;
		}
		// System.out.println("Order ID " + order_ID + " not found in " + iterations + " iterations");
		return -1;
	}

	/**
	 * finds the index of a sales record in the salesArr[] using sequential search
	 * @param order_ID the order_ID of the sales record to be searched for
	 * @return the index of the order_ID in the salesArr[]
	 */
	public static int sequentialSaleSearch(long order_ID) {
		Arrays.sort(salesArr);
		int iterations = 0;
		for (int i = 0; i < salesArrSize; i++) {
			if (salesArr[i].getOrder_ID() == order_ID) {
				System.out.println("Order ID " + order_ID + " found in " + iterations + " iterations");
				return i;
			}
			iterations++;
		}
		// System.out.println("Order ID " + order_ID + " not found in " + iterations + " iterations");
		return -1;
	}

	/**
	 * reads a valid file, creates a Sales object for each line, and adds the Sales object to the salesArr[] using addRecords() method
	 * also writes the contents to outputFile
	 * @param file the file to be read
	 * @param exceptionLogFile the file to write the exceptions to
	 * @param outputFile the file to write the contents to
	 * @throws IOException if an I/O error occurs, usually due to an invalid file
	 */
	public static void processFile(File file, File exceptionLogFile, File outputFile) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(file)));
		String line;
		while ((line = br.readLine()) != null) {
			// the line has 12 fields separated by one or more spaces, tab, or other whitespaces
			String[] fields = line.split("\\s+");
			// if the line has 12 fields, create a new Sale object and add it to the salesArr[]
			if (fields.length == 12) {
				try {
					String country = fields[0];
					String item_type = fields[1];
					char order_priority = fields[2].charAt(0);
					// create a format for the order_date so it follows dd/mm/yyyy format
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					
					Date order_date = formatter.parse(fields[3]);
					long order_ID = Long.parseLong(fields[4]);
					Date ship_date = formatter.parse(fields[5]);
					int units_sold = Integer.parseInt(fields[6]);
					float unit_price = Float.parseFloat(fields[7]);
					float unit_cost = Float.parseFloat(fields[8]);
					double revenue = Double.parseDouble(fields[9]);
					double total_cost = Double.parseDouble(fields[10]);
					double total_profit = Double.parseDouble(fields[11]);
					Sales s = new Sales(country, item_type, order_priority, order_date, order_ID, ship_date, units_sold,
							unit_price, unit_cost, revenue, total_cost, total_profit);
					addRecords(s);
					
					// use buffered all the fields to the output file
					FileWriter fw = new FileWriter(outputFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(s.toString());
					bw.newLine();
					bw.close();
					fw.close();
				} catch (DuplicateRecordException e) {
					// write the exception message to the exceptionLogFile
					try {
						FileWriter fw = new FileWriter(exceptionLogFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(e.getMessage());
						bw.newLine();
						bw.close();
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (ParseException e) {
					e.printStackTrace();
					try {
						FileWriter fw = new FileWriter(exceptionLogFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(e.getMessage());
						bw.newLine();
						bw.close();
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				// log an exception
				try {
					FileWriter fw = new FileWriter(exceptionLogFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Line " + line + " has " + fields.length + " fields instead of 12");
					bw.newLine();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// print the message
				System.out.println("Line " + line + " has " + fields.length + " fields instead of 12");
			}
		}
		br.close();
	}

	/**
	 * allows the user to log all files from a Data folder to a log file and then filters the unique records from each file and writes them to an output file
	 * @param args the command line arguments (not used)
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Sales Database");

		// create log.txt inside Log folder
		File logFile = new File("src/log.txt");
		if (logFile.exists()) {
			logFile.delete();
		}
		
		// create an exception-log.txt inside Log folder
		File exceptionLogFile = new File("src/exception-log.txt");
		if (exceptionLogFile.exists()) {
			exceptionLogFile.delete();
		}

		// create an output.txt inside src folder if it does not exist
		File outputFile = new File("src/output.txt");
		if (outputFile.exists()) {
			outputFile.delete();
		}
		
		try {
			outputFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create a menu to display the following options:
		// 1. List files
		// 2. Process files
		// 3. Exit
		while(true) {
			System.out.println("\n*****MENU*****");
			System.out.println("1. List files");
			System.out.println("2. Process files");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			
			// use BufferedReader to read the input from standard input
			BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
			try {
				// read the input from standard input
				String choice = br.readLine();
				if (choice.equals("1")) {
					listAllFiles(new File("src/Data"), logFile);
					System.out.println("All files in the Data folder have been logged to log.txt in the \"log\" folder");
				} else if (choice.equals("2")) {
					try {
						BufferedReader br2 = new BufferedReader(new FileReader(logFile));
						String line;
						while ((line = br2.readLine()) != null) {
							Pattern p = Pattern.compile("(\\w+):(.*)"); // matches (directory)|(file):<path>
							Matcher m = p.matcher(line.trim());
							if (m.matches()) {
								try {
									if (m.group(1).equals("directory")) {// if the first part is "directory", check if the directory exists
										File directory = new File(m.group(2));
										if (!directory.exists() || !Files.list(directory.toPath()).findAny().isPresent()) {
//											System.out.println("Directory " + m.group(2) + " does not exist");
											throw new EmptyFolderException(directory.getName());
										}
									} else if (m.group(1).equals("file")) { // if the first part is "file", check if the file exists
										File file = new File(m.group(2));
										if (!file.exists()) {
//											System.out.println("File " + m.group(2) + " does not exist");
											throw new InvalidFileException(file.getName());
										} else {
											 System.out.println("\nProcessing file " + m.group(2));
											// create fileInputStream to read the file
											FileInputStream fis = new FileInputStream(file);
											try {
												displayFileContents(fis);
												fis.close();
												processFile(file, exceptionLogFile, outputFile);
											} catch (FileNotFoundException e){
												// create regex which matches the file name and extension from a path
												p = Pattern.compile("(.*)\\.(.*)");
												m = p.matcher(logFile.getName());
												if (m.matches()) {
													// print the error message to the console
													System.out.println(e.getMessage());
//													System.out.println("Error: File " + m.group(1) + "." + m.group(2) + " does not exist");
													throw new InvalidFileException(m.group(1) + "." + m.group(2));
												}
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}
								} catch (InvalidFileException e) {
									System.out.println(e);
									try { // write the error message to the exceptionLogFile
										FileWriter fw = new FileWriter(exceptionLogFile, true);
										BufferedWriter bw = new BufferedWriter(fw);
										bw.write(e.getMessage());
										bw.newLine();
										bw.close();
										fw.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								} catch (EmptyFolderException e) {
									System.out.println(e);
									try { // write the error message to the exceptionLogFile
										FileWriter fw = new FileWriter(exceptionLogFile, true);
										BufferedWriter bw = new BufferedWriter(fw);
										bw.write(e.getMessage());
										bw.newLine();
										bw.close();
										fw.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							}
						}
						br2.close();
						// for all elements in salesArr, print the element
//						for (int i = 0; i < salesArr.length; i++) {
//							System.out.println(salesArr[i]);
//						}
					} catch (FileNotFoundException e){
						// create regex which matches the file name and extension from a path
						Pattern p = Pattern.compile("(.*)\\.(.*)");
						Matcher m = p.matcher(logFile.getName());
						if (m.matches()) {
							// print the error message to the console
							System.out.println("Error: File " + m.group(1) + "." + m.group(2) + " does not exist");
							throw new InvalidFileException(m.group(1) + "." + m.group(2));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (choice.equals("3")) {
					System.out.println("Thank you for using the program!");
					System.exit(0);
				} else {
					System.out.println("Invalid choice. Please try again");
				}
			} catch (InvalidFileException e) {
				System.out.println(e);
				try { // write the error message to the exceptionLogFile
					FileWriter fw = new FileWriter(exceptionLogFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(e.getMessage());
					bw.newLine();
					bw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
