package fr.univtln.bruno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public Person find(int id) {
        String query1 = "SELECT * FROM PERSON WHERE id=" + id;
        Person person = null;

        try {
            ResultSet resultSet = null;
            Statement statement = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query1);

            while (resultSet.next()) {
                person = Person.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
            }
        } catch (SQLException e) {
            //Erreur lors de la requête
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> findAll() {
        String query1 = "SELECT * FROM PERSON";
        List<Person> personList = new ArrayList<>();

        //personList.add(Person.builder().id(129).name("X").build());

        try {
            ResultSet resultSet = null;
            Statement statement = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query1);

            while (resultSet.next()) {
                personList.add(
                        Person.builder()
                                .id(resultSet.getInt("id"))
                                .name(resultSet.getString("name"))
                                .build()
                );
            }

            return personList;

        } catch (SQLException e) {
            //Erreur lors de la requête
            e.printStackTrace();
        }
        return null;
    }

}
