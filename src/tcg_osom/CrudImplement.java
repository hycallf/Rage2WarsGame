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
    private String sql_login = "select from account where username = ? and password =?";
    private String get_user = "select * from account where username = ?";
   
    
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
    
    @Override
    public String login(String user, String pass) throws SQLException {
        String username = null;
        PreparedStatement ps = conn.prepareStatement(sql_login);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs;
        rs = ps.executeQuery();
        
        while(rs.next()){
            Menu menu = new Menu();
            menu.setVisible(true);
            username = user;
        }
        return username;
    }

    public Account getUser(String user) throws SQLException {
        ResultSet rs = null;
        
        try{
            PreparedStatement ps = conn.prepareStatement(get_user);
            ps.setString(1, user);
            rs = ps.executeQuery();
            Account acc = null;
            if(rs.next()){
                acc = new Account();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setEmail(rs.getString("email"));
                acc.setNickname(rs.getString("nickname"));
                acc.setExp(rs.getInt("level"));
                acc.setGold(rs.getInt("gold"));
                acc.setGems(rs.getInt("gems"));
            
            }
            return acc;
        }
        catch(SQLException e){
            throw e;
        }
       
        
    }
    
}
