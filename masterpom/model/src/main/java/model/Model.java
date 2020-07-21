package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import imodel.IMap;
import imodel.IMobile;
import imodel.IModel;
import imodel.Sprite;
import model.element.motionfull.Hero;

/**
 * The Class Model.
 *
 * @author nodji
 */
public final class Model implements IModel {
	
	/** The map*/
	private IMap map;

	/** The player*/
	private Hero character;

	
	public Model(final int mapID) throws SQLException, IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(Elementboulder.getMapById(mapID));
		this.setHero(new Hero(1, 1, this.getMap()));
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
	public Hero getCharacter() {
		return this.character;
	}

	/**
	 * @param character the character to set
	 */
	public void setHero(Hero character) {
		this.character = character;
	}

	
}
