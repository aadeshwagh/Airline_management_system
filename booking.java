import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class booking implements ActionListener {
    JButton check_out,cancle;
    JTextField F_T,L_T,E_T,P_T,flig_T;
    booking(){
        //Labels
        JLabel F_name = new JLabel("First name :");
        JLabel L_name = new JLabel("Last name :");
        JLabel E_mail = new JLabel("Email ID :");
        JLabel P_mr = new JLabel("PMR number :");
        JLabel flight = new JLabel("Flight number:");

        F_name.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        L_name.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        E_mail.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        P_mr.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        flight.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        
        //text field
        F_T = new JTextField();
        L_T = new JTextField();
        E_T = new JTextField();
        P_T = new JTextField();
        flig_T = new JTextField();

        F_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        L_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        E_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        P_T.setFont(new Font("san-sarif",Font.PLAIN,17));
        flig_T.setFont(new Font("san-sarif",Font.PLAIN,17));

        //button
        check_out = new JButton("Check out");
        check_out.setFocusable(false);
        check_out.setFont(new Font("san-sarif",Font.PLAIN ,18));
        check_out.addActionListener(this);

        cancle = new JButton("Cancle");
        cancle.setFocusable(false);
        cancle.addActionListener(this);
        cancle.setFont(new Font("san-sarif",Font.PLAIN ,18));
        
        //window
        JFrame booking = new JFrame("Ticket reservation");
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

        //add textfields
        booking.add(F_T);
        booking.add(L_T);
        booking.add(E_T);
        booking.add(P_T);
        booking.add(flig_T);

        //add buttons
        booking.add(check_out);
        booking.add(cancle);

        

        //bounds labels
        F_name.setBounds(30, 20, 100, 19);
        L_name.setBounds(30, 80, 100, 19);
        E_mail.setBounds(30, 140, 100, 19);
        P_mr.setBounds(30, 200, 120, 19);
        flight.setBounds(30 ,260 ,120 ,20);

        //bounds textfields
        F_T.setBounds(180, 20, 230, 30);
        L_T.setBounds(180, 80, 230, 30);
        E_T.setBounds(180, 140, 230, 30);
        P_T.setBounds(180, 200, 230, 30);
        flig_T.setBounds(180,260,230,30);

       //bounds button
       check_out.setBounds(150,350, 120 ,40);
       cancle.setBounds(280,350, 120 ,40);




        booking.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
       
    }
}
