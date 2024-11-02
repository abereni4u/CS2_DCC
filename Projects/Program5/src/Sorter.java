import java.util.ArrayList;

public class Sorter {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Omega");
		myList.add("Beta");
		myList.add("Alpha");
		System.out.println("This is unsorted");
		System.out.println(myList);
		System.out.println("This is sorted");
		sort(myList);
		System.out.println(myList);
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> array) {
		quickSort(array, 0, array.size()-1);
	}
	
	private static <E extends Comparable<E>> void quickSort(ArrayList<E> array, int first, int last) {
		if (first < last) {
			// partition and get the pivot index
			int pivot = partition(array, first, last);
			// quicksort lower subarray
			quickSort(array, first, pivot-1);
			// quicksort upper subarray
			quickSort(array, pivot+1, last);
		}	
	}
	
	private static <E extends Comparable<E>> int partition(ArrayList<E> array, int first, int last) {
		// find midpoint index
		int mid_index = (first + last) / 2;
		E pivotValue = array.get(mid_index);
		swap(array, first, mid_index);
		int endOfLeft = first;
		for (int i = first + 1; i <= last; i++) {
			if(array.get(i).compareTo(pivotValue) < 0) {
				endOfLeft++;
				swap(array, endOfLeft, i);
			}
		}
		swap(array, first, endOfLeft);
		return endOfLeft;
		
	}
	
	private static <E extends Comparable<E>> void swap(ArrayList<E> array, int i, int j) {
		E temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
		
		
	}
		
}
