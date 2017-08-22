package etherenst;

import etherenst.conn.Connector;

public class Beta {

	public static EtherenST multiSessionGame(Connector connector, int sessions) {
		return new EtherenST(connector, sessions);
	}

}
