package OnlineBankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    TextField textField;
    JButton b1,b2;
    String pin;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1700,650,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1350,700);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(350,180,400,30);
        l3.add(label1);
        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(350,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
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
      try {
          String amount = textField.getText();
          Date date = new Date();
          if (e.getSource()==b1){
              if(textField.getText().equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
              }else{
                  Connn c = new Connn();
                  c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Deposit','"+amount+"')");
                  JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited successfully");
                  setVisible(false);
              }

          }else if(e.getSource()==b2){
              setVisible(false);
              new main_Class(pin);

          }
      }
      catch(Exception E){
          E.printStackTrace();
      }


    }

    public static void main(String[] args) {
        new Deposit(" ");
    }
}
