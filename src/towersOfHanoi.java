import java.util.*;import java.io.*;
public class towersOfHanoi { 
//@begin@ 
public static void towersOfHanoi(int n, int source, int dest, int by) {
    if(n==1) {
        System.out.println(source+" -> "+dest);
    } else {
        towersOfHanoi(n-1, source, by,   dest);
        towersOfHanoi(1,   source, dest, by);
        towersOfHanoi(n-1, by,     dest, source);
    }
}
//@end@ 
    public static void main(String[] args) { 
        System.exit(0);
    } 
} 
