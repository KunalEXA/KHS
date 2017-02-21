import java.util.*;

public class StartPeer 
{
	
	 public static void main (String[] args) throws Exception 
	 {	        
	        final int pid = Integer.parseInt(args[0]);
	        Peer peer = new Peer(pid);
	        Properties CommonProperties = null;
	        peerList peerList = new peerList();
	        Collection<Peer> ConnectionList = new ArrayList<>();
	        try 
	        {
	            CommonProperties = CommonProperties.read ();
	            peerList.read ();
	            Iterator<Peer> PeerIterator = ConnectionList.iterator();
	    		while (PeerIterator.hasNext()) 
	    		{
	    			Peer p = PeerIterator.next();
	    			if(pid == p.getid)
	    			{
	    				peer.address = p.getaddr();
	                    peer.port = p.getPort();
	                    peer.hasFile = p.hasFile();
	                    break;
	    			}
	    			else
	    			{
	    				ConnectionList.add(p);
	    			}
	    		}
	        }
	        catch (Exception e) { }

	        Process startpeer = new Process (pid, peer.address, peer.port, peer.hasFile, peerList.getpeerList(), CommonProperties);
	        //startpeer.init();
	        Thread t = new Thread (startpeer);
	        t.setName (""+pid);
	        t.start();
	        startpeer.connectToPeers (ConnectionList);
	    }
}
