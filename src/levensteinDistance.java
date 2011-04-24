import java.util.*;import java.io.*;
public class levensteinDistance { 
//@begin@ 
public static int levensteinDistance(String s1, String s2) {
	int[][] d = new int[s1.length()+1][s2.length()+1];
	
	for(int i=0; i<=s1.length(); i++) d[i][0] = i;
	for(int j=0; j<=s2.length(); j++) d[0][j] = j;
	
	for(int i=1; i<=s1.length(); i++) {
		for(int j=1; j<=s2.length(); j++) {  
		
			int del = d[i-1][j]+1, // brisanje
				ins = d[i][j-1]+1, // vstavljanje
				sub = d[i-1][j-1]; // sprememba
			
			if(s1.charAt(i-1) != s2.charAt(j-1)) sub++;
			
			// shrani najmanjšo izmed razdalj
			d[i][j] = Math.min(del, Math.min(ins, sub));
		}
	}
	
	return d[s1.length()][s2.length()];
}
//@end@ 
	public static void main(String[] args) { 		
		if ((levensteinDistance("Burek", "Baraka")==3)
			&&(levensteinDistance("aaa", "aaaa")==1)
			&&(levensteinDistance("aaa", "aa")==1)
			&&(levensteinDistance("aaa", "aba")==1)
			&&(levensteinDistance("aaa", "aaa")==0)
			) 
		{
			System.out.println("Suxcess!");
			System.exit(0);
		}
		else 
		{
			System.out.println(levensteinDistance("Burek", "Baraka"));
			System.out.println(levensteinDistance("aaa", "aaaa"));
			System.out.println(levensteinDistance("aaa", "aa"));
			System.out.println(levensteinDistance("aaa", "aba"));
			System.exit(1); 
		}
	} 
} 
