package fr.univtln.bruno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {

        String jdbcURL = "jdbc:postgresql://localhost:5436/postgres";
        Connection connection = DriverManager.getConnection(jdbcURL, "postgres", "password");

        PersonDAO personDAO = new PersonDAO(connection);

        System.out.println(personDAO.findAll());

        System.out.println(personDAO.find(2));

        System.out.println(personDAO.find(3));

        connection.close();
    }
}
