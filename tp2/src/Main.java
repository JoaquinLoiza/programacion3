

public class Main {
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7};
		System.out.println("El arreglo esta ordenado ascendentemente?: " + isSortAsc(array));
		
	}
	
	//-----------------Ejercicio 1--------------------
	public static boolean isSortAsc(int[] array) {
		return isSortAsc(array, 0);
	}

	private static boolean isSortAsc(int[] array, int index) {
		boolean aux = true;
		
		if(index < array.length-1) {
			if (array[index] <= array[index+1]) {
				aux = isSortAsc(array, index+1);
			} else 
				aux = false;
		}
		return aux;
	}
	//------------------------------------------------
	//-----------------Ejercicio 2--------------------
	
	public static <T> int findElement(MySimpleLinkedList<T> element) {
		return 0;
	}
	
	
	
}
