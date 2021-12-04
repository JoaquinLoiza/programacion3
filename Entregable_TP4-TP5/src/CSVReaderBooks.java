
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderBooks {
	
	private String path;
	
	public CSVReaderBooks(String path) {
		this.path = path;
	}
	
	public ArrayList<Book> read() {
		
		ArrayList<String[]> lines = this.readContent();
		ArrayList<Book> books = new ArrayList<Book>();
		
		for (String[] line: lines) {
			String idBook = line[0].trim();
			String title = line[1].trim();
			String author = line[2].trim();
			String genre = line[3].trim();
			Integer pages = Integer.parseInt(line[4].trim());
			Integer score = Integer.parseInt(line[5].trim());
			Integer copies = Integer.parseInt(line[6].trim());
			
			Book book = new Book(idBook,title,author,genre,pages,score,copies);
			books.add(book);
		}
		return books;
	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}

}
