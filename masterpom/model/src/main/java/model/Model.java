package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.element.motionfull.Character;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model implements IModel {
	
	/** The map*/
	private IMap map;

	/** The player*/
	private Character character;

	
	public Model(final int mapID) throws SQLException, IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(Elementboulder.getMapById(mapID));
		this.setCharacter(new Character(1, 1, this.getMap()));
	}
	
	@Override
	public IMap getMap() {
		return this.map;
	}


	@Override
	public void movePawns() {
ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

	if (this.getCharacter().isCrushed())
			this.getCharacter().die();
	
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * @return the character
	 */
	public Character getCharacter() {
		return this.character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}

	
}
