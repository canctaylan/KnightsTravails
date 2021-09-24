package com.knightsTravails.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.knightsTravails.entity.Node;

@Service
public class KnightsTravailsService {
	// Below arrays detail all eight possible movements for a knight
	 private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
	 private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };

	 // Check if (x, y) is valid chessboard coordinates.
	 // Note that a knight cannot go out of the chessboard
	 private static boolean isValid(int x, int y, int N) {
	     return (x >= 0 && x < N) && (y >= 0 && y < N);
	 }
	 
	 public String findShortestDistance(String start, String end)
	 {
		 //N x N matrix
	     int N = 8;
	     
	     // source coordinates
	     Node src = new Node(stringToCoord(start));

	     // destination coordinates
	     Node dest = new Node(stringToCoord(end));
		 
	     // set to check if the matrix cell is visited before or not
	     Set<Node> visited = new HashSet<>();

	     // create a queue and enqueue the first node
	     Queue<Node> q = new ArrayDeque<>();
	     q.add(src);

	     // loop till queue is empty
	     while (!q.isEmpty())
	     {
	         // dequeue front node and process it
	         Node node = q.poll();

	         int x = node.x;
	         int y = node.y;
	         String prevNodes = node.prevNodes;
	         int dist = node.dist;
	         
	         

	         // if the destination is reached, return distance
	         if (x == dest.x && y == dest.y) {
	        	 return coordToString(prevNodes);
//	             return dist;
	         }

	         // skip if the location is visited before
	         if (!visited.contains(node))
	         {
	             // mark the current node as visited
	             visited.add(node);

	             // check for all eight possible movements for a knight
	             // and enqueue each valid movement
	             for (int i = 0; i < row.length; i++)
	             {
	                 // get the knight's valid position from the current position on
	                 // the chessboard and enqueue it with +1 distance
	                 int x1 = x + row[i];
	                 int y1 = y + col[i];

	                 if (isValid(x1, y1, N)) {
	                     q.add(new Node(x1, y1, dist + 1, prevNodes + " "+x1+y1));
	                 }
	             }
	         }
	     }

	     // return infinity if the path is not possible
	     return null;
	 }
	 
	 public int[] stringToCoord(String location)
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
	 
	 public String coordToString(String nodeList)
	 {
		 String[] arr = nodeList.trim().split(" ");
		 String result = "";
		 for(int i=0;i<arr.length;i++)
		 {
			 String letterLocation = arr[i].substring(0,1);
			 int numberLocation = Integer.parseInt(arr[i].substring(1))+1;
			 
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
	 
//	 public static void main(String[] args)
//	 {
//	     // N x N matrix
//	     int N = 8;
//	     
//	     // source coordinates
//	     Node src = new Node(stringToCoord("A8"));
//
//	     // destination coordinates
//	     Node dest = new Node(stringToCoord("B7"));
//
//	     System.out.println(findShortestDistance(src, dest, N));
//	 }

}
