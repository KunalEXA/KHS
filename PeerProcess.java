import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PeerProcess 
{
	
	private Peer _peer;
    private final Properties _commonprop;
    private final Collection<Connection> _connHandlers = Collections.newSetFromMap(new ConcurrentHashMap<Connection, Boolean>());

    public PeerProcess(Peer peer, Collection<Peer> peerlist, Properties commonprop) 
    {
        _peer = peer;
        _commonprop = commonprop;    
        //_fileMgr = new FileManager(_peerId, _conf);
        ArrayList<Peer> _peerlist = new ArrayList<>(peerlist);
        for (Peer p : _peerlist) 
        {
            if (p.getId() == _peer.getId()) 
            {
                _peerlist.remove(p);
                break;
            }
        }
    }
    public void run() 
    {
        try {
            ServerSocket serverSocket = new ServerSocket(_peer.getPort());                
                    Connection con = new Connection(_peer.getId(), serverSocket.accept());
                    if (!_connHandlers.contains(con)) 
                    {
                        _connHandlers.add(con);
                    }

        	}
            catch (Exception e) 
            {
            }
            
    }  
    void PeersConnection(Collection<Peer> ConnectionList) {
        Iterator<Peer> iter = ConnectionList.iterator();
        while (iter.hasNext()) {
            do {
                Socket socket = null;
                Peer peer = iter.next();
                try 
                {             
                    socket = new Socket(peer._peerAddress, peer.getPort());
                    Connection conn = new Connection(_peer.getId(), true, peer.getId(),socket); 
                    iter.remove();                          
                }
                catch (Exception ex) 
                {
                }
            }
            while (iter.hasNext());
            iter = ConnectionList.iterator();
            try 
            {
                Thread.sleep(5);
            } 
            catch (Exception e) 
            {
            }
        }
    }   
}
