import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class welcome_window implements ActionListener{
    JButton login ,reg;
    JFrame root;
    welcome_window(){
        
        //Labels
        JLabel name = new JLabel();
        name.setText("WELCOME TO AIR INDIA");
        name.setFont(new Font(name.getName(),Font.PLAIN, 40));
        
        JLabel info = new JLabel();
        info.setText("PLEASE LOGIN FOR TO PROCEED");
        info.setFont(new Font(info.getName(),Font.PLAIN,20));

        JLabel img = new JLabel(new ImageIcon("background.jpg"));
        
        
        
        //button
        login = new JButton("Login");
        login.addActionListener(this);
        login.setFocusable(false);
        login.setFont(new Font("san-sarif" , Font.PLAIN ,18));


        reg  = new JButton("Register");
        reg.addActionListener(this);
        reg.setFocusable(false);
        reg.setFont(new Font("san-sarif",Font.PLAIN ,17));

        
        
       

       
        //main window
        root = new JFrame("Airline management system");
        root.add(name);
        root.add(info);
        root.add(login);
        root.add(reg);
        root.add(img);
        
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setLayout(null);

        //set bounds
        name.setBounds(550,20,700,40);
        info.setBounds(600, 90, 700, 20);
        login.setBounds(660, 140, 100, 40);
        reg.setBounds(770 ,140,100,40);

        img.setBounds(430 ,160 ,700,700);


        root.setVisible(true);
    
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            new login();
            
        }
        if(e.getSource()==reg){
            new register();
        }
    }
}
