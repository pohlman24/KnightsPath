/**
 * 
 */

/**
 * @author reecepohlman
 *
 */
public class LLQueue {
	protected LLNode head; // front of line 
	protected LLNode tail; // end of line 
	protected int numberInQueue;
	
	
	public LLQueue() {
		head = tail = null;
		numberInQueue = 0;
	}
	

	
	public void enqueue(Pos start) throws QueueFullException {
		// TODO Auto-generated method stub
		LLNode newNode = new LLNode(start);
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numberInQueue++;
	}

	
	public Pos dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		LLNode removedNode;
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		removedNode = head;
		head = head.getNext();
		numberInQueue--;
		removedNode.setNext(null);
		return removedNode.getContents();
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberInQueue == 0;
	}

	
	public boolean isFull() {
		// TODO Auto-generated method stub
		// will never be full with a linked list
		return false;
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return numberInQueue;
	}

	
	public String peek() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */

}
