package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {
      JLabel l1,l2,l3,l4,l5;
      JButton b1,b2;
      //JPasswordField pf1;
      JTextField tf1,tf2;
      JFrame f1;
      public login(){
          super("login");
          new JFrame("Login Account");
          setBackground(Color.WHITE);
          setLayout(null);
          ImageIcon image=new ImageIcon(this.getClass().getResource("virgin-2721333_1280.jpg"));
         // f1.setIconImage(image.getImage());



          l1=new JLabel();
          l1.setBounds(0,0,1500,814);
          l1.setLayout(null);

          l2=new JLabel("User Name");
          l2.setBounds(120,120,150,40);
          l2.setForeground(Color.BLACK);
          l2.setFont(new Font("Arial",Font.BOLD,20));
          l1.add(l2);
          add(l1);

          l3=new JLabel("Password");
          l3.setBounds(120,170,150,40);
          l3.setForeground(Color.BLACK);
          l3.setFont(new Font("Arial",Font.BOLD,20));
          l1.add(l3);

          l4=new JLabel("Login Account");
          l4.setBounds(190,30,500,50);
          l4.setForeground(Color.BLACK);
          l4.setFont(new Font("Arial",Font.BOLD,20));
          l1.add(l4);



          tf1=new JTextField();
          tf1.setBounds(270,130,150,30);
          l1.add(tf1);

          tf2=new JPasswordField();
          tf2.setBounds(270,170,150,30);
          l1.add(tf2);

          b1=new JButton("Login");
          b1.setBackground(Color.BLACK);
          b1.setForeground(Color.WHITE);
          b1.setBounds(120,220,150,40);
          l1.add(b1);

          b2=new JButton("Reset");
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.WHITE);
          b2.setBounds(320,220,150,40);
          l1.add(b2);

          l5=new JLabel(image);
          l5.setSize(1500,844);
          l1.add(l5);

          b1.addActionListener(this);
          b2.addActionListener(this);

          setSize(1500,844);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true);

      }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()==b2){
              tf1.setText("");
              tf2.setText("");
          }
         if (e.getSource()==b1){
             //new menubar();
             try {
                 connc c=new connc();
                 String s1=tf1.getText();
                 String s2=tf2.getText();
                 String str="select * from login where username='"+s1+"' and pass='"+s2+"'";
                 ResultSet rs=c.st.executeQuery(str);
                 if (rs.next()){
                     new menubar();
                     setVisible(false);
                 }
                 else {
                     JOptionPane.showMessageDialog(f1,"Invalid login");
                     setVisible(false);
                 }
             } catch (SQLException ex) {
                 throw new RuntimeException(ex);
             }
         }
    }
}
