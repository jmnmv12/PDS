package LAB_5;

public class PersonBuilder {
    private String lastName; //required
    private String firstName; //required
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAddress;
    private String city; //required
    private String state;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomeOwner;

    public PersonBuilder() {

    }

    public PersonBuilder newLastName(String lastName){
        this.lastName=lastName;
        return this;
    }

    public PersonBuilder newFirstName(String firstName){
        this.firstName=firstName;
        return this;
    }

    public PersonBuilder middleName(String middleName){
        this.middleName=middleName;
        return this;
    }

    public PersonBuilder salutation(String salutation){
        this.lastName=salutation;
        return this;
    }

    public PersonBuilder suffix(String suffix){
        this.suffix=suffix;
        return this;
    }

    public PersonBuilder streetAddress(String streetAddress){
        this.streetAddress=streetAddress;
        return this;
    }

    public PersonBuilder city(String city){
        this.city=city;
        return this;
    }

    public PersonBuilder state(String state){
        this.state=state;
        return this;
    }


    public PersonBuilder isFemale(boolean isFemale){
        this.isFemale=isFemale;
        return this;
    }

    public PersonBuilder isEmployed(boolean isEmployed){
        this.isEmployed=isEmployed;
        return this;
    }

    public PersonBuilder isHomeOwner(boolean isHomeOwner){
        this.isHomeOwner=isHomeOwner;
        return this;
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salutation='" + salutation + '\'' +
                ", suffix='" + suffix + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomeOwner=" + isHomeOwner +
                '}';
    }
}
