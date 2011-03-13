import java.util.*;import java.io.*;
public class Fib { 
//vrne prvih n stevil fibonaccijevega zaporedja k-tega reda
//@begin@ 
public static int[] Fib(int n, int k) {
    // tabela vrednosti zaporedja (na zaèetku 0,0,...,0,1,0,...)
    int[] out = new int[n];
    out[k-1]=1;
    
    // generiramo zaporedje naprej - nov element je vsota zadnjih k elementov
    for(int i=k; i<n; i++)
        for(int j=0; j<k; j++)
            out[i] += out[i-j-1];
    
    return out;
}
//@end@ 
    public static void main(String[] args) {         
        int n=50;
        int k=5;
        if ((args.length > 0)&&(args[0] != null)) k = Integer.parseInt(args[0]);
        
        int[] fib = Fib(n, k);
        System.out.print("{");
        for (int i=0; i<n; i++)    System.out.print(fib[i]+",");
        System.out.print("}");
        
        System.exit(0); 
    } 
} 
