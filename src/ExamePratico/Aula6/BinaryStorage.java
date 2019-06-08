package ExamePratico.Aula6;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BinaryStorage implements ContactsStorageInterface {
    private String filename;
    Path path;

    public BinaryStorage(String filename) {
        this.filename = filename;
        this.path= Paths.get(filename);
    }

    @Override
    public List<Contact> loadContacts() {
        ArrayList<Contact> al=new ArrayList<>();
        ObjectInputStream oi;
        try{
            FileInputStream fi=new FileInputStream(filename);
            oi=new ObjectInputStream(fi);
            al=(ArrayList<Contact>)oi.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return al;

    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        ObjectOutputStream obj;

        try {
            FileOutputStream fo=new FileOutputStream(filename);
            obj=new ObjectOutputStream(fo);
            obj.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
