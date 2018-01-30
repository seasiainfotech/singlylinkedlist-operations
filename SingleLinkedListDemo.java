/**
 * This code has been used to create a singly linked list that contains data of integer type
 * and performing some linked list related basic functions
 * Operations performed are:
 * 1. Append an element into the linkedlist
 * 2. Remove the tail element from a linkedlist
 * 3. Remove all element in the linkedlist that is great than a target value
 * @author Nitin
 *
 */
public class SingleLinkedListDemo<T> {

	public static void main(String a[]){
		SingleLinkedListDemo<Integer> linkedListDemo = new SingleLinkedListDemo<>();
		// Adding random Nodes to make a linked list
		linkedListDemo.insertLinkedListNode(5);
		linkedListDemo.insertLinkedListNode(13);
		linkedListDemo.insertLinkedListNode(45);
		linkedListDemo.insertLinkedListNode(23);
		linkedListDemo.insertLinkedListNode(67);
		//Printing all Nodes
		linkedListDemo.printLinkedListNodes();
		// Inserting a Nodes 82 after Nodes 45
		linkedListDemo.insertLinkedListNodeAfter(82, 45);
		//Printing all Nodes
		linkedListDemo.printLinkedListNodes();
		//Delete last Nodes from list and its reference from previous Nodes
		System.out.println("List after deleting last Element ");
		linkedListDemo.deleteLastLinkedListNode();
		//Printing all Nodes
		linkedListDemo.printLinkedListNodes();
		// Adding random Nodes
		linkedListDemo.insertLinkedListNode(32);
		linkedListDemo.insertLinkedListNode(6);
		linkedListDemo.insertLinkedListNode(98);
		linkedListDemo.insertLinkedListNode(27);
		linkedListDemo.insertLinkedListNode(45);
		//Traversal of all Nodes
		linkedListDemo.printLinkedListNodes();
		// delete all Nodes having value greater than 30
		linkedListDemo.deleteLinkedListNodesGreaterThan(30);
		//Printing all Nodes
		linkedListDemo.printLinkedListNodes();
	}

	private LinkedListNode<T> tailNode;
	private LinkedListNode<T> headNode;

	//This class is used to define a Node and implementing Comparable Interface
	class LinkedListNode<T> implements Comparable<T> {
		private T value;
		private LinkedListNode<T> nextLinkedListNodeLink;

		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public LinkedListNode<T> getNextLinkedListNodeLink() {
			return nextLinkedListNodeLink;
		}
		public void setNextLinkedListNodeLink(LinkedListNode<T> link) {
			this.nextLinkedListNodeLink = link;
		}
		@Override
		public int compareTo(T arg) {
			if(arg == this.value){
				return 0;
			} else {
				return 1;
			}
		}
	}

	/**
	 * This method is Inserting New Node in the List
	 * @param element
	 */
	private void insertLinkedListNode(T element){

		LinkedListNode<T> LinkedListNode = new LinkedListNode<>();
		LinkedListNode.setValue(element);
		System.out.println("Adding Node: "+element);
		// when list is empty there will be one LinkedListNode that's why
		//both head and tail will get the same value
		if(headNode == null){
			headNode = LinkedListNode;
			tailNode = LinkedListNode;
		} else {
			// if there is already existing LinkedListNode then set the current tail as next LinkedListNode link
			tailNode.setNextLinkedListNodeLink(LinkedListNode);
			//now newly created LinkedListNode will act as the tail of the linked list
			tailNode = LinkedListNode;
		}
	}

	/**
	 * Method to add a Node in list after a given Node
	 * @param element
	 * @param after
	 */
	private void insertLinkedListNodeAfter(T element, T after){
		System.out.println("Inserting "+element+" after "+after);
		LinkedListNode<T> tmp = headNode;
		LinkedListNode<T> refLinkedListNode = null;
		/**
		 * Traverse till given element
		 */
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.compareTo(after) == 0){
				//found the target LinkedListNode, add after this LinkedListNode
				refLinkedListNode = tmp;
				break;
			}
			tmp = tmp.getNextLinkedListNodeLink();
		}
		if(refLinkedListNode != null){
			//add element after the target LinkedListNode
			LinkedListNode<T> nd = new LinkedListNode<T>();
			nd.setValue(element);
			nd.setNextLinkedListNodeLink(tmp.getNextLinkedListNodeLink());
			if(tmp == tailNode){
				tailNode = nd;
			}
			tmp.setNextLinkedListNodeLink(nd);
		} else {
			System.out.println("Unable to locate the element in the list");
		}
	}

	/**
	 * Removing all elements in the linked list that are greater than a target value
	 * @param value
	 */
	private void deleteLinkedListNodesGreaterThan(int value) {
		System.out.println("Deleting all nodes from list having value greater than "+value);
		LinkedListNode<T> prev = null, next;
		for (LinkedListNode<T> currentNode = headNode; currentNode != null; currentNode = next) {
			next = currentNode.getNextLinkedListNodeLink();
			if ((int)currentNode.getValue() > value) {
				if (prev != null) {
					prev.setNextLinkedListNodeLink(next);
				} else {
					headNode = next;
				}
			} else {
				prev = currentNode;
			}
		}
	}


	/**
	 * This method deletes last Node from the list
	 */
	private void deleteLastLinkedListNode(){
		//System.out.println("Deleting last Node from list");
		if(headNode == null)
			System.out.println("List seems to be empty as No element found in the list");
		else{
			LinkedListNode<T> currentLinkedListNode = null;
			LinkedListNode<T> nextLinkedListNode = headNode;
			while(nextLinkedListNode.getNextLinkedListNodeLink() != null)
			{
				currentLinkedListNode = nextLinkedListNode;
				nextLinkedListNode = nextLinkedListNode.getNextLinkedListNodeLink();
			}
			if(currentLinkedListNode != null)
			{
				currentLinkedListNode.setNextLinkedListNodeLink(null);
				tailNode = currentLinkedListNode;
			}
		}
	}

	/**
	 * Method to print all LinkedListNodes of linked list
	 */
	private void printLinkedListNodes(){
		System.out.println("Showing the elements after performing operations");
		LinkedListNode<T> tmpNode = headNode;
		while(true){
			if(tmpNode == null){
				System.out.println();
				break;
			}

			System.out.print(tmpNode.getValue());
			tmpNode = tmpNode.getNextLinkedListNodeLink();
			if(tmpNode != null)
				System.out.print(" > ");
		}
	}
}
