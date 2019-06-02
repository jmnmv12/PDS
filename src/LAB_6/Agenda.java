package LAB_6;

import java.util.*;

public class Agenda implements ContactsInterface {
    private ContactsStorageInterface defaultStorage;
    private List<Contact> tempList;
    private Map<String,Contact> table;

    public Agenda(ContactsStorageInterface defaultStorage) {
        this.defaultStorage = defaultStorage;
        this.tempList=new ArrayList<>();
        this.table=new TreeMap<>();
    }

    @Override
    public boolean add(Contact contact) {
        String name=contact.getName();
        table.put(name,contact);
        return true;



    }

    @Override
    public boolean exist(Contact contact) {
        String name=contact.getName();
        if(table.get(name)==null)
            return false;
        else
            return true;
    }

    @Override
    public boolean remove(Contact contact) {
        String name=contact.getName();
        if(table.remove(name)==null)
            return false;
        else
            return true;
    }

    @Override
    public Contact getByName(String name) {
            return table.get(name);

    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        String name, email, num;
        tempList = store.loadContacts();
        ListIterator<Contact> iter = tempList.listIterator();
        while (iter.hasNext()) {
            Contact temp = iter.next();
            name = temp.getName();
            table.put(name, temp);
        }
    }

    @Override
    public void saveAndClose() {
        List<Contact> list=new ArrayList<>(table.values());
        defaultStorage.saveContacts(list);
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        List<Contact> list=new ArrayList<>(table.values());
        store.saveContacts(list);
    }
}
