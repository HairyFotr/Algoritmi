import java.util.*;import java.io.*;
//@begin@ 
class Link<T> {
    Link<T> p,n; // previous, next
    T val; // value
    
    public Link(Link<T> prev, T v, Link<T> next) { p=prev; val = v; n=next; }
    public Link(T v) { this(null, v, null); }
    
    public Link remove() { // remove self, return next
        Link next = n;
        if(p!=null) p.n = n;
        if(n!=null) n.p = p;
        n = null;
        p = null;
        return next;
    }
    
    public Link move(int k) { // move k places
        Link<T> out = this;
        boolean forward = true;
        if(k<0) { k = -k; forward = false; } // move backwards
        while(k --> 0 && out != null) if(forward) out = out.n; else out = out.p;
        return out;
    }
    
    public void insert(Link<T> next) { // insert after
        Link<T> nn = this.n;
        if(nn!=null) {
            next.n = nn;
            nn.p = next;
        }
        next.p = this;        
        this.n = next;
    }

    public static <T> Link<T> createLinks(T... links) { // create links and return first
        Link<T> first = new Link<T>(links[0]), next=first;
        for(int i=1; i < links.length; i++) {
            next.insert(new Link<T>(links[i]));
            next = next.n;
        }
        return first;
    }
    
    public String toString() { return val.toString(); }
}
//@end@ 
public class LinkedList {
    public static void main(String[] args) { 
        Link<Integer> root = Link.createLinks(1,2,3,4,5);
        System.out.println(root.move(3));
        root.move(3).remove();        
        System.out.println(root.move(3));
        System.out.println(root.move(3).move(-3));
        root = Link.createLinks(new Integer[]{1,2,3,4,5});
        System.out.println(root.move(3));
        root.move(3).remove();        
        System.out.println(root.move(3));
        System.out.println(root.move(3).move(-3));
    } 
} 
