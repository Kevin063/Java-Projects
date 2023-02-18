import java.util.Scanner;
//User action and validation check for C4
public class C4action extends action{
	public C4action(board bd, int p) {
		super(p);
		Scanner s=new Scanner(System.in);
		while(true) {
		String input=s.nextLine();
		if(input.equals("quit")) {
			this.quit=true;
			break;
		}
		int y = Integer.parseInt(input);
		int x =0;
		if(y<0||y>bd.getwidth()-1) {
			System.out.println("Invaild format for the input! Please try again.");
			continue;
		}
		//Find the top of the column, if the column is full, reject the input
		for(x=bd.getheight()-1;x>=0;x--) {
			action act=new action(x,y,p);
			if (bd.vaild_action(act)) break;
		}
		action act=new action(x,y,p);
		if (!bd.vaild_action(act)) {
			System.out.println("The whole column is occupied yet! Please choose another location.");	
			continue;
		}
		this.x=x;
		this.y=y;
		break;
	}
}
}
