package ExamePratico.Aula7;

public class main2 {
    public static void main(String[] args) {
        ReaderInterface reader=new CoderFilter(new ReverseFIlter(new TermFilter(new TextReader("novo.txt"))));
        while (reader.hasNext()){
            System.out.println(reader.next());

        }
    }
}
