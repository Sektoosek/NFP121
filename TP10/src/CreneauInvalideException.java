/**
 * CreneauInvalideException indique qu'une date n'est pas valide.
 */
public class CreneauInvalideException extends Exception {


	public CreneauInvalideException(String cause) {
		super(cause);
		System.out.println("La date n'est pas valide");
	}
	
	
}
