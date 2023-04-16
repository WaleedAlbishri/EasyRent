import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
// Name: Waleed Albishri
// ID: 2037558
// Section: EE

public class BookingDemo {

    static int airlineindex = 0;
    static int airportindex = 0;
    static int flightindex = 0;
    static int bookingindex = 0;

    public static void main(String[] args) throws FileNotFoundException {

        // creating and finding files objects
        File input1 = new File("inputBookings.txt");
        File input2 = new File("inputDB.txt");
        if (!(input1.exists() && input2.exists())) { //check if the file exists
            System.out.println("One or more of the files does not exist"); // print this statement if one or more of the files does not exist
            System.exit(1); // exit
        }
        Scanner read1 = new Scanner(input1);
        Scanner read2 = new Scanner(input2);

        // creating output files
        File output1 = new File("printBookings.txt");
        File output2 = new File("printLog.txt");
        PrintWriter write1 = new PrintWriter(output1);
        PrintWriter write2 = new PrintWriter(output2);

        Airline[] airlines = new Airline[read2.nextInt()]; // size of airlines array
        Airport[] airports = new Airport[read2.nextInt()]; //size of airports array
        Flight[] flights = new Flight[read2.nextInt()]; // size of flights array

        String command; // creating command variable
        while (true) { // loop for the commands
            command = read2.next();
            if (command.equals("ADD_Airline")) {
                airlines[airlineindex] = getAirline(read2); // send it to the method
                airlineindex++; // increase the index variable

            } else if (command.equals("ADD_Airport")) {
                airports[airportindex] = getAirport(read2); // send it to the method
                airportindex++; // increase the index variable
            } else if (command.equals("ADD_Flight")) {
                flights[flightindex] = getFlight(read2); // send it to the method
                flightindex++; // increase the index variable
            } else if (command.equals("Quit")) {
                break; //break the loop (exit)
            }
        }
        PrintLog(airlines, flights, airports, write2); // send them to PrintLong method

        Booking[] bookings = new Booking[read1.nextInt()]; // size of bookings array
        String bookingcommand; // creating command variable
        while (true) { // loop for the command
            bookingcommand = read1.next();
            if (bookingcommand.equals("NewBooking")) {
                bookings[bookingindex] = GenerateBooking(read1, flights, airlines, airports); // send it to the method
                bookingindex++; // increase the index variable
            } else {
                break; // break the loop (exit)
            }
        }
        PrintBooking(bookings, write1); // send them to PrintBooking method
        write1.close(); // close the file
        write2.close(); // close the file
    }
//////////////////////////////////////////////////////////

    private static Airline getAirline(Scanner read2) {
        String twoDigitCode = read2.next(); // read from the file
        String name = read2.next(); // read from the file
        String originCountry = read2.next(); // read from the file
        String website = read2.next(); // read from the file
        return new Airline(twoDigitCode, name, originCountry, website); // send them to the Airline class then return and store it in the airlines array
    }
    //////////////////////////////////////////////////////////

    private static Airport getAirport(Scanner read2) {
        String threeDigitCode = read2.next(); // read from the file
        String city = read2.next(); // read from the file
        String name = read2.next(); // read from the file
        return new Airport(threeDigitCode, city, name); // send them to the Airport class then return and store it in the airports array

    }
//////////////////////////////////////////////////////////

    private static Flight getFlight(Scanner read2) {
        String flightNo = read2.next(); // read from the file
        String departure = read2.next(); // read from the file
        String destination = read2.next(); // read from the file
        double fare = read2.nextDouble(); // read from the file
        return new Flight(flightNo, departure, destination, fare); // send them to the Flight class then return and store it in the flights array
    }

    //////////////////////////////////////////////////////////
    private static Booking GenerateBooking(Scanner read1, Flight[] flights, Airline[] airlines, Airport[] airports) {
        // read from the file
        long bookingNo = System.currentTimeMillis();
        String flightnum = read1.next();
        int indexflightnum = searchflightnumber(flightnum, flights);
        String twoletters = read1.next();
        int indextwoletters = searchtwoletters(twoletters, airlines);
        String threeletters = read1.next();
        int indexthreeletters = searchthreeletters(threeletters, airports);
        Date flightDate = new Date();
        flightDate.setYear(read1.nextInt() - 1900);
        flightDate.setMonth(read1.nextInt() - 1);
        flightDate.setDate(read1.nextInt());
        String name = read1.next();
        Date dateofbirth = new Date();
        dateofbirth.setYear(read1.nextInt() - 1900);
        dateofbirth.setMonth(read1.nextInt() - 1);
        dateofbirth.setDate(read1.nextInt());
        boolean isBusinessClass = read1.nextBoolean();
        int baggageWeight = read1.nextInt();
        return new Booking(bookingNo, flights[indexflightnum], airlines[indextwoletters], airports[indexthreeletters], flightDate, name, dateofbirth, isBusinessClass, baggageWeight); // send them to Booking class

    }
    ///////////////////////////////////////////////

    public static int searchflightnumber(String flightnum, Flight[] flights) { //search method to find the right flight number
        for (int i = 0; i < flights.length; i++) {
            if (flightnum.equals(flights[i].getFlightNo())) {
                return i;
            }
        }
        return -1;
    }
    //////////////////////////////////////////////

    public static int searchtwoletters(String twoletters, Airline[] airlines) { //search method to find the right two letters
        for (int i = 0; i < airlines.length; i++) {
            if (twoletters.equals(airlines[i].getTwoDigitCode())) {
                return i;
            }
        }
        return -1;
    }
    ///////////////////////////////////////////////

    public static int searchthreeletters(String threeletters, Airport[] airports) {  //search method to find the right three letters
        for (int i = 0; i < airports.length; i++) {
            if (threeletters.equals(airports[i].getThreeDigitCode())) {
                return i;
            }
        }
        return -1;
    }
    ////////////////////////////////////////

    public static void PrintBooking(Booking[] tempBooking, PrintWriter fWrite) {
        // print to the first file (printBookings.txt)
        fWrite.println("--------------- Welcome to Air Ticket Reservation System ---------------");
        fWrite.println("");
        fWrite.println("");
        for (int i = 0; i < tempBooking.length; i++) { // loop to print Bookings

            fWrite.println("Booking No. " + tempBooking[i].getBookingNo());
            fWrite.println("");
            fWrite.println("Passenger Details	Passenger Name: " + tempBooking[i].getName() + "		Date of Birth: " + (tempBooking[i].getDob().getYear() + 1900) + "-" + tempBooking[i].getDob().getDate() + "-" + (tempBooking[i].getDob().getMonth() + 1));
            fWrite.println("");
            fWrite.println("Flight Details	Flight Code: " + tempBooking[i].getAirline().getTwoDigitCode() + "-" + tempBooking[i].getFlight().getFlightNo() + "			" + (tempBooking[i].getFlightDate().getYear() + 1900) + "-" + tempBooking[i].getFlightDate().getDate() + "-" + (tempBooking[i].getFlightDate().getMonth() + 1));
            fWrite.println("                Depature: " + tempBooking[i].getFlight().getDeparture() + "                   Destination: " + tempBooking[i].getFlight().getDestination());
            fWrite.println("");
            fWrite.println("Airport Details	Airport Name: " + tempBooking[i].getAirport().getName() + " (" + tempBooking[i].getAirport().getThreeDigitCode() + "), " + tempBooking[i].getAirport().getCity());
            fWrite.println("");
            fWrite.println("Airline Details	Name: " + tempBooking[i].getAirline().getName() + " based in " + tempBooking[i].getAirline().getWebsite());
            fWrite.println("");
            fWrite.println("Fare Details	Regular Fare: SAR " + tempBooking[i].getFlight().getFare());
            fWrite.println("		Total Fare: SAR " + tempBooking[i].CalculateFare());

            fWrite.println("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");
        }

    }
    /////////////////////////////////////////

    public static void PrintLog(Airline[] airlines, Flight[] flights, Airport[] airports, PrintWriter fWrite) {
        // print to the second file (printLog.txt)
        fWrite.println("--------------- Air Ticket Reservation System Log ---------------");
        fWrite.println("");
        for (int i = 0; i < airlines.length; i++) { // loop to print airlines
            fWrite.println("");
            fWrite.println(airlines[i].toString());
            fWrite.println("-------------------");
        }
        for (int i = 0; i < flights.length; i++) { // loop to print flights
            fWrite.println("");
            fWrite.println(flights[i].toString());
            fWrite.println("-------------------");
        }
        for (int i = 0; i < airports.length; i++) { // loop to print airports
            fWrite.println("");
            fWrite.println(airports[i].toString());
            fWrite.println("-------------------");

        }
        fWrite.close();
    }

    //////////////////////////////////////
    public static void NumOfFlightsperAirport(Airport[] allairports, Booking[] alltickets, PrintWriter fWrite) {

    }
//////////////////////////////////////////
}
