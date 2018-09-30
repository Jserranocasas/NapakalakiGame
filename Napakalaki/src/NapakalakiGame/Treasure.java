package NapakalakiGame;

/* @brief   
 * @file    Treasure.java
 * @author  Javier Serrano Casas
 * @date    02-05-2018
 */
public class Treasure implements Card{
    private final String name;
    private final int goldCoins;
    private final int minBonus;
    private final int maxBonus;
    private final TreasureKind type;
    private final String image;
    
    public Treasure(){
        this.name = "FOO";
        this.goldCoins = 0;
        this.minBonus = 0;
        this.maxBonus = 0;
        this.type = TreasureKind.ARMOR;
        this.image = "Escopeta.png";
    }

    /**
     * Public Constructor of class Treasure
     */
    public Treasure(String name, int gold, int min, int max, TreasureKind t, String image){
        this.name = name;
        this.goldCoins = gold;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
        this.image = image;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the goldCoins
     */
    public int getGoldCoins() {
        return goldCoins;
    }

    /**
     * @return the minBonus
     */
    public int getMinBonus() {
        return minBonus;
    }

    /**
     * @return the maxBonus
     */
    public int getMaxBonus() {
        return maxBonus;
    }

    /**
     * @return the image 
     */
    public String getImage(){
        return image;
    }
    
    /**
     * @return the type
     */
    public TreasureKind getType() {
        return type;
    }

    @Override
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return getMaxBonus();
    }
    
}
