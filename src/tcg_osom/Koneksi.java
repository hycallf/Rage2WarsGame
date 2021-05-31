package tcg_osom;

import java.sql.*;
import javax.swing.JOptionPane;
 
public class Koneksi {
    Connection conn;
    Statement stat;
    
    public Connection config(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/tcg_osom", "root", "");
            stat = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
        
        return conn;
    }
}