package etherenst.debg;

import etherenst.JORts;

public abstract class Debug {
	
	protected final JORts os;
	
	public Debug(JORts os) {
		this.os = os;
		this.os.debugger(this);
	}
	
	public abstract void update();
	
}
