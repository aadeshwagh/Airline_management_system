import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_frame implements ActionListener {
    JFrame root;
    JMenuItem book , cancle , flig_info;

    main_frame(){

        //Menu Items
         book = new JMenuItem("Book Ticket");
         cancle = new JMenuItem("Cancel Ticket");
         flig_info = new JMenuItem("Flight info");
         book.addActionListener(this);

         //Menu
         JMenu Ticket = new JMenu("Ticket");
         JMenu flight = new JMenu("Flight");
         Ticket.add(book);
         Ticket.add(cancle);
         flight.add(flig_info);
         

        //Menu bar
        JMenuBar menu_bar = new JMenuBar();
        menu_bar.add(Ticket);
        menu_bar.add(flight);
       
        //Background image 
        JLabel background = new JLabel(new ImageIcon("254361.jpg"));

        //Main window
        root = new JFrame("Airline management System");
        root.add(background);
        root.setJMenuBar(menu_bar);
        root.setVisible(true);
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setLayout(new GridLayout());
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==book){
            new booking();

        }
    }
}
