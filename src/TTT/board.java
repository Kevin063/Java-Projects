package TTT;

import java.util.Arrays;

public class board {
private int width;
private int height;
private int[] grids;
//Default setting with 3x3
public board(){
	this(3,3);
}
//Constructor
public board(int a, int b) {
	width=a;
	height=b;
	grids=new int[width*height];
	Arrays.fill(grids, 0);//For clearance, actually don't need since the default is 0
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
}
