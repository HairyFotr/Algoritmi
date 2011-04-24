import java.util.*;
public class monteCarloPi {
//?rabiš castat v double v rezultatu
//@begin@
public static double monteCarloPi(int num) {
    Random rand=new Random();
    int hits=0;
    for(int i=0; i<num; i++) {
        double x=rand.nextDouble(), y=rand.nextDouble();
        
        if(Math.sqrt(x*x + y*y)<=1) hits++;
    }
    
    return ((double)hits/num)*4;
}
//@end@

    public static void main(String[] args) {
        if (Math.abs(monteCarloPi(100)-3.14) > 0.5) {
            System.exit(1);
        } else {
            System.exit(0);
        }        
    }    
}
