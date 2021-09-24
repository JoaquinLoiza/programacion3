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
			return null;
	}
	
	// O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public boolean hasElement(Integer e) {
		if(this.value == e) {
			return true;
		} else if (this.value < e) {
			if(this.right != null) {
				return this.right.hasElement(e);
			}
		} else {
			if (this.left != null) {
				return this.left.hasElement(e);
			}
		}
		return false;
	}
	
	// O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	private Tree getNode(Integer e) {	
		Tree aux = null;
		if(this.value != null) {			
			if(this.value == e) {
				aux = this;
			} else if (this.value < e) {
				if(this.right != null) {
					return this.right.getNode(e);
				}
			} else {
				if (this.left != null) {
					return this.left.getNode(e);
				}
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
		boolean aux = false;
		Tree tree = getNode(i);
		
		if (tree != null && this.value != null) {
			if(tree.left == null && tree.right == null) {		
				if (tree.father != null) {					
					if(tree.father.value > tree.value) 
						tree.father.left = null;
					else 
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
	
	private void deleteWithChilds(Tree t) {
		Integer aux = FindLeftmostRightNode(t.right).value;
		delete(aux);
		t.value = aux;
	}

	private Tree FindLeftmostRightNode(Tree t) {
		if(t.left != null) {
			return FindLeftmostRightNode(t.left);
		} else
			return t;
	}
	
	private void deleteWithLeftChild(Tree t) {
		if(t.father != null) {
			if (t.value > t.father.value) {
				t.father.right = t.left;
			} else
				t.father.left = t.left;
		} else {
			if(t.left.right != null) {			
				int nmi = t.FindLeftmostRightNode(t.left.right).value;
				t.value = nmi;
				t.left.delete(nmi);
			} else if (t.left.left != null) {
				t.value = t.left.value;
				t.left.delete(t.value);
			} else if(t.left.left == null && t.left.right == null) {
				t.value = t.left.value;
				t.left = null;
			}
		}
	}
	
	private void deleteWithRightChild(Tree t) {
		if(t.father != null) {
			if (t.value >= t.father.value) {
				t.father.right = t.right;
			} else
				t.father.left = t.right;
		} else {
			if(t.right.left != null) {			
				int nmi = t.FindLeftmostRightNode(t.right.left).value;
				t.value = nmi;
				t.right.delete(nmi);
			} else if (t.right.right != null) {
				t.value = t.right.value;
				t.right.delete(t.value);
			} else if(t.right.left == null && t.right.right == null) {
				t.value = t.right.value;
				t.right = null;
			}
		}
	}
	
	//O(n)
	// Para todos los metodos de impresion (pre order, post order y order) 
	// ya que en todos los casos debemos recorrer todos los nodos del arbol.
	public void printPreOrder() {
		if(this.value != null) {
			System.out.print(this.value+" ");
			if(this.left != null)			
				this.left.printPreOrder();
			else
				System.out.print("- ");
			
			if(this.right != null)			
				this.right.printPreOrder();
			else
				System.out.print("- ");
		}
	}
	
	public void printPostOrder() {
		if(this.value != null) {			
			if(this.left != null) {			
				this.left.printPostOrder();
			}
			if(this.right != null) {			
				this.right.printPostOrder();
			}
			System.out.println(this.value);
		}
	}
	
	public void printOrder() {
		if(this.value != null) {
			if(this.left != null) {			
				this.left.printOrder();
			}
			System.out.println(this.value);
			if(this.right != null) {			
				this.right.printOrder();
			}
		}
	}
	
	//O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.
	public int getHeight() {
		int l = 0;
		int r = 0;
		
		if(this.value != null) {			
			if(this.left != null) {
				l = this.left.getHeight() + 1;
			}
			
			if(this.right != null) {
				r = this.right.getHeight() + 1;
			}
		}
		
		if (this.value == null)
			return -1;
		else if(l > r) 
			return l;
		else
			return r;
	}
	
	//O(h)
	// Depende de la altura del arbol, ya que no tenemos certeza de que
	// el arbol se encuntre bien balanzeado.	
	public ArrayList<Integer> getLongestBranch() {
		ArrayList<Integer> branchL = new ArrayList<>();
		ArrayList<Integer> branchR = new ArrayList<>();
		
		if(this.value != null) {
			branchL.add(this.value);
			branchR.add(this.value);
			
			if(this.left != null) {
				branchL.addAll(this.left.getLongestBranch());
			}
			
			if(this.right != null) {
				branchR.addAll(this.right.getLongestBranch());
			}			
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
		Integer aux = this.value;
		if(this.right != null) {
			aux = this.right.getMaxElem();
		} 
		return aux;
	}
	
	//O(n)
	//Ya que recorrera todos los nodos hasta llegar a cada una de las hojas.
	public ArrayList<Integer> getFrontier() {
		ArrayList<Integer> aux = new ArrayList<>();
		if(this.value != null) {
			if (this.left==null && this.right==null) {
				aux.add(this.value);
			}
			else {
				if(this.left != null) {
					aux.addAll(this.left.getFrontier());
				}
				if (this.right != null) {
					aux.addAll(this.right.getFrontier());
				}
			}
		}
		return aux;
	}
	
	//O(n)
	//Por que en el peor de los casos tendrá que recorrer todo el arbol.
	public ArrayList<Integer> getElemAtLevel(int level) {
		return getElemAtLevel(level, 0);
	}
	
	private ArrayList<Integer> getElemAtLevel(int level, int levelAux) {
		ArrayList<Integer> aux = new ArrayList<>();
		if (this.value != null) {
			if (levelAux == level) {
				aux.add(this.value);
			}
			else { 
				if(this.left != null) {
					aux.addAll(this.left.getElemAtLevel(level, (levelAux+1)));
				}
				if(this.right != null) {
					aux.addAll(this.right.getElemAtLevel(level, (levelAux+1)));
				}
			}
		}
		return aux;
	} 
	
	//O(n)
	//Ya que recorrera todos los nodos hasta llegar a cada una de las hojas para realizar la resta.
	public ArrayList<Integer> getDifferenceBetweenLeaves() {
		return getDifferenceBetweenLeaves(new ArrayList<Integer>());
	}
	
	private ArrayList<Integer> getDifferenceBetweenLeaves(ArrayList<Integer> temp) {
		ArrayList<Integer> diff = new ArrayList<>();
		
		if (this.value != null) {
			if (this.left==null && this.right==null) {
				if(temp.isEmpty()) {
					temp.add(this.value);
				} else {
					diff.add(temp.get(0) - this.value);
					temp.remove(0);
					temp.add(this.value);
				}
			}
			else {
				if (this.right != null) {
					diff.addAll(this.right.getDifferenceBetweenLeaves(temp));
				}
				if(this.left != null) {
					diff.addAll(this.left.getDifferenceBetweenLeaves(temp));
				}
			}
		}	
		return diff;
	}
}
	