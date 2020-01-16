import org.omg.CORBA.Current;

/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * 
 * @author Greg Gagne - February 2017
 *
 */
public class LinkedList implements List {
	// reference to the head of the linked list
	private Node head;

	// number of elements in the list
	private int numberOfElements;

	public LinkedList() {
		head = null;
	}

	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private Object data;
		private Node next;

		private Node(Object data) {
			this(data,null);
		}

		private Node (Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	@Override
	public void add(Object item) {

		// adds (appends) an item to the rear of the list

		Node newNode = new Node(item);
		Node current = head;

		if (isEmpty()) {
			// special case - first element being added to the list
			head = newNode;
		}
		else {
			while (current.next != null) {
				current = current.next;
			}

			// current now references the last item in the list
			current.next = newNode;
		}

		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(Object item, int index) {//I can't figure this last part out 
		// TO DO
		Node current = head;
		if(index < 0)
		{
			return false;
		}else if(index == 0)
		{		Node addition = new Node(item);
				addition.next = head;
				head = addition;
				numberOfElements++;
		}else
		{
			for(int i = 0; i < (index-1); i++)
			{
				current = current.next;
			}
			Node addition = new Node(item);
			addition.next = current.next;
			current.next = addition;
			numberOfElements++;
		}
		return false;
	}

	@Override
	public boolean contains(Object item) {
		Node current = head;
		boolean found = false;

		while (current != null && !found) {
			if (current.data.equals(item)) {
				found = true;
			}

			current = current.next;
		}

		return found;

	}

	@Override
	public Object get(int index) {
		// TO DO
		Node current = head;
		if(index >= numberOfElements)
		{
			return null;
		}else
		{
		for(int i = 0; i < index; i++)
		{
			current = current.next;
		}
		}
		return current.data;
	}

	@Override
	public boolean remove(Object item) {
		// TO DO
		Node current = head;
		if(head == null)
		{
			return false;
		}
		if(head.data.equals(item))	
		{
			head = current.next;
			numberOfElements--;
			return true;
		} 
		while(current != null && current.next != null)
		{
			if(current.next.data.equals(item))
			{
				current.next = current.next.next;
				numberOfElements--;
				return true;
			}
				current = current.next;
		}
		return false;
	}
	

	@Override
	public Object remove(int index) {
		Object rv = null;

		if (isEmpty() || index >= numberOfElements) {
			rv = null;
		}
		else if (index == 0) {
			// special case - first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else {
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}

			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}

		return rv;
	}
	

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		if(head == null)
		{
			return true;
		}else
		return false;
	}

	@Override
	public int getFrequency(Object item) {
		// TO DO
		Node current = head;
		int frequency = 0;
		while(current != null)
		{
			if(current.data.equals(item))
			{
				frequency++;
				current = current.next;
			}else
				current = current.next;
		}

		return frequency;
	}

	@Override
	public void clear() {
		// TO DO
		head = null;
	}

}
