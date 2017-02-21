/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kunal
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
public class Handshake {
    
    private byte[] _addZeroBits = new byte[10];
    private String _header = "P2PFILESHARINGPROJ";
    private byte[] _peerId = new byte[4];
    
    
    //Default constructor which initializes the necessary variables
    public Handshake()
    { }
    
    //The constructor which take in peer ID and sets this value into peer id byte array
    public Handshake(int peerId)
    {
        this(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(peerId).array()); 
    }
    
    //this constructor is for checking length of byte array and then setting its value into peer ID
    public Handshake (byte[] peerId)
    {
        if(peerId.length > 4)
        {
            throw new ArrayIndexOutOfBoundsException("peerId max length is 4, while "
                    + Arrays.toString (peerId) + "'s length is "+ peerId.length);
        }
        
        //Else set the value in peerID
        int k = 0;
        for(byte i : peerId)
            _peerId[k++] = i;
    }
    
    public int getPeerId()
    {
        //This is the fastest way to convert Byte array to int. Another is the following
        /*
            return (_peerId[3] & 0xFF | (_peerId[2]& 0xFF) << 8 | (_peerId[1]& 0xFF) & 16 | (_peerId[0]& 0xFF) << 32)
        */
        return ByteBuffer.wrap(_peerId).order(ByteOrder.BIG_ENDIAN).getInt();
    }
    
    public void read()
    {}
    
    public void write()
    {} 
}
