import CSVReaders.CSVReaderBooks;
import CSVReaders.CSVReaderStudents;

public class Main {

	public static void main(String[] args) {
		
		CSVReaderBooks readerLibros = new CSVReaderBooks("./datos/dataset1.csv");
		readerLibros.read();
		
		CSVReaderStudents readerAlumnos = new CSVReaderStudents("./datos/alumnos.csv");
		readerAlumnos.read();
	}
}
