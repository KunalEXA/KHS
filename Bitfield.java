package edu.ufl.cise.cnt5106c.messages;

import java.util.BitSet;


public class Bitfield extends Messages {

    Bitfield (byte[] bitfield) {
        super ("Bitfield", bitfield);
    }


    // to be looked
    public Bitfield (BitSet bitset) {
        super ("Bitfield", bitset.toByteArray());
    }
// to be looked
    public BitSet getBitSet() {
        return BitSet.valueOf (payLoad);
    }
}
