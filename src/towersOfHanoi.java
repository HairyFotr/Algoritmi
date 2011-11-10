import java.util.*;import java.io.*;
public class towersOfHanoi { 
//@begin@ 
public static void hanoi(int n) { hanoi(n,'a','b','c'); }
private static void hanoi(int n, char source, char dest, char by) {
    if(n==1) {
        System.out.println(source+" -> "+dest);
    } else {
        hanoi(n-1, source, by,   dest);
        hanoi(1,   source, dest, by);
        hanoi(n-1, by,     dest, source);
    }
}
//@end@ 
    public static void main(String[] args) { 
        hanoi(10);
        System.exit(0);
    } 
} 
