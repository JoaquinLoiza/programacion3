
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderStudents {
	
	private String path;
	
	public CSVReaderStudents(String path) {
		this.path = path;
	}
	
	public ArrayList<Student> read() {
		
		ArrayList<Student>students = new ArrayList<Student>();		
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			String idStudent = line[0].trim();
			Integer score = Integer.parseInt(line[1].trim());
			Student student = new Student(idStudent,score);
			students.add(student);
		}
		return students;
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
