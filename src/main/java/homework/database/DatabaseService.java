package homework.database;

import java.math.BigDecimal;
import java.sql.*;

public class DatabaseService {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static String insertStatement = "insert into employees (name, lastname, age, salary, position) values (?, ?, ?, ?, ?);";

    public static void connectToDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:database/example.db");
    }

    public static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDB() throws SQLException {
        statement = connection.createStatement();
        statement.execute("create table if not exists employees (id integer primary key autoincrement, name text, lastname text, age integer, salary integer, position text);");
        ps = connection.prepareStatement(insertStatement);
    }

    public static void insert(String name, String lastName, int age, BigDecimal salary, String position) throws SQLException {
        ps.setString(1, name);
        ps.setString(2, lastName);
        ps.setInt(3, age);
        ps.setBigDecimal(4, salary);
        ps.setString(5, position);
        ps.executeUpdate();
    }

    public static void update(int id, String name, String lastname) throws SQLException {
        statement.executeUpdate("UPDATE employees SET name = '" + name
                + "', lastname = '" + lastname
                + "' WHERE id = " + id);
    }

    public static void deleteById(int id) throws SQLException {
        statement.executeUpdate("DELETE FROM employees WHERE id = " + id);
    }

    public static void searchById(int id) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("SELECT name, lastname, age, salary, position FROM employees WHERE id = " + id)) {
            while (resultSet.next()) {
                System.out.printf("Employee: %s %s, age: %s, salary: %d, position: %s\n",
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getString("position"));
            }
        }
    }

    public static void showEmployeesOlderThan(int age) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("SELECT name, lastname, age, salary, position FROM employees WHERE age >= " + age)) {
            while (resultSet.next()) {
                System.out.printf("Employee: %s %s, age: %s, salary: %d, position: %s\n",
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getString("position"));
            }
        }
    }

    public static void readDB() throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("SELECT id, name, lastname, age, salary, position FROM employees;")) {
            while (resultSet.next()) {
                System.out.printf("Employees: %s. %s %s, age: %s, salary: %d, position: %s\n",
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getString("position"));
            }
        }
    }

}
