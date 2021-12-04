import java.util.ArrayList;

public class Student implements Comparable<Student>{
	
	private String id;
	private int score;
	private ArrayList<Book> books;
	
	public Student() {
		this.id = null;
		this.score = 0;
		this.books = new ArrayList<>();
	}
	
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
	
	public Student clone() {
		Student s = new Student();
		s.setId(this.id);
		s.setScore(this.score);
		s.addBooks(new ArrayList<Book>(this.books));
		return s;
	}
	
	public void addBooks(ArrayList<Book> books) {
		this.books.addAll(books);
	}
	
	public boolean containBook(Book l) {
		return this.books.contains(l);
	}
	
	public ArrayList<Book> getBooks(){
		return new ArrayList<>(this.books);	
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
	}

	@Override
	public String toString() {
		String data = "---------------------\n"
				+ "Id: "+this.id+"\n"
				+ "Score: "+this.score+"\n"
				+ "Books: "+this.books; 
		return data;
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
