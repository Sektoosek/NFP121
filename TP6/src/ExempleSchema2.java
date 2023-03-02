import afficheur.Ecran;
public class ExempleSchema2 {
	public static void main (String [] args) {
		Ecran e = new Ecran("ExempleSchema2",600,400,20);
		e.dessinerAxes();
		PointNomme p1 = new PointNomme(3, 2, "A");
		PointNomme p2 = new PointNomme(6, 9, "S");
		Point p3 = new Point(11, 4);
		Segment s12 = new Segment(p1, p2);
		Segment s23 = new Segment(p2, p3);
		Segment s31 = new Segment(p3, p1);
		
		double sx = p1.getX() + p2.getX() + p3.getX();
		double sy = p1.getY() + p2.getY() + p3.getY();
		PointNomme barycentre = new PointNomme(sx / 3, sy / 3,"C");
		
		s12.dessiner(e);
		s23.dessiner(e);
		s31.dessiner(e);
		barycentre.dessiner(e);

	}
		
		

}
