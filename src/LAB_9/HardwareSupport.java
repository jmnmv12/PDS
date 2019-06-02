package LAB_9;

public class HardwareSupport extends Parser {
    @Override
    public void parse(String problem) {
        if (canHandleProblem(problem, "hardware"))
            System. out.println("Tech support for: " + problem);
        else
            super.parse(problem);
    }
}