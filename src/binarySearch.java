import java.util.*;import java.io.*;import java.math.*;
public class binarySearch { 
//sprejme urejeno tabelo in vrne indeks v a, kjer se nahaja key
//@begin@ 
public static int binarySearch(int a[], int key) {
    int left = 0, mid, right = a.length-1;
    
    while(left<=right) {
        mid = (left+right)>>>1;            // sredina intervala
        if(a[mid]<key) left = mid+1; else  // premaknemo spodnjo mejo
        if(a[mid]>key) right = mid-1; else // premaknemo zgornjo mejo
        return mid;                        // našli smo iskani element
    }
    return -1; // iskanega elementa ni v tabeli
}

public static int binarySearch2(int a[], int key) {
    return Arrays.binarySearch(a, key);
}
//@end@ 
    public static void main(String[] args) { 
        int[] a = new int[]{1,2,4,5,8,11,15,23,27,28,65,74,88,91,92,99};        
        for (int i=0; i<a.length; i++)
            if((binarySearch(a, a[i]) != i)&&(binarySearch(a, a[i]) != i))
                System.exit(1);

        if (binarySearch(a, 77) != -1)
            System.exit(1);
        
        System.exit(0);
    } 
} 
