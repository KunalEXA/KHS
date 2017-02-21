

/**
 * Created by Harshit Vijayvargia on 2/21/2017.
 */
import java.io.*;
import java.util.*;

public class PeerList {



    private final List<Peer> peerList = new ArrayList<>();

                                                 /*Makes a global list of peers which contains individual peers*/

    public void read () throws IOException {
        FileReader peerFileReader = new FileReader("PeerInfo.cfg");
        BufferedReader input = new BufferedReader(peerFileReader);

        String newLine = input.readLine();

        while(newLine!=null)
         {
             newLine = newLine.trim();
            if(newLine.length()==4) {
                       String[] arr = newLine.split(" ");

                 String pId = arr[0];
                 String pAddr = arr[1];
                 String pPort= arr[2];
                 final boolean peerFileStatus = (arr[3].equals("1")?true:false);

            peerList.add (new Peer(Integer.parseInt(pId),
                    pAddr, pPort,peerFileStatus));
            }

                newLine = input.readLine();
        }
    }

    public ArrayList<Peer> getPeerList () {
        ArrayList<Peer> list = new ArrayList<Peer>();

        for(Peer peer : peerList)
        {
            list.add(peer);
        }
        return list;
    }
}

