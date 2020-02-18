import java.util.PriorityQueue;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class encode {
	
	public encode() {
		
	}
	
	public static int[] findFreq(String s) {
		
		// Fill out character Frequency
		
		int[] freqArr = new int[27];					//stores frequency of each letter
		
		s = s.toLowerCase();							//we only care about lower case
		
		for(int i=0; i<s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) { 
				freqArr[s.charAt(i)-97]++;			//counts each letter
			}
			else if(s.charAt(i)==' ') {				//if it's a space add to end index
				freqArr[26]++;
			}
		}
		
		return freqArr;	
	}
	
	public static void findCodes(int[] f) throws IOException{
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(27);
		char[] charArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
		
		for (int j=0; j<27; j++) {
			Node n = new Node();
			n.setProb(f[j]);
			n.setCh(charArr[j]);
			n.setLeft(null);
			n.setRight(null);
			q.add(n);
		}
		
		Node root = null;
		
		// Construct Minimum-Priority Queue
		
		while(q.size()>1) {
			
			Node one = q.peek();
			q.poll();
			Node two = q.peek();
			q.poll();
			
			Node newFreq = new Node();
			
			newFreq.setProb(one.getProb()+two.getProb());	//add frequencies for new combined node
			newFreq.setCh('-');								
			newFreq.setLeft(one);							//update pointers
			newFreq.setRight(two);
			
			root = newFreq;
			q.add(newFreq);
		}
		
		String outfile = "code_key.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
		
		write(root, "", out);
		
		out.close();
	}
	
	public static void write(Node root, String s, BufferedWriter out) throws IOException{
		
		if(root.getLeft()==null && root.getRight()==null) {
			if(Character.isLetter(root.getCh())||(root.getCh()==' ')){
				out.write(root.getCh()+":"+s);
				out.write("\n");
						
				return;
			}
		}
		write(root.getLeft(), s+"0", out);
		write(root.getRight(), s+"1", out);
	}
}
