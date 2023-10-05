import java.util.Arrays;

/** Driver program for Assignment 2
 * @author Sherif Khattab (Adapted  from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 1 code)
 *
 * This program must work as is with your LinkedDS<T> class.
 * Look carefully at all of the method calls so that
 *  you create your LinkedDS<T> methods correctly.  For example,
 *  note the constructor calls push() and pop() method calls.
 *  The output should be identical to the sample output.
 */
public class A2Test
{
	private static final int SIZE = 5;
	private static final int SIZE2 = 10;
	private static final int LARGE_SIZE = 100000;
	private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static final Character[] LETTERS = {'.', ';', '!', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public static void main(String [] args)
	{
		LinkedDS<Integer> s1 = new LinkedDS<>(DIGITS);

		// Testing push
		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			s1.push(newItem);
			System.out.println(newItem + " pushed to sequence");
		}

		System.out.println("Sequence size is: " + s1.size());

		// Testing pop
		while (!(s1.isEmpty()))
		{
			Integer oldItem = s1.pop();
			System.out.println(oldItem + " popped from sequence");
		}
		try {
			Integer noItem = s1.pop();
		} catch (EmptySequenceException e) {
			System.out.println("Nothing in the sequence");
		}

		// Testing with a different alphabet
		String[] alphabet = new String[SIZE2];
		for(int i=0; i<SIZE2; i++){
			alphabet[i] = new String("Item " + i);
		}
		SequenceInterface<String> theS2 = new LinkedDS<>(alphabet);

		int count = 0;
		String theItem = new String("Item " + count);
		System.out.println("Adding " + theItem);
		theS2.push(theItem);
		for (int i = 0; i < 8; i++)
		{
			count++;
			theItem = new String("Item " + count);
			System.out.println("Adding " + theItem);
			theS2.push(theItem);
			theItem = theS2.pop();
			System.out.println("Removing " + theItem);
		}
		int sz = theS2.size();
		System.out.println(sz + " item(s) in the sequence.");


		//Testing getFrequencyOf, predecessors
		SequenceInterface<Character> sentence = new LinkedDS<>(LETTERS);
		StringBuilder s = new StringBuilder("data structures are fun; algorithms are fun too!");
		for(Character c : s.reverse().toString().toCharArray()){
			sentence.push(c);
		}

		System.out.println("The letter \'d\' appeared " +
			sentence.getFrequencyOf('d') + " time(s)");
		System.out.println("The character '!' appeared " +
			sentence.getFrequencyOf('!') + " time(s)");
		System.out.println("The character 'j' appeared " +
			sentence.getFrequencyOf('j') + " time(s)");


		System.out.println("The letter \"r\" appeared " +
			sentence.getFrequencyOf('r') + " time(s)");
			System.out.println("The srting \"re\" appeared " +
					sentence.getFrequencyOf('r', 'e') + " time(s)");
		System.out.println("The letters following 'r' are " + 
						Arrays.toString(sentence.successors('r')));
		System.out.println("The letters following 'j' are " + 
						Arrays.toString(sentence.successors('j')));


		//Testing with a large sequence
		SequenceInterface<Integer> large = new LinkedDS<>(DIGITS);
		for(int i=0; i<LARGE_SIZE; i++){
			large.push(5);
			large.push(4);
			large.push(4);
			large.push(0);
		}
		large.pop(); //popping 0
		large.pop(); //popping 4
		large.pop(); //popping 4
		large.pop(); //popping 5
		large.push(1); //pushing 1
		large.push(0); //pushing 0
		large.push(4); //pushing 4
		large.push(0); //pushing 0
		large.push(7); //pushing 7
		large.push(0); //pushing 0
		large.push(0); //pushing 0
		large.push(0); //pushing 0

		System.out.println("First item is: " + large.first());
		System.out.println("Last item is: " + large.last());

		System.out.println("The size of the sequence is " + large.size());
		System.out.println("The frequency of(4, 4) in the sequence is " + 
			large.getFrequencyOf(4, 4));
		System.out.println("The successors of 4 in the sequence are " + 
			Arrays.toString(large.successors(4)));
		System.out.print("The first 12 items in the sequence are: ");
		for(int i=0; i<12; i++){
			System.out.print(large.pop());
		}
		System.out.println();
	}
}