import java.util.List;
import java.util.ArrayList;

public class ContactFeat {
    private List<Contact> contacts;

    public ContactFeat() {
        contacts = new ArrayList<>();
    }

    public Contact searchByNumber(long number) {
        for(Contact num : contacts) {
            if(number < 1_000_000_000L || number > 9_999_999_999L) {
                break;
            }
            if(num.equals(number)) {
                return num;
            }
        }
        return null;
    }

    public void addContact(long number, String name) {
        Contact found = searchByNumber(number);
        if(found != null) {
            System.out.println("Contact already exists with the same number");
        }
        else {
            contacts.add(new Contact(number, name));
        }
    }

    public void updateContact(long number, long newNumber, String newName) {
        Contact found = searchByNumber(number);

        if(found == null) {
            System.out.println("Contact not found");
        }
        else {
            found.setNumber(newNumber);
            found.setName(newName);
        }
    }

    public void removeContact(long number) {
        Contact found = searchByNumber(number);

        if(found == null) {
            System.out.println("Number not found");
        }

        else {
            contacts.remove(number);
        }
    }

    public void showAllContacts() {
        for (Contact num : contacts) {
            System.out.println(num);
        }
    }
}
