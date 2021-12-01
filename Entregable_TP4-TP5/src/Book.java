
public class Book implements Comparable<Book>{
	
	private String id;
	private String title;
	private String author;
	private String genre;
	private int pages;
	private int score;
	private int copies;
	
	public Book(String idBook, String title, String author,
			String genre, int pages, int score, int copies) {
		
		this.id = idBook;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pages = pages;
		this.score = score;
		this.copies = copies;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getPages() {
		return this.pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getCopies() {
		return this.copies;
	}
	
	public void setCopies() {
		this.copies = this.copies-1;
	}
	
	@Override
	public String toString() {
		return "Titulo: "+this.title;
	}
	
	@Override
	public int compareTo(Book l1) {
		if(this.score<l1.score) {
			return -1;
		}
		if(this.score>l1.score) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Book p = (Book)obj;
			return this.getId().equals(p.getId()); 
		} catch (Exception e) {
			return false;
		}
	}
}