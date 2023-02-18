//Class for gameboard and wincheck functions
import java.util.Arrays;

public class board {
protected int width;
protected int height;
protected int wincondition;
protected int[] grids;
public board() {
}
//Constructor
public board(int a, int b,int wc) {
	width=a;
	height=b;
	wincondition=wc;
	grids=new int[width*height];
	Arrays.fill(grids, 0);//For clearance, actually don't need since the default is 0
}
public int getheight() {
	return this.height;
}
public int getwidth() {
	return this.width;
}
public int getwincondition() {
	return this.wincondition;
}
public int[] getgrids() {
	return this.grids;
}
//Reset the board to init state
public void resetboard() {
	grids=new int[width*height];
	Arrays.fill(grids, 0);
}
//Build a line of the board grid outline,AKA,"+--+--+--+"
private String build_line(){
	String output="";
	for(int i=0;i<width;i++) output+="+--";
	output+="+";
	return output;
}
//Build a line of the board grid with numbers,AKA,"|O | | |"
private String build_grid(int linenum) {
	String output="";
	for(int i=0;i<width;i++) {
		output+="|";
		switch(grids[linenum*width+i]) {
			case 0:
				output+=" ";
				break;
			case 1:
				output+="O";
				break;
			case 2:
				output+="X";
				break;
			case -1://For marking the winner combo
				output+="*";
				break;
			default://Supporting the mutiple players
				output+=grids[linenum*width+i];
		}
		output+=" ";
	}
	output+="|";
	return output;
}
//Display the board in graphic
public String build_out() {
	String output="";
	for(int i=0;i<height;i++) {
		output+=build_line()+"\n";
		output+=build_grid(i)+"\n";
	}
	return output+build_line();
}
//Check whether the game is stalemate, here I use the simple way: whether all board grids are filled
public boolean checkstalemate() {
	for(int i = 0;i<grids.length;i++) {
		if (grids[i]==0) return false;
	}
	return true;
}
//Validate whether the spot is taken yet
public boolean vaild_action(action act) {
	if (act.getx()*width+act.gety()<0) return false;
	if (grids[act.getx()*width+act.gety()]!=0) return false;
	else return true;
}
//Execute the action
public boolean execute_action(action act,int player) {
	return false;
}

//Check winning conditions
public boolean wincheck(action act,int player) {
	return horizonwincheck(player,act.getx())||verticalwincheck(player,act.gety())||diagonalwincheck(player,act.getx(),act.gety())||inversediagonalwincheck(player,act.getx(),act.gety());
}
//Check horizon lines
public boolean horizonwincheck(int player,int x) {
	for(int i=0;i<this.width-this.wincondition+1;i++) {
		for(int j=i;j<i+this.wincondition;j++) {
			if(grids[x*this.width+j]!=player) break;
			if(j==i+this.wincondition-1) return true;//If any combo from i to j matches the combo length, then win
		}
	}
	return false;
}
//Check vertical lines
public boolean verticalwincheck(int player,int y) {
	for(int i=0;i<this.height-this.wincondition+1;i++) {
		for(int j=i;j<i+this.wincondition;j++) {
			if(grids[j*this.width+y]!=player) break;
			if(j==i+this.wincondition-1) return true;//If any combo from i to j matches the combo length, then win
		}
	}
	return false;
}
//Check diagonal lines
public boolean diagonalwincheck(int player,int x,int y) {
	//Start point for the diagonal passing (x,y):(x-Math.min(x,y)),(y-Math.min(x,y)))
	for(int i=0;i<Math.min(this.height-(x-Math.min(x,y)),this.width-(y-Math.min(x,y)))-this.wincondition+1;i++) {
		for(int j=i;j<i+this.wincondition;j++) {
			if(grids[((x-Math.min(x,y))+j)*this.width+(y-Math.min(x,y))+j]!=player) break;
			if(j==i+this.wincondition-1) return true;//If any combo from i to j matches the combo length, then win
		}
	}
	return false;
}
//Check inverse diagonal lines
public boolean inversediagonalwincheck(int player,int x,int y) {
	//Start point for the inverse diagonal passing (x,y):(x-Math.min(x,this.width-y-1)),(y+Math.min(x,this.width-y-1)))
	for(int i=0;i<Math.min(this.height-(x-Math.min(x,this.width-y-1)),(y+Math.min(x,this.width-y-1)+1))-this.wincondition+1;i++) {
		for(int j=i;j<i+this.wincondition;j++) {
			if(grids[((x-Math.min(x,this.width-y-1))+j)*this.width+(y+Math.min(x,this.width-y-1))-j]!=player) break;
			if(j==i+this.wincondition-1) return true;//If any combo from i to j matches the combo length, then win
		}
	}
	return false;
}
}
