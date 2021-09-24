package com.knightsTravails.entity;

import java.util.*;

//A queue node used in BFS
public class Node
{
 // (x, y) represents chessboard coordinates
 // `dist` represents its minimum distance from the source
 public int x, y, dist;
 public String prevNodes="";

 public Node(int x, int y)
 {
     this.x = x;
     this.y = y;
 }
 
 public Node(int[] coord)
 {
     this.x = coord[0];
     this.y = coord[1];
 }

 public Node(int x, int y, int dist, String prevNodes)
 {
     this.x = x;
     this.y = y;
     this.dist = dist;
     this.prevNodes = prevNodes;
 }

 // As we are using the class object as a key in a `HashMap`,
 // we need to implement `hashCode()` and `equals()`

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Node node = (Node) o;
     return x == node.x &&
             y == node.y &&
             dist == node.dist;
 }

 @Override
 public int hashCode() {
     return Objects.hash(x, y, dist);
 }
}



