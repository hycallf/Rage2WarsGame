/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author KuroNeko
 */
public class GameFrame extends javax.swing.JFrame {
Timer timer;
private final card[] Card = new card[21];
    private final int[] Indexes = new int[5];
    private int healthP1 = 3000;
    private int healthCPU = 3000;
    private card Cpu, P1 = null;
    private int P1_graveyard = 0, Cpu_graveyard = 0, P1_deck = 20, Cpu_deck = 20;
    int turn = 0;


    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        setLocationRelativeTo(null);
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
        timer = new Timer();
        timer.schedule(new countdown(), 0, 1000);
        
        
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
        healthBar1.setValue(healthCPU);
        
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
        highlight_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + P1.getHighlight())));
        highlight_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CardHighlight/" + Cpu.getHighlight())));
        Indexes[index] = getRandomIndex();
        setImageDeck();
        battle();
        setAllLabel();
        getTimer();
    }
    
    private void getTimer(){
        timer.cancel();
        lbTimer.setText(String.valueOf(60));
        timer = new Timer();
        timer.schedule(new countdown(), 0, 1000);

    }

   public class countdown extends TimerTask {
        int sec = Integer.parseInt(lbTimer.getText());
        
        
        public void run() {
            if (sec > 0){
                lbTimer.setText(String.valueOf(sec));
                sec--;
            }else{
                lbTimer.setText("0");
            }
            
        }
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
        } else if ((Cpu.getType().equals("kertas") && P1.getType().equals("gunting"))
                || (Cpu.getType().equals("gunting") && P1.getType().equals("batu"))
                || (Cpu.getType().equals("batu") && P1.getType().equals("kertas"))) {
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
        dmgToP1 = new javax.swing.JLabel();
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
        lbTimer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        getContentPane().add(deck_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 480, 135, 230));

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
        getContentPane().add(deck_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 480, 135, 230));

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
        getContentPane().add(deck_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 480, 135, 230));

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
        getContentPane().add(deck_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 480, 135, 230));

        deck_5.setBorderPainted(false);
        deck_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deck_5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deck_5MouseExited(evt);
            }
        });
        deck_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deck_5ActionPerformed(evt);
            }
        });
        getContentPane().add(deck_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 480, 135, 230));

        hp_p1_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_p1_label.setText("HP Player : 3000");
        getContentPane().add(hp_p1_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        hp_cpu_label.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hp_cpu_label.setText("HP CPU : 3000");
        getContentPane().add(hp_cpu_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        dmgToCPU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dmgToCPU.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(dmgToCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, 30));

        dmgToP1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dmgToP1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(dmgToP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, 100, 30));
        getContentPane().add(highlight_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 62, 170, 300));
        getContentPane().add(highlight_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 72, 170, 290));

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
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, 50));

        healthBarPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        healthBar1.setBackground(new java.awt.Color(0, 153, 51));
        healthBar1.setMaximum(3000);
        healthBar1.setToolTipText("");
        healthBar1.setBorderPainted(false);
        healthBarPanel1.add(healthBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        getContentPane().add(healthBarPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, 20));

        healthBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        healthBar.setBackground(new java.awt.Color(0, 153, 51));
        healthBar.setMaximum(3000);
        healthBar.setBorderPainted(false);
        healthBarPanel.add(healthBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        getContentPane().add(healthBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 190, 20));

        lbTimer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbTimer.setText("60");
        getContentPane().add(lbTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Cooldown :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GameScreen.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

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

    private void deck_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deck_5ActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Are You Sure?.","Select Card", JOptionPane.YES_NO_OPTION);
        if(konfirm == 0){
            deckOnClick(4);
        }
    }//GEN-LAST:event_deck_5ActionPerformed

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

    private void deck_5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_5MouseEntered
        deck_5.setBackground(Color.blue);
    }//GEN-LAST:event_deck_5MouseEntered

    private void deck_5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deck_5MouseExited
        deck_5.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_deck_5MouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        timer.cancel();
        int konfirm = JOptionPane.showConfirmDialog(null, "Back to menu","Exit game", JOptionPane.YES_NO_OPTION);

        if(konfirm == 0){
            this.dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

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
    private javax.swing.JLabel dmgToP1;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JProgressBar healthBar1;
    private javax.swing.JPanel healthBarPanel;
    private javax.swing.JPanel healthBarPanel1;
    private javax.swing.JLabel highlight_1;
    private javax.swing.JLabel highlight_2;
    private javax.swing.JLabel hp_cpu_label;
    private javax.swing.JLabel hp_p1_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbTimer;
    private javax.swing.JLabel p1_deck_label;
    private javax.swing.JLabel p1_graveyard_label;
    private javax.swing.JLabel turnLabel;
    // End of variables declaration//GEN-END:variables
}
