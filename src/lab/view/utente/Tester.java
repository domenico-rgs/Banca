package lab.view.utente;

import lab.controller.cliente.ControllerCliente;
import lab.controller.cliente.ControllerLogin;
import lab.model.banca.Banca;

public class Tester {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Banca banca = new Banca("Poste",10,"0001"); //creazione banca

		ClienteGUI test = new ClienteGUI();
		test.setVisible(true);
		
		ControllerCliente ctrl = new ControllerCliente(test, banca);
		ControllerLogin ctrlLog = new ControllerLogin(ctrl.getLogin(),banca, ctrl);
	}
}
