
public class Duesenstrahl extends CellularAutomata implements IBeobachtbar {

	public static void main(String[] args) {
		Duesenstrahl duesenstrahl = new Duesenstrahl(10, 10);
		duesenstrahl.printNeighbors(1, 1);
	}
	
	public Duesenstrahl(int cells_x, int cells_y) {
		super(cells_x, cells_y);
	}

	@Override
	public void anmelden(IBeobachter beobachter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abmelden(IBeobachter beobachter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[][] gibZustand() {
		// TODO Auto-generated method stub
		return null;
	}

}
