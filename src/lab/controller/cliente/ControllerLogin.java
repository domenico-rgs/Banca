package lab.controller.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab.model.banca.Banca;
import lab.model.banca.conti.Conto;
import lab.model.banca.conti.ContoWeb;
import lab.view.utente.Login;
import lab.view.utente.NewPass;

/**
 * Controller per il pannello di login
 * @author Domenico
 *
 */
public class ControllerLogin {
	private Login login;
	private Banca banca;
	private ControllerCliente ctrl;
	
	public ControllerLogin(Login login, Banca banca, ControllerCliente ctrl) {
		this.banca = banca;
		this.login = login;
		this.ctrl=ctrl; //necessito del controller cliente per importare l'iban usato per visualizzare le informazioni e cambiare la password
		initComponents();
	}
	
	/**
	 * Il listener prova a effettuare il login
	 * se è la prima volta apre la finestra per il cambio password
	 * altrimenti effettua il login comunicando il relativo successo/insuccesso nella label apposita
	 */
	private void initComponents() {
		ActionListener act1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conto c = banca.getConto(login.getInput().getText());
				if(c instanceof ContoWeb) {
					if(((ContoWeb) c).getFirstLogin() && ((ContoWeb)c).getPassword().equals("changeme")) {
							NewPass nuova = new NewPass((ContoWeb)c);
							nuova.setVisible(true);
					}else {
						((ContoWeb) c).login(((new String((login.getInput2()).getPassword()))));
						ctrl.setIban(login.getInput().getText());
						login.getInfo().setText("Login effettuato");
					}
				}else {
					login.getInfo().setText("Non è stato trovato alcun conto web corrispondente");
					login.getInfo().revalidate();
				}	
			}
		};
		(login.getConferma()).addActionListener(act1);
	}
	
}
