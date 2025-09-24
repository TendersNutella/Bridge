package Form;

import Database.Login;
import Database.LoginDB;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGUI extends Window{

    public RegisterGUI(){
        super("Register");
        addGuiComponents();
    }

    private void addGuiComponents(){
        // Create title
        JLabel registerLabel = Window.AddTitle("Register", 140, 10, 250, 100, 36);
        add(registerLabel);

        // username label
        JLabel usernameLabel = Window.AddLabel("Username", 100, 100, 300, 25, 16);
        add(usernameLabel);

        JTextField usernameField = Window.AddTextField(100, 125, 350, 35, 14);
        add(usernameField);

        // password label
        JLabel passwordLabel = Window.AddLabel("Password:", 100, 170, 300, 25, 16);
        add(passwordLabel);

        // password text field
        JTextField passwordField = Window.AddTextField(100, 195, 350, 35, 14);
        add(passwordField);

        // re-enter password label
        JLabel rePasswordLabel = Window.AddLabel("Re-password:", 100, 240, 300, 25, 16);
        add(rePasswordLabel);

        // re-enter password text field
        JTextField rePasswordField = Window.AddTextField(100, 265, 350, 35, 14);
        add(rePasswordField);

        // create button
        JButton registerButton = Window.CreateButton("Register", 220, 330, 110, 30, 18);
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(LoginDB.CheckUser(usernameField.getText())){
                    System.out.println("Username already taken!");
                }else if(passwordField.getText().equals(rePasswordField.getText())){
                    System.out.println("Register successfully");
                    LoginDB.Add(new Login(usernameField.getText(), passwordField.getText()));
                    RegisterGUI.this.dispose();
                    new BridgeGUI().setVisible(true);
                }
                else{
                    System.out.println("Problem encountered");
                }
            }
        });
        add(registerButton);

        // create link button to login page
        JLabel loginLabel = Window.AddLink("Already have an account?", 150, 360, 250, 30);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterGUI.this.dispose();
                new LoginGUI().setVisible(true);
            }
        });
        add(loginLabel);
    }
}
