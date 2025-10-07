import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

import static java.lang.Thread.sleep;

public class Main {
	static List<Player> players = new ArrayList<>(); //List of players who haven't played
	static List<Player> played = new ArrayList<>(); //List of players who have played
    public static Court[] courts;	//List of the courts on the field
    public static Player pick() {
		if(players.isEmpty())
		{
			// If no players are left in the list, re-add played players and clear the played list
			players.addAll(played);
			played.clear();
			// Pick the first player from the players list
			Player p = players.remove(0);
			played.add(p);
			return p;
		}

		// Pick the first player from the players list
		Player p = players.remove(0); //Removing the first player
		played.add(p); // Add the player to the played list

		return p;
	}

	// After Player 1 is created, we reference it for picking Player 2
	public static Player pickOthers(Player p1)
	{
		Player p2 = null;

		if(players.isEmpty())
		{
			players.addAll(played);
			played.clear();
		}

		// Try to find a player who hasn't played with p1
		for(Player potentialPlayers : players)
		{
			if(!p1.opponents.contains(potentialPlayers)) {
				p2 = potentialPlayers; //Found a valid player
				break;
			}
		}

		//If p2 is a valid player, we will take it out of the players and put it in player list.
		if (p2 != null)
		{
			players.remove(p2);
			played.add(p2);
		}

		else
		{
			System.out.println("Player " + p1.getID() + " has played with everyone. Clearing opponents list and trying again.");
			p1.opponents.clear(); // Reset the opponents list for p1
			return pickOthers(p1); // Recursively try again
		}
		return p2;
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter number of players: ");
		int nplayers = scan.nextInt();
	
		for (int i = 1; i <= nplayers; i++) {
			players.add(new Player(i));
			System.out.println("Player " + i + " created.");
		}
			
		System.out.println("Enter number of courts: ");
		int ncourts = scan.nextInt();

		courts = new Court[ncourts];        //Creates court Array List
		Scanner scanr = new Scanner(System.in);


		for (int i = 1; i <= ncourts; i++) {
			System.out.println("Court " + i + " type: ");
			String type = scanr.nextLine().toLowerCase();
			if (type.equals("singles") || type.equals("single")) {
				courts[i-1] = new Court(i, false);
				System.out.println("Singles court (" + i + ") created.");
			} else if (type.equals("doubles") || type.equals("double")) {
				courts[i-1] = new Court(i, true);
				System.out.println("Doubles court (" + i + ") created.");
			}
		}
		Rounds();

		sleep(20);
		//After game setup
		while(true) {
			System.out.println("Next Round?");
			String round = scanr.nextLine().toLowerCase();
			if (round.equals("yes")) {
				Rounds();
			} else {
				scan.close();
				scanr.close();
				System.exit(0);
			}
		}




	}

	public static void Rounds()
	{
		Collections.shuffle(players);

		for(int i = 0; i < courts.length; i++) {
			courts[i].clearCourt();
			if(courts[i].getCourtType())
			{
				Player p1 = pick();
				Player p2 = pickOthers(p1);
				Player p3 = pickOthers(p1);
				Player p4 = pickOthers(p1);
				courts[i].setDoubleCourt(p1,p2,p3,p4);
				p1.playWithDoubles(p2,p3,p4);
				p2.playWithDoubles(p1,p3,p4);
				p3.playWithDoubles(p2,p1,p4);
				p4.playWithDoubles(p2,p3,p1);

				System.out.println(courts[i]);
			}
			else
			{
				Player p1 = pick();
				Player p2 = pickOthers(p1);
				courts[i].setSingleCourt(p1,p2);
				System.out.println(courts[i]);
				p1.playWithSingles(p2);
				p2.playWithSingles(p1);


			}

		}
	}
}
