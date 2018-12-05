import java.util.List;

public class CellularAutomata {
	private Cell[][] cells;
	private int[][] state;
	private int[][] newState;
	
	public static void main(String[] args) {
		CellularAutomata automata = new CellularAutomata(10, 10);
		automata.printNeighbors(1, 1);
	}
	
	public CellularAutomata(int cells_x, int cells_y) {
		cells = new Cell[cells_x][cells_y];
		state = new int[cells_x][cells_y];
		newState = new int[cells_x][cells_y];
		
		initCells();
		initNeighbors();
	}
	
	private void initCells() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	private void initNeighbors() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				for (int k = i - 1; k <= i + 1; k++) {
					for (int m = j - 1; m <= j + 1; m++) {
						if ((0 <= k) && (k < cells.length) && (0 <= m) && (m < cells[0].length)) {
							if (!((i == k) && (j == m))) {
								cells[i][j].addNeighbor(cells[k][m], k, m);
							}
						}
					}
				}
			}
		}
	}
	
	public void printNeighbors(int cell_x, int cell_y) {
		try {
			System.out.println("Neighbors from " + cell_x + "_" + cell_y + ": ");
			List<Cell> neighbors = cells[cell_x][cell_y].getAllNeighbors();
			for (Cell neighbor: neighbors) {
				System.out.println(neighbor);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("this cell does not exist");
		}
	}
}





