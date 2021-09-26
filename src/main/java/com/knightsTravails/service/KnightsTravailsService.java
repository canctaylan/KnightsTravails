package com.knightsTravails.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.knightsTravails.model.Node;

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
	     
	     Node startNode = new Node(stringToCoord(start));

	     Node destNode = new Node(stringToCoord(end));
		 
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
	        	 return coordToString(prevNodes);
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
	 
	 public int[] stringToCoord(String location) //method to convert the String location to numerical values for easy calculation
	 {
		 int[] locationArray = new int[2];
		 char letterLocation = location.charAt(0);
		 int numberLocation = Integer.parseInt(location.substring(1))-1;
		 
		 if(letterLocation == 'A')
			 locationArray[0] = 0;
		 else if(letterLocation == 'B')
			 locationArray[0] = 1;
		 else if(letterLocation == 'C')
			 locationArray[0] = 2;
		 else if(letterLocation == 'D')
			 locationArray[0] = 3;
		 else if(letterLocation == 'E')
			 locationArray[0] = 4;
		 else if(letterLocation == 'F')
			 locationArray[0] = 5;
		 else if(letterLocation == 'G')
			 locationArray[0] = 6;
		 else if(letterLocation == 'H')
			 locationArray[0] = 7;
		 else
			 return null;
		 
		 locationArray[1] = numberLocation;
		 return locationArray;
	 }
	 
	 public String coordToString(String nodeList) //convert all numerical values into String locations
	 {
		 String[] nodeArray = nodeList.trim().split(" ");
		 String result = "";
		 for(String node : nodeArray)
		 {
			 String letterLocation = node.substring(0,1);
			 int numberLocation = Integer.parseInt(node.substring(1))+1;
			 
			 if(letterLocation.equals("0"))
				 result += " A" + numberLocation;
			 else if(letterLocation.equals("1"))
				 result += " B" + numberLocation;
			 else if(letterLocation.equals("2"))
				 result += " C" + numberLocation;
			 else if(letterLocation.equals("3"))
				 result += " D" + numberLocation;
			 else if(letterLocation.equals("4"))
				 result += " E" + numberLocation;
			 else if(letterLocation.equals("5"))
				 result += " F" + numberLocation;
			 else if(letterLocation.equals("6"))
				 result += " G" + numberLocation;
			 else if(letterLocation.equals("7"))
				 result += " H" + numberLocation;
		 }
		 return result.trim();
	 }

}
