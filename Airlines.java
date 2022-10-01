package Assignment;
/***
 * class Airlines
 * This class stores all the data from the CsV related to the Airlines
 * contains public classes to be accessed by other classes
 * **/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Airlines {

    private int airlineID ;
    private String airlineName;
    private String allias;
    private String IATA;
    private String ICAO;
    private String callSign;
    private String active;


    public Airlines(int airlineID, String airlineName, String allias, String IATA, String ICAO,String callSign, String active){
        this.airlineID = airlineID;
        this.airlineName = airlineName;
        this.allias = allias;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.callSign = callSign;
        this.active = active;
    }
    public int getAirlineID() {
        return airlineID;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public String getAllias() {
        return allias;
    }
    public String getIATA() {
        return IATA;
    }
    public String getICAO() {
        return ICAO;
    }
    public String getCallSign() {
        return callSign;
    }
    public String getActive() {
        return active;
    }


    @Override
    public String toString() {
        return "Airlines{" +
                "airlineID=" + airlineID +
                ", airlineName='" + airlineName + '\'' +
                ", allias='" + allias + '\'' +
                ", IATA='" + IATA + '\'' +
                ", ICAO='" + ICAO + '\'' +
                ", callSign='" + callSign + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

    /***
     * take the file that will be passed in the method
     * Read csv file "Airlines"
     * Store it in Hashmap with the AirlineId as the key and airline object as the value
     * Catch IOE exception referring to the read file
     * **/
    public static  void readairLines(String  fileName)  {
        try {
            File file = new File(fileName);
            BufferedReader readness = new BufferedReader(new FileReader(file));
            String line;

            while ((line = readness.readLine()) != null) {
                String[] attributes = line.split(",");
                Airlines airline = createAirline(attributes);
                Main.mapAirlines.put(airline.getAirlineID(), airline);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace(); }

    }
    /** @param  airdata is a string contatnig data of each line of the airline object
     * method that is called in readairLines method
     * It takes the value find in file, separated by the comma and
     * past it to the different parameters */
    public static Airlines createAirline(String[] airdata){

        int airlineID = 0;
        String airlineName = "";
        String allias = "";
        String IATA = "";
        String ICAO = "";
        String callSign = "";
        String active = "";

        try {
            airlineID = Integer.parseInt(airdata[0]);
            airlineName = airdata[1];
            allias = airdata[2];
            IATA = airdata[3];
            ICAO = airdata[4];
            callSign = airdata[5];
            active = airdata[6];

        } catch (NumberFormatException e) {
            e.printStackTrace(); }

        return new Airlines(airlineID, airlineName, allias, IATA, ICAO, callSign, active);
    }

}


