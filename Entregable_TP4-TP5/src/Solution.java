import java.util.ArrayList;

public class Solution {
	
	private ArrayList<Student> studentsSolution;

	public Solution() {
		this.studentsSolution = new ArrayList<>();
	}
	
	public void add(Student s) {
		this.studentsSolution.add(s) ;
	}
	
	public ArrayList<Student> getStudentsSolution(){
		return new ArrayList<>(this.studentsSolution);
	}

	public int getQuantityApproved() {
		return this.studentsSolution.size();
	}
	
	@Override
	public String toString() {
		
		String students = "";
		for(Student s : this.studentsSolution) {		
			students += s.toString() + "\n";
		}
		
		return "Los alumnos aprobados son: \n" + students;
	}
}
