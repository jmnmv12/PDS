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
        return false;
    }

    @Override
    public boolean exist(Contact contact) {
        return false;
    }

    @Override
    public boolean remove(Contact contact) {
        return false;
    }

    @Override
    public Contact getByName(String name) {
        return null;
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

    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {

    }
}
