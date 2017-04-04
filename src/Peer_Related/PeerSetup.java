<<<<<<< HEAD
package Peer_Related;
import java.util.*;
/**
 * Created by Harshit Vijayvargia on 3/31/2017.
 */
public class PeerSetup {
    FileManager fileManager;
    PeerManager peerManager;
    PeerInfo peer;
    LinkedList<PeerInfo> peers = new LinkedList<PeerInfo>();

    Properties common_cfg = new Properties();

    PeerSetup(Properties common_cfg, LinkedList<PeerInfo> peers, PeerInfo peer)
    {
        this.peers = peers;
        this.common_cfg = common_cfg;
        this.peer = peer;
        fileManager = new FileManager();

        //making peers to connect to list
        LinkedList<PeerInfo> peersToConnectTo = new LinkedList<>(removePeer(peers, peer.getPeerId()));

        peerManager = new PeerManager(peersToConnectTo);

    }























// this method removes the peer from the peer list and sends the new peer list

    LinkedList<PeerInfo> removePeer(LinkedList<PeerInfo> peers, int peerId)
    {
        LinkedList<PeerInfo> newPeers = new LinkedList<PeerInfo>();

        for(PeerInfo p : peers)
        {
            if (peerId == p.getPeerId()) { continue;}
            else { newPeers.add(p);}
        }
        return newPeers;
    }



}
=======
package Peer_Related;
import java.util.*;
/**
 * Created by Harshit Vijayvargia on 3/31/2017.
 */
public class PeerSetup {
    FileManager fileManager;
    PeerManager peerManager;
    PeerInfo peer;
    LinkedList<PeerInfo> peers = new LinkedList<PeerInfo>();

    Properties common_cfg = new Properties();

    PeerSetup(Properties common_cfg, LinkedList<PeerInfo> peers, PeerInfo peer)
    {
        this.peers = peers;
        this.common_cfg = common_cfg;
        this.peer = peer;
        fileManager = new FileManager();

        //making peers to connect to list
        LinkedList<PeerInfo> peersToConnectTo = new LinkedList<>(removePeer(peers, peer.getPeerId()));

        peerManager = new PeerManager(peersToConnectTo);

    }























// this method removes the peer from the peer list and sends the new peer list

    LinkedList<PeerInfo> removePeer(LinkedList<PeerInfo> peers, int peerId)
    {
        LinkedList<PeerInfo> newPeers = new LinkedList<PeerInfo>();

        for(PeerInfo p : peers)
        {
            if (peerId == p.getPeerId()) { continue;}
            else { newPeers.add(p);}
        }
        return newPeers;
    }



}
>>>>>>> ef0f61f9fff6a8ea8b42a9bda1c6004cc7f478f4
