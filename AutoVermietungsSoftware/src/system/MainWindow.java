/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Nico Zahmel <Enjoy the flight>
 * @version 1.0
 */

public class MainWindow extends JFrame {

	// Variablendeklaration
	JLabel startText;
	JLabel endText;
	JButton bFahrzeugverwaltung, bKundenverwaltung, bVerfuegbarkeit;

	
	public MainWindow() {

		/*
		 *
		 * Initialisierung & Anpassung
		 *
		 */
		
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("Car Rental System for S.E. at THB");
		setSize(800, 600);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialisierung & Anpassung Gr��e - Start Text
		startText = new JLabel("Verwaltungsprogramm v 1.0");
		startText.setHorizontalAlignment(JLabel.CENTER);
		startText.setVerticalAlignment(JLabel.CENTER);

		// Definition der Schriftart
		Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
		startText.setFont(schriftartHeader); // legt die Schriftart fest.

		// F�hrt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		startText.setOpaque(true);
		startText.setBackground(Color.gray);

		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn oben.
		add(startText, BorderLayout.NORTH); // f�gt das Text-Label oben hinzu.

		// Die Mitte 'center' bekommt ein Panel mit eigenem GridLayout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		add(buttonPanel);

		// Black Frame um das ButtonPanel
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		buttonPanel.setBorder(border);

		// Initialisierung Buttons
		bFahrzeugverwaltung = new JButton("Fahrzeugverwaltung");
		bKundenverwaltung = new JButton("Kundenverwaltung");
		bVerfuegbarkeit = new JButton("Verf�gbarkeit");

		// Schriftart & Gr��e der Buttons
		Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);

		bFahrzeugverwaltung.setFont(schriftartButtons);
		bKundenverwaltung.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);

		bKundenverwaltung.setBounds(275, 70, 250, 100);
		bFahrzeugverwaltung.setBounds(275, 200, 250, 100);
		bVerfuegbarkeit.setBounds(275, 330, 250, 100);

		buttonPanel.add(bFahrzeugverwaltung);
		buttonPanel.add(bKundenverwaltung);
		buttonPanel.add(bVerfuegbarkeit);

		// Handler verleiht den Buttons seine Funktionalit�t.
		DerHandler handler = new DerHandler();
		// Bevor Klasse DerHandler erstellt und definiert wird,
		// ActionListener hinzuf�gen & handler als Objekt �bergeben.
		bFahrzeugverwaltung.addActionListener(handler); // ActionsListener passt auf, ob etwas passiert
		bKundenverwaltung.addActionListener(handler); // & wei�, was dann zu tun ist.
		bFahrzeugverwaltung.addActionListener(handler); // ActionsListener passt auf, ob etwas passiert
		bVerfuegbarkeit.addActionListener(handler);

		// Initialisierung & Anpassung Gr��e - Footer Text
		endText = new JLabel(
				"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");
		// endText.setHorizontalAlignment(JLabel.RIGHT);
		endText.setVerticalAlignment(JLabel.CENTER);
		endText.setHorizontalAlignment(JLabel.CENTER);

		// Definition der Schriftart
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 19);
		endText.setFont(schriftartFooter); // legt die Schriftart fest.

		// F�hrt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		endText.setOpaque(true);
		endText.setBackground(Color.RED);

		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn unten.
		add(endText, BorderLayout.SOUTH); // f�gt das Text-Label unten hinzu.

		// Swing Timer in Action - war ein Versuch, kann ignoriert werden.
		// final int labelwidth = 800;
		// final AtomicInteger labelPadding = new AtomicInteger();
		// Timer timer = new Timer(20, new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// endText.setBorder(new EmptyBorder(0, 0, 0, labelPadding.getAndIncrement()-
		// labelwidth));
		// }
		// });
		// timer.start();
	}

	
	private class DerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == bFahrzeugverwaltung) {
				// null positioniert die Meldung in der Mitte
				// danach folgt der Ausgabe-String
				JOptionPane.showMessageDialog(null, "Willkommen in der Fahrzeugverwaltung");
			} else if (event.getSource() == bKundenverwaltung) {
				JOptionPane.showMessageDialog(null, "Willkommen in der Kundenverwaltung");
			} else if (event.getSource() == bVerfuegbarkeit) {
				JOptionPane.showMessageDialog(null, "Willkommen im Verf�gbarkeits Check");
			}
		}
	}
}
