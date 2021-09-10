import java.util.ArrayList;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;
	private Tree father;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.father = null;
	}
	
	// O(h*n)
	// Al ser O(h) la complejidad del metodo 'add', se ejecutará 1 vez por cada 
	// elemento del array, haciendo que la complejidad del metodo resulte en O(h*n).
	public Tree(int[] array) {
		for(int value: array) {
			this.add(value);
		}
	}
	
	// O(h) Porque depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null) {
					Tree arbol = new Tree(newValue);
					this.left = arbol;
					arbol.father = this;
				}
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null) {					
					Tree arbol = new Tree(newValue);
					this.right = arbol;
					arbol.father = this;
				}
				else
					this.right.add(newValue);
			}
		}
	}
	
	// O(1);
	// Donde se realiza un solo acceso a memoria.
	public Integer getValue() {
		int v = this.value;
		return v;
	}
	
	// O(1)
	// Donde se compara el valor con un solo acceso a memoria.
	public boolean isEmpty() {
		return (this.value == null);
	}
	
	// O(1)
	// Donde se compara el valor con un solo acceso a memoria.
	public Integer getRoot() {
		if (this.value != null) {			
			return this.value;
		}else 
			return -1;
	}
	
	// O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public boolean hasElement(Integer e) {
		return hasElement(e, this);
	}
	
	private boolean hasElement(Integer e, Tree t) {
		if (getNode(e,t) != null) {
			return true;
		} else
			return false;
	}
	
	// O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	private Tree getNode(Integer e, Tree t) {
		
		Tree aux = null;
		
		if (t.value != null) {
			if(t.value == e) {
				aux = t;
			} 
			else if (e < t.value && t.left != null) {
				aux = getNode(e, t.left); 
			} 
			else if (e > t.value && t.right != null){
				aux = getNode(e, t.right);
			}
		}
		return aux;
	}
	
	// O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	// para esta complejidad se tuvieron en cuenta, todos los metodos
	// delete (los 3 casos) y el metodo que busca el nodo mas a la
	// izquierda del brazo derecho.
	public boolean delete(Integer i) {
		return delete(i, this);
	}
	
	private boolean delete(Integer i, Tree t) {
		boolean aux = false;
		Tree tree = getNode(i, t);
				
		if (tree != null) {
			if(tree.left == null && tree.right == null) {
				if(tree.father.value > tree.value) {
					tree.father.left = null;
				} else {
					tree.father.right = null;
				}
				tree.value = null;
			}
			else if(tree.left != null && tree.right != null) {
				deleteWithChilds(tree);
			} 
			else {
				if(tree.left != null) {
					deleteWithLeftChild(tree);
				} 
				else
					deleteWithRightChild(tree);
			}
			aux = true;
		}
		return aux;
	}
	
	private void deleteWithLeftChild(Tree t) {
		if(t.father != null) {
			if (t.value > t.father.value) {
				t.father.right = t.left;
			} else
				t.father.left = t.left;
		} else {
			t = t.left;
		}
	}
	
	private void deleteWithRightChild(Tree t) {
		if(t.father != null) {
			if (t.value >= t.father.value) {
				t.father.right = t.right;
			} else
				t.father.left = t.right;
		} else {
			t = t.right;
		}
	}
	
	private void deleteWithChilds(Tree t) {
		Tree aux = FindLeftmostRightNode(t.right);
		t.value = aux.value;
		delete(aux.value ,aux);
	}
	
	// O(h) porque no estamos seguros de que nuestro arbol este balanceado.
	private Tree FindLeftmostRightNode(Tree t) {
		if(t.left != null) {
			return FindLeftmostRightNode(t.left);
		} else
			return t;
	}
	
	//O(n)
	// Para todos los metodos de impresion (pre order, post order y order) 
	// ya que en todos los casos debemos recorrer todos los nodos del arbol.
	public void printPreOrder() {
		printPreOrder(this);
	}
	
	private void printPreOrder(Tree t) {
		if(t == null) {
			return;
		}	
		System.out.print(t.value+" ");
		
		if(t.left != null)			
			printPreOrder(t.left);
		else
			System.out.print("- ");
		
		if(t.right != null)			
			printPreOrder(t.right);
		else
			System.out.print("- ");
	}
	
	public void printPostOrder() {
		printPostOrder(this);
	}
	
	private void printPostOrder(Tree t) {
		if(t == null) {
			return;
		}
		
		printPostOrder(t.left);
		printPostOrder(t.right);
		System.out.println(t.value);
	}
	
	public void printOrder() {
		printOrder(this);
	}
	
	private void printOrder(Tree t) {
		if(t == null) {
			return;
		}
		
		printOrder(t.left);
		System.out.println(t.value);
		printOrder(t.right);
	}

	//O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public int getHeight() {
		return getHeight(this);
	}

	private int getHeight(Tree t) {
		int l = 0;
		int r = 0;
		
		if(t.left != null) {
			l = t.left.getHeight(t.left) + 1;
		}
		
		if(t.right != null) {
			r = t.right.getHeight(t.right) + 1;
		}
		
		if (l > r )
			return l;
		else
			return r;
	}
	
	//O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.	
	public ArrayList<Tree> getLongestBranch() {
		return getLongestBranch(this);
	}
	
	private ArrayList<Tree> getLongestBranch(Tree t) {
		ArrayList<Tree> branchL = new ArrayList<>();
		ArrayList<Tree> branchR = new ArrayList<>();
		branchL.add(t);
		branchR.add(t);
		
		if(t.left != null) {
			branchL.addAll(t.left.getLongestBranch(t.left));
		}
		
		if(t.right != null) {
			branchR.addAll(t.right.getLongestBranch(t.right));
		}	
		
		if (branchL.size() >= branchR.size()) {			
			return branchL;
		} else
			return branchR;
	}
	
	//O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public Integer getMaxElem() {
		return getMaxElem(this);
	}

	private Integer getMaxElem(Tree t) {
		Integer aux = t.value;
		if(t.right != null) {
			aux = getMaxElem(t.right);
		} 
		return aux;
	}
	
	//O(n)
	//Ya que recorrera todos los nodos hasta llegar a cada una de las hojas.
	public ArrayList<Tree> getFrontier(){
		  return getFrontier(this);
	}
	
	private ArrayList<Tree> getFrontier(Tree t) {
		ArrayList<Tree> aux = new ArrayList<>();
		if(t != null) {
			if (t.left==null && t.right == null) {
				aux.add(t);
			}
			else {
				if(t.left != null) {
					aux.addAll(getFrontier(t.left));
				}
				if (t.right != null) {
					aux.addAll(getFrontier(t.right));
				}
			}
		}
		return aux;
	}

	//O(h) 
	//Donde 'h' es la altura que recibe por parametro.
	public ArrayList<Tree> getElemAtLevel(int level) {
		return getElemAtLevel(level, this, 0);
	}
	
	private ArrayList<Tree> getElemAtLevel(int level, Tree t, int levelAux) {
		ArrayList<Tree> aux = new ArrayList<>();
		int lAux = levelAux;
		
		if (lAux == level) {
			aux.add(t);
		}
		else { 
			if(t.left != null) {
				aux.addAll(getElemAtLevel(level, t.left,(lAux+1)));
			}
			if(t.right != null) {
				aux.addAll(getElemAtLevel(level, t.right,(lAux+1)));
			}
		}
		return aux;
	}
	
	//O(n)
	//Ya que invoca al metodo getFrontier que recorre todo el arbol
	//hasta llegar a las hojas.
	public ArrayList<Integer> getDifferenceBetweenLeaves() {
		ArrayList<Tree>leaves = getFrontier();
		return getDifferenceBetweenLeaves(leaves, leaves.size()-1);
	}
	
	private ArrayList<Integer> getDifferenceBetweenLeaves(ArrayList<Tree> leaves, int i) {
		ArrayList<Integer> aux = new ArrayList<>();
		
		if(i > 0) {
			aux.add( (leaves.get(i).value) - (leaves.get(i-1).value) );
			aux.addAll(getDifferenceBetweenLeaves(leaves, i-1));
		}
		
		return aux;
	}
}
