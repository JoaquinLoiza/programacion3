
import java.util.ArrayList;

public class MainGreedy {

	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Student> students = new ArrayList<Student>();

		CSVReaderBooks readerBooks = new CSVReaderBooks("./data/dataset1.csv");
		books = readerBooks.read();

		CSVReaderStudents readerStudents = new CSVReaderStudents("./data/students.csv");
		students = readerStudents.read();

		Library library = new Library(50);
		library.addStudents(students);
		library.addBooks(books);
		
		System.out.println(library.assignBooksGreedy());
		System.out.println("---------------------\nEl costo fue de: "+library.getCost());
	}
}
