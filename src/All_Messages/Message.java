package All_Messages;
import java.util.*;
/**
 * Created by Harshit Vijayvargia on 2/21/2017.
 */
public class Message {
    public int messageLength;
    public byte messageType;
    public byte[] payLoad;
    final static Byte typeToValue[] = {0,1,2,3,4,5,6,7};
    final static HashMap<String, Byte> hash = new HashMap<String, Byte>();




    static  {


        hash.put("Choke", typeToValue[0]);
        hash.put("Unchoke", typeToValue[1]);
        hash.put("Interested", typeToValue[2]);
        hash.put("Uninterested", typeToValue[3]);
        hash.put("Have", typeToValue[4]);
        hash.put("Bitfield", typeToValue[5]);
        hash.put("Request", typeToValue[6]);
        hash.put("Piece", typeToValue[7]);

    }
    protected Message(String type) {

        this (type, null);
    }
    Message(String type, byte[] payload)
    {
        if(payload==null)
        {
            messageLength = 0;
        }
        else {
            messageLength = payload.length;
        }
        messageType = hash.get(type);
        this.payLoad = payload;
    }
    Byte getTypeOfMessage(String type)
    {
        return hash.get(type);
    }

    public static Message getMessage (int length, String type)  {
        switch (type) {
            case "Choke":
                return new Choke();

            case "Unchoke":
                return new Unchoke();

            case "Interested":
                return new Interested();

            case "NotInterested":
                return new Uninterested();

            case "Have":
                return new Have (new byte[length]);

            case "BitField":
                return new Bitfield (new byte[length]);

            case "Request":
                return new Request (new byte[length]);

            case "Piece":
                return new Piece (new byte[length]);

            default:
                return  new Interested();    // EXception to be handled ( Class Not found and IO Exception).
        }
    }
}



