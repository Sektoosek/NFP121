import java.awt.Color;
public class Cercle {
	private Point centre;
	private double rayon;
	private Color couleur;
	private double diametre;
	private Point p1;
	private Point p2;
	public static final double PI = Math.PI;
	
	public Cercle(Point centre, double rayon) {
		this.centre = centre;
		this.rayon = rayon;
		this.couleur= Color.BLUE;
	}
	public Cercle (Point p1 , Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.couleur=Color.BLUE;
	}
	
	
	public double getDiametre() {
		return diametre;
	}
	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}


	public Point getCentre() {
		return centre;
	}
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	public double getRayon() {
		return rayon;
	}
	public double rayon2 () {
		return 0.0;
	}
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	public double diametre () {
		return 2*this.rayon;
	}
	public void translater (double x, double y) {
		this.centre.translater(x, y);
	}
	public boolean contient (Point p) {
		return false;
	}
	public double perimetre () {
		return 2 * PI * rayon;
		
	}
	public double aire () {
		return PI* Math.pow(this.rayon,2.0);
	}
	public String toString () {
		return ("C"+ this.rayon + "@["+ this.centre.getX() + "," + this.centre.getY() + ")" );
		
	}
	
	
	
	


}
