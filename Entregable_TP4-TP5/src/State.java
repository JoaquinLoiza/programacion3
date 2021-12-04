import java.util.ArrayList;

public class State {
	
	private ArrayList<Student> AllStudents;
	private int quantityApproved;
	private int indexBook;
	
	public State(ArrayList<Student> students) {
		this.AllStudents = new ArrayList<>();
		this.AllStudents.addAll(students);
		this.quantityApproved = 0;
		this.indexBook = 0;
	}
	
	public int getIndexBook() {
		return this.indexBook;
	}
	
	public void setIndexBook(int n) {
		this.indexBook += n;
	}
	
	public int getQuantityApproved() {
		return this.quantityApproved;
	}
	
	public void setQuantityApproved(int quantity) {
		this.quantityApproved += quantity;
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
	
	public ArrayList<Student> getStudentsApproved(int passingScore) {
		ArrayList<Student> aux = new ArrayList<Student>();
		
		for(Student s : this.AllStudents) {
			if(s.getScore() >= passingScore) {
				aux.add(s.clone());
			}
		}
		return aux;
	}
}
