package Peer_Related;
import Logging.logrecord;
import Peer_Related.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Harshit Vijayvargia on 3/28/2017.
 */

public class peerprocess {

    static String CONFIGFILENAME =  "CommonFile";
    static String PEERINFOFILENAME= "PeerInfoFile";
    static Properties common_cfg ;
    final static LinkedList<Peerinfo> peers = new LinkedList<Peerinfo>();

    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        int peerId = inp.nextInt();
        inp.nextLine();

        Reader commonReader =null;
        Reader peerReader =null;
        common_cfg = readCommonFile(commonReader);
        readPeerFile(peerReader);
       logrecord.getLogRecord().setLoggerForPeer(peerId);



      logrecord.getLogRecord().peerLogger.log(Level.INFO, "First Log");


// Storing all peers in a LinkedList which this peer has to connect to .
// A peer connects only to previous peers

        // initializing a process associated with a peer , it's file manager , its peer manager ,
        // requires configuration and peerinfo file





    }









//Method for storing Common.cfg file information in properties

    static Properties readCommonFile(Reader commonReader) {
        Properties cProperty = new Properties() {
            public synchronized void load(Reader commonReader) {

                try {
                    commonReader = new FileReader(CONFIGFILENAME);

                    BufferedReader cReader = new BufferedReader(commonReader);

                    int i=0;

                    for (String line; (line = cReader.readLine()) != null; i++) {
                        String arr[] = line.split(" ");
                        setProperty(arr[0], arr[1]);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally
                {

                    try {
                        commonReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        };
        try {
            cProperty.load(commonReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cProperty;
    }





    //Method for Reading PeerInfo File and storing that information in  a LinkedList

    static void readPeerFile(Reader peerReader) {
        try {
            peerReader = new FileReader(PEERINFOFILENAME);
            BufferedReader pReader = new BufferedReader(peerReader);


            int i=0;
            for (String line; (line = pReader.readLine()) != null; i++) {
                String arr[] = line.split(" ");
                peers.add(new Peerinfo(arr[0], arr[1], arr[2], arr[3]));



            }


        } catch (Exception e) {

        }
        finally
        {
            try {
                peerReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}




