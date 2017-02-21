/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kunal
 */
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;
public class Peer {
    
    public int id;
    public boolean hasFile;
    public int port;
    public String addr;
    public BitSet hasPieces;
    public AtomicBoolean interested;
    
    public Peer(int id, int port, boolean hasFile, String add)
    {
        this.id = id;
        this.port = port;
        this.hasFile = hasFile;
        this.addr = add;
    }
    
    public void setId(int peerId)
    {
        this(peerId, 6008, false, "localhost");
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setInterested(boolean flag)
    {
        interested.set(flag);
    }
    
    public boolean getInterested()
    {
        return interested.get();
    }
    
    public void setAddr(String address)
    {
        this.addr = address;
    }
    
    public String getAddr()
    {
        return this.addr;
    }
    
    
    //Following code is for setting pieces that the peer has and also send this information out to other peers
    public void setBits()
    {
        //Do something
    }
    
    public BitSet hasPieces()
    {
        return this.hasPieces;
    }
}
