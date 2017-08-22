package etherenst;

import etherenst.math.AABB;

public class UnitType {
	
	private final AABB aabb;
	
	private double speed;
	
	public UnitType(AABB aabb, double speed) {
		if(aabb.x() != 0 && aabb.y() != 0)
			throw new IllegalArgumentException("UnitType AABB x != 0 || y != 0");
		this.aabb = aabb;

		this.speed = speed;
	}
	
	public AABB getAABB() {
		return aabb.x(0).y(0);
	}

	public double speed() {
		return this.speed;
	}
	
}
