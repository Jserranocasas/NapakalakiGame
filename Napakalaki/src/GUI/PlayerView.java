package GUI;

import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @brief   View Player of MVC model
 * @file    PlayerView.java
 * @author  Javier Serrano Casas
 * @date    30-05-2018
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    public void setNapakalaki(Napakalaki model) throws URISyntaxException {
        this.napakalakiModel = model;
    }
    
    public void setPlayer(Player p) throws URISyntaxException{
        this.playerModel = p;
        cultistView1.setCultist(p);

        TextLevel.setText("Player: " + playerModel.getName());
        TextPlayer.setText("Level: " + playerModel.getLevel());
        fillTreasurePanel (visibleTreasure, playerModel.getVisibleTreasures());
        fillTreasurePanel (hiddenTreasure, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) throws URISyntaxException {
        // Delete old information
        aPanel.removeAll();

        // Construct new panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        
        // Visual update
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextLevel = new javax.swing.JLabel();
        TextPlayer = new javax.swing.JLabel();
        discardTreasures = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        presentTreasure = new javax.swing.JButton();
        buyLevel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        hiddenTreasure = new javax.swing.JPanel();
        visibleTreasure = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cultistView1 = new GUI.CultistView();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 102));

        TextLevel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        TextLevel.setForeground(new java.awt.Color(255, 255, 255));
        TextLevel.setText("Level:");

        TextPlayer.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        TextPlayer.setForeground(new java.awt.Color(255, 255, 255));
        TextPlayer.setText("Player:");

        discardTreasures.setBackground(new java.awt.Color(0, 102, 204));
        discardTreasures.setForeground(new java.awt.Color(255, 255, 255));
        discardTreasures.setText("Discard Treasures");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        makeVisible.setBackground(new java.awt.Color(0, 153, 102));
        makeVisible.setForeground(new java.awt.Color(255, 255, 255));
        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        presentTreasure.setBackground(new java.awt.Color(255, 51, 51));
        presentTreasure.setForeground(new java.awt.Color(255, 255, 255));
        presentTreasure.setText("Present Treasure");
        presentTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentTreasureActionPerformed(evt);
            }
        });

        buyLevel.setBackground(new java.awt.Color(153, 153, 0));
        buyLevel.setForeground(new java.awt.Color(255, 255, 255));
        buyLevel.setText("Buy Levels");
        buyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hidden Treasures");
        jLabel3.setOpaque(true);

        hiddenTreasure.setBackground(new java.awt.Color(74, 48, 23));
        hiddenTreasure.setMaximumSize(new java.awt.Dimension(500, 250));
        hiddenTreasure.setPreferredSize(new java.awt.Dimension(700, 250));
        hiddenTreasure.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        visibleTreasure.setBackground(new java.awt.Color(126, 65, 31));
        visibleTreasure.setMaximumSize(new java.awt.Dimension(500, 250));
        visibleTreasure.setPreferredSize(new java.awt.Dimension(500, 250));
        visibleTreasure.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Visible Treasures");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hiddenTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextLevel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(presentTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(discardTreasures)))
                                .addGap(59, 59, 59)
                                .addComponent(makeVisible))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visibleTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(TextPlayer)
                                .addGap(85, 85, 85))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cultistView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPlayer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeVisible)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buyLevel)
                        .addComponent(presentTreasure)
                        .addComponent(discardTreasures)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hiddenTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cultistView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasure);
        napakalakiModel.discardVisibleTreasures(selVisible);

        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasure);
        napakalakiModel.discardHiddenTreasures(selHidden);

        if(!selHidden.isEmpty() || !selVisible.isEmpty())
            Napakalaki.getInstance().getSound(4).play();
 
        try {
            setPlayer(napakalakiModel.getCurrentPlayer());
        } catch (URISyntaxException ex) {
            Logger.getLogger(PlayerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        repaint();
    }//GEN-LAST:event_discardTreasuresActionPerformed

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasure);
       
        if (selHidden.size() > 0) {
            napakalakiModel.makeTreasuresVisible(selHidden);
            
            if(napakalakiModel.getCurrentPlayer().getHiddenTreasures().size() < 5){
                napakalakiModel.setCanGo(true);
            }
            
            try {
                setPlayer(napakalakiModel.getCurrentPlayer());
            } catch (URISyntaxException ex) {
                Logger.getLogger(PlayerView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            repaint();
        } else {
            JOptionPane.showMessageDialog(null, "You haven't hidden Treasures");
        }
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void presentTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentTreasureActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasure);        
        
        String result;
        if (selHidden.size() > 0) {
            Treasure t = selHidden.get(0);
            result =  napakalakiModel.makePresent(t);
            try {
                setPlayer(napakalakiModel.getCurrentPlayer());
            } catch (URISyntaxException ex) {
                Logger.getLogger(PlayerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            result = "You must select Hidden Treasure";
        }
        
        if(!selHidden.isEmpty())
            Napakalaki.getInstance().getSound(11).play();
        
        repaint();

        //Show Message
        JOptionPane.showMessageDialog(null, result);
    }//GEN-LAST:event_presentTreasureActionPerformed

    private void buyLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasure);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasure);
        napakalakiModel.buyLevels(selVisible, selHidden);

        try {
            setPlayer(napakalakiModel.getCurrentPlayer());
        } catch (URISyntaxException ex) {
            Logger.getLogger(PlayerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(napakalakiModel.getCurrentPlayer().getHiddenTreasures().size() < 5){
            napakalakiModel.setCanGo(true);
        }
                
        repaint();
    }//GEN-LAST:event_buyLevelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextLevel;
    private javax.swing.JLabel TextPlayer;
    private javax.swing.JButton buyLevel;
    private GUI.CultistView cultistView1;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JPanel hiddenTreasure;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton makeVisible;
    private javax.swing.JButton presentTreasure;
    private javax.swing.JPanel visibleTreasure;
    // End of variables declaration//GEN-END:variables
}
