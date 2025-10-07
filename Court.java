import java.util.ArrayList;

public class Court {
	ArrayList<Player> team1 = new ArrayList<>();
	ArrayList<Player> team2 = new ArrayList<>();
	boolean doubleType;
	int courtID;

	public Court(int id, boolean type) {
		this.courtID = id;
		this.doubleType = type;
	}

	public void setSingleCourt(Player a, Player b) {
		team1.add(a);
		team2.add(b);
	}

	public void setDoubleCourt(Player a, Player b, Player c, Player d) {
		team1.add(a);
		team1.add(b);
		team2.add(c);
		team2.add(d);
	}

	public boolean getCourtType() { // Returns if it's doubles or not
		return doubleType;
	}

	public void clearCourt() {
		team1.clear(); // Simply clear the lists
		team2.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Court ").append(courtID).append(" - ");
		sb.append(doubleType ? "Doubles" : "Singles").append("\n");
		sb.append("Team 1: [");
		for (Player p : team1) {
			sb.append(p.getID()).append(", ");
		}
		if (!team1.isEmpty()) sb.setLength(sb.length() - 2); // Remove trailing ", "
		sb.append("]");

		sb.append(", Team 2: [");
		for (Player p : team2) {
			sb.append(p.getID()).append(", ");
		}
		if (!team2.isEmpty()) sb.setLength(sb.length() - 2); // Remove trailing ", "
		sb.append("]");

		return sb.toString();
	}
}
