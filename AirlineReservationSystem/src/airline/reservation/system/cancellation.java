package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class cancellation implements ActionListener {
    JTextField tf1,tf2,tf3,tf4;
    JFrame frame;
    JButton cancel3;
     public cancellation(){
        frame=new JFrame("CANCELLATION");
       // frame.setTitle("");
       // frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        JLabel cancellation=new JLabel("CANCELLATION");
        cancellation.setBounds(185,24,259,38);
        frame.add(cancellation);

        JLabel pnr_no=new JLabel("Passenger PNR No");
        pnr_no.setBounds(60,100,132,26);
        frame.add(pnr_no);

        tf1=new JTextField();
        tf1.setBounds(250,100,150,27);
        frame.add(tf1);

        JLabel cancellaationno=new JLabel("Cancellation No");
        cancellaationno.setBounds(60,150,150,27);
        frame.add(cancellaationno);

        tf2=new JTextField();
        tf2.setBounds(250,150,150,27);
        frame.add(tf2);

        JLabel cancellationdate=new JLabel("Cancellation Date");
        cancellationdate.setBounds(60,200,180,27);
        frame.add(cancellationdate);

        tf3=new JTextField();
        tf3.setBounds(250,200,150,27);
        frame.add(tf3);

        JLabel flightcode=new JLabel("Flight Code");
        flightcode.setBounds(60,250,150,27);
        frame.add(flightcode);

        tf4=new JTextField();
        tf4.setBounds(250,250,150,27);
        frame.add(tf4);

        cancel3=new JButton("CANCEL");
         cancel3.setBackground(Color.BLACK);
         cancel3.setForeground(Color.WHITE);
         cancel3.setBounds(250,350,150,27);
         frame.add(cancel3);

         cancel3.addActionListener(this);


        frame.setVisible(true);
    }

    public static void main(String[] args)  {
      new cancellation();
    }


   @Override
   public void actionPerformed(ActionEvent e) {

      if(e.getSource()==cancel3){
         try {
            String pnr_no= tf1.getText();
            String cancellation_no=tf2.getText();
            String cancellation_date=tf3.getText();
            String flight_code=tf4.getText();
            if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() )
               JOptionPane.showMessageDialog(frame,"TRY AGAIN");
            else {
               connc c=new connc();
               String str = "INSERT INTO cancellation values('" + pnr_no + "','" + cancellation_no + "','" + cancellation_date + "','" + flight_code + "')";
               c.st.executeUpdate(str);
               JOptionPane.showMessageDialog(frame, "Ticket Cancelled");
            }

         }catch (SQLException ex){
            System.err.println(ex);
         }
      }

   }
}
