package PA2;
//Class for storing all players game history
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	public void saveleaderboard() {
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("leaderboard.txt"));
		Iterator it=leaderboard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair=(Map.Entry)it.next();
			writer.write((pair.getKey())+";"+((player)(pair.getValue())).getbestscore());
			writer.newLine();
			} 
		writer.close();
		}catch (IOException e) {
				System.out.println("IO error while saving the leaderboard!");
			}
        System.out.println("Leaderboard is successfully saved.");
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
