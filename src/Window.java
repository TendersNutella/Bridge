import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title){
        super(title);
        setSize(540, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);
    }

    public static JLabel AddTitle(String text, int x, int y, int width, int height, int size){
        JLabel loginLabel = new JLabel(text);
        loginLabel.setBounds(x, y, width, height);
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, size));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return loginLabel;
    }

    public static JLabel AddLabel(String text, int x, int y, int width, int height, int size){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(CommonConstants.TEXT_COLOR);
        label.setFont(new Font("Dialog", Font.PLAIN, size));
        return label;
    }

    public static JTextField AddTextField(int x, int y, int width, int height, int size){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBackground(CommonConstants.TEXT_COLOR);
        textField.setForeground(CommonConstants.TEXT_COLOR_ON_BUTTON);
        textField.setFont(new Font("Dialog", Font.PLAIN, size));
        return textField;
    }

    public static JLabel AddLink(String text,int x, int y, int width, int height){
        JLabel linkLabel = new JLabel(text);
        linkLabel.setHorizontalAlignment(SwingConstants.CENTER);
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        linkLabel.setForeground(CommonConstants.TEXT_COLOR);
        linkLabel.setBounds(x, y, width, height);
        return linkLabel;
    }

    public static JButton CreateButton(String text,int x, int y, int width, int height, int size){
        JButton loginButton = new JButton(text);
        loginButton.setFont(new Font("Dialog", Font.PLAIN, size));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommonConstants.TEXT_COLOR);
        loginButton.setBounds(x, y, width, height);
        return loginButton;
    }
}
