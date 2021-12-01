import java.util.ArrayList;

public class Student implements Comparable<Student>{
	
	private String id;
	private int score;
	private ArrayList<Book> books;
	
	public Student(String id, int score) {
		this.id = id;
		this.score = score;
		this.books = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score += score;
	}
	
	public void addBook(Book l) {
		this.books.add(l);
	}
	
	public boolean containBook(Book l) {
		if(!this.books.isEmpty()) {
			 return this.books.get(this.books.size()-1).equals(l);
		}
		return false;
	}
	
	public ArrayList<Book> getBooks(){
		return new ArrayList<>(this.books);	
	}

	@Override
	public String toString() {
		return this.id+" : "+this.books;
	}
	
	@Override
	public int compareTo(Student s) {
		if (this.score > s.score) {
			return -1;
		}
		if(this.score < s.score) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
