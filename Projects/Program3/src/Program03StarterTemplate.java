


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO: 2. Write your Project Documentation comment here.
/**
 * CPS142 - Fall 2024
 * Program 3
 * @author Abereni Opuiyo
 * Simple test program for the Shape classes
 */
public class Program03StarterTemplate extends Application{

	public static final String DATA_FILE = "src/htracks_na_cps142_dcc.csv";

	// --------------------------
	// Application instance fields.
	// --------------------------
	// UI Related Fields
	private Stage stage;
	private BorderPane rootPane;	
	private MenuBar menuBar;

	// Data related fields
	private ArrayList<StormRecord> data;

	private ArrayList<StormRecord> filteredData;


	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * start method for the JavaFX application
	 */
	@Override
	public void start(Stage primaryStage) {

		// Load the Hurricane data
		this.data = loadData();

		// Remember the primaryStage
		this.stage = primaryStage;

		// Create the Menu
		this.menuBar = new MenuBar();

		// TODO: 3. Use the buildFileMenu and buildModeMenu methods to populate the menuBar.

		menuBar.getMenus().add(buildFileMenu());

		this.rootPane = new BorderPane();
		this.rootPane.setTop(menuBar);
		this.rootPane.setCenter(getStormRecordBrowserScene());

		// Create the Scene
		Scene scene = new Scene(rootPane,900,450);

		// Get the scene
		primaryStage.setScene(scene);

		// set the title
		// TODO: 4. Set the title bar text

		// set the css mode
		// TODO: 5. Load the preferred initial CSS file for light or dark mode

		// Show the primary stage
		primaryStage.show();

	}

	/**
	 * Builds and returns the file Menu
	 * @return
	 */
	private Menu buildFileMenu() {
		
		// TODO: 6. Add code to create the File Menu, (Program 3 - Section 1.1.2)
		
		Menu fileMenu = new Menu("File");
		
		MenuItem exitMenu = new MenuItem("Exit");
		
		// Close application when "Exit" is clicked"
		exitMenu.setOnAction(event -> {
			stage.close();
		});
		
		fileMenu.getItems().add(exitMenu);
		return fileMenu;
	}


	/**
	 * Builds and returns the mode Menu
	 * @return
	 */
	private Menu buildModeMenu() {
		Menu modeMenu = null;
		
		// TODO: 7. Add code to create the complete Mode Menu, (Program 3 - Section 1.1.3)

		return modeMenu;
	}

	/**
	 * Build and return the storm record browser scene
	 * @return
	 */
	private Pane getStormRecordBrowserScene() {

		//--------------------------------------------------------------------
		// Left-side Control Panel - City filter and statistics
		// Filter selector using ComboBox
		// (Program 3 - Section 1.1.5)
		//--------------------------------------------------------------------
		// Setup the filter selector as a ComboBox with options 
		// TODO: 8.a. In the line below, replace null with your code to create the ComboBox
		ComboBox<String> filterSelector = null; 
		
		// TODO: 8.b. Initialize and configure the filterSelector (Program 3 - Section 1.1.4)
		// Use the following algorithm to initialize the filterSelector ComboBox
		// 
		// ArrayList<String> names = new ArrayList<>();
		// for StormRecord record : this.data
		//   if names does not contain record.getName() then
		//      add record to names
		//   endIf
		// endFor
		// add all items in the names array to the filterSelector
		// Set the value of filterSelector to "Ivan".
		
		// TODO: 9. Filtered set statistics labels (Program 3 - Section 1.1.5)
		// Create and style JavaFX Label controls with the following names: 
		// totalRecordsLabel
		// maxWindSpeedTimestamp
		// maxWindSpeed
		// maxStormSpeedTimestamp
		// maxStormSpeed

		// TODO: 10. Setup the controls column (Program 3 - Section 1.1.5)
		// Create the left-side controls column using a VBox.
		// Add the Label instances declared and initialized above using
		// VBox, HBox, and additional Label controls as need.
		// Consider setting preferred widths, alignment, and padding
		// to achieve a nice looking layout.
		VBox controlColumnLeft = null; // Replace null with your code to create and initialize the VBox



		//--------------------------------------------------------------------
		// Center Control Panel
		// with City ListView selector
		// (Program 3 - Section 1.1.6)
		//--------------------------------------------------------------------
		// TODO: 11. storm record list view (Program 3 - Section 1.1.6)
		// Create a JavaFX ListView to display filtered StormRecord information.
		// Replace "null" below with your code to instantiate a ListView.
		// Make sure that the ListView is in single selection mode.
		// Style using preferred widths and heights, etc. as needed
		ListView<String> stormListView = null;

		// TODO: 12. Center Control column (Program 3 - Section 1.1.6)
		// Create the center control column VBox and include the stormListView ListView 
		// and an appropriate Label.  
		// Replace "null" below with your code to instantiate a VBox.
		// Consider setting preferred widths, alignment, and padding
		// to achieve a nice looking layout.
		VBox controlColumnCenter = null; 
		
		
		//--------------------------------------------------------------------
		// Right-side Control Panel
		// Individual city information
		// (Program 3 - Section 1.1.7)
		//--------------------------------------------------------------------
		// Hurricane Information column
		// TODO: 13. Declare and initialize a Label called stormRecrodInfoLabel

		// TODO: 14. Create the right-side column(Program 3 - Section 1.1.6)
		// Create the right-side control column including the stormRecrodInfoLabel Label 
		// and an appropriate "Selected City" Label 
		// Replace "null" below with your code to instantiate a VBox.
		// Consider setting preferred widths, alignment, and padding
		// to achieve a nice looking layout.
		VBox controlColumnRight = null;

		
		//--------------------------------------------------------------------
		// Setup the outside view wrappers
		//--------------------------------------------------------------------		
		// TODO: 15. Update the HBox below to use the column VBox items above once they have
		// been completed
		// Consider setting preferred widths, alignment, padding, size, etc.
		// to achieve a nice looking layout.
		HBox root = new HBox(20, 
				new Label("Replace this entire Label starting at 'new' and ending at ')' with controlColumnLeft"), 
				new Label("Replace this entire Label starting at 'new' and ending at ')' with controlColumnCenter"), 
				new Label("Replace this entire Label starting at 'new' and ending at ')' with controlColumnRight"));


		//--------------------------------------------------------------------
		// Setup helpers
		//--------------------------------------------------------------------		
		// TODO:  16. Define a filterUpdateHandler to handle events related to a change in the filter setting
		// 
		// Replace "null" in the line of code below with a Lambda expression or anonymous inner class to do the following:
		// 
		// ********************************************* IMPORTANT *****************************************
		// *             See the filterUpdateHandler local variable below this comment block!              *
		// *              Write all of the following algorithm INSIDE the Lambda expression                *
		// *                          or anonymous inner class update method.                              *
		// *************************************************************************************************
		//
		// 1. "Clear" the text in the stormRecrodInfoLabel declared above by setting its text to an empty string ""
		//     (Textbook Section 12.2, from CPS141) 
		//
		// 2. Initialize the filteredData field with a new, empty, ArrayList. 
		//    (Textbook, Section 7.13, CPS141)
		//
		// 3. Declare a local variable, searchTerm : String, and initialize it with
		//    a lower-case copy of the current value of the filterSelector ComboBox
		//    (Textbook Section 13.3)
		//
		// 4. Implement the following algorithm to filter the storm record data based on the serchTerm
		//    into the filteredData field and to find the most populous and  most dense cities.
		//    NOTE: You've already written an algorithm very much like this in Program 1.  
		//    Take your original code and adapt it for this use.
		//
		//    StormRecord maxWind = null
		//    StormRecord maxSpeed = null
		//  
		//    for (StormRecord record : data) // use an enhanced for loop
		//        if searchTerm.length > 0 and record.getName().toLowerCase().startsWith(searchTerm)
		//  
		//        add record to filteredData ArrayList
		//
		//        if maxWind==null or maxWind.getWind() < record.getWind() )
		//            maxWind = record
		//        endif
		//
		//        if maxSpeed==null or maxSpeed.getSpeed() < record.getSpeed()
		//            maxSpeed = city
		//        endif
		//
		//      endif
		//    endfor
		//
		// 5. Set the text of the totalRecordsLabel to the number of items in the filteredData array.
		//    (Textbook Section 7.3 and Section 12.2, from CPS141)
		//
		// 6. Set the text of the maxWindSpeedTimestamp Label to the timestamp of maxWind.
		//    (Textbook Section 12.2, from CPS141)
		//
		// 7. Set the text of the maxWindSpeed Label to the wind speed of maxWind.
		//    Use a nicely formatted number with "," comma thousands separators.
		//    (Textbook Section 3.10 and Section 12.2, from CPS141)
		//
		// 8. Set the text of the maxStormSpeedTimestamp Label to the timestamp of maxSpeed.
		//    (Textbook Section 12.2, from CPS141)
		//
		// 9. Set the text of the maxStormSpeed to the speed of maxSpeed.
		//    Use a nicely formatted number with "," comma thousands separators and two decimal places.
		//    (Textbook Section 3.10 and Section 12.2, from CPS141)
		//
		// 10. Clear the current selection of the stormListView. 
		//     (Textbook Section 13.4)
		//
		// 11. Clear all of the items in the stormListView.  
		//     (Textbook Section 13.4)
		//
		// 12. Add an display String for each Storm in the filteredData ArrayList to the stormListView.
		//     (Textbook Section 13.4)
		//
		//	   for (StormRecord record : filteredData) {
		//         // Create a nicely formatted String with the following storm information:
		//         // timestamp, category, latitude, longitude
		//         String info = <Use String.format to create a String object>
		//         // Add the info String to the stormListView items as described in Section 13.4.
		//     }
		//
		UpdateHandler filterUpdateHandler = null;		

		//--------------------------------------------------------------------
		// Setup control event handlers
		//--------------------------------------------------------------------		
		// TODO: 17. Configure the filterSelector event handler
		// Write a setOnAction event handler for the filterSelector ComboBox.
		// The handler should simply call the filterUpdateHandler update() method.
		//
		// Uncomment the line below and add your code where indicated.
		// You may use a lambda expression or anonymous inner class.

		// filterSelector.setOnAction( /* your code goes in here */ );				

		
		// TODO: 18. Setup ListView listener for the stormListView - 
		// this handles user selection of a storm record and displays
		// information for the storm record in the right-hand panel.
		// 
		// your listener should to the following:
		//
		// 1. Get the index of the currently selected item in the stormListView as a int local variable called selectedIndex
		//
		//    int selectdIndex = //add your code to get the selected index. 
		// 
		//    (Textbook Section 13.4) 
		//    HINT: only one line of code needed
		//
		// 2. Get the selected instance of StormRecord from the filteredData array using the selectedIndex of step 1.
		//    (Textbook Section 7.13 - for how to get an item at an index from an ArrayList) 
		//    HINT: only one line of code needed
		//
		// 3. Set the text of the stormRecrodInfoLabel by calling the selected StormRecord instance toString() method.
		//    (Textbook Section 12.2 & 12.3 from CPS141 Label setText method)
		//    HINT: only one line of code needed
		//
		// Uncomment the line below and add your code where indicated.
		// You may use a lambda expression or anonymous inner class.
		
		// stormListView.getSelectionModel().selectedItemProperty().addListener( /* your code goes here */ ); 


		// TODO: 19. Initialize the display at startup by calling following line of code. Just uncomment it.
		// filterUpdateHandler.update();


		return root;
	} // getStormRecordBrowserScene



	/**
	 * This method loads record data from an external file and
	 * returns it as an ArrayList of StormRecord objects.
	 * @return - the ArrayList of StormRecord Objects
	 */
	public static ArrayList<StormRecord> loadData() {

		
		// TODO: 20. Add your code  to load the StormRecrod data from the file
		// NOTE: You must handle all exceptions here using try-catch-finally blocks.
		// NOTE: Use your loadData method from Program 1 as a starting point.
		
		StormRecord csvStormRecord;
		
		String csvString;
		
		ArrayList<StormRecord> csvRecords = new ArrayList<>();
		
		Scanner readCSV = null; 
		
		try {
			
			File csvFile = new File(DATA_FILE);
			
			// csvFile exists so continue, otherwise exception thrown before this point 
			
			readCSV = new Scanner(csvFile);
			
			// Skips the first two lines of the CSV 
			for(int i = 1; i<=2; i++)
				readCSV.nextLine();
			
			while(readCSV.hasNextLine()) {
				csvString = readCSV.nextLine();
				csvStormRecord = new StormRecord(csvString);
				csvRecords.add(csvStormRecord);
			}
		}	
		// handle file not found exception by displaying an error
		catch(FileNotFoundException e) {
			System.out.println("There was problem processing the file");
			System.out.println("Stack Trace:");
			for (StackTraceElement msg : e.getStackTrace()) {
				System.out.println("  " + msg);
			}
		}	
		finally	{
			// readCSV contains DOES contain a file, so close it.
			if(readCSV != null)
				readCSV.close();
		}
		
		return csvRecords;

	}


}
