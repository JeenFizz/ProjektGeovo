package view;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import aedt.showboard.IPawn;
import aedt.showboard.ISquare;

class NettleBoardPanel extends aedt.showboard.BoardPanel {
	private static final long serialVersionUID = 2361367180781892671L;

	public NettleBoardPanel(final Dimension dimension, final ISquare[][] squares, final ArrayList<? extends IPawn> pawns, final Point center, final int zoom) {
		super(dimension, squares, pawns, center, zoom);
	}

}
