package ExamePratico.Aula6;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextStorage implements ContactsStorageInterface {
    private String filename;
    Path path;

    public TextStorage(String filename) {
        this.filename = filename;
        path= Paths.get(filename);

        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException ignored){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contact> loadContacts() {
        List<String> tempList=new ArrayList<>();
        List<Contact> contactList=new ArrayList<>();
        try {
            tempList=Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator it=tempList.listIterator();
        while (it.hasNext()){
            String [] tokens=it.next().toString().split("\t");
            Contact temp=new Contact(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            contactList.add(temp);
        }
        return contactList;

    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        Iterator it=list.iterator();
        while (it.hasNext()){
            Contact temp=(Contact) it.next();
            String to_save=temp.getName()+"\t"+temp.getNumber()+"\t"+temp.getCompany()+"\n";
            try {
                Files.write(path,to_save.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return true;
    }


}
