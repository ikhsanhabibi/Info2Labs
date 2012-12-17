
public class Node<T> {
	private T content;
	@SuppressWarnings("rawtypes")
	public Node next;
	
	public Node (T content){
		this.content = content;
	}
	public T getContent(){
		return content;
	}
}
