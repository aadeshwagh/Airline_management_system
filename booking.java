import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class booking implements ActionListener {
    JButton check_out,cancle;
    JTextField F_T,L_T,E_T,P_T,flig_T ,no_T;
    JFrame booking;
    booking(){
        //Labels
        JLabel F_name = new JLabel("First name :");
        JLabel L_name = new JLabel("Last name :");
        JLabel E_mail = new JLabel("Email ID :");
        JLabel P_mr = new JLabel("PMR number :");
        JLabel flight = new JLabel("Flight number:");
        JLabel no = new JLabel("Pssengers :");

        F_name.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        L_name.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        E_mail.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        P_mr.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        flight.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        no.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        
        //text field
        F_T = new JTextField();
        L_T = new JTextField();
        E_T = new JTextField();
        P_T = new JTextField();
        flig_T = new JTextField();
        no_T = new JTextField();

        F_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        L_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        E_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        P_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        flig_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        no_T.setFont(new Font("san-sarif",Font.PLAIN,17));

        //button
        check_out = new JButton("Proceed");
        check_out.setFocusable(false);
        check_out.setFont(new Font("san-sarif",Font.PLAIN ,18));
        check_out.addActionListener(this);

        cancle = new JButton("Cancle");
        cancle.setFocusable(false);
        cancle.addActionListener(this);
        cancle.setFont(new Font("san-sarif",Font.PLAIN ,18));
        
        //window
         booking = new JFrame("Ticket reservation");
        booking.setSize(540,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        booking.setLocation(dim.width/2-booking.getSize().width/2, dim.height/2-booking.getSize().height/2);
        booking.setLayout(null);
        booking.setResizable(false);
        booking.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //adding labels
        booking.add(F_name);
        booking.add(L_name);
        booking.add(E_mail);
        booking.add(P_mr);
        booking.add(flight);
        booking.add(no);

        //add textfields
        booking.add(F_T);
        booking.add(L_T);
        booking.add(E_T);
        booking.add(P_T);
        booking.add(flig_T);
        booking.add(no_T);

        //add buttons
        booking.add(check_out);
        booking.add(cancle);

        

        //bounds labels
        F_name.setBounds(30, 20, 100, 19);
        L_name.setBounds(30, 80, 100, 19);
        E_mail.setBounds(30, 140, 100, 19);
        P_mr.setBounds(30, 200, 120, 19);
        flight.setBounds(30 ,260 ,120 ,20);
        no.setBounds(30,320 ,100 ,20);

        //bounds textfields
        F_T.setBounds(180, 20, 230, 30);
        L_T.setBounds(180, 80, 230, 30);
        E_T.setBounds(180, 140, 230, 30);
        P_T.setBounds(180, 200, 230, 30);
        flig_T.setBounds(180,260,230,30);
        no_T.setBounds(180 ,320 ,230 ,30);

       //bounds button
       check_out.setBounds(150,380, 120 ,40);
       cancle.setBounds(280,380, 120 ,40);




        booking.setVisible(true);
        
    }
    void conform() throws Exception{
        String full_name = F_T.getText()+" "+L_T.getText();
        String quory = "insert into booking values('"+Integer.parseInt(P_T.getText())+"','"+full_name+"','"+E_T.getText()+"','"
        +flig_T.getText()+"','"+Integer.parseInt(no_T.getText())+"')";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasengers","root","Phe6@nol");
        Statement st = con.createStatement();
        st.executeUpdate(quory);
        con.close();
        st.close();

        JOptionPane.showMessageDialog(booking, "Reservation is confirm", "Ticket status", JOptionPane.PLAIN_MESSAGE );
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==check_out){
        try{
         conform(); 

        F_T.setText("");
        E_T.setText("");
        no_T.setText("");
        flig_T.setText("");
        L_T.setText("");
        P_T.setText("");
        }catch(Exception m){
            JOptionPane.showMessageDialog(booking, "Some thing went wrong","status",JOptionPane.ERROR_MESSAGE);
        }
       }
       
       
    }
    public static Object getSize() {
        return null;
    }
}
