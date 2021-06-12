/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author KuroNeko
 */
public class GameFrame extends javax.swing.JFrame {
private final card[] Card = new card[34];
    private final int[] Indexes = new int[4];
    private int healthP1 = 10000;
    private int healthCPU = 10000;
    private card Cpu, P1 = null;
    private int P1_graveyard = 0, Cpu_graveyard = 0, P1_deck = 33, Cpu_deck = 33;
    int turn = 0;


    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        setLocationRelativeTo(null);
        Card[0] = new card("HC000.png", "BC000.png", "Rick Roll", "gunting", 6000, 0);
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
        
        
        
    }

    private int getRandomIndex() {
        return new Random().nextInt(20 - 0);
        
    }
    
    private void setAllLabel() {
        p1_deck_label.setText("Deck : x" + P1_deck);
        p1_graveyard_label.setText("Graveyard : x" + P1_graveyard);
        cpu_deck_label.setText("Deck : x" + Cpu_deck);
        cpu_graveyard_label.setText("Graveyard : x" + Cpu_graveyard);
        hp_p1_label.setText("HP Player : "+ healthP1);
        hp_cpu_label.setText("HP CPU : "+ healthCPU);
        turnLabel.setText("Turn : "+ turn);
        healthBar.setValue(healthP1);
        cpuHealthBar.setValue(healthCPU);
        panelMenu.setVisible(false);
        
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

//    private void timeUp(){
//
//        if (isTimeUp == true){
//                int konfirm = JOptionPane.showConfirmDialog(null, "Will be selected a random card","Times Up", JOptionPane.OK_OPTION);
//                if(konfirm == 0){
//                    Random z = new Random(4-0);
//                    int indexRandom = z.nextInt();
//                    P1 = Card[Indexes[indexRandom]];
//                    Cpu = Card[getRandomIndex()];
//                    highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + P1.getHighlight())));
//                    highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + Cpu.getHighlight())));
//                    Indexes[indexRandom] = getRandomIndex();
//                    setImageDeck();
//                    battle();
//                    setAllLabel();
//                    
//                }
//         }
//    }
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
        if ((Cpu.getType().equals("kertas") && P1.getType().equals("batu"))
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
        
        if (healthCPU <= 0 || Cpu_deck <= 0) {
            WinFrame win = new WinFrame();
            this.dispose();
            win.setVisible(true);
        }else if (healthP1 <= 0 || P1_deck <= 0){
            DieFrame die = new DieFrame();
            this.dispose();
            die.setVisible(true);
        };
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        deck_1 = new javax.swing.JButton();
        deck_2 = new javax.swing.JButton();
        deck_3 = new javax.swing.JButton();
        deck_4 = new javax.swing.JButton();
        hp_p1_label = new javax.swing.JLabel();
        hp_cpu_label = new javax.swing.JLabel();
        dmgToCPU = new javax.swing.JLabel();
        dmgToP1 = new javax.swing.JLabel();
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
        panelMenu = new javax.swing.JPanel();
        btnRestart = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        LayoutGame = new javax.swing.JLabel();
        winPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1028, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(deck_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 510, 168, 233));

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
        getContentPane().add(deck_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 510, 168, 233));

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
        getContentPane().add(deck_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 510, 168, 233));

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
        getContentPane().add(deck_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 510, 168, 233));

        hp_p1_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_p1_label.setText("HP Player : 10000");
        getContentPane().add(hp_p1_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        hp_cpu_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_cpu_label.setText("HP CPU : 10000");
        getContentPane().add(hp_cpu_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        dmgToCPU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dmgToCPU.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(dmgToCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, 30));

        dmgToP1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dmgToP1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(dmgToP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, 100, 30));

        highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackLarge.png"))); // NOI18N
        getContentPane().add(highlight_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 200, 196, 273));

        highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackLarge.png"))); // NOI18N
        getContentPane().add(highlight_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 200, 196, 273));

        p1_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_deck_label.setText("Deck : x00");
        getContentPane().add(p1_deck_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 140, 40));

        cpu_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_deck_label.setText("Deck : x00");
        getContentPane().add(cpu_deck_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 100, 40));

        p1_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_graveyard_label.setText("Graveyard : x00");
        getContentPane().add(p1_graveyard_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 140, 50));

        cpu_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_graveyard_label.setText("Graveyard : x00");
        getContentPane().add(cpu_graveyard_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 140, 40));

        turnLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        turnLabel.setText("Turn : 0");
        getContentPane().add(turnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/BC033.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 90, 100));

        HealthBar.setBackground(new java.awt.Color(0, 153, 153));
        HealthBar.setLayout(new java.awt.CardLayout());

        cpuHealthBar.setBackground(new java.awt.Color(0, 153, 51));
        cpuHealthBar.setMaximum(10000);
        cpuHealthBar.setBorderPainted(false);
        cpuHealthBar.setPreferredSize(new java.awt.Dimension(150, 25));
        HealthBar.add(cpuHealthBar, "card2");

        getContentPane().add(HealthBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 160, 30));

        healthBarPanel.setBackground(new java.awt.Color(0, 153, 153));
        healthBarPanel.setLayout(new java.awt.CardLayout());

        healthBar.setBackground(new java.awt.Color(0, 153, 51));
        healthBar.setMaximum(10000);
        healthBar.setBorderPainted(false);
        healthBarPanel.add(healthBar, "card2");

        getContentPane().add(healthBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 25));

        Deck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Deck.png"))); // NOI18N
        getContentPane().add(Deck, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 515, 200, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 30, 90, 130));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 30, 90, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 31, 90, 130));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/cardbackEnemy.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 30, 90, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/Battlecard/BC033.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 90, 100));

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
                    .addComponent(btnRestart, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
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

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 220, 240));

        btnMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 190, 50));

        LayoutGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/gameplay.png"))); // NOI18N
        LayoutGame.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(LayoutGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGSrc/win.png"))); // NOI18N

        javax.swing.GroupLayout winPanelLayout = new javax.swing.GroupLayout(winPanel);
        winPanel.setLayout(winPanelLayout);
        winPanelLayout.setHorizontalGroup(
            winPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        winPanelLayout.setVerticalGroup(
            winPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(winPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deck_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_1ActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.OK_OPTION);
        if(konfirm == 0){
            deckOnClick(0);
        }
    }//GEN-LAST:event_deck_1ActionPerformed

    private void deck_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_2ActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.YES_NO_OPTION);
        if(konfirm == 0){
            deckOnClick(1);
        }
    }//GEN-LAST:event_deck_2ActionPerformed

    private void deck_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_3ActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.YES_NO_OPTION);
        if(konfirm == 0){
            deckOnClick(2);
        }
    }//GEN-LAST:event_deck_3ActionPerformed

    private void deck_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_4ActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.YES_NO_OPTION);
        if(konfirm == 0){
            deckOnClick(3);
        }
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
        panelMenu.setVisible(true);
        panelMenu.setSize(300,300);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        panelMenu.setVisible(false);
        
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        new GameFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        Menu main = new Menu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

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
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRestart;
    private javax.swing.JProgressBar cpuHealthBar;
    private javax.swing.JLabel cpu_deck_label;
    private javax.swing.JLabel cpu_graveyard_label;
    private javax.swing.JButton deck_1;
    private javax.swing.JButton deck_2;
    private javax.swing.JButton deck_3;
    private javax.swing.JButton deck_4;
    private javax.swing.JLabel dmgToCPU;
    private javax.swing.JLabel dmgToP1;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JPanel healthBarPanel;
    private javax.swing.JLabel highlight_1;
    private javax.swing.JLabel highlight_2;
    private javax.swing.JLabel hp_cpu_label;
    private javax.swing.JLabel hp_p1_label;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel p1_deck_label;
    private javax.swing.JLabel p1_graveyard_label;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel turnLabel;
    private javax.swing.JPanel winPanel;
    // End of variables declaration//GEN-END:variables
}
