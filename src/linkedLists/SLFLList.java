package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractSLList.SNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(first); 
		first = (SNode<E>) nuevo;
		if(last == null) last = (SNode<E>) nuevo;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		if(this.getLastNode().equals(target)) last = (SNode<E>) nuevo;
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		length++; 
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if (target == first)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = findNodePrevTo(target);  
			this.addNodeAfter(prevNode, nuevo); 
		}
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException("getFirstNode() : linked list is empty...");
		else return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(last == null) throw new NoSuchElementException("getFirstNode() : linked list is empty...");
		else return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		return super.getNodeAfter(target);
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if (target == first)  
			throw new NoSuchElementException("getPrevNode(...) : target is the first node."); 
		else 
			return findNodePrevTo(target);
	}
	
	private Node<E> findNodePrevTo(Node<E> target) {
		// Pre: target is a node in the list
		if (target == first) 
			return null; 
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		if (target == first) 
			first = first.getNext(); 
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		((SNode<E>) target).clean();
		length--; 
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
