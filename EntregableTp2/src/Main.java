
public class Main {

	public static void main(String[] args) {
		
		Tree arbol = new Tree(16);
		arbol.add(14);
		arbol.add(6);
		arbol.add(15);
		arbol.add(17);
		arbol.add(9);
		arbol.add(5);
		arbol.add(8);
		arbol.add(2);
		arbol.add(19);
			
		//System.out.println(arbol.hasElement(6)+"\n");
		
		//System.out.println("Delete: "+arbol.delete(6)+"\n");
		
		//Imprime la altura del arbol
		System.out.println("La altura es: "+arbol.getHeight()+"\n");
		
		//Trae un ArrayList con los nodos del brazo mas largo
		/*
		for(Tree t: arbol.getLongestBranch()) {
			System.out.println(t.getValue());
		}
		*/
		
		System.out.println("");
		
		//Trae un ArrayList con los nodos hojas/frontera
		for(Tree t: arbol.getFrontier()) {
			System.out.println(t.getValue());
		}
		
	}

}
