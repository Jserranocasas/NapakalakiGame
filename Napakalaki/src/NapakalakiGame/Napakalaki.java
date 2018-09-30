package NapakalakiGame;

import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @brief   Singleton Napakalaki
 * @file    Napakalaki.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class Napakalaki {
    private static Napakalaki INSTANCE = null;
    private final ArrayList<Player> players;
    private Monster currentMonster;
    private Player currentPlayer;
    private boolean canGo;
    ArrayList<AudioClip> sound;
    
    /**
     * Public Constructor of class Napakalaki
     */
    private Napakalaki()  {
        players = new ArrayList<>();
        currentPlayer = null;
        canGo = true;
        sound = new ArrayList<>();
        URL url = this.getClass().getClassLoader().getResource("Sound/SoundGame.wav");
        AudioClip soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Dice.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/WinCombat.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/LoseCombat.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/LoseTreasure.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Sold.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/ConvertCultist.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Dead.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Escape.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Winner.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Change.aiff");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
        url = this.getClass().getClassLoader().getResource("Sound/Present.wav");
        soundBackground = java.applet.Applet.newAudioClip(url);
        sound.add(soundBackground);
    }

    /**
     * @brief Create instance of Napakalaki
     */
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Napakalaki();
        }
    }

    /**
     * @return to access the singleton
     */
    public static Napakalaki getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    /**
     * @return currentPlayer
     */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    /**
     * @return currentMonster
     */
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    /**
     * @brief Initialize players
     * @param names of players
     */
    private void initPlayers(ArrayList<String> names){
        for(String name : names){
                players.add(new Player(name));
        }
    }
    
    /**
     * @brief Choose next player
     * @return next player
     */
    private Player nextPlayer(){
        int index;
        if(currentMonster == null){
            index = ThreadLocalRandom.current().nextInt(0,players.size()-1);
        } else {
            index = players.indexOf(currentPlayer);
            if(index == players.size()-1){
                index = 0;
            } else {
                index += 1; 
            }
            
        }
        currentPlayer = players.get(index);

        return currentPlayer;
    }
    
    /**
     * @brief Method that performs the process of fighting
     * @return combat result
     */
    public CombatResult developCombat(){
        CombatResult combat = currentPlayer.combat(currentMonster);
        if (combat == CombatResult.LOSEANDCONVERT) {
            Cultist cl = CardDealer.getInstance().nextCultist();
            CultistPlayer clPlayer = new CultistPlayer(currentPlayer, cl);

            players.set(players.indexOf(currentPlayer), clPlayer);
            currentPlayer = clPlayer;
        }
        CardDealer.getInstance().giveMonsterBack(currentMonster);

        return combat;
    }
    
    /**
     * @brief Method that removes the visible treasures indicated from the list 
     * of visible treasures of the player.
     * @param treasures treasures to remove
     */
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for (Treasure t : treasures) { 
            currentPlayer.discardVisibleTreasure(t);
            CardDealer.getInstance().giveTreasureBack(t);
        }
    }
    
    /**
     * @brief Method that removes the hidden treasures indicated from the list 
     * of visible treasures of the player.
     * @param treasures treasures to remove
     */
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for (Treasure t : treasures) { 
            currentPlayer.discardHiddenTreasure(t);
            CardDealer.getInstance().giveTreasureBack(t);
        }
    }
    
    /**
     * Method in which the player passes treasures hidden to visible
     * @param treasures Treasures to convert
     */
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for ( Treasure t : treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    /**
     * @brief Method to buy levels
     * @param visible Visible treasures to change
     * @param hidden Hidden treasures to change
     * @return true if the player buy level 
     */
    public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden);
    }
    
    /**
     * @brief Method to init game
     * @param players Player who will play
     */
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        CardDealer.getInstance().initCards(); 
        nextTurn(); 
    }
    
    /**
     * @brief Method that check if treasure can make visible
     * @param t treasure to convert
     * @return true if treasure can make visible and false otherwise
     */
    public boolean canMakeTreasureVisible(Treasure t){
        return currentPlayer.canMakeTreasureVisible(t);
    }
    
    /**
     * @brief Method that check if the player complies with the rules of the game 
     * to can finish his turn.
     * @return true if the game can continue with the next turn
     */
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer = nextPlayer();
            
            boolean dead = currentPlayer.isDead();
            if (dead) {
                currentPlayer.initTreasures(); 
            }
        }
        
        return stateOK;
    }
    
    /**
     * Check if active player complies with the rules to be able to finish
     * @return false if player can't pass turn else true
     */
    public boolean nextTurnAllowed(){
        return (currentPlayer==null) ? true : currentPlayer.validState();
    }
    
    /**
     * @brief Check if the game is over
     * @param result Combat result
     * @return true if the result is winner
     */
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
    /**
     * @brief Method to make present
     * @param t treasure
     * @return String with the result
     */
    public String makePresent(Treasure t) {
        Player playerReceiver = null;

        String result="";
        for (Player pl : this.players) {
            if (!pl.equals(this.currentPlayer)) {
                if (playerReceiver == null) {
                    playerReceiver = pl;
                } else if (pl.getLevels() < playerReceiver.getLevels()) {
                    playerReceiver = pl;                
                }
            }
        }
        
        if (playerReceiver != null) {
            this.currentPlayer.discardHiddenTreasure(t);
            result = playerReceiver.receivePresent(t);
        } 
        
        return result;
    }

    /**
     * @return the canGo
     */
    public boolean isCanGo() {
        return canGo;
    }

    /**
     * @param canGo the canGo to set
     */
    public void setCanGo(boolean canGo) {
        this.canGo = canGo;
    }
    
    /**
     * @return audioclip
     */
    public AudioClip getSound(int index){
        return sound.get(index);
    }
}
