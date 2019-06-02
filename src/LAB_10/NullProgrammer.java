package LAB_10;

public class NullProgrammer extends Employee{
    public NullProgrammer() {
        this.name = "No employee with that name";
    }
    @Override
    public String getName() {
        return name;
    }
}
