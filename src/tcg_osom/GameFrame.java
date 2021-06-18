/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author KuroNeko
 */
public class GameFrame extends javax.swing.JFrame {
    
    long startTime, endTime;
    String elapsedTime;
    private CrudImplement impl = new CrudImplement();
    private final card[] Card = new card[34];
    private final int[] Indexes = new int[4];
    private int healthP1 = 10000;
    private int healthCPU = 10000;
    private card Cpu, P1 = null;
    private int P1_graveyard = 0, Cpu_graveyard = 0, P1_deck = 33, Cpu_deck = 33;
    int turn = 0;
    String account_id, nick;
    int gold, exp;
    int rewardGold, rewardExp;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String state;
    String tanggal;

    public void getDate(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, YYYY");
        tanggal = dtf.format(date);
    }
    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        startTime= System.currentTimeMillis();
        initComponents();
        setLocationRelativeTo(null);
        Card[0] = new card("HC000.png", "BC000.png", "Rick Roll", "pistol", 6000, 0);
        Card[1] = new card("HC001.png", "BC001.png", "Epic Sax Guy", "batu", 3000, 1200);
        Card[2] = new card("HC002.png", "BC002.png", "Trololo", "gunting", 3300, 800);
        Card[3] = new card("HC003.png", "BC003.png", "But it was me DIO", "kertas", 3000, 1200);
        Card[4] = new card("HC004.png", "BC004.png", "Spanish Inquisition", "batu", 2800, 1600);
        Card[5] = new card("HC005.png", "BC005.png", "El Risitas", "gunting", 2600, 1800);
        Card[6] = new card("HC006.png", "BC006.png", "Buff Doge", "kertas", 3500, 500);
        Card[7] = new card("HC007.png", "BC007.png", "Dorime", "batu", 2300, 1000);
        Card[8] = new card("HC008.png", "BC008.png", "Cheems Doge", "gunting", 2400, 900);
        Card[9] = new card("HC009.png", "BC009.png", "Yaoming", "kertas", 2200, 1100);
        Card[10] = new card("HC010.png", "BC010.png", "Derp", "batu", 2000, 1500);
        Card[11] = new card("HC011.png", "BC011.png", "Spongebob", "gunting", 2100, 1400);
        Card[12] = new card("HC012.png", "BC012.png", "Za Warudo", "kertas", 2600, 800);
        Card[13] = new card("HC013.png", "BC013.png", "Woman yelling to cat", "gunting", 2400, 1000);
        Card[14] = new card("HC014.png", "BC014.png", "Cat getting yelled", "batu", 2400, 1000);
        Card[15] = new card("HC015.png", "BC015.png", "Diccbudd", "kertas", 2300, 1100);
        Card[16] = new card("HC016.png", "BC016.png", "Think Mark!", "batu", 1500, 900);
        Card[17] = new card("HC017.png", "BC017.png", "Mark, who can't think", "gunting", 1500, 900);
        Card[18] = new card("HC018.png", "BC018.png", "The Blurred Girl", "kertas", 1000, 1400);
        Card[19] = new card("HC019.png", "BC019.png", "The Distracted Guy", "batu", 1100, 1300);
        Card[20] = new card("HC020.png", "BC020.png", "Angry GF", "gunting", 1200, 1200);
        Card[21] = new card("HC021.png", "BC021.png", "Lol is u ded?", "kertas", 1200, 1200);
        Card[22] = new card("HC022.png", "BC022.png", "Ded guy", "batu", 1000, 1500);
        Card[23] = new card("HC023.png", "BC023.png", "U see that guy?", "gunting", 1500, 700);
        Card[24] = new card("HC024.png", "BC024.png", "That Guy", "kertas", 1400, 900);
        Card[25] = new card("HC025.png", "BC025.png", "Now angry guy", "batu", 1600, 500);
        Card[26] = new card("HC026.png", "BC026.png", "No U", "gunting", 0, 3000);
        Card[27] = new card("HC027.png", "BC027.png", "Meme Man", "kertas", 1000, 1000);
        Card[28] = new card("HC028.png", "BC028.png", "Orang Man", "batu", 1000, 1000);
        Card[29] = new card("HC029.png", "BC029.png", "Ara ara nee-san", "gunting", 1500, 600);
        Card[30] = new card("HC030.png", "BC030.png", "Shota-kun", "kertas", 1000, 1200);
        Card[31] = new card("HC031.png", "BC031.png", "Lord Elon", "batu", 1300, 900);
        Card[32] = new card("HC032.png", "BC032.png", "Elons Dolphin.exe", "gunting", 900, 1300);
        Card[33] = new card("HC033.png", "BC033.png", "Lord Zucc", "kertas", 2700, 0);
        getFirstIndexes();
        setImageDeck();
        setAllLabel();
        logged();
        getDate();
        
    }

    private void logged(){
        account_id = tcg_osom.Database.getUserId();
        nick = tcg_osom.Database.getNickname();
        winPanel.setVisible(false);
        losePanel.setVisible(false);
        panelMenu.setVisible(false);
        
    }
    
    private void recordGame(){
        try{
            impl.setRecord(P1_deck, Cpu_deck, healthP1, healthCPU, state, tanggal, elapsedTime, account_id);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getGoldExp(){
        conn = Database.config();
        String get = "select * from account where account_id = ?";
        try {
            pst = conn.prepareStatement(get);
            pst.setString(1, account_id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                exp = rs.getInt("exp");
                gold = rs.getInt("gold");
            }
            gold += rewardGold;
            exp += rewardExp;
            impl.setExp(exp, account_id);
            impl.setGold(gold, account_id);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private int getRandomIndex() {
        return new Random().nextInt(20 - 0);
    }
    
    private void setAllLabel() {
        p1_deck_label.setText("Deck : x" + P1_deck);
        p1_graveyard_label.setText("Graveyard : x" + P1_graveyard);
        cpu_deck_label.setText("Deck : x" + Cpu_deck);
        cpu_graveyard_label.setText("Graveyard : x" + Cpu_graveyard);
        hp_p1_label.setText(nick +" hp : "+ healthP1);
        hp_cpu_label.setText("HP CPU : "+ healthCPU);
        turnLabel.setText("Turn : "+ turn);
        healthBar.setValue(healthP1);
        cpuHealthBar.setValue(healthCPU);
        panelMenu.setVisible(false);
        txtTurn.setText(" "+turn);
        txtTurn1.setText(" "+turn);
        txtGold.setText(" "+rewardGold);
        txtXp.setText(" "+rewardExp);
        txtGold1.setText(" "+rewardGold);
        txtXp1.setText(" "+rewardExp);
        txtTime.setText(""+elapsedTime);
        txtTime1.setText(""+elapsedTime);
    }

    private void getFirstIndexes() {
        Indexes[0] = getRandomIndex();
        Indexes[1] = getRandomIndex();
        Indexes[2] = getRandomIndex();
        Indexes[3] = getRandomIndex();
    }

    private void setImageDeck() {
        deck_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Handcard/" + Card[Indexes[0]].getImage())));
        deck_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Handcard/" + Card[Indexes[1]].getImage())));
        deck_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Handcard/" + Card[Indexes[2]].getImage())));
        deck_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Handcard/" + Card[Indexes[3]].getImage())));
    }

    private void deckOnClick(int index) {
        
        P1 = Card[Indexes[index]];
        Cpu = Card[getRandomIndex()];
        highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/" + P1.getHighlight())));
        highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/" + Cpu.getHighlight())));
        Indexes[index] = getRandomIndex();
        setImageDeck();
        battle();
        setAllLabel();
    }
    
    @SuppressWarnings("empty-statement")
    private void battle() {
        if (Cpu.getType().equals("pistol")&&P1.getType().equals("pistol")) {
            P1_deck -= 1;
            P1_graveyard += 1;
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            JOptionPane.showMessageDialog(null, "Draw!");
            
            turn++;
        }
        else if (Cpu.getType().equals("pistol")) {
            P1_deck -= 1;
            P1_graveyard += 1;
            Cpu.setDamage(Cpu.getAttack() - P1.getDefence());
            if(Cpu.getDamage() > 0){
                healthP1 -= Cpu.getDamage();
                JOptionPane.showMessageDialog(null, "CPU Attack Point = "+Cpu.getAttack()+" P1 Defence point = "+P1.getDefence()+"\nYou Got "+Cpu.getDamage()+" Damage!");
            }
            turn++;
        }
        else if (P1.getType().equals("pistol")) {
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            P1.setDamage(P1.getAttack() - Cpu.getDefence());
            if(P1.getDamage() > 0){
                healthCPU -= P1.getDamage();
                JOptionPane.showMessageDialog(null, "P1 Attack Point = "+P1.getAttack()+" CPU Defence point = "+Cpu.getDefence()+"\nYou Deal "+P1.getDamage()+" Damage!");
            }
            turn++;
        }
        else if ((Cpu.getType().equals("kertas") && P1.getType().equals("batu"))
                || (Cpu.getType().equals("gunting") && P1.getType().equals("kertas"))
                || (Cpu.getType().equals("batu") && P1.getType().equals("gunting"))) {
            P1_deck -= 1;
            P1_graveyard += 1;
            Cpu.setDamage(Cpu.getAttack() - P1.getDefence());
            if(Cpu.getDamage() > 0){
                healthP1 -= Cpu.getDamage();
                JOptionPane.showMessageDialog(null, "CPU Attack Point = "+Cpu.getAttack()+" P1 Defence point = "+P1.getDefence()+"\nYou Got "+Cpu.getDamage()+" Damage!");
            }
            turn++;
        } else if ((Cpu.getType().equals(P1.getType()))
                || (Cpu.getType().equals(P1.getType()))
                || (Cpu.getType().equals(P1.getType()))) {
            P1_deck -= 1;
            P1_graveyard += 1;
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            turn++;
        } else if ((Cpu.getType().equals("kertas") && P1.getType().equals("gunting"))
                || (Cpu.getType().equals("gunting") && P1.getType().equals("batu"))
                || (Cpu.getType().equals("batu") && P1.getType().equals("kertas"))) {
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            P1.setDamage(P1.getAttack() - Cpu.getDefence());
            if(P1.getDamage() > 0){
                healthCPU -= P1.getDamage();
                JOptionPane.showMessageDialog(null, "P1 Attack Point = "+P1.getAttack()+" CPU Defence point = "+Cpu.getDefence()+"\nYou Deal "+P1.getDamage()+" Damage!");
            }
            turn++;
        }
        
        if (healthCPU <= 0 || Cpu_deck == 0) {
            rewardGold = 100;
            rewardExp = 100;
            state = "WIN";
            healthCPU = 0;
            winPanel.setVisible(true);
            MainPanel.setVisible(false);
            recordGame();
            getGoldExp();
            
        }else if (healthP1 <= 0 || P1_deck == 0){
            rewardGold = 0;
            rewardExp = 25;
            state = "LOSE";
            healthP1 = 0;
            losePanel.setVisible(true);
            MainPanel.setVisible(false);
            recordGame();
            getGoldExp();
        };
        endTime=System.currentTimeMillis();
        elapsedTime = String.valueOf((endTime-startTime)/1000);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelMenu = new javax.swing.JPanel();
        btnRestart = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        hp_cpu_label = new javax.swing.JLabel();
        hp_p1_label = new javax.swing.JLabel();
        deck_1 = new javax.swing.JButton();
        deck_2 = new javax.swing.JButton();
        deck_3 = new javax.swing.JButton();
        deck_4 = new javax.swing.JButton();
        highlight_1 = new javax.swing.JLabel();
        highlight_2 = new javax.swing.JLabel();
        p1_deck_label = new javax.swing.JLabel();
        cpu_deck_label = new javax.swing.JLabel();
        p1_graveyard_label = new javax.swing.JLabel();
        cpu_graveyard_label = new javax.swing.JLabel();
        turnLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HealthBar = new javax.swing.JPanel();
        cpuHealthBar = new javax.swing.JProgressBar();
        healthBarPanel = new javax.swing.JPanel();
        healthBar = new javax.swing.JProgressBar();
        Deck = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        LayoutGame = new javax.swing.JLabel();
        losePanel = new javax.swing.JPanel();
        txtXp1 = new javax.swing.JLabel();
        txtGold1 = new javax.swing.JLabel();
        txtTime1 = new javax.swing.JLabel();
        txtTurn1 = new javax.swing.JLabel();
        btnQuitLose = new javax.swing.JButton();
        btnPlayLose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        winPanel = new javax.swing.JPanel();
        txtXp = new javax.swing.JLabel();
        txtGold = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtTurn = new javax.swing.JLabel();
        btnPlayWin = new javax.swing.JButton();
        btnQuitWin = new javax.swing.JButton();
        bgWin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1028, 720));
        setUndecorated(true);
        getContentPane().setLayout(null);

        panelMenu.setBackground(new java.awt.Color(51, 51, 51));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 300));

        btnRestart.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btnPause.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnQuit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRestart, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(165, Short.MAX_VALUE)))
        );

        jLayeredPane1.add(panelMenu);
        panelMenu.setBounds(40, 40, 200, 240);

        MainPanel.setLayout(null);

        hp_cpu_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_cpu_label.setText("HP CPU : 10000");
        MainPanel.add(hp_cpu_label);
        hp_cpu_label.setBounds(770, 40, 133, 22);

        hp_p1_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_p1_label.setText("HP Player : 10000");
        MainPanel.add(hp_p1_label);
        hp_p1_label.setBounds(120, 360, 210, 22);

        deck_1.setBorderPainted(false);
        deck_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deck_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deck_1MouseExited(evt);
            }
        });
        deck_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_1ActionPerformed(evt);
            }
        });
        MainPanel.add(deck_1);
        deck_1.setBounds(275, 510, 168, 233);

        deck_2.setBorderPainted(false);
        deck_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deck_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deck_2MouseExited(evt);
            }
        });
        deck_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_2ActionPerformed(evt);
            }
        });
        MainPanel.add(deck_2);
        deck_2.setBounds(459, 510, 168, 233);

        deck_3.setBorderPainted(false);
        deck_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deck_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deck_3MouseExited(evt);
            }
        });
        deck_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_3ActionPerformed(evt);
            }
        });
        MainPanel.add(deck_3);
        deck_3.setBounds(645, 510, 168, 233);

        deck_4.setBorderPainted(false);
        deck_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deck_4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deck_4MouseExited(evt);
            }
        });
        deck_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_4ActionPerformed(evt);
            }
        });
        MainPanel.add(deck_4);
        deck_4.setBounds(831, 510, 168, 233);

        highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackLarge.png"))); // NOI18N
        MainPanel.add(highlight_1);
        highlight_1.setBounds(335, 200, 196, 273);

        highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackLarge.png"))); // NOI18N
        MainPanel.add(highlight_2);
        highlight_2.setBounds(717, 200, 196, 273);

        p1_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_deck_label.setText("Deck : x00");
        MainPanel.add(p1_deck_label);
        p1_deck_label.setBounds(120, 420, 140, 40);

        cpu_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_deck_label.setText("Deck : x00");
        MainPanel.add(cpu_deck_label);
        cpu_deck_label.setBounds(810, 100, 100, 40);

        p1_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_graveyard_label.setText("Graveyard : x00");
        MainPanel.add(p1_graveyard_label);
        p1_graveyard_label.setBounds(20, 460, 140, 50);

        cpu_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_graveyard_label.setText("Graveyard : x00");
        MainPanel.add(cpu_graveyard_label);
        cpu_graveyard_label.setBounds(880, 150, 140, 40);

        turnLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        turnLabel.setText("Turn : 0");
        MainPanel.add(turnLabel);
        turnLabel.setBounds(590, 380, 90, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/BC033.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        MainPanel.add(jLabel2);
        jLabel2.setBounds(20, 360, 90, 100);

        HealthBar.setBackground(new java.awt.Color(0, 153, 153));
        HealthBar.setLayout(new java.awt.CardLayout());

        cpuHealthBar.setBackground(new java.awt.Color(0, 153, 51));
        cpuHealthBar.setMaximum(10000);
        cpuHealthBar.setBorderPainted(false);
        cpuHealthBar.setPreferredSize(new java.awt.Dimension(150, 25));
        HealthBar.add(cpuHealthBar, "card2");

        MainPanel.add(HealthBar);
        HealthBar.setBounds(740, 70, 160, 30);

        healthBarPanel.setBackground(new java.awt.Color(0, 153, 153));
        healthBarPanel.setLayout(new java.awt.CardLayout());

        healthBar.setBackground(new java.awt.Color(0, 153, 51));
        healthBar.setMaximum(10000);
        healthBar.setBorderPainted(false);
        healthBarPanel.add(healthBar, "card2");

        MainPanel.add(healthBarPanel);
        healthBarPanel.setBounds(120, 390, 170, 25);

        Deck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Deck.png"))); // NOI18N
        MainPanel.add(Deck);
        Deck.setBounds(40, 515, 200, 230);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        MainPanel.add(jLabel4);
        jLabel4.setBounds(407, 30, 90, 130);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        MainPanel.add(jLabel5);
        jLabel5.setBounds(304, 30, 90, 130);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        MainPanel.add(jLabel6);
        jLabel6.setBounds(615, 31, 90, 130);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        MainPanel.add(jLabel7);
        jLabel7.setBounds(513, 30, 90, 130);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/BC033.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        MainPanel.add(jLabel3);
        jLabel3.setBounds(920, 40, 90, 100);

        btnMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        MainPanel.add(btnMenu);
        btnMenu.setBounds(40, 40, 190, 50);

        LayoutGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/gameplay.png"))); // NOI18N
        LayoutGame.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        MainPanel.add(LayoutGame);
        LayoutGame.setBounds(0, 0, 1030, 772);

        jLayeredPane1.add(MainPanel);
        MainPanel.setBounds(0, 0, 1030, 770);

        losePanel.setLayout(null);

        txtXp1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtXp1.setForeground(new java.awt.Color(255, 255, 255));
        txtXp1.setText("100");
        losePanel.add(txtXp1);
        txtXp1.setBounds(650, 520, 70, 30);

        txtGold1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtGold1.setForeground(new java.awt.Color(255, 255, 255));
        txtGold1.setText("100");
        losePanel.add(txtGold1);
        txtGold1.setBounds(370, 520, 70, 30);

        txtTime1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTime1.setForeground(new java.awt.Color(255, 255, 255));
        losePanel.add(txtTime1);
        txtTime1.setBounds(560, 350, 70, 30);

        txtTurn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTurn1.setForeground(new java.awt.Color(255, 255, 255));
        losePanel.add(txtTurn1);
        txtTurn1.setBounds(560, 310, 70, 30);

        btnQuitLose.setBackground(new java.awt.Color(38, 38, 38));
        btnQuitLose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuitLose.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitLose.setText("Quit");
        btnQuitLose.setToolTipText("");
        btnQuitLose.setBorder(null);
        btnQuitLose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitLoseActionPerformed(evt);
            }
        });
        losePanel.add(btnQuitLose);
        btnQuitLose.setBounds(530, 640, 200, 50);

        btnPlayLose.setBackground(new java.awt.Color(38, 38, 38));
        btnPlayLose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPlayLose.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayLose.setText("Play Again!");
        btnPlayLose.setToolTipText("");
        btnPlayLose.setBorder(null);
        btnPlayLose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayLoseActionPerformed(evt);
            }
        });
        losePanel.add(btnPlayLose);
        btnPlayLose.setBounds(290, 640, 200, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/lose.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        losePanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 780);

        jLayeredPane1.add(losePanel);
        losePanel.setBounds(0, 0, 1030, 770);

        winPanel.setLayout(null);

        txtXp.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtXp.setForeground(new java.awt.Color(255, 255, 255));
        txtXp.setText("100");
        winPanel.add(txtXp);
        txtXp.setBounds(650, 470, 100, 50);

        txtGold.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtGold.setForeground(new java.awt.Color(255, 255, 255));
        txtGold.setText("100");
        winPanel.add(txtGold);
        txtGold.setBounds(370, 470, 90, 50);

        txtTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTime.setForeground(new java.awt.Color(255, 255, 255));
        winPanel.add(txtTime);
        txtTime.setBounds(560, 330, 70, 30);

        txtTurn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTurn.setForeground(new java.awt.Color(255, 255, 255));
        winPanel.add(txtTurn);
        txtTurn.setBounds(560, 290, 70, 30);

        btnPlayWin.setBackground(new java.awt.Color(38, 38, 38));
        btnPlayWin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPlayWin.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayWin.setText("Play Again!");
        btnPlayWin.setToolTipText("");
        btnPlayWin.setBorder(null);
        btnPlayWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayWinActionPerformed(evt);
            }
        });
        winPanel.add(btnPlayWin);
        btnPlayWin.setBounds(290, 630, 200, 50);

        btnQuitWin.setBackground(new java.awt.Color(38, 38, 38));
        btnQuitWin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuitWin.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitWin.setText("Quit");
        btnQuitWin.setToolTipText("");
        btnQuitWin.setBorder(null);
        btnQuitWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitWinActionPerformed(evt);
            }
        });
        winPanel.add(btnQuitWin);
        btnQuitWin.setBounds(520, 630, 200, 50);

        bgWin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/win.png"))); // NOI18N
        winPanel.add(bgWin);
        bgWin.setBounds(0, 0, 1040, 770);

        jLayeredPane1.add(winPanel);
        winPanel.setBounds(0, 0, 1030, 770);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 1030, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deck_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_1ActionPerformed
        deckOnClick(0);
    }//GEN-LAST:event_deck_1ActionPerformed

    private void deck_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_2ActionPerformed
        deckOnClick(1);
    }//GEN-LAST:event_deck_2ActionPerformed

    private void deck_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_3ActionPerformed
        deckOnClick(2);
    }//GEN-LAST:event_deck_3ActionPerformed

    private void deck_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_4ActionPerformed
        deckOnClick(3);
    }//GEN-LAST:event_deck_4ActionPerformed

    private void deck_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_1MouseEntered
        deck_1.setBackground(Color.blue);
    }//GEN-LAST:event_deck_1MouseEntered

    private void deck_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_1MouseExited
        deck_1.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_deck_1MouseExited

    private void deck_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_2MouseEntered
        deck_2.setBackground(Color.blue);
    }//GEN-LAST:event_deck_2MouseEntered

    private void deck_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_2MouseExited
        deck_2.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_deck_2MouseExited

    private void deck_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_3MouseEntered
        deck_3.setBackground(Color.blue);
    }//GEN-LAST:event_deck_3MouseEntered

    private void deck_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_3MouseExited
        deck_3.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_deck_3MouseExited

    private void deck_4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_4MouseEntered
        deck_4.setBackground(Color.blue);
    }//GEN-LAST:event_deck_4MouseEntered

    private void deck_4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_4MouseExited
        deck_4.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_deck_4MouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        btnMenu.setVisible(false);
        panelMenu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        panelMenu.setVisible(false);
        btnMenu.setVisible(true);
        
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        new GameFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        Menu main = new Menu();
        
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.OK_OPTION);
        if(konfirm == 0){
            main.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnPlayLoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayLoseActionPerformed
        this.dispose();
        new GameFrame().setVisible(true);
    }//GEN-LAST:event_btnPlayLoseActionPerformed

    private void btnQuitLoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitLoseActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnQuitLoseActionPerformed

    private void btnPlayWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayWinActionPerformed
        new GameFrame().setVisible(true);
    }//GEN-LAST:event_btnPlayWinActionPerformed

    private void btnQuitWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitWinActionPerformed
        this.dispose();
        Menu mn = new Menu();
        mn.setVisible(true);
        
    }//GEN-LAST:event_btnQuitWinActionPerformed

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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Deck;
    private javax.swing.JPanel HealthBar;
    private javax.swing.JLabel LayoutGame;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel bgWin;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlayLose;
    private javax.swing.JButton btnPlayWin;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnQuitLose;
    private javax.swing.JButton btnQuitWin;
    private javax.swing.JButton btnRestart;
    private javax.swing.JProgressBar cpuHealthBar;
    private javax.swing.JLabel cpu_deck_label;
    private javax.swing.JLabel cpu_graveyard_label;
    private javax.swing.JButton deck_1;
    private javax.swing.JButton deck_2;
    private javax.swing.JButton deck_3;
    private javax.swing.JButton deck_4;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JPanel healthBarPanel;
    private javax.swing.JLabel highlight_1;
    private javax.swing.JLabel highlight_2;
    private javax.swing.JLabel hp_cpu_label;
    private javax.swing.JLabel hp_p1_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel losePanel;
    private javax.swing.JLabel p1_deck_label;
    private javax.swing.JLabel p1_graveyard_label;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel turnLabel;
    private javax.swing.JLabel txtGold;
    private javax.swing.JLabel txtGold1;
    private javax.swing.JLabel txtTime;
    private javax.swing.JLabel txtTime1;
    private javax.swing.JLabel txtTurn;
    private javax.swing.JLabel txtTurn1;
    private javax.swing.JLabel txtXp;
    private javax.swing.JLabel txtXp1;
    private javax.swing.JPanel winPanel;
    // End of variables declaration//GEN-END:variables
}
