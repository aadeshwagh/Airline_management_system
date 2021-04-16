
import java.sql.*;

public class scratch {
    public static void main(String arges[]) throws Exception {
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasengers", "root", "Phe6@nol");
        PreparedStatement st = con.prepareStatement("insert into users(id ,username ,pass ,full_name ,status) values(? ,? ,? ,? ,?");
        st.setInt(1, 174);
        st.setString(2, "sswagh");
        st.setString(3, "swagh");
        st.setString(4, "Shivani wagh");
        st.setString(5, "staff");
        st.executeUpdate();

       // System.out.println(rs.getString(username));

       

    }
 }

