package etherenst.debg;

import etherenst.EtherenST;

public abstract class Debug {
	
	protected final EtherenST os;
	
	public Debug(EtherenST os) {
		this.os = os;
		this.os.debugger(this);
	}
	
	public abstract void update();
	
}
