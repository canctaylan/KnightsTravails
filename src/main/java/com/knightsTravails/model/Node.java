package com.knightsTravails.model;

import java.util.*;

public class Node {
	public int row, column;
	public String prevNodes = "";

	public Node(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Node(int[] coord) {
		this.row = coord[0];
		this.column = coord[1];
	}

	public Node(int row, int column, String listOfNodes) {
		this.row = row;
		this.column = column;
		this.prevNodes = listOfNodes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Node node = (Node) o;
		return row == node.row && column == node.column && prevNodes == node.prevNodes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, column, prevNodes);
	}
}
