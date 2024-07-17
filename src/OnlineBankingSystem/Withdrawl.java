package OnlineBankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {


    TextField textField;
    JButton b1,b2;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1700,650,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1350,700);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWL IS RS.10,000");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(350,180,700,30);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(350,220,400,30);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(350,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65,125,128));
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setBounds(630,310,132,25);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65,125,128));
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBounds(630,350,132,25);
        b2.addActionListener(this);
        l3.add(b2);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {


            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Connn c = new Connn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance = balance + Integer.parseInt(resultSet.getString("amount"));

                        } else {
                            balance = balance - Integer.parseInt(resultSet.getString("amount"));
                        }

                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values ('" + pin + "','" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }


            } catch (Exception E) {

            }
        }
        else if(e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin);
        }

    }


    public static void main(String[] args) {
        new Withdrawl(" ");

    }
}
