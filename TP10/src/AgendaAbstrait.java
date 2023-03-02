/**
 * AgendaAbstrait factorise la définition du nom et de l'accesseur associé.
 */
public abstract class AgendaAbstrait extends ObjetNomme implements Agenda {

	/**
	 * Initialiser le nom de l'agenda.
	 *
	 * @param nom le nom de l'agenda
	 * @throws IllegalArgumentException si nom n'a pas au moins un caractère
	 */
	public AgendaAbstrait(String nom) throws IllegalArgumentException {
		super(nom);
		if(nom == null ) {
			throw new IllegalArgumentException();
		}
		if (nom.length() == 0) {
			throw new IllegalArgumentException();
		}
	
	}
	
	/**
	 * Verifie si le creneau est valide
	 * @param numéro du créneau
	 * @throws IllegalArgumentException si le creneau n'est pas compris entre 1 et 366 
	 */
	public void verifierCreneau (int creneau) throws IllegalArgumentException {
		if (creneau < 1 || creneau > 366) {
			throw new IllegalArgumentException("Le numéro du créneau est incorrect il doit être comrpis entre 1 et 366");
		}
		
	
	}

}
