package OnlineBankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2 , label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");

        // Image for Bank Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        // Image for Card Icon
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        // Welcome Label
        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 115, 450, 40);
        add(label1);

        // Card No Label and TextField
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150, 180, 375, 30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325, 180, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        // PIN Label and PasswordField
        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150, 230, 375, 30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 230, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        // Buttons
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(280, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Reset");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(410, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(280, 350, 230, 30);
        button3.addActionListener(this);
        add(button3);

        // Background Image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        // Frame settings
        setLayout(null);
        setSize(850, 480);
        setLocation(250, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                Connn c = new Connn();
                String cardno = textField2.getText();
                String pin = new String(passwordField3.getPassword()); // Correct handling of password field

                System.out.println("Debug: cardno=" + cardno + ", pin=" + pin); // Debug statement

                String q = "SELECT * FROM login WHERE card_number = '" + cardno + "' AND pin = '" + pin + "'";
                System.out.println("Debug: Query: " + q); // Debug statement

                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
