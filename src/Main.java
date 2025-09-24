import Database.DataBase;
import Database.Login;
import Database.LoginDB;
import Form.ErrorGUI;
import Form.LoginGUI;
//import Form.LoginGUI;
import javax.swing.*;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });


//        try(var connection = DataBase.connect()){
//            System.out.println("Connected to the database!");
//        }catch (SQLException e){
//            System.err.println(e.getMessage());
//        }
//
//        // add rows to the table
//        int id = LoginDB.Add(new Login("Tenders", "Tenders123"));
//        System.out.println("Inserted id : " + id);
//
//        // delete rows in the table
//        int deletedRows = LoginDB.delete(2);
//        System.out.println("Rows deleted : " + deletedRows);

//        var users = LoginDB.Querying();
//        for (var user : users){
//            System.out.println(user);
//        }

//        int updateRows = LoginDB.Update(6, "TendersNutella", "TendersNutella123");
//        System.out.println("Updated Rows : " + updateRows);
//
//        System.out.println(LoginDB.CheckUser("kntui"));
    }
}