
public class Main {

	public static void main(String[] args) {
		
		int[] array = {10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30};
		Tree arbol = new Tree(array);
			
		System.out.print("Impresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Integer n: arbol.getLongestBranch()) {			
			System.out.print(n+" ");
		}
		
		int level = 2;
		System.out.print("\nElementos del nivel '"+level+"': ");
		for(Integer n: arbol.getElemAtLevel(level)) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Integer n: arbol.getFrontier()) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer n: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(n+" ");
		}
		
		arbol.add(23);
		arbol.add(4);
		arbol.delete(11);
		arbol.delete(25);
		
		System.out.print("\n\nImpresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Integer n: arbol.getLongestBranch()) {			
			System.out.print(n+" ");
		}
		
		int level2 = 2;
		System.out.print("\nElementos del nivel '"+level2+"': ");
		for(Integer n: arbol.getElemAtLevel(level2)) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Integer n: arbol.getFrontier()) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer n: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(n+" ");
		}
		arbol.add(65);
		arbol.add(8);
		arbol.delete(10);
		arbol.delete(55);
		
		System.out.print("\n\nImpresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Integer n: arbol.getLongestBranch()) {			
			System.out.print(n+" ");
		}
		
		int level3 = 2;
		System.out.print("\nElementos del nivel '"+level3+"': ");
		for(Integer n: arbol.getElemAtLevel(level3)) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Integer n: arbol.getFrontier()) {		
			System.out.print(n+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer n: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(n+" ");
		}
	}

}
