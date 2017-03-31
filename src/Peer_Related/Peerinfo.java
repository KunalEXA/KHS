package Peer_Related;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Harshit Vijayvargia on 3/28/2017.
 */
public class Peerinfo {
    public final String peerId;
    public final String hostName;
    public final String listeningPort;
    public final boolean hasFile;
    public AtomicInteger _bytesDownloadedFrom;
    public BitSet _receivedParts;
    private final AtomicBoolean _interested;

    public Peerinfo(String pID, String hName, String lPort, String hFile)
    {
        peerId = pID;
        hostName = hName;
        listeningPort = lPort;
        hasFile = hFile.equals("1")?true:false;

        //To understand
        _bytesDownloadedFrom = new AtomicInteger (0);
        _receivedParts = new BitSet();
        _interested = new AtomicBoolean (false);

    }
    public int getPeerId() {
        return Integer.parseInt(peerId);
    }

    public int getPort() {
        return Integer.parseInt(hostName);
    }

    public String getPeerAddress() {
        return listeningPort;
    }

    public boolean hasFile() {
        return hasFile;
    }


    //to Understand
    public boolean isInterested() {
        return _interested.get();
    }

    public void setInterested() {
        _interested.set (true);
    }

    public void setNotIterested() {
        _interested.set (false);
    }

}
