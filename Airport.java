// Name: Waleed Albishri
// ID: 2037558
// Section: EE
 class Airport {
 private String threeDigitCode; // creating
 private String city; // creating
 private String name; // creating

    public Airport(String threeDigitCode, String city, String name) { //cons
        this.threeDigitCode = threeDigitCode;
        this.city = city;
        this.name = name;
    }
 
 
   // getters and setters  
    public String getThreeDigitCode() {
        return threeDigitCode;
    }

    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  // toString
    @Override
    public String toString() {
        return "(New Airport Added)	Airport Code: "+threeDigitCode+"	City: "+city+"	Name: "+name;
    }
 
 
}
