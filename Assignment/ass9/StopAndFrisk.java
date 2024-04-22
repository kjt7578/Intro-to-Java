import java.util.ArrayList;
public class StopAndFrisk {


    private ArrayList<SFYear> database; 

    public StopAndFrisk () {
        database = new ArrayList<>();
    }

    public ArrayList<SFYear> getDatabase() {
        return database;
    }

    public void readFile ( String csvFile ) {

        StdIn.setFile(csvFile);
        StdIn.readLine();
        // WRITE YOUR CODE HERE
      while (!StdIn.isEmpty()) {
          String[] recordEntries = StdIn.readLine().split(",");

          int year = Integer.parseInt(recordEntries[0]);
          String description = recordEntries[2];
          String gender = recordEntries[52];
          boolean arrested = recordEntries[13].equals("Y");
          boolean frisked = recordEntries[16].equals("Y");
          String race = recordEntries[66];
          String location = recordEntries[71];

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

    public double[] friskedVSArrested ( int year ) {
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

        return result;
    }

    public double[][] genderBias ( int year ) {
      int blackf = 0, blackm = 0, whitef = 0, whitem = 0, black = 0, white = 0;
      for(SFYear sfYear : database){
        if(sfYear.getcurrentYear() == year){
          ArrayList<SFRecord> list = sfYear.getRecordsForYear();
          for(SFRecord record : list){
            if(record.getRace().equals("B")){
              black++;
              if(record.getGender().equals("F")){
                blackf++;
              }
              if(record.getGender().equals("M")){
                blackm++;
              }
            }
            if(record.getRace().equals("W")){
              white++;
              if(record.getGender().equals("F")){
                whitef++;
              }
              if(record.getGender().equals("M")){
                whitem++;
              }
            }
          }
        }
      }
      double[][] result = new double[2][3];
      result[0][0] = ((double) blackf / black * 0.5 * 100);
      result[1][0] = ((double) blackm / black * 0.5 * 100);
      result[0][1] = ((double) whitef / white * 0.5 * 100);
      result[1][1] = ((double) whitem / white * 0.5 * 100);
      result[0][2] = result[0][0] + result[0][1];
      result[1][2] = result[1][0] + result[1][1];
  
      return result;
    }

    public double crimeIncrease ( String crimeDescription, int year1, int year2 ) {
      double result = 0;
      int ct1 = 0, total1 = 0;
      int ct2 = 0, total2 = 0;
        for(SFYear sfYear : database){
          if(sfYear.getcurrentYear() == year1){
            for(SFRecord record : sfYear.getRecordsForYear()){
              if(record.getDescription().indexOf(crimeDescription) != -1){
                ct1++;
              }
              total1++;
            }
          }
          else if(sfYear.getcurrentYear() == year2){
            for(SFRecord record : sfYear.getRecordsForYear()){
              if(record.getDescription().indexOf(crimeDescription) != -1){
                ct2++;
              }
              total2++;
            }
          }
        }

        double y1 = (double)ct1 / total1 * 100;
        double y2 = (double)ct2 / total2 * 100;
        result = y1 - y2;
      
        if (year1 > year2){
          result = result * -1;
        }
        else if (year1 == year2){
          result = 0;
        }
	return result;
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
      int Brooklyn = 0, Manhattan = 0, Bronx = 0, Queens = 0, Staten_Island = 0;
      for(SFYear sfYear : database){
        if(sfYear.getcurrentYear() == year){
          for(SFRecord record : sfYear.getRecordsForYear()){
            String location = record.getLocation();
            if(location.contains("BROOKLYN")){Brooklyn++;}
            else if(location.contains("MANHATTAN")){Manhattan++;}
            else if(location.contains("BRONX")){Bronx++;}
            else if(location.contains("QUEENS")){Queens++;}
            else if(location.contains("STATEN ISLAND")){Staten_Island++;}
          }
        }
      }

      int maxCount = Math.max(Brooklyn, Math.max(Manhattan, Math.max(Bronx, Math.max(Queens, Staten_Island))));
      if (maxCount == Brooklyn){return "Brooklyn";}
      else if (maxCount == Manhattan){return "Manhattan";}
      else if (maxCount == Bronx){return "Bronx";}
      else if (maxCount == Queens){return "Queens";}
      else if (maxCount == Staten_Island){return "Staten_Island";}

        return null;
    }

}
