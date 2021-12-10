import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class show_reservations implements ActionListener {
    JFrame root;
    JTextField pnr_T;
    JButton display, displayAll;
    JTable table;

    show_reservations() {

        // Jtable

        table = new JTable();
        table.setFont(new Font("san-sarif", Font.PLAIN, 18));

        JScrollPane sp = new JScrollPane(table);

        // labels
        JLabel pnr = new JLabel("PNR NO :");

        pnr.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // text fields
        pnr_T = new JTextField();

        pnr_T.setFont(new Font("san-sarif", Font.PLAIN, 17));

        // buttons
        display = new JButton("Display");
        display.setFocusable(false);
        display.setFont(new Font("san-sarif", Font.PLAIN, 18));
        display.addActionListener(this);

        displayAll = new JButton("Display all");
        displayAll.setFocusable(false);
        displayAll.addActionListener(this);
        displayAll.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // main window
        root = new JFrame("Passenger reservations");
        root.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        root.setSize(600, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width / 2 - root.getSize().width / 2, dim.height / 2 - root.getSize().height / 2);
        root.setLayout(null);
        root.setResizable(false);

        // add
        root.add(pnr);
        root.add(pnr_T);
        root.add(display);
        root.add(displayAll);
        root.add(table);
        root.add(sp);

        // set bounds
        pnr.setBounds(10, 30, 100, 19);
        pnr_T.setBounds(120, 30, 200, 30);
        display.setBounds(130, 70, 130, 30);
        displayAll.setBounds(265, 70, 130, 30);
        table.setBounds(10, 130, 560, 400);

        root.setVisible(true);
    }

    void show_data() throws Exception {
        String url = "jdbc:mysql://localhost:3306/pasengers";
        String uname = "root";
        String pass = "<password>";
        String query = "SELECT * FROM booking";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    void show_data(String pnr_no) throws Exception {
        String url = "jdbc:mysql://localhost:3306/pasengers";
        String uname = "root";
        String pass = "<password>";
        String query = "SELECT * FROM booking where id=?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, pnr_no);
        ResultSet rs = st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {
            try {
                show_data(pnr_T.getText());
            } catch (Exception p) {
                System.out.println("Wrong");
            }
        }
        if (e.getSource() == displayAll) {
            try {
                show_data();
            } catch (Exception p) {
                System.out.println("Wrong");
            }
        }
    }
}
