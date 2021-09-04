
public class ListCombiner<T> {
	
	private MySimpleLinkedList<T> list1;
	private MySimpleLinkedList<T> list2;
	
	public ListCombiner(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
		this.list1 = list1;
		this.list2 = list2;
	}

	public MySimpleLinkedList<T> getCommonOrderedList() {
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		if(list1.size()<list2.size()) {
			aux = commonList(list1,list2);
		}else {
			aux = commonList(list2,list1);
		}
		
		return this.sortList(aux);
	}
	
	private MySimpleLinkedList<T> commonList(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
		
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

	private MySimpleLinkedList<T> sortList(MySimpleLinkedList<T> l) {
		/*
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		int pos = 0;
		T info = l.get(0);
		
		while(pos < l.size()) {
			if(l.get(pos) > info) {
				info = l.get(pos);
			}
		}
		
		 */
		return l;
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
	
	public MySimpleLinkedList<T> getElementOnlyFirstList() {
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		int pos = 0;
		
		while(pos < this.list1.size()) {
			if( !containElement(list2, this.list1.get(pos)) ) {
				aux.insertFront(list1.get(pos));
			}
			pos ++;
		}
		
		return aux;
	}
}
