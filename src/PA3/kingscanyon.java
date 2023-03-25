package PA3;
//Subclass for a mountainmap, more blockers, less market
public class kingscanyon extends map{
	public kingscanyon(int width, int height) {
		this.maptype="kingsCanyon";
		this.width=width;
		this.height=height;
		this.battlesize=3;
		grids=new char[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				double x=Math.random();
				if(x<0.3) grids[i][j]='I';
				else if(x<0.35) grids[i][j]='M';
				else grids[i][j]=' ';
			}
		}
		this.playerx=(height-1)/2;
		this.playery=(width-1)/2;
		grids[playerx][playery]='P';
	}
	public kingscanyon() {
		this(15,15);
		this.monsterindex=0.2;
	}
}
