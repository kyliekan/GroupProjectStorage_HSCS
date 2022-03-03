import java.io.*;
import java.util.*;

public class HuffyTree {
	
	public SortNode root;
	public HashMap<Character, Integer> map;
	public PriorityQueue<SortNode> queue;
	public String path;
	
	public class Node {
		SortNode left;
		SortNode right;
		char data;
		int freq;
		
		public Node(SortNode l, SortNode r, char d, int f) {
			left = l;
			right = r;
			data = d;
			freq = f;
		}
	}
	
	public class SortNode implements Comparable<SortNode> {
		Node n;
		public SortNode( Node s ) {
			n = s;
		}
		
		public int compareTo(SortNode s) {
			if(n.freq > s.n.freq) return 1;
			if(n.freq < s.n.freq) return -1;
			return 0;
		}
		
		public String toString() {
			return n.data + " " + n.freq;
		}
	}
	
	public HuffyTree() {
		root = null;
		map = new HashMap<Character, Integer>(); 
		queue = new PriorityQueue<SortNode>();
	}
	
	public void read(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		
		while(sc.hasNext()) {
			String chaos = sc.nextLine();
			chaos = chaos.replaceAll("[*]", "");
			for(int i = 0; i < chaos.length(); i++) {
				char a = chaos.charAt(i);
				if(!map.containsKey(a))
					map.put(a, 1);
				else {
					int cnt = map.get(a);
				    map.put(a, cnt + 1);
				}
			}
		}
		map.forEach((k,v) -> {
	        //System.out.println("key: " + k + ", value: " + v);
			queue.add(new SortNode(new Node(null, null, k, v)));
		});
		
		while(queue.size() > 1) {
			SortNode one = queue.poll();
			SortNode two = queue.poll();
			SortNode n = new SortNode(new Node(one, two, '*', one.n.freq + two.n.freq));
			queue.add(n);
		}
		root = queue.poll();
	}
	
	
	public String find(char val) {
		path = "";
		find(val, root, path);
		return path;
	}
	private void find(char val, SortNode tempNode, String p) {
		if(tempNode != null && tempNode.n.left == null && tempNode.n.right == null) {
			if(tempNode.n.data == val) {
				System.out.print(p);
				path = p;
			}
		}
		else {
			find(val, tempNode.n.left, p + "0");
			find(val, tempNode.n.right, p + "1");
		}
	}
	
	public String HuffmanCompressor(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		String chaos = "";
		String out = "";
		
		while(sc.hasNext()) {	
			chaos += sc.nextLine();
		}
		//System.out.println(chaos);
		for(int i = 0; i < chaos.length(); i++) {
			String n = find(chaos.charAt(i));
			out += n;
		}
		return out;
	}
	
	public void HuffmanCode(String s) {
		SortNode n = root;
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(temp == '1') {
				if(n.n.right != null) {
					n = n.n.right;
					if(n.n != null && n.n.data != '*') {
						System.out.print(n.n.data);
						n = root;
					}
				}
			}
			else if(temp == '0') {
				if(n.n.left != null) {
					n = n.n.left;
					if(n != null && n.n.data != '*') {
						System.out.print(n.n.data);
						n = root;
					}
				}
			}
		}
	}
	
	
	public void inOrder()
	{
	    System.out.println();
	    inOrder( root );	
	}
	
	private void inOrder( SortNode t )
    {
      if( t != null)
      {
         inOrder( t.n.left );
         System.out.print( t.n.data + " " + t.n.freq + "\n");
         inOrder( t.n.right );
      }
    }
	
	public static void main(String[] args) throws IOException {
		HuffyTree tree = new HuffyTree();
		Scanner file = new Scanner(System.in);
		System.out.println("Type the name of the file you wish to use as input: ");
		String fileName = file.nextLine().trim();
		
		tree.read(fileName);
		System.out.println();
		
		System.out.println("Encoded file content: ");
		String temp = tree.HuffmanCompressor(fileName);
		System.out.println("\n");
		
		System.out.println("Decoded file content: ");
		tree.HuffmanCode(temp);
	}
	
}
