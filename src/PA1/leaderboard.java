package PA1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//Class for storing all players match history
public class leaderboard {
	private HashMap<String,player> leaderboard;
	private int stalemate;
	public leaderboard() {
		this.leaderboard=new HashMap<String, player>();
		this.stalemate=0;
	}
	public void recordwinner(String winner, game gm) {
		if (leaderboard.containsKey(winner)) {
			((player) leaderboard.get(winner)).playerwin(gm);
		}
		else {
			player p=new player(winner);
			this.leaderboard.put(winner, p);
			this.recordwinner(winner,gm);
		}
	}
	public void recordplayer(String player) {
		if (!leaderboard.containsKey(player)) {
			player p=new player(player);
			this.leaderboard.put(player, p);
		}
	}
	public void printleaderboard() {
		Iterator it=leaderboard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair=(Map.Entry)it.next();
			((player) pair.getValue()).printplayer();
		}
		System.out.println("The game has been ends with stalemate for "+this.stalemate+" times.");
	}
	public void recordstalemate() {
		this.stalemate++;
	}
}
