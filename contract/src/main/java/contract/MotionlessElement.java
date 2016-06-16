package contract;

import contract.Element;
import contract.ISprite;
import contract.Permeability;

public abstract class MotionlessElement extends Element implements IDoActionOnHeroes {
	private final char fileSymbol;

	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}

	
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}
}