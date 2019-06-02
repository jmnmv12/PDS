package LAB_9;

public class SoftwareSupport extends Parser {
    @Override
    public void parse(String problem) {
        if (canHandleProblem(problem, "software"))
            System. out.println("Tech support for: " + problem);
        else
            super.parse(problem);
    }
}
