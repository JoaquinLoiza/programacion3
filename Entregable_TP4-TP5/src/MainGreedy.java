
import java.util.ArrayList;

public class MainGreedy {

	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Student> students = new ArrayList<Student>();

		CSVReaderBooks readerBooks = new CSVReaderBooks("./data/dataset2.csv");
		books = readerBooks.read();

		CSVReaderStudents readerStudents = new CSVReaderStudents("./data/students2.csv");
		students = readerStudents.read();

		Library library = new Library(40);
		library.addStudents(students);
		library.addBooks(books);
		
		System.out.print(library.assignBooksGreedy());
	}
}
