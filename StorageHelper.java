package PasswordManager;

import java.io.*;
import java.util.ArrayList;

public class StorageHelper {

    private static final String FILE_NAME = "passwords.txt";

    public static void savePasswords(ArrayList<PasswordEntry> passwords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (PasswordEntry entry : passwords) {
                writer.write(
                        entry.getWebsite() + "," +
                        entry.getUsername() + "," +
                        entry.getPassword()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving passwords: " + e.getMessage());
        }
    }

    public static ArrayList<PasswordEntry> loadPasswords() {

        ArrayList<PasswordEntry> passwords = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return passwords;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    passwords.add(
                            new PasswordEntry(
                                    parts[0],
                                    parts[1],
                                    parts[2]
                            )
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading passwords: " + e.getMessage());
        }

        return passwords;
    }
}
    