package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

    private static final String jdbcURL = "jdbc:h2:~/mentoriajava";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "password";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Não foi possível estabelecer a conexão :/");
        }
        return connection;
    }
}
