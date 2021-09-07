
public class Main {

	public static void main(String[] args) {
		
		Tree arbol = new Tree(33);
		arbol.add(10);
		arbol.add(6);
		arbol.add(11);
		arbol.add(9);
		arbol.add(5);
		arbol.add(8);
		arbol.add(2);
		
		System.out.println("Delete: "+arbol.delete(6)+"\n");
		System.out.println(arbol.hasElement(6));
	}

}
