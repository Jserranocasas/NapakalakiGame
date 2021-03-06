package GUI;

import NapakalakiGame.Napakalaki;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @brief   Singelton Dice
 * @file    Dice.java
 * @author  fvelasco
 */
public class Dice extends javax.swing.JDialog {
    private static Dice INSTANCE = null;
    private final Timer timerDice;
    private int value;
    
    private Dice (java.awt.Frame parent) {
        super(parent, true);

        initComponents();
        ThreadLocalRandom.current();
        timerDice = new Timer (50,diceAction);
        setTitle("Dice");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
    }

    public static void createInstance(java.awt.Frame parent) {
        if (INSTANCE == null) { 
            INSTANCE = new Dice(parent);
        }
    }

    public static Dice getInstance() {
        return INSTANCE;
    }
  
    private int privateNextNumber() {
      return ThreadLocalRandom.current().nextInt(1,7);
    }
  
    private ActionListener diceAction = new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent ev) {
            value = privateNextNumber();
            jL_dice.setText(Integer.toString(value));
            pack();
          }
    };
  

    public int nextNumber () {
        Napakalaki.getInstance().getSound(1).loop();
        jB_OK.setVisible(false);
        pack();
        timerDice.start();
        this.setVisible(true);
        return value;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jB_OK = new javax.swing.JButton();
        jL_dice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("\"Click to stop the dice\"");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(157, 40));
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jB_OK.setText("OK");
        jB_OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_OKMouseClicked(evt);
            }
        });
        jB_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_OKActionPerformed(evt);
            }
        });
        getContentPane().add(jB_OK, java.awt.BorderLayout.PAGE_END);

        jL_dice.setBackground(new java.awt.Color(0, 0, 0));
        jL_dice.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jL_dice.setForeground(new java.awt.Color(255, 255, 255));
        jL_dice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_dice.setText("1");
        jL_dice.setOpaque(true);
        jL_dice.setPreferredSize(new java.awt.Dimension(50, 70));
        jL_dice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_diceMouseClicked(evt);
            }
        });
        getContentPane().add(jL_dice, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jL_diceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_diceMouseClicked
        timerDice.stop();
        Napakalaki.getInstance().getSound(1).stop();
        jB_OK.setVisible(true);
        pack();
    }//GEN-LAST:event_jL_diceMouseClicked

    private void jB_OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_OKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_OKMouseClicked

    private void jB_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_OKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_OKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_OK;
    private javax.swing.JLabel jL_dice;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
