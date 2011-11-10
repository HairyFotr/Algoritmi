import java.util.*;import java.io.*;import java.math.*;
public class SubsetSum { 
//katere vsote lahko dobimo s pomnožicami množice a
//@begin@ 
public static boolean[] subsetSums(int[] a) {
    int M = 0;
    for(int i : a) M += i;
    boolean[] m = new boolean[M+1];
    m[0]=true;
    
    for(int i=0; i<a.length; i++)
        for(int j=M; j>=a[i]; j--)
            m[j] |= m[j-a[i]];
    
    return m;
}
//@end@ 
    public static void main(String[] args) { 
        boolean[] b = subsetSums(new int[]{3,3,3,1});
        for(int i=0; i<b.length; i++) {
            System.out.println(b[i]);
        }
    } 
} 
