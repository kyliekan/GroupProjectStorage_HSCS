import java.util.*;
import java.io.*;
// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
    // Your code here
	private QuestionNode root;
	public Scanner sc;
	public QuestionNode computer;
    private static class QuestionNode {
        // Your code here	
    	QuestionNode left;
    	QuestionNode right;
    	String data;
    	Boolean ans;
    	private QuestionNode(QuestionNode l, QuestionNode r, String q, boolean a) {
    		left = l;
    		right = r;
    		data = q;
    		ans = a;
    	}
    }
    public QuestionsGame() {
    	computer = new QuestionNode(null,null, "Computer",false);
    	
    }

    public QuestionsGame(String initialObject) {
		
	}

	public QuestionsGame(Scanner questions) {
		
	}

	public void play() {
    
    }
    public void read(Scanner sc) {
    	int ac = 0;
    	int boo = 0;
    	int count = 0;
    	while (sc.hasNext()) {
    		boolean tf = false;
        	if(sc.nextLine().equals("A:")) {
        		ac++;
        		tf = true;
        	}
        	else ac --;
        	if(ac == 0) boo = 1;
        	if(boo == 1) ac = 0;
        	if(ac == 0) count ++;
        	if(count == 1) ac = 1;
        	String data = sc.nextLine();
    		root = add(data,root,ac,tf);
    	}
    	
    	inOrder();
    	
    }
    private QuestionNode add(String data,QuestionNode n,int ac,boolean tf) {
    	if(n == null) {
    		 n = new QuestionNode(null,null,data,tf);
    	}
    	else if(ac == 0) { // for start to right
    		ac = 1;
    		n.right = add(data,n.right,ac,tf);
    		
    	}
    	else if(n.left != null && n.left.ans) { 
    		// left leaf is answer
    		n.right = add(data,n.right,ac,tf);
    	}
    	else if(tf && n.left != null && n.left.ans) {
    		n.right = add(data,n.right,ac,tf);
    	}
    	
    	else  {
    		n.left = add(data,n.left,ac,tf);
    	}
    	
    	return n;
    	
    }


	public void saveQuestions(PrintStream printStream) {
	
		
	}
	public void inOrder()
	{
	    System.out.println();
	    inOrder( root );	
	}
	
	private void inOrder( QuestionNode t )
    {
      if( t != null)
      {
         inOrder( t.left );
         System.out.println( t.data + " " + t.ans  );
         inOrder( t.right );
      }
    }
	public void LevelOrder() {
		Queue<QuestionNode> que = new LinkedList<QuestionNode>();
		que.add(root);
		while (!que.isEmpty()) {
			QuestionNode temp = que.poll();
			if (temp.left!=null) 
				que.add(temp.left);	
			if (temp.right!=null)
				que.add(temp.right);
			System.out.println(temp.data + " ");
			
		}
	}
}
