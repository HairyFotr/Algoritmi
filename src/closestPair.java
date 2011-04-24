import java.util.*;import java.io.*;
public class closestPair { 
//@begin@ 
static int[][] tocke;

private static int[] closestPair() {
    //uredi to�ke po Y
    sort(tocka);
    
    int minTocka1 = 0, minTocka2 = 1;
    double minRazd = razdalja(minTocka1, minTocka2);
    //ugotovi najkrajo razdaljo med sosednjimi to�kami po dimenziji Y
    //ta korak ni nujen, ampak lahko pohitri ra�unanje, ker prej dobimo
    //bolj�o trenutno vrednost za najkraj�o razdaljo
    for(int i = 1; i < tocke.length-1; i++) { 
        int t1 = i, t2 = i+1;
        if(((tocke[t2][1]-tocke[t1][1]) >= minRazd)
        ||(Math.abs(tocke[t2][0]-tocke[t1][0]) >= minRazd)) continue;
        
        double tmpRazd = razdalja(t1, t2);
        if(tmpRazd < minRazd) {
            minRazd = tmpRazd;
            minTocka1 = t1;
            minTocka2 = t2;
        }
    }

    //prei��e okno to�k od t1+1...t2 v katerem so lahko to�ke,
    //ki so bli�je od trenutne vrednosti za najkraj�o razdaljo
    int t1 = 0, t2 = 2;
    do {
        do {
            double tmpRazd = razdalja(t1, t2);
            if(tmpRazd < minRazd) {
                minRazd = tmpRazd;    
                minTocka1 = t1;
                minTocka2 = t2;
            }
            do t2++; while((t2 < tocke.length)
                &&(Math.abs(tocke[t2][0]-tocke[t1][0]) >= minRazd)
                &&((tocke[t2][1]-tocke[t1][1]) < minRazd));
        } while((t2 < tocke.length)&&((tocke[t2][1]-tocke[t1][1]) < minRazd));
        do {
            t1++;
            t2 = t1+2;
        } while((t2 < tocke.length)&&((tocke[t2][1]-tocke[t1][1]) >= minRazd));
    } while(t2 < tocke.length);
    
    return new int[]{minTocka1, minTocka2};
}

private static double razdalja(int t1, int t2) { 
    return Math.sqrt((long)(tocke[t1][0]-tocke[t2][0])*(tocke[t1][0]-tocke[t2][0])
        + (long)(tocke[t1][1]-tocke[t2][1])*(tocke[t1][1]-tocke[t2][1]));
}
//@end@ 
    public static void main(String[] args) { 
        System.exit(1); 
    } 
} 
