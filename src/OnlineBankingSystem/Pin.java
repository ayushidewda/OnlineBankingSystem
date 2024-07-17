package OnlineBankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Pin extends JFrame implements ActionListener {
    JButton b1, b2;
    JPasswordField p1, p2;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1700, 650, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        add(l3);
        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(350, 180, 400, 30);
        l3.add(label1);
        JLabel label2 = new JLabel(" New PIN:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(320, 210, 400, 30);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.white);
        p1.setBounds(470, 210, 200, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p1);

        JLabel label3 = new JLabel(" Re-Enter New PIN:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(320, 240, 200, 35);
        l3.add(label3);
        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.white);
        p2.setBounds(470, 240, 200, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setBounds(630, 310, 132, 25);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBounds(630, 350, 132, 25);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = new String(p1.getPassword());
            String pin2 = new String(p2.getPassword());

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if (e.getSource() == b1) {
                if (pin1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (pin2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Connn c = new Connn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";



                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource() == b2) {
                new main_Class(pin);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
