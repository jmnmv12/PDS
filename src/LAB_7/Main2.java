package LAB_7;

public class Main2 {
    public static void main(String[] args) {
        Reader rd=new TextReader("../novo.txt");
        Reader rdA=new ReverseFilter(new CoderFilter(rd));

        while (rdA.hasNext()){
            System.out.println(rdA.next());
        }
    }
}
