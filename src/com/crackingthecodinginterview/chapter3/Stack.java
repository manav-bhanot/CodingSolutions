package com.crackingthecodinginterview.chapter3;

@SuppressWarnings("unchecked")
public class Stack<T> {
	
	Node top;
	int size;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Stack class : "+this.hashCode();
	}
	
	public T pop() {
		
		//System.out.println(this.toString());
		
		if (this.top != null) {
			T item = (T)this.top.data;
			this.top = this.top.next;
			
			/*if (this instanceof Stack) {
				this.size--;
			}*/
			this.size--;
			return item;
		}
		return null;
	}
	
	public void push(T item) {
		
		//System.out.println(this.toString());
		
		Node t = new Node(item);
		t.next = this.top;
		this.top = t;
		
		this.size++;
	}
	
	public T peek() {
		if (top == null) {
			return null;
		}
		else {
			return (T)top.data;
		}
	}

}
