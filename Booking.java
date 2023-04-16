import java.util.Date;
// Name: Waleed Albishri
// ID: 2037558
// Section: EE
class Booking {

    private long bookingNo; //creating
    private Flight flight; //creating
    private Airline airline; //creating
    private Airport airport; //creating
    Date flightDate; //creating
    private String name; //creating
    private Date dob; //creating
    boolean isBusinessClass; //creating
    private int baggageWeight; //creating

    public Booking(long bookingNo, Flight flight, Airline airline, Airport airport, Date flightDate, String name, Date dob, boolean isBusinessClass, int baggageWeight) { //cons
        this.bookingNo = bookingNo;
        this.flight = flight;
        this.airline = airline;
        this.airport = airport;
        this.flightDate = flightDate;
        this.name = name;
        this.dob = dob;
        this.isBusinessClass = isBusinessClass;
        this.baggageWeight = baggageWeight;
    }

    // setters and getters
    public long getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean getIsBusinessClass() {
        return isBusinessClass;
    }

    public void setIsBusinessClass(boolean isBusinessClass) {
        this.isBusinessClass = isBusinessClass;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public double CalculateFare() {
        int age = (getFlightDate().getYear() + 1900) - (getDob().getYear() + 1900);
        double fare = flight.getFare(); // get fare
        int w;
        int overload;
        if (age <= 2) {
            w = (int) (fare * (10.0f / 100.0f));
            fare = w;
        } else if (age <= 12) {
            w = (int)(fare * (70.0f / 100.0f));
            fare = w + 1;
        }
        if (isBusinessClass == true) {
            fare = fare * 1.4;
            if (baggageWeight - 50 > 0) {
                overload = (baggageWeight - 50) * 30;
                fare = fare + overload;
            }
        } else {
            if (baggageWeight - 30 > 0) {
                overload = (baggageWeight - 30) * 30;
                fare = fare + overload;
            }
        }
        return Math.round(fare); // return

    }
}
