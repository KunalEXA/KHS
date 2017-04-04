package Peer_Related;
import java.util.*;
/**
 * Created by Harshit Vijayvargia on 3/31/2017.
 */
public class PeerManager implements Runnable {

    LinkedList<PeerInfo> prefferedNeighbours;


PeerManager(LinkedList<PeerInfo> peers)
{

}

    @Override
    public void run() {


        /*second thread for maintaining preferred neighbours,choked neighbours, neighbours from which optimistic
        unchoked neighbour will be selected . These all are determined using interested neighbours

        Steps :
        1)Get peers in which the peer is interested

        2) Determine Preferred Neighbours : Two cases : a) In the beginning randomly 3 Preferred neighbours will be choosen.
                          shuffle the interested peers and assign the first 3
                       b) After each unchoking interval , sort the interested neighbours acco
                           rding to bytes downloaded from them and take the first two.
        3)

        */
        LinkedList<PeerInfo> interestedPeers = getInterestedPeers(PeerProcess.peers);
        HashSet<Integer> interestedPeersIds = new HashSet<Integer>();
        interestedPeersIds = PeerInfo.getPeerIds(interestedPeers);

        LinkedList<PeerInfo> preferredPeers  = getPreferredPeers(interestedPeers);
        HashSet<Integer> preferredPeersIds = new HashSet<Integer>();
        preferredPeersIds = PeerInfo.getPeerIds(preferredPeers);

        LinkedList<PeerInfo> peersToChoke = getPeersToChoke(preferredPeers,interestedPeers);
        HashSet<Integer> peersToChokeIds= new HashSet<Integer>();
        peersToChokeIds = PeerInfo.getPeerIds(peersToChoke);




    }














    LinkedList<PeerInfo> getPreferredPeers(LinkedList<PeerInfo> interestedPeers)
    {
        Collections.sort(interestedPeers, new Comparator<PeerInfo>() {
            @Override
            public int compare(PeerInfo o1, PeerInfo o2) {
                if(o1._bytesDownloadedFrom.get()>o2._bytesDownloadedFrom.get()){
                    return 1;}
                    else{return -1;}

            }
        });

        LinkedList<PeerInfo> preferredPeers = (LinkedList)interestedPeers.subList(0,Math.min(interestedPeers.size(),2));
        return preferredPeers;

    }



    LinkedList<PeerInfo> getPeersToChoke(LinkedList<PeerInfo> preferredPeers, LinkedList<PeerInfo> interestedPeers)
    {
        return null;
    }












    /* To get Interested peers */

    LinkedList<PeerInfo> getInterestedPeers(LinkedList<PeerInfo> peers)
    {
        LinkedList<PeerInfo> interestedPeers= new LinkedList<PeerInfo>();
        for(PeerInfo p : interestedPeers)
        {
            if(p.isInterested()) { interestedPeers.add(p);}

        }
        return interestedPeers;
    }
}
