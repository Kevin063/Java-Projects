package PA12;
import java.util.Scanner;
//User action and validation check for TTT
public class TTTaction extends action{
	public TTTaction(board bd, int p) {
		super(p);
		Scanner s=new Scanner(System.in);
		while(true) {
		String input=s.nextLine();
		if(input.equals("quit")) {
			this.quit=true;
			break;
		}
		if(input.indexOf(",")==-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}//No "," in the input
		int x = Integer.parseInt(input.substring(0,input.indexOf(",")));
		int y = Integer.parseInt(input.substring(input.indexOf(",")+1));
		if(x<0||x>bd.getheight()-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		if(y<0||y>bd.getwidth()-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		action act=new action(x,y,p);
		if (!bd.vaild_action(act)) {
			System.out.println("The grid is occupied yet! Please choose another location.");	
			continue;
		}
		this.x=x;
		this.y=y;
		break;
	}
}
}
