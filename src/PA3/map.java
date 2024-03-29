package PA3;
//Class for the map generation and display
import java.util.Scanner;
public class map {
	protected int width;
	protected int height;
	protected char[][] grids;
	protected market[][] globalmarket;
	protected double monsterindex;
	protected int playerx;
	protected int playery;
	protected String maptype;
	protected int battlesize;
	protected double escapechance;
	public map(int width, int height) {
		this.width=width;
		this.height=height;
		grids=new char[height][width];
		globalmarket=new market[height][width];
	}
	public map() {
		this(10,10);
	}
	//Generate inventories in all markets in the worlds
	public void generateMarket() {
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				if(grids[i][j]=='M') globalmarket[i][j]=new market();
			}
		}
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
        System.out.print("\n");
    }
	public static map readmap() {
		IO.clearconsole();
	    int inChar;
	    System.out.println("Enter a map number to start the game");
	    IO.setGreen();
	    System.out.println("1. Olympus (Normal)");
	    IO.resetColor();
	    System.out.println("[Olympus is a peaceful city with adventurers and monsters. There's room to grow and thrive, but it's still a dangerous WORLD.]");
	    IO.setYellow();
	    System.out.println("2. Kings Canyon (Hard)");
	    IO.resetColor();
	    System.out.println("[Covered by countless rock roofs, adventurers come to Kings Canyon for treasures and golds.]");
	    IO.setRed();
	    System.out.println("3. Strom Point (Mars)");
	    IO.resetColor();
	    System.out.println("[The strom point is designed to be unfair. Huge threats will crash upon you without mercy. Only for players who want to struggle to survive.]");
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
        	map=new kingscanyon();
        	break;
        	}
        case("3"):{
        	map=new stormpoint();
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
	//Try to move in a direction
	public boolean move(String direction) {
	switch(direction) {
	case("W"):{
		if(playerx==0||grids[playerx-1][playery]=='I') {
		    IO.setYellow();
			System.out.println("You cannot pass there!");
		    IO.resetColor();
			return false;
		}
		else {
			if(globalmarket[playerx][playery]==null) grids[playerx][playery]=' ';//If leave a empty grid
			else grids[playerx][playery]='M';//If leave a market
			grids[playerx-1][playery]='P';
			playerx--;
			this.printMap();
			System.out.println("Your team moves.");
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
			if(globalmarket[playerx][playery]==null) grids[playerx][playery]=' ';//If leave a empty grid
			else grids[playerx][playery]='M';//If leave a market
			grids[playerx+1][playery]='P';
			playerx++;
			this.printMap();
			System.out.println("Your team moves.");
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
			if(globalmarket[playerx][playery]==null) grids[playerx][playery]=' ';//If leave a empty grid
			else grids[playerx][playery]='M';//If leave a market
			grids[playerx][playery-1]='P';
			playery--;
			this.printMap();
			System.out.println("Your team moves.");
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
			if(globalmarket[playerx][playery]==null) grids[playerx][playery]=' ';//If leave a empty grid
			else grids[playerx][playery]='M';//If leave a market
			grids[playerx][playery+1]='P';
			playery++;
			this.printMap();
			System.out.println("Your team moves.");
			return true;
		}
	}
	default: return false;
	}
	}
	//Check whether at a market
	public boolean marketcheck() {
	if(globalmarket[playerx][playery]!=null) {
			return true;
		}
	return false;
	}
	public double getmonsterindex() {
		return monsterindex;
	}
	public char getloc() {
		return grids[playerx][playery];
	}
	//Get the market standing on
	public market getMarket() {
		return globalmarket[playerx][playery];
	}
	//Get the maptype
	public String getMaptype() {
		return maptype;
	}
	//Get battle size
	public int getBattlesize() {
		return battlesize;
	}
	//Get chance to escape a battle
	public double getEscapeChance() {
		return this.escapechance;
	}
}
