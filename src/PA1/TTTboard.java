package PA1;
//Board rules for TTT
import java.util.Arrays;
public class TTTboard extends board{
	public TTTboard() {
		this.height=IO.readheight();
		this.width=IO.readwidth();
		this.wincondition=IO.readTTTwincondition(Math.max(this.height,this.width));
		this.grids=new int[width*height];
		Arrays.fill(this.grids, 0);
	}
	public boolean execute_action(action act,int player) {
		this.getgrids()[act.getx()*this.getwidth()+act.gety()]=player;
		return wincheck(act,player);
	}
}
