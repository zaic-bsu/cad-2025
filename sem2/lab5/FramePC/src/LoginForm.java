import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

public class LoginForm extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public LoginForm() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));   
        add(passwordField);
        add(new JPanel()); // Пустое место
        add(loginButton);
 
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String encodedAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
                
                TaskManagerForm taskManagerForm = new TaskManagerForm(encodedAuth);
                taskManagerForm.setVisible(true);
                dispose(); // Закрываем форму авторизации
                System.out.println("Encoded Auth: " + encodedAuth);
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
