package crud;

import entities.Person;

import java.sql.*;

public class Update {
    private static final String updateSQL = "UPDATE users SET name = ?, cpf = ? WHERE id = ?";

    public void updateRecord(Person person) {
        try {
            Connection connection = Utils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCpf());
            preparedStatement.setInt(3, person.getId());

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

            System.out.println("Pessoa atualizada com sucesso!");
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Não foi atualizar essa pessoa :/");
        }
    }
}
