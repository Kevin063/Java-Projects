package PA2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//Class for storing all players match history
public class leaderboard {
	private HashMap<String,player> leaderboard;
	private int stalemate;
	public leaderboard() {
		this.leaderboard=new HashMap<String, player>();
	}
	public void recordwinner(String winner, int score) {
		if (leaderboard.containsKey(winner)) {
			((player) leaderboard.get(winner)).playerwin(score);
		}
		else {
			player p=new player(winner);
			this.leaderboard.put(winner, p);
			this.recordwinner(winner,score);
		}
	}
	public void recordplayer(String player) {
		if (!leaderboard.containsKey(player)) {
			player p=new player(player);
			this.leaderboard.put(player, p);
		}
	}
	public void printleaderboard() {
		String frametop= 
				  "╔══════════════════════════════════╗\n"
                + "║           Leaderboard            ║\n"
                + "╠══════════════╦═══════════════════╣\n"
                + "║   Player     ║      Score        ║\n"
                + "╠══════════════╬═══════════════════╣\n";
		String framebot="╚══════════════╩═══════════════════╝";
		System.out.println(frametop);
		Iterator it=leaderboard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair=(Map.Entry)it.next();
			((player) pair.getValue()).printplayer();
		}
		System.out.println(framebot);
	}
}
