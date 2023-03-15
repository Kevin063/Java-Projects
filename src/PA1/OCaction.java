package PA1;
import java.util.Scanner;
//User action and validation check for OC
public class OCaction extends action{
	public OCaction(board bd, int p) {
		Scanner s=new Scanner(System.in);
		while(true) {
		String input=s.nextLine();
		if(input.equals("quit")) {
			this.quit=true;
			break;
		}
		if(input.charAt(1)!=','||input.substring(2).indexOf(",")==-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}//No "," in the input
		int symbol;
		if(input.charAt(0)=='o'||input.charAt(0)=='O') symbol=1;
		else if(input.charAt(0)=='x'||input.charAt(0)=='X') symbol=2;
		else {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		int x = Integer.parseInt(input.substring(2).substring(0,input.substring(2).indexOf(",")));
		int y = Integer.parseInt(input.substring(2).substring(input.substring(2).indexOf(",")+1));
		if(x<0||x>bd.getheight()-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		if(y<0||y>bd.getwidth()-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		action act=new action(x,y,symbol);
		if (!bd.vaild_action(act)) {
			System.out.println("The grid is occupied yet! Please choose another location.");	
			continue;
		}
		this.x=x;
		this.y=y;
		this.player=symbol;
		break;
	}
}
}
