import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class staff_window implements ActionListener {
    JFrame root, can_win;
    JMenuItem book, cancle, flig_info, add_flight, show_res;
    JButton cancle_tic;
    JTextField P_T;

    staff_window() {

        // Menu Items
        book = new JMenuItem("Book Ticket");
        cancle = new JMenuItem("Cancel Ticket");
        flig_info = new JMenuItem("Flight info");
        book.addActionListener(this);
        cancle.addActionListener(this);
        add_flight = new JMenuItem("Add flight");
        show_res = new JMenuItem("Reservations");
        add_flight.addActionListener(this);
        show_res.addActionListener(this);
        flig_info.addActionListener(this);

        // Menu
        JMenu Ticket = new JMenu("Ticket");
        JMenu flight = new JMenu("Flight");
        JMenu pasenger = new JMenu("Passengers");
        Ticket.add(book);
        Ticket.add(cancle);
        flight.add(flig_info);
        flight.add(add_flight);
        pasenger.add(show_res);

        // Menu bar
        JMenuBar menu_bar = new JMenuBar();
        menu_bar.add(Ticket);
        menu_bar.add(flight);
        menu_bar.add(pasenger);

        // Background image
        JLabel background = new JLabel(new ImageIcon("254361.jpg"));

        // Main window
        root = new JFrame("Airline management System");
        root.add(background);
        root.setJMenuBar(menu_bar);
        root.setVisible(true);
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setLayout(new GridLayout());
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    void cancle_ticket_window() {
        // label
        JLabel pmr = new JLabel("PMR no. :");

        // JField

        P_T = new JTextField();
        P_T.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // button
        cancle_tic = new JButton("Procced");
        cancle_tic.setFocusable(false);
        cancle_tic.setFont(new Font("san-sarif", Font.PLAIN, 18));
        cancle_tic.addActionListener(this);

        can_win = new JFrame("Cancel reservation");
        can_win.setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        can_win.setLocation(dim.width / 2 - can_win.getSize().width / 2, dim.height / 2 - can_win.getSize().height / 2);
        can_win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        can_win.setLayout(null);

        can_win.add(pmr);
        can_win.add(P_T);
        can_win.add(cancle_tic);

        pmr.setBounds(10, 20, 100, 18);
        P_T.setBounds(120, 20, 200, 30);
        cancle_tic.setBounds(120, 70, 130, 30);

        can_win.setVisible(true);

    }

    void delete_row() throws Exception {
        int p = Integer.parseInt(P_T.getText());
        String quory = "delete from booking where id = '" + p + "' ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasengers", "root", "<password>");
        Statement st = con.createStatement();
        st.executeUpdate(quory);

        JOptionPane.showMessageDialog(can_win, "Reservation is cancel succefully", "status",
                JOptionPane.INFORMATION_MESSAGE);
        P_T.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == book) {
            new booking();

        }
        if (e.getSource() == cancle) {
            cancle_ticket_window();
        }
        if (e.getSource() == cancle_tic) {
            try {
                delete_row();
            } catch (Exception p) {
                JOptionPane.showMessageDialog(can_win, "Somthing went wrong", "database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == flig_info) {
            new Flight_info();
        }
        if (e.getSource() == show_res) {
            new show_reservations();
        }
        if (e.getSource() == add_flight) {
            new AddFlights();
        }
    }
}
