import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cypher {
	public static String encode(String s) {
		String a = "";
		String b = "";
		String c = "";
		for(int i = 0; i < s.length(); i += 4) {
			if( i + 4 < s.length()) {
					a  += (s.substring(i,i+1) + "...");
			}
			else {
				a +=(s.substring(i,i+1));
			}
		}
		if(s.length() > 1) {
		b +=".";
		for(int i = 1; i < s.length(); i += 2) {
			if( i + 2 < s.length()) {
				b  += (s.substring(i,i+1) + ".");
		}
		else {
			b +=(s.substring(i,i+1));
		}
		}
		if(s.length() > 2) {
		c+="..";
		for(int i = 2; i < s.length(); i += 4) {
			if( i + 4 < s.length()) {
				c +=(s.substring(i,i+1) + "...");
			}
			else {
				c +=(s.substring(i,i+1));
			}
		}
		}
		}
		while (a.length() > b.length()) {
			b += ".";
		}
		while (a.length() < b.length()) {
			a += ".";
		}
		while (c.length() > a.length()) {
			a += ".";
			b += ".";
		}
		while(c.length() < a.length()) {
			c += ".";
		}
		String ns = a + "\n" + b +"\n" + c;
		return ns;
	}
	public static String decode(String s) {
		String ns = "";
		String [] strs = s.split("\n");
		String a = "";
		String b = "";
		String c = "";
		if(strs.length > 0) {
		for(int i = 0; i < strs[0].length(); i++) {
			if(!strs[0].substring(i,i+1).equals(".")) {
				a += strs[0].substring(i,i+1);
			}
		}
		}
		if(strs.length > 1) {
			for(int i = 0; i < strs[1].length(); i++) {
				if(!strs[1].substring(i,i+1).equals(".")) {
					b += strs[1].substring(i,i+1);
				}
			}
			}
		if(strs.length > 2) {
			for(int i = 0; i < strs[2].length(); i++) {
				if(!strs[2].substring(i,i+1).equals(".")) {
					c += strs[2].substring(i,i+1);
				}
			}
			}
		while(a.length() > 0 || b.length() > 0 || c.length() >0) {
			if(a.length() > 0) {
				ns += a.substring(0,1);
				a = a.substring(1,a.length());
			}
			if(b.length() > 0) {
				ns += b.substring(0,1);
				b = b.substring(1,b.length());
			}
			if(c.length() > 0) {
				ns += c.substring(0,1);
				c = c.substring(1,c.length());
			}
			if(b.length() > 0) {
				ns += b.substring(0,1);
				b = b.substring(1,b.length());
			}
		}
		return ns;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("what do you wana encode");
		Scanner sc = new Scanner (System.in);
		String s = sc.nextLine(); 
		System.out.println(encode(s));
		System.out.println("what would you like to decode");
		s = ""; 
		s += sc.nextLine() + "\n";
		s += sc.nextLine() + "\n";
		s += sc.nextLine() + "\n";
		System.out.println(decode(s));
	 }
}
