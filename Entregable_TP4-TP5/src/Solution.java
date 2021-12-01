import java.util.ArrayList;

public class Solution {
	
	private ArrayList<Student> studentsSolution;
	private int quantity;

	public Solution() {
		this.studentsSolution = new ArrayList<>();
		this.quantity = 0;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity() {
		this.quantity+= 1;
	}
	
	public void add(Student s) {
		this.studentsSolution.add(s) ;
	}
	
	public void remove(Student s) {
		this.studentsSolution.remove(s);
	}
	
	public ArrayList<Student> getStudentsSolution(){
		return new ArrayList<>(this.studentsSolution);
	}

	@Override
	public String toString() {
		return "La cantidad de alumnos aprobados es "+ this.getQuantity() +" y los que aprobaron son "+ this.studentsSolution.toString();
	}
}
