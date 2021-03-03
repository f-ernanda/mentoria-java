package crud;

import entities.Person;

import java.sql.*;

public class Create {
    private static final String createSQL = "INSERT INTO users (id, name, cpf) VALUES (?, ?, ?);";

    public void createRecord(Person person) {
        try {
            Connection connection = Utils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getCpf());

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

            System.out.println("Pessoa adicionada com sucesso!");
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Não foi possível adicionar esta pessoa :/");
        }
    }
}
