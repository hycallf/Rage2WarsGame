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
//    String account_id = tcg_osom.Database.getUserId();
    
    private String sql_add = "insert into account(username, password, email, nickname) VALUES (?,?,?,?)";
    private String sql_update = "update account set password = ? where email = ?";
    private String levelUp = "update account set level=? where account_id=?";
    private String setGold = "update account set gold=? where account_id=?";
    private String setExp = "update account set exp=? where account_id=?";
    private String setGems = "update account set gems=? where account_id=?";
    private String history = "insert into history (p1_card, cpu_card, p1_hp, cpu_hp, win_lose, date, play_time, account_id) value (?,?,?,?,?,?,?,?)";
   
    
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

    public void levelUp(int level, String account_id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(levelUp);
        ps.setInt(1, level);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
   public void setGold(int gold, String account_id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(setGold);
        ps.setInt(1, gold);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
   public void setExp(int exp, String account_id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(setExp);
        ps.setInt(1, exp);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
   public void setGems(int gems, String account_id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(setGems);
        ps.setInt(1, gems);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
    public void setRecord(int P1_deck, int Cpu_deck, int healthP1, int healthCPU, String state, String tanggal, String waktu_maen, String account_id) throws SQLException{
        PreparedStatement pst = conn.prepareStatement(history);
        pst.setInt(1, P1_deck);
        pst.setInt(2, Cpu_deck);
        pst.setInt(3, healthP1);
        pst.setInt(4, healthCPU);
        pst.setString(5, state);
        pst.setString(6, tanggal);
        pst.setString(7, waktu_maen);
        pst.setString(8, account_id);
        pst.executeUpdate();
    }
}
