package Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Manan Dineshbhai Paruthi - 40192620
 * @author Harman Preet Kaur - 40198317
 */
public class BibCreator {

	/**
	 * This method gets all articles data in list of objects format and and prints it in IEEE, ACM & NJ format
	 * @param sc - Scanner object of Input File
	 * @param fileNo - File number from all 10 Files
	 * @param pwIeee - Print Writer object of IEEE Output File
	 * @param pwACM - Print Writer object of ACM Output File
	 * @param pwNJ - Print Writer object of NJ Output File
	 */
	public static void processFilesForValidation(Scanner sc, int fileNo, PrintWriter pwIeee, PrintWriter pwACM, PrintWriter pwNJ) {
		try {
			List<JournalData> allJournalData = getAllJournalData(sc, fileNo, pwIeee, pwACM, pwNJ);

			for (JournalData data : allJournalData) {
				pwIeee.println(data.getIEEEFormat() + "\n");
				pwACM.println(data.getACMFormat() + "\n");
				pwNJ.println(data.getNJSampleFormat() + "\n");
			}
		} catch (FileInvalidException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method extracts the data from all articles and converts it in objects and returns the list of objects & finds invalid articles and deletes them if created
	 * @param sc - Scanner object of Input File
	 * @param fileNo - File number from all 10 Files
	 * @param pwIeee - Print Writer object of IEEE Output File
	 * @param pwACM - Print Writer object of ACM Output File
	 * @param pwNJ - Print Writer object of NJ Output File
	 * @return - Returns the list of all article objects 
	 * @throws FileInvalidException - If file is invalid
	 */
	public static List<JournalData> getAllJournalData(Scanner sc, int fileNo, PrintWriter pwIeee, PrintWriter pwACM, PrintWriter pwNJ) throws FileInvalidException {
		List<JournalData> allArticles = new ArrayList<JournalData>();
		int index = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.matches("@ARTICLE\\{[\\s]*")) { // start of article
				JournalData data = new JournalData();
				index++;
				data.setJournalNo(index);
				allArticles.add(data);
			} else if (line.matches("[0-9]+,[\\s]*") || line.matches("[0-9]+[\\s]*")) { // journal number
				// skip
			} else if (line.matches("\\}[\\s]*")) { // end of article
				// skip
			} else if (line.matches("[\\s]*")) { // empty line
				// skip
			} else {
				String[] temp = line.split("=");
				if (temp[1].matches("\\{[\\s]*\\},[\\s]*")) { // invalid file - empty field
					if (pwIeee != null) {
						pwIeee.close();
					}
					if (pwACM != null) {
						pwACM.close();
					}
					if (pwNJ != null) {
						pwNJ.close();
					}
					throw new FileInvalidException(fileNo, temp[0]);
				} else { // valid file
					String key = temp[0];
					String temp1 = temp[1].trim();
					String value = temp1.substring(1, temp1.length() - 2);
					JournalData currJournalData = allArticles.get(allArticles.size() - 1);
					switch (key) {
					case "author":
						String[] authorsArr = value.split(" and ");
						currJournalData.setAuthor(authorsArr);
						break;

					case "journal":
						currJournalData.setJournal(value);
						break;

					case "title":
						currJournalData.setTitle(value);
						break;

					case "year":
						currJournalData.setYear(value);
						break;

					case "volume":
						currJournalData.setVolume(value);
						break;

					case "number":
						currJournalData.setNumber(value);
						break;

					case "pages":
						currJournalData.setPages(value);
						break;

					case "doi":
						currJournalData.setDoi(value);
						break;

					case "month":
						currJournalData.setMonth(value);
						break;
					}
				}
			}

		}
		return allArticles;
	}

	/**
	 * This method deletes the file if it exists
	 * @param fileName - Takes the filename which needs to be deleted if it exists
	 */
	public static void deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to the Bibcreator!\n");

		Scanner sc = null;
		PrintWriter pwIeee = null, pwACM = null, pwNJ = null;
		for (int i = 1; i <= 10; i++) {
			try {
				sc = new Scanner(new FileInputStream("BibFiles/Latex" + i + ".bib"));
				pwIeee = new PrintWriter(new FileOutputStream("IEEE" + i + ".json"));
				pwACM = new PrintWriter(new FileOutputStream("ACM" + i + ".json"));
				pwNJ = new PrintWriter(new FileOutputStream("NJ" + i + ".json"));

				processFilesForValidation(sc, i, pwIeee, pwACM, pwNJ);

				sc.close();
				pwIeee.close();
				pwACM.close();
				pwNJ.close();
			} catch (FileNotFoundException e) {
				System.out.println("Could not open input file Latex" + i + ".bib for reading.\n"
						+ "\nPlease check if file exists! Program will terminate after closing any opened files.\n");

				if (sc != null) {
					sc.close();
				}
				if (pwIeee != null) {
					pwIeee.close();
				}
				if (pwACM != null) {
					pwACM.close();
				}
				if (pwNJ != null) {
					pwNJ.close();
				}

				for (int j = 0; j < 10; j++) { // delete all of the created files as per point 4
					deleteFile("IEEE" + i + ".json");
					deleteFile("ACM" + i + ".json");
					deleteFile("NJ" + i + ".json");
				}
				System.exit(-1);
			} finally {
				if (sc != null) {
					sc.close();
				}
				if (pwIeee != null) {
					pwIeee.close();
				}
				if (pwACM != null) {
					pwACM.close();
				}
				if (pwNJ != null) {
					pwNJ.close();
				}
			}
		}

		System.out.println("\nA total of " + FileInvalidException.getNoOfInvalidFiles()
				+ " files were invalid, and could not be processed. All other "
				+ (10 - FileInvalidException.getNoOfInvalidFiles()) + " \"Valid\" files have been created");
		
		Scanner scn = null;
		try {
			scn = new Scanner(System.in);
			int counter = 1;
			boolean exists = false;
			String line;
			while (counter <= 3 && !exists) {
				System.out.println("\nPlease enter the name of one of the files that you need to review: ");
				String userEnteredfileName = scn.next(); // give 3 chances - chk fig 5 & 6
				File file = new File(userEnteredfileName);
				if (file.exists()) {
					System.out.println("Here are the contents of the successfully created JSON File: " + userEnteredfileName);
					BufferedReader br = new BufferedReader(new FileReader(userEnteredfileName));
					line = br.readLine();
					while (line != null) {
						System.out.println(line);
						line = br.readLine();
					}
					exists = true;
					br.close();
				} else {
					counter++;
					if(counter > 3) {
						throw new FileNotFoundException();
					}
					else {
						System.out.println("Could not open input file. File does not exist; possibly it could not be created");
						System.out.println("However, you will be allowed another chance to enter another file name.");
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file again. File does not exist; possibly it could not be created");
			System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scn.close();
		}

	}

}

class FileInvalidException extends Exception {
	private static int noOfInvalidFiles = 0;

	FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}

	FileInvalidException(String msg) {
		super(msg);
	}

	FileInvalidException(int fileNo, String errorFieldVal) {
		super("\nError: Detected Empty Field!\n============================\n\n"
				+ "Problem detected with input file: Latex" + fileNo + ".bib\nFile is Invalid: Field \"" + errorFieldVal
				+ "\" is Empty. Processing stopped at this point. Other empty fields may be present as well!");

		noOfInvalidFiles++;
		deleteFile("IEEE" + fileNo + ".json");
		deleteFile("ACM" + fileNo + ".json");
		deleteFile("NJ" + fileNo + ".json");
	}

	public String getMessage() {
		return super.getMessage();
	}

	public static void deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	public static int getNoOfInvalidFiles() {
		return noOfInvalidFiles;
	}

}

class JournalData {
	private String[] author;
	private String title, journal, volume, number, pages, month, year, doi;
	private int journalNo;

	public JournalData() {
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public void setJournalNo(int journalNo) {
		this.journalNo = journalNo;
	}

	public String[] getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getJournal() {
		return journal;
	}

	public String getVolume() {
		return volume;
	}

	public String getNumber() {
		return number;
	}

	public String getPages() {
		return pages;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getDoi() {
		return doi;
	}

	public int getJournalNo() {
		return journalNo;
	}

	public String getIEEEFormat() {
		String authorsFormatted = "";
		authorsFormatted += author[0];
		for (int i = 0; i < author.length; i++) {
			authorsFormatted += (", " + author[i]);
		}
		authorsFormatted += ".";

		return authorsFormatted + " " + getTitle() + ", " + getJournal() + ", " + "vol. " + getVolume() + ", " + "no. "
				+ getNumber() + ", " + "p. " + getPages() + ", " + getMonth() + " " + getYear() + ".";

	}

	public String getNJSampleFormat() {
		String authorsFormatted = "";
		authorsFormatted += author[0];
		for (int i = 0; i < author.length; i++) {
			authorsFormatted += (" & " + author[i]);
		}
		authorsFormatted += ".";

		return authorsFormatted + " " + getTitle() + ". " + getJournal() + ". " + getVolume() + ", " + getPages() + "("
				+ getYear() + ").";
	}

	public String getACMFormat() {
		String authorsFormatted = author[0];
		return "[" + getJournalNo() + "] " + authorsFormatted + " et al. " + getYear() + ". " + getTitle() + ". "
				+ getJournal() + ". " + getVolume() + ", " + getNumber() + " (" + getYear() + "), " + getPages() + ". "
				+ "DOI:https://doi.org/" + getDoi() + ".";
	}

}
