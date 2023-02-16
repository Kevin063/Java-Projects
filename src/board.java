

import java.util.Arrays;

public class board {
private int width;
private int height;
private int[] grids;
//Constructor
public board(int a, int b) {
	width=a;
	height=b;
	grids=new int[width*height];
	Arrays.fill(grids, 0);//For clearance, actually don't need since the default is 0
}
public board() {
	this(IO.readheight(),IO.readwidth());
}
public int getheight() {
	return this.height;
}
public int gethwidth() {
	return this.width;
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
			case 3://For marking the winner combo
				output+="*";
				break;
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
	if (grids[act.getx()*width+act.gety()]!=0) return false;
	else return true;
}
//Execute the action
public boolean execute_action(action act,int player) {
	grids[act.getx()*width+act.gety()]=player;
	return wincheck(act,player);
}
//Check winning conditions
public boolean wincheck(action act,int player) {
	//Check four directions, the new grid put can be at any point of the three combo. so we need to check 12 pairs of grids at max!
	if(act.getx()>0&&act.getx()<height-1) if((grids[(act.getx()-1)*width+act.gety()]==player)&&(grids[(act.getx()+1)*width+act.gety()]==player)) {
		grids[(act.getx()-1)*width+act.gety()]=3;
		grids[(act.getx()+1)*width+act.gety()]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()<height-2) if((grids[(act.getx()+1)*width+act.gety()]==player)&&(grids[(act.getx()+2)*width+act.gety()]==player)) {
		grids[(act.getx()+1)*width+act.gety()]=3;
		grids[(act.getx()+2)*width+act.gety()]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()>1) if((grids[(act.getx()-1)*width+act.gety()]==player)&&(grids[(act.getx()-2)*width+act.gety()]==player)) {
		grids[(act.getx()-1)*width+act.gety()]=3;
		grids[(act.getx()-2)*width+act.gety()]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.gety()>0&&act.gety()<width-1) if((grids[(act.getx())*width+act.gety()-1]==player)&&(grids[(act.getx())*width+act.gety()+1]==player)) {
		grids[(act.getx())*width+act.gety()-1]=3;
		grids[(act.getx())*width+act.gety()+1]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.gety()<width-2) if((grids[(act.getx())*width+act.gety()+1]==player)&&(grids[(act.getx())*width+act.gety()+2]==player)) {
		grids[(act.getx())*width+act.gety()+1]=3;
		grids[(act.getx())*width+act.gety()+2]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.gety()>1) if((grids[(act.getx())*width+act.gety()-1]==player)&&(grids[(act.getx())*width+act.gety()-2]==player)) {
		grids[(act.getx())*width+act.gety()-1]=3;
		grids[(act.getx())*width+act.gety()-2]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()>0&&act.gety()>0&&act.getx()<height-1&&act.gety()<width-1) if(grids[(act.getx()-1)*width+act.gety()-1]==player&&grids[(act.getx()+1)*width+act.gety()+1]==player) {
		grids[(act.getx()-1)*width+act.gety()-1]=3;
		grids[(act.getx()+1)*width+act.gety()+1]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()>1&&act.gety()>1) if(grids[(act.getx()-1)*width+act.gety()-1]==player&&grids[(act.getx()-2)*width+act.gety()-2]==player) {
		grids[(act.getx()-1)*width+act.gety()-1]=3;
		grids[(act.getx()-2)*width+act.gety()-2]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()<height-2&&act.gety()<width-2) if(grids[(act.getx()+1)*width+act.gety()+1]==player&&grids[(act.getx()+2)*width+act.gety()+2]==player) {
		grids[(act.getx()+1)*width+act.gety()+1]=3;
		grids[(act.getx()+2)*width+act.gety()+2]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()>0&&act.gety()>0&&act.getx()<height-1&&act.gety()<width-1) if(grids[(act.getx()-1)*width+act.gety()+1]==player&&grids[(act.getx()+1)*width+act.gety()-1]==player) {
		grids[(act.getx()-1)*width+act.gety()+1]=3;
		grids[(act.getx()+1)*width+act.gety()-1]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.getx()>1&&act.gety()<width-2) if(grids[(act.getx()-1)*width+act.gety()+1]==player&&grids[(act.getx()-2)*width+act.gety()+2]==player) {
		grids[(act.getx()-1)*width+act.gety()+1]=3;
		grids[(act.getx()-2)*width+act.gety()+2]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	if(act.gety()>1&&act.getx()<height-2) if(grids[(act.getx()+2)*width+act.gety()-2]==player&&grids[(act.getx()+1)*width+act.gety()-1]==player) {
		grids[(act.getx()+2)*width+act.gety()-2]=3;
		grids[(act.getx()+1)*width+act.gety()-1]=3;
		grids[(act.getx())*width+act.gety()]=3;
		return true;
	}
	return false;//No win
}
}
