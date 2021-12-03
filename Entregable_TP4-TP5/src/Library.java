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
	
	public boolean isFeasible(Student s) {
		Boolean result = false;
		if(s.getScore() >= this.passingScore) {
			result = true;
		}
		return result;
	}
	
	public Solution assignBooksGreedy() {

		Solution solution = new Solution();
		sortBooks(this.books);
		sortStudents(this.students);
		
		while(!this.books.isEmpty() && !this.students.isEmpty()) {
			
			Student student = this.students.get(0);
			this.students.remove(student);
			int index = 0;
			
			while(!this.books.isEmpty() && !isFeasible(student) && index < this.books.size()) {
				
				Book book = this.books.get(index);
				
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
				solution.addStudent(student);
		}
		return solution;
	}
	
	public Solution assignBooksBacktracking() {	
		State state = new State();
		Solution currentSolution = null;
		int indexBook = 0;
		return this.assignBooksBacktracking(state , currentSolution, indexBook);
	}
	
	private Solution assignBooksBacktracking(State state, Solution currentSolution, int indexBook) {
	
		Boolean assignedBook = false;
		Book book = null;
		int indexStudent = 0;
		state.setCost(1);
		
		if(indexBook > this.books.size()-1 || state.getQuantityApproved() == students.size()) {
			if(currentSolution == null || currentSolution.getQuantityApproved() < state.getQuantityApproved()) {
				currentSolution = new Solution();
				ArrayList<Student> studentsState = state.getStudents();
				for(Student s : studentsState) {
					if(this.isFeasible(s)) {						
						currentSolution.addStudent(s);
					}
				}
			}
		} 
		else {
			
			if(indexBook < this.books.size()) {
				book = this.books.get(indexBook);
			}
			
			indexBook++;
			
			while(indexStudent < this.students.size() && book != null) {
				
				Student student = this.students.get(indexStudent);
				
				if(!student.containBook(book)) {
					
					//------ HACER ------
					assignedBook = true;
					this.removeBook(book);
					student.addBook(book);
					student.setScore(book.getScore());
					state.addStudent(student);
					
					if(this.isFeasible(student)) {
						state.setQuantityApproved(1);
					}

					// LLAMADO RECURSIVO AL BACK
					this.assignBooksBacktracking(state, currentSolution, indexBook);
										
					//------ DESHACER ------
					this.addBook(book);
					student.removeBook(book);
					student.setScore(-book.getScore());
					//state.removeStudent(student);
					
					if(this.isFeasible(student)) {
						state.setQuantityApproved(-1);
					}
				}
				indexStudent++;
			}
			
			if(assignedBook == false) {
				this.removeBook(book);
				this.assignBooksBacktracking(state, currentSolution, indexBook);
				this.addBook(book);
			}
		}
		
		return currentSolution;
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