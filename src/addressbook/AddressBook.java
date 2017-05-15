package addressbook;

import java.util.ArrayList;

public class AddressBook {
    
    private ArrayList<Person> contacts = new ArrayList<>();
    
    public void addPerson(Person person) {
    
        contacts.add(person);
    }
    
    public Person getPerson(int index) {
    
        return contacts.get(index);
    }
    
    public void deletePerson(Person person) {
    
        contacts.remove(person);
    }
    
    public void deletePerson(int i) {
    
        contacts.remove(i);
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
}
