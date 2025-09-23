package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection connect() throws SQLException{
        try{
            var jbdcUrl = DatabaseConfig.GetUrl();
            var jbdcUser = DatabaseConfig.GetUsername();
            var jbdcPassword = DatabaseConfig.GetPassword();

            return DriverManager.getConnection(jbdcUrl, jbdcUser, jbdcPassword);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
