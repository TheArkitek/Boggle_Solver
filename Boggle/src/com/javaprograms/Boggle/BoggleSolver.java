package com.javaprograms.Boggle;

import java.util.List;

// An interface was created so multiple solvers could be implemented

public interface BoggleSolver {
	
	List<String> solve(Board board);
	

}
