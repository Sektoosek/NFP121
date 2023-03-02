import java.lang.Math;
public class Point {
	private double x;
	private double y;

	
public Point(double abs , double y) {
	this.x = abs;
	this.y = y; 
	}

public void translater (double dx , double dy) {
	this.x += dx;
	this.y += dy;
}
public void afficher () {
	System.out.println(this.x+";"+this.y);
	
}

public void setX (double Newx) {
	this.x = Newx;
}

public double getModule() {
	return Math.sqrt(this.x);
	
}

}
