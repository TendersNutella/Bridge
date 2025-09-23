package Database;

import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB {
    public static int add(Login users){
        // Sql basic request to insert data into a table
        var sql = "INSERT INTO users(username, password) "
                + "VALUES(?,?)";

        try(var connection = DataBase.connect(); var pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, users.GetUsername());
            pstmt.setString(2, users.GetPassword());

            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0){
                var resultSet = pstmt.getGeneratedKeys();
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static int delete(int id){
        var sql = "DELETE FROM users WHERE id=?";

        try(var connection = DataBase.connect(); var pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
