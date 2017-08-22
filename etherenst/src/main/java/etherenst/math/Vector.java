package etherenst.math;

public class Vector {

	public double x, y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return this.x;
	}

	public double y() {
		return this.y;
	}

	public Vector x(double n) {
		this.x = n;
		return this;
	}

	public Vector y(double n) {
		this.y = n;
		return this;
	}

	public Vector add(Vector v) {
		return add(v.x, v.y);
	}

	public Vector add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector sub(Vector v) {
		return sub(v.x, v.y);
	}

	public Vector sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector mul(Vector v) {
		return mul(v.x, v.y);
	}

	public Vector mul(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector mul(double speed) {
		return mul(speed, speed);
	}

	public Vector div(Vector v) {
		return div(v.x, v.y);
	}

	public Vector div(double x, double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	public double dot(Vector v) {
		return this.x * v.x + this.y * v.y;
	}

	public double length() {
		return Math.sqrt(length2());
	}

	public double length2() {
		return dot(this);
	}

	public Vector normalize() {
		double length = length();
		return new Vector(x / length, y / length);
	}

	public Vector copy() {
		return new Vector(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
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
		if (!(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public void zero() {
		x(0).y(0);
	}

}
