
public interface IBeobachtbar {
	public void anmelden (IBeobachter beobachter);
	public void abmelden (IBeobachter beobachter);
	public Cell[][] gibZustand();
}
