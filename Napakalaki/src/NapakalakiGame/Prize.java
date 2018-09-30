package NapakalakiGame;

/**
 * @brief   Class that represents the value of a card
 * @file    Prize.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class Prize {
    private int treasures;
    private int level;
    
    /**
     * Public Constructor of class Prize
     * @param treasures
     * @param level 
     */
    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }

    /**
     * @return the treasures
     */
    public int getTreasures() {
        return treasures;
    }

    /**
     * @param treasures the treasures to set
     */
    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + " levels = " + Integer.toString(level); 
    }
}
