package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	LLNode<E> temp;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();
		else {
			temp = new LLNode<E>(element);
			if (size == 0) {
				this.head.next = temp;
			}
			this.size++;
			temp.prev = tail.prev;
			temp.next = tail;
			tail.prev.next = temp;
			tail.prev = temp;
			return true;
		}
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		int ind = 0;
		// TODO: Implement this method.
		if (index < 0 || index>=size)
			throw new IndexOutOfBoundsException();
		temp = head.next;
		while (ind != index && temp != tail) {
			temp = temp.next;
			ind++;
		}
		if (ind != index)
			throw new IndexOutOfBoundsException();
		else
			return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		int ind = 0;
		if (element == null)
			throw new NullPointerException();
		else {
			LLNode<E> temp1 = new LLNode<E>(element);
			if (size == index) {
				boolean in = this.add(element);
			} else {
				temp = head.next;
				while (ind != index && temp != tail) {
					ind++;
					temp = temp.next;
				}
				if (ind == index) {
					temp1.next = temp;
					temp1.prev = temp.prev;
					temp.prev.next = temp1;
					temp.prev = temp1;
				} else {
					throw new IndexOutOfBoundsException();
				}
				size++;
			}
		}
		// TODO: Implement this method
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		int ind = 0;
		E t;
		if (index < 0 || size <= index)
			throw new IndexOutOfBoundsException();
		else if (size == 1 && index == ind) {
			t = head.next.data;
			head.next = tail;
			tail.prev = head;
			size--;
		} else {
			temp = head.next;
			while (ind != index && temp != tail) {
				ind++;
				temp = temp.next;
			}
			if (ind != index)
				throw new IndexOutOfBoundsException();
			else {
				t = temp.data;
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp = temp.next;
			}
			size--;
		}
		return t;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		E t;
		int ind = 0;
		if (element == null)
			throw new NullPointerException();
		else if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		else {
			temp = head.next;
			while (ind != index && temp != tail) {
				ind++;
				temp = temp.next;
			}
			if (ind == index) {
				t = temp.data;
				temp.data = element;
			} else
				throw new IndexOutOfBoundsException();
		}
		// TODO: Implement this method
		return t;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;
	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}
