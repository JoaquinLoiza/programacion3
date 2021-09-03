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
	
	public MySimpleLinkedList<T> getCommonOrderedList(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		if(l1.size()<l2.size()) {
			aux = commonList(l1,l2);
		}else {
			aux = commonList(l2,l1);
		}
		return aux.sortList(aux);
	}
	
	public MySimpleLinkedList<T> commonList(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
		
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		int pos = 0;
		
		for( int i = 0; i<l1.size() ; i++ ) {
			while( pos < l2.size() ){
				if ( (l1.get(i) == l2.get(pos)) && !containElement(aux, l1.get(i))){
					aux.insertFront(l1.get(i));
					pos = l2.size();
				} else {					
					pos ++;
				}
			}
			pos = 0;
		}
		return aux;
	}
	
	private boolean containElement(MySimpleLinkedList<T> list, T inf) {
		boolean aux = false;
		int pos = 0;
		Node<T> cursor = list.getFirst();
		
		while(pos < list.size()) {
			if(cursor.getInfo() == inf) {
				aux = true;
				pos = list.size();
			}
			cursor = cursor.getNext();
			pos ++;
		}
		return aux;
	}
	
	private MySimpleLinkedList<T> sortList(MySimpleLinkedList<T> l) {
		return null;
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
