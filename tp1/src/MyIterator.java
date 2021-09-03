import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

	private Node<T> cursor;
	
	public MyIterator(Node<T> firstDeLaLista) {
		this.cursor = firstDeLaLista;
	}

	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}

}
