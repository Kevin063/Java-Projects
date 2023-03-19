package PA2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
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
		System.out.print(frametop);
		Iterator it=leaderboard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair=(Map.Entry)it.next();
			((player) pair.getValue()).printplayer();
		}
		System.out.println(framebot);
	}
	//Try to read the leaderboard from the file system
		public static leaderboard readleaderboard(){
			//part of the file IO code comes from w3school tutorials
			leaderboard lb=new leaderboard();
		    try {
		        File myObj = new File("leaderboard.txt");
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		          String data = myReader.nextLine();
		          String surname=data.substring(0,data.indexOf(";"));
		          int bestscore=Integer.parseInt(data.substring(data.indexOf(";")+1));
		          lb.recordwinner(surname, bestscore);
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		}
		    return lb;
			}
}
