import java.util.ArrayList;
import java.util.Collections;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Student> students;
	private Solution solution;
	private int passingScore;
	private int cost;
	
	public Library(int passingScore) {
		this.books = new ArrayList<>();
		this.students = new ArrayList<>();
		this.solution = new Solution();
		this.passingScore = passingScore;
		this.cost = 0;
	}
	
	public int getCost() {
		return this.cost;
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
	
	public boolean isFeasible(Student s) {
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
			
			while(!this.books.isEmpty() && !isFeasible(student) && index < this.books.size()) {
				
				Book book = this.books.get(index);
				this.cost++;
				
				if(student.containBook(book)) {
					index++;
				} 
				else {		
					student.addBook(book);
					student.setScore(book.getScore());
					
					if(book.getCopies() > 1) {
						book.setCopies(-1);
						index++;
					}
					else {
						this.books.remove(index);
					}
				}
			}
			
			if(isFeasible(student)) 
				this.solution.addStudent(student);
		}
		return this.solution;
	}
	
	public Solution assignBooksBacktracking() {	
		State state = new State(this.students);
		return this.assignBooksBacktracking(state);
	}
	
	private Solution assignBooksBacktracking(State state) {
		
		this.cost++;
		
		if(state.getIndexBook() > this.books.size()-1 || state.getQuantityApproved() == students.size()) {
			
			if(this.solution.getQuantityApproved() == 0 || this.solution.getQuantityApproved() < state.getQuantityApproved()) {
				this.solution = new Solution();
				ArrayList<Student> studentsState = state.getStudentsApproved(this.passingScore);
				for(Student s : studentsState) {
					this.solution.addStudent(s);
				}
			}
		}
		else {
			Book book = null;
			if(state.getIndexBook() < this.books.size()) {
				book = this.books.get(state.getIndexBook());
			}
			
			if(this.books.size() > 0 && book != null) {
				boolean assignedBook = false;
				int indexStudent = 0;
				
				while(indexStudent < this.students.size()) {
					
					Student student = this.students.get(indexStudent);
					if(!student.containBook(book) && !this.isFeasible(student)) {
						assignedBook = true;
						student.addBook(book);
						student.setScore(book.getScore());
						this.removeBook(book);
						if(this.isFeasible(student)) {
							state.setQuantityApproved(1);
						}
						
						// LLAMADO RECURSIVO AL BACK
						this.assignBooksBacktracking(state);
						
						//------ DESHACER CAMBIOS ------
						if(this.isFeasible(student)) {
							state.setQuantityApproved(-1);
						}
						student.removeBook(book);
						student.setScore(-book.getScore());
						this.addBook(book);
					}
					indexStudent++;
				}
				
				if(assignedBook == false) {
					state.setIndexBook(1);
					this.assignBooksBacktracking(state);
					state.setIndexBook(-1);
				}
				
			}
		}
		return this.solution;
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
}