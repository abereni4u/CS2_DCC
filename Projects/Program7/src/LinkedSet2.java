import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LinkedSet2<T> implements Set<T>{
	
	private class Node{
		T value;
		Node next;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
		
		public Node (T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node first;
	private Node last;
	
	private int count;
	
	public LinkedSet2() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

	@Override
	public boolean contains(Object o) {
		if(this.isEmpty() == true)
			return false;
		
		Node copy = this.first;
		
		while(copy != null && !(copy.value.equals(o))) {
			copy = copy.next;
		}
		
		return copy != null;
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
		if(this.isEmpty() == true) {
			Node valueNode = new Node(e, this.first);
			this.first = valueNode;
			this.last = this.first;
			this.count++;
			return true;
		}
		else {
			if(this.contains(e) == true)
				return false;
			else {
				this.last.next = new Node(e);
				this.last = this.last.next;
				this.count++;
				return true;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder nodeString = new StringBuilder();
		if(this.isEmpty() == true) {
			return "This linked set is empty";
		}
		else {
			Node copy = this.first;
			nodeString.append("[");
			while(copy.next != null) {
				nodeString.append(copy.value + ", ");
				copy = copy.next;
			}
			nodeString.append(copy.value + "]");
			return nodeString.toString();
			
		}
	}
	
	@Override
	public boolean remove(Object o) {
		if(this.isEmpty() == true) {
			return false;
		}
		else {
			Node prev = this.first;
			while ( (prev.next != null) && !prev.next.value.equals(o) ) {
				prev = prev.next;
			}
			
			// did we get to the end?
			if (prev.next == null) {
				return false;
			}
			
			// At this point we did find the node for the element
			// remove the node at index
			prev.next = prev.next.next;
			
			// Update the last node if we just removed the last node
			if (prev.next == null) {
				this.last = prev;
			}	
			this.count--;
			return true;
			
			}
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

	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}
	
}
