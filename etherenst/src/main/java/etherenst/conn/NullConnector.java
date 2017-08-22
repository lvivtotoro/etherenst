package etherenst.conn;

import java.util.function.Consumer;

@Deprecated
public class NullConnector extends Connector {
	
	public NullConnector() {
		super(0);
	}

	@Override
	public void start() {
	}

	@Override
	public void send(byte[] b) {
	}

	@Override
	public void setListener(Consumer<byte[]> listener) {
	}

	@Override
	public void stop() {
	}

}
