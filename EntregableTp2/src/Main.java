
public class Main {

	public static void main(String[] args) {
		
		Tree arbol = new Tree(15);
		arbol.add(10);
		arbol.add(6);
		arbol.add(11);
		arbol.add(17);
		arbol.add(9);
		arbol.add(5);
		arbol.add(8);
		arbol.add(2);
		arbol.add(19);
		
		
		arbol.printOrder();
		
		System.out.println("");
		
		//System.out.println(arbol.hasElement(6)+"\n");
		System.out.println("Delete: "+arbol.delete(2)+"\n");
		//System.out.println(arbol.hasElement(6));
		
		System.out.println(arbol.getHeight());
	}

}
