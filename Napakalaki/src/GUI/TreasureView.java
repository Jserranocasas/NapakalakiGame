package GUI;
import NapakalakiGame.Treasure;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @brief   View Treasure of MVC model
 * @file    TreasureView.java
 * @author  Javier Serrano Casas
 * @date    30-05-2018
 */
public class TreasureView extends javax.swing.JPanel {
    private Treasure treasureModel;
    private boolean selected;

    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
        selected = false;
    }

    public void setTreasure(Treasure t) throws URISyntaxException{
        this.treasureModel = t;
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(getClass().getResource("/Images/Treasures/"+treasureModel.getImage()).toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        ImageIcon imgIcon = new ImageIcon(img);
        jLabel1.setIcon(imgIcon);
        repaint();
    }
    
    public boolean isSelected() {
        return selected;
    }

    public Treasure getTreasure() {
        return treasureModel;
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

        setBackground(new java.awt.Color(0, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Treasures/M.T.PNG"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 180));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        selected = !selected;
        if(selected){
            jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 143, 243), 6));
        }
        else {
            jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        }
        
        repaint();
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
