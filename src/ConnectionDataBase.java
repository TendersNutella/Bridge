import java.sql.*;

public class ConnectionDataBase {
    final private String m_url;
    final private String m_postgresqlUsername;
    final private String m_postgresqlPassword;
    final private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public ConnectionDataBase(String url, String username, String password) throws SQLException{
        this.m_url = url;
        this.m_postgresqlUsername = username;
        this.m_postgresqlPassword = password;
        this.connection = DriverManager.getConnection(m_url, m_postgresqlUsername, m_postgresqlPassword);
        System.out.println("Connected successfully!");
    }

    public Connection getConnection (){
        return connection;
    }

    public void CloseConnection() throws SQLException{
        connection.close();
        System.out.println("Connection closed!");
    }
}
