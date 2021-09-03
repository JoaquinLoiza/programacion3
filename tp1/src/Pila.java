
public class Pila<T> extends MySimpleLinkedList<T> {

	public Pila(){
		super();
	}
	
	public void push(T o) {
		super.insertFront(o);
	}
	
	public T pop() {
		return super.extractFront();
	}
	
	public T top() {
		return super.getFirst().getInfo();
	}
	
	public MySimpleLinkedList<T> reverse() {
		MySimpleLinkedList<T> temp = new MySimpleLinkedList<T>();
		Node<T> cursor = super.getFirst();
		int pos = 0;
		while(pos < super.size()) {
			temp.insertFront(cursor.getInfo());
			cursor = cursor.getNext();
			pos++;
		}
		return temp;
	}
}
