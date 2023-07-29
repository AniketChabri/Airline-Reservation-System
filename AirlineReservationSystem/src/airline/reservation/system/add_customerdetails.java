package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class add_customerdetails implements ActionListener {
    JFrame  frame;
    JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    JButton button;
    JRadioButton male1,female1;
    add_customerdetails(){
        frame=new JFrame("ADD CUSTOMER DETAILS");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        JLabel flightCode=new JLabel("FLIGHT CODE");
        flightCode.setBounds(60,30,150,27);
        frame.add(flightCode);

        tx1=new JTextField();
        tx1.setBounds(200,30,150,27);
        frame.add(tx1);

        JLabel passengerno=new JLabel("PASSENGER NO");
        passengerno.setBounds(60,80,150,27);
        frame.add(passengerno);

        tx2=new JTextField();
        tx2.setBounds(200,80,150,27);
        frame.add(tx2);

        JLabel pnrno=new JLabel("PNR NO");
        pnrno.setBounds(60,130,150,27);
        frame.add(pnrno);

        tx3=new JTextField();
        tx3.setBounds(200,130,150,27);
        frame.add(tx3);

        JLabel address=new JLabel("ADDRESS");
        address.setBounds(60,180,150,27);
        frame.add(address);

        tx4=new JTextField();
        tx4.setBounds(200,180,150,27);
        frame.add(tx4);

        JLabel nationality=new JLabel("NATIONALITY");
        nationality.setBounds(60,230,150,27);
        frame.add(nationality);

        tx5=new JTextField();
        tx5.setBounds(200,230,150,27);
        frame.add(tx5);

        JLabel name=new JLabel("NAME");
        name.setBounds(60,280,150,27);
        frame.add(name);


        tx6=new JTextField();
        tx6.setBounds(200,280,150,27);
        frame.add(tx6);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60,320,150,27);
        frame.add(gender);

        male1=new JRadioButton("MALE");
        male1.setBackground(Color.WHITE);
        male1.setBounds(200,320,70,27);
        frame.add(male1);

        female1=new JRadioButton("FEMALE");
        female1.setBackground(Color.WHITE);
        female1.setBounds(280,320,100,27);
        frame.add(female1);

        JLabel phone=new JLabel("PH NO");
        phone.setBounds(60,370,150,27);
        frame.add(phone);

        tx7=new JTextField();
        tx7.setBounds(200,370,150,27);
        frame.add(tx7);

        button=new JButton("SAVE");
        button.setBounds(200,450,150,27);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        frame.add(button);

        button.addActionListener(this);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new add_customerdetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            try {
                String fc=tx1.getText();
                String pno=tx2.getText();
                String pnr=tx3.getText();
                String address=tx4.getText();
                String nationality=tx5.getText();
                String name1=tx6.getText();
                String gender=null;
                String phno=tx7.getText();
                if (male1.isSelected()){
                    gender="MALE";
                } else if (female1.isSelected()) {
                    gender="FEMALE";
                }
                connc c=new connc();
                String str="INSERT INTO passenger values('"+fc+"','"+pno+"','"+pnr+"','"+address+"','"+nationality+"','"+name1+"','"+gender+"','"+phno+"')";
                c.st.executeUpdate(str);
                JOptionPane.showMessageDialog(frame,"Successfully added.....");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
