package Assignment;
/***
 * class Routes
 * This class stores all the data from the CsV related to the Routes
 * contains public classes to be accessed by other classes
 * **/
import java.io.*;
import java.util.*;

public class Routes {
    private String airlineCode ;
    private String airlineId;
    private String sourceOfAirport;
    private int airportId;
    private String destinationAirport;
    private int destinationId;
    private String codeShare;
    private String stops;
    private String equipment;

    public Routes(String airlineCode, String airlineId, String sourceOfAirport, int airportId, String destinationAirport,
                  int destinationId, String codeShare, String stops, String equipment){
        this.airlineCode = airlineCode;
        this.airlineId = airlineId;
        this.sourceOfAirport = sourceOfAirport;
        this.airportId = airportId;
        this.destinationAirport = destinationAirport;
        this.destinationId = destinationId;
        this.codeShare = codeShare;
        this.stops = stops;
        this.equipment = equipment; }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public void setSourceOfAirport(String sourceOfAirport) {
        this.sourceOfAirport = sourceOfAirport;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getSourceOfAirport() {
        return sourceOfAirport;
    }

    public int getAirportId() {
        return airportId;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public int getDestinationId() { return destinationId; }

    public String getCodeShare() {
        return codeShare;
    }

    public String getStops() {
        return stops;
    }

    public String getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "airlineCode='" + airlineCode + '\'' +
                ", airlineId='" + airlineId + '\'' +
                ", sourceOfAirport='" + sourceOfAirport + '\'' +
                ", airportId=" + airportId +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", destinationId=" + destinationId +
                ", codeShare='" + codeShare + '\'' +
                ", stops='" + stops + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }

    public static List <Routes> routes = new ArrayList<>();
    public static Map<String, Routes> mapcity = new HashMap<String, Routes>();
    /***
     * take the file that will be passed in the method
     * Read csv file "Routes"
     * Store it in ArrayList  as the key and airline object as the value
     * Catch IOE exception referring to the read file
     * **/
    public static void readreroutes(String  fileName){
        try {
            File file = new File(fileName);
            BufferedReader readness =new BufferedReader(new FileReader(file));

            String line;

            while((line = readness.readLine()) != null){
                String [] attributes = line.split(",");
                Routes route = createRoute(attributes);

                routes.add(route);
                Main.maproutes.put(route.getAirportId(), route);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    /** @param  anydata a string contatnig data of each line of the airline object
     * method that is called in readreroutes method
     * It takes the value find in file, separated by the comma and
     * past it to the different parameters */
    public static Routes createRoute (String[] anydata){
        String airlineCode = "";
        String airlineId= "";
        String sourceOfAirport= "";
        int airportId = 0;
        String destinationAirport= "";
        int destinationId = 0;
        String codeShare= "";
        String stops= "";
        String equipment= "";
        try {
            airlineCode = anydata[0];
            airlineId = (anydata[1]);
            sourceOfAirport = anydata[2];
            airportId = Integer.parseInt((anydata[3]));
            destinationAirport = anydata[4];
            destinationId = Integer.parseInt(anydata[5]);
            // destinationId = anydata[5];
            codeShare = anydata[6];
            stops = (anydata[7]);
            equipment = String.valueOf(anydata.length - 1);
        }
        catch(NumberFormatException ne){
            // ne.printStackTrace();
        }
        return new Routes(airlineCode, airlineId, sourceOfAirport, airportId,destinationAirport,destinationId,codeShare,stops,equipment);
    }

}
