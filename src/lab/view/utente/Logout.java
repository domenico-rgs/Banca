package lab.view.utente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import lab.model.banca.Banca;
import lab.model.banca.conti.Conto;
import lab.model.banca.conti.ContoWeb;

/** 
 * Finestra semi-indipendente per la gestione del logout dal conto web
 * (implementazione non mvc)
 * @author Domenico
 *
 */
@SuppressWarnings("serial")
public class Logout extends JFrame implements ActionListener{
	private Banca banca; //necessario per la ricerca del conto
	private JTextField input;
	private JLabel info;
	
	public Logout(Banca banca) {
		this.banca = banca;
		Display();
	}
	
	public void Display() {
		setSize(300,150);
		setTitle("Logout");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new FlowLayout());
		
		JLabel iban = new JLabel("Inserisci iban:");
		input = new JTextField();
		input.setPreferredSize(new Dimension(100,20));
		pannello.add(iban);
		pannello.add(input);
		JButton log = new JButton("Logout");
		log.addActionListener(this);
		info = new JLabel(); //informazioni di servizio
		
		add(pannello, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		add(info, BorderLayout.SOUTH);

	}

	/**
	 * Listener per il logout, cerca il conto e se presente effettua l'operazione di logout
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Conto c2 = banca.getConto(input.getText().trim());
		if(c2 instanceof ContoWeb) {
			((ContoWeb) c2).logout();
			info.setText("Logout effettuato!");
		}else {
			info.setText("Non � stato trovato alcun conto web corrispondente");
		}		
	}
	
}
