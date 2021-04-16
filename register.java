import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class register implements ActionListener {
    JFrame root;
    JTextField n_t , u_t ,p_t ,i_t;
    JButton regis ,pqr;
    Choice c;
    
    register(){

        //button
        regis = new JButton("Register");
        
        regis.setFont(new Font("san-sarif" , Font.PLAIN ,18));
        regis.setFocusable(false);
        regis.addActionListener(this);

        //Choice
         c  = new Choice(); 
        c.add("Staff");
        c.add("Passenger");
       

        //labels
        JLabel name = new JLabel("Full name :");
        name.setFont(new Font("san-sarif" , Font.PLAIN ,18));

        JLabel user = new JLabel("Username :");
        user.setFont(new Font("san-sarif",Font.PLAIN ,18));
        
        JLabel pass = new JLabel("Password :");
        pass.setFont(new Font("san-sarif",Font.PLAIN ,18));

        JLabel id = new JLabel("PMR no. :");
        id.setFont(new Font("san-sarif",Font.PLAIN ,18));

        JLabel status = new JLabel("Status :");
        status.setFont(new Font("san-sarif",Font.PLAIN ,18));



        //text fields
        n_t = new JTextField();
        n_t.setFont(new Font("san-sarif",Font.PLAIN ,18));

        u_t = new JTextField();
        u_t.setFont(new Font("san-sarif",Font.PLAIN ,18));

        p_t = new JTextField();
        p_t.setFont(new Font("san-sarif",Font.PLAIN ,18));

        i_t = new JTextField();
        i_t.setFont(new Font("san-sarif",Font.PLAIN ,18));

       

        //window
        root = new JFrame("Register");
        root.setSize(450, 350);
        root.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width/2-root.getSize().width/2, dim.height/2-root.getSize().height/2);
        root.setLayout(null);
        
        //add

        root.add(regis);

        
        root.add(c);


        root.add(name);
        root.add(user);
        root.add(pass);
        root.add(id);
        root.add(status);

        root.add(n_t);
        root.add(u_t);
        root.add(p_t);
        root.add(i_t);
        

        //set bounds
        regis.setBounds(150 ,230 , 130 , 30);

        c.setBounds(150 ,170,100,20);
        
        name.setBounds(10,10,100,20);
        user.setBounds(10,50,100,20);
        pass.setBounds(10,90,100,20);
        id.setBounds(10,130,100,20);
        status.setBounds(10,170,100,20);


        n_t.setBounds(150 ,10 ,200 ,30);
        u_t.setBounds(150,50 ,200 ,30);
        p_t.setBounds(150,90 ,200 ,30);
        i_t.setBounds(150,130,200,30);


        root.setVisible(true);
    }
    void new_user(int id , String username , String pass ,String name ,String status )throws Exception{
        String quory = "insert into users values( '"+id+"', '"+username+"','"+pass+"','"+name+"', '"+ status + "')";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasengers", "root", "Phe6@nol");
        Statement st = con.createStatement();

        /*
        st.setInt(1, id);
        st.setString(2, username);
        st.setString(3, pass);
        st.setString(4, name);
        st.setString(5, status);
        */
        st.executeUpdate(quory);
        con.close();
        st.close();
       
           JOptionPane.showMessageDialog(root, "User is registered");
           i_t.setText("");
           u_t.setText("");
           p_t.setText("");
           n_t.setText("");
           
       }


@Override
public void actionPerformed (ActionEvent e){
    if(e.getSource()==regis){
        try{
        new_user(Integer.parseInt(i_t.getText()), u_t.getText(), p_t.getText(), n_t.getText(),c.getItem(c.getSelectedIndex()));
        }catch(Exception q){
           JOptionPane.showMessageDialog(root, "Enter unique PMR no .","error ",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
}
