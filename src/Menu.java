import java.util.Scanner;

public class Menu {
    //fields
    private Manager manager;
    //constructors


    public Menu() {
        manager = new Manager();
    }

    //methods
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 8) {
            System.out.println("============================");
            System.out.print("1-Show contacts\n2-Add contact\n3-Delete contact\n4-Edit contact\n5-Serach by name\n6-Search by number\n7-Get contact index by name\n8-Exit\n");
            System.out.println("============================");
            option = scanner.nextInt();
            processOption(option);
        }
    }

    public void processOption(int number) {
        Scanner scanner = new Scanner(System.in);
        switch (number) {
            case 1: //Show contacts
                Contact[] contacts3 = manager.getContacts();
                printContact(contacts3);
                break;
            case 2://Add contact
                manager.addContact(getContactInfo());
                break;
            case 3://Delete contact
                System.out.println("Enter the index to delete: ");
                int index = scanner.nextInt();
                manager.deletContact(index);
                break;
            case 4://Edit contact
                System.out.println("Enter the index to edit: ");
                int index1 = scanner.nextInt();
                manager.editContact(getContactInfo(), index1);
                break;
            case 5://Serach by name
                System.out.println("Enter a name to search:");
                String name = scanner.nextLine();
                manager.searchContactByName(name);
                break;
            case 6://Search by number
                System.out.println("Enter a number to search: ");
                String number1 = scanner.nextLine();
                manager.searchContactByNumber(number1);
                break;
            case 7://Get contact index by name
                System.out.println("Enter a name to get its index: ");
                String name1 = scanner.nextLine();
                manager.indexOfContact(name1);
                break;

        }
    }

    private Contact getContactInfo() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Enter Name:");
        try {
            contact.setName(scanner.nextLine());
            System.out.println("Enter Number:");
            contact.setNumber(scanner.nextLine());
            System.out.println("Enter Email:");
            contact.setEmail(scanner.nextLine());
            System.out.println("Enter Address:");
            contact.setAddress(scanner.nextLine());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    private void printContact(Contact[] contacts) {
        for (int i = 0; i < manager.counter; i++) {
            System.out.println("Name: " + contacts[i].getName() + "  Number: " + contacts[i].getNumber() + "  Email: " + contacts[i].getEmail() + "  Address: " + contacts[i].getAddress());
        }
    }
}


