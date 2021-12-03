import java.util.ArrayList;

public class State {
	
	private ArrayList<Student> AllStudents;
	private int quantityApproved;
	private int cost;
	
	public State(ArrayList<Student> students) {
		this.AllStudents = new ArrayList<>();
		this.AllStudents.addAll(students);
		this.quantityApproved = 0;
		this.cost = 0;
	}
	
	public int getQuantityApproved() {
		return this.quantityApproved;
	}
	
	public void setQuantityApproved(int quantity) {
		this.quantityApproved += quantity;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setCost(int cost) {
		this.cost += cost;
	}
}
