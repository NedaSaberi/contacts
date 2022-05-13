import java.util.Scanner;

public class Manager {
    //fields
    Contact[] contacts = new Contact[300];
    int counter;


    //constructors

    public Manager(Contact[] contacts) {
        this.contacts = contacts;
        counter = 0;
    }

    public Manager() {

    }

    //methods

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public boolean addContact(Contact contact) {
        if (counter < 0 || counter > 300) {
            return false;
        } else {

            contacts[counter] = new Contact(contact.getName(), contact.getNumber());
            contacts[counter].setEmail(contact.getEmail());
            contacts[counter].setAddress(contact.getAddress());
            counter++;
            return true;
        }

    }

    public boolean searchContactByName(String name) {
        Contact[] searchContacts = new Contact[counter];
        int cnt = 0;
        for (int i = 0; i < counter; i++) {
            if (contacts[i].getName().contains(name)) {
                searchContacts[cnt] = new Contact(contacts[i].getName(), contacts[i].getNumber());
                // searchContacts[cnt]= new Contact();
                // searchContacts[cnt].setName(contacts[i].getName());
                //  searchContacts[cnt].setNumber(contacts[i].getNumber());
                searchContacts[cnt].setEmail(contacts[i].getEmail());
                searchContacts[cnt].setAddress(contacts[i].getAddress());
                cnt++;
            }
        }
        if (cnt!=0){
            for (int i =0;i<cnt;i++){
                System.out.println("Name: " + searchContacts[i].getName() + "  Number: " + searchContacts[i].getNumber() + "  Email: " + searchContacts[i].getEmail() + "  Address: " + searchContacts[i].getAddress());
            }
        }
        else {
            System.out.println("There is not any name matched by the name you entered.");
        }
        return true;
    }

    public boolean searchContactByNumber(String number) {
        Contact[] searchContacts = new Contact[counter];
        int cnt = 0;
        for (int i = 0; i < counter; i++) {
            if (contacts[i].getNumber().contains(number)) {
                searchContacts[cnt]= new Contact();
              //  searchContacts[cnt]= new Contact(contacts[i].getName(),contacts[i].getNumber());
                searchContacts[cnt].setName(contacts[i].getName());
                searchContacts[cnt].setNumber(contacts[i].getNumber());
                searchContacts[cnt].setEmail(contacts[i].getEmail());
                searchContacts[cnt].setAddress(contacts[i].getAddress());
                cnt++;
            }
        }
        if (cnt!=0) {
            for (int i = 0; i < cnt; i++) {
                System.out.println("Name: " + searchContacts[i].getName() + "  Number: " + searchContacts[i].getNumber() + "  Email: " + searchContacts[i].getEmail() + "  Address: " + searchContacts[i].getAddress());
            }
        }
        else{
            System.out.println("There is not any number matched to your search.");
        }
        return true;
    }

    public boolean deletContact(int index) {
        if (index < 0 || index > counter) {
            System.out.println("The number you entered is out of the range.");
            return false;
        } else {
            for (int i = index; i < counter - 1; i++) {
                contacts[i].setName(contacts[i + 1].getName());
                contacts[i].setNumber(contacts[i + 1].getNumber());
                contacts[i].setEmail(contacts[i + 1].getEmail());
                contacts[i].setAddress(contacts[i + 1].getAddress());
            }
            contacts[counter] = null;
            counter--;
            return true;
        }
    }

    public boolean editContact(Contact contact, int index) {
        if (index < 0 || index > counter) {
            System.out.println("The number you entered is out of the range.");
            return false;
        } else {
            contacts[index].setName(contact.getName());
            contacts[index].setNumber(contact.getNumber());
            contacts[index].setEmail(contact.getEmail());
            contacts[index].setAddress(contact.getAddress());
            return true;
        }
    }

    public void setContact(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter Name:");
        contact.setName(input);
        System.out.println("Enter Number:");
        contact.setNumber(input);
        System.out.println("Enter Email:");
        contact.setEmail(input);
        System.out.println("Enter Address:");
        contact.setAddress(input);
    }

    public boolean indexOfContact(String name) {
        int[] indexes = new int[counter];
        int cnt = 0;
        for (int i = 0; i < counter; i++) {
            if (contacts[i].getName().equals(name)) {
                indexes[cnt] = i;
                cnt++;
            }
        }
        if (cnt != 0) {
            for (int j = 0; j < cnt; j++) {
                System.out.println("Index " + indexes[j]);
            }
        } else {
            System.out.println("There is no index matched by the name.");
        }
        return true;
    }
}
