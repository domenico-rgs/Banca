package lab.model.banca;

import lab.controller.banchiere.ControllerBanchiere;
import lab.controller.banchiere.ControllerNewConto;
import lab.controller.banchiere.ControllerPannelloOp;
import lab.controller.cliente.ControllerCliente;
import lab.controller.cliente.ControllerLogin;
import lab.controller.cliente.FocusList;
import lab.view.banchiere.BanchiereGUI;
import lab.view.utente.ClienteGUI;

/**
 * Programma per la gestione dei conti di una banca
 * @author domenico
 * @version 3.0
 */

public class Main {
		
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Banca banca = new Banca("Poste",10,"0001"); //creazione banca

		BanchiereGUI test = new BanchiereGUI();
		test.setVisible(true);
		
		ControllerBanchiere ctrl = new ControllerBanchiere(test, banca);
		ControllerNewConto ctrlConto = new ControllerNewConto(ctrl.getPannelloNewConto(),banca);
		ControllerPannelloOp ctrlOp = new ControllerPannelloOp(ctrl.getPannelloOp(),banca);

		ClienteGUI testCliente = new ClienteGUI();
		testCliente.setVisible(true);
		
		ControllerCliente ctrlCliente = new ControllerCliente(testCliente, banca);
		ControllerLogin ctrlLog = new ControllerLogin(ctrlCliente.getLogin(),banca, ctrlCliente);
		ControllerPannelloOp ctrlOpCliente = new ControllerPannelloOp(ctrlCliente.getPannelloOp(),banca);
		FocusList focus = new FocusList(ctrlCliente.getLogin());

	}
}
