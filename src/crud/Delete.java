package crud;

import java.sql.*;

public class Delete {
    private static final String deleteSQL = "DELETE FROM users WHERE id = ?";

    public void deleteRecord(int id) {
        try {
            Connection connection = Utils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

            System.out.println("Pessoa excluída com sucesso!");
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível excluir esta pessoa :/");
        }
    }
}
