import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComprendreSwingTimer extends JPanel {

	final private JFrame fenetrePrincipale;
	final private JLabel nomTxt = new JLabel("Nom : ");
	{
		nomTxt.setHorizontalAlignment(JLabel.RIGHT);
	}
	final private JTextField nom = new JTextField(25);
	final private JButton bA = new JButton("A");
	final private JButton bB = new JButton("B");
	final private JButton bC = new JButton("C");
	final private JButton bQ = new JButton("Q");

	public ComprendreSwingTimer(JFrame fenetre) {
		super();
		this.fenetrePrincipale = fenetre;
		this.setLayout(new BorderLayout());

		JPanel boutonsABC = new JPanel(new FlowLayout());
		this.add(boutonsABC, BorderLayout.NORTH);
		boutonsABC.add(bA);
		boutonsABC.add(bB);
		boutonsABC.add(bC);

		JPanel centre = new JPanel(new GridLayout(1, 2));
		this.add(centre, BorderLayout.CENTER);
		centre.add(nomTxt);
		centre.add(nom);

		JPanel bas = new JPanel();
		this.add(bas, BorderLayout.SOUTH);
		bas.add(bQ);

		this.bQ.addActionListener(new ActionQuitter());

		ActionTrace trace = new ActionTrace();
		bA.addMouseListener(trace);
		bB.addMouseListener(trace);

		bC.addActionListener(new  ActionEffacer());

		// Armer un timer pour rendre visible la fen�tre toutes les 10 secondes
		new Timer(5 * 1000, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Timer d�clench�.");
				fenetrePrincipale.setVisible(true);
			}
		}).start();
		System.out.println("Timer arm�");
	}

	public class ActionEffacer implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			nom.setText("");
		}
	}

	public class ActionQuitter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			System.out.println("Quitter" + " " + fenetrePrincipale.getTitle());
			fenetrePrincipale.dispose();
		}
	}

	public class ActionTrace extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent ev) {
			System.out.println("Appui sur "
					+ fenetrePrincipale.getTitle() + "."
					+ ((JButton) ev.getSource()).getText());
		}

		@Override
		public void mouseEntered(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Entr�e dans "
					+ fenetrePrincipale.getTitle() + "."
					+ source.getText());
		}

		@Override
		public void mouseExited(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Sortie de "
					+ fenetrePrincipale.getTitle() + "."
					+ source.getText());
		}

	}

	public static JFrame newJFrame(String titre) {
		JFrame fenetre = new JFrame(titre);
		ComprendreSwingTimer comprendre = new ComprendreSwingTimer(fenetre);
		fenetre.getContentPane().add(comprendre);
		fenetre.pack();
		return fenetre;
	}


	public static void exemple1() {
		JFrame frame1 = newJFrame("Fen�tre1");
		JFrame frame2 = newJFrame("Fen�tre2");
		frame2.setLocation(300, 100);
		frame1.setVisible(true);
		frame2.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(ComprendreSwingTimer::exemple1);
			// On demande au fil d'ex�cutin de Swing d'ex�cuter la m�thode
			// exemple1 de la classe ComprendreSwingTimer.
		System.out.println("Fin du programme principal !");
	}

}
