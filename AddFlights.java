import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddFlights implements ActionListener {
    JFrame root;
    JTextField src_T, desti_T, flight_T;
    JButton add;
    JTable table;

    AddFlights() {

        // labels
        JLabel src = new JLabel("Source :");
        JLabel desti = new JLabel("Destination:");
        JLabel Flight_no = new JLabel("Flight no :");

        src.setFont(new Font("san-sarif", Font.PLAIN, 18));
        desti.setFont(new Font("san-sarif", Font.PLAIN, 18));
        Flight_no.setFont(new Font("san-sarif", Font.PLAIN, 18));

        // text fields
        src_T = new JTextField();
        desti_T = new JTextField();
        flight_T = new JTextField();

        src_T.setFont(new Font("san-sarif", Font.PLAIN, 17));
        desti_T.setFont(new Font("san-sarif", Font.PLAIN, 17));
        flight_T.setFont(new Font("san-sarif", Font.PLAIN, 17));

        // buttons
        add = new JButton("add");
        add.setFocusable(false);
        add.setFont(new Font("san-sarif", Font.PLAIN, 18));
        add.addActionListener(this);

        // main window
        root = new JFrame("Add flights");
        root.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        root.setSize(400, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width / 2 - root.getSize().width / 2, dim.height / 2 - root.getSize().height / 2);
        root.setLayout(null);
        root.setResizable(false);

        // add
        root.add(src);
        root.add(desti);
        root.add(src_T);
        root.add(desti_T);
        root.add(Flight_no);
        root.add(flight_T);
        root.add(add);

        // set bounds
        src.setBounds(10, 30, 100, 19);
        src_T.setBounds(120, 30, 200, 30);
        desti.setBounds(10, 80, 110, 19);
        desti_T.setBounds(120, 80, 200, 30);
        Flight_no.setBounds(10, 130, 110, 19);
        flight_T.setBounds(120, 130, 200, 30);
        add.setBounds(140, 180, 70, 30);

        root.setVisible(true);
    }

    void Add(String src, String desti, String fno) throws Exception {
        String query = "insert into flights values(?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasengers", "root", "<password>");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, src);
        st.setString(2, desti);
        st.setString(3, fno);
        st.executeUpdate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            try {
                Add(src_T.getText(), desti_T.getText(), flight_T.getText());
            } catch (Exception p) {
                System.out.println("Database error in addflights class");

            } finally {
                src_T.setText("");
                desti_T.setText("");
                flight_T.setText("");

                JOptionPane.showMessageDialog(root, "Flight added successfully", "status", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
