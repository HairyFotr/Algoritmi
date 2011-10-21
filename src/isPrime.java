import java.util.*;import java.io.*;import java.math.*;
public class isPrime { 
//vrne true, ce je a prastevilo
//@begin@ 
public static boolean isPrime(int a) {        
    if(a<=1) return false;        
    
    for(int i=2; i<=Math.sqrt(a); i++) 
        if(a%i==0) return false;
    
    return true;
}

public static boolean isPrime2(int a) { 
    return BigInteger.valueOf(a).isProbablePrime(5);
}
//@end@ 
    public static void main(String[] args) { 
        for(int i=2; i<Integer.MAX_VALUE; i++) {
            if(isPrime(i)&&!isPrime2(i)) System.out.println(i);
        }
        System.exit(0); 
    } 
} 
