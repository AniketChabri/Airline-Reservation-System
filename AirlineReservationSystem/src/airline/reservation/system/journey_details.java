package airline.reservation.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class journey_details implements ActionListener {
    JFrame frame;
    JButton button;
    JComboBox comboBox1,comboBox;
    JTable table;
    JLabel source,destination;
    journey_details(){
        frame=new JFrame("JOURNEY_DETAILS");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel journeydetails=new JLabel("JOURNEY DETAILS");
        journeydetails.setForeground(Color.RED);
        journeydetails.setBounds(100,17,300,39);
        journeydetails.setFont(new Font("Tahoma",Font.PLAIN,30));
        frame.add(journeydetails);

        source=new JLabel("SOURCE");
        source.setBounds(60,100,150,27);
        source.setFont(new Font("Tahoma",Font.PLAIN,20));
        frame.add(source);

        destination=new JLabel("DESTINATION");
        destination.setBounds(350,100,150,27);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        frame.add(destination);

        String[] items1 =  {"Philippines", "India","China", "Russia", "United States","Australia","Saudi Arabia"};
        comboBox=new JComboBox(items1);
        comboBox.setBounds(150,100,150,27);
        frame.add(comboBox);

        String[] item2={"Philippines", "India","China", "Russia", "United States","Australia","Saudi Arabia"};
        comboBox1=new JComboBox(item2);
        comboBox1.setBounds(500,100,150,27);
        frame.add(comboBox1);

        button=new JButton("SHOW");
        button.setBounds(700,100,100,27);
        frame.add(button);

        JLabel tickedid=new JLabel("TICKED_ID");
        tickedid.setBounds(70,200,100,27);
        frame.add(tickedid);

        JLabel flightcode=new JLabel("FLIGHT_CODE");
        flightcode.setBounds(200,200,100,27);
        frame.add(flightcode);

        JLabel journeydate=new JLabel("JNY_DATE");
        journeydate.setBounds(340,200,100,27);
        frame.add(journeydate);

        JLabel journeytime=new JLabel("JNY_TIME");
        journeytime.setBounds(460,200,100,27);
        frame.add(journeytime);

        source=new JLabel("SOURCE");
        source.setBounds(580,200,100,27);
        frame.add(source);

        destination=new JLabel("DESTINATION");
        destination.setBounds(680,200,100,27);
        frame.add(destination);

        table=new JTable();
        table.setBounds(50,230,800,200);
        frame.add(table);

        button.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new journey_details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            try{
                String src1=(String) comboBox.getSelectedItem();
                String dest=(String) comboBox1.getSelectedItem();
                connc c=new connc();
                String str="SELECT tkid,fcode,jdate,jtime,src1,dest from journey where src1='"+src1+ "' and dest='"+dest+"'";
                ResultSet rs=c.st.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
//                if(rs.next()){
//                    table.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                else {
//                    JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
//                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
