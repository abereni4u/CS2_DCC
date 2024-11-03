//package reference;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;
import com.apple.laf.AquaButtonBorder.Toggle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * CPS142 - Fall 2024
 * 10/31/24 
 * Professor: Adam Divelbiss
 * @author Abereni Opuiyo
 * Assignment: Program05
 * Purpose: Simple graphical user interface for a Hurricane database. Allows the 
 * user to display information for storm records for a selected hurricane name.
 */
public class Main extends Application {

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

		// populate the menuBar with Menus using buildFileMenu and buildModeMenu

		menuBar.getMenus().add(buildFileMenu());
		menuBar.getMenus().add(buildModeMenu());

		this.rootPane = new BorderPane();
		this.rootPane.setTop(menuBar);
		this.rootPane.setCenter(getStormRecordBrowserScene());

		// Create the Scene
		Scene scene = new Scene(rootPane, 900, 450);

		// Get the scene
		primaryStage.setScene(scene);

		// set the title

		stage.setTitle("Storm Record App");

		// set the initial css mode

		scene.getStylesheets().add("light.css");

		// Show the primary stage
		primaryStage.show();

	}

	/**
	 * Builds and returns the file Menu
	 * 
	 * @return
	 */
	private Menu buildFileMenu() {

		// create the File Menu and "Exit" menu item

		Menu fileMenu = new Menu("File");

		MenuItem exitMenu = new MenuItem("Exit");
		
		// create "browse" and "search" radio menu items and add them to a 
		// toggle group
		
		RadioMenuItem browseMenu = new RadioMenuItem("Browse");
		RadioMenuItem searchMenu = new RadioMenuItem("Search");
		SeparatorMenuItem seperator = new SeparatorMenuItem();
		
		ToggleGroup modeToggle = new ToggleGroup();
		browseMenu.setToggleGroup(modeToggle);
		searchMenu.setToggleGroup(modeToggle);
		

		// Close application when "Exit" is clicked"
		exitMenu.setOnAction(event -> {
			stage.close();
		});
		
		// Change ui layout when "browse" radio menu item is selected
		browseMenu.setOnAction(event -> {
			this.rootPane.setCenter(getStormRecordBrowserScene());
		});
		
		// change ui layout when "search" radio menu item is selected
		searchMenu.setOnAction(event -> {
			this.rootPane.setCenter(getSearchScene());
		});
		
		
		fileMenu.getItems().add(browseMenu);
		fileMenu.getItems().add(searchMenu);
		fileMenu.getItems().add(seperator);
		fileMenu.getItems().add(exitMenu);
		return fileMenu;
	}

	/**
	 * Builds and returns the mode Menu
	 * 
	 * @return
	 */
	private Menu buildModeMenu() {
		
		// Create mode menu and radio menu items
		Menu modeMenu = new Menu("Mode");
		RadioMenuItem lightMode = new RadioMenuItem("Light");
		RadioMenuItem darkMode = new RadioMenuItem("Dark");

		// Create toggle group and add radio items to it
		ToggleGroup styleToggleGroup = new ToggleGroup();
		lightMode.setToggleGroup(styleToggleGroup);
		darkMode.setToggleGroup(styleToggleGroup);

		// Set initial radio button selection
		lightMode.setSelected(true);

		// Change css style for light mode and dark mode
		lightMode.setOnAction(event -> {
			this.stage.getScene().getStylesheets().clear();
			this.stage.getScene().getStylesheets().add("light.css");
		});
		darkMode.setOnAction(event -> {
			this.stage.getScene().getStylesheets().clear();
			this.stage.getScene().getStylesheets().add("dark.css");
		});

		// Add radio button items to menu
		modeMenu.getItems().add(lightMode);
		modeMenu.getItems().add(darkMode);

		return modeMenu;
	}

	/**
	 * Build and return the storm record browser scene
	 * 
	 * @return
	 */
	private Pane getStormRecordBrowserScene() {

		// --------------------------------------------------------------------
		// Left-side Control Panel - City filter and statistics
		// Filter selector using ComboBox
		// --------------------------------------------------------------------
		
		// Setup the filter selector as a ComboBox with options
		ComboBox<String> filterSelector = new ComboBox<>();

		
		// create array list to store all the names from storm record list
		ArrayList<String> names = new ArrayList<>();
		
		// SLIDER SETUP
	
		Slider catSlider = new Slider(0.0,5.0,0.0);
		catSlider.setMajorTickUnit(1.0);
		catSlider.setMinorTickCount(0);
		catSlider.setSnapToTicks(true);
		catSlider.setShowTickLabels(true);
		catSlider.setShowTickMarks(true);
		catSlider.setBlockIncrement(1.0);
		// catSlider.lookup(".axis").setStyle("-fx-tick-label-fill: white;");
		Label sliderLabel = new Label("Minimum Category:");
		sliderLabel.getStyleClass().add("heading-label");
		VBox sliderBox = new VBox(2, sliderLabel,catSlider);
		
		// if a name in the storm record isn't in the names arraylist already, add it
		for (StormRecord record : this.data) {
			if (!names.contains(record.getName()))
				names.add(record.getName());
		}
		
		// add all unique names to the filter selector's observable list
		filterSelector.getItems().addAll(names);
		filterSelector.setValue("Ivan");

		// set statistics labels 

		Label selectFilter = new Label("Select a Hurricane");
		selectFilter.getStyleClass().add("heading-label");
		
		Label totalRecordsLabel = new Label();

		Label maxWindSpeedTimestamp = new Label();
		Label maxWindSpeed = new Label();

		Label maxStormSpeedTimestamp = new Label();
		Label maxStormSpeed = new Label();

		// filterSelector width
		filterSelector.setPrefWidth(200);
		
		// Create the left-side controls column using a VBox.
		VBox controlLabelFilter = new VBox(10, selectFilter, filterSelector);
		VBox controlLabelWind = new VBox(2, maxWindSpeedTimestamp, maxWindSpeed);
		VBox controlLabelStorm = new VBox(2, maxStormSpeedTimestamp, maxStormSpeed);
		

		VBox controlColumnLeft = new VBox(20, controlLabelFilter, sliderBox, totalRecordsLabel,
				controlLabelWind, controlLabelStorm); 
	
		// styling for control column left
		controlColumnLeft.getStyleClass().add("control-column-left");
		controlColumnLeft.setPrefWidth(500);
		controlColumnLeft.setPadding(new Insets (20,20,20,20));
		//controlColumnLeft

		// --------------------------------------------------------------------
		// Center Control Panel
		// with City ListView selector
		// --------------------------------------------------------------------
		
		// Create a JavaFX ListView to display filtered StormRecord information.
		ListView<String> stormListView = new ListView<>();
		stormListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		// Create the center control column VBox and include the stormListView ListView
		Label stormListLabel = new Label("Select a Storm Record:");
		
		// styling for heading label
		stormListLabel.getStyleClass().add("heading-label");

	
	
		VBox controlColumnCenter = new VBox(10, stormListLabel, stormListView);
		
		// styling for center control column
		controlColumnCenter.getStyleClass().add("control-column-center");
		controlColumnCenter.setPrefWidth(720);
		controlColumnCenter.setPadding(new Insets(20,10,20,10));

		// --------------------------------------------------------------------
		// Right-side Control Panel
		// Individual city information
		// --------------------------------------------------------------------
		
		// Declare and initialize a Label for the  Hurricane Information column
		Label stormRecordInfoLabel = new Label();

		// Create the right-side control column including the stormRecrodInfoLabel Label
		Label selectedStorm = new Label("Selected Storm Record:");		
		VBox controlColumnRight = new VBox(10, selectedStorm, stormRecordInfoLabel);
		selectedStorm.getStyleClass().add("heading-label");

		
		// styling for right control column
		controlColumnRight.getStyleClass().add("control-column-right");
		controlColumnRight.setPrefWidth(520);
		controlColumnRight.setPadding(new Insets(20,20,20,20));

		// --------------------------------------------------------------------
		// Setup the outside view wrappers
		// --------------------------------------------------------------------
		
		// Update the HBox below to use the column VBox items above once they
		HBox root = new HBox(
				controlColumnLeft,
				controlColumnCenter,
				controlColumnRight);

		// --------------------------------------------------------------------
		// Setup helpers
		// --------------------------------------------------------------------
	
		// implement event handler for filter selection
		UpdateHandler filterUpdateHandler = () -> {
			// clear text in rightmost column when filter is selected.
			stormRecordInfoLabel.setText("");
			
			filteredData = new ArrayList<>();
			
			// get selected filter from comboBox to be searched in StormRecord array. 
			String searchTerm = filterSelector.getValue().toLowerCase();
			
			// Loop through storm records list and add matching storm record and category to
			// filtered data list to be displayed in center ListView. Update max 
			// wind / max speed if records with greater values are found in the list.

			StormRecord maxWind = null;
			StormRecord maxSpeed = null;

			for (StormRecord record : data) {
				if (searchTerm.length() > 0 && record.getName().toLowerCase().startsWith(searchTerm) && record.getCategory() >= catSlider.getValue())
					filteredData.add(record);
			}
			
			for (StormRecord catRecord: filteredData) {
				if (maxWind == null || maxWind.getWind() < catRecord.getWind()) {
					maxWind = catRecord;
				}

				if (maxSpeed == null || maxSpeed.getSpeed() < catRecord.getSpeed()) {
					maxSpeed = catRecord;
				}
			}
			

			// Set labels in left hand column to display info of selected filter's total amount,
			// strongest wind, and fastest storm speed.
			totalRecordsLabel.setText("Total Records:  " + String.valueOf(filteredData.size()));
			
			// If the filter didn't have any storms that were equal or greater than the slider value
			// Set the max wind and max speed to zero.
			if(maxWind !=null) {
				maxWindSpeedTimestamp.setText("Strongest:  " + maxWind.getTimestamp());
				maxWindSpeed.setText("Wind Speed:  " + String.valueOf(maxWind.getWind()));
			}
			else {
				maxWindSpeedTimestamp.setText("Strongest: NOT AVAILABLE");
				maxWindSpeed.setText("Wind Speed: NOT AVAILABLE");
			}
			
			if(maxSpeed != null) {
				maxStormSpeedTimestamp.setText("Fastest:  " + maxSpeed.getTimestamp());
				maxStormSpeed.setText("Storm Speed:  " + String.valueOf(maxSpeed.getSpeed()));
			}
			else {
				maxStormSpeedTimestamp.setText("Fastest: NOT AVAILABLE");
				maxStormSpeed.setText("Storm Speed: NOT AVAILABLE");
			}
			
			// Clear storm listView selection when a new filter is selected.
			stormListView.getSelectionModel().clearSelection();
			stormListView.getItems().clear();

			
			// Create and add a css class to listView control
			stormListView.getStyleClass().add("storm-list-view");
			
			// loop through filtered data list and add entries to 
			// the storm listView's observable list based off initial slider value.
			for (StormRecord record : filteredData) {
					String info = String.format("%-15s cat: %-2d lat: %6.1f long: %6.1f",
						record.getTimestamp(),
						record.getCategory(),
						record.getLatitude(),
						record.getLongitude());
						stormListView.getItems().add(info);
			};

		};

		// --------------------------------------------------------------------
		// Setup control event handlers
		// --------------------------------------------------------------------
		
		// Register an event handler to the filterSelector ComboBox.
		filterSelector.setOnAction(event -> {
			filterUpdateHandler.update();
		});

		// Setup ListView listener for the stormListView -
		// this handles user selection of a storm record and displays
		// information for the storm record in the right-hand panel.

		// Register listener to storm listView
		stormListView.getSelectionModel().selectedItemProperty().addListener(event -> {
			
			// get the index of the selected storm record
			int selectedIndex = stormListView.getSelectionModel().getSelectedIndex();
			
			// retrieve storm record from filtered data array using index from above
			StormRecord listViewRecord = filteredData.get(selectedIndex);
			
			// output info of storm record to right column.
			stormRecordInfoLabel.setText(listViewRecord.toString());
		});

		// Add listener to slider - just call the filter update handler everytime it changes to update the filtered
		// data list. 
		catSlider.valueProperty().addListener(
			(observable, oldvalue, newvalue) ->
			{
				filterUpdateHandler.update();	
				
			});
 
		//  Initialize the display at startup and category slider to 0.
		catSlider.setValue(0);
		filterUpdateHandler.update();

		return root;
	} // getStormRecordBrowserScene

	
	/**
	 * Creates and returns the user interface that implements the Search feature. 
	 * 
	 * @return user interface for Search
	 */
	private Pane getSearchScene() {
		
		// Controls for search scene
		Label titleText = new Label("Storm Search");
		Label instructionText = new Label("Enter a timestamp\n"
				+ "[M]M/[D]D/YY [h]h:mm\n"
				+ "For example: 9/10/77 3:00");
		TextField searchTerm = new TextField();
		Button searchButton = new Button("SEARCH");
		Label searchResult = new Label();
		
		// Grouping of controls for search scene
		VBox leftSide = new VBox(10,instructionText, searchTerm, searchButton);
		VBox rightSide = new VBox(searchResult);
		HBox searchLayout = new HBox(10, leftSide, rightSide);
		VBox searchScreen = new VBox(10, titleText, searchLayout);
	
		// Styling of controls
		titleText.getStyleClass().add("search-title");
	
		instructionText.getStyleClass().add("search-left");
		searchResult.getStyleClass().add("search-right");
		searchButton.setPrefWidth(100);
		
		leftSide.getStyleClass().add("control-column-left");
		leftSide.setPrefHeight(350);
		leftSide.setPrefWidth(520);
		leftSide.setPadding(new Insets(20));
		leftSide.setAlignment(Pos.CENTER_LEFT);
		
		rightSide.getStyleClass().add("control-column-right");
		rightSide.setPrefWidth(520);
		rightSide.setPadding(new Insets(20));
		
		searchScreen.setPadding(new Insets(20));
		searchScreen.setAlignment(Pos.CENTER);
	
		// Search button event register
		searchButton.setOnAction(event -> {
			// Get the searchText from the searchTextField 
			String searchText = searchTerm.getText();
			
			// Create a StormRecord with the timestamp we want to find
			
			StormRecord toFind = new StormRecord(); 
			toFind.setTimestamp(searchText);
			
			// Get the index of the object in this.data,
			// using the recursive binary search
			
			int searchIndex = Searcher.search(this.data, toFind);
			
			// if the searchIndex is less than 0 then display an appropriate not found message
			if (searchIndex < 0) {
				searchResult.setText("No records found for timestamp:\n" + searchText);
			}
			// Otherwise get object at searchIndex of this.data
			else {
				searchResult.setText(this.data.get(searchIndex).toString());
			}
		});
		
		return searchScreen;
	}
	/**
	 * This method loads record data from an external file and
	 * returns it as an ArrayList of StormRecord objects.
	 * 
	 * @return - the ArrayList of StormRecord Objects
	 */
	private static ArrayList<StormRecord> loadData() {
		
		// Create a placeholder StormRecord object and an arraylist of StormRecords then
		// open the csv file and create a StormRecord object from each string.

		StormRecord csvStormRecord;

		String csvString;

		ArrayList<StormRecord> csvRecords = new ArrayList<>();

		Scanner readCSV = null;

		try {

			File csvFile = new File(DATA_FILE);

			// csvFile exists so continue, otherwise exception thrown before this point

			readCSV = new Scanner(csvFile);

			// Skips the first two lines of the CSV
			for (int i = 1; i <= 2; i++)
				readCSV.nextLine();

			while (readCSV.hasNextLine()) {
				csvString = readCSV.nextLine();
				csvStormRecord = new StormRecord(csvString);
				csvRecords.add(csvStormRecord);
			}
			
			// Sort the list based on each Storm Record's timestamp.
			Sorter.sort(csvRecords);
		}
		// handle file not found exception by displaying an error
		catch (FileNotFoundException e) {
			System.out.println("There was problem processing the file");
			System.out.println("Stack Trace:");
			for (StackTraceElement msg : e.getStackTrace()) {
				System.out.println("  " + msg);
			}
		} finally {
			// readCSV DOES contain a file, so close it.
			if (readCSV != null)
				readCSV.close();
		}

		return csvRecords;

	}

}
