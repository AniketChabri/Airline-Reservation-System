package airline.reservation.system;
import java.sql.*;
public class connc {

    Connection con;
    Statement st;
    public connc(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinereservation","root","Aniket@123");
            st=con.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new connc();
    }
}
