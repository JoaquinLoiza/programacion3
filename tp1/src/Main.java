import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		/*
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
		
		lista.insertFront(3);
		lista.insertFront(2);
		lista.insertFront(1);

		Iterator<Integer> it1 = lista.iterator();
		while(it1.hasNext()) {
			int valor = it1.next();
			System.out.println(valor);
		}
		
		int index = 2;		
		System.out.println("El de indice "+index+": "+lista.get(2));
		*/

		/*
		 *  EJERCICIO 2
		 * a. La complejidad de insertar al principio en MySimpeLinkedList es de O(1),
		 * 	  y en un array convencional es O(n);
		 * b. La complejidad de buscar un elemento en MySimpeLinkedList es de O(n),
		 *    mientras que en un array es O(1);
		 * c. Considerando que tenemos el atributo size en MySimpleLinkedList que se actualiza
		 * 	  cada vez que insertamos o eliminamos un elemento, la complejidad seria de 0(1);
		 * 	  y en un array tambien seria de O(1);
		 */
		
		/*
		Pila<Integer> pila = new Pila<Integer>();
		
		pila.push(1);
		pila.push(2);
		pila.push(3);
		
		Iterator<Integer> it2 = pila.iterator();
		while(it2.hasNext()) {
			int valor = it2.next();
			System.out.println(valor);
		}
		
		System.out.println(pila.indexOf(5));
		*/
		
		MySimpleLinkedList<Integer> l1 = new MySimpleLinkedList<Integer>();
		l1.insertFront(5);
		l1.insertFront(8);
		l1.insertFront(1);
		l1.insertFront(1);
		l1.insertFront(6);
		
		MySimpleLinkedList<Integer> l2 = new MySimpleLinkedList<Integer>();
		l2.insertFront(6);
		l2.insertFront(5);
		l2.insertFront(8);
		l2.insertFront(2);
		l2.insertFront(3);
		l2.insertFront(1);
		l2.insertFront(8);
		
		MySimpleLinkedList<Integer> orderedList = new MySimpleLinkedList<Integer>();
		ListCombiner<Integer> lc = new ListCombiner<Integer>(l1, l2);
		orderedList = lc.getCommonOrderedList();
		
		Iterator<Integer> it2 = orderedList.iterator();
		while(it2.hasNext()) {
			int valor = it2.next();
			System.out.println(valor);
		}
	
	}
}
