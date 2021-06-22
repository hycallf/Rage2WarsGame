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
        setDefaultDeck(acc.getUserId());

    }

    @Override
    public void update(Account acc) throws SQLException {
        ps = conn.prepareStatement(sql_update);
        ps.setString(1, acc.getPassword());
        ps.setString(2, acc.getEmail());
        ps.executeUpdate();
    }

    @Override
    public void levelUp(int level, String account_id) throws SQLException{
        ps = conn.prepareStatement(levelUp);
        ps.setInt(1, level);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
    @Override
   public void setGold(int gold, String account_id) throws SQLException{
        ps = conn.prepareStatement(setGold);
        ps.setInt(1, gold);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    @Override
   public void setExp(int exp, String account_id) throws SQLException{
        ps = conn.prepareStatement(setExp);
        ps.setInt(1, exp);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    @Override
   public void setGems(int gems, String account_id) throws SQLException{
        ps = conn.prepareStatement(setGems);
        ps.setInt(1, gems);
        ps.setString(2, account_id);
        ps.executeUpdate();
    }
    
    public void setRecord(int P1_deck, int Cpu_deck, int healthP1, int healthCPU, String state, String tanggal, String waktu_maen, String account_id) throws SQLException{
        ps = conn.prepareStatement(history);
        
        ps.setInt(1, P1_deck);
        ps.setInt(2, Cpu_deck);
        ps.setInt(3, healthP1);
        ps.setInt(4, healthCPU);
        ps.setString(5, state);
        ps.setString(6, tanggal);
        ps.setString(7, waktu_maen);
        ps.setString(8, account_id);
        ps.executeUpdate();
    }
    
    public void getStarterDeck(String account_id) throws SQLException{
        Card[0] = new card("IV014.png", "HC014.png", "BC014.png", "Cat getting yelled", "batu", 2400, 1000, 14, "A", "DC014.png");
        Card[1] = new card("IV015.png", "HC015.png", "BC015.png", "Diccbudd", "kertas", 2300, 1100, 15, "A", "DC015.png");
        Card[2] = new card("IV016.png", "HC016.png", "BC016.png", "Think Mark!", "batu", 1500, 900, 16, "B", "DC016.png");
        Card[3] = new card("IV017.png", "HC017.png", "BC017.png", "Mark, who can't think", "gunting", 1500, 900, 17, "B", "DC017.png");
        Card[4] = new card("IV018.png", "HC018.png", "BC018.png", "The Blurred Girl", "kertas", 1000, 1400, 18, "B", "DC018.png");
        Card[5] = new card("IV019.png", "HC019.png", "BC019.png", "The Distracted Guy", "batu", 1100, 1300, 19, "B", "DC019.png");
        Card[6] = new card("IV020.png", "HC020.png", "BC020.png", "Angry GF", "gunting", 1200, 1200, 20, "B", "DC020.png");
        Card[7] = new card("IV021.png", "HC021.png", "BC021.png", "Lol is u ded?", "kertas", 1200, 1200, 21, "B", "DC021.png");
        Card[8] = new card("IV022.png", "HC022.png", "BC022.png", "Ded guy", "batu", 1000, 1500, 22, "B", "DC022.png");
        Card[9] = new card("IV023.png", "HC023.png", "BC023.png", "U see that guy?", "gunting", 1500, 700, 23, "B", "DC023.png");
        Card[10] = new card("IV024.png", "HC024.png", "BC024.png", "That Guy", "kertas", 1400, 900, 24, "B", "DC024.png");
        Card[11] = new card("IV025.png", "HC025.png", "BC025.png", "Now angry guy", "batu", 1600, 500, 25, "B", "DC025.png");
        Card[12] = new card("IV026.png", "HC026.png", "BC026.png", "No U", "gunting", 0, 3000, 26, "B", "DC026.png");
        Card[13] = new card("IV027.png", "HC027.png", "BC027.png", "Meme Man", "kertas", 1000, 1000, 27, "B", "DC027.png");
        Card[14] = new card("IV028.png", "HC028.png", "BC028.png", "Orang Man", "batu", 1000, 1000, 28, "B", "DC028.png");
        Card[15] = new card("IV029.png", "HC029.png", "BC029.png", "Ara ara nee-san", "gunting", 1500, 600, 29, "B", "DC029.png");
        Card[16] = new card("IV030.png", "HC030.png", "BC030.png", "Shota-kun", "kertas", 1000, 1200, 30, "B", "DC030.png");
        Card[17] = new card("IV031.png", "HC031.png", "BC031.png", "Lord Elon", "batu", 1300, 900, 31, "B", "DC031.png");
        Card[18] = new card("IV032.png", "HC032.png", "BC032.png", "Elons Dolphin.exe", "gunting", 900, 1300, 32, "B", "DC032.png");
        Card[19] = new card("IV033.png", "HC033.png", "BC033.png", "Lord Zucc", "kertas", 2700, 0, 33, "B", "DC033.png");
        
        String starterDeck = "insert into card (account_id, id_card, card_name, att_power, def_power, card_type, img, hand_card, highlight, selectImg, rarity) value(?,?,?,?,?,?,?,?,?,?,?)";
        
        ps = conn.prepareStatement(starterDeck);
        for(int i = 0; i<20; i++){
            ps.setString(1, account_id);
            ps.setInt(2, Card[i].getId_card());
            ps.setString(3, Card[i].getName());
            ps.setInt(4, Card[i].getAttack());
            ps.setInt(5, Card[i].getDefence());
            ps.setString(6, Card[i].getType());
            ps.setString(7, Card[i].getImage());
            ps.setString(8, Card[i].getHand_card());
            ps.setString(9, Card[i].getHighlight());
            ps.setString(10, Card[i].getSelectImg());
            ps.setString(11, Card[i].getRarity());
            ps.executeUpdate();
        }

    }
    
    public void setDefaultDeck(String account_id) throws SQLException{
        String defaultDeck = "insert into deck(id_card, account_id, card_name, att_power, def_power, card_type, battle_card, hand_card) values(?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(defaultDeck);
        for(int a = 0; a<20; a++){
            ps.setInt(1, a+1);
            ps.setString(2, account_id);
            ps.setString(3, Card[a].getName());
            ps.setInt(4, Card[a].getAttack());
            ps.setInt(5, Card[a].getDefence());
            ps.setString(6, Card[a].getType());
            ps.setString(7, Card[a].getHighlight());
            ps.setString(8, Card[a].getHand_card());
            
            ps.executeUpdate();
        }
    }
}
