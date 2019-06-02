package LAB_9;
import java.util.*;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        List<String> TechSupport = new ArrayList<>();
        TechSupport.add("network");
        TechSupport.add("software");
        TechSupport.add("hardware");
        TechSupport.add("device");
        Parser HardwareSupport =
                new HardwareSupport ().setSuccessor(
                        new SoftwareSupport().setSuccessor(
                                new NetworkSupport()));
        for (String support : TechSupport) {
            HardwareSupport.parse(support);
        }
    }

}
