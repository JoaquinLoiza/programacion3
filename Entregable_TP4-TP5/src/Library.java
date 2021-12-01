import java.util.ArrayList;
import java.util.Collections;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Student> students;
	private int passingScore;
	
	public Library(int passingScore) {
		this.books = new ArrayList<>();
		this.students = new ArrayList<>();
		this.passingScore = passingScore;
	}
	
	public Solution asignar() {

    Solution s = new Solution();
		
		ordenarLibros(books);
		ordenarAlumnos(students);

		int indice = 0;
		while(!students.isEmpty() && !books.isEmpty()) {
			Student a = students.get(0);
			while(a.getScore() < this.passingScore && !books.isEmpty() &&books.size()>indice) {
				Book l = books.get(indice);
				if(!a.containBook(l)) {
					a.addBook(l);
					a.setScore(l.getScore());
					if(l.getCopies() > 1) {
						l.setCopies();
						indice++;
					}
					else {
						books.remove(indice);
					}
					
				}
				else {
					indice++;
				}	
			}
			s.add(a);
			if(a.getScore()>=this.passingScore) {
				s.setCant();
				indice=0;
			}
			else {
				s.remover(a);
			}
			students.remove(a);
		}
		
		return s;
	}
	
	private void ordenarLibros(ArrayList<Book> libros) {
		Collections.sort(libros);
	}
	
	private void ordenarAlumnos(ArrayList<Student> alumnos) {
		Collections.sort(alumnos);
	}
	
	public void addLibro(ArrayList<Book> librosN) {
		books.addAll(librosN);
	}
	
	public void addAlumnos(ArrayList<Student> alumnosN) {
		students.addAll(alumnosN);
	}
}