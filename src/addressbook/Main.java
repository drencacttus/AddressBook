package addressbook;

public class Main {
    
    private static final AddressBook addressBook = new AddressBook();
    
    public static void main(String[] args) {
        
        addressBook.addPerson(new Person("Filan", 
                                        "Fisteku", 
                                        "Prishtine", 
                                        "+342 234 423", 
                                        "234@efrw.df"));
        
        addressBook.addPerson(new Person("Izet", 
                                        "Belegu", 
                                        "Prishtine", 
                                        "+342 234 423", 
                                        "234@efrw.df"));
        
        addressBook.addPerson(new Person("Rexhep", 
                                        "Mala", 
                                        "Prishtine", 
                                        "+342 234 423", 
                                        "234@efrw.df"));
        
        
        MainWindow mainWindow = new MainWindow();
        mainWindow.setAddressBook(addressBook);
        mainWindow.setVisible(true);
    }
}
