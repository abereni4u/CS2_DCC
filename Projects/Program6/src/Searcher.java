import java.util.ArrayList;
/**
 * Searcher contains static methods to perform binary search operations on sorted ArrayLists.
 */
public class Searcher {
	
	/**
     * Performs a binary search on a sorted ArrayList to find the specified value.
     * This is the public interface for the binary search algorithm.
     *
     * @param <E> the type of elements in the ArrayList, must implement Comparable
     * @param array the sorted ArrayList to search in
     * @param value the value to search for
     * @return the index of the value if found, -1 if not found
     */
	public static <E extends Comparable<E>> int search(ArrayList<E> array, E value) {
		return binarySearch(array, 0, array.size()-1, value);	
	}
	
	/**
     * Recursive helper method that implements the binary search algorithm.
     * Searches for a value in a sorted ArrayList within the specified range [start, end].
     *
     * @param <E> the type of elements in the ArrayList, must implement Comparable
     * @param array the sorted ArrayList to search in
     * @param start the starting index of the search range (inclusive)
     * @param end the ending index of the search range (inclusive)
     * @param value the value to search for
     * @return the index of the value if found, -1 if not found
     */
	private static <E extends Comparable<E>> int binarySearch(ArrayList<E> array, int start, int end, E value) {
		int mid_index = start + (end - start)/2;
		
		if(start > end) {
			return -1;
		}
		else {	
			if(array.get(mid_index).compareTo(value) == 0) {
				return mid_index;
			}
			else if(array.get(mid_index).compareTo(value) < 0) {
				return binarySearch(array, mid_index + 1, end, value);
			}
			else {
				return binarySearch(array, start, mid_index - 1, value);
			}
		}
	}
}
