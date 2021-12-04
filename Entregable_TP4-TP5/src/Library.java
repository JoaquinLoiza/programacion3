import java.util.ArrayList;
import java.util.Collections;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Student> students;
	private Solution solution;
	private int passingScore;
	
	public Library(int passingScore) {
		this.books = new ArrayList<>();
		this.students = new ArrayList<>();
		this.solution = new Solution();
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
	
	private void removeBook(Book book) {
		if(book.getCopies() > 1) {
			book.setCopies(-1);
		} else {
			this.books.remove(book);
		}
	}
	
	private void addBook(Book book) {
		if(!this.books.contains(book)) {
			this.books.add(book);
		} else {
			book.setCopies(1);
		}
	}
	
	public boolean approvedStudent(Student s) {
		Boolean result = false;
		if(s.getScore() >= this.passingScore) {
			result = true;
		}
		return result;
	}
	
	public Solution assignBooksGreedy() {

		sortBooks(this.books);
		sortStudents(this.students);
		
		while(!this.books.isEmpty() && !this.students.isEmpty()) {
			
			Student student = this.students.get(0);
			this.students.remove(student);
			int index = 0;
			
			while(!this.books.isEmpty() && !approvedStudent(student) && index < this.books.size()) {
				
				Book book = this.books.get(index);
				this.solution.setCost(1);
				
				if(student.containBook(book)) {
					index++;
				} 
				else {		
					student.addBook(book);
					student.setScore(book.getScore());
					this.removeBook(book);
					//Si lo contiene significa que al remover tenia una
					//copia y se decremento el numero de las mismas
					if(this.books.contains(book)) {
						index++;
					}
				}
			}
			
			if(approvedStudent(student)) 
				this.solution.addStudent(student);
		}
		return this.solution;
	}
	
	public Solution assignBooksBacktracking() {	
		State state = new State(this.students);
		return this.assignBooksBacktracking(state);
	}
	
	private Solution assignBooksBacktracking(State state) {
		
		this.solution.setCost(1);
		
		if(state.getIndexBook() > this.books.size()-1 || state.getQuantityApproved() == students.size()) {
			if(this.solution.getQuantityApproved() == 0 || this.solution.getQuantityApproved() < state.getQuantityApproved()) {
				this.solution = new Solution();
				ArrayList<Student> studentsState = state.getStudentsApproved(this.passingScore);
				this.solution.addStudents(studentsState);
			}
		}
		else {
			Book book = null;
			if(state.getIndexBook() < this.books.size()) {
				book = this.books.get(state.getIndexBook());
			}
			
			if(book != null) {
				boolean assignedBook = false;
				int indexStudent = 0;
				
				while(indexStudent < this.students.size()) {
					
					Student student = this.students.get(indexStudent);
					if(!student.containBook(book) && !this.approvedStudent(student)) {
						//------ HACER ------
						assignedBook = true;
						student.addBook(book);
						student.setScore(book.getScore());
						this.removeBook(book);
						if(this.approvedStudent(student)) {
							state.setQuantityApproved(1);
						}
						
						// LLAMADO RECURSIVO AL BACK
						this.assignBooksBacktracking(state);
						
						//------ DESHACER CAMBIOS ------
						if(this.approvedStudent(student)) {
							state.setQuantityApproved(-1);
						}
						student.removeBook(book);
						student.setScore(-book.getScore());
						this.addBook(book);
					}
					indexStudent++;
				}
				
				if(!assignedBook) {
					state.setIndexBook(1);
					this.assignBooksBacktracking(state);
					state.setIndexBook(-1);
				}
				
			}
		}
		return this.solution;
	}
}