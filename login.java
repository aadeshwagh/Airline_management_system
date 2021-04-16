import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login implements ActionListener{
    JFrame root;
    Choice c;
    JPasswordField pass_T;
    JTextField user_T;
    JButton login;
    login(){
        //choice

        c  = new Choice(); 
        c.add("Staff");
        c.add("Passenger");

        //Buttons
        login = new JButton("Login");
        login.setFont(new Font("san-sarif",Font.PLAIN ,18));
        login.setFocusable(false);
        login.addActionListener(this);

        //Labels

        JLabel user = new JLabel("Username");
        user.setFont(new Font("san-sarif",Font.PLAIN ,18));
        
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("san-sarif",Font.PLAIN ,18));

        JLabel status = new JLabel("Status");
        status.setFont(new Font("san-sarif",Font.PLAIN ,18));

        //Text field
        user_T = new JTextField();
        user_T.setFont(new Font("san-sarif",Font.PLAIN ,18));


        //password field
        pass_T = new JPasswordField();
        pass_T.setFont(new Font("san-sarif",Font.PLAIN ,18));

        //window
        root = new JFrame("Login");
        root.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        root.setSize(400, 300);
        root.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width/2-root.getSize().width/2, dim.height/2-root.getSize().height/2);
        root.setLayout(null);

        
        //adding labels
        root.add(user);
        root.add(pass);
        root.add(status);
        
        //adding textfields
        root.add(user_T);
        root.add(pass_T);

        //adding buttons
        root.add(login);

        root.add(c);

        //set bounds
        user.setBounds(20 , 40 ,100 , 18);
        pass.setBounds(20 , 80 ,100 ,18);
        status.setBounds(20 , 120 ,100 ,18);

        c.setBounds(140 ,120 ,100 ,30);

        user_T.setBounds(140 , 40 ,200 , 30);
        pass_T.setBounds(140 , 80 ,200 ,30);

        login.setBounds(140 ,160 ,100 , 40);

       

        root.setVisible(true);

    }
    void check()throws Exception {
        String username = user_T.getText();
        String passw = "";
        char password[] = pass_T.getPassword();
        for(char c:password){
            passw+=c;
        }
        String url = "jdbc:mysql://localhost:3306/pasengers";
        String uname = "root";
        String pass = "Phe6@nol";
        String query = "SELECT * FROM users WHERE username = ? AND pass = ? AND status = ?" ;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con  = DriverManager.getConnection(url , uname ,pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,username);
        st.setString(2 ,passw);
        st.setString(3 ,c.getItem(c.getSelectedIndex()));
        ResultSet rs = st.executeQuery();
        

        if(rs.next()){
            new main_frame();
                
            root.dispose();
            
        }
        
        else{
            JOptionPane.showMessageDialog(login, "Incorrect password/username", "Login status", JOptionPane.ERROR_MESSAGE) ;
        }
        
       /*
        
        System.out.println(passw);
        
        if(username.equals("aadesh")){
            if(passw.equals("pass@123")){
               
            }
            else{
                JOptionPane.showMessageDialog(login, "Incorrect password", "Login status", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(login, "Incorrect Username", "Login status", JOptionPane.ERROR_MESSAGE);
        }
    
    */
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try{
            check();
            }catch(Exception k){
                JOptionPane.showMessageDialog(login, "Somthing went wrong", "Database error", JOptionPane.ERROR_MESSAGE) ;
            }
            
        }
    }
}