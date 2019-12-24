package lab.view.utente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JPanel {
	
	private JPanel pannelloLogin;
	private JButton conferma;
	private JTextField input;
	private JPasswordField input2;
	private JLabel info;
	
	public Login() {
		setSize(300,200);
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new FlowLayout());
		
		JLabel iban = new JLabel("Inserisci dati");
		iban.setHorizontalAlignment(JLabel.CENTER);
		input = new JTextField("IBAN");
		input.setPreferredSize(new Dimension(100,20));
		input2 = new JPasswordField("Password");
		input2.setPreferredSize(new Dimension(100,20));
		pannello.add(iban);
		pannello.add(input);
		pannello.add(input2);
		pannello.setPreferredSize(new Dimension(300,150));
		pannelloLogin = new JPanel();
		pannelloLogin.setLayout(new BorderLayout());
		pannelloLogin.add(pannello,BorderLayout.NORTH);
		conferma = new JButton("Login");
		conferma.setPreferredSize(new Dimension(50,30));
		pannelloLogin.add(conferma, BorderLayout.CENTER);
		info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setPreferredSize(new Dimension(300,150));
		pannelloLogin.add(info, BorderLayout.SOUTH);
	}
	
	public JPanel getPannello() {
		return pannelloLogin;
	}

	public JButton getConferma() {
		return conferma;
	}

	public JTextField getInput() {
		return input;
	}

	public JPasswordField getInput2() {
		return input2;
	}

	public JLabel getInfo() {
		return info;
	}

}
