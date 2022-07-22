package com.leetcode.problems;

import com.leetcode.problems.p34.Solution;

public class Main {

    public static void main(String[] args) {
        runSolutionOfP34();
    }

    static void runSolutionOfP34() {
        Solution p34Solution = new Solution();

        int[] inputArray = new int[] {5,7,7,8,8,10};
        int target = 8;

        printSolutionsOnConsole(p34Solution.searchRange(inputArray, target));
    }

    static void printSolutionsOnConsole(Object o) {

        StringBuilder printedSolution = new StringBuilder();

        if (o instanceof int[]) {
            printedSolution.append("[");

            for (int i: (int[])o) {
                printedSolution.append(i).append(",");
            }

            printedSolution.deleteCharAt(printedSolution.lastIndexOf(","));
            printedSolution.append("]");
        } else {

        }

        System.out.println(printedSolution);
    }
}
