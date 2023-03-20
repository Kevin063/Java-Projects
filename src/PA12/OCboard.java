package PA12;
//Board rules for OC
import java.util.Arrays;

public class OCboard extends board{
	public OCboard() {
	this.height=IO.readheight();
	this.width=IO.readwidth();
	this.wincondition=IO.readOCwincondition(Math.max(this.height,this.width));
	this.grids=new int[width*height];
	Arrays.fill(this.grids, 0);
	}
	public boolean execute_action(action act,int symbol) {
		this.getgrids()[act.getx()*this.getwidth()+act.gety()]=symbol;
		return wincheck(act,symbol);
	}
}
