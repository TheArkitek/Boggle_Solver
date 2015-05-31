package com.javaprograms.Boggle;

import java.util.List;

// The node characteristic neighbors is needed in order to correctly follow the rules of Boggle

public class Node {
	
	private final char value;
	private final Position position;
	private final List<Position> neighbors;
	
	public Node(char value, Position position, List<Position> neighbors){
		this.value = value;
		this.position = position;
		this.neighbors = neighbors;
		
	}
	
	public char getValue(){
		return value;
	}
	public Position getPosition(){
		return position; 
	}
	
	public List<Position> getNeighbors(){
		return neighbors;
	}

}
