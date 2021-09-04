import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
	
	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		T infTemp = first.getInfo();
		first.setNext(first.getNext());
		size--;
		return infTemp;
	}
	
	public int indexOf(T info) {
		int pos = 0;
		Node<T> cursor = this.first;
		while (pos < this.size) {
			if(cursor.getInfo() == info) {
				return pos;
			} 
			cursor = cursor.getNext();
			pos ++;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return (this.first == null);
	}
	
	public T get(int index) {
		int pos = 0;
		Node<T> cursor = this.first;
		
		while(pos < this.size) {
			if(pos == index) {
				pos = size;
				return cursor.getInfo();
			}else {
				pos ++;
				cursor = cursor.getNext();
			}
		}
		return null;
	}
	
	
	public Node<T> getFirst() {
		Node<T> temp = new Node<T>();
		temp = this.first;
		return temp;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
	
}
