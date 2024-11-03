import java.util.ArrayList;

/**
 * Sorter implements the QuickSort algorithm to sort ArrayLists in ascending order.
 */

public class Sorter {

	/**
     * Sorts an ArrayList using the QuickSort algorithm.
     *
     * @param <E> the type of elements in the ArrayList, must implement Comparable
     * @param array the ArrayList to be sorted
     */
	public static <E extends Comparable<E>> void sort(ArrayList<E> array) {
		quickSort(array, 0, array.size()-1);
	}
	
	/**
     * Recursive helper method that implements the QuickSort algorithm.
     * Sorts a portion of the ArrayList specified by the first and last indices.
     *
     * @param <E> the type of elements in the ArrayList, must implement Comparable
     * @param array the ArrayList to be sorted
     * @param first the starting index of the portion to sort (inclusive)
     * @param last the ending index of the portion to sort (inclusive)
     */
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
	
	/**
     * Partitions a portion of the ArrayList around a pivot value.
     * Uses the middle element as the pivot and rearranges elements such that
     * all elements less than the pivot are on the left side and all elements
     * greater than the pivot are on the right side.
     *
     * @param <E> the type of elements in the ArrayList, must implement Comparable
     * @param array the ArrayList being partitioned
     * @param first the starting index of the portion to partition (inclusive)
     * @param last the ending index of the portion to partition (inclusive)
     * @return the final position of the pivot element
     */
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

	 /**
     * Swaps two elements in an ArrayList at the specified indices.
     *
     * @param <E> the type of elements in the ArrayList
     * @param array the ArrayList containing the elements to swap
     * @param i the index of the first element
     * @param j the index of the second element
     */
	private static <E extends Comparable<E>> void swap(ArrayList<E> array, int i, int j) {
		E temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);	
	}
		
}
