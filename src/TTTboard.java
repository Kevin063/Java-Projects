
public class TTTboard extends board{
	public boolean execute_action(action act,int player) {
		this.getgrids()[act.getx()*this.getwidth()+act.gety()]=player;
		return wincheck(act,player);
	}
	//Check winning conditions, for TTT it contains four directions
	public boolean wincheck(action act,int player) {
		return horizonwincheck(player,act.getx())||verticalwincheck(player,act.gety())||diagonalwincheck(player,act.getx(),act.gety())||inversediagonalwincheck(player,act.getx(),act.gety());
	}
}
