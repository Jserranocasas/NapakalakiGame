package NapakalakiGame;

import java.util.ArrayList;

/**
 * @brief   Class that represent the consequences in case of losing
 * @file    BadStuff.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class BadStuff {
    private String text;            //It tells us a bad stuff
    private int levels;             //Levels that are lost
    private int nVisibleTreasures;  //Number of visible treasures that are lost
    private int nHiddenTreasures;   //Number of hidden treasures that are lost.
    private boolean death;          //Death type bad stuff
    private final ArrayList<TreasureKind> specificHiddenTreasures;
    private final ArrayList<TreasureKind> specificVisibleTreasures;
    
    /**
     * @brief Public Constructor to class BadStuff
     * @param text It tells us a bad stuff
     * @param levels Levels that are lost
     * @param nVisible Number of visible treasures that are lost
     * @param nHidden Number of hidden treasures that are lost
     */
    public BadStuff(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.death = false;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        specificHiddenTreasures = null;
        specificVisibleTreasures = null;
    }
    
    /**
     * @brief Public Constructor to class BadStuff
     * @param text It tells us a bad stuff
     * @param death Death type bad stuff
     */
    public BadStuff(String text, boolean death){
        this.text = text;
        this.death = death;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;        
        specificHiddenTreasures = null;
        specificVisibleTreasures = null;
    }

    /**
     * @brief Public Constructor to class BadStuff
     * @param text It tells us a bad stuff
     * @param levels Levels that are lost
     * @param tVisible visible treasures that are lost
     * @param tHidden hidden treasures that are lost
     */
    public BadStuff(String text, int levels, ArrayList<TreasureKind> tVisible, 
                                             ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.death = false;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
        if(tVisible == null){
            this.nVisibleTreasures = 0;
        } else {
            this.nVisibleTreasures = tVisible.size();
        }
        if(tHidden == null){
            this.nHiddenTreasures = 0;
        } else {
            this.nHiddenTreasures = tHidden.size();
        }
    }
    
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the levels
     */
    public int getLevels() {
        return levels;
    }

    /**
     * @param levels the levels to set
     */
    public void setLevels(int levels) {
        this.levels = levels;
    }

    /**
     * @return the nVisibleTreasures
     */
    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    /**
     * @param nVisibleTreasures the nVisibleTreasures to set
     */
    public void setnVisibleTreasures(int nVisibleTreasures) {
        this.nVisibleTreasures = nVisibleTreasures;
    }

    /**
     * @return the nHiddenTreasures
     */
    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    /**
     * @param nHiddenTreasures the nHiddenTreasures to set
     */
    public void setnHiddenTreasures(int nHiddenTreasures) {
        this.nHiddenTreasures = nHiddenTreasures;
    }

    /**
     * @return the death
     */
    public boolean kills() {
        return death;
    }

    /**
     * @param death the death to set
     */
    public void setDeath(boolean death) {
        this.death = death;
    }
    
    /**
     * @return boolean value to know if bad stuff is empty
     */
    public boolean isEmpty(){
        return (levels == 0 && !death && nHiddenTreasures == 0 && nVisibleTreasures == 0
                && getSpecificHiddenTreasures().isEmpty() && getSpecificVisibleTreasures().isEmpty());
    }
    
    /**
     * @brief Apply bad stuff removing visible treasure
     * @param t treasure to remove
     */
    public void substractVisibleTreasure(Treasure t){
        getSpecificVisibleTreasures().remove(t);
    }
    
    /**
     * @brief Apply bad stuff removing hidden treasure
     * @param t treasure to remove
     */
    public void substractHiddenTreasure(Treasure t){
        getSpecificHiddenTreasures().remove(t);
    }
    
    /**
     * @brief Method that fit treasure list with visible and hidden treasure that the player must undo.
     * @param v visible treasures
     * @param h hidden treasures
     * @return bad stuff with a list of visible and hidden treasure types that the player must undo.
     */
    BadStuff adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        if(specificVisibleTreasures != null){
            for (Treasure t: v) {
                for (TreasureKind tk : specificVisibleTreasures){
                    if(tk == t.getType())
                        tVisible.add(t.getType());
                }
            }
        } else if (nVisibleTreasures != 0){
            int i=0;
            while(nVisibleTreasures > 0 && i<v.size()){
                Treasure t = v.get(i++);
                tVisible.add(t.getType());
                nVisibleTreasures--;
            }
        }

        if(specificHiddenTreasures != null){
            for (Treasure t: h) {
                for (TreasureKind tk : specificHiddenTreasures){
                    if(tk == t.getType())
                        tHidden.add(t.getType());
                }
            }
        } else if (nHiddenTreasures != 0){
            int i=0;
            while(nHiddenTreasures > 0  && i<h.size()){
                Treasure t = h.get(i++);
                tHidden.add(t.getType());
                nHiddenTreasures--;
            }
        }
        
        return  new BadStuff(text, 0, tVisible, tHidden);
    }
    
    @Override
    public String toString(){
        return "Text = " + text + " levels = " + Integer.toString(levels)
                + " nVisibleTreasures = " + Integer.toString(nVisibleTreasures)
                + " nHiddenTreasures = " + Integer.toString(nHiddenTreasures); 
    }

    /**
     * @return the specificHiddenTreasures
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    /**
     * @return the specificVisibleTreasures
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
}
