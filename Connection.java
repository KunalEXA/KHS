import java.io.IOException;
import java.net.Socket;

public class Connection {
	

    private final int _connectingpeer;
    private final boolean _isConnected;
    private final int _toConnectPeerId;
    private final Socket _socket;

    public Connection(int connectingpeer, Socket socket) throws IOException {
        this(connectingpeer, false, -1, socket);
    }

    public Connection(int connectingpeer, boolean isConnected, int toConnectPeerId,
                             Socket socket) throws IOException {
        _socket = socket;
        _connectingpeer = connectingpeer;
        _isConnected = isConnected;
        _toConnectPeerId = toConnectPeerId;
    }
}
