import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class booking implements ActionListener {
    booking(){
        //Labels
        JLabel name = new JLabel("First name :");
        
        //text field
        JTextField F_name = new JTextField();
        JTextField L_name = new JTextField();
        JTextField email = new JTextField();
        JTextField pmr = new JTextField();
        
        //window
        JFrame booking = new JFrame("Ticket reservation");
        booking.setSize(600,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        booking.setLocation(dim.width/2-booking.getSize().width/2, dim.height/2-booking.getSize().height/2);
        booking.setLayout(null);
        booking.add(name);
        booking.add(F_name);
        booking.setVisible(true);
        booking.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
       
    }
}
