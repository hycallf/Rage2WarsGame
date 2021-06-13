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
    static Connection conn = Database.config();
    private String sql_add = "insert into account(username, password, email, nickname) VALUES (?,?,?,?)";
    private String sql_update = "update account set password = ? where email = ?";
   
    
    @Override
    public void add(Account acc) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql_add);
        ps.setString(1, acc.getUsername());
        ps.setString(2, acc.getPassword());
        ps.setString(3, acc.getEmail());
        ps.setString(4, acc.getNickname());
        ps.executeUpdate();

    }

    @Override
    public void update(Account acc) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql_update);
        ps.setString(1, acc.getPassword());
        ps.setString(2, acc.getEmail());
        ps.executeUpdate();
    }

    
}
