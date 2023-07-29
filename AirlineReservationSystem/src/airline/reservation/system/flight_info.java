package airline.reservation.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class flight_info implements ActionListener {
    JFrame frame;
    JTextField t1;
    JButton button;
    JTable table;
    flight_info(){
        frame=new JFrame("GET DETAIL");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

         JLabel flightdetails=new JLabel("FLIGHT INFORMATION");
         flightdetails.setFont(new Font("Tahoma", Font.PLAIN, 25));
         flightdetails.setBounds(50,20,280,27);
         frame.add(flightdetails);

         JLabel flightcode=new JLabel("FLIGHT CODE");
         flightcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
         flightcode.setBounds(50,100,200,27);
         frame.add(flightcode);

         t1=new JTextField();
         t1.setBounds(200,105,200,27);
         frame.add(t1);

        button=new JButton("SHOW");
        button.setBounds(200,150,100,25);
        frame.add(button);

        table=new JTable();
        table.setBackground(Color.white);
        table.setBounds(25,250,500,200);
        frame.add(table);


        JLabel flightcode1=new JLabel("FLIGHT_CODE");
        flightcode1.setBounds(30,220,100,29);
        frame.add(flightcode1);

        JLabel flightname=new JLabel("FLIGHT_NAME");
        flightname.setBounds(150,220,100,29);
        frame.add(flightname);

        JLabel source1=new JLabel("SOURCE");
        source1.setBounds(260,220,100,29);
        frame.add(source1);

        JLabel destination1=new JLabel("DESTINATION");
        destination1.setBounds(350,220,100,29);
        frame.add(destination1);

        button.addActionListener(this);


        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new flight_info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){

            try{
                String code=t1.getText();
                if (t1.getText().isEmpty())
                    JOptionPane.showMessageDialog(frame,"TRY AGAIN");
                else {
                    connc c=new connc();
                    String str="SELECT f_code,f_name,src,dst from flightcode where f_code='"+code+"'";
                    ResultSet rs=c.st.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
//                    ResultSetMetaData rsmd=rs.getMetaData();
//                    DefaultTableModel model=(DefaultTableModel) table.getModel();
//                    String fc,fn,sr,des;
//                    while (rs.next()){
//                        fc=rs.getString(1);
//                        fn=rs.getString(2);
//                        sr=rs.getString(3);
//                        des=rs.getString(4);
//                        String[] row={fc,fn,sr,des};
//                        model.addRow(row);
//                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
