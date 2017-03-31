package Logging;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;

/**
 * Created by Harshit Vijayvargia on 3/28/2017.
 */
public class logrecord {

    public static Logger peerLogger;
    static logrecord logRecord;
    static String LOGTITLE;
    static
    {
        new logrecord(Logger.getLogger("BitTorrent"));
    }

    public logrecord(Logger bitTorrent) {
        peerLogger = bitTorrent;

    }
    public static logrecord getLogRecord()
    {
        return logRecord;
    }
    public static void setLoggerForPeer(int peerId)
    {
        LOGTITLE = "Peer" + " " + Integer.toString(peerId);
                String filename = "log_peer_" + Integer.toString(peerId) + ".log";
        try {
            Handler loggerHandler = new FileHandler(filename);
            peerLogger.addHandler(loggerHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //To Reframe

    public void peerConnection (int peerId, boolean isConnectingPeer) {
        final String msg = LOGTITLE + (isConnectingPeer ? " makes a connection to Peer %d." : " is connected from Peer %d.");
        peerLogger.info (String.format (msg, peerId));
    }

    public void changeOfPrefereedNeighbors (String preferredNeighbors) {
        final String msg = LOGTITLE + " has preferred neighbors %s";
        peerLogger.info (String.format (msg, preferredNeighbors));
    }

    public void changeOfOptimisticallyUnchokedNeighbors (String preferredNeighbors) {
        final String msg = LOGTITLE + " has the optimistically unchoked neighbor %s";
        peerLogger.info (String.format (msg, preferredNeighbors));
    }

    public void chokeMessage (int peerId) {
        final String msg = LOGTITLE + " is choked by %d.";
        peerLogger.info (String.format (msg, peerId));
    }

    public void unchokeMessage (int peerId) {
        final String msg = LOGTITLE + " is unchoked by %d.";
        peerLogger.info (String.format (msg, peerId));
    }

    public void haveMessage (int peerId, int pieceIdx) {
        final String msg = LOGTITLE + " received the 'have' message from %d for the piece %d.";
        peerLogger.info (String.format (msg, peerId, pieceIdx));
    }

    public void interestedMessage (int peerId) {
        final String msg = LOGTITLE + " received the 'interested' message from %d.";
        peerLogger.info (String.format (msg, peerId));
    }

    public void notInterestedMessage (int peerId) {
        final String msg = LOGTITLE + " received the 'not interested' message from %d.";
        peerLogger.info (String.format (msg, peerId));
    }

    public void pieceDownloadedMessage (int peerId, int pieceIdx, int currNumberOfPieces) {
        final String msg = LOGTITLE + " has downloaded the piece %d from peer %d. Now the number of pieces it has is %d.";
        peerLogger.info (String.format (msg, pieceIdx, peerId, currNumberOfPieces));
    }

    public void fileDownloadedMessage () {
        final String msg = LOGTITLE + " has downloaded the complete file.";
        peerLogger.info (String.format (msg));
    }


}
