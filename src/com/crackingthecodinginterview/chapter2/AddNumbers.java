package com.crackingthecodinginterview.chapter2;

public class AddNumbers {

	private Node head1;
	private Node head2;
	private Node head3;

	public Node createFirstNumber() {

		Node n = new Node(5);
		this.head1 = n;

		n.appendToTail(7);
		n.appendToTail(0);
		n.appendToTail(6);
		n.appendToTail(4);

		return this.head1;
	}

	public Node createSecondNumber() {

		Node n = new Node(8);
		this.head2 = n;

		n.appendToTail(0);
		n.appendToTail(9);

		return this.head2;
	}

	public int findSizeOfLinkedList(Node head) {

		Node n = head;
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	public Node addNumbersInLinkedLists(Node num1, Node num2) {

		// Get the number of digits in the first number
		int len1 = findSizeOfLinkedList(num1);
		int len2 = findSizeOfLinkedList(num2);
		
		System.out.println("Number 1 is : "+len1+" digits long");
		System.out.println("Number 2 is : "+len2+" digits long");

		Node resultLinkedList = null;
		int carry = 0;

		if (len1 > len2) {
			while (num2 != null) {
				int s = num1.data + num2.data;
				
				if (this.head3 == null) {
					resultLinkedList = new Node(s > 9 ? s % 10 + carry : s + carry);
					this.head3 = resultLinkedList;
				} else {
					resultLinkedList.appendToTail(s > 9 ? s % 10 + carry : s + carry);
				}
				carry = s > 9 ? 1 : 0;
				num1 = num1.next;
				num2 = num2.next;			
			}
			
			// Now just append the remaining digits of num1 to the resultLinkedList
			while(num1 != null) {
				resultLinkedList.appendToTail(num1.data + carry);
				carry = 0;
				num1 = num1.next;
			}
		} else {
			while (num1 != null) {
				int s = num1.data + num2.data;
				
				if (this.head3 == null) {
					resultLinkedList = new Node(s > 9 ? s % 10 + carry : s + carry);
					this.head3 = resultLinkedList;
				} else {
					resultLinkedList.appendToTail(s > 9 ? s % 10 + carry : s + carry);
				}
				carry = s > 0 ? 1 : 0;
				num1 = num1.next;
				num2 = num2.next;			}
			
			// Now just append the remaining digits of num2 to the resultLinkedList
			while(num2 != null) {
				resultLinkedList.appendToTail(num1.data + carry);
				carry = 0;
				num1 = num1.next;
			}
		}
		
		return this.head3;
	}

	public static void main(String[] args) {

		AddNumbers numbers = new AddNumbers();
		Node number1 = numbers.createFirstNumber();
		Node number2 = numbers.createSecondNumber();
		
		System.out.println("Number 1 in reverse order is :");
		number1.printLinkedList();
		
		System.out.println("Number 2 in reverse order is :");
		number2.printLinkedList();
		
		numbers.addNumbersInLinkedLists(number1, number2);
		
		System.out.println("Sum in reverse order is : ");
		numbers.head3.printLinkedList();

	}

}
