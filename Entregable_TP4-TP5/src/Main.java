
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Student> students = new ArrayList<Student>();

		CSVReaderBooks readerBooks = new CSVReaderBooks("./data/dataset1.csv");
		books = readerBooks.read();

		//Collections.sort(books);

		System.out.println(books);
		
		CSVReaderStudents readerStudents = new CSVReaderStudents("./data/students.csv");
		students = readerStudents.read();

		Collections.sort(students);
		
		//System.out.println(students);

		Library library = new Library(120);
		library.addStudents(students);
		library.addBooks(books);
		System.out.println(library.assignBooks());
		
	}
}
