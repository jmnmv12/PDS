package LAB_9;

public class NetworkSupport extends Parser {
    @Override
    public void parse(String problem) {
        if (canHandleProblem(problem, "network"))
            System. out.println("Tech support for: " + problem);
        else
            super.parse(problem);
    }
}
