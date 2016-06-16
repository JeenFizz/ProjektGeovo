package controller;

import java.io.IOException;

import javax.swing.SwingUtilities;

import contract.INettleFrame;
import contract.INettleWorld;
import contract.NettleFrame;
import contract.NettleWorld;

public final class Nettle implements Runnable {
	private final INettleWorld nettleWorld;
	private final NettlePlay nettlePlay;
	private INettleFrame nettleFrame;

	public Nettle() throws IOException {
		this.nettleWorld = new NettleWorld("salle001.txt");
		this.nettlePlay = new NettlePlay(this.nettleWorld);
		SwingUtilities.invokeLater(this);
	}
	
	private INettleWorld getNettleWorld() {
		return this.nettleWorld;
	}
	
	private NettlePlay getNettlePlay() {
		return this.nettlePlay;
	}
	
	public void run() {
		this.nettleFrame = new NettleFrame("Welcome to NettleWorld", this.getNettleWorld(),this.getNettlePlay());
		this.nettlePlay.setNettleFrame(this.nettleFrame);
	}

	
}
