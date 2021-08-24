package hw7;

import java.util.Iterator;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstPaths;

public class Solver {
	public static String solve(char[][] grid) {
		Graph g = new Graph(grid.length * grid.length);
		int startV = -1;
		int finishV = -1;
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid.length; col++) {
				char currentCell = grid[row][col];
				if (currentCell != '*') {
					int currentV = row * grid.length + col;
					if (currentCell == 's')
						startV = currentV;
					if (currentCell == 'f')
						finishV = currentV;
					if (col < grid.length - 1) {
						if (grid[row][col+1] != '*')
							g.addEdge(currentV, currentV+1);
					}
					if (row < grid.length - 1) {
						if (grid[row+1][col] != '*')
							g.addEdge(currentV, currentV+grid.length);
					}
				}
			}
		}
		
		BreadthFirstPaths bfs = new BreadthFirstPaths(g, startV);
		StringBuilder sb = new StringBuilder(4 * grid.length);
		int previous = -1;
		Iterable<Integer> path = bfs.pathTo(finishV);
		if (path == null)
			return null;
		for(int current : path) {
			if (previous != -1) {
				if (current > previous) {
					if (current == previous + 1)
						sb.append('R');
					else
						sb.append('D');
				} else {
					if (current == previous - 1)
						sb.append('L');
					else
						sb.append('U');
				}								
			}
			previous = current;
		}
		return sb.toString();
	}
}