import java.util.*;import java.io.*;
public class isPrime { 
//vrne true, ce je a prastevilo
//@begin@ 
public static boolean isPrime(int a) {        
    if(a<=1) return false;        
    
    for(int i=2; i<=Math.sqrt(a); i++) 
        if(a%i==0) return false;
    
    return true;
}
//@end@ 
    public static void main(String[] args) { 
        System.exit(0); 
    } 
} 
