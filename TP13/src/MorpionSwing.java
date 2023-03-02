import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/** Programmation d'un jeu de Morpion avec une interface graphique Swing.
  *
  * REMARQUE : Dans cette solution, le patron MVC n'a pas été appliqué !
  * On a un modèle (?), une vue et un contrôleur qui sont fortement liés.
  *
  * @author	Xavier Crégut
  * @version	$Revision: 1.4 $
  */

public class MorpionSwing {

	// les images à utiliser en fonction de l'état du jeu.
	private static final Map<ModeleMorpion.Etat, ImageIcon> images
		= new HashMap<ModeleMorpion.Etat, ImageIcon>();
	static {
		images.put(ModeleMorpion.Etat.VIDE, new ImageIcon("blanc.jpg"));
		images.put(ModeleMorpion.Etat.CROIX, new ImageIcon("croix.jpg"));
		images.put(ModeleMorpion.Etat.ROND, new ImageIcon("rond.jpg"));
	}

// Choix de réalisation :
// ----------------------
//
//  Les attributs correspondant à la structure fixe de l'IHM sont définis
//	« final static » pour montrer que leur valeur ne pourra pas changer au
//	cours de l'exécution.  Ils sont donc initialisés sans attendre
//  l'exécution du constructeur !

	private ModeleMorpion modele;	// le modèle du jeu de Morpion

//  Les éléments de la vue (IHM)
//  ----------------------------

	/** Fenêtre principale */
	private JFrame fenetre;

	/** Bouton pour quitter */
	private final JButton boutonQuitter = new JButton("Q");

	/** Bouton pour commencer une nouvelle partie */
	private final JButton boutonNouvellePartie = new JButton("N");

	/** Cases du jeu */
	private final JLabel[][] cases = new JLabel[3][3];

	/** Zone qui indique le joueur qui doit jouer */
	private final JLabel joueur = new JLabel();


// Le constructeur
// ---------------

	/** Construire le jeu de morpion */
	public MorpionSwing() {
		this(new ModeleMorpionSimple());
	}

	/** Construire le jeu de morpion */
	public MorpionSwing(final ModeleMorpion modele) {
		// Initialiser le modèle
		this.modele = modele;

		// Créer les cases du Morpion
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				// Creer la case blanche
				this.cases[i][j] = new JLabel();
			}
		}

		// Initialiser le jeu
		this.recommencer();

		// Construire la vue (présentation)
		//	Définir la fenêtre principale
		this.fenetre = new JFrame("Morpion");
		this.fenetre.setLocation(100, 200);

		// Construire le contrôleur (gestion des événements)
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Définir le layout de la fenêtre
		Container contentPane = this.fenetre.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// Ajouter le menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Jeu");
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("Nouvelle partie");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recommencer();
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Quitter");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
		this.fenetre.setJMenuBar(menuBar);

		// Créer la zone de jeu
		JPanel jeu = new JPanel();
		jeu.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				jeu.add(this.cases[i][j]);
			}
		}
		contentPane.add(jeu, BorderLayout.CENTER);

		// Ajouter des listeners sur les cases
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				final int ii = i;
				final int jj = j;
				this.cases[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// Cocher la case
						try {
							modele.cocher(ii, jj);
							// Mettre à jour l'affichage
							cases[ii][jj].setIcon(joueur.getIcon());
							// Vérifier si la partie est terminée
							if (modele.estTerminee()) {
								// Afficher le gagnant
								JOptionPane.showMessageDialog(fenetre,"Le gagnant est " + modele.getJoueur());
								// Recommencer une partie
								recommencer();
							} else {
								// Mettre à jour l'affichage
								joueur.setIcon(images.get(modele.getJoueur()));
							}
						} catch (CaseOccupeeException ex) {
							throw new RuntimeException(ex);
						}
					}
				});
			}
		}

		// Ajouter les boutons
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(1, 3));
		boutons.add(this.boutonNouvellePartie);
		boutons.add(this.joueur);
		boutons.add(this.boutonQuitter);
		contentPane.add(boutons, BorderLayout.SOUTH);

		// afficher la fenêtre
		this.fenetre.pack();			// redimmensionner la fenêtre
		this.fenetre.setVisible(true);	// l'afficher
	}

// Quelques réactions aux interactions de l'utilisateur
// ----------------------------------------------------

	/** Recommencer une nouvelle partie. */
	public void recommencer() {
		this.modele.recommencer();

		// Vider les cases
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j].setIcon(images.get(this.modele.getValeur(i, j)));
			}
		}

		// Mettre à jour le joueur
		joueur.setIcon(images.get(modele.getJoueur()));
	}



// La méthode principale
// ---------------------

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Set style to windows style
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				new MorpionSwing();
			}
		});
	}

}
