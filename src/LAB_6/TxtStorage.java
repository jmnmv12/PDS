package LAB_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.util.ListIterator;

public class TxtStorage implements  ContactsStorageInterface  {
    private String stringPath;
    private Path p1;
    private List<Contact> tempList;


    public TxtStorage(String stringPath) {
        this.stringPath = stringPath;
        this.p1 = Paths.get(this.stringPath);
        this.tempList=new ArrayList<>();
        try{

            Files.createFile(p1);

        }catch (FileAlreadyExistsException ignored){

        }catch (IOException e){
            System.err.println("Error: "+e);
        }


    }

    @Override
    public List<Contact> loadContacts() {
        String temp,name, email,finalSt;
        int num;

        try{
            List contents=Files.readAllLines(p1);
            ListIterator<String> iter=contents.listIterator();
            while(iter.hasNext()){
                temp=iter.next();
                String [] tokens=temp.split("\t+");
                name=tokens[0];
                email=tokens[1];
                num=Integer.parseInt(tokens[2]);

                Contact c1=new Contact(name,num,email);
                tempList.add(c1);
            }
        }catch (IOException e){
            System.err.println("Error: "+ e);
        }
        return tempList;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        Contact temp;
        String name, email,finalSt;
        int num;
        ListIterator<Contact> iter=list.listIterator();
        while (iter.hasNext()){
            temp=iter.next();
            try{
                name=temp.getName();
                email=temp.getEmail();
                num=temp.getNumber();
                finalSt=name+"\t"+email+"\t"+num;
                Files.write(this.p1,(finalSt.toString()+"\n").getBytes(),StandardOpenOption.APPEND);

            }catch (IOException e){
                System.err.println("Error:"+e);
            }

        }
        return true;
    }


}
