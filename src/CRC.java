import java.util.*;import java.io.*;
//klièeš iz konzole.. lahko z veè binarnimi zaporedji zaporedoma npr:
//java CRC 01010010 01001011 01001111

public class CRC {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CRC(new boolean[]{true, false, true, false, true, false, true, false},
            new boolean[]{true, false, true, true})));
        boolean[] crc = CRC(new boolean[]{true,false},
            new boolean[]{false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, true});//x^16+x^12+x^5+1 16-bit CRC-16-CCITT
            
        crc = CRC(new boolean[]{false, false, false, false, false, false, false, false, false, true, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true},new boolean[]{true, false, false, true});
        String s="";
        for(boolean b : crc) {
            s+=b?"0":"1";
        }
        System.out.println(s);
    }
    //?is this fo'real?
    //@begin@    
    public static boolean[] CRC(boolean[] bits, boolean[] poly) {
        // ustvarimo dovolj veliko tabelo za izraèun in na zaèetek prilepimo vhodne bite
        boolean[] tmpbits = new boolean[bits.length + poly.length];
        System.arraycopy(bits, 0, tmpbits, 0, bits.length);
        
        for(int pos=0; pos<bits.length; pos++) if(tmpbits[pos])
            for(int i=0; i<poly.length; i++) if(poly[i]) 
                tmpbits[pos+i] = tmpbits[pos+i]^poly[i];
        
        boolean[] CRCbits = new boolean[poly.length-1];
        System.arraycopy(tmpbits, bits.length+1, CRCbits, 0, poly.length-1);
        return CRCbits;
    }
    //@end@
}
