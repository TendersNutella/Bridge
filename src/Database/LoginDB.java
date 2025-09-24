package Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDB {
    public static int Add(Login users){
        // Sql basic request to insert data into a table
        var sql = "INSERT INTO users(username, password) "
                + "VALUES(?,?)";

        try(var connection = DataBase.connect();
                var pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
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

        try(var connection = DataBase.connect();
                var pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Login> Querying(){
        var users = new ArrayList<Login>();
        var sql = "SELECT id, username, password FROM users ORDER BY id";

        try(var connection = DataBase.connect()) {
            assert connection != null; // In case the database connection return is null
            try(var statement = connection.createStatement()){
                var resultset = statement.executeQuery(sql);

                while (resultset.next()){
                    var user = new Login(
                            resultset.getInt("id"),
                            resultset.getString("username"),
                            resultset.getString("password"));
                    users.add(user);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public static int Update(int id, String username, String password){
        int affectedRows = 0;
        var sql  = "UPDATE users "
                + "SET username = ?, password = ? "
                + "WHERE id = ?";

        try (var connection = DataBase.connect();
                var pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);

            affectedRows = pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return affectedRows;
    }

    // A method that check if the username enter in the field is in the database
    public static boolean CheckUser(String username){
        var sql = "SELECT * FROM users WHERE username = ?";
        try(var connection = DataBase.connect();
                var checkUserExist = connection.prepareStatement(sql)){

            checkUserExist.setString(1, username);
            var resultset = checkUserExist.executeQuery();

            if(!resultset.isBeforeFirst()){
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}

