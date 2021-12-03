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
		return this.books.contains(l);
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
