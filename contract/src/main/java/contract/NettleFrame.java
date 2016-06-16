package contract;

import java.awt.Dimension;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import contract.IOrderPerformed;
import contract.INettleWorld;
import contract.INettleFrame;

public class NettleFrame extends JFrame implements KeyListener, INettleFrame {
	private static final long				serialVersionUID	= 1500600853286674118L;
	private final NettleBoardPanel	mapPanel;
	private NettleBoardPanel				meetingPanel;
	private final IOrderPerformed		nettlePlay;
	private final NettleCardView		nettleCardView;

	public NettleFrame(final String title, final INettleWorld nettleWorld, final IOrderPerformed nettlePlay) {
		this.setTitle(title);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nettlePlay = nettlePlay;
		this.mapPanel = new NettleBoardPanel(new Dimension(nettleWorld.getWidth(), nettleWorld.getHeight()), nettleWorld.getElements(), nettleWorld.getMobiles(),
				nettleWorld.getHero().getPosition(), NettleView.MAP_ZOOM);
		this.setResizable(false);
		nettleWorld.addObserver(this.mapPanel);
		this.addKeyListener(this);
		this.nettleCardView = new NettleCardView();
		this.getContentPane().setLayout(this.nettleCardView);
		this.getContentPane().add(this.mapPanel, "MAP");
		this.setVisible(true);
	}

	private IOrderPerformed getNettlePlay() {
		return this.nettlePlay;
	}

	public void setMeeting(final INettleWorld nettleWorld) {
		if (this.meetingPanel != null) {
			this.nettleCardView.removeLayoutComponent(this.meetingPanel);
		}
		this.meetingPanel = new NettleBoardPanel(new Dimension(nettleWorld.getWidth(), nettleWorld.getHeight()), nettleWorld.getElements(),
				nettleWorld.getMobiles(), nettleWorld.getHero().getPosition(), NettleView.MEETING_ZOOM);
		nettleWorld.addObserver(this.meetingPanel);
		this.getContentPane().add(this.meetingPanel, "MEETING");
	}

	public void refresh(final Point center) {
		this.mapPanel.setCenter(center);
	}

	public void setViewMode(final int viewMode) {
		switch (viewMode) {
			case NettleView.VIEW_MODE_MEETING:
				this.nettleCardView.show(this.getContentPane(), "MEETING");
				break;
			case NettleView.VIEW_MODE_MAP:
				this.nettleCardView.show(this.getContentPane(), "MAP");
				break;
			default:
				break;
		}
	}

	public void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getNettlePlay().orderPerform(NettleView.keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void keyReleased(final KeyEvent arg0) {
	}

	public void keyTyped(final KeyEvent arg0) {
	}
}
