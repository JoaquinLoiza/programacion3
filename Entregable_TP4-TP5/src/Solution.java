import java.util.ArrayList;

public class Solution {
	private ArrayList<Student> solucion;
	private int cant;

	public Solution() {
		this.solucion = new ArrayList<>();
		this.cant=0;
	}
	
	public int getCant() {
		return cant;
	}
	
	public void setCant() {
		this.cant+=1;
	}
	
	public void add(Student a) {//agrego el alumno con un arreglo vacio de libros
		this.solucion.add(a) ;
	}
	
	public void remover(Student a) {
		this.solucion.remove(a);
	}
	
	public ArrayList<Student> alumnos(){
		return new ArrayList<>(this.solucion);
	}

	@Override
	public String toString() {
		return "La cantidad de alumnos aprobados es "+ this.getCant() +" y los que aprobaron  son "+ this.solucion.toString();
	}
}
