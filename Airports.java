package Assignment;
/***
 * class Airports
 * This class stores all the data from the CsV related to the Routes
 * contains public classes to be accessed by other classes
 * **/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Double.*;

public class Airports {

    private int airportID ;
    private String name;
    private String city;
    private String country;
    private String IATA;
    private String ICAO;
    private double latitude;
    private double longitude;
    private double altitude;
    private double timezone;
    private String DST;
    private String databaseTimeZone;
    private String typeOfAirport;
    private String sourceOfData;

    public Airports(int airportID, String name, String city, String country, String IATA, String ICAO,
                    double latitude, double longitude, double altitude, double timezone,
                    String DST, String databaseTimeZone, String typeOfAirport, String sourceOfData){

        this.airportID = airportID;
        this.name = name;
        this.city = city;
        this.country= country;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.databaseTimeZone= databaseTimeZone;
        this.typeOfAirport = typeOfAirport;
        this.sourceOfData = sourceOfData;
    }

    public Airports(){}

    public static void main() {
    }

    public int getAirportID() {
        return airportID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIATA() {
        return IATA;
    }

    public String getICAO() {
        return ICAO;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getTimezone() {
        return timezone;
    }

    public String getDST() {
        return DST;
    }

    public String getDatabaseTimeZone() {
        return databaseTimeZone;
    }

    public String getTypeOfAirport() {
        return typeOfAirport;
    }

    public String getSourceOfData() {
        return sourceOfData;
    }

    @Override
    public String toString() {
        return "Airports {" +
                "airportID=" + airportID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", IATA='" + IATA + '\'' +
                ", ICAO='" + ICAO + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", timezone=" + timezone +
                ", DST='" + DST + '\'' +
                ", databaseTimeZone='" + databaseTimeZone + '\'' +
                ", typeOfAirport='" + typeOfAirport + '\'' +
                ", sourceOfData='" + sourceOfData + '\'' +
                '}';
    }
    // public static ArrayList<String[]> userSearch = new ArrayList<String[]>();
    /**
     * @param city1 is the source city
     * @param city2 is the destination city
     * @list mapairport stores the airport object that have the city corresponding to the source and the destination
     * @return The arraylist of the airport object
     * This method takes two cities, the source citya nd the destination
     * It check in the airport object if the city name corresponds to the one of the object
     * iff it is true, it takes the object and add it to an optional array list
     * which will be used  to get the ids of the tow destinations and paste it the
     * other class to find the routes**/
    public static ArrayList<Airports> findAirport(String city1, String city2){
        ArrayList<Airports> mapairport = new ArrayList<>();
        for (Airports airport: Main.mapAirports.values()) {
            if ( airport.getCity().equals(city1)) {
                mapairport.add(airport);
            }
            if (airport.getCity().equals(city2)){
                mapairport.add(airport);
            }

        } System.out.println(mapairport);
        return mapairport;

    }

//    public static void readuserentry(String fileName){
//            try {
//                File file = new File(fileName);
//                BufferedReader readness =new BufferedReader(new FileReader(file));
//
//                String line;
//
//                while((line = readness.readLine()) != null){
//                    String [] entry = line.split(",");
//                    userSearch.add(entry);
//                }
//            }catch (IOException ioe){
//                ioe.printStackTrace();
//            }
//        }
    /***
     * @param fileName is where we will past the URL of the file to read
     * @mapAirports is the Hashmap of the Airport file
     * take the file that will be passed in the method
     * Read csv file "Airports"
     * Store it in Hashmap with the AirportId as the key and airport object as the value
     * Catch IOE exception referring to the read file
     * **/

    public static void readairports(String  fileName){
        try {
            File file = new File(fileName);
            BufferedReader readness =new BufferedReader(new FileReader(file));

            String line;

            while((line = readness.readLine()) != null){
                String [] attributes = line.split(",");
                Airports airport = createAirport(attributes);
                Main.mapAirports.put(airport.getAirportID(), airport);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    /** @param  airdata is a string contatnig data of each line of the airline object
     * method that is called in readairports method
     * It takes the value find in file, separated by the comma and
     * past it to the different parameters
     * @try catch the number exception*/

    public static Airports createAirport(String[] airdata) {
        int airportID = 0;
        String name = "";
        String city = "";
        String country = "";
        String DST = "";
        String IATA = "";
        String ICAO = "";
        String databaseTimeZone = "";
        String typeOfAirport = "";
        String sourceOfData = "";
        double latitude = 0.0;
        double longitude = 0.0;
        double altitude = 0.0;
        double timezone = 0.0;

        try {

            airportID = Integer.parseInt(airdata[0]);
            name = airdata[1];
            city = airdata[2];
            country = airdata[3];
            IATA = airdata[4];
            ICAO = airdata[5];
            latitude = parseDouble(airdata[6]);
            longitude = parseDouble(airdata[7]);
            altitude = parseDouble(airdata[8]);
            timezone = parseDouble(airdata[9]);
            DST = airdata[10];
            databaseTimeZone = airdata[11];
            typeOfAirport = airdata[12];
            sourceOfData = airdata[13];
        } catch (NumberFormatException ne) {
            // ne.printStackTrace()
            ;}
        return new Airports(airportID, name, city, country, IATA, ICAO, latitude, longitude, altitude, timezone, DST, databaseTimeZone, typeOfAirport, sourceOfData);
    }

}


