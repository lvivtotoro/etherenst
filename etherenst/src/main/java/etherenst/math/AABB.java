package etherenst.math;

public final class AABB {

	private double x, y, w, h;

	public AABB(double w, double h) {
		this(0, 0, w, h);
	}

	public AABB(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double w() {
		return w;
	}

	public double h() {
		return h;
	}

	public AABB x(double n) {
		x = n;
		return this;
	}

	public AABB y(double n) {
		y = n;
		return this;
	}

	public AABB w(double n) {
		w = n;
		return this;
	}

	public AABB h(double n) {
		h = n;
		return this;
	}

	public AABB copy() {
		return new AABB(x, y, w, h);
	}

	public AABB move(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public boolean contains(Vector target) {
		return contains(target.x, target.y);
	}

	public boolean contains(double pX, double pY) {
		double x2 = x + w, y2 = y + h;
		return x < pX && x2 > pX && y < pY && y2 > pY;
	}

	public boolean intersectsOrTouches(AABB aabb) {
		return !(aabb.x > (this.x + this.w) || (aabb.x + aabb.w) < this.x || aabb.y > (this.y + this.h)
				|| (aabb.y + aabb.h) < this.y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(h);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(w);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AABB))
			return false;
		AABB other = (AABB) obj;
		if (Double.doubleToLongBits(h) != Double.doubleToLongBits(other.h))
			return false;
		if (Double.doubleToLongBits(w) != Double.doubleToLongBits(other.w))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public String toString() {
		return String.format("AABB(%s,%s,%s,%s)", x, y, w, h);
	}

	public Vector center() {
		return new Vector(x + w / 2, y + h / 2);
	}

	public Vector xy() {
		return new Vector(x, y);
	}

}
