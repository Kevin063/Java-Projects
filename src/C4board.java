import java.util.Arrays;
//Board rules for C4
public class C4board extends board{
	public C4board() {
		this.height=IO.readheight();
		this.width=IO.readwidth();
		this.wincondition=IO.readC4wincondition(Math.max(this.height,this.width));
		this.grids=new int[width*height];
		Arrays.fill(this.grids, 0);
	}
	public boolean execute_action(action act,int player) {
		this.getgrids()[act.getx()*this.getwidth()+act.gety()]=player;
		return wincheck(act,player);
	}
}
