public class LinkedDS<T> implements SequenceInterface<T> {

    private Node[] array; //1-D array of linked lists
    private int size; //the number of items in the sequence
    private T[] alphabet; //the possible item values (e.g., the decimal digits)
    private T firstItem; //the first item
    private T lastItem; //the last item
  
    public LinkedDS(T[] alphabet){
		//TODO: implement this constructor
    }
    

    /** Add a new Object to the logical start of the sequence in O(1) time
	 * @param item the item to be added.
	 */
	public void push(T item){
		//TODO: implement this method
	}

    /** Delete the item at the logical start of the sequence in O(1) item
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T pop(){
        //TODO: implement this method
		return null;
    }



	/** Check if the sequence is empty in O(1) time
	 * @return true if the sequence is empty, and false otherwise
	 */
	public boolean isEmpty(){
		//TODO: implement this method
        return true;
    }

	/** Return the number of items in the sequence in O(1) time
	 * @return the number of items currently in the sequence
	 */
	public int size(){
		//TODO: implement this method
        return 0;
    }

	/**
	 * @return the the logically first item in the sequence in O(1) time
	 */
	public T first(){
		//TODO: implement this method
        return null;
    }

	/**
	 * @return the the logically last item in the sequence in O(1) time
	 */
	public T last(){
		//TODO: implement this method
        return null;
    }

    /** Return the number of times in the sequence that an item appears.
     * The running time is O(frequency of item in sequence).
	 * @param item an T item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item){
        //TODO: implement this method
		return 0;
    }


	/** Return the number of times in the sequence that an ordered pair of 
	 * items appear in the sequence. The running time is O(frequency of first 
	 * item).
	 * @param first the first item in the ordered pait
	 * @param second the second item in the ordered pair
	 * @return the number of occurences in the sequence of (first, second)
	 */
	public int getFrequencyOf(T first, T second){
        //TODO: implement this method
		return 0;
    }

	/**
	 * Returns an array of all unique successors of an item in the sequence.
	 * The running time is O(frequency of item in sequence * number of 
     * predecessors)
	 * @param item an item
	 * @return an array of all unique predecessors of item or null if 
     * item doesn't exist in the sequence.
	 */
	public T[] successors(T item){
        //TODO: implement this method
		return null;
    }

    private static class Node {
        private int item; //index in alphabet of item
        private Node next;
    
        private Node(int item){
            this.item = item;
            next = null;
        }
    }
}