package Form;

import javax.swing.*;
import java.awt.*;

public class ErrorGUI extends Window{
    public ErrorGUI(){
        super("Error");
        setSize(250, 250);
        getContentPane().setBackground(CommonConstants.TEXT_COLOR);
        addGuiComponents();
    }

    private void addGuiComponents(){
        // error label
        JLabel usernameLabel = AddLabel("Error",100, 100, 300, 25, 16);
        add(usernameLabel);
    }

    public static JLabel AddLabel(String text, int x, int y, int width, int height, int size){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.decode("000000"));
        label.setFont(new Font("Dialog", Font.PLAIN, size));
        return label;
    }
}
