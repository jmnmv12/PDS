package LAB_6;
import java.util.ArrayList;
import java.util.List;

public class Main6_2 {
    public static void main(String[] args) {
        Contact c1=new Contact("Joao",913654912,"j@gmail.com");
        Contact c2=new Contact("Antonio",913654912,"j@gmail.com");
        List <Contact> agenda=new ArrayList<>();
        TxtStorage txtSt=new TxtStorage("../../../teste.txt");
        ArrayList<Contact> list=new ArrayList<>();
        list.add(c1);
        list.add(c2);
        txtSt.saveContacts(list);
        agenda=txtSt.loadContacts();
        for (Contact c3:agenda) {
            System.out.println(c3);

        }



    }

}
