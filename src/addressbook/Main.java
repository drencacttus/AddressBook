package addressbook;

import java.io.File;

public class Main {
    
    private static AddressBook addressBook;
    private static String objPath = new File("object.dat").getAbsolutePath();
    
    public static void main(String[] args) {
        
        System.out.println(objPath);
        
        addressBook = AddressBook.LoadFromFile(objPath);
 
        if(addressBook == null)
            addressBook = new AddressBook(objPath);
        
        MainWindow mainWindow = new MainWindow();
        mainWindow.setAddressBook(addressBook);
        
        mainWindow.setVisible(true);
    }
}
