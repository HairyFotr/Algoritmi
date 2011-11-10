import java.util.*;import java.io.*;import java.math.*;
//@begin@ 
class Fraction {
    long num, denom;

    public Fraction(long numerator, long denominator) {
        num = numerator;
        denom = denominator;
        fix();
    }

    public Fraction negate() {
        Fraction out = this.clone();
        out.num = -out.num;
        out.fix();
        return out;
    }
    public Fraction add(Fraction b) {
        Fraction ax = this.clone(), bx = b.clone();
        long LCM = ax.denom*bx.denom / GCD(ax.denom,bx.denom),
            LCMa = LCM/ax.denom,
            LCMb = LCM/bx.denom;
        
        ax.num *= LCMa; ax.denom *= LCMa;
        bx.num *= LCMb; bx.denom *= LCMb;
        
        ax.num += bx.num;
        ax.fix();
        return ax;
    }
    public Fraction add(int x) {
        Fraction out = this.clone();
        out.num += out.denom*x;
        out.fix();
        return out;
    }
    public Fraction remove(Fraction b) {
        return this.add(b.negate());
    }
    public Fraction remove(int x) {
        return add(-x);
    }
    public Fraction mul(long x) {
        Fraction out = this.clone();
        out.num *= x;
        out.fix();
        return out;
    }
    public Fraction mul(Fraction x) {
        Fraction out = this.clone();
        out.num *= x.num;
        out.denom *= x.denom;
        out.fix();
        return out;
    }

    public void fix() { // an in-place method!
        if(num==0) denom = 1;
        if(num<0 && denom<0) {num = -num; denom = -denom; }
        if(num>0 && denom<0) {num = -num; denom = -denom; }
    }
    public Fraction simplify() {
        long GCD = GCD(num,denom);
        num/=GCD;
        denom/=GCD;
        return this;
    }
    public long sign() {
        if(num==0) return 0;
        if((num<0 && denom<0) || (num>0 && denom>0)) return 1;
        return -1;
    }
    public long wholePart() { return num/denom; }
    
    @Override
    public Fraction clone() { return new Fraction(num, denom); }

    @Override
    public String toString() { return num + "/" + denom; }
    
    public int compareTo(Fraction frac) {
        long t = this.num * frac.denom;
        long f = frac.num * this.denom;
        
        if(t>f) return 1;
        else if(f>t) return -1;
        else return 0;
    }

    public static long GCD(long a, long b) { 
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
}
//@end@ 
public class Fractions { 
   public static void main(String[] args) {
        Fraction f1 = new Fraction(2,2);
        System.out.println(f1.toString());
        Fraction f2 = new Fraction(2,-2);
        System.out.println(f2.toString());
        System.out.println((f2.add(3).add(new Fraction(147,-56))).simplify().toString());
        System.out.println((f2.add(3).add(new Fraction(1447,-56))).simplify().toString());
        System.out.println((f2.add(3).add(new Fraction(1447,-56))).simplify().toString());
        System.out.println((new Fraction(1,6).add(10).remove(new Fraction(1,5)).add(new Fraction(1,4)).remove(new Fraction(1,3)).add(new Fraction(1,2)).remove(10).mul(new Fraction(2,10))).simplify().toString());
            
        System.exit(1);
    } 
} 
