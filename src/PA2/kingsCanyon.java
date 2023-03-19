package PA2;
//Subclass for a mountainmap, more blockers, less market
public class kingsCanyon extends map{
	public kingsCanyon(int width, int height) {
		this.width=width;
		this.height=height;
		grids=new char[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				double x=Math.random();
				if(i==(height-1)/2&j==(width-1)/2) grids[i][j]='P';
				else if(x<0.3) grids[i][j]='I';
				else if(x<0.35) grids[i][j]='M';
				else grids[i][j]=' ';
			}
		}
	}
	public kingsCanyon() {
		this(15,15);
		this.monsterindex=0.2;
	}
}
