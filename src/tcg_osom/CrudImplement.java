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
    private String sql_select = "select * from account where account_id=?";
    private String sql_add = "insert into account(username, password, email, nickname) VALUES (?,?,?,?)";
    private String sql_update = "update account set password = ? where email = ?";
    private String levelUp = "update account set level=? where account_id=?";
    private String setGold = "update account set gold=? where account_id=?";
    private String setExp = "update account set exp=? where account_id=?";
    private String setGems = "update account set gems=? where account_id=?";
    private String starterDeck = "insert into card (account_id, id_card, card_name, att_power, def_power, card_type, img, highlight, selectImg, rarity) value(?,?,?,?,?,?,?,?,?,?)";
    private String history = "insert into history (p1_card, cpu_card, p1_hp, cpu_hp, win_lose, date, play_time, account_id) value (?,?,?,?,?,?,?,?)";
   
    private final card[] Card = new card[21];
        
    ResultSet rs = null;
    PreparedStatement ps = null;
    @Override
    public void add(Account acc) throws SQLException {
        ps = conn.prepareStatement(sql_add);
        ps.setString(1, acc.getUsername());
        ps.setString(2, acc.getPassword());
        ps.setString(3, acc.getEmail());
        ps.setString(4, acc.getNickname());
        ps.executeUpdate();
        
        String query = "select * from account where username = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, acc.getUsername());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            acc.setUserId(rs.getString("account_id"));
        }
        
        getStarterDeck(acc.getUserId());

    }

    @Override
    public void update(Account acc) throws SQLException {
        ps = conn.prepareStatement(sql_update);
        ps.setString(1, acc.getPassword());
        ps.setString(2, acc.getEmail());
        ps.executeUpdate();
    }

    public void levelUp(int level, String account_id) throws SQLException{
        ps = conn.prepareStatement(levelUp);
        ps.setInt(1, level);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
   public void setGold(int gold, String account_id) throws SQLException{
        ps = conn.prepareStatement(setGold);
        ps.setInt(1, gold);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
   public void setExp(int exp, String account_id) throws SQLException{
        ps = conn.prepareStatement(setExp);
        ps.setInt(1, exp);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
   public void setGems(int gems, String account_id) throws SQLException{
        ps = conn.prepareStatement(setGems);
        ps.setInt(1, gems);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
    public void setRecord(int P1_deck, int Cpu_deck, int healthP1, int healtIVPU, String state, String tanggal, String waktu_maen, String account_id) throws SQLException{
        ps = conn.prepareStatement(history);
        
        ps.setInt(1, P1_deck);
        ps.setInt(2, Cpu_deck);
        ps.setInt(3, healthP1);
        ps.setInt(4, healtIVPU);
        ps.setString(5, state);
        ps.setString(6, tanggal);
        ps.setString(7, waktu_maen);
        ps.setString(8, account_id);
        ps.executeUpdate();
    }
    
    public void getStarterDeck(String account_id) throws SQLException{
        
        ps = conn.prepareStatement(starterDeck);
        Card[0] = new card("IV014.png", "BC014.png", "Cat getting yelled", "batu", 2400, 1000, 14, "A", "DC014.png");
        Card[1] = new card("IV015.png", "BC015.png", "Diccbudd", "kertas", 2300, 1100, 15, "A", "DC015.png");
        Card[2] = new card("IV016.png", "BC016.png", "Think Mark!", "batu", 1500, 900, 16, "B", "DC016.png");
        Card[3] = new card("IV017.png", "BC017.png", "Mark, who can't think", "gunting", 1500, 900, 17, "B", "DC017.png");
        Card[4] = new card("IV018.png", "BC018.png", "The Blurred Girl", "kertas", 1000, 1400, 18, "B", "DC018.png");
        Card[5] = new card("IV019.png", "BC019.png", "The Distracted Guy", "batu", 1100, 1300, 19, "B", "DC019.png");
        Card[6] = new card("IV020.png", "BC020.png", "Angry GF", "gunting", 1200, 1200, 20, "B", "DC020.png");
        Card[7] = new card("IV021.png", "BC021.png", "Lol is u ded?", "kertas", 1200, 1200, 21, "B", "DC021.png");
        Card[8] = new card("IV022.png", "BC022.png", "Ded guy", "batu", 1000, 1500, 22, "B", "DC022.png");
        Card[9] = new card("IV023.png", "BC023.png", "U see that guy?", "gunting", 1500, 700, 23, "B", "DC023.png");
        Card[10] = new card("IV024.png", "BC024.png", "That Guy", "kertas", 1400, 900, 24, "B", "DC024.png");
        Card[11] = new card("IV025.png", "BC025.png", "Now angry guy", "batu", 1600, 500, 25, "B", "DC025.png");
        Card[12] = new card("IV026.png", "BC026.png", "No U", "gunting", 0, 3000, 26, "B", "DC026.png");
        Card[13] = new card("IV027.png", "BC027.png", "Meme Man", "kertas", 1000, 1000, 27, "B", "DC027.png");
        Card[14] = new card("IV028.png", "BC028.png", "Orang Man", "batu", 1000, 1000, 28, "B", "DC028.png");
        Card[15] = new card("IV029.png", "BC029.png", "Ara ara nee-san", "gunting", 1500, 600, 29, "B", "DC029.png");
        Card[16] = new card("IV030.png", "BC030.png", "Shota-kun", "kertas", 1000, 1200, 30, "B", "DC030.png");
        Card[17] = new card("IV031.png", "BC031.png", "Lord Elon", "batu", 1300, 900, 31, "B", "DC031.png");
        Card[18] = new card("IV032.png", "BC032.png", "Elons Dolphin.exe", "gunting", 900, 1300, 32, "B", "DC032.png");
        Card[19] = new card("IV033.png", "BC033.png", "Lord Zucc", "kertas", 2700, 0, 33, "B", "DC033.png");
      
        for(int i = 0; i<20; i++){
            ps.setString(1, account_id);
            ps.setInt(2, Card[i].getId_card());
            ps.setString(3, Card[i].getName());
            ps.setInt(4, Card[i].getAttack());
            ps.setInt(5, Card[i].getDefence());
            ps.setString(6, Card[i].getType());
            ps.setString(7, Card[i].getImage());
            ps.setString(8, Card[i].getHighlight());
            ps.setString(9, Card[i].getSelectImg());
            ps.setString(10, Card[i].getRarity());
            ps.executeUpdate();
        }
    }
}
