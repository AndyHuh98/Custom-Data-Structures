import java.util.Iterator;

public class LinkedList<T> {
	private class Node<T> {
		T data;
		Node<T> next, prev;
		
		public Node(T data, Node<T> next, Node<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private int size;
	private Node<T> head, tail;
	
	//Constructors
	public LinkedList() {
		
	}
	
	public LinkedList(T elem) {
		Node<T> node = new Node(elem, null, null);
		head = node;
		tail = node;
	}
	
	//Clear
	public void clear() {
		Node<T> traverser = head;
		
		while (traverser != null) {
			Node<T> next = traverser.next;
			traverser.data = null;
			traverser.prev = null;
			traverser.next = null;
			traverser = next;
		}
		
		head = tail = traverser = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addToFront(T elem) {
		if (isEmpty()) {
			Node<T> element = new Node(elem, null, null);
			head = tail = element;
			size++;
		} else {
			Node<T> element = new Node(elem, head, null);
			head.prev = element;
			head = element;
			size++;
		}
	}
	
	public void append(T elem) {
		if (isEmpty()) {
			Node<T> element = new Node(elem, null, null);
			head = tail = element;
		} else {
			Node<T> element = new Node(elem, null, tail);
			tail.next = element;
			tail = element;
		}
		size++;
	}
	
	public T removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		
		T data = head.data;
		head = head.next;
		size--;
		
		if (isEmpty()) {
			tail = null;
		} else {
			head.prev = null;
		}
		
		return data;
	}
	
	public T removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		
		T data = tail.data;
		tail = tail.prev;
		size--;
		
		if (isEmpty()) {
			head = null;
		} else {
			tail.next = null;
		}
		
		return data;
	}
	
	public T remove(Node<T> node) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty List");
		}
		
		if (node.next == null) {
			removeLast();
		} 
		if (node.prev == null) {
			removeFirst();
		}
		
		T data = node.data;
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		node.data = null;
		node = null;
		node.prev = null;
		node.next = null;
		size--;
		
		if (isEmpty()) {
			head = null;
			tail = null;
		}
		
		return data;
	}
}
