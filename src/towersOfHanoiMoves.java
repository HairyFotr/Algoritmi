import java.util.*;import java.io.*;
public class towersOfHanoiMoves { 
//@begin@ 
public static int towersOfHanoiMoves(int n) {
    int moves=0;
    for(int i=0; i<n; i++) 
        moves = moves*2+1;
    
    return moves;
}
//@end@ 
    public static void main(String[] args) { 
        if((towersOfHanoiMoves(1) == 1)&&(towersOfHanoiMoves(4) == 15)&&(towersOfHanoiMoves(3) == 7))
            System.exit(0);
        else
            System.exit(1);
    } 
} 
