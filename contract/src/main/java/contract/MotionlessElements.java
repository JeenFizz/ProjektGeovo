package contract;

import contract.Land;
import contract.MotionlessElement;

public abstract class MotionlessElements {
	public static final MotionlessElement	OSH									= new OsH();
	public static final MotionlessElement	OSV									= new OsV();
	public static final MotionlessElement	OSBALL								= new OsBall();
	public static final MotionlessElement	ENERGYBALL							= new EnergyBall();
	public static final MotionlessElement	EXITCLOSED							= new ExitClose();
	public static final MotionlessElement	EXIT								= new Exit();
	public static final MotionlessElement	LAND									= new Land();

	private static MotionlessElement			motionlessElements[]	= { OSH, OSV, LAND, OSBALL, ENERGYBALL,EXITCLOSED, EXIT };

	 public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return LAND;
	} 
}