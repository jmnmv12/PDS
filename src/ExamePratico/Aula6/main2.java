package ExamePratico.Aula6;


import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) {
        ArrayList<Contact> ola=new ArrayList<>();
        BinaryStorage txSt=new BinaryStorage("save.txt");
        Agenda phone=new Agenda(txSt);
        phone.add(new Contact("Joaquim",91123,"UA"));
        phone.add(new Contact("Alberto",9123,"UA"));
        phone.add(new Contact("Joao",9145,"UA"));
        phone.add(new Contact("Maria",91222,"UA"));
        Contact ct=new Contact("Mario",91222,"UA");
        Contact ca=new Contact("Maria",91222,"UA");
        phone.remove(ca);
        phone.saveAndClose();
        System.out.println(phone.exist(ct));
        System.out.println(phone.getByName("Joaquim"));
        phone.openAndLoad(txSt);
    }
}
