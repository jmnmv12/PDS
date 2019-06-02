package ExamePratico.Aula5;

public class Person {
    private final String lastName;
    private final String firstName;
    private  String middleName;
    private  String salutation;
    private  String suffix;
    private  String streetAddress;
    private  String city;
    private  String state;
    private  boolean isFemale;
    private  boolean isEmployed;
    private  boolean isHomewOwner;

    public Person(
            final String newLastName,
            final String newFirstName

            ) {
        this.lastName = newLastName;
        this.firstName = newFirstName;

    }

    public Person middleName(String middle){
        this.middleName=middle;
        return this;
    }
}