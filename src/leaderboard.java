import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//Class for storing all players match histtory
public class leaderboard {
	private HashMap<String,player> leaderboard;
	private int stalemate;
	public leaderboard() {
		this.leaderboard=new HashMap();
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
	public void printleaderboard() {
		Iterator it=leaderboard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair=(Map.Entry)it.next();
			System.out.print(pair.getKey()+" ");
			((player) pair.getValue()).printplayer();
		}
		System.out.println("The game has been ends with stalemate for "+this.stalemate+" times.");
	}
	public void recordstalemate() {
		this.stalemate++;
	}
}
