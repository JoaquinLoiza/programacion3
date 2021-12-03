import java.util.ArrayList;

public class State {
	
	private ArrayList<Student> AllStudents;
	private int quantityApproved;
	private int cost;
	
	public State() {
		this.AllStudents = new ArrayList<>();
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
	
	public void addStudent(Student student) {
		if(!this.AllStudents.contains(student)) {
			this.AllStudents.add(student);
		}
	}
	
	public void removeStudent(Student student) {
		this.AllStudents.remove(student);
	}
	
	public ArrayList<Student> getStudents() {
		return new ArrayList<Student>(this.AllStudents);
	}
}
