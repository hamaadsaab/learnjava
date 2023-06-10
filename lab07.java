import java.sql.*;
import java.util.*;
import java.io.*;

class AddressBook {

    Connection connection;
    PreparedStatement addPersonStatement;
    PreparedStatement deletePersonStatement;
    PreparedStatement searchPersonStatement;

    public AddressBook() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/stdent_data", "root", "root");

            String addPersonQuery = "INSERT INTO info VALUES (?, ?, ?, ?)";
            addPersonStatement = connection.prepareStatement(addPersonQuery);

            String deletePersonQuery = "DELETE FROM info WHERE username = ?";
            deletePersonStatement = connection.prepareStatement(deletePersonQuery);

            String searchPersonQuery = "SELECT * FROM info WHERE username = ?";
            searchPersonStatement = connection.prepareStatement(searchPersonQuery);
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

            addPersonStatement.setString(1, username);
            addPersonStatement.setString(2, address);
            addPersonStatement.setString(3, city);
            addPersonStatement.setInt(4, phone);

            // Inserting data
            int rowsAffected = addPersonStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Person record added successfully.");
            } else {
                System.out.println("Failed to add person record.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(String name) {
        try {
            deletePersonStatement.setString(1, name);

            int rowsAffected = deletePersonStatement.executeUpdate();

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
            searchPersonStatement.setString(1, name);

            ResultSet resultSet = searchPersonStatement.executeQuery();

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
            addPersonStatement.close();
            deletePersonStatement.close();
            searchPersonStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Driver {
    private AddressBook addressBook;

    public Driver() {
        try {
            addressBook = new AddressBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        Driver driver = new Driver();

        while (true) {
            driver.displayMenu();
        }
    }
}
