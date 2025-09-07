import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });

//        final Scanner scanner = new Scanner(System.in);
//        String username;
//        String password;
//
//        ConnectionDataBase dataBase = new ConnectionDataBase("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
//        LoginDB user = new LoginDB(dataBase);
//
//        System.out.print("Enter username : ");
//        username = scanner.next();
//        System.out.print("Enter password : ");
//        password = scanner.next();
//
//        if(user.hasAccount(username, password)){
//            user.Login();
//        }else{
//            user.register(username, password);
//        }
//
//        dataBase.CloseConnection();
    }
}