package NapakalakiGame;

import java.util.ArrayList;

/**
 * @brief   Class that represent the consequences in case of losing
 * @file    CultistPlayer.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayers;
    private final Cultist myCultistCard;

    /**
     * @brief Public Constructor to class CultistPlayer
     */
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    /**
     * @return combat level of cultist player
     */
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + getMyCultistCard().getSpecialValue();
    }
    
    /**
     * @return boolean value to know if it should be converted to cultist player
     */
    @Override
    public boolean shouldConvert() {
        return false;
    }

    /**
     * @bried Method to get oponent level of a monster
     * @param m Monster to consult
     * @return oponent level of monster m
     */
    @Override
    public int getOponentLevel(Monster m) {
        return m.getSpecialValue();
    }
    
    /**
     * @brief Method to compute gold coins value
     * @param t ArrayList with treasure cards
     * @return gold coins value
     */
    @Override
    public int computeGoldCoinsValue(ArrayList<Treasure> t){
        return super.computeGoldCoinsValue(t) * 2;
    }
    
    /**
     * @return the totalcultistplayers
     */
    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }

    /**
     * @return the myCultistCard
     */
    public Cultist getMyCultistCard() {
        return myCultistCard;
    }
}
