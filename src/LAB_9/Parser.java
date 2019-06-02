package LAB_9;

public abstract class Parser {
    private Parser successor=null;

    public void parse(String type){
        if(successor!=null)
            successor.parse(type);
        else
            System.out.println("No tech support for "+type);
    }

    protected  boolean canHandleProblem(String problem,String type){
        return (type==null)||(problem==type);
    }

    public Parser setSuccessor(Parser successor){
        this.successor=successor;
        return this;
    }
}
