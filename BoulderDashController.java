package controller;


import java.sql.SQLException;
import model.Direction;
import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public class BoulderDashController implements IOrderPerformer, IController{
	private IModel boulderDashModel;
	private IUserOrder userOrder[] = new IUserOrder[4];
	private IAlive[][] alives;
	
	public BoulderDashController(IModel boulderDashModel){
		this.boulderDashModel = boulderDashModel;
		userOrder[0] = new UserOrder(Order.UP);
		userOrder[1] = new UserOrder(Order.RIGHT);
		userOrder[2] = new UserOrder(Order.LEFT);
		userOrder[3] = new UserOrder(Order.DOWN);
	}
	/**
	 * Send to the model which order need to be exec
	 * @param userOrder
	 * The order that we want to exec
	 */
	
	
	@Override
	public void orderPerform(IUserOrder userOrder) throws SQLException {
		Direction direction;
		switch (userOrder.getOrder()) {
		case UP:
			direction = Direction.UP;
			break;
		case RIGHT:
			direction = Direction.RIGHT;
			break;
		case DOWN:
			direction = Direction.DOWN;
			break;
		case LEFT:
			direction = Direction.LEFT;
			break;
		default:
			direction = null;
		}
		System.out.println(direction);
		int x = boulderDashModel.getMapXsize(boulderDashModel.getIdMap());
		int y = boulderDashModel.getMapYsize(boulderDashModel.getIdMap());
		boulderDashModel.setDirection(direction);
		boulderDashModel.move(direction ,x,  y,boulderDashModel);
		boulderDashModel.moveMobs(x, y, boulderDashModel);
		Thread thr = new Thread(){
			private IAlive[][] alives;
			private ITile[][] tile;
			private IBlock[][] block;
			public void run(){
				this.alives = boulderDashModel.getAlive();
				this.tile = boulderDashModel.getTile();
				this.block = boulderDashModel.getBlock();
				for(int j = 0; j < y; j++){
					for(int i = 0; i < x; i++){
						if(block[i][j] != null){ 
							if(block[i][j+1] == null && alives[i][j+1] == null && tile[i][j+1] == null){
								block[i][j].fall(i, j, y, boulderDashModel, block[i][j].isPickable());
							}
						}
					}
				}
			}
		};
		thr.start();
	}

	@Override
	public IUserOrder[] getUserOrder() {
		return userOrder;
	}

	public IAlive[][] getAlives() {
		return alives;
	}

	public void setAlives(IAlive[][] alives) {
		this.alives = alives;
	}
}
