package NapakalakiGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @brief   Singleton that represent a card dealer
 * @file    Dice.java
 * @author  Javier Serrano Casas
 * @date    02-05-2018
 */
public class CardDealer {
    private static CardDealer INSTANCE = null;  // Initialize the singleton.
    private final ArrayList<Monster> unusedMonsters; //
    private final ArrayList<Treasure> unusedTreasure;
    private final ArrayList<Monster> usedMonsters;
    private final ArrayList<Treasure> usedTreasure;
    private final ArrayList<Cultist> unusedCultists;

    /**
     * @brief Private Constructor 
     */
    private CardDealer() {
        unusedMonsters = new ArrayList();
        unusedTreasure = new ArrayList();
        usedMonsters = new ArrayList();
        usedTreasure = new ArrayList();
        unusedCultists = new ArrayList();
    }

    /**
     * @brief Create instance of Card Dealer
     */
    private static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new CardDealer();
        }
    }

    /**
     * @return to access the singleton
     */
    public static CardDealer getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    /**
     * @brief Initialize treasure cards
     */
    private void initTreasureCardDeck(){
        unusedTreasure.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET, "MiAmo.png"));
        unusedTreasure.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE,"BotasInvestigacion.png"));
        unusedTreasure.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET, "CapuchaCthulhu.png"));
        unusedTreasure.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR, "APruebaBabas.png"));
        unusedTreasure.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHAND, "BotasLLA.png"));
        unusedTreasure.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET, "CascoMinero.png"));
        unusedTreasure.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHAND, "AmetralladoraThompson.png"));
        unusedTreasure.add(new Treasure("Camiseta de la UJA", 100, 1, 7, TreasureKind.ARMOR, "CamisetaUja.png"));
        unusedTreasure.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND, "ClavoRail.png"));
        unusedTreasure.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND, "CuchilloSushi.png"));
        unusedTreasure.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET, "FezAlopodo.png"));
        unusedTreasure.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND, "Hacha.png"));
        unusedTreasure.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR, "AparatoTesla.png"));
        unusedTreasure.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHAND, "Gaita.png"));
        unusedTreasure.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND, "Insecticida.png"));
        unusedTreasure.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHAND, "Escopeta.png"));
        unusedTreasure.add(new Treasure("Garabato Mistico", 300, 2, 2, TreasureKind.ONEHAND, "GarabatoMistico.png"));
        unusedTreasure.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE, "M.T.png"));
        unusedTreasure.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR, "RebecaMetalica.png"));
        unusedTreasure.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND, "Mazo.png"));
        unusedTreasure.add(new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.ONEHAND, "NecroPlay.png"));
        unusedTreasure.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHAND, "Lanzallamas.png"));
        unusedTreasure.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND, "NecroComicon.png"));
        unusedTreasure.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHAND, "Necronomicon.png"));
        unusedTreasure.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHAND, "Linterna.png"));
        unusedTreasure.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND, "Necrognomicon.png"));
        unusedTreasure.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET, "Necrotelecom.png"));
        unusedTreasure.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND, "Porra.png"));
        unusedTreasure.add(new Treasure("Tentácula de pega", 200, 0, 1, TreasureKind.HELMET, "Tentaculo.png"));
        unusedTreasure.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE, "ZapatoDejaAmigos.png"));
        unusedTreasure.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHAND, "Shogulador.png"));
        unusedTreasure.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND, "Varita.png"));
    }
    
    /**
     * @brief Initialize moster cards 
     */
    private void initMonsterCardDeck(){
        ArrayList<TreasureKind> tvp = new ArrayList();
        tvp.add(TreasureKind.ONEHAND);
        ArrayList<TreasureKind> thp = new ArrayList();
        thp.add(TreasureKind.ONEHAND);
        ArrayList<TreasureKind> tvp2 = new ArrayList();
        tvp2.add(TreasureKind.ARMOR);
        ArrayList<TreasureKind> thp2 = new ArrayList();
        thp2.add(TreasureKind.ARMOR);
        ArrayList<TreasureKind> tvp3 = new ArrayList();
        tvp3.add(TreasureKind.HELMET);
        ArrayList<TreasureKind> thp3 = new ArrayList();
        thp3.add(TreasureKind.BOTHHAND);
        ArrayList<TreasureKind> tvp4 = new ArrayList();
        tvp4.add(TreasureKind.SHOE);     
        ArrayList<TreasureKind> tvp5 = new ArrayList();
        tvp5.add(TreasureKind.BOTHHAND); 
        ArrayList<TreasureKind> tvp6 = new ArrayList();
        tvp6.add(TreasureKind.ARMOR);         
        tvp6.add(TreasureKind.ONEHAND);         
        tvp6.add(TreasureKind.BOTHHAND);         
        tvp6.add(TreasureKind.HELMET);         
        tvp6.add(TreasureKind.SHOE);         
        tvp6.add(TreasureKind.NECKLACE);  
        ArrayList<TreasureKind> tvp7 = new ArrayList();
        tvp7.add(TreasureKind.ARMOR); 
        tvp7.add(TreasureKind.HELMET);         

        //Create 3 Byakhees de Bonanza
        BadStuff badStuff = new BadStuff("Pierdes tu armadura visible y otra oculta", 0, tvp2, thp2);
        unusedMonsters.add(new Monster("3 Byakhees de Bonanza", 8, badStuff, new Prize(2,1), "Byakhees.png"));
        
        //Create El Rey de Rosa
        badStuff = new BadStuff("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        unusedMonsters.add(new Monster("El Rey de Rosa", 13, badStuff, new Prize(4,2), "ReyRosa.png"));
        
        //Create Ángeles de la Noche Ibicenca
        badStuff = new BadStuff("Te atrapan para llevarte de fiesta y te dejan "
            + "caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, tvp, thp);
        unusedMonsters.add(new Monster("Ángeles de la Noche Ibicenca", 14, badStuff, new Prize(4,1), "Angeles.png"));
        
        //Create Chibithulhu
        badStuff = new BadStuff("Embobados con el lindo primigenio te descartas "
                                        + "de tu casco visible", 0, tvp3, null);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badStuff, new Prize(1,1), "Chibithulhu.png"));

        //Create El Sopor de Dunwich
        badStuff = new BadStuff("El primordial bostezo contagioso. Pierdes el calzado "
                                                            + "visible", 0, tvp4, null);
        unusedMonsters.add(new Monster("El Sopor de Dunwich", 2, badStuff, new Prize(1,1), "Dunwich.png"));
    
        //Create El Gorron en el Umbral
        badStuff = new BadStuff("Pierdes todos tus tesoros visibles", 0, tvp6, null);
        unusedMonsters.add(new Monster("El Gorron en el Umbral", 10, badStuff, new Prize(3,1), "Gorron.png"));
    
        //Create H.P. Munchcraft
        badStuff = new BadStuff("Pierdes la armadura visible", 0, tvp2, null);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badStuff, new Prize(2,1), "Munchcraft.png"));
    
        //Create Bichgooth
        badStuff = new BadStuff("Sientes bichos bajo la ropa. Descarta la armadura "
                                                        + "visible", 0, tvp2, null);
        unusedMonsters.add(new Monster("Bichgooth", 2, badStuff, new Prize(1,1), "Bichgooth.png"));
    
        //Create La que Redacta en las Tinieblas
        badStuff = new BadStuff("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        unusedMonsters.add(new Monster("La que Redacta en las Tinieblas", 2, badStuff, new Prize(1,1), "Redactora.png"));
    
        //Create Los Hondos
        badStuff = new BadStuff("Estos monstruos resultan bastante superficiales y te "
                                            + "aburren mortalmente. Estas muerto", true);
        unusedMonsters.add(new Monster("Los Hondos", 8, badStuff, new Prize(2,1), "Hondos.png"));
  
        //Create Semillas Cthulhu
        badStuff = new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badStuff, new Prize(2,1), "Semillas.png")); 
        
         //Create Dameargo
        badStuff = new BadStuff("Te intentas escaquear.Pierdes una mano visible.",0, tvp,null);
        unusedMonsters.add(new Monster("Dameargo", 1, badStuff, new Prize(2,1), "Dameargo.png"));   
        
        //Create Pollipolipo Volante
        badStuff = new BadStuff("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        unusedMonsters.add(new Monster("Pollipolipo Volante", 3, badStuff, new Prize(1,1), "Pollipolipo.png"));   
        
        //Create Yskhtihyssg-Goth
        badStuff = new BadStuff("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badStuff, new Prize(3,1), "Yskhtihyssg.png"));   
      
        //Create Familia Feliz
        badStuff = new BadStuff("La familia te atrapa. Estás muerto", true);
        unusedMonsters.add(new Monster("Familia Feliz", 1, badStuff, new Prize(4,1), "Familia.png"));   
 
        //Create Roboggoth
        badStuff = new BadStuff("La quinta directiva, primaria te obliga a perder 2 niveles"
                                        + " y un tesoro 2 manos visibles", 2, tvp5, null);
        unusedMonsters.add(new Monster("Roboggoth", 8, badStuff, new Prize(2,1), "Roboggoth.png"));   
       
        //Create El Espia
        badStuff = new BadStuff("Te asusta en la noche. Pierdes un casco visible", 0, tvp3,null);
        unusedMonsters.add(new Monster("El Espia", 5, badStuff, new Prize(1,1), "Espia.png"));   
       
        //Create El Lenguas
        badStuff = new BadStuff("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros"
                                                            + " visibles", 0, tvp3, null);
        unusedMonsters.add(new Monster("El Lenguas", 20, badStuff, new Prize(1,1), "Lenguas.png"));   

        //Create Bicéfalo
        badStuff = new BadStuff("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus"
                                                + "tesoros visibles de las manos", 3, tvp5, null);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badStuff, new Prize(1,1), "Bicefalo.png"));     
        
        //Create El mal indecible impronunciable
        badStuff = new BadStuff("Pierdes 1 mano visible", 0, tvp, null);
        unusedMonsters.add(new Monster("El Mal Indecible Impronunciable", 10, -2, badStuff, new Prize(3,1), "Mal.png")); 
    
        //Create Testigos Oculares
        badStuff = new BadStuff("Pierdes tus tesoros visible. Jajaja", 0, tvp6, null);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, 2, badStuff, new Prize(2,1), "Testigos.png")); 
    
        //Create El Gran Cthulhu
        badStuff = new BadStuff("Hoy no es tu día de suerte. Mueres", true);
        unusedMonsters.add(new Monster("El Gran Cthulhu", 20, 4, badStuff, new Prize(2,5), "GranCthulhu.png")); 
    
        //Create Serpiente Político
        badStuff = new BadStuff("Tu gobierno te recorta 3 niveles.", 2, 0, 0);
        unusedMonsters.add(new Monster("Serpiente Político", 8, -2, badStuff, new Prize(2,1), "Politico.png")); 
    
        //Create Felpuggoth
        badStuff = new BadStuff("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",
                                                                        0, tvp7, thp3);
        unusedMonsters.add(new Monster("Felpuggoth", 2, 5, badStuff, new Prize(1,1), "Felpuggoth.png")); 
    
        //Create Shoggoth
        badStuff = new BadStuff("Pierdes 2 niveles", 2, 0, 0);
        unusedMonsters.add(new Monster("Shoggoth", 16, -4, badStuff, new Prize(4,2), "Shoggoth.png")); 

        //Create Lolitagooth
        badStuff = new BadStuff("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        unusedMonsters.add(new Monster("Lolitagooth", 2, 3, badStuff, new Prize(1,1), "Lolitagooth.png")); 

    }
    
    /**
     * @brief Initialize cultist card
     */
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist(1,"Sectario1.png"));
        unusedCultists.add(new Cultist(2,"Sectario2.png"));
        unusedCultists.add(new Cultist(1,"Sectario3.png"));
        unusedCultists.add(new Cultist(2,"Sectario4.png"));
        unusedCultists.add(new Cultist(1,"Sectario5.png"));
        unusedCultists.add(new Cultist(1,"Sectario6.png"));
    }
    
    /**
     * @brief Method to shuffle treasure cards
     */
    private void shuffleTreasures(){
        ArrayList<Treasure> aux = new ArrayList();
        for(int i=unusedTreasure.size(); i>1; i--){
            int randomNumber = ThreadLocalRandom.current().nextInt(0,i-1);
            aux.add(unusedTreasure.get(randomNumber));
            unusedTreasure.remove(randomNumber);
        }
        aux.add(unusedTreasure.get(0));
        unusedTreasure.remove(0);
        unusedTreasure.addAll(aux);
    }
    
    /**
     * @brief Method to shuffle monster cards
     */
    private void shuffleMonsters(){
        ArrayList<Monster> aux = new ArrayList();
        for(int i=unusedMonsters.size(); i>1; i--){
            int randomNumber = ThreadLocalRandom.current().nextInt(0,i-1);
            aux.add(unusedMonsters.get(randomNumber));
            unusedMonsters.remove(randomNumber);
        }
        aux.add(unusedMonsters.get(0));
        unusedMonsters.remove(0);
        unusedMonsters.addAll(aux);
    }
    
    /**
     * @brief Method to shuffle cultist cards
     */
    private void shuffleCultists(){
        ArrayList<Cultist> aux = new ArrayList();
        for(int i=unusedCultists.size(); i>1; i--){
            int randomNumber = ThreadLocalRandom.current().nextInt(0,i-1);
            aux.add(unusedCultists.get(randomNumber));
            unusedCultists.remove(randomNumber);
        }
        aux.add(unusedCultists.get(0));
        unusedCultists.remove(0);
        unusedCultists.addAll(aux);
    }
    
    /**
     * @return the next treasure card in the deck
     */
    public Treasure nextTreasure(){
        if(unusedTreasure.isEmpty()){
            unusedTreasure.addAll(usedTreasure);
            usedTreasure.clear();
            shuffleTreasures();
        }
        
        Treasure t = unusedTreasure.remove(0);
        giveTreasureBack(t);
        
        return t;
    }
    
    /**
     * @return the next monster card in the deck
     */
    public Monster nextMonster(){
        if(unusedTreasure.isEmpty()){
            unusedMonsters.addAll(usedMonsters);
            usedMonsters.clear();
            shuffleTreasures();
        }
        
        Monster m = unusedMonsters.remove(0);
        giveMonsterBack(m);
        
        return m;
    }
    
    /**
     * @return the next cultist card in the deck
     */
    public Cultist nextCultist(){
        if (unusedCultists.isEmpty()) {
            initCultistCardDeck();
            shuffleCultists(); 
        }
        
        return unusedCultists.remove(0);
    }
    
    /**
     * @brief Return a treasure card to the deck
     * @param t treasure card to be introduced in the deck
     */
    public void giveTreasureBack(Treasure t){
        usedTreasure.add(t);
    }
    
    /**
     * @brief Return a moster card to the deck
     * @param m moster card to be introduced in the deck
     */
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    /**
     * @brief Initialize cards
     */
    public void initCards(){
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistCardDeck();
        shuffleCultists();
    }
}
