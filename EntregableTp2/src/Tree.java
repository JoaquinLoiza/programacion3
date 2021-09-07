
public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
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
		
		boolean aux = false;
		
		if (t.value != null) {
			if(t.value == e) {
				aux = true;
			} 
			else if (e < t.value && t.left != null) {
				aux = hasElement(e, t.left); 
			} 
			else if (e > t.value && t.right != null){
				aux = hasElement(e, t.right);
			}
		}
		return aux;
	}
	
	public boolean delete(Integer i) {
		return delete(i, this);
	}
	
	private boolean delete(Integer i, Tree t) {
		
		boolean aux = false;
		
		if(t.value == i) {
			if(t.left == null && t.right == null) {
				System.out.println("No tengo hijos");
				t.value = null;
			}
			else if(t.left != null && t.right != null) {
				System.out.println("Tengo dos hijos");
			} 
			else {
				if(t.left != null) {
					System.out.println("Tengo un hijo izq");
				} 
				else
					System.out.println("Tengo un hijo der");
			}
			aux = true;
		} 
		else if (i < t.value && t.left != null) {
			aux = delete(i, t.left); 
		} 
		else if (i > t.value && t.right != null){
			aux = delete(i, t.right);
		}	
		
		return aux;
	}
}
