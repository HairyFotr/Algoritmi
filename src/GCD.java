import java.util.*;import java.io.*;import java.math.*;
public class GCD { 
//vrne najvecji skupni delitelj stevil a in b
//@begin@ 
public static int GCD(int a, int b) {
    if(a==0) return b; else
    if(b==0) return a; else
    if(a>b) return GCD(b, a%b); else
    return GCD(a, b%a);
}

public static int GCD2(int a, int b) { 
    return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
}
//@end@ 
    public static void main(String[] args) { 
        if ((GCD(60, 30) == 30)&&(GCD(22, 10) == 2)&&(GCD2(60, 30) == 30)&&(GCD2(22, 10) == 2))
            System.exit(0);
            
        System.exit(1);
    } 
} 
