package Assignment;
/***
 * Main methods that text every code written i different class.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;


public class Main {

    //public static Map<Integer, ArrayList<Routes>> maproutes = new HashMap<>();
    public static Map<Integer, Routes> maproutes = new HashMap<>();
    public static Map<Integer, Airports> mapAirports = new HashMap<>();
    public static Map<Integer, Airlines> mapAirlines = new HashMap<>();

    /**Different call of the call method and past the URL. */
    public static void main(String[] args) {
        int key = 0;
        int dest = 0;
        int airlineString = 0;
        
        Airports.readairports("src/Assignment/airports.csv");
        Routes.readreroutes("src/Assignment/routes.csv");
        Airlines.readairLines("src/Assignment/airlines.csv");
        //Airports.readuserentry("Assignment (1)/entryUser");
/***
 * key represents the AirportId of the source of thec city
 * dest represents the AirportId of the destination airport
 * We past the Airports to call all method that all in the airports class; same for the rest of the file
 */
        ArrayList<Airports> airports = Airports.findAirport("Accra", "Addis Ababa");
        key = airports.get(0).getAirportID();
        dest = airports.get(1).getAirportID();
/***
 * An  Airport Id can corresponds to many ids, so this loops to all those
 * possibles routes and check the ones that have the same destination and source of airport as t
 * the previous parameter, take the object route.
 * And it pastes the route airline Id to the hashmap mapAirlines to get the indication the flight to take.
 * It writes all the result in the a Flight.text.
 */
        try {
            FileWriter myWrite = new FileWriter("Flights.txt");

            for (Routes route : Routes.routes) {
                if (route.getAirportId() == key && route.getDestinationId() == dest) {
                    myWrite.write("\nThis is your direct route : " + route);
                    myWrite.write("\n---------------------------------------------------------------------------------------------------------------------- ");
                    airlineString = Integer.parseInt(route.getAirlineId());
                    myWrite.write("\nThe flight From : "+mapAirports.get(key).getCity()+" To: "+mapAirports.get(dest).getCity());
                    myWrite.write("\nThe Flight is : " + mapAirlines.get(airlineString) + " , and it makes :" + route.getStops() + " stop(s)");
                }
            }myWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




