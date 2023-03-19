package PA2;
//Subclass for a circle map, the map is surrounded by Inaccessible spaces
public class stormPoint extends map{
	public stormPoint(int width, int height) {
		this.width=width;
		this.height=height;
		grids=new char[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				double x=Math.random();
				if(Math.pow((i-(height-1)/2),2)+Math.pow((j-(width-1)/2),2)>Math.pow((Math.min(width/2-1, height/2-1)),2)) grids[i][j]='I';
				else if(i==(height-1)/2&j==(width-1)/2) grids[i][j]='P';
				else if(x<0.05) grids[i][j]='I';
				else if(x<0.1) grids[i][j]='M';
				else grids[i][j]=' ';
			}
		}
	}
	public stormPoint() {
		this(15,15);
		this.monsterindex=0.5;
	}
}