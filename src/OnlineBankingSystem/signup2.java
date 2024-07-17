package OnlineBankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup2 extends JFrame implements ActionListener {
    JComboBox comboBox  , comboBox2, comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;

    String formno;
    signup2(String formno) {
        super("APPLICATION FORM");



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120,5,100,100);
        add(image);
        this.formno = formno;
        JLabel l1 = new JLabel("Page 2:");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(300,15,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(300,45,600,40);
        add(l2);
        JLabel l3 = new JLabel("Religion:");
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        l3.setBounds(100,110,100,40);
        add(l3);

        String religion[] = {"Hindu", "Muslim", "Sikh","Christian", "Other"};
        comboBox =  new JComboBox(religion);
        comboBox.setBackground(new Color(231, 198, 105));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(350,110,320,30);
        add(comboBox);
        JLabel l4 = new JLabel("Category:");
        l4.setFont(new Font("Raleway", Font.BOLD, 15));
        l4.setBounds(100,160,100,40);
        add(l4);
        String category[] = {" General ", "OBC", "SC","ST","Other"};
        comboBox2 =  new JComboBox(category);
        comboBox2.setBackground(new Color(231, 198, 105));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(350,160,320,30);
        add(comboBox2);

        JLabel l5= new JLabel("Income:");
        l5.setFont(new Font("Raleway", Font.BOLD, 15));
        l5.setBounds(100,210,100,40);
        add(l5);
        String Income[] = {"null","<1,50,000","<2,50,000","5,00,000","upto 10,00,000","above 10,00,000"};
        comboBox3 =  new JComboBox(Income);
        comboBox3.setBackground(new Color(231, 198, 105));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(350,210,320,30);
        add(comboBox3);
        JLabel l6= new JLabel("Educational:");
        l6.setFont(new Font("Raleway", Font.BOLD, 15));
        l6.setBounds(100,260,100,40);
        add(l6);

        String educational[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate", "Engineer","other"};
        comboBox4 =  new JComboBox(educational);
        comboBox4.setBackground(new Color(231, 198, 105));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(350,260,320,30);
        add(comboBox4);

        JLabel l7= new JLabel("Occupation:");
        l7.setFont(new Font("Raleway", Font.BOLD, 15));
        l7.setBounds(100,310,100,40);
        add(l7);

        String occupation[] = {"Salaried","Self-Employed","Bussiness","Student", "Retired","other"};
        comboBox5 =  new JComboBox(occupation);
        comboBox5.setBackground(new Color(231, 198, 105));
        comboBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox5.setBounds(350,310,320,30);
        add(comboBox5);
        JLabel l8= new JLabel("PAN Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 15));
        l8.setBounds(100,360,100,40);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 15));
        textPan.setBounds(350,360,320,30);
        add(textPan);

        JLabel l9= new JLabel("Aadhar Number:");
        l9.setFont(new Font("Raleway", Font.BOLD, 15));
        l9.setBounds(100,410,150,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 15));
        textAadhar.setBounds(350,410,320,30);
        add(textAadhar);
        JLabel l10= new JLabel("Senior Citizen:");
        l10.setFont(new Font("Raleway", Font.BOLD, 15));
        l10.setBounds(100,460,180,30);
        add(l10);
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 15));
        r1.setBackground(new Color(231, 198, 105));
        r1.setBounds(350,460,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 15));
        r2.setBackground(new Color(231, 198, 105));
        r2.setBounds(450,460,100,30);
        add(r2);

        JLabel l11= new JLabel("Existing Account:");
        l11.setFont(new Font("Raleway", Font.BOLD, 15));
        l11.setBounds(100,510,180,30);
        add(l11);
        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 15));
        e1.setBackground(new Color(231, 198, 105));
        e1.setBounds(350,510,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 15));
        e2.setBackground(new Color(231, 198, 105));
        e2.setBounds(450,510,100,30);
        add(e2);

        JLabel l12= new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 15));
        l12.setBounds(650,10,100,30);
        add(l12);
        JLabel l13= new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 15));
        l13.setBounds(710,10,60,30);
        add(l13);
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setBounds(570,570,100,30);
        next.addActionListener(this);
        add(next);







        setLayout(null);
        setSize(850 , 750);
        setLocation(250,15);
        getContentPane().setBackground(new Color(231, 198, 105));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate= (String) comboBox2.getSelectedItem();
        String  inc =  (String) comboBox3.getSelectedItem();
        String edu  = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = (String) textPan.getText();
        String aadhar = (String) textAadhar.getText();
        String scitizen = " ";
        if(r1.isSelected()){
            scitizen = "Yes";
        }else if(r2.isSelected()){
            scitizen = "No";
        }
        String eAccount =" ";
        if(e1.isSelected()){
            eAccount = "Yes";
        }else if(e2.isSelected()){
            eAccount = "No";
        }

        try{
            if(textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter all the details in the fields");
            }else{
                Connn c1 = new Connn();
                String q ="insert into signuptwo values('"+formno +"','"+rel+"','"+cate+"' , '"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);

            }

        }catch(Exception E){
            E.printStackTrace();
        }



    }


    public static void main(String[] args) {
        new signup2(" ");
    }


}
