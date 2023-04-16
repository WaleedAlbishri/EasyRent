// Name: Waleed Albishri
// ID: 2037558
// Section: EE
 class Flight {
private String flightNo; // creating
private String departure; // creating
private String destination; // creating
private double fare; // creating

    public Flight(String flightNo, String departure, String destination, double fare) { //cons
        this.flightNo = flightNo;
        this.departure = departure;
        this.destination = destination;
        this.fare = fare;
    }


  // getters and setters
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
// toString
    @Override
    public String toString() {
        return "(New Flight Added)	Flight No: "+flightNo+"	Departure: "+departure+" Destination: "+destination+"  Fare: "+fare;
    }


}
