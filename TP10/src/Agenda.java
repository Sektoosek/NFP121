public interface Agenda {

	/** Le plus petit crÃ©neau possible. */
	int CRENEAU_MIN = 1;

	/** Le plus grand crÃ©neau possible. */
	int CRENEAU_MAX = 366;

	/**
	 * Obtenir le nom de l'agenda.
	 * @return le nom de l'agenda
	 */
	String getNom();

	/**
	 * Enregistrer un rendez-vous dans cet agenda.
	 *
	 * @param creneau le crÃ©neau du rendez-vous
	 * @param rdv le rendez-vous
	 * @throws CreneauInvalideException si le crÃ©neau est invalide
	 * @throws IllegalArgumentException si nom vaut null
	 * @throws OccupeException si le crÃ©neau n'est pas libre
	 */
	void enregistrer(int creneau, String rdv) throws CreneauInvalideException,IllegalArgumentException,OccupeException;

	/**
	 * Annuler le rendez-vous pris Ã  une creneau donnÃ©e.
	 * Rien ne se passe si le crÃ©neau est libre.
	 * Retourne vrai si l'agenda est modifiÃ© (un rendez-vous est annulÃ©),
	 * faux sinon.
	 * 
	 * @param creneau crÃ©neau du rendez-vous Ã  annuler
	 * @return vrai si l'agenda est modifiÃ©
	 * @throws CreneauInvalideException si le crÃ©neau est invalide
	 */
	boolean annuler(int creneau) throws CreneauInvalideException;

	/**
	 * Obtenir le rendez-vous pris Ã  une creneau donnÃ©e.
	 * 
	 * @param creneau le crÃ©neau du rendez-vous
	 * @return le rendez-vous Ã  le crÃ©neau donnÃ©e
	 * @throw LibreException si pas de rendez-vous Ã  ce crÃ©neau
	 */
	String getRendezVous(int creneau) throws LibreException;

}
