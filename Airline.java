// Name: Waleed Albishri
// ID: 2037558
// Section: EE
 public class Airline {

    private String twoDigitCode; //creating
    private String name; //creating
    private String originCountry; //creating
    private String website; //creating

    public Airline(String twoDigitCode, String name, String originCountry, String website) { //cons
        this.twoDigitCode = twoDigitCode;
        this.name = name;
        this.originCountry = originCountry;
        this.website = website;
    }

    
    
    //getters and setters
    public String getTwoDigitCode() {
        return twoDigitCode;
    }

    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
     // toString
    @Override
     public String toString() {
        return "(New Airline Added)	Airline No.: "+twoDigitCode+" Airline: "+name+" Hub: "+originCountry+" URL: "+website;
    }
    
}
