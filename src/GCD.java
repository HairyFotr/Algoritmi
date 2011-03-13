import java.util.*;import java.io.*;
public class GCD { 
//vrne najvecji skupni delitelj stevil a in b
//@begin@ 
public static int GCD(int a, int b) {
    if(a==0) return b; else
    if(b==0) return a; else
    if(a>b) return GCD(b, a%b); else
    return GCD(a, b%a);
}
//@end@ 
    public static void main(String[] args) { 
        if ((GCD(60, 30) == 30)&&(GCD(22, 10) == 2))
            System.exit(0);
            
        System.exit(1); 
    } 
} 
