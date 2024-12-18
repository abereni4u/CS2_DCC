/**
 * The StormRecord Java class represents a single storm tracking event record in the database.
 * It consists of fields that holds information read from the “htracks_na_cps142_dcc.csv” file.
 */
public class StormRecord implements Comparable<StormRecord> {
	
	// ----------------------------------------------//
	// FIELDS
	//----------------------------------------------//
	
	// FIELD NAMES
	private String id, name, timestamp, status; 
	private int year, number, category;
	private double latitude, longitude, wind, pressure,
				speed, direction;
	
	// FIELD POSITIONS
	private final int ID_POS = 18, YEAR_POS = 1, NUMBER_POS = 2, NAME_POS = 5, TIMESTAMP_POS = 6,
			  LATITUDE_POS = 19, LONGITUDE_POS = 20, STATUS_POS = 21, WIND_POS = 22, 
			  PRESSURE_POS = 23, CATEGORY_POS = 24, SPEED_POS = 25, DIRECTION_POS = 26;
	
	// FIELD LABELS
	private String nameLabel = "Name:", yearLabel = "Year:", numberLabel = "Number:",
			idLabel = "ID:", timestampLabel = "Timestamp:", categoryLabel = "Category:",
			statusLabel = "Status:", latitudeLabel = "Latitude(N):",
			longitudeLabel = "Longitude(E):", windLabel = "Wind(kts):", 
			pressureLabel = "Pressure(mb):", speedLabel = "Speed(kts):", 
			directionLabel = "Direction(d):";
	

	// ----------------------------------------------//
	// CONSTRUCTOR
	//----------------------------------------------//
	
	
	/**
	 * This constructor takes a String object that is then tokenized using a comma “,” delimiter.
	 * Once the string is tokenized, the array of tokens String objects are used to initialize
	 * the instance fields of this class.
	 * @param string String to be tokenized. 
	 */
	public StormRecord(String string){

		
		// Tokenize the input string using "," as the delimiter, then trim each token.
		
		String trimmedString = string.trim();
		String[] tokens = trimmedString.split(",");
		for(int i = 0; i< tokens.length; i++) {
			tokens[i] = tokens[i].trim();
		}
		
		
		// Check each field in the list of tokens for empty values. If the values are
		// empty, use default values, otherwise use the token value and convert it if
		// necessary. 

		//-------------------------//
		// FIELD: ID
		//-------------------------//
	
		if(tokens[ID_POS].length() != 0) {
			this.id = tokens[ID_POS];
		}
			
		//-------------------------//
		// FIELD: YEAR	
		//-------------------------//

		if(tokens[YEAR_POS].length() != 0) {
			this.year = Integer.parseInt(tokens[YEAR_POS]);
		}
			
		//-------------------------//
		// FIELD: NUMBER	
		//-------------------------//
		
		if(tokens[NUMBER_POS].length() != 0) {
	
			this.number = Integer.parseInt(tokens[NUMBER_POS]);
		}
		
		//-------------------------//
		// FIELD: NAME	
		//-------------------------//
		
		if(tokens[NAME_POS].length() != 0) {

			this.name = tokens[NAME_POS];
		}
		
		//-------------------------//
		// FIELD: TIMESTAMP	
		//-------------------------//
		
		
		if(tokens[TIMESTAMP_POS].length() != 0) {

			this.timestamp = tokens[TIMESTAMP_POS];
		}
	
		//-------------------------//
		// FIELD: LATITUDE	
		//-------------------------//
		
		if(tokens[LATITUDE_POS].length() != 0) {

			this.latitude = Double.parseDouble(tokens[LATITUDE_POS]);
		}
			
		//-------------------------//
		// FIELD: LONGITUDE	
		//-------------------------//
		
		if(tokens[LONGITUDE_POS].length() != 0) {
	
			this.longitude = Double.parseDouble(tokens[LONGITUDE_POS]);
		}
		
		//-------------------------//
		// FIELD: STATUS	
		//-------------------------//
		
		if(tokens[STATUS_POS].length() != 0) {

			this.status = tokens[STATUS_POS];
		}
		
		
		//-------------------------//
		// FIELD: WIND	
		//-------------------------//
		
		if(tokens[WIND_POS].length() != 0) {

			this.wind = Double.parseDouble(tokens[WIND_POS]);
		}
		
		//-------------------------//
		// FIELD: PRESSURE	
		//-------------------------//
		
		if(tokens[PRESSURE_POS].length() != 0) {

			this.pressure = Double.parseDouble(tokens[PRESSURE_POS]);
		}
		
		//-------------------------//
		// FIELD: CATEGORY	
		//-------------------------//
		
		if(tokens[CATEGORY_POS].length() != 0) {

			this.category = Integer.parseInt(tokens[CATEGORY_POS]);
		}
	
		//-------------------------//
		// FIELD: SPEED	
		//-------------------------//

		if(tokens[SPEED_POS].length() != 0) {

			this.speed = Double.parseDouble(tokens[SPEED_POS]);
		}
		
		//-------------------------//
		// FIELD: DIRECTION	
		//-------------------------//

		if(tokens[DIRECTION_POS].length() != 0) {

			this.direction = Double.parseDouble(tokens[DIRECTION_POS]);
		}
		
	}
	
	/**
	 * No-arg constructor for StormRecord
	 */
	public StormRecord() {
		
	}
	
	// ----------------------------------------------//
	// GETTERS
	//----------------------------------------------//
	
	/**
	 * Returns value in id field
	 * @return id
	 */
	public String getID() {
		return this.id;
	}

	/**
	 * Return value in year field
	 * @return year
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * Return value in number field
	 * @return number
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Return value in name field
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return value in timestamp field
	 * @return timestamp
	 */
	public String getTimestamp() {
		return this.timestamp;
	}
	
	/**
	 * Return value in latitude field
	 * @return latitude
	 */
	public double getLatitude() {
		return this.latitude;
	}
	/**
	 * Return value in longitude field
	 * @return longitude
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	
	/**
	 * Return value in status field
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Return value in wind field
	 * @return wind
	 */
	public double getWind() {
		return this.wind;
	}
	
	/**
	 * Return value in pressure field
	 * @return pressure
	 */
	public double getPressure() {
		return this.pressure;
	}
	
	/**
	 * Return value in category field
	 * @return category
	 */
	public int getCategory() {
		return this.category;
	}
	
	/**
	 * Return value in speed field
	 * @return speed
	 */
	public double getSpeed() {
		return this.speed;
	}
	
	/**
	 * Return value in direction field
	 * @return direction
	 */
	public double getDirection() {
		return this.direction;
	}
	
	//----------------------------------------------//
	// SETTERS 
	//----------------------------------------------//
	/**
	 * Change StormRecord timestamp to 
	 * @param timestamp the timestamp to be placed in the StormRecord object.
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	//----------------------------------------------//
	// COMPARE TO 
	//----------------------------------------------//
	
	@Override
	public int compareTo(StormRecord o) {
		return this.timestamp.compareTo(o.timestamp);
	}
	
	//----------------------------------------------//
	// TO STRING
	//----------------------------------------------//
	
	
	@Override
	public String toString() {
		
		// Creates StringBuilder report w/ separate lines for each field;
		
		StringBuilder stormRecordReport = new StringBuilder();
		
		stormRecordReport.append(String.format("%-20s %-25s\n", nameLabel, getName()));
		stormRecordReport.append(String.format("%-20s %-25d\n", yearLabel, getYear()));
		stormRecordReport.append(String.format("%-20s %-25d\n", numberLabel, getNumber()));
		stormRecordReport.append(String.format("%-20s %-25s\n", idLabel, getID()));
		stormRecordReport.append(String.format("%-20s %-25s\n", timestampLabel, getTimestamp()));
		stormRecordReport.append(String.format("%-20s %-25d\n", categoryLabel, getCategory()));
		stormRecordReport.append(String.format("%-20s %-25s\n", statusLabel, getStatus()));
		stormRecordReport.append(String.format("%-20s %-25.1f\n", latitudeLabel, getLatitude()));
		stormRecordReport.append(String.format("%-20s %-25.1f\n", longitudeLabel, getLongitude()));
		stormRecordReport.append(String.format("%-20s %-25.1f\n", windLabel, getWind()));
		stormRecordReport.append(String.format("%-20s %-25.1f\n", pressureLabel, getPressure()));
		stormRecordReport.append(String.format("%-20s %-25.1f\n", speedLabel, getSpeed()));
		stormRecordReport.append(String.format("%-20s %-25.1f", directionLabel, getDirection()));

		return stormRecordReport.toString();
	}
}


	
	
