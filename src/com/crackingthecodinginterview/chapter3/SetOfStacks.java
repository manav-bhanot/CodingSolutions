package com.crackingthecodinginterview.chapter3;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SetOfStacks extends Stack {

	Stack s;
	private Integer threshold = 3;

	@Override
	public String toString() {
		return "SetOfStacks class : " + this.hashCode();
	}

	public SetOfStacks() {
		this.s = new Stack();
	}

	public void push(Integer item) {

		/*
		 * System.out.println(this.s); System.out.println(this.s.size);
		 */

		if (this.s.size < threshold) { // check the top index. If it has reached
										// the threshold value,
			// then add this stack to the set of stacks.
			s.push(item);
		} else {
			// Now creating a new stack since the previous stack is full and
			// adding items to this stack
			/*System.out.println("Size of "+this+" is : "+this.size);
			System.out.println("Size of "+this.s+" is : "+this.s.size);*/
			
			s = new Stack();
			s.push(item);

			// Placing this new stack on the top of the StackOfStacks
			this.push(this.s);
			
			
		}
	}

	/*
	 * public Object pop() {
	 * 
	 * Stack s = (Stack) this.pop();
	 * 
	 * if (s!=null && s.top != null) { return s.top.data; } else { return null;
	 * }
	 * 
	 * if (this.top == null) { if (this.top.next == null) { return null; }
	 * this.top = this.top.next; }
	 * 
	 * if (this.s.top != null) { Object item = this.s.top.data; this.s.top =
	 * this.s.top.next; return item; } return null;
	 * 
	 * }
	 */

	public Object popAt(Integer index) {

		List<Stack> listOfStacks = new ArrayList<Stack>();
		
		if (index > this.size) {
			System.out.println("Invalid Index! There is no sub stack at the specified index");
			return null;
		}
		
		int actualIndex = this.size - index + 1;
		System.out.println("Actual index is : "+actualIndex);

		while (actualIndex != 0) {
			if (this.top != null) {
				Stack s = (Stack) this.pop();
				listOfStacks.add(s);
			} else {
				System.out.println("There is no such sub stack at the specified index");
			}
			actualIndex--;
		}
		
		System.out.print("Item at substack indexed at position : "+index+" is : ");
		System.out.println(listOfStacks.get(listOfStacks.size()-1).pop());
		
		// Pushing the stacks back to the main stack
		for (int i=listOfStacks.size()-1; i>=0; i--) {
			this.push(listOfStacks.get(i));
		}		
		return 0;		
	}

	public static void main(String... args) {
		SetOfStacks setOfStacks = new SetOfStacks();
		setOfStacks.push(setOfStacks.s);

		// Pushing the items on to the stack
		for (int i = 0; i < 24; i++) {
			setOfStacks.push(i);
		}

		// Pushing the items on to the stack
		/*while (setOfStacks.top != null) {
			Stack s = (Stack) setOfStacks.pop();
			while (s.top != null) {
				System.out.println(s.pop());
			}
		}*/
		
		//Pop from a substack at a specific index
		setOfStacks.popAt(4);

		/*
		 * System.out.println(setOfStacks.pop());
		 * System.out.println(setOfStacks.pop());
		 */
	}
}
