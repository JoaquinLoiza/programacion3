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
	
	public Integer getValue() {
		int v = this.value;
		return v;
	}
	
	public boolean isEmpty() {
		return (this.value == null);
	}
	
	public Integer getRoot() {
		if (this.value != null) {			
			return this.value;
		}else 
			return -1;
	}
	
	public boolean hasElement(Integer e) {
		return hasElement(e, this);
	}
	
	private boolean hasElement(Integer e, Tree t) {
		if (getNode(e,t) != null) {
			return true;
		} else
			return false;
	}
	
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
		System.out.println("arbol con dos hijos "+ t.value+"\n");    // value = 6
		System.out.println("nodo derecho mas a la izquierda "+ aux.value +"\n"); // value = 9
		
		// 6 se vuelve 9
		t.value = aux.value;
			//  
		delete(aux.value ,aux);
	}
	
	private Tree FindLeftmostRightNode(Tree t) {
		if(t.left != null) {
			return FindLeftmostRightNode(t.left);
		} else
			return t;
	}
	
	public void printPreOrder() {
		printPreOrder(this);
	}
	
	private void printPreOrder(Tree t) {
		if(t == null) {
			return;
		}
		
		System.out.println(t.value);
		printPreOrder(t.left);
		printPreOrder(t.right);
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
}
