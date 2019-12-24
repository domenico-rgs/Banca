package lab.view.banchiere;

import lab.controller.banchiere.ControllerBanchiere;
import lab.controller.banchiere.ControllerNewConto;
import lab.controller.banchiere.ControllerPannelloOp;
import lab.model.banca.Banca;

public class Tester {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Banca banca = new Banca("Poste",10,"0001"); //creazione banca

		BanchiereGUI test = new BanchiereGUI();
		test.setVisible(true);
		
		ControllerBanchiere ctrl = new ControllerBanchiere(test, banca);
		ControllerNewConto ctrlConto = new ControllerNewConto(ctrl.getPannelloNewConto(),banca);
		ControllerPannelloOp ctrlOp = new ControllerPannelloOp(ctrl.getPannelloOp(),banca);
	}
}
