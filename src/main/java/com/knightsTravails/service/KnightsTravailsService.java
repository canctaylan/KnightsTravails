package com.knightsTravails.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.knightsTravails.model.Node;
import com.knightsTravails.util.KnightsTravailsUtil;

@Service
public class KnightsTravailsService {
	 //All possible movements of a Knight chess piece in rows and columns
	 private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
	 private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
	 
	 private final int BOARD_SIZE = 8;
	 
	 //method to check if a movement is inside the board
	 private static boolean isInBoard(int x, int y, int N) {
	     return (x >= 0 && x < N) && (y >= 0 && y < N);
	 }
	 
	 public String findShortestPath(String start, String end)
	 {
	     int N = BOARD_SIZE;
	     
	     Node startNode = new Node(KnightsTravailsUtil.stringToCoord(start));

	     Node destNode = new Node(KnightsTravailsUtil.stringToCoord(end));
		 
	     Set<Node> visitedNodes = new HashSet<>();

	     Queue<Node> queueOfNodes = new ArrayDeque<>();
	     queueOfNodes.add(startNode);

	     while (!queueOfNodes.isEmpty())
	     {
	    	 //We retrieve the first node in the queue and remove it from the queue
	         Node node = queueOfNodes.poll();

	         int rowOfNode = node.row;
	         int colOfNode = node.column;
	         String prevNodes = node.prevNodes;
	        
	         if (rowOfNode == destNode.row && colOfNode == destNode.column) { //destination reached
	        	 return KnightsTravailsUtil.coordToString(prevNodes);
	         }

	         if (!visitedNodes.contains(node))
	         {
	             visitedNodes.add(node);

	             for (int i = 0; i < row.length; i++)
	             {
	                 int nextRow = rowOfNode + row[i];
	                 int nextColumn = colOfNode + col[i];

	                 if (isInBoard(nextRow, nextColumn, N)) {
	                     queueOfNodes.add(new Node(nextRow, nextColumn, prevNodes + " "+nextRow+nextColumn));
	                 }
	             }
	         }
	     }

	     return null;
	 }

}
