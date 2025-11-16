import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ContactFeat contact = new ContactFeat();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== CONTACTS ======");
            System.out.println("1. Add contact");
            System.out.println("2. Update contact");
            System.out.println("3. Remove contact");
            System.out.println("4. Show all contacts");
            System.out.println("5. Exit app");

            System.out.println();

            System.out.print("Enter choice (1-5): ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter contact number: ");
                    long number = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    contact.addContact(number, name);
                    break;
                
                case 2:
                    System.out.println("Enter the contact number for which you want to update details: ");
                    number = sc.nextLong();
                    sc.nextLine();
                    Contact contactUp = contact.searchByNumber(number);
                    if(contactUp != null) {
                        System.out.print("Enter new number: ");
                        long newNumber = sc.nextLong();
                        sc.nextLine();
                        if(newNumber > 9_999_999_999L || newNumber < 1_000_000_000L) {
                            System.out.println("Enter valid number");
                            break;
                        }
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                        contact.updateContact(number, newNumber, name);
                    }
                    break;

                case 3:
                    System.out.print("Enter the contact number you want to remove: ");
                    number = sc.nextLong();
                    sc.nextLine();
                    contactUp = contact.searchByNumber(number);
                    if(contactUp != null) {
                        contact.removeContact(number);
                    }
                    else {
                        System.out.println("Contact does not exit");
                    }
                    break;

                case 4:
                    contact.showAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        } while(choice != 5);
        sc.close();
    }
}
