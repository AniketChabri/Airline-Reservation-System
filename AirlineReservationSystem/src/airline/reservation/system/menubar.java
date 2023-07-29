package airline.reservation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class menubar implements ActionListener {
    JMenuItem getinfo, addDetails, cancel, addpassenger, pay;
    JFrame frame;

    public static void main(String[] args) {
        new menubar();
    }

    public menubar() {
        //super("Airline Reservation System");
        frame=new JFrame("Airline Reservation System");
        frame.setLayout(null);
        frame.setSize(3000, 1667);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon(this.getClass().getResource("air_image3.jpg"));
        JLabel l5 = new JLabel(image);
        l5.setSize(2000, 650);
        frame.add(l5);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu flight_info = new JMenu("Flight");
        menuBar.add(flight_info);
        getinfo = new JMenuItem("Get Details");
        flight_info.add(getinfo);
        JMenu customerdetails = new JMenu("Customer");
        menuBar.add(customerdetails);
        addDetails = new JMenuItem("Add Customer details");
        customerdetails.add(addDetails);
        cancel = new JMenuItem("Cancel Ticket");
        customerdetails.add(cancel);
        JMenu journeydetails = new JMenu("Journey");
        menuBar.add(journeydetails);
        addpassenger = new JMenuItem("Add Journey details");
        journeydetails.add(addpassenger);
        JMenu paydetails = new JMenu("Payment");
        menuBar.add(paydetails);
        pay = new JMenuItem("Make Payment");
        paydetails.add(pay);

        getinfo.addActionListener(this);
        addDetails.addActionListener(this);
        cancel.addActionListener(this);
        addpassenger.addActionListener(this);
        pay.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==addDetails)
            new add_customerdetails();
       if (e.getSource() == cancel)
            new cancellation();
       if (e.getSource()==getinfo)
           new flight_info();
       if (e.getSource()==addpassenger)
           new journey_details();
       if (e.getSource()==pay)
           new payment_details();
    }
}


