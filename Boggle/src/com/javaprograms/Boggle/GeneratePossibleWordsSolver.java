package com.javaprograms.Boggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneratePossibleWordsSolver extends WithDictionary implements BoggleSolver {
	public List<String> solve(Board board){
		Set<String> words = new HashSet<String>(readDictionary());
		Set<String> foundWords = new HashSet<String>();
		
		for (Node startingNode : board.getNodes()){
			Set<Position> visited = new HashSet<Position>();
			visited.add(startingNode.getPosition());
			findAll("" + startingNode.getValue(), startingNode, board, words, foundWords, visited);
		}
		
		return new ArrayList<String>(foundWords);
	}
	
	private void findAll(String currentWord, Node currentNode, Board board, Set<String> words, Set<String> foundWords, Set<Position> visited){
		
		if (currentWord.length() > 20) return;
		
		if (words.contains(currentWord)){
			foundWords.add(currentWord);
			
		}
		
		List<Node> neighbors = new ArrayList<Node>();
		
		for (Position neighbor : currentNode.getNeighbors()){
			neighbors.add(positionToNode(neighbor, board));
		}
		
		for (Node neighbor : neighbors){
			if (visited.contains(neighbor.getPosition())) continue;
			visited.add(neighbor.getPosition());
			findAll(currentWord + neighbor.getValue(), neighbor, board, words, foundWords, visited);
			visited.remove(neighbor.getPosition());
		}
	}
	
	private Node positionToNode(Position position, Board board){
		for (Node node : board.getNodes()){
			if (position.equals(node.getPosition())) return node;
		}
		
		return null;
	}
	

}
