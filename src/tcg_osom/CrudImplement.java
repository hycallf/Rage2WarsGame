/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;
import java.sql.*;
/**
 *
 * @author KuroNeko
 */
public class CrudImplement implements CrudInterface{
    static Connection conn = DBConnection.config();
   
    
    @Override
    public void add(Account acc) throws SQLException {
        String query = "insert into account(username, password, email, nickname) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, acc.getUsername());
        ps.setString(2, acc.getPassword());
        ps.setString(3, acc.getEmail());
        ps.setString(4, acc.getNickname());
        ps.executeUpdate();

    }

    @Override
    public void update(Account acc) throws SQLException {
        String query = "update account set password = ? where email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, acc.getPassword());
        ps.setString(2, acc.getEmail());
        ps.executeUpdate();
    }
    
}
