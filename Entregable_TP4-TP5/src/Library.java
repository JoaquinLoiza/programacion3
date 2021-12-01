import java.util.ArrayList;
import java.util.Collections;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Student> students;
	private int passingScore;
	
	public Library(int passingScore) {
		this.books = new ArrayList<>();
		this.students = new ArrayList<>();
		this.passingScore = passingScore;
	}
	
	public void addBooks(ArrayList<Book> books) {
		this.books.addAll(books);
	}
	
	public void addStudents(ArrayList<Student> students) {
		this.students.addAll(students);
	}
	
	private void sortBooks(ArrayList<Book> books) {
		Collections.sort(books);
	}
	
	private void sortStudents(ArrayList<Student> students) {
		Collections.sort(students);
	}
	
	public Solution assignBooks() {

		Solution solution = new Solution();
		sortBooks(this.books);
		sortStudents(this.students);
		int index = 0;
		
		while(!this.books.isEmpty() && !this.students.isEmpty()) {
			
			Student student = this.students.get(0);
			
			while(!this.books.isEmpty() && this.books.size() > index && student.getScore() < this.passingScore) {
				
				Book l = this.books.get(index);
				
				if(!student.containBook(l)) {
					student.addBook(l);
					student.setScore(l.getScore());
					if(l.getCopies() > 1) {
						l.setCopies();
						index++;
					}
					else {
						this.books.remove(index);
					}
					
				} else {
					index++;
				}	
			}
			
			solution.add(student);
			
			if(student.getScore()>=this.passingScore) {
				index=0;
			}
			else {
				solution.remove(student);
			}
			
			this.students.remove(student);
		}
		
		return solution;
	}
}