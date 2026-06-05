package PasswordManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PasswordManager manager = new PasswordManager();

        while (true) {
            System.out.println("\n===== PASSWORD MANAGER =====");
            System.out.println("1. Add Password");
            System.out.println("2. View Passwords");
            System.out.println("3. Search Password");
            System.out.println("4. Delete Password");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Website/App Name: ");
                    String website = sc.nextLine();

                    System.out.print("Enter Username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    manager.addPassword(website, username, password);
                    break;

                case 2:
                    manager.viewPasswords();
                    break;

                case 3:
                    System.out.print("Enter Website/App Name to Search: ");
                    String searchSite = sc.nextLine();
                    manager.searchPassword(searchSite);
                    break;

                case 4:
                    System.out.print("Enter Website/App Name to Delete: ");
                    String deleteSite = sc.nextLine();
                    manager.deletePassword(deleteSite);
                    break;

                case 5:
                    System.out.println("Exiting Password Manager...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}