import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/**
 * CPS142 - Fall 2024
 * 11/23/24 
 * Professor: Adam Divelbiss
 * @author Abereni Opuiyo
 * Assignment: Program07
 * Purpose:  A generic Java class called “LinkedSet” that implements some of the
basic methods of the Java Collections Framework “Set” interface. 
 */
public class LinkedSet<T> implements Set<T>{
	
	private class Node{
		T value;
		Node next;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
		
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
		
	}
	
	private Node first;
	private int count;

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	@Override
	public void clear() {
		this.first = null;
		this.count = 0;
	}
	
	@Override
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		StringBuilder myString = new StringBuilder();
		
		if(this.isEmpty() == true)
			return "This linked set is empty!";
		else {
			Node ref = this.first;
			myString.append("[");
			// Loop until you get to the last node so we don't add a comma to it.
			while(ref.next != null) {
				myString.append(ref.value + ", ");
				ref = ref.next;
			}
			myString.append(ref.value + "]");
		}
		return myString.toString();
	}

	@Override
	public boolean add(T e) {
		// Check if the linked set is empty
		if(this.isEmpty() == true) {
			this.first = new Node(e);
			this.count++;
			return true;
		}
		// It's not empty, so check if the linked set contains the value to be added already.
		else if(this.contains(e) == true){
			return false;	
		}
		else {
			Node ref = this.first;
			while(ref.next != null)
				ref = ref.next;	
			ref.next = new Node(e);
			this.count++;
			return true;
		}
		
	}
	
	@Override
	public boolean contains(Object o) {
		// linked set is empty so it contains nothing
		if(this.isEmpty() == true) {
			return false;
		}
		else {
			Node ref = this.first;
			// traverse through the linked set until we find the value or reach the end
			while(ref != null && !(ref.value.equals(o))) {
				ref = ref.next;
			}
			return (ref != null);
		}
	}

	@Override
	public boolean remove(Object o) {	
		// check if the linked set is empty
		if(this.isEmpty() == true) {
			return false;
		}
		// check if the linked set actually contains the value being removed
		else if(this.contains(o) == false) {
			return false;	
		}
		// check if the first value in the list is equal to the value we want removed
		else if(this.first.value.equals(o)) {
			this.first = this.first.next;
			this.count--;
			return true;
		}
		// traverse through the list until you get right before the value to be removed.
		else {
			Node ref = this.first;
			while (!(ref.next.value.equals(o)))
				ref = ref.next;
			ref.next = ref.next.next;
			this.count--;
			return true;
		}
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
