package etherenst;

import java.util.ArrayList;
import java.util.List;

import etherenst.math.Vector;

public class Realm {

	private ArrayList<Unit> units = new ArrayList<Unit>();

	Realm() {

	}

	public void update() {
		for (Unit u : units) {
			if(u.target() == null)
				continue;

			u.aabb().move(u.vel().x, u.vel().y);
			boolean moved = true;

			for (Unit toTestWith : units) {
				if (toTestWith == u)
					continue;
				if (u.aabb().intersectsOrTouches(toTestWith.aabb())) {
					u.aabb().move(-u.vel().x, -u.vel().y);
					moved = false;
					u.target(null);
				}
			}
			
			if(moved) {
				if(u.aabb().contains(u.target())) {
					u.target(null);
				}
			}
			
			System.out.println(u.aabb());
		}
	}

	public Unit addUnit(int team, UnitType type, Vector pos) {
		Unit u = new Unit(team, type, pos);
		units.add(u);
		return u;
	}

	public List<Unit> units() {
		return this.units;
	}

}
