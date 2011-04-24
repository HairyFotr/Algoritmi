import java.util.*;import java.io.*;
public class Permutations { 
//nasel na: http://www.cs.princeton.edu/introcs/23recursion/Permutations.java.html
//funkciji sprejmeta vhodno zaporedje in izpiseta vse permutacije

//@begin@ 
// Izpiši permutacije (v pravem zaporedju)
public static void perm1(String s) { 
    perm1("", s);
}
private static void perm1(String prefix, String s) {
    if(s.length()==0) {
        System.out.println(prefix);
    } else for(int i=0; i<s.length(); i++) {
        perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()));
    }
}

// Izpiši permutacije (niso v pravem zaporedju)
public static void perm2(String s) {
    char[] a = new char[s.length()];
    for(int i=0; i<s.length(); i++)
        a[i] = s.charAt(i);
   
    perm2(a, s.length());
}
private static void perm2(char[] a, int len) {
    if (len==1) {
        System.out.println(a);
    } else for(int i=0; i<len; i++) {
        swap(a, i, len-1);
        perm2(a, len-1);
        swap(a, i, len-1);
    }
}
//@end@ 
    
    private static void swap(char[] a, int i, int j) {
        char c = a[i]; 
        a[i] = a[j]; 
        a[j] = c;
    }
    
    public static void main(String[] args) {
       int n = Integer.parseInt(args[0]);
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       String elements = alphabet.substring(0, n);
       perm1(elements);
       System.out.println();
       perm2(elements);
        System.exit(1); 
    }
}