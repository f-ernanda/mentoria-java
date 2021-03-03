package crud;

import java.sql.*;

public class Read {
    private static final String readSQL = "SELECT * FROM users";

    public void readRecord() {
        try {
            Connection connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSQL);

            while(resultSet.next()) {
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               String cpf = resultSet.getString("cpf");
               System.out.println("Id: " + id + " - Nome: " + name + ", CPF: " + cpf + "; ");
            }

            connection.close();
            statement.close();
            resultSet.close();

            System.out.println();

        } catch (SQLException e) {
            System.out.println("Não foi possível exibir o conteúdo da tabela :/");
        }
    }
}
