package model.element.motionless;


public class MotionlessElementFactory {


	/** The Constant background. */
	private static final Background Background = new Background();

	/** The Constant border. */
	private static final Border Border = new Border();

	/** The Constant exitDoor. */
	private static final ExitDoor ExitDoor = new ExitDoor();

	/** The Constant mud. */
	private static final Mud Mud = new Mud();

	/** The Constant specialStoneWall. */
	private static final SpecialStoneWall SpecialStoneWall = new SpecialStoneWall();

	/** The Constant star. */
	private static final Star Star = new Star();

	/** The Constant wall. */
	private static final Wall Wall = new Wall();

	private static MotionlessElement[] motionlessElements = {Background, Border, ExitDoor, Mud, SpecialStoneWall, Star, Wall};


	public static MotionlessElement createBackground(int level) {
		return Background;
	}

	public static MotionlessElement createBorder(int level) {
		return Border;
	}

	public static MotionlessElement createExitDoor(int level) {
		return ExitDoor;
	}

	public static MotionlessElement createMud(int level) {
		return Mud;
	}

	public static MotionlessElement createSpecialStoneWall(int level) {
		return SpecialStoneWall;
	}

	public static MotionlessElement createStar(int level) {
		return Star;
	}

	public static MotionlessElement createWall(int level) {
		return Wall;
	}

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionlessElement;
			}
		}
		return null;
	}
}
