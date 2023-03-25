package PA3;
//Subclass for a plainmap, less monster, smaller map but better resources.
public class olympus extends map{
	public olympus(int width, int height) {
		this.maptype="olympus";
		this.width=width;
		this.height=height;
		this.battlesize=3;
		this.escapechance=0.5;
		grids=new char[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				double x=Math.random();
				if(x<0.1) grids[i][j]='I';
				else if(x<0.2) grids[i][j]='M';
				else grids[i][j]=' ';
			}
		}
		this.playerx=(height-1)/2;
		this.playery=(width-1)/2;
		grids[playerx][playery]='P';
	}
	public olympus() {
		this(10,10);
		this.monsterindex=0.1;
	}
}
