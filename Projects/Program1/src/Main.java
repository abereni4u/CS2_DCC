import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Abereni Opuiyo
* CPS142 – Fall 2024
* 9/7/24
* Instructor: Adam Divelbiss
* Assignment: Program01
* Purpose:  a simple command line application to find the 
* strongest and fastest hurricane for a given  name.  
* */

public class Main {
	
	final static String FILE_NAME = "/Users/abereni4u/Dropbox/Github/CS2_DCC/Projects/Program1/src/htracks_na_cps142_dcc.csv";

	/**
	 * A public static method that is responsible for loading the data from a csv file. 
	 * @return an ArrayList consisting of a StormRecord observation 
	 * record for each row of data in the file.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<StormRecord> loadData() throws FileNotFoundException{
		
		// Create a placeholder StormRecord object and an arraylist of StormRecords then
		// open the csv file and create a StormRecord object from each string.
		
		StormRecord csvStormRecord;
		
		String csvString;
		
		ArrayList<StormRecord> csvRecords = new ArrayList<>();
		
		File csvFile = new File(FILE_NAME);

		Scanner readCSV = new Scanner(csvFile);

		// Skips the first two lines of the CSV 
		
		readCSV.nextLine();
		readCSV.nextLine();		
		while(readCSV.hasNextLine()) {
			csvString = readCSV.nextLine();
			csvStormRecord = new StormRecord(csvString);
			csvRecords.add(csvStormRecord);
			
		}
		
		readCSV.close();
		return csvRecords;
	}
	
	/**
	 * A public static method that outputs a welcome message for the DCC Hurricane Database
	 * program, outputs the total number of records, prompts and returns the user's search term.
	 * @param records ArrayList of storm records 
	 * @return search term to be looked up in storm records list
	 */
	private static String getUserInput(ArrayList<StormRecord> records) {
		
		Scanner userInput = new Scanner(System.in);
		
		// Welcome message + prompt
		System.out.println("\nWelcome to the DCC Hurricane Database!\n");
		
		System.out.println("Enter all or part of the name of a North "
			+ "Atlantic Hurricane to search.\nThe program will find"
			+ " records for hurricanes with the highest wind speed\n"
			+ "and highest storm speed from the database for the given name.\n");
	
		System.out.printf("Total records:  %d\n\n", records.size());
		
		System.out.print("Hurricane Name: ");
	
		return userInput.nextLine();

	}
	
	
	/**
	 * Generates final report of search term in storm records, prompts user to continue using report, and returns
	 * that answer.
	 * @param searchTerm Search term that was queried in storm records
	 * @param recordCount Number of times search term appears in storm records
	 * @param maxWind Storm record of hurricane with highest wind that matches search term
	 * @param maxSpeed Storm record of hurricane with fastest speed that matches search term
	 * @return user's decision to continue using DCC Hurricane Database program
	 */
	private static String generateFinalReport(String searchTerm, int recordCount, StormRecord maxWind, StormRecord maxSpeed) {
		
		Scanner userInput = new Scanner(System.in);
		
		// Heading for report
		System.out.println("\n************************************************");
		System.out.println("Hurricane report for: " + searchTerm + "\n");
		
		
		// Change output message if no records were found
		
		if(recordCount == 0) {
			System.out.println("No records were found.\n");
			
			System.out.printf("Would you like to try again (Y/N)? ");
			
			return userInput.nextLine(); 
			
		}
		
		// Generate regular output message if records were found
		else {
		
			System.out.println("Total number of records found: " + recordCount + "\n");
			
			System.out.println("Highest Wind:");
			System.out.println(maxWind + "\n");
			
			System.out.println("Fastest Storm:");
			System.out.println(maxSpeed);
			System.out.println("************************************************\n");
	
			
			System.out.printf("Would you like to try again (Y/N)? ");
			
			return userInput.nextLine();
		
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<StormRecord> data = loadData();
		
		// Continue prompting the user for search term until input == "n"
		boolean shouldContinue = true;
		while (shouldContinue){
			
			// Generate welcome message for program, prompt user for search term, 
			// and make it match the case of storm records in ArrayList.
			
			String userHurricane = getUserInput(data);
			String searchTerm = userHurricane.toUpperCase();

			
			// Create placeholder StormRecord objects to store max wind and max speed 
			// hurricanes from ArrayList
			
			StormRecord maxWind = null;
			StormRecord maxSpeed = null;
	
			
			int recordCount = 0;
			
			// Loop through storm records list, keep track of total records that match search term and
			// update max wind / max speed if greater records with greater values are found in the list.
			
			for(StormRecord record: data) {
				if (searchTerm.length() > 0 && record.getName().contains(searchTerm)) {
					recordCount++;
					
					if(maxWind == null || record.getWind() > maxWind.getWind()) {
						maxWind = record;
					}
					
					if (maxSpeed == null || record.getSpeed() > maxSpeed.getSpeed()){
						maxSpeed = record;
					}
				}
			}
			
			// Generate final and prompt user to continue using DCC Hurricane Database or not
			
			String continuePrompt = generateFinalReport(searchTerm, recordCount, maxWind, maxSpeed);
			
			if(continuePrompt.equalsIgnoreCase("n")) {
				shouldContinue = false;
				System.out.println("\nThanks for using the DCC Hurricane Database!");
			}
		}
				
	}

}
