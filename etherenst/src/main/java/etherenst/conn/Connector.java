package etherenst.conn;

import java.util.function.Consumer;

public abstract class Connector {
	
	public Connector(int port) {
	}
	
	public abstract void start();
	public abstract void send(byte[] b);
	public abstract void setListener(Consumer<byte[]> listener);
	public abstract void stop();
	
}
