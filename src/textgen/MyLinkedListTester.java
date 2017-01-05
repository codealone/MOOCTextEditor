/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet() throws IndexOutOfBoundsException
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(-1);
			fail("Check out of bounds");
			throw new IndexOutOfBoundsException();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("For empty list index out of range"+e.getMessage());
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
			throw new IndexOutOfBoundsException();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("For short list negative index"+e.getMessage());
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
			throw new IndexOutOfBoundsException();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("For short list index out of range"+e.getMessage());
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
			throw new IndexOutOfBoundsException();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("For long list negative index"+e.getMessage());
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
			throw new IndexOutOfBoundsException();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("For long list index out of range"+e.getMessage());
		}
	}
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove() throws IndexOutOfBoundsException
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		try{
			a= list1.remove(-1);
			throw new IndexOutOfBoundsException();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Index negative "+e.getMessage());
		}
		assertEquals("Remove: check size is correct ", 2, list1.size());
		try{
			a= list1.remove(2);
			throw new IndexOutOfBoundsException();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Index out of bounds "+e.getMessage());
		}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd() throws NullPointerException,IndexOutOfBoundsException
	{
        // TODO: implement this test
		boolean tr = emptyList.add(78);
		assertEquals("Check tr", true, tr);
		//test empty list, get should throw an exception
				try {
					emptyList.get(1);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For empty list index out of range "+e.getMessage());
				}
				try {
					tr= shortList.add(null);
					fail("Check out of bounds");
					throw new NullPointerException();
				}
				catch (NullPointerException e) {
					System.out.println("For short list data is null "+e.getMessage());
				}
				// test short list, first contents, then out of bounds
				assertEquals("Check first", "A", shortList.get(0));
				assertEquals("Check second", "B", shortList.get(1));
				
				try {
					shortList.get(-1);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For short list negative index"+e.getMessage());
				}
				tr=shortList.add("C");
				assertEquals("Check result", true, tr);
				try {
					shortList.get(3);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For short list index out of range"+e.getMessage());
				}
				tr=longerList.add(190);
				assertEquals("Check size", 11, longerList.size());
				// test longer list contents
				for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
					assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
				}
				
				// test off the end of the longer array
				try {
					longerList.get(-1);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For long list negative index"+e.getMessage());
				}
				try {
					longerList.get(longerList.size());
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For long list index out of range"+e.getMessage());
				}
				try {
					tr = longerList.add(null);
					fail("Check out of bounds");
					throw new NullPointerException();
				}
				catch (NullPointerException e) {
					System.out.println("For long list index out of range"+e.getMessage());
				}
	}
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		list1.add(1000);
		assertEquals("Remove: check size is correct ", 4, list1.size());
		assertEquals("Remove: check last element is correct ", (Integer)1000, list1.get(3));
	}
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex() throws NullPointerException,IndexOutOfBoundsException
	{
        // TODO: implement this test
		emptyList.add(0,78);
		assertEquals("Check element", (Integer)78, emptyList.get(0));
		//test empty list, get should throw an exception
				try {
					emptyList.get(3);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For empty list index out of range "+e.getMessage());
				}
				try {
					emptyList.add(0,null);
					fail("Check out of bounds");
					throw new NullPointerException();
				}
				catch (NullPointerException e) {
					System.out.println("For empty list data is null "+e.getMessage());
				}
				shortList.add(1,"D");
				// test short list, first contents, then out of bounds
				assertEquals("Check first", "A", shortList.get(0));
				assertEquals("Check second", "D", shortList.get(1));
				
				try {
					shortList.get(-1);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For short list negative index"+e.getMessage());
				}
				try {
					shortList.add(0,null);
					fail("Check out of bounds");
					throw new NullPointerException();
				}
				catch (NullPointerException e) {
					System.out.println("For short list data is null "+e.getMessage());
				}
				try {
					shortList.get(4);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For short list index out of range"+e.getMessage());
				}
				longerList.add(10,200);
				assertEquals("Check element", (Integer)200, longerList.get(10));
				// test longer list contents
				for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
					assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
				}
				
				// test off the end of the longer array
				try {
					longerList.get(-1);
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For long list negative index"+e.getMessage());
				}
				try {
					longerList.add(1,null);
					fail("Check out of bounds");
					throw new NullPointerException();
				}
				catch (NullPointerException e) {
					System.out.println("For long list negative index"+e.getMessage());
				}
				try {
					longerList.get(longerList.size());
					fail("Check out of bounds");
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("For long list index out of range"+e.getMessage());
				}
	}
	/** Test setting an element in the list */
	@Test
	public void testSet() throws NullPointerException,IndexOutOfBoundsException
	{
	    // TODO: implement this test
		try{
			list1.set(0, null);
			throw new NullPointerException();
		}catch(NullPointerException e){
			System.out.println("Set element was null "+e.getMessage());
		}
		assertEquals("Remove: check size is correct ", 3, list1.size());
		assertEquals("Remove: check last element is correct ", (Integer)42, list1.get(2));
		assertEquals("Remove: check 0 element is correct ", (Integer)65, list1.get(0));
		try{
			list1.set(5, 7);
			throw new IndexOutOfBoundsException();
		}catch(IndexOutOfBoundsException e){
			System.out.println("For list1 index out of Bounds "+e.getMessage());
		}
		try{
			list1.set(-1, 7);
			throw new IndexOutOfBoundsException();
		}catch(IndexOutOfBoundsException e){
			System.out.println("For list1 index out of Bounds "+e.getMessage());
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
