import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoginDB {
    final private ConnectionDataBase dataBase;
    final private List<String> usernameDataBase = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public LoginDB( ConnectionDataBase dataBase) throws SQLException{
        this.dataBase = dataBase;
    }

    public void register(String username, String password) throws SQLException {
        Verification(username, password);
    }

    public void addUsers(String username, String password) throws SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        statement.executeUpdate("INSERT INTO login VALUES (DEFAULT, '" + username + "', '" + password + "')");
        System.out.println("User added successfully");
    }

    public void Verification(String username, String password) throws SQLException{
        addUserToArray();
        while (this.usernameDataBase.contains(username)){
            System.out.println("Username already taken");
            username = scanner.next();
        }
        addUsers(username, password);
    }

    public void addUserToArray() throws SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select username from login");
        String usernamedb = " ";

        while(resultSet.next()){
            usernamedb = resultSet.getString("username");
            this.usernameDataBase.add(usernamedb);
        }

        for (String s : this.usernameDataBase){
            System.out.println(s);
        }
    }

    public void Login() throws SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login");

        while (resultSet.next()){
            int id_user = resultSet.getInt("id_user");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println(id_user + " : " + username + ", " + password);
        }

    }

    public boolean hasAccount(String username, String password) throws SQLException{
        String usernameDB = " ";
        String passwordDB = " ";
        Statement statement = dataBase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select id_user, username, password from login WHERE username = '"
                + username + "' and password ='" + password + "'");

        while (resultSet.next()){
            usernameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
        }

        if (username.equals(usernameDB) && password.equals(passwordDB)){
            return true;
        }

        statement.close();
        resultSet.close();
        return false;
    }

    public void DisplayDataBase() throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login");

        while (resultSet.next()){
            int id_user = resultSet.getInt("id_user");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println(id_user + " : " + username + ", " + password);
        }

        statement.close();
        resultSet.close();
    }
}
