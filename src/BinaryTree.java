import java.util.*;import java.io.*;
//@begin@
class Node<T extends Comparable<T>> {
    Node<T> l,r; // left,right
    Node<T> parent;
    T val; // value
    
    public Node(Node<T> left, T v, Node<T> right) { l=left; val = v; r=right; }
    public Node(T v) { this(null, v, null); }
    
    public void insert(T v) {
        int cmp = v.compareTo(val);
        if(cmp==0) {
            return;
        } else if(cmp < 0) {
            if(l!=null) { l.insert(v); } else { l = new Node<T>(v); l.parent = this; }
        } else {
            if(r!=null) { r.insert(v); } else { r = new Node<T>(v); r.parent = this; }
        }
    }
    public boolean contains(T v) {
        int cmp = v.compareTo(val);
        if(cmp==0) {
            return true;
        } else if(cmp < 0) {
            if(l!=null) { return l.contains(v); } else { return false; }
        } else {
            if(r!=null) { return r.contains(v); } else { return false; }
        }
    }
    
    public String getTreeString() {
        return "("+
            ((l!=null)?l.getTreeString():"_") + ", " +
            toString() + ", " +
            ((r!=null)?r.getTreeString():"_")
        +")";
    }
    
    public String toString() { return val.toString(); }
}
//@end@ 
public class BinaryTree {
    public static void main(String[] args) { 
        Node<Integer> root = new Node<Integer>(4);
        System.out.println(root.getTreeString());
        root.insert(2); root.insert(6);
        System.out.println(root.getTreeString());
        root.insert(3); root.insert(5);
        System.out.println(root.getTreeString());
        root.insert(0); root.insert(9);
        System.out.println(root.getTreeString());
        for(int i=0; i<10; i++) System.out.println(i+":"+root.contains(i));
    } 
} 
