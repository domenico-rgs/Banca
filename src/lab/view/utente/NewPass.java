package lab.view.utente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

import lab.model.banca.conti.ContoWeb;

/**
 * Finestra semi-indipendente per il cambio della password di un conto web
 * @author Domenico
 *
 */
@SuppressWarnings("serial")
public class NewPass extends JFrame implements ActionListener{
	private JPasswordField vecchiaPw;
	private JPasswordField nuovaPw;
	private JLabel info;
	private ContoWeb c;
	
	public NewPass(ContoWeb c) {
		this.c=c;
		Display();
	}
	
	public void Display() {
		setSize(300,200);
		setTitle("Cambio Password");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new GridLayout(4,1));
		
		JPanel pannello2 = new JPanel();
		pannello2.setLayout(new FlowLayout());
		
		JPanel pannello3 = new JPanel();
		pannello2.setLayout(new FlowLayout());
		
		JLabel vecchia = new JLabel("Vecchia password: ");
		vecchiaPw = new JPasswordField("password");
		//i focus listener cancellano il testo nel campo al click su di essi
		vecchiaPw.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				vecchiaPw.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}
			
		});
		vecchiaPw.setPreferredSize(new Dimension(100,20));
		pannello2.add(vecchia);
		pannello2.add(vecchiaPw);
		
		JLabel nuova = new JLabel("Nuova password: ");
		nuovaPw = new JPasswordField("password");
		nuovaPw.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				nuovaPw.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}
			
		});
		nuovaPw.setPreferredSize(new Dimension(100,20));
		pannello3.add(nuova);
		pannello3.add(nuovaPw);
		pannello.add(pannello2);
		pannello.add(pannello3);
		JButton cambia = new JButton("Cambia password");
		cambia.addActionListener(this);
		pannello.add(cambia);
		
		info = new JLabel(); //informazioni di servizio
		pannello.add(info);
		
		add(pannello);

	}

	public JPasswordField getVecchiaPw() {
		return vecchiaPw;
	}

	public JPasswordField getNuovaPw() {
		return nuovaPw;
	}

	public JLabel getInfo() {
		return info;
	}

	/**
	 * Listener per il tasto conferma
	 * Prende le password dai relativi cambi e prova a cambiare la password riportando il relativo successo
	 * o insuccesso nella label info
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(c.setPassword(new String(vecchiaPw.getPassword()), new String(nuovaPw.getPassword()))) {
			info.setText("Password modificata con successo");
			info.revalidate();
		}else {
			info.setText("Password non corrette");
			info.revalidate();
		}
	}
}
