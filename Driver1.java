import java.sql.*;
import java.util.*;

class AddressBook {
    Class.forname("com.mysql.jdbc.Driver")
     Connection connection;

    public AddressBook() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/stdent_data", "root", "root");
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson() {
        try {
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO info VALUES (?, ?, ?, ?)");
             String username, address, city;
            int phone;
			Scanner sc= new Scanner(System.in);
			// take  username as input
			System.out.println("enter the  username ");
			String Username= sc.nextLine();
            // take  address  as input
			System.out.println("enter the  username ");
			String Address= sc.nextLine();
            // take  phone as input
			System.out.println("enter the  username ");
			String Phone= sc.nextLine();

            // take city as input
			System.out.println("enter the  username ");
			String City= sc.nextLine();
			
            preparedStatement.executeUpdate();
            System.out.println("Person added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void searchPerson(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM info WHERE username = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("username"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("City: " + resultSet.getString("city"));
                System.out.println("Phone: " + resultSet.getString("phone"));
            } else {
                System.out.println("Person not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM info WHERE username = ?");
            preparedStatement.setString(1, name);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Person deleted successfully!");
            } else {
                System.out.println("Person not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class today {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        // Option menu
        boolean exit = false;
        while (!exit) {
            System.out.println("Address Book");
            System.out.println("1. Add Person");
            System.out.println("2. Delete Person");
            System.out.println("3. Search Person");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                case 1:
                    addressBook.addPerson();
                    break;
                case 2:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = System.console().readLine();
                    addressBook.deletePerson(nameToDelete);
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = System.console().readLine();
                    addressBook.searchPerson(nameToSearch);
                    break;
                case 4:
                    exit = true;
                    addressBook.closeConnection();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        }
    }
}
