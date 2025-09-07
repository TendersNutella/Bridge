package Form;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI extends Window{
    public LoginGUI(){
        super("Login");
        addGuiComponents();
    }

    private void addGuiComponents(){
        // Create title
        JLabel loginLabel = Window.AddTitle("Login", 140, 10, 250, 100, 36);
        add(loginLabel);

        // username label
        JLabel usernameLabel = Window.AddLabel("Username:",100, 120, 300, 25, 16);
        add(usernameLabel);

        // username text field
        JTextField usernameField = Window.AddTextField(100, 150, 350, 35, 14);
        add(usernameField);

        // password label
        JLabel passwordLabel = Window.AddLabel("Password", 100, 200, 300, 25, 16);
        add(passwordLabel);

        // password text field
        JTextField passwordField = Window.AddTextField(100, 230, 350, 35, 14);
        add(passwordField);

        // login button
        JButton loginButton = Window.CreateButton("Login", 220, 300, 100, 30, 18);
        add(loginButton);

        // link to the register page
        JLabel registerLink = Window.AddLink("Don't have an account?", 150, 350, 250, 30);
        registerLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginGUI.this.dispose();
                new RegisterGUI().setVisible(true);
            }
        });
        add(registerLink);

    }
}
