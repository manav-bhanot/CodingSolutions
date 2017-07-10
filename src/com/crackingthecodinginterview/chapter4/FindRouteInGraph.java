package com.crackingthecodinginterview.chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindRouteInGraph {
	
	public int noOfVertices = 10;
	
	List<Integer> graph[];
	
	public void createGraphUsingAdjacencyList(int noOfVertices) {		
		graph = new List[noOfVertices];
		for (int i=0; i<graph.length; i++) {			
			graph[i] = new ArrayList<Integer>();
		}		
	}
	
	public void addEdge(int u, int v) {
		graph[u].add(v);
	}
	
	
	
	public boolean isReachable(int source, int destination) {
		
		boolean isVisited[] = new boolean[noOfVertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(source);
		
		while (!queue.isEmpty()) {
			
			int s = queue.poll();
			
			Iterator<Integer> it = graph[s].listIterator();
			
			while (it.hasNext()) {
				
				int n = it.next();
				
				if (n == destination) {
					return true;
				}
				
				if (!isVisited[n]) {
					isVisited[n] = true;
					queue.add(n);
				}
			}
		}		
		return false;		
	}
	
	public static void main(String[] args) {
		
		FindRouteInGraph graph = new FindRouteInGraph();
		
		graph.createGraphUsingAdjacencyList(graph.noOfVertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println(graph.isReachable(2, 0));
		
		
	}

}
