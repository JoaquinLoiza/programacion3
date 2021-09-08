
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
		Tree arbol = getNode(i, t);
				
		if (arbol != null) {
			if(arbol.left == null && arbol.right == null) {
				if(arbol.father.value > arbol.value) {
					arbol.father.left = null;
				} else {
					arbol.father.right = null;
				}
				arbol.value = null;
			}
			else if(arbol.left != null && arbol.right != null) {
				deleteWithChilds(arbol);
			} 
			else {
				if(arbol.left != null) {
					deleteWithLeftChild(arbol);
				} 
				else
					deleteWithRightChild(arbol);
			}
			aux = true;
		}
		return aux;
	}
	
	private void deleteWithLeftChild(Tree a) {
		if(a.father != null) {
			if (a.value > a.father.value) {
				a.father.right = a.left;
			} else
				a.father.left = a.left;
		} else {
			a = a.left;
		}
	}
	
	private void deleteWithRightChild(Tree a) {
		if(a.father != null) {
			if (a.value > a.father.value) {
				a.father.right = a.right;
			} else
				a.father.left = a.right;
		} else {
			a = a.right;
		}
	}
	
	private void deleteWithChilds(Tree a) {
		Tree aux = findNML(a.right);
		a.value = aux.value;
		delete(a.value ,aux);
	}
	
	private Tree findNML(Tree a) {
		if(a.left != null) {
			return findNML(a.left);
		} else
			return a;
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
		int x = 0;
		if(t.right != null || t.left != null) {
			if(t.left != null) {
				x = getHeight(t.left);
			}
			else {
				x = getHeight(t.right);
			}
			x++;
		}
		return x;
	}
}
