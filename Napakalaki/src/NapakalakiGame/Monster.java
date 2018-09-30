package NapakalakiGame;

/**
 * @brief   Class that represent a card monster
 * @file    Monster.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class Monster implements Card{
    private int levelChangeAgainstCultistPlayer;
    private final BadStuff basStuff;
    private final Prize prize;
    private int combatLevel;
    private String name;
    private String image;
    
    /**
     * Public Constructor of class Monster
     */
    public Monster(String name, int level, BadStuff bc, Prize price, String image){
        this.name = name;
        this.combatLevel = level;
        this.basStuff = bc;
        this.prize = price;
        this.image = image;
    }
    
    /**
     * Public Constructor of class Monster
     */
    public Monster(String name, int level, int lc, BadStuff bc, Prize price, String image){
        this.levelChangeAgainstCultistPlayer = lc;
        this.name = name;
        this.combatLevel = level;
        this.basStuff = bc;
        this.prize = price;
        this.image = image;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the combatLevel
     */
    public int getCombatLevel() {
        return combatLevel;
    }

    /**
     * @param combatLevel the combatLevel to set
     */
    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }
    
    /**
     * @return true if badStuff is death and false otherwise
     */
    boolean kills(){
        return getBasStuff().kills();
    }
    
    /**
     * @return Level gained for the player
     */
    int getLevelGained(){
        return prize.getLevel();
    }
    
    /**
     * @return Treasures gained for the player
     */
    int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    /**
     * @return image of monster
     */
    public String getImage(){
        return image;
    }
    
    @Override
    public String toString(){
        return "Name = " + name + " combatLevel = " + Integer.toString(combatLevel)
                + getBasStuff().toString() + prize.toString(); 
    }

    /**
     * @return the basStuff
     */
    public BadStuff getBasStuff() {
        return basStuff;
    }

    @Override
    public int getBasicValue() {
        return combatLevel ;
    }

    @Override
    public int getSpecialValue() {
        return combatLevel + levelChangeAgainstCultistPlayer;
    }
}
