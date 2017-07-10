package com.crackingthecodinginterview.chapter3;

public class MinElementStack extends Stack<Integer> {

	Stack<Integer> s2;

	public MinElementStack() {
		s2 = new Stack<Integer>();
	}

	public void addItemIntoStack(Integer item) {

		if (s2.peek()!=null && item < s2.peek()) {
			s2.push(item);
		}
		this.push(item);
		
		System.out.println("S2 : "+s2.peek());
		System.out.println("MinElementStack : "+this.peek());
	}

	public Integer getItemFromStack() {

		if (this.top.data == s2.peek()) {
			s2.pop();
		}
		return this.pop();
	}

	public Integer getMinimum() {
		return s2.peek();
	}

	public static void main(String[] args) {
		MinElementStack minimum = new MinElementStack();
		minimum.addItemIntoStack(3);
		minimum.addItemIntoStack(6);
		minimum.addItemIntoStack(5);
		minimum.addItemIntoStack(0);
		minimum.addItemIntoStack(90);
		
		System.out.println(minimum.getMinimum());
	}
}
