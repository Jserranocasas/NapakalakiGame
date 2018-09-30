package NapakalakiGame;
import GUI.Dice;
import java.util.ArrayList;

/* @brief   Class that represent to a player
 * @file    Player.java
 * @author  Javier Serrano Casas
 * @date    02-05-2018
 */
public class Player {
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    private BadStuff pendingBadStuff;
    private String name;
    private boolean dead;
    private int level;
    
    /**
     * Public Constructor of class Player
     */
    public Player(String name){
        visibleTreasures = new ArrayList<>();
        hiddenTreasures = new ArrayList<>();
        this.name = name;
        this.level = 1;
        this.dead = true;
    }
    
    /**
     * Public Constructor of class Player
     */
    public Player(Player p){
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
        this.pendingBadStuff = p.pendingBadStuff;
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
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
     * @return the name
     */
    public String getLevel() {
        return Integer.toString(level);
    }
    
    /**
     * @brief Check if player is dead
     * @return true if player is dead otherwise false
     */
    public boolean isDead(){
        return dead;
    }
    
    /**
     * @return the level
     */
    public int getLevels(){
        return level;    
    }
    
    /**
     * @return hiddenTreasures 
     */
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    /**
     * @return visibleTreasures 
     */
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    /**
     * @brief Bring the player to life 
     */
    private void bringToLife(){
        dead = false;
    }
    
    /**
     * @brief Calculate combat level of player
     * @return combat level of player
     */
    public int getCombatLevel(){
        int combatLevel = level;
        
        boolean hasNecklace = false; //Check if has treasure necklace
        for (int i=0; i<visibleTreasures.size() && !hasNecklace; i++) {
            if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                hasNecklace = true;
            }
        }
        
        if(hasNecklace){ //If has necklace
            for (Treasure visible : visibleTreasures){
                combatLevel += visible.getMaxBonus();
            }
        } else {        //Else has necklace
            for (Treasure visible : visibleTreasures){
                combatLevel += visible.getMinBonus();
            }
        }
        return combatLevel;
    }
    
    /**
     * @brief Increase level of player
     * @param number to increase
     */
    private void incrementLevels(int number){
        level += number;
    }
    
    /**
     * @brief Decrease level of player
     * @param number to decrease
     */
    private void decrementLevels(int number){
        if(level - number < 1){
            level = 1;
        } else {
            level -= number;
        }
    }
    
    /**
     * @param b the pendingBadStuff to set
     */
    private void setPendingBadStuff(BadStuff b){
        ArrayList<Treasure> visible = new ArrayList<>();
        ArrayList<Treasure> hidden = new ArrayList<>();
        
        if(b.getnVisibleTreasures() != 0){
            for (Treasure t: visibleTreasures) {
                for (TreasureKind tk : b.getSpecificVisibleTreasures()){
                    if(tk == t.getType()){
                        visible.add(t);
                    }
                }
            }
        }
        
        if(b.getnHiddenTreasures() != 0){
            for (Treasure t: hiddenTreasures) {
                for (TreasureKind tk : b.getSpecificHiddenTreasures()){
                    if(tk == t.getType()){
                        hidden.add(t);
                    }
                }
            }     
        }
        
        if(visibleTreasures.removeAll(visible) || hiddenTreasures.removeAll(hidden)){
            Napakalaki.getInstance().getSound(4).play();
        }

        for (Treasure t : visible) {
            CardDealer.getInstance().giveTreasureBack(t);
        }

        for (Treasure t : hidden) {
            CardDealer.getInstance().giveTreasureBack(t);
        }

        pendingBadStuff = null;
    }
    
    /**
     * @brief Method to kill player. It erases the tresures and lower the level
     */
    private void die(){
        level = 1;

        for (Treasure t : this.visibleTreasures) {
            CardDealer.getInstance().giveTreasureBack(t); 
        }
        
        visibleTreasures.clear(); 
        
        for (Treasure t : this.hiddenTreasures) {
            CardDealer.getInstance().giveTreasureBack(t); 
        }

        hiddenTreasures.clear(); 

        dieIfNoTreasures(); 
    }
    
    /**
     * @brief Check if has treasure necklace and in that case we return to 
     * CardDealer and delete for us
     */
    private void discardNecklaceIfVisible(){
        boolean hasNeckLace = false;
        for(int i=0; i<visibleTreasures.size() && !hasNeckLace; i++){
            if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                CardDealer.getInstance().giveTreasureBack(visibleTreasures.get(i));
                visibleTreasures.remove(i);
                hasNeckLace = true;
            }
        }
    }
    
    /**
     * @brief It kill if there are no treasures
     */
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    
    /**
     * @brief Calculate the levels that the player can buy with the treasure list t.
     * @param t the treasure list
     * @return  the levels that the player can buy
     */
    public int computeGoldCoinsValue(ArrayList<Treasure> t){
        int totalGold = 0;
        for(Treasure treasure : t){
            totalGold += treasure.getGoldCoins();
        }

        return totalGold/1000;
    }
    
    /**
     * @brief Method that check if the player can buy levels
     * @param l levels to add
     * @return true if the levels you buy do not win the game and false otherwise.
     */
    private boolean canIBuyLevels(float l){
        return level + l < 10;
    }
    
    /**
     * @brief Method that apply the good stuff to the player, adding the corresponding 
     * levels and stealing the indicated treasures
     * @param currentMonster Monster
     */
    public void applyPrize(Monster currentMonster){
        int nLevels = currentMonster.getLevelGained();
        incrementLevels(nLevels);

        int nTreasures = currentMonster.getTreasuresGained();
        if (nTreasures > 0) {
            for (int i = 1; i <= nTreasures; i++) {
                Treasure t = CardDealer.getInstance().nextTreasure();
                hiddenTreasures.add(t);
            }
        }
    }
    
    /**
     * Method that performs the process of fighting with a monster
     * @param m Monster to fight
     * @return combar result
     */
    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel(); 
        int monsterLevel = getOponentLevel(m); 

        CombatResult result;
        if (myLevel > monsterLevel) {
            applyPrize(m);

            result = (level >= 10) ? CombatResult.WINANDWINGAME : CombatResult.WIN;
            if(level >= 10){
                Napakalaki.getInstance().getSound(0).stop();
                Napakalaki.getInstance().getSound(9).play();
            }else{
                Napakalaki.getInstance().getSound(2).play();
            }
        } else {
            int escape = Dice.getInstance().nextNumber(); 

            if (escape < 5) {
                boolean amIDead = m.kills(); 

                if (amIDead) {
                    die();
                    result = CombatResult.LOSEANDDIE;
                    Napakalaki.getInstance().getSound(7).play();
                } else {
                    if(shouldConvert()){
                        result = CombatResult.LOSEANDCONVERT;
                        Napakalaki.getInstance().getSound(6).play();
                    } else {
                        result = CombatResult.LOSE;
                        applyBadStuff(m.getBasStuff());                    
                        Napakalaki.getInstance().getSound(3).play();
                    }
                }
            } else {
                result = CombatResult.LOSEANDESCAPE;
                        Napakalaki.getInstance().getSound(8).play();
            }
        }
        discardNecklaceIfVisible();

        return result;
    }
    
    /**
     * @brief Method that Apply the bad roll to the player when he has lost the fight  
     * @param bad BadStuff of the monster
     */
    public void applyBadStuff(BadStuff bad){
        decrementLevels(getLevels());
        pendingBadStuff = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures); 
        setPendingBadStuff(pendingBadStuff);
    }
    
    /**
     * Method in which the player passes treasures hidden to visible
     * @param t treasure to convert
     * @return true if treasure make visible and false otherwise.
     */
    public boolean makeTreasureVisible(Treasure t){
        if (canMakeTreasureVisible(t)) {
            this.visibleTreasures.add(t); 
            this.hiddenTreasures.remove(t); 
            Napakalaki.getInstance().getSound(10).play();
            return true;
        }    
        return false;
    }
    
    /**
     * Method to check if treasure can make visible
     * @param t treasure to check
     * @return true if treasure can make visible and false otherwise.
     */
    public boolean canMakeTreasureVisible(Treasure t){
        if (visibleTreasures.size() < 4){
            if(t.getType() == TreasureKind.ONEHAND){
                int counter = 0;
                for (Treasure tre : visibleTreasures){
                    if(tre.getType() == TreasureKind.BOTHHAND){
                        return false;
                    }
                    if(tre.getType() == TreasureKind.ONEHAND){
                        counter++;
                    }
                }
                if( counter == 1 || counter == 0){
                    return true;
                }
            } else {
                for (Treasure tre : visibleTreasures){
                    if(tre.getType() == t.getType()){
                        return false;
                    }
                }
                return true;
            }
        }
            
        return false;
    }
    
    /**
     * @brief Method that removes the visible treasures indicated from the list 
     * of visible treasures of the player.
     * @param t treasure to remove
     */
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t); 

        if (pendingBadStuff != null && !pendingBadStuff.isEmpty()) {
            pendingBadStuff.substractVisibleTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    /**
     * @brief Method that removes the hidden treasures indicated from the list 
     * of visible treasures of the player.
     * @param t treasure to remove
     */
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t); 

        if (pendingBadStuff != null && !pendingBadStuff.isEmpty()) {
            pendingBadStuff.substractHiddenTreasure(t);
        }

        dieIfNoTreasures();
    }
        
    /**
     * @brief Method that allows you to buy levels before fighting with the current monster.
     * @param visible Visible treasure
     * @param hidden Hidden treasure
     * @return true if the player has purchased levels and false otherwise
     */
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        int levelsMayBought = 0;
        levelsMayBought += computeGoldCoinsValue(visible); 
        levelsMayBought += computeGoldCoinsValue(hidden); 

        boolean canI = canIBuyLevels(levelsMayBought);
        if (canI) {
            incrementLevels(levelsMayBought);
            Napakalaki.getInstance().getSound(5).play();
        }

        visibleTreasures.removeAll(visible); 
        hiddenTreasures.removeAll(hidden); 

        for (Treasure t : visible) {
            CardDealer.getInstance().giveTreasureBack(t);
        }

        for (Treasure t : hidden) {
            CardDealer.getInstance().giveTreasureBack(t);
        }

        return canI;
    }
    
    /**
     * @brief Method to check valid state
     * @return true if valid state and false otherwise
     */
    public boolean validState(){
        return pendingBadStuff == null || 
                (pendingBadStuff.isEmpty() && hiddenTreasures.size() <= 4);
    }
    
    /**
     * @brief Method that provides new treasures so you can continue playing.
     * This method is used when a player is on his first turn or has run out 
     * of hidden or visible treasures
     */
    public void initTreasures(){
        int number = Dice.getInstance().nextNumber();
        
        bringToLife(); 

        int numTheft;
        if( number == 1){
            numTheft = 1;
        } else {
            numTheft = (number == 6) ? 3 : 2;
        }
        
        Treasure treasure; 
        for(int i=0; i<numTheft; i++){
            treasure = CardDealer.getInstance().nextTreasure();  
            hiddenTreasures.add(treasure); 
        }
    }
    
    /**
     * @brief Method to check if the player has visible treasures
     * @return true if the player has visible treasures and false otherwise
     */
    public boolean hasVisibleTreasures(){
        return !visibleTreasures.isEmpty();
    }
    
    /**
     * @brief Method that account for visible treasures the player has
     * @param tKind Treasure kind
     * @return number of visible treasures
     */
    public int howManyVisibleTreasures(TreasureKind tKind){
        int counter = 0;
        for (Treasure t : visibleTreasures){
            if(t.getType() == tKind)
                counter++;
        }
        return counter;
    }
   
    /**
     * @return the oponent level
     */
    public int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    
    /**
     * @brief Method to check if the player should convert
     * @return true if the dice shows the number 6 and false otherwise
     */
    public boolean shouldConvert(){
        return Dice.getInstance().nextNumber() == 6;
    }
    
    /**
     * @brief Method to receive present of a player
     * @param t Treasure
     * @return String
     */
    public String receivePresent(Treasure t) {
        hiddenTreasures.add(t);

        return name + ": Thank you very much!";
    }
}
