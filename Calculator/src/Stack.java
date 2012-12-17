
public class Stack<T> {
	//the pointer to topOfStack
	private Node<T> top = null;
	
	/**
	 * adds an item to the Stack
	 * @param item
	 */
	public void push(T item){
		Node<T> add = new Node<T>(item);
		add.next = top;
		top = add;
		
	}
	/**
	 * removes one item from the top of the Stack
	 * @return the removed item
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T pop() throws Exception{
		if(!empty()){
			T temp = top.getContent();
			top = top.next;
			return temp;
		}else{
			throw new Exception("Stack Underflow");
		}
	}
	/**
	 * shows the item on topOfStack
	 * @return the item on topOfStack
	 */
	public T peek(){
		return top.getContent();
	}
	
	/**
	 * tells weather the Stack is empty or not
	 * @return weather the Stack is empty
	 */
	public boolean empty(){
		return (top == null);
	}
	/**
	 * Overwrites the toString method 
	 * prints out all items in the Stack as a String
	 */
	@SuppressWarnings("unchecked")
	public String toString(){
		String out = "";
		Node<T> temp = top;
		while(temp != null){
			out += temp.getContent().toString() + ";";
			temp = temp.next;
		}
		return out;
	}

}
