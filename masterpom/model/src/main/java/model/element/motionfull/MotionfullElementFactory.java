package model.element.motionfull;

import model.element.Map;

public class MotionfullElementFactory {

	private static Map MAP;

	/** The Constant character. */
	private static final Character Character = new Character(MAP);
	
	/** The Constant pointEnemy. */
	private static final PointEnemy PointEnemy = new PointEnemy(MAP);

	/** The Constant pointEnemy. */
	private static final DiamondEnemy DiamondEnemy = new DiamondEnemy(MAP);
	
	private static final Diamond Diamond = new Diamond(MAP);

	private static final Rock Rock = new Rock(MAP);
	

	private static MotionFullElement[] motionfullElements = { Character, PointEnemy, DiamondEnemy, Diamond, Rock};

	public static void setMap(Map map) {
		MAP = map;
	}

	public static MotionFullElement createCharacter(Map map) {
		setMap(map);
		return Character;
	}

	public static MotionFullElement createPoint(Map map) {
		setMap(map);
		return PointEnemy;
	}

	public static MotionFullElement createDiamondEnemy(Map map) {
		setMap(map);
		return DiamondEnemy;
	}
	
	public static MotionFullElement createDiamond(Map map) {
		setMap(map);
		return Diamond;
	}
	
	public static MotionFullElement createRock(Map map) {
		setMap(map);
		return Rock;
	}

	public static MotionFullElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionFullElement motionfullElement : motionfullElements) {
			if (motionfullElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionfullElement;
			}
		}
		return null;
	}
}
