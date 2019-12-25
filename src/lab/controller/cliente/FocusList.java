package lab.controller.cliente;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import lab.view.utente.Login;

//focus listener per la finestra di login
//cos� che i campi vengano ripuliti al click del mouse
public class FocusList {
	private Login login;
	
	public FocusList(Login login) {
		this.login=login;
		initComponents();
	}
	
	private void initComponents() {
		FocusListener act1 = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				login.getInput().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		};
		(login.getInput()).addFocusListener(act1);
		
		FocusListener act2 = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				login.getInput2().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		};
		(login.getInput2()).addFocusListener(act2);
		
	}
}
