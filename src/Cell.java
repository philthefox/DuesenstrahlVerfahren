import java.util.ArrayList;
import java.util.List;

public class Cell {
	private int ordinate_x;
	private int ordinate_y;
	private int state;
	private List<Cell> neighbors;
	private Cell upperLeftNeighbor;
	private Cell upperNeighbor;
	private Cell upperRightNeighbor;
	private Cell rightNeighbor;
	private Cell belowRightNeighbor;
	private Cell belowNeighbor;
	private Cell belowLeftNeighbor;
	private Cell leftNeighbor;
	
	public Cell(int ordinate_x, int ordinate_y) {
		this.ordinate_x = ordinate_x;
		this.ordinate_y = ordinate_y;
		neighbors = new ArrayList<Cell>();
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}
	
	public List<Cell> getAllNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Cell neighbor, int neighbor_x, int neighbor_y) {
		if ((neighbor_x < ordinate_x) && (neighbor_y < ordinate_y)) {
			upperLeftNeighbor = neighbor;
		}
		else if ((neighbor_x < ordinate_x) && (neighbor_y == ordinate_y)) {
			upperNeighbor = neighbor;
		}
		else if ((neighbor_x < ordinate_x) && (neighbor_y > ordinate_y)) {
			upperRightNeighbor = neighbor;
		}
		else if ((neighbor_x == ordinate_x) && (neighbor_y < ordinate_y)) {
			leftNeighbor = neighbor;
		}
		else if ((neighbor_x == ordinate_x) && (neighbor_y > ordinate_y)) {
			rightNeighbor = neighbor;
		}
		else if ((neighbor_x > ordinate_x) && (neighbor_y < ordinate_y)) {
			belowLeftNeighbor = neighbor;
		}
		else if ((neighbor_x > ordinate_x) && (neighbor_y == ordinate_y)) {
			belowNeighbor = neighbor;
		}
		else if ((neighbor_x > ordinate_x) && (neighbor_y > ordinate_y)) {
			belowRightNeighbor = neighbor;
		}
		else {
			// throw exception
		}
		
		neighbors.add(neighbor);
	}
	
	@Override
	public String toString() {
		return ordinate_x + "_" + ordinate_y;
	}
}
