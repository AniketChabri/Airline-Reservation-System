package airline.reservation.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class payment_details implements ActionListener {
    JFrame frame;
    JTextField t2;
    JTable table;
    JButton button;
    public payment_details(){
        frame=new JFrame("PAYMENT_DETAILS");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel paymentdetails=new JLabel("PAYMENT DETAILS");
        paymentdetails.setForeground(Color.RED);
        paymentdetails.setBounds(100,17,300,39);
        paymentdetails.setFont(new Font("Tahoma",Font.PLAIN,30));
        frame.add(paymentdetails);

        JLabel pnr=new JLabel("PNR NO");
        pnr.setBounds(50,100,150,27);
        pnr.setFont(new Font("Tahoma",Font.PLAIN,20));
        frame.add(pnr);

        t2=new JTextField();
        t2.setBounds(200,100,150,27);
        frame.add(t2);

        button=new JButton("SHOW");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBounds(200,150,150,27);
        frame.add(button);

        JLabel pnrno=new JLabel("PNR_NO");
        pnrno.setBounds(29,250,150,27);
        frame.add(pnrno);

        JLabel paidamt=new JLabel("PAID_AMOUNT");
        paidamt.setBounds(120,250,150,27);
        frame.add(paidamt);

        JLabel paydate=new JLabel("PAY_DATE");
        paydate.setBounds(250,250,150,27);
        frame.add(paydate);

        JLabel checkno=new JLabel("CHECK_NO");
        checkno.setBounds(350,250,150,27);
        frame.add(checkno);

        JLabel cardno=new JLabel("CARD_NO");
        cardno.setBounds(450,250,150,27);
        frame.add(cardno);

        JLabel phno=new JLabel("PHONE_NO");
        phno.setBounds(550,250,150,27);
        frame.add(phno);

        table =new JTable();
        table.setBounds(20,290,650,200);
        frame.add(table);

        button.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new payment_details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            try {
                String code=t2.getText();
                connc c=new connc();
                String str="SELECT pnrno,paidamt,pdate,ckno,crdno,phn from payment where pnrno='"+code+"'";
                ResultSet rs=c.st.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
