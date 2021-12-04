import java.util.ArrayList;

public class Solution {
	
	private ArrayList<Student> studentsSolution;
	private int cost;

	public Solution() {
		this.studentsSolution = new ArrayList<>();
		this.cost = 0;
	}
	
	public void addStudent(Student s) {
		this.studentsSolution.add(s) ;
	}
	
	public void addStudents(ArrayList<Student> students) {
		this.studentsSolution.addAll(students) ;
	}
	
	public ArrayList<Student> getStudentsSolution(){
		return new ArrayList<>(this.studentsSolution);
	}

	public int getQuantityApproved() {
		return this.studentsSolution.size();
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setCost(int n) {
		this.cost += n;
	}
	
	@Override
	public String toString() {
		String students = "";
		for(Student s : this.studentsSolution) {		
			students += s.toString() + "\n";
		}
		return "Los alumnos aprobados son: \n" + students +"---------------------\n\nEl costo fue de: "+this.cost;
	}
}
