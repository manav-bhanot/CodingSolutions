package com.internetbrands;

public class Staircase {
	
	private Integer n;
	
	public void printStaircase(Integer size) {
		
		for (int index = size; index > 0; index--) {
			
			for (int j = index-1; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int k = size; k > index-1; k--){
				System.out.print("#");				
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		Staircase staircase = new Staircase();
		staircase.n = 50;
		staircase.printStaircase(staircase.n);
		
		/*int x = 1;
		int y = 1;
		int z = 0;
		
		while (x < 25) {
			z = x;
			x = x + y;
			y = z;
		    System.out.println(x);
		}*/
	}
}
