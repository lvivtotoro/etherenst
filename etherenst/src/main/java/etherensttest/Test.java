package etherensttest;

import etherenst.EtherenST;
import etherenst.Unit;
import etherenst.UnitType;
import etherenst.conn.NullConnector;
import etherenst.debg.GUISwingDebug;
import etherenst.math.AABB;
import etherenst.math.Vector;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		EtherenST os = new EtherenST(new NullConnector());
		new GUISwingDebug(os);
		Unit u = os.realms()[0].addUnit(0, new UnitType(new AABB(32, 32), 4), new Vector(0, 0));
		u.target(new Vector(128, 128));
	}

}
