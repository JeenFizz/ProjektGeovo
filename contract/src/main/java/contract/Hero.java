package contract;

import java.awt.Point;
import contract.Sprite;

public class Hero extends Mobile {
	private final Point lastPosition;

	public Hero() {
		super(new Sprite("@", "heroes.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}

	@Override
	public void moveUp() {
		this.saveLastPosition();
		super.moveUp();
	}

	@Override
	public void moveLeft() {
		this.saveLastPosition();
		super.moveLeft();
	}

	@Override
	public void moveDown() {
		this.saveLastPosition();
		super.moveDown();
	}

	@Override
	public void moveRight() {
		this.saveLastPosition();
		super.moveRight();
	}
	@Override
	public void moveUPRight() {
		this.saveLastPosition();
		super.moveUPRight();
		
	}
	@Override
	public void moveDownRight() {
		this.saveLastPosition();
		super.moveDownRight();
		
	}
	@Override
	public void moveUPLeft() {
		this.saveLastPosition();
		super.moveUPLeft();
		
	}
	@Override
	public void moveDownLeft() {
		this.saveLastPosition();
		super.moveDownRight();	
	}

	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}

}
