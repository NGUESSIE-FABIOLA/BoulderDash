package model.element.motionfull;

import model.Map;

public class MotionfullElementFactory {

	private static Map MAP;

	/** The Constant character. */
	private static final MainCharacter Character = new MainCharacter(MAP);
	
	/** The Constant pointEnemy. */
	private static final PointEnemy PointEnemy = new PointEnemy(MAP);

	/** The Constant pointEnemy. */
	private static final DiamondEnemy DiamondEnemy = new DiamondEnemy(MAP);
	
	private static final Diamond Diamond = new Diamond(MAP);

	private static final Rock Rock = new Rock(MAP);
	

	private static MotionfullElement[] motionfullElements = { Character, PointEnemy, DiamondEnemy, Diamond, Rock};

	public static void setMap(Map map) {
		MAP = map;
	}

	public static MotionfullElement createCharacter(Map map) {
		setMap(map);
		return Character;
	}

	public static MotionfullElement createPoint(Map map) {
		setMap(map);
		return PointEnemy;
	}

	public static MotionfullElement createDiamondEnemy(Map map) {
		setMap(map);
		return DiamondEnemy;
	}
	
	public static MotionfullElement createDiamond(Map map) {
		setMap(map);
		return Diamond;
	}
	
	public static MotionfullElement createRock(Map map) {
		setMap(map);
		return Rock;
	}

	public static MotionfullElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionfullElement motionfullElement : motionfullElements) {
			if (motionfullElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionfullElement;
			}
		}
		return null;
	}
}
