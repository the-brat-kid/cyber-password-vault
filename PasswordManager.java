package PasswordManager;

import java.util.ArrayList;

public class PasswordManager {

    private ArrayList<PasswordEntry> passwords;

    public PasswordManager() {
        passwords = new ArrayList<>();
    }

    public void addPassword(String website, String username, String password) {
        PasswordEntry entry = new PasswordEntry(website, username, password);
        passwords.add(entry);
        System.out.println("Password added successfully!");
    }

    public void viewPasswords() {
        if (passwords.isEmpty()) {
            System.out.println("No passwords stored.");
            return;
        }

        System.out.println("\n===== STORED PASSWORDS =====");

        for (PasswordEntry entry : passwords) {
            System.out.println(entry);
            System.out.println("----------------------");
        }
    }

    public void searchPassword(String website) {
        boolean found = false;

        for (PasswordEntry entry : passwords) {
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                System.out.println("\nPassword Found:");
                System.out.println(entry);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No entry found for: " + website);
        }
    }

    public void deletePassword(String website) {
        PasswordEntry toRemove = null;

        for (PasswordEntry entry : passwords) {
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            passwords.remove(toRemove);
            System.out.println("Password deleted successfully!");
        } else {
            System.out.println("No entry found for: " + website);
        }
    }
}
    

