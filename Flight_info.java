import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.util.*;

public class Flight_info implements ActionListener {
    JFrame root;
    JTextField src_T, desti_T;
    JButton display, displayAll;
    JTable table;

    Flight_info() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Source");
        names.add("Destination");
        names.add("Flight No");

        // Jtable

        table = new JTable();
        table.setFont(new Font("san-sarif", Font.PLAIN, 18));

        JScrollPane sp = new JScrollPane(table);

        // labels
        JLabel src = new JLabel("Source :");
        JLabel desti = new JLabel("Destination:");

        JLabel src_t = new JLabel(names.get(0));
        JLabel desti_t = new JLabel(names.get(1));
        JLabel flight_no = new JLabel(names.get(2));

        src_t.setFont(new Font("san-sarif", Font.PLAIN, 18));
        desti_t.setFont(new Font("san-sarif", Font.PLAIN, 18));
        flight_no.setFont(new Font("san-sarif", Font.PLAIN, 18));

        src.setFont(new Font("san-sarif", Font.PLAIN, 18));
        desti.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // text fields
        src_T = new JTextField();
        desti_T = new JTextField();

        src_T.setFont(new Font("san-sarif", Font.PLAIN, 17));
        desti_T.setFont(new Font("san-sarif", Font.PLAIN, 17));

        // buttons
        display = new JButton("display");
        display.setFocusable(false);
        display.setFont(new Font("san-sarif", Font.PLAIN, 18));
        display.addActionListener(this);

        displayAll = new JButton("All Flights");
        displayAll.setFocusable(false);
        displayAll.addActionListener(this);
        displayAll.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // main window
        root = new JFrame("Flights information");
        root.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        root.setSize(600, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width / 2 - root.getSize().width / 2, dim.height / 2 - root.getSize().height / 2);
        root.setLayout(null);
        root.setResizable(false);

        // add
        root.add(src);
        root.add(desti);
        root.add(src_T);
        root.add(desti_T);
        root.add(display);
        root.add(displayAll);
        root.add(src_t);
        root.add(desti_t);
        root.add(flight_no);
        root.add(table);
        root.add(sp);

        // set bounds
        src.setBounds(10, 30, 100, 19);
        src_T.setBounds(120, 30, 130, 30);
        desti.setBounds(270, 30, 110, 19);
        desti_T.setBounds(390, 30, 130, 30);
        display.setBounds(150, 70, 110, 30);
        displayAll.setBounds(265, 70, 110, 30);
        src_t.setBounds(10, 100, 100, 30);
        desti_t.setBounds(170, 100, 100, 30);
        flight_no.setBounds(330, 100, 100, 30);
        table.setBounds(10, 130, 560, 400);

        root.setVisible(true);

    }

    void show_data(String src, String desti) throws Exception {
        String url = "jdbc:mysql://localhost:3306/pasengers";
        String uname = "root";
        String pass = "<password>";
        String query = "SELECT * FROM flights WHERE src = ? AND desti = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, src);
        st.setString(2, desti);
        ResultSet rs = st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    void show_data() throws Exception {
        String url = "jdbc:mysql://localhost:3306/pasengers";
        String uname = "root";
        String pass = "<password>";
        String query = "SELECT * FROM flights";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {
            try {
                show_data(src_T.getText(), desti_T.getText());
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
