import java.util.HashSet;

public class Player {
	int id;
	HashSet<Player> opponents;

	public Player(int id) {
		this.id = id;
		opponents = new HashSet<Player>();
	}

	public int getID() {
		return id;
	}
	
	public void playWithSingles(Player p) {
		opponents.add(p);
	}

	public void playWithDoubles(Player p1, Player p2, Player p3)
	{
		opponents.add(p1);
		opponents.add(p2);
		opponents.add(p3);
	}
}
