package LAB_6;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BinaryStorage implements ContactsStorageInterface {
    private String stringPath;
    private List<Contact> tempList;

    public BinaryStorage(String stringPath) {
        this.stringPath = stringPath;
        this.tempList=new ArrayList<>();
        /*try{

            Files.createFile(p1);

        }catch (FileAlreadyExistsException ignored){

        }catch (IOException e){
            System.err.println("Error: "+e);
        }*/
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        ObjectOutputStream os=null;



        try{
            FileOutputStream fileOS= new FileOutputStream(stringPath);
            os= new ObjectOutputStream(fileOS);
            os.writeObject(list);

        }catch (IOException e){
            System.err.println("Error:"+e);
        }



        return true;
    }

    @Override
    public List<Contact> loadContacts() {

        ObjectInputStream is=null;

        try{
            FileInputStream fileIS= new FileInputStream(stringPath);
            is= new ObjectInputStream(fileIS);
            tempList=(List<Contact>)is.readObject();

        }catch (IOException e){
            System.err.println("Error:"+e);
        }catch (ClassNotFoundException e){
            System.err.println(e);
        }


        return tempList;
    }
}
