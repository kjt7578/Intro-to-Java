import java.util.ArrayList;

/**
 * The StopAndFrisk class represents stop-and-frisk data, provided by
 * the New York Police Department (NYPD), that is used to compare
 * during when the policy was put in place and after the policy ended.
 * 
 * @author Tanvi Yamarthy
 * @author Vidushi Jindal
 */
public class StopAndFrisk {

    /*
     * The ArrayList keeps track of years that are loaded from CSV data file.
     * Each SFYear corresponds to 1 year of SFRecords. 
     * Each SFRecord corresponds to one stop and frisk occurrence.
     */ 
    private ArrayList<SFYear> database; 

    /*
     * Constructor creates and initializes the @database array
     * 
     * DO NOT update nor remove this constructor
     */
    public StopAndFrisk () {
        database = new ArrayList<>();
    }

    /*
     * Getter method for the database.
     * *** DO NOT REMOVE nor update this method ****
     */
    public ArrayList<SFYear> getDatabase() {
        return database;
    }

    /**
     * This method reads the records information from an input csv file and populates 
     * the database.
     * 
     * Each stop and frisk record is a line in the input csv file.
     * 
     * 1. Open file utilizing StdIn.setFile(csvFile)
     
     * 2. While the input still contains lines:
     *    - Read a record line (see assignment description on how to do this)
     
     *    - Create an object of type SFRecord containing the record information
     *    - If the record's year has already is present in the database:
     *        - Add the SFRecord to the year's records
     *    - If the record's year is not present in the database:
     *        - Create a new SFYear 
     *        - Add the SFRecord to the new SFYear
     *        - Add the new SFYear to the database ArrayList
     * 
     * @param csvFile
     */
    public void readFile ( String csvFile ) {

        // DO NOT remove these two lines
        StdIn.setFile(csvFile); // Opens the file
        StdIn.readLine();       // Reads and discards the header line
        // WRITE YOUR CODE HERE
      //일단 각 한 줄에 recordEntries 배열을 생성해서 그 줄의 단어를 ','로 구별 한 후 하나씩 넣기
      //거기에서 하나씩 뽑아 new SFRecord 클래스에 추가
      // Read each line of the file until there are no more lines
      while (!StdIn.isEmpty()) {
          // Read a line and split it into parts using comma as delimiter
          String[] recordEntries = StdIn.readLine().split(",");

          // Extract relevant information from the recordEntries array
          int year = Integer.parseInt(recordEntries[0]); // Year is the first entry
          String description = recordEntries[2]; // Description is the third entry
          String gender = recordEntries[52]; // Gender is the 53rd entry
          boolean arrested = recordEntries[13].equals("Y"); // Arrested is the 14th entry
          boolean frisked = recordEntries[16].equals("Y"); // Frisked is the 17th entry
          String race = recordEntries[66]; // Race is the 67th entry
          String location = recordEntries[71]; // Location is the 72nd entry

          // Create a new SFRecord object with the extracted information
          SFRecord newRecord = new SFRecord(description, arrested, frisked, gender, race, location);

          boolean yearFound = false;
          for (SFYear sfYear : database) {
              if (sfYear.getcurrentYear() == year) {
                  sfYear.addRecord(newRecord);
                  yearFound = true;
                  break;
              }
          }

          if (!yearFound) {
              SFYear newYear = new SFYear(year);
              newYear.addRecord(newRecord);
              database.add(newYear);
          }
      }
    }

    /**
     * This method returns the stop and frisk records of a given year where 
     * the people that was stopped was of the specified race.
     * 
     * @param year we are only interested in the records of year.
     * @param race we are only interested in the records of stops of people of race. 
     * @return an ArrayList containing all stop and frisk records for people of the 
     * parameters race and year.

     Access the specific year you are looking for in the database array.
     Traverse the records in that year and keep track of the ones that match the specific race we are looking for. 
     If a record matches the specific race criteria, store this record into the ArrayList from step (1).
     Return new ArrayList.
     Suggested getter methods to use:

     getCurrentYear()
     getRace()
     getRecordsForYear()
     */

  public ArrayList<SFRecord> populationStopped(int year, String race) {
    ArrayList<SFRecord> result = new ArrayList<>();

    for (SFYear sfYear : database){
      if(sfYear.getcurrentYear() == year){
        ArrayList<SFRecord> records = sfYear.getRecordsForYear();
        for (SFRecord record : records){
            if(record.getRace().equals(race)){
                result.add(record);
            }
        }
      }
    }

      return result;
  }

    /**
     * This method computes the percentage of records where the person was frisked and the
     * percentage of records where the person was arrested.
     * 
     * @param year we are only interested in the records of year.
     * @return the percent of the population that were frisked and the percent that
     *         were arrested.
     Create two counters, one for the population frisked and the other for the population arrested.
     Access the specific year you are looking for in the database array.
     Traverse the records in that year updating the counters.
     Utilize getFrisked() and getArrested() to check if the person was frisked and/or arrested.
     Compute the percentage once all databases has been traversed.
     percentage = counter / number of records for the year * 100;
     Create a 1D output array that contains two values (in the following order):
     output[0]: the percentage of the population that frisked
     output[1]: the percentage of the population that arrested
     Return the output array.
     */
    public double[] friskedVSArrested ( int year ) {
        // WRITE YOUR CODE HERE
      int total = 0;
      int frisked = 0;
      int arrested = 0;
      for(SFYear sfYear : database){
        if(sfYear.getcurrentYear() == year){
          ArrayList<SFRecord> list = sfYear.getRecordsForYear();
          for(SFRecord record : list){
            total++;
            if(record.getFrisked())  frisked++;
            if(record.getArrested()) arrested++;
          }
        }
      }
      double [] result = new double [2];
      result[0] = (double) frisked / total * 100;
      result[1] = (double) arrested / total * 100;

        return result; // update the return value
    }

    /**
     * This method keeps track of the fraction of Black females, Black males,
     * White females and White males that were stopped for any reason.
     * Drawing out the exact table helps visualize the gender bias.
     * 
     * @param year we are only interested in the records of year.
     * @return a 2D array of percent of number of White and Black females
     *         versus the number of White and Black males.
     
     Access the specific year you are looking for in the database array.
     Create counters to keep track of the number of black people who were stopped, the number of white people who were stopped, as well as the number of black men who were stopped, the number of white men who were stopped, the number of black women who were stopped, and the number of white women who were stopped.
     Utilize the SFRecord getRace() method to identify a person’s race
     If the race equals “B” (Black), increase the Black population count.
     If the race equals “W” (White), increase the White population count.
     Utilize the SFRecord getGender() method to identify a person’s gender
     If the Arraylist contains “F” (Female), increase the Female count, accordingly.
     If the Arraylist contains “M” (Male), increase the Male count, accordingly.
     Create a 2D array of 2 rows and 3 columns containing the information in the table below. For example, to compute the Black Female Percentage use:
     percentage = (number of black females / number of black people) * 0.5 * 100

     Return the 2D resulting array
     */
    public double[][] genderBias ( int year ) {
        // WRITE YOUR CODE HERE
      int total = 0;
      int blackf = 0, blackm = 0, whitef = 0, whitem = 0, female = 0, male = 0, black = 0, white = 0;
      for(SFYear sfYear : database){
        if(sfYear.getcurrentYear() == year){
          ArrayList<SFRecord> list = sfYear.getRecordsForYear();
          for(SFRecord record : list){
            total++;
            if(record.getGender() == "F"){
              female++;
              if(record.getRace() == "B"){
                blackf++;
                  black++;
              }
              if(record.getRace() == "W"){
                whitef++;
                white++;
              }
            }
            if(record.getGender() == "M"){
              male++;
              if(record.getRace() == "B"){
                  black++;
                blackm++;
              }
              if(record.getRace() == "W"){
                whitem++;
                white++;
              }
            }
          }
        }
      }
      double [][] result = new double [2][3];
      result[0][0] = (double) blackf / black * 0.5 * 100;
      result[0][1] = (double) blackm / black * 0.5 * 100;
      result[1][0] = (double) whitef / white * 0.5 * 100;
      result[1][1] = (double) whitem / white * 0.5 * 100;
      result[1][2] = (double) female / total * 100;
      result[0][2] = (double) male / total * 100;

        return result; // update the return value
    }

    /**
     * This method checks to see if there has been increase or decrease 
     * in a certain crime from year 1 to year 2.
     * 
     * Expect year1 to preceed year2 or be equal.
     * 
     * @param crimeDescription
     * @param year1 first year to compare.
     * @param year2 second year to compare.
     * @return 
     */

    public double crimeIncrease ( String crimeDescription, int year1, int year2 ) {
        
        // WRITE YOUR CODE HERE

	return 0.0; // update the return value
    }

    /**
     * This method outputs the NYC borough where the most amount of stops 
     * occurred in a given year. This method will mainly analyze the five 
     * following boroughs in New York City: Brooklyn, Manhattan, Bronx, 
     * Queens, and Staten Island.
     * 
     * @param year we are only interested in the records of year.
     * @return the borough with the greatest number of stops
     */
    public String mostCommonBorough ( int year ) {

        // WRITE YOUR CODE HERE

        return null; // update the return value
    }

}
