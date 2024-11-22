import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LinkedSet<T> implements Set<T>{
	
	private T first;
	private int size;
	
	
	private class Node{
		T next;
		T value;
		
		/**
		 * Constructor for node that takes a value and returns a single node
		 * with that a value.
		 * @param value
		 */
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
		
		/**
		 * Constructor for node that accepts a value and the node right after it.
		 * @param value
		 * @param next
		 */
		public Node(T value, T next) {
			this.value = value;
			this.next = next;
		}
	}
	/**
	 * No-arg constructor for LinkedSet.
	 */
	public LinkedSet() {
		this.first = null;
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.first == null;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
