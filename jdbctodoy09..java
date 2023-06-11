import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            CustomerDAO customerDAO = new CustomerDAO(connection);

            // Insert a new customer
            Customer newCustomer = new Customer("John Doe", 30);
            customerDAO.insertCustomer(newCustomer);

            // Search for customers with age greater than 25
            int ageThreshold = 25;
            ResultSet resultSet = customerDAO.searchCustomersByAge(ageThreshold);
            while (resultSet.next()) {
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                int customerAge = resultSet.getInt("age");
                System.out.println("Customer ID: " + customerId + ", Name: " + customerName + ", Age: " + customerAge);
            }
            resultSet.close();

            // Delete a customer
            int customerIdToDelete = 1;
            customerDAO.deleteCustomer(customerIdToDelete);

            // Close the resources
            customerDAO.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class CustomerDAO {
    private Connection connection;
    private PreparedStatement insertStatement;
    private PreparedStatement searchStatement;
    private PreparedStatement deleteStatement;

    public CustomerDAO(Connection connection) throws SQLException {
        this.connection = connection;
        String insertQuery = "INSERT INTO customers (name, age) VALUES (?, ?)";
        insertStatement = connection.prepareStatement(insertQuery);

        String searchQuery = "SELECT * FROM customers WHERE age > ?";
        searchStatement = connection.prepareStatement(searchQuery);

        String deleteQuery = "DELETE FROM customers WHERE id = ?";
        deleteStatement = connection.prepareStatement(deleteQuery);
    }

    public void insertCustomer(Customer customer) throws SQLException {
        insertStatement.setString(1, customer.getName());
        insertStatement.setInt(2, customer.getAge());
        insertStatement.executeUpdate();
    }

    public ResultSet searchCustomersByAge(int ageThreshold) throws SQLException {
        searchStatement.setInt(1, ageThreshold);
        return searchStatement.executeQuery();
    }

    public void deleteCustomer(int customerId) throws SQLException {
        deleteStatement.setInt(1, customerId);
        deleteStatement.executeUpdate();
    }

    public void close() throws SQLException {
        insertStatement.close();
        searchStatement.close();
        deleteStatement.close();
    }
}

class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
