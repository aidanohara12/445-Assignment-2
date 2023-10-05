/**  SequenceInterface<T> interface for CS 0445 Assignment 2
 * @author Sherif Khattab
 * @param <T> The data type of the items stored in the sequence.
 *
 * Carefully read the specifications for each of the operations and
 * implement them correctly in your LinkedDS class.
 *
 * The overall logic of the SequenceInterface<T> is the following:
 * Data items are organized in a sequence. The items come from a fixed set of
 * possible items. That set is called the alphabet. For example, a sequence
 * of digits has the set of decimal digits as its alphabet. A sequence of 
 * letters has the set of letters as its alphabet. The items in the sequence 
 * have a logical order. However, there is no requirement for the physical 
 * storage of the actual data.  Your only requirement for the LinkedDS<T> class 
 * is that all of the methods work as specified and that your class has a 
 * one-dimensional array of linked lists as its primary data structure. More 
 * details are in the README file of the assignment.
 *
 * Except for the array of linked lists, you MAY NOT use ArrayList, Vector or 
 * any predefined collection class for your LinkedDS<T> class. You MAY NOT
 * declare one-dimensional arrays except for the alphabet and for the return 
 * value of any of the methods that return an array
 */

public interface SequenceInterface<T>
{
	/** Add a new Object to the logical start of the sequence in O(1) time
	 * @param item the item to be added.
	 */
	public void push(T item);

	/** Delete the item at the logical start of the sequence in O(1) item
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T pop();

	/** Check if the sequence is empty in O(1) time
	 * @return true if the sequence is empty, and false otherwise
	 */
	public boolean isEmpty();

	/** Return the number of items in the sequence in O(1) time
	 * @return the number of items currently in the sequence
	 */
	public int size();

	/**
	 * @return the the logically first item in the sequence in O(1) time
	 */
	public T first();

	/**
	 * @return the the logically last item in the sequence in O(1) time
	 */
	public T last();

    /** Return the number of times in the sequence that an item appears.
     * The running time is O(frequency of item in sequence).
	 * @param item an T item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item);

	/** Return the number of times in the sequence that an ordered pair of 
	 * items appear in the sequence. The running time is O(frequency of first 
	 * item).
	 * @param first the first item in the ordered pait
	 * @param second the second item in the ordered pair
	 * @return the number of occurences in the sequence of (first, second)
	 */
	public int getFrequencyOf(T first, T second);

	/**
	 * Returns an array of all unique successors of an item in the sequence.
	 * The running time is O(frequency of item in sequence * number of 
     * unique successors)
	 * @param item an item
	 * @return an array of all unique successors of item or null if 
     * item doesn't exist in the sequence.
	 */
	public T[] successors(T item);
}