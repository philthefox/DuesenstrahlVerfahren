import java.util.List;

public class Duesenstrahl extends CellularAutomata {
	
	public static void main(String[] args) {
		Duesenstrahl duesenstrahl = new Duesenstrahl(100, 100);
		duesenstrahl.printNeighbors(1, 1);
		
		duesenstrahl.anmelden(new Visualisierung(duesenstrahl.getHeight(), duesenstrahl.getWidth()));
			
		while (true) {
			duesenstrahl.updateState();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Duesenstrahl(int cells_x, int cells_y) {
		super(cells_x, cells_y);
		initState();
	}
	
	private void initState() {
		cells[0][49].setState(10000);
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				if ((i == j) || (j == width - i - 1)) {
//					cells[i][j].setState(10000);
//				}
//			}
//		}
	}
	
	public void updateState() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				List<Cell> neighbors = cells[i][j].getAllNeighbors();
				int summe = 0;
				int zaehler = 0;
				for (Cell neighbor: neighbors) {
					summe += neighbor.getState();
					zaehler++;
				}
				int mittelwert = summe / zaehler;
				state[i][j] = mittelwert;
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j].setState(state[i][j]);
			}
		}
		
		for (IBeobachter beobachter: this.beobachter) {
			beobachter.aktualisieren(this);
		}
	}
	
	public void updateState2() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				List<Cell> neighbors = cells[i][j].getAllNeighbors();
				int summe = 0;
				int zaehler = 0;
				for (Cell neighbor: neighbors) {
					summe += neighbor.getState();
					zaehler++;
				}
				int mittelwert = summe / zaehler;
				state[i][j] = mittelwert;
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j].setState(state[i][j]);
			}
		}
		
		for (IBeobachter beobachter: this.beobachter) {
			beobachter.aktualisieren(this);
		}
	}

	

}
