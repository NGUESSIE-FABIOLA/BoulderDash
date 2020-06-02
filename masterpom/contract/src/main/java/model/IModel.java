package model;

/**
 *
 *@author Heidy Kengne
 *
 */
public interface IModel {

    /**
     * Gets the map.
     * 
     * @return map
     */
    public IMap getMap();
    
    /** @return the player's character */
    public IMobile getCharacter();
    
    /** Makes the pawn follow their strategy */
    public void movePawns();
}
