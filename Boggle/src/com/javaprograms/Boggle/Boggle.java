package com.javaprograms.Boggle;

/*
 * This little project demonstrates a solving type Depth First Search
 * by simulating a Boggle board and automatically finding every word
 * that exists within the games rules.
 * 
 * 
 */



import java.util.ArrayList;
import java.util.List;

public class Boggle {
	
	private Board board;
	private BoggleSolver solver;
	
	public Boggle(String input){
		board = buildBoard(input);
		solver = new GeneratePossibleWordsSolver();
	}
	
	private Board buildBoard(String input){
		List<Node> nodes = new ArrayList<Node>(input.length());
		
		int dimension = (int) Math.sqrt(input.length());
		
		for (int i = 0, sz = input.length(); i < sz; i++){
			nodes.add(buildNode(input.charAt(i), new Position(i / dimension, i % dimension), dimension));
			
		}
		
		return new Board(nodes);
	}
	
	private Node buildNode(char value, Position position, int dimension){
		return new Node(value, position, getNeighbors(position, dimension));
	}
	
	private List<Position> getNeighbors(Position position, int dimension){
		int[] directions = {-1, 0, 1};
		List<Position> neighbors = new ArrayList<Position>();
		
		for (int rowDiff : directions){
			for (int colDiff : directions){
				Position neighbor = new Position(position.getRow() + rowDiff, position.getColumn() + colDiff);
				
				if (!position.equals(neighbor) && validPosition(neighbor, dimension)){
					neighbors.add(neighbor);
					}
				}
		}
		return neighbors;
	}
	
	private boolean validPosition(Position position, int dimension){
		return inRange(position.getRow(), dimension) && inRange(position.getColumn(), dimension);
	}
	
	private boolean inRange(int x, int dimension){
		return x >= 0 && x < dimension;
	}
	
	public void solve(){
		List<String> foundWords = solver.solve(board);
		
		for (String foundWord : foundWords){
			System.out.print(foundWord + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args){
		
		new Boggle(args[0]).solve();
		
	}

}
