package etherenst;

import etherenst.math.AABB;
import etherenst.math.Vector;

public class Unit {

	private int team;
	private UnitType type;

	private AABB aabb;

	private Vector target, vel = new Vector(0, 0);

	Unit(int team, UnitType type, Vector pos) {
		this.type = type;
		this.team = team;
		this.aabb = type.getAABB().copy().move(pos.x, pos.y);
	}

	public int team() {
		return this.team;
	}

	public UnitType type() {
		return this.type;
	}

	public AABB aabb() {
		return this.aabb;
	}

	public Vector target() {
		return this.target;
	}

	public Vector target(Vector v) {
		Vector old = target;
		target = v;
		if (v == null) {
			vel.zero();
		} else {
			vel = target.copy().sub(aabb.center()).normalize().mul(type.speed());
		}
		return old;
	}

	public Vector vel() {
		return this.vel;
	}

}
