package edu.ufl.cise.cnt5106c.messages;

public class Request extends Messages {

    Request (byte[] pieceIdx)
    {

        super ("Request", pieceIdx);
    }

}
