import java.util.ArrayList;
import java.util.Arrays;

public class LinkedDS<T> implements SequenceInterface<T>
{

    private Node[] array; // 1-D array of linked lists
    private int size; // the number of items in the sequence
    private T[] alphabet; // the possible item values (e.g., the decimal digits)
    private T firstItem; // the first item
    private T lastItem; // the last item

    public LinkedDS(T[] alphabet)
    {
        // set variables
        this.alphabet = alphabet;
        this.size = 0;
        this.firstItem = null;
        this.lastItem = null;

        this.array = new Node[alphabet.length];
        for (int i = 0; i < alphabet.length; i++)
        {
            array[i] = null;
        }
    }

    /**
     * Add a new Object to the logical start of the sequence in O(1) time
     * 
     * @param item
     *            the item to be added.
     */
    public void push(T item)
    {
        // set the index to the first items index in alphabet
        int index = indexInAlphabet(firstItem);
        // make a new node at the index of the first item
        Node newNode = new Node(index);

        // if size is zero just set first and last item ot the item
        if (size == 0)
        {
            firstItem = lastItem = item;
        } else
        {
            // if the array is null for the index of item then jsut set to null
            if (array[indexInAlphabet(item)] == null)
            {
                array[indexInAlphabet(item)] = newNode;
            } else
            {
                // if not then set the next item to the new node
                newNode.next = array[indexInAlphabet(item)];
                array[indexInAlphabet(item)] = newNode;
            }
        }
        // change first item to item and add the size
        firstItem = item;
        size++;
    }

    /**
     * Delete the item at the logical start of the sequence in O(1) item
     * 
     * @return the deleted item
     * @throws EmptySequenceException
     *             if the sequence is empty
     */
    public T pop()
    {

        //
        // check to see if the sequence is empty then throw exception
        if (isEmpty())
        {
            throw new EmptySequenceException("Sequence is empty");
        }

        // set the index to the first item in index
        int index = indexInAlphabet(firstItem);
        T deleted = firstItem;

        // creating new node at the index in the array
        Node deletedNode = array[index];

        if (deletedNode == null)
        {
            array[index] = null;
            firstItem = null;
            lastItem = null;
        } else
        {
            firstItem = alphabet[deletedNode.item];
            deletedNode = deletedNode.next;
            array[index] = deletedNode;

        }

        size--;

        return deleted;

    }

    /**
     * Check if the sequence is empty in O(1) time
     * 
     * @return true if the sequence is empty, and false otherwise
     */
    public boolean isEmpty()
    {
        // if size is zero then it is empty so return
        if (this.size == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Return the number of items in the sequence in O(1) time
     * 
     * @return the number of items currently in the sequence
     */
    public int size()
    {
        // just return the number of items in sequense
        return this.size;
    }

    /**
     * @return the the logically first item in the sequence in O(1) time
     */
    public T first()
    {
        // return first item in sequence
        return this.firstItem;
    }

    /**
     * @return the the logically last item in the sequence in O(1) time
     */
    public T last()
    {
        // return last item in sequece
        return this.lastItem;
    }

    /**
     * Return the number of times in the sequence that an item appears. The
     * running time is O(frequency of item in sequence).
     * 
     * @param item
     *            an T item
     * @return the number of occurences in the sequence of item
     */
    public int getFrequencyOf(T item)
    {
        // nake coutner variable
        int counter = 0;

        // if the first item is euqal to the item you increase coutner because
        // it will not be added if it doenst follow anyone
        if (lastItem.equals(item))
        {
            counter++;
        }
        // make a current node in the index in the array
        Node current = array[indexInAlphabet(item)];

        // set while loop and for every node in the index counter++ while it is
        // not null
        while (current != null)
        {

            counter++;
            current = current.next;

        }
        // return total ammount
        return counter;
    }

    /**
     * Return the number of times in the sequence that an ordered pair of items
     * appear in the sequence. The running time is O(frequency of first item).
     * 
     * @param first
     *            the first item in the ordered pait
     * @param second
     *            the second item in the ordered pair
     * @return the number of occurences in the sequence of (first, second)
     */

    public int getFrequencyOf(T first, T second)
    {
        // make a counter and make a target index for the second item
        int counter = 0;
        int targetIndex = indexInAlphabet(second);

        // make a current node in the index of the first item in the array
        Node current = array[indexInAlphabet(first)];

        // go through the nodes in the index of the first item
        while (current != null)
        {
            // if the current item is equal to the second item then increase the
            // coutner
            if (current.item == targetIndex)
            {
                counter++;
            }
            current = current.next;
        }

        return counter;
    }

    /**
     * Returns an array of all unique successors of an item in the sequence. The
     * running time is O(frequency of item in sequence * number of predecessors)
     * 
     * @param item
     *            an item
     * @return an array of all unique predecessors of item or null if item
     *         doesn't exist in the sequence. //
     */
    @SuppressWarnings("unchecked")
    public T[] successors(T item)
    {
        if (getFrequencyOf(item) == 0)
        {
            return null;
        } else
        {

            ArrayList<T> temp = new ArrayList<T>();

            Node current = array[indexInAlphabet(item)];

            while (current != null)
            {
                int index = current.item;
                if (!temp.contains(alphabet[index]))
                {
                    temp.add(alphabet[index]);
                }
                current = current.next;
            }

            T[] temp2 = (T[]) new Object[temp.size()];

            temp2 = (T[]) temp.toArray();

            return temp2;
        }

    }

    public int indexInAlphabet(T item)
    {
        // itterate through and try to see where the item in the alphabet is and
        // see if it exists in teh alphabet
        for (int i = 0; i < alphabet.length; i++)
        {
            if (item == null)
            {
                if (alphabet[i] == null)
                {
                    return i;
                }
                // if it exists in the alphabet then return the number
            } else if (item.equals(alphabet[i]))
            {
                return i;
            }
        }
        return -1;
    }

    private static class Node
    {
        private int item; // index in alphabet of item
        private Node next;

        private Node(int item)
        {
            this.item = item;
            next = null;
        }
    }

    public void display()
    {
        System.out.println(firstItem + " " + lastItem + " " + size);
        for (int i = 0; i < alphabet.length; i++)
        {
            Node current = array[i];
            System.out.print(alphabet[i] + ": ");
            while (current != null)
            {
                System.out.print(alphabet[current.item] + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    private static final int SIZE = 5;
    private static final int SIZE2 = 10;
    private static final int LARGE_SIZE = 100000;
    private static final Integer[] DIGITS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static final Character[] LETTERS = { '.', ';', '!', ' ', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void main(String[] arg)
    {
        LinkedDS<Integer> s1 = new LinkedDS<>(DIGITS);

        s1.push(4);
        s1.push(7);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(3);
        s1.push(4);
        s1.push(3);
        s1.push(1);

        s1.display();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(s1.getFrequencyOf(4));
        System.out.println(s1.getFrequencyOf(4, 3));
        System.out.println("Hello");
        System.out.println(Arrays.toString(s1.successors(3)));

    }

}