import java.sql.*;
import java.util.*;
import java.io.*;

class AddressBook {

    Connection connection;
    Statement statement;

    public AddressBook() throws Exception {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/stdent_data", "root", "root");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson() throws Exception {
        try {

            String username, address, city;
            int phone;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter username: ");
            username = reader.readLine();

            System.out.print("Enter address: ");
            address = reader.readLine();

            System.out.print("Enter city: ");
            city = reader.readLine();

            System.out.print("Enter phone number: ");
            phone = Integer.parseInt(reader.readLine());

            // Inserting data
            String query = "INSERT INTO info VALUES ('" + username + "', '" + address + "', '" + city + "', " + phone
                    + ")";
            statement.executeUpdate(query);
            System.out.println("Person record added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(String name) {
        try {

            String query = "DELETE FROM info WHERE username = '" + name + "'";
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected == 0) {
                System.out.println("No person found with that name.");
            } else {
                System.out.println("Person record deleted successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchPerson(String name) {
        try {
            // Searching for the record in the table
            String query = "SELECT * FROM info WHERE username = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("City: " + resultSet.getString("city"));
                System.out.println("Phone: " + resultSet.getInt("phone"));
            } else {
                System.out.println("No person found with that name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Driver throws Exception {
    private AddressBook addressBook;

    public Driver() {
        addressBook = new AddressBook();
    }

    public void displayMenu() {
        System.out.println("Address Book Menu:");
        System.out.println("1. Add Person");
        System.out.println("2. Delete Person");
        System.out.println("3. Search Person");
        System.out.println("4. Exit");

        try {
            // Accepting input from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    addressBook.addPerson();
                    break;
                case 2:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = reader.readLine();
                    addressBook.deletePerson(nameToDelete);
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = reader.readLine();
                    addressBook.searchPerson(nameToSearch);
                    break;
                case 4:
                    addressBook.closeConnection();
                    System.out.println("Exiting from the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Driver driver = new Driver();

        while (true) {
            driver.displayMenu();
        }
    }
}
