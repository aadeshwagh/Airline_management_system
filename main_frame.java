import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_frame implements ActionListener {
    JFrame root;
    JMenuItem book , cancle;

    main_frame(){

        //Menu Items
         book = new JMenuItem("Book Ticket");
         cancle = new JMenuItem("Cancle Ticket");
         book.addActionListener(this);

         //Menu
         JMenu Ticket = new JMenu("Ticket");
         Ticket.add(book);
         Ticket.add(cancle);
         

        //Menu bar
        JMenuBar menu_bar = new JMenuBar();
        menu_bar.add(Ticket);
       
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
