
public class Main {

	public static void main(String[] args) {
		
		int[] array = {16, 14, 6, 15, 17, 9, 5, 8, 2, 19};
		Tree arbol = new Tree(array);
				
		System.out.print("Impresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Tree t: arbol.getLongestBranch()) {			
			System.out.print(t.getValue()+" ");
		}
		
		int level = 2;
		System.out.print("\nElementos del nivel '"+level+"': ");
		for(Tree t: arbol.getElemAtLevel(level)) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Tree t: arbol.getFrontier()) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer e: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(e+" ");
		}
		
		arbol.add(23);
		arbol.add(4);
		arbol.delete(6);
		arbol.delete(9);
		
		System.out.print("\n\nImpresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Tree t: arbol.getLongestBranch()) {			
			System.out.print(t.getValue()+" ");
		}
		
		int level2 = 2;
		System.out.print("\nElementos del nivel '"+level2+"': ");
		for(Tree t: arbol.getElemAtLevel(level2)) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Tree t: arbol.getFrontier()) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer e: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(e+" ");
		}
		
		arbol.add(34);
		arbol.add(13);
		arbol.delete(17);
		arbol.delete(8);
		
		System.out.print("\n\nImpresión preorder: ");
		arbol.printPreOrder();
		System.out.println("\nElemento de mayor valor: "+arbol.getMaxElem() );
		System.out.println("Altura del arbol: " + arbol.getHeight() );
		
		System.out.print("Rama mas larga del arbol: ");
		for(Tree t: arbol.getLongestBranch()) {			
			System.out.print(t.getValue()+" ");
		}
		
		int level3 = 2;
		System.out.print("\nElementos del nivel '"+level3+"': ");
		for(Tree t: arbol.getElemAtLevel(level3)) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nElementos frontera: ");
		for(Tree t: arbol.getFrontier()) {		
			System.out.print(t.getValue()+" ");
		}
		
		System.out.print("\nvalor de la diferencia entre hojas contiguas del árbol: ");
		for(Integer e: arbol.getDifferenceBetweenLeaves()) {			
			System.out.print(e+" ");
		}
		
	}

}
