
public class LLNode {
	protected Pos contents;
	protected LLNode next;
	
	public LLNode(){
		this(null,null);
	}
	
	public LLNode(Pos start){
		this(start,null);
	}
	
	public LLNode(Pos start, LLNode n){
		contents = start;
		next = n;
	}

	public Pos getContents() {
		return contents;
	}

	public void setContents(Pos contents) {
		this.contents = contents;
	}

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}
	
}
