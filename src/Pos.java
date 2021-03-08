
public class Pos {
	public int x;
	public int y;
	public int depth;
	  
	Pos(int x, int y, int depth) {
	this.x = x;
	this.y = y;
	this.depth = depth;
	}

	public boolean equals(Pos that) {
	return this.x == that.x && this.y == that.y;
	}

	public String toString() {
	return "("+this.x + " " + this.y+ " " + this.depth +")";
	}
}
