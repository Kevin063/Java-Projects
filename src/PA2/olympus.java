package PA2;
//Subclass for a plainmap, less monster, smaller map but better resources.
public class olympus extends map{
	public olympus(int width, int height) {
		this.width=width;
		this.height=height;
		grids=new char[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				double x=Math.random();
				if(i==(height-1)/2&j==(width-1)/2) grids[i][j]='P';
				else if(x<0.1) grids[i][j]='I';
				else if(x<0.2) grids[i][j]='M';
				else grids[i][j]=' ';
			}
		}
	}
	public olympus() {
		this(10,10);
		this.monsterindex=0.1;
	}
}
