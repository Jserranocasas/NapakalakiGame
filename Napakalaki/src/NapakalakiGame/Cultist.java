package NapakalakiGame;

/**
 * @brief   Class to represent cultist cards
 * @file    Cultist.java
 * @author  Javier Serrano Casas
 * @date    27-05-2018
 */
public class Cultist implements Card{
    private final String name;
    private final int gainedLevels;
    private final String image;
    
    Cultist(int gainedLevels, String image) {
        this.name = "Sectario";
        this.gainedLevels = gainedLevels;
        this.image = image;
    }
    
    public String getImage(){
        return image;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + " Leves: " + this.gainedLevels;
    }

    @Override
    public int getBasicValue() {
        return this.gainedLevels;
    }

    @Override
    public int getSpecialValue() {
        return this.getBasicValue() * CultistPlayer.getTotalCultistPlayers();   
    }
}
