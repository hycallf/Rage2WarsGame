package tcg_osom;

import java.sql.*;
import javax.swing.JOptionPane;
 
public class DBConnection {
    private static Connection conn = null;
    
    public static Connection config(){
        String url = "jdbc:mysql:// localhost:3306/tcg_osom";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
        } 
        catch (ClassNotFoundException  | SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
        
        return conn;
    }
}