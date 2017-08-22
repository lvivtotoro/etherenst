package etherenst;

import java.util.HashMap;

import etherenst.conn.Connector;
import etherenst.debg.Debug;

public class EtherenST {

	@SuppressWarnings("unused")
	private HashMap<Integer, UnitType> units = new HashMap<>();

	private Connector connector;

	private final Realm[] realms;

	private final TheLoop loop;

	public EtherenST(Connector connector) {
		this(connector, 1);
	}

	public EtherenST(Connector connector, int sessions) {
		this.realms = new Realm[sessions];
		for (int i = 0; i < realms.length; i++)
			this.realms[i] = new Realm();

		this.connector = connector;
		this.connector.start();
		this.loop = new TheLoop(this);
	}

	public void close() {
		connector.stop();
		loop.stop();
	}

	public Realm[] realms() {
		return this.realms;
	}

	public Connector connector() {
		return this.connector;
	}

	public void debugger(Debug debug) {
		loop.debug = debug;
	}

	public void future(int ticks, Runnable run) {
		loop.scheduled.add(loop.new Job(ticks, run));
	}

}
