package etherenst;

import etherenst.conn.Connector;

public class Beta {

	public static JORts multiSessionGame(Connector connector, int sessions) {
		return new JORts(connector, sessions);
	}

}
