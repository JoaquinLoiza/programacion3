package CSVReaders;

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
	
	public void read() {
		
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			String idLibro = line[0].trim();
			String titulo = line[1].trim();
			String autor = line[2].trim();
			String genero = line[3].trim();
			Integer paginas = Integer.parseInt(line[4].trim());
			Integer puntaje = Integer.parseInt(line[5].trim());
			Integer cantidadEjemplares = Integer.parseInt(line[6].trim());
			
			System.out.println(idLibro);
			System.out.println(titulo);
			System.out.println(autor);
			System.out.println(genero);
			System.out.println(paginas);
			System.out.println(puntaje);
			System.out.println(cantidadEjemplares);
		}
		
	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine(); // Salteo la primera linea
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
