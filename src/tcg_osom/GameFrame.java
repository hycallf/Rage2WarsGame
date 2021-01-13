/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author KuroNeko
 */
public class GameFrame extends javax.swing.JFrame {

private final card[] Card = new card[21];
    private final int[] Indexes = new int[5];
    private int healthP1 = 3000;
    private int healthCPU = 3000;
    private card Cpu, P1 = null;
    private int P1_graveyard = 0, Cpu_graveyard = 0, P1_deck = 16, Cpu_deck = 21;
    int turn = 0;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        Card[0] = new card("Card1.png", "Highlight1.png", "Buff Doge", "gunting", 500);
        Card[1] = new card("Card2.png", "Highlight2.png", "Rick'roll", "kertas", 500);
        Card[2] = new card("Card3.png", "Highlight3.png", "U Mad bro?", "batu", 500);
        Card[3] = new card("Card4.png", "Highlight4.png", "Meme Man", "gunting", 300);
        Card[4] = new card("Card5.png", "Highlight5.png", "Pepe", "batu", 300);
        Card[5] = new card("Card6.png", "Highlight6.png", "Doge", "kertas", 300);
        Card[6] = new card("Card7.png", "Highlight7.png", "Rage Man", "gunting", 300);
        Card[7] = new card("Card8.png", "Highlight8.png", "Triggered Boi", "batu", 300);
        Card[8] = new card("Card9.png", "Highlight9.png", "Troll Fail", "kertas", 300);
        Card[9] = new card("Card10.png", "Highlight10.png", "Diccbutt", "gunting", 200);
        Card[10] = new card("Card11.png", "Highlight11.png", "Cereal Guy", "Kertas", 200);
        Card[11] = new card("Card12.png", "Highlight12.png", "Yao ming", "kertas", 200);
        Card[12] = new card("Card13.png", "Highlight13.png", "Triggered", "gunting", 200);
        Card[13] = new card("Card14.png", "Highlight14.png", "Bully Maguire", "batu", 200);
        Card[14] = new card("Card15.png", "Highlight15.png", "Lolol", "kertas", 200);
        Card[15] = new card("Card16.png", "Highlight16.png", "Rage Guy", "gunting", 200);
        Card[16] = new card("Card17.png", "Highlight17.png", "Y U No Do This", "batu", 200);
        Card[17] = new card("Card18.png", "Highlight18.png", "Also Cereal Guy", "kertas", 200);
        Card[18] = new card("Card19.png", "Highlight19.png", "Thumbs Up", "gunting", 200);
        Card[19] = new card("Card20.png", "Highlight20.png", "Bonk Doge", "batu", 200);
        Card[20] = new card("Card21.png", "Highlight21.png", "Herp", "kertas", 200);
        getFirstIndexes();
        setImageDeck();
        setAllLabel();
    }

    private int getRandomIndex() {
        return new Random().nextInt(20 - 0) + 0;
    }
    
    private void setAllLabel() {
        p1_deck_label.setText("Deck : x" + P1_deck);
        p1_graveyard_label.setText("Graveyard : x" + P1_graveyard);
        cpu_deck_label.setText("Deck : x" + Cpu_deck);
        cpu_graveyard_label.setText("Graveyard : x" + Cpu_graveyard);
        hp_p1_label.setText("HP Player : "+ healthP1);
        hp_cpu_label.setText("HP CPU : "+ healthCPU);
        turnLabel.setText("Turn : "+ turn);
    }

    private void getFirstIndexes() {
        Indexes[0] = getRandomIndex();
        Indexes[1] = getRandomIndex();
        Indexes[2] = getRandomIndex();
        Indexes[3] = getRandomIndex();
        Indexes[4] = getRandomIndex();
    }

    private void setImageDeck() {
        deck_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cards/" + Card[Indexes[0]].getImage())));
        deck_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cards/" + Card[Indexes[1]].getImage())));
        deck_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cards/" + Card[Indexes[2]].getImage())));
        deck_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cards/" + Card[Indexes[3]].getImage())));
        deck_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cards/" + Card[Indexes[4]].getImage())));
    }

    private void deckOnClick(int index) {
        
        P1 = Card[Indexes[index]];
        Cpu = Card[getRandomIndex()];
        highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + P1.getHighlight())));
        highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + Cpu.getHighlight())));
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
            healthP1 -= Cpu.getDamage();
            turn++;
        } else if ((Cpu.getType().equals(P1.getType()))
                || (Cpu.getType().equals(P1.getType()))
                || (Cpu.getType().equals(P1.getType()))) {
            P1_deck -= 1;
            P1_graveyard += 1;
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            turn++;
        } else {
            Cpu_deck -= 1;
            Cpu_graveyard += 1;
            healthCPU -= P1.getDamage();
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

        deck_1 = new javax.swing.JButton();
        deck_2 = new javax.swing.JButton();
        deck_3 = new javax.swing.JButton();
        deck_4 = new javax.swing.JButton();
        deck_5 = new javax.swing.JButton();
        hp_p1_label = new javax.swing.JLabel();
        hp_cpu_label = new javax.swing.JLabel();
        dmgToCPU = new javax.swing.JLabel();
        highlight_1 = new javax.swing.JLabel();
        highlight_2 = new javax.swing.JLabel();
        p1_deck_label = new javax.swing.JLabel();
        cpu_deck_label = new javax.swing.JLabel();
        p1_graveyard_label = new javax.swing.JLabel();
        cpu_graveyard_label = new javax.swing.JLabel();
        turnLabel = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        healthBarPanel1 = new javax.swing.JPanel();
        healthBar1 = new javax.swing.JProgressBar();
        healthBarPanel = new javax.swing.JPanel();
        healthBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deck_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_1ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 130, 220));

        deck_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_2ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 130, 220));

        deck_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_3ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 130, 220));

        deck_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_4ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 130, 220));

        deck_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_5ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 130, 220));

        hp_p1_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_p1_label.setText("HP Player : 4000");
        getContentPane().add(hp_p1_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        hp_cpu_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_cpu_label.setText("HP CPU : 4000");
        getContentPane().add(hp_cpu_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        dmgToCPU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dmgToCPU.setForeground(new java.awt.Color(255, 0, 0));
        dmgToCPU.setText("jLabel2");
        getContentPane().add(dmgToCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));
        getContentPane().add(highlight_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 170, 300));
        getContentPane().add(highlight_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 170, 290));

        p1_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_deck_label.setText("Deck : x00");
        getContentPane().add(p1_deck_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 140, 80));

        cpu_deck_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_deck_label.setText("Deck : x00");
        getContentPane().add(cpu_deck_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 140, 80));

        p1_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        p1_graveyard_label.setText("Graveyard : x00");
        getContentPane().add(p1_graveyard_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 140, 80));

        cpu_graveyard_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cpu_graveyard_label.setText("Graveyard : x00");
        getContentPane().add(cpu_graveyard_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 140, 80));

        turnLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        turnLabel.setText("Turn : 0");
        getContentPane().add(turnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        btnMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnMenu.setText("Menu");
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, 50));

        healthBarPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        healthBar1.setBackground(new java.awt.Color(0, 204, 204));
        healthBar1.setMaximum(4000);
        healthBar1.setValue(4000);
        healthBar1.setBorderPainted(false);
        healthBarPanel1.add(healthBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        getContentPane().add(healthBarPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, 20));

        healthBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        healthBar.setBackground(new java.awt.Color(0, 204, 204));
        healthBar.setMaximum(4000);
        healthBar.setValue(4000);
        healthBar.setBorderPainted(false);
        healthBarPanel.add(healthBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        getContentPane().add(healthBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 190, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GameScreen.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

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

    private void deck_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_5ActionPerformed
        deckOnClick(4);
    }//GEN-LAST:event_deck_5ActionPerformed

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
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel cpu_deck_label;
    private javax.swing.JLabel cpu_graveyard_label;
    private javax.swing.JButton deck_1;
    private javax.swing.JButton deck_2;
    private javax.swing.JButton deck_3;
    private javax.swing.JButton deck_4;
    private javax.swing.JButton deck_5;
    private javax.swing.JLabel dmgToCPU;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JProgressBar healthBar1;
    private javax.swing.JPanel healthBarPanel;
    private javax.swing.JPanel healthBarPanel1;
    private javax.swing.JLabel highlight_1;
    private javax.swing.JLabel highlight_2;
    private javax.swing.JLabel hp_cpu_label;
    private javax.swing.JLabel hp_p1_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel p1_deck_label;
    private javax.swing.JLabel p1_graveyard_label;
    private javax.swing.JLabel turnLabel;
    // End of variables declaration//GEN-END:variables
}
