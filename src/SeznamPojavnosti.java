import java.util.*;import java.io.*;
//@begin@
class Node<T> {
    List<Conn<T>> cons;
    T val; // value
    
    public Node(T v, ArrayList<Conn<T>> conns) { val = v; cons = conns; }
}
class Conn<T> {
    List<Node<T>> nodes;
    T val; // value
    
    public Conn(T v, ArrayList<Node<T>> nods) { val = v; nodes = nods; }
}
//@end@ 
public class SeznamPojavnosti {
    public static void main(String[] args) { 
    } 
} 
