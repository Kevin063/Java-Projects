package PA3;
//Class for the map generation and display
import java.util.Scanner;
public class map {
	protected int width;
	protected int height;
	protected char[][] grids;
	protected double monsterindex;
	protected int playerx;
	protected int playery;
	public map(int width, int height) {
		this.width=width;
		this.height=height;
		grids=new char[height][width];
	}
	public map() {
		this(10,10);
	}
    public void printMap() {
    	// I got help from internet code source to complete the coloring part.
        int m = grids.length;
        int n = grids[0].length;
        // Print top border
        System.out.print("┏");
        for (int j = 0; j < n-1; j++) {
            System.out.print("━━━┳");
        }
        System.out.println("━━━┓");
        // Print map contents
        for (int i = 0; i < m; i++) {
            System.out.print("┃ ");
            for (int j = 0; j < n; j++) {
                // Set color based on character
                if (grids[i][j] == 'I') {
                    System.out.print("\033[0;31m"); // Red
                } else if (grids[i][j] == 'M'){
                    System.out.print("\033[0;32m"); // Green
                }
                else if (grids[i][j] == 'P'){
                    System.out.print("\033[0;35m"); // Purple
                }

                System.out.print(grids[i][j] + " ");
                System.out.print("\033[0m┃ ");
            }
            System.out.println();
            // Print separator between rows
            if (i != m - 1) {
                System.out.print("┣");
                for (int j = 0; j < n; j++) {
                    System.out.print("━━━╋");
                }
                System.out.println("");
            }
        }

        // Print bottom border
        System.out.print("┗");
        for (int j = 0; j < n; j++) {
            System.out.print("━━━┻");
        }
    }
	public static map readmap() {
		IO.clearconsole();
	    int inChar;
	    System.out.println("Enter a map number to start the game");
	    System.out.print("\033[0;32m");
	    System.out.println("1. Olympus");
	    System.out.print("\033[0;0m");
	    System.out.println("[Olympus is a peaceful city with adventurers and monsters. There's room to grow and thrive, but it's still a dangerous WORLD.]");
	    System.out.print("\033[0;33m");
	    System.out.println("2. Kings Canyon");
	    System.out.print("\033[0;0m");
	    System.out.println("[Covered by countless rock roofs, adventurers come to Kings Canyon for treasures and golds.]");
	    System.out.print("\033[0;31m");
	    System.out.println("3. Strom Point");
	    System.out.print("\033[0;0m");
	    System.out.println("The strom point is designed to be unfair. Huge threats will crash upon you without mercy. Only for players who want to struggle to survive.");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		System.out.flush();
		map map;
        switch(input) {
        case("1"):{
        	map=new olympus(); 
        	break;
        }
        case("2"):{
        	map=new kingsCanyon();
        	break;
        	}
        case("3"):{
        	map=new stormPoint();
        	break;
        }
        default:{
			System.out.println("Please input a valid map number!");
			return readmap();
        }
        }
        System.out.println("World generating...");
        try {
			Thread.sleep(1000);//Simulate the world generation....
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        map.printMap();
        System.out.println("\nThe world generation complete!");
        IO.pressEnterToContinue();
        return map;
	}
	public boolean move(String direction) {
	switch(direction) {
	case("W"):{
		if(playerx==0||grids[playerx-1][playery]=='I') {
		    System.out.print("\033[0;32m");
			System.out.println("You cannot pass there!");
		    System.out.print("\033[0;0m");
			return false;
		}
		else {
			playerx--;
			return true;
		}
	}
	case("S"):{
		if(playerx==height-1||grids[playerx+1][playery]=='I') {
		    System.out.print("\033[0;32m");
			System.out.println("You cannot pass there!");
		    System.out.print("\033[0;0m");
			return false;
		}
		else {
			playerx++;
			return true;
		}
	}
	case("A"):{
		if(playery==0||grids[playerx][playery-1]=='I') {
		    System.out.print("\033[0;32m");
			System.out.println("You cannot pass there!");
		    System.out.print("\033[0;0m");
			return false;
		}
		else {
			playery--;
			return true;
		}
	}
	case("D"):{
		if(playery==width-1||grids[playerx][playery+1]=='I') {
		    System.out.print("\033[0;32m");
			System.out.println("You cannot pass there!");
		    System.out.print("\033[0;0m");
			return false;
		}
		else {
			playery++;
			return true;
		}
	}
	default: return false;
	}
	}
	public double getmonsterindex() {
		return monsterindex;
	}
	public char getloc() {
		return grids[playerx][playery];
	}
}
