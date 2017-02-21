
import java.io.IOException;
import java.util.*;
/**
 * Created by Harshit Vijayvargia on 2/21/2017.
 */
public class Messages {
    private int messageLength;
    private byte messageType;
    protected byte[] payLoad;
    final Byte typeToValue[] = {0,1,2,3,4,5,6,7};
    final HashMap<String, Byte> hash = new HashMap<String, Byte>();
    public void Messages() {


        hash.put("Choke", typeToValue[0]);
        hash.put("Unchoke", typeToValue[1]);
        hash.put("Interested", typeToValue[2]);
        hash.put("Uninterested", typeToValue[3]);
        hash.put("Have", typeToValue[4]);
        hash.put("Bitfield", typeToValue[5]);
        hash.put("Request", typeToValue[6]);
        hash.put("Piece", typeToValue[7]);

    }
    protected Messages (String type) {

        this (type, null);
    }
    Messages(String type, byte[] payload)
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

    public static Messages getMessage (int length, String type)  {
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



