

public class Node implements Comparable<Node>{
	
	private int prob;
	private char ch;
	private Node left;
	private Node right;
	
	//Constructor
	public Node() {

	}
	
	public int getProb() {
		return prob;
	}
	public void setProb(int prob) {
		this.prob = prob;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node l) {
		this.left = l;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node r) {
		this.right = r;
	}

	public int compareTo(Node n) {
		int compareProb = ((Node) n).getProb(); 
		return (this.prob - compareProb);  //Ascending
	}
}