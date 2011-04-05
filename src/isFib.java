import java.util.*;import java.io.*;
public class isFib { 
//vrne true, ce je a del fibonaccijevega zaporedja k-tega reda
//@begin@ 
public static boolean isFib(int a, int k) {
    if (a==0) return true;
    
    // tabela zadnjih k vrednosti zaporedja (na zaèetku 0,0,...,0,1)
    int[] store = new int[k];
    store[k-1]=1;
    // vsota èlenov
    int sum=1;

    // kaže na mesto v tabeli, ki ga bomo prepisali
    int pos=0;
    
    while(a>sum) {
        int oldSum = sum;
        sum = 2*sum-store[pos%k];
        store[pos%k] = oldSum;
        
        pos++;
    }
    
    return (sum==a); // ali je a èlen zaporedja
}
//@end@ 
    public static void main(String[] args) { 
        isFib(100, 3);
        if((isFib(56, 4))&&(!isFib(7, 2))) 
            System.exit(0);
        else
            System.exit(1);
    } 
} 
