package ExamePratico.Aula9;

public class ControlRemote {
    //Invokes the commands
    private Command command;

    public void setCommand(Command command){
        this.command=command;
    }
    public void pressButton(String elem){
        this.command.execute(elem);
    }
}
