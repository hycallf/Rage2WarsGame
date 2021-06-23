/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KuroNeko
 */
public class Deck extends javax.swing.JFrame {
    
    
    Account acc = new Account();
    CrudImplement cli = new CrudImplement();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    String account_id;
    
    private card[] deck = new card[20];
    private card inven_card;
    private ArrayList<card> inventory = new ArrayList<>();
    int index;
    int selectCard;

    /**
     * Creates new form Deck
     */
    public Deck() {
        initComponents();
        account_id = tcg_osom.Database.getUserId();
        getInventory();
        showInventory();
        defaultImage();
        defaultDeck();

    }

//    private boolean checkDeck(){
//        conn = Database.config();
//        String query = "select * from deck where account_id = ?";
//        boolean checkDeck = false;
//        try {
//            pst = conn.prepareStatement(query);
//            pst.setString(1,account_id);
//            rs = pst.executeQuery();
//            if(rs.next()){
//                checkDeck = true;
//            }
//        }
//        catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return checkDeck;
//    }
    
    private void getInventory(){
        conn = Database.config();
        String query = "select * from card where account_id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,account_id);
            rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                inven_card = new card(rs.getString("img"), rs.getString("hand_card"), rs.getString("highlight"), rs.getString("card_name"),rs.getString("card_type"), rs.getInt("att_power"), rs.getInt("def_power"), rs.getInt("id_card"), rs.getString("rarity"), rs.getString("selectImg"));
                inventory.add(inven_card);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void defaultDeck(){
        conn = Database.config();
        String query = "select * from deck where account_id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,account_id);
            rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                deck[i] = new card(rs.getString("hand_card"), rs.getString("battle_card"), rs.getString("card_name"),rs.getString("card_type"), rs.getInt("att_power"), rs.getInt("def_power"));
                i++;
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void showInventory(){
        inven1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(0).getImage())));
        inven2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(1).getImage())));
        inven3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(2).getImage())));
        inven4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(3).getImage())));
        inven5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(4).getImage())));
        inven6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(5).getImage())));
        inven7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(6).getImage())));
        inven8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(7).getImage())));
        inven9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(8).getImage())));
        inven10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(9).getImage())));
        inven11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(10).getImage())));
        inven12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(11).getImage())));
        inven13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(12).getImage())));
        inven14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(13).getImage())));
        inven15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(14).getImage())));
        inven16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(15).getImage())));
        inven17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(16).getImage())));
        inven18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(17).getImage())));
        inven19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(18).getImage())));
        inven20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckThumbs/"+inventory.get(19).getImage())));
    }
    private void defaultImage(){
        btnDeck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        btnDeck20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        
    }
    private void getSelectedCard(int selectCard, card inven_card){
        if(index == 0){
            deck[index] = inven_card;
            btnDeck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 1){
            deck[index] = inven_card;
            btnDeck2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 2){
            deck[index] = inven_card;
            btnDeck3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 3){
            deck[index] = inven_card;
            btnDeck4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 4){
            deck[index] = inven_card;
            btnDeck5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 5){
            deck[index] = inven_card;
            btnDeck6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 6){
            deck[index] = inven_card;
            btnDeck7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 7){
            deck[index] = inven_card;
            btnDeck8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 8){
            deck[index] = inven_card;
            btnDeck9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 9){
            deck[index] = inven_card;
            btnDeck10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 10){
            deck[index] = inven_card;
            btnDeck11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 11){
           deck[index] = inven_card;
            btnDeck12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 12){
            deck[index] = inven_card;
            btnDeck13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 13){
            deck[index] = inven_card;
            btnDeck14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 14){
            deck[index] = inven_card;
            btnDeck15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 15){
            deck[index] = inven_card;
            btnDeck16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 16){
            deck[index] = inven_card;
            btnDeck17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 17){
            deck[index] = inven_card;
            btnDeck18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 18){
            deck[index] = inven_card;
            btnDeck19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        else if(index == 19){
            deck[index] = inven_card;
            btnDeck20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShow/"+inventory.get(selectCard).getSelectImg())));
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Deck = new javax.swing.JPanel();
        btnDeck1 = new javax.swing.JButton();
        btnDeck2 = new javax.swing.JButton();
        btnDeck3 = new javax.swing.JButton();
        btnDeck4 = new javax.swing.JButton();
        btnDeck5 = new javax.swing.JButton();
        btnDeck6 = new javax.swing.JButton();
        btnDeck7 = new javax.swing.JButton();
        btnDeck8 = new javax.swing.JButton();
        btnDeck9 = new javax.swing.JButton();
        btnDeck10 = new javax.swing.JButton();
        btnDeck11 = new javax.swing.JButton();
        btnDeck12 = new javax.swing.JButton();
        btnDeck13 = new javax.swing.JButton();
        btnDeck14 = new javax.swing.JButton();
        btnDeck15 = new javax.swing.JButton();
        btnDeck16 = new javax.swing.JButton();
        btnDeck17 = new javax.swing.JButton();
        btnDeck18 = new javax.swing.JButton();
        btnDeck19 = new javax.swing.JButton();
        btnDeck20 = new javax.swing.JButton();
        btnSetDeck = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        inven1 = new javax.swing.JButton();
        inven2 = new javax.swing.JButton();
        inven4 = new javax.swing.JButton();
        inven3 = new javax.swing.JButton();
        inven5 = new javax.swing.JButton();
        inven6 = new javax.swing.JButton();
        inven7 = new javax.swing.JButton();
        inven8 = new javax.swing.JButton();
        inven9 = new javax.swing.JButton();
        inven10 = new javax.swing.JButton();
        inven11 = new javax.swing.JButton();
        inven12 = new javax.swing.JButton();
        inven13 = new javax.swing.JButton();
        inven14 = new javax.swing.JButton();
        inven15 = new javax.swing.JButton();
        inven16 = new javax.swing.JButton();
        inven17 = new javax.swing.JButton();
        inven18 = new javax.swing.JButton();
        inven19 = new javax.swing.JButton();
        inven20 = new javax.swing.JButton();
        inven21 = new javax.swing.JButton();
        inven22 = new javax.swing.JButton();
        inven23 = new javax.swing.JButton();
        inven24 = new javax.swing.JButton();
        inven25 = new javax.swing.JButton();
        inven26 = new javax.swing.JButton();
        inven27 = new javax.swing.JButton();
        inven28 = new javax.swing.JButton();
        inven29 = new javax.swing.JButton();
        inven30 = new javax.swing.JButton();
        inven31 = new javax.swing.JButton();
        inven32 = new javax.swing.JButton();
        inven33 = new javax.swing.JButton();
        inven34 = new javax.swing.JButton();
        inven35 = new javax.swing.JButton();
        inven36 = new javax.swing.JButton();
        inven37 = new javax.swing.JButton();
        inven38 = new javax.swing.JButton();
        inven39 = new javax.swing.JButton();
        inven40 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        toggleCard = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 720));

        Deck.setBackground(new java.awt.Color(153, 153, 153));

        btnDeck1.setBorder(null);
        btnDeck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck1MouseReleased(evt);
            }
        });

        btnDeck2.setBorder(null);
        btnDeck2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck2MouseReleased(evt);
            }
        });

        btnDeck3.setBorder(null);
        btnDeck3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck3MouseReleased(evt);
            }
        });

        btnDeck4.setBorder(null);
        btnDeck4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck4MouseReleased(evt);
            }
        });

        btnDeck5.setBorder(null);
        btnDeck5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck5MouseReleased(evt);
            }
        });

        btnDeck6.setBorder(null);
        btnDeck6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck6MouseReleased(evt);
            }
        });

        btnDeck7.setBorder(null);
        btnDeck7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck7MouseReleased(evt);
            }
        });

        btnDeck8.setBorder(null);
        btnDeck8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck8MouseReleased(evt);
            }
        });

        btnDeck9.setBorder(null);
        btnDeck9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck9MouseReleased(evt);
            }
        });

        btnDeck10.setBorder(null);
        btnDeck10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck10MouseReleased(evt);
            }
        });

        btnDeck11.setBorder(null);
        btnDeck11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck11MouseReleased(evt);
            }
        });

        btnDeck12.setBorder(null);
        btnDeck12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck12MouseReleased(evt);
            }
        });

        btnDeck13.setBorder(null);
        btnDeck13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck13MouseReleased(evt);
            }
        });

        btnDeck14.setBorder(null);
        btnDeck14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck14MouseReleased(evt);
            }
        });

        btnDeck15.setBorder(null);
        btnDeck15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck15MouseReleased(evt);
            }
        });

        btnDeck16.setBorder(null);
        btnDeck16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck16MouseReleased(evt);
            }
        });

        btnDeck17.setBorder(null);
        btnDeck17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck17MouseReleased(evt);
            }
        });

        btnDeck18.setBorder(null);
        btnDeck18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck18MouseReleased(evt);
            }
        });

        btnDeck19.setBorder(null);
        btnDeck19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck19MouseReleased(evt);
            }
        });

        btnDeck20.setBorder(null);
        btnDeck20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeck20MouseReleased(evt);
            }
        });

        btnSetDeck.setBackground(new java.awt.Color(51, 51, 51));
        btnSetDeck.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnSetDeck.setForeground(new java.awt.Color(255, 255, 255));
        btnSetDeck.setText("Set Deck");
        btnSetDeck.setBorder(null);
        btnSetDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetDeckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeckLayout = new javax.swing.GroupLayout(Deck);
        Deck.setLayout(DeckLayout);
        DeckLayout.setHorizontalGroup(
            DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeckLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeck20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeck10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addComponent(btnSetDeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DeckLayout.setVerticalGroup(
            DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeckLayout.createSequentialGroup()
                            .addComponent(btnDeck10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDeck20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DeckLayout.createSequentialGroup()
                                .addComponent(btnDeck9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeck19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeckLayout.createSequentialGroup()
                            .addComponent(btnDeck5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDeck15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DeckLayout.createSequentialGroup()
                                .addComponent(btnDeck4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeck14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(DeckLayout.createSequentialGroup()
                                    .addComponent(btnDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeck11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(btnSetDeck, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventory");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        inven1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven1MouseEntered(evt);
            }
        });
        inven1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven1ActionPerformed(evt);
            }
        });

        inven2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven2MouseEntered(evt);
            }
        });
        inven2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven2ActionPerformed(evt);
            }
        });

        inven4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven4MouseEntered(evt);
            }
        });
        inven4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven4ActionPerformed(evt);
            }
        });

        inven3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven3MouseEntered(evt);
            }
        });
        inven3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven3ActionPerformed(evt);
            }
        });

        inven5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven5MouseEntered(evt);
            }
        });
        inven5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven5ActionPerformed(evt);
            }
        });

        inven6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven6MouseEntered(evt);
            }
        });
        inven6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven6ActionPerformed(evt);
            }
        });

        inven7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven7MouseEntered(evt);
            }
        });
        inven7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven7ActionPerformed(evt);
            }
        });

        inven8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven8MouseEntered(evt);
            }
        });
        inven8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven8ActionPerformed(evt);
            }
        });

        inven9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven9MouseEntered(evt);
            }
        });
        inven9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven9ActionPerformed(evt);
            }
        });

        inven10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven10MouseEntered(evt);
            }
        });
        inven10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven10ActionPerformed(evt);
            }
        });

        inven11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven11MouseEntered(evt);
            }
        });
        inven11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven11ActionPerformed(evt);
            }
        });

        inven12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven12MouseEntered(evt);
            }
        });
        inven12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven12ActionPerformed(evt);
            }
        });

        inven13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven13MouseEntered(evt);
            }
        });
        inven13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven13ActionPerformed(evt);
            }
        });

        inven14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven14MouseEntered(evt);
            }
        });
        inven14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven14ActionPerformed(evt);
            }
        });

        inven15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven15MouseEntered(evt);
            }
        });
        inven15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven15ActionPerformed(evt);
            }
        });

        inven16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven16MouseEntered(evt);
            }
        });
        inven16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven16ActionPerformed(evt);
            }
        });

        inven17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven17MouseEntered(evt);
            }
        });
        inven17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven17ActionPerformed(evt);
            }
        });

        inven18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven18MouseEntered(evt);
            }
        });
        inven18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven18ActionPerformed(evt);
            }
        });

        inven19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven19MouseEntered(evt);
            }
        });
        inven19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven19ActionPerformed(evt);
            }
        });

        inven20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inven20MouseEntered(evt);
            }
        });
        inven20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inven31, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven34, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven33, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven36, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven38, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven40, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven37, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven39, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven32, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inven35, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inven21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven25, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven24, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven28, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven23, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven26, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven27, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven29, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven30, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inven11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven18, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven19, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inven10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inven9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inven19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven15, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inven29, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven25, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven24, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven26, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inven32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven34, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven33, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven36, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven38, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven37, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inven39, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new java.awt.CardLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Toggle Card");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel4, "card2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(toggleCard, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toggleCard, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setText("Deck Card");

        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/btnClose.png"))); // NOI18N
        btnClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClose1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/btnClose-Hover.png"))); // NOI18N
        btnClose1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/btnClose-Hover.png"))); // NOI18N
        btnClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose1MouseClicked(evt);
            }
        });
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(483, 483, 483)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Deck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnClose1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClose1MouseClicked

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        Menu menu = new Menu();
        this.dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void inven1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven1ActionPerformed
        inven_card = new card(inventory.get(0).getHand_card(), inventory.get(0).getHighlight(), inventory.get(0).getName(), inventory.get(0).getType(), inventory.get(0).getAttack(), inventory.get(0).getDefence());
        selectCard = 0;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven1ActionPerformed

    private void inven2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven2ActionPerformed
        inven_card = new card(inventory.get(1).getHand_card(), inventory.get(1).getHighlight(), inventory.get(1).getName(), inventory.get(1).getType(), inventory.get(1).getAttack(), inventory.get(1).getDefence());
        selectCard = 1;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven2ActionPerformed

    private void inven3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven3ActionPerformed
        inven_card = new card(inventory.get(2).getHand_card(), inventory.get(2).getHighlight(), inventory.get(2).getName(), inventory.get(2).getType(), inventory.get(2).getAttack(), inventory.get(2).getDefence());
        selectCard = 2;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven3ActionPerformed

    private void inven4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven4ActionPerformed
       inven_card = new card(inventory.get(3).getHand_card(), inventory.get(3).getHighlight(), inventory.get(3).getName(), inventory.get(3).getType(), inventory.get(3).getAttack(), inventory.get(3).getDefence());
       selectCard = 3;
       getSelectedCard(selectCard, inven_card);
       index++;
    }//GEN-LAST:event_inven4ActionPerformed

    private void inven5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven5ActionPerformed
        inven_card = new card(inventory.get(4).getHand_card(), inventory.get(4).getHighlight(), inventory.get(4).getName(), inventory.get(4).getType(), inventory.get(4).getAttack(), inventory.get(4).getDefence());
        selectCard = 4;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven5ActionPerformed

    private void inven6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven6ActionPerformed
        inven_card = new card(inventory.get(5).getHand_card(), inventory.get(5).getHighlight(), inventory.get(5).getName(), inventory.get(5).getType(), inventory.get(5).getAttack(), inventory.get(5).getDefence());
        selectCard = 5;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven6ActionPerformed

    private void inven7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven7ActionPerformed
        inven_card = new card(inventory.get(6).getHand_card(), inventory.get(6).getHighlight(), inventory.get(6).getName(), inventory.get(6).getType(), inventory.get(6).getAttack(), inventory.get(6).getDefence());
        selectCard = 6;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven7ActionPerformed

    private void inven8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven8ActionPerformed
        inven_card = new card(inventory.get(7).getHand_card(), inventory.get(7).getHighlight(), inventory.get(7).getName(), inventory.get(7).getType(), inventory.get(7).getAttack(), inventory.get(7).getDefence());
        selectCard = 7;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven8ActionPerformed

    private void inven9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven9ActionPerformed
        inven_card = new card(inventory.get(8).getHand_card(), inventory.get(8).getHighlight(), inventory.get(8).getName(), inventory.get(8).getType(), inventory.get(8).getAttack(), inventory.get(8).getDefence());
        selectCard = 8;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven9ActionPerformed

    private void inven10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven10ActionPerformed
        inven_card = new card(inventory.get(9).getHand_card(), inventory.get(9).getHighlight(), inventory.get(9).getName(), inventory.get(9).getType(), inventory.get(9).getAttack(), inventory.get(9).getDefence());
        selectCard = 9;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven10ActionPerformed

    private void inven11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven11ActionPerformed
        inven_card = new card(inventory.get(10).getHand_card(), inventory.get(10).getHighlight(), inventory.get(10).getName(), inventory.get(10).getType(), inventory.get(10).getAttack(), inventory.get(10).getDefence());
        selectCard = 10;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven11ActionPerformed

    private void inven12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven12ActionPerformed
        inven_card = new card(inventory.get(11).getHand_card(), inventory.get(11).getHighlight(), inventory.get(11).getName(), inventory.get(11).getType(), inventory.get(11).getAttack(), inventory.get(11).getDefence());
        selectCard = 11;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven12ActionPerformed

    private void inven13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven13ActionPerformed
        inven_card = new card(inventory.get(12).getHand_card(), inventory.get(12).getHighlight(), inventory.get(12).getName(), inventory.get(12).getType(), inventory.get(12).getAttack(), inventory.get(12).getDefence());
        selectCard = 12;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven13ActionPerformed

    private void inven14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven14ActionPerformed
        inven_card = new card(inventory.get(13).getHand_card(), inventory.get(13).getHighlight(), inventory.get(13).getName(), inventory.get(13).getType(), inventory.get(13).getAttack(), inventory.get(13).getDefence());
        selectCard = 13;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven14ActionPerformed

    private void inven15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven15ActionPerformed
        inven_card = new card(inventory.get(14).getHand_card(), inventory.get(14).getHighlight(), inventory.get(14).getName(), inventory.get(14).getType(), inventory.get(14).getAttack(), inventory.get(14).getDefence());
        selectCard = 14;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven15ActionPerformed

    private void inven16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven16ActionPerformed
        inven_card = new card(inventory.get(15).getHand_card(), inventory.get(15).getHighlight(), inventory.get(15).getName(), inventory.get(15).getType(), inventory.get(15).getAttack(), inventory.get(15).getDefence());
        selectCard = 15;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven16ActionPerformed

    private void inven17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven17ActionPerformed
        inven_card = new card(inventory.get(16).getHand_card(), inventory.get(16).getHighlight(), inventory.get(16).getName(), inventory.get(16).getType(), inventory.get(16).getAttack(), inventory.get(16).getDefence());
        selectCard = 16;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven17ActionPerformed

    private void inven18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven18ActionPerformed
        inven_card = new card(inventory.get(17).getHand_card(), inventory.get(17).getHighlight(), inventory.get(17).getName(), inventory.get(17).getType(), inventory.get(17).getAttack(), inventory.get(17).getDefence());
        selectCard = 17;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven18ActionPerformed

    private void inven19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven19ActionPerformed
        inven_card = new card(inventory.get(18).getHand_card(), inventory.get(18).getHighlight(), inventory.get(18).getName(), inventory.get(18).getType(), inventory.get(18).getAttack(), inventory.get(18).getDefence());
        selectCard = 18;
        getSelectedCard(selectCard, inven_card);
        index++;
    }//GEN-LAST:event_inven19ActionPerformed

    private void inven20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven20ActionPerformed
        inven_card = new card(inventory.get(19).getHand_card(), inventory.get(19).getHighlight(), inventory.get(19).getName(), inventory.get(19).getType(), inventory.get(19).getAttack(), inventory.get(19).getDefence());
        selectCard = 19;
        getSelectedCard(selectCard, inven_card);
        index++;
        
    }//GEN-LAST:event_inven20ActionPerformed

    private void btnDeck1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck1MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 0;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck1MouseReleased

    private void btnDeck2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck2MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 1;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck2MouseReleased

    private void btnDeck3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck3MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 2;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck3MouseReleased

    private void btnDeck4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck4MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 3;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck4MouseReleased

    private void btnDeck5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck5MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 4;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck5MouseReleased

    private void btnDeck6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck6MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 5;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck6MouseReleased

    private void btnDeck7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck7MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 6;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck7MouseReleased

    private void btnDeck8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck8MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 7;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck8MouseReleased

    private void btnDeck9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck9MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 8;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck9MouseReleased

    private void btnDeck10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck10MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 9;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck10MouseReleased

    private void btnDeck11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck11MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 10;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck11MouseReleased

    private void btnDeck12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck12MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 11;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck12MouseReleased

    private void btnDeck13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck13MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 12;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck13MouseReleased

    private void btnDeck14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck14MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 13;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck14MouseReleased

    private void btnDeck15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck15MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 14;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck15MouseReleased

    private void btnDeck16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck16MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 15;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck16MouseReleased

    private void btnDeck17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck17MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 16;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck17MouseReleased

    private void btnDeck18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck18MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 17;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck18MouseReleased

    private void btnDeck19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck19MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 18;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck19MouseReleased

    private void btnDeck20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeck20MouseReleased
        if(evt.getButton()==(MouseEvent.BUTTON1)){
            index = 19;
        }
        else if(evt.getButton()==(MouseEvent.BUTTON3)){

            btnDeck20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/DeckShowback.png")));
        }
    }//GEN-LAST:event_btnDeck20MouseReleased

    private void inven1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven1MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(0).getHighlight())));
    }//GEN-LAST:event_inven1MouseEntered

    private void inven2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven2MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(1).getHighlight())));
    }//GEN-LAST:event_inven2MouseEntered

    private void inven3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven3MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(2).getHighlight())));
    }//GEN-LAST:event_inven3MouseEntered

    private void inven4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven4MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(3).getHighlight())));
    }//GEN-LAST:event_inven4MouseEntered

    private void inven5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven5MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(4).getHighlight())));
    }//GEN-LAST:event_inven5MouseEntered

    private void inven6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven6MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(5).getHighlight())));
    }//GEN-LAST:event_inven6MouseEntered

    private void inven7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven7MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(6).getHighlight())));
    }//GEN-LAST:event_inven7MouseEntered

    private void inven8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven8MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(7).getHighlight())));
    }//GEN-LAST:event_inven8MouseEntered

    private void inven9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven9MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(8).getHighlight())));
    }//GEN-LAST:event_inven9MouseEntered

    private void inven10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven10MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(9).getHighlight())));
    }//GEN-LAST:event_inven10MouseEntered

    private void inven11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven11MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(10).getHighlight())));
    }//GEN-LAST:event_inven11MouseEntered

    private void inven12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven12MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(11).getHighlight())));
    }//GEN-LAST:event_inven12MouseEntered

    private void inven13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven13MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(12).getHighlight())));
    }//GEN-LAST:event_inven13MouseEntered

    private void inven14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven14MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(13).getHighlight())));
    }//GEN-LAST:event_inven14MouseEntered

    private void inven15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven15MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(14).getHighlight())));
    }//GEN-LAST:event_inven15MouseEntered

    private void inven16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven16MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(15).getHighlight())));
    }//GEN-LAST:event_inven16MouseEntered

    private void inven17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven17MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(16).getHighlight())));
    }//GEN-LAST:event_inven17MouseEntered

    private void inven18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven18MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(17).getHighlight())));
    }//GEN-LAST:event_inven18MouseEntered

    private void inven19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven19MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(18).getHighlight())));
    }//GEN-LAST:event_inven19MouseEntered

    private void inven20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven20MouseEntered
        toggleCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/"+inventory.get(19).getHighlight())));
    }//GEN-LAST:event_inven20MouseEntered

    private void btnSetDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDeckActionPerformed
        index = 0;
        conn = Database.config();
        String del = "delete from deck where account_id=?";
        String set = "insert into deck(account_id, card_name, att_power, def_power, card_type, battle_card, hand_card, id_card) values(?,?,?,?,?,?,?,?)";

//        String set = "update deck set id_card=?, card_name=?, att_power=?, def_power=?, card_type=?, battle_card=?, hand_card=? where account_id=?";
        boolean checkDuplicate = false;
        for (int a = 0; a < 20; a++){
            for(int b = a+1; b < 20; b++){
                if(deck[a].getName().equals(deck[b].getName())){
                    checkDuplicate = true;
                    
                }
            }
        }
        
        if(checkDuplicate == true){
            JOptionPane.showMessageDialog(null, "Terdapat kartu duplikat, Tidak boleh menggunakan kartu yang sama");
        }
        else{
            try {
                pst = conn.prepareStatement(del);
                pst.setString(1, account_id);
                pst.execute();

                pst = conn.prepareStatement(set);
                for(int i = 0; i<20; i++){

                    pst.setString(1, account_id);
                    pst.setString(2, deck[i].getName());
                    pst.setInt(3, deck[i].getAttack());
                    pst.setInt(4, deck[i].getDefence());
                    pst.setString(5, deck[i].getType());
                    pst.setString(6, deck[i].getHighlight());
                    pst.setString(7, deck[i].getImage());
                    pst.setInt(8, i+1);
                    pst.executeUpdate();

                    System.out.println(deck[i].getName()+"|"+deck[i].getAttack()+"|"+deck[i].getDefence()+"|"+deck[i].getType());
                }

                JOptionPane.showMessageDialog(null, "Berhasil merubah kartu di Deck!");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        }
    
    }//GEN-LAST:event_btnSetDeckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Deck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deck().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Deck;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnDeck1;
    private javax.swing.JButton btnDeck10;
    private javax.swing.JButton btnDeck11;
    private javax.swing.JButton btnDeck12;
    private javax.swing.JButton btnDeck13;
    private javax.swing.JButton btnDeck14;
    private javax.swing.JButton btnDeck15;
    private javax.swing.JButton btnDeck16;
    private javax.swing.JButton btnDeck17;
    private javax.swing.JButton btnDeck18;
    private javax.swing.JButton btnDeck19;
    private javax.swing.JButton btnDeck2;
    private javax.swing.JButton btnDeck20;
    private javax.swing.JButton btnDeck3;
    private javax.swing.JButton btnDeck4;
    private javax.swing.JButton btnDeck5;
    private javax.swing.JButton btnDeck6;
    private javax.swing.JButton btnDeck7;
    private javax.swing.JButton btnDeck8;
    private javax.swing.JButton btnDeck9;
    private javax.swing.JButton btnSetDeck;
    private javax.swing.JButton inven1;
    private javax.swing.JButton inven10;
    private javax.swing.JButton inven11;
    private javax.swing.JButton inven12;
    private javax.swing.JButton inven13;
    private javax.swing.JButton inven14;
    private javax.swing.JButton inven15;
    private javax.swing.JButton inven16;
    private javax.swing.JButton inven17;
    private javax.swing.JButton inven18;
    private javax.swing.JButton inven19;
    private javax.swing.JButton inven2;
    private javax.swing.JButton inven20;
    private javax.swing.JButton inven21;
    private javax.swing.JButton inven22;
    private javax.swing.JButton inven23;
    private javax.swing.JButton inven24;
    private javax.swing.JButton inven25;
    private javax.swing.JButton inven26;
    private javax.swing.JButton inven27;
    private javax.swing.JButton inven28;
    private javax.swing.JButton inven29;
    private javax.swing.JButton inven3;
    private javax.swing.JButton inven30;
    private javax.swing.JButton inven31;
    private javax.swing.JButton inven32;
    private javax.swing.JButton inven33;
    private javax.swing.JButton inven34;
    private javax.swing.JButton inven35;
    private javax.swing.JButton inven36;
    private javax.swing.JButton inven37;
    private javax.swing.JButton inven38;
    private javax.swing.JButton inven39;
    private javax.swing.JButton inven4;
    private javax.swing.JButton inven40;
    private javax.swing.JButton inven5;
    private javax.swing.JButton inven6;
    private javax.swing.JButton inven7;
    private javax.swing.JButton inven8;
    private javax.swing.JButton inven9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel toggleCard;
    // End of variables declaration//GEN-END:variables
}
