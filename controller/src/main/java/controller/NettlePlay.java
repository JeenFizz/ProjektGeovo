package controller;

import java.io.IOException;

import contract.Hero;
import contract.IDoActionOnHeroes;
import contract.INettleFrame;
import contract.INettleWorld;
import contract.NettleView;



public class NettlePlay implements IOrderPerformed {
	private final INettleWorld	nettleWorld;
	private INettleWorld				nettleMeeting;
	private INettleFrame				nettleFrame;
	private int									playMode;

	public NettlePlay(final INettleWorld nettleWorld) {
		this.nettleWorld = nettleWorld;
		this.nettleWorld.addMobile(new Hero(), 15, 15);
	}

	private INettleWorld getNettleWorld() {
		return this.nettleWorld;
	}

	private INettleWorld getNettleMeeting() {
		return this.nettleMeeting;
	}

	private INettleFrame getNettleFrame() {
		return this.nettleFrame;
	}

	public void setNettleFrame(final INettleFrame nettleFrame) {
		this.nettleFrame = nettleFrame;
	}

	private int getPlayMode() {
		return this.playMode;
	}

	private void setPlayMode(final int playMode) {
		this.playMode = playMode;
		this.getNettleFrame().setViewMode(playMode);
	}

	private INettleWorld getActuelNettleWorld() {
		if (this.getPlayMode() == NettleView.VIEW_MODE_MEETING) {
			return this.getNettleMeeting();
		}
		return this.getNettleWorld();
	}

	
	public void orderPerform(final UserOrder userOrder) throws IOException {
		switch (userOrder) {
			case UP:
				this.getActuelNettleWorld().getHero().moveUp();
				break;
			case RIGHT:
				this.getActuelNettleWorld().getHero().moveRight();
				break;
			case DOWN:
				this.getActuelNettleWorld().getHero().moveDown();
				break;
			case LEFT:
				this.getActuelNettleWorld().getHero().moveLeft();
				break;
			case NOP:
			default:
				break;
		}
		this.getWorldAnswer();
	}

	/* private void resolveEnterCamp() throws IOException {
		this.setNettleMeeting(new NettleWorld("camp.txt"));
		this.resolveWorldAnswer();
	} */

	/* private void resolveEnterTown() throws IOException {
		this.setNettleMeeting(new NettleWorld("town.txt"));
		this.resolveWorldAnswer();
	} */

	/* private void resolveEnterMonastery() throws IOException {
		this.setNettleMeeting(new NettleWorld("monastery.txt"));
		this.resolveWorldAnswer();
	} */

	/* private void resolveWorldAnswer() throws IOException {
		this.getNettleMeeting().addMobile(new Hero(), 0, 0);
		this.getNettleFrame().setMeeting(this.getNettleMeeting());
		this.setPlayMode(NettleView.VIEW_MODE_MEETING);
	} */

	private void exitMetting() throws IOException {
		this.setPlayMode(NettleView.VIEW_MODE_MAP);
	}


	private void getWorldAnswer() throws IOException {
		final IDoActionOnHeroes element = this.getActuelNettleWorld().getElements(this.getActuelNettleWorld().getHero().getX(),
				this.getActuelNettleWorld().getHero().getY());

		switch (element.getActionOnHeroes()) {
			case OPEN_DOOR:
				NettleView.displayMessage("you take the energy ball and open the door");
				//this.opendoor();
				break;
			case TAKE_MONEY:
				NettleView.displayMessage("You take the purse");
				//this.addmoney();
				//this.disapearmoney
				break;
			case HURT:
				NettleView.displayMessage("Hurted by closed door");
				//this.killme();
				break;
			case EXIT:
				NettleView.displayMessage("You leave this place.");
				this.exitMetting();
				break;
			
			case NOP:
			default:
				break;
		}
	}
}
