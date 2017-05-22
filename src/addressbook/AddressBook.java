package addressbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AddressBook implements Serializable {
    
    private ArrayList<Person> contacts = new ArrayList<>();
    private String objectPath;
    
    public static AddressBook LoadFromFile(String filePath) {
    
        File objectFile = new File(filePath);
        
        try{
            FileInputStream fileInputStream = new FileInputStream(objectFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        
            return (AddressBook)objectInputStream.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
        
            return null;
        }
    }
    
    public AddressBook(String objectPath) {
    
        this.objectPath = objectPath;
    }
    
    public void addPerson(Person person) {
    
        contacts.add(person);
        saveObject();
    }
    
    public Person getPerson(int index) {
    
        return contacts.get(index);
    }
    
    public void deletePerson(Person person) {
    
        contacts.remove(person);
        saveObject();
    }
    
    public void deletePerson(int i) {
    
        contacts.remove(i);
        saveObject();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }
    
    public ArrayList<Person> search(String query) {
    
        ArrayList<Person> results = new ArrayList<>();
        
        String preparedQuery = query.toLowerCase().trim();
        
        for(Person currentPerson : contacts) {
        
            String fullName = currentPerson.getFirstName() + " " +
                              currentPerson.getLastName();
            
            if(fullName.toLowerCase().contains(preparedQuery)) {
            
                results.add(currentPerson);
            }
        }
        
        return results;
    }
    
    public void saveObject() {
    
        saveObject(objectPath);
    }
    
    public void saveObject(String filePath) {
    
        File objectFile = new File(filePath);
        
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(objectFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(this);
        }
        catch(IOException ex) {
        
        }
    }
}
