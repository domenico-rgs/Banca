package lab.controller.banchiere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import lab.model.banca.Banca;
import lab.view.banchiere.PanelOp;

public class ControllerPannelloOp {
	private PanelOp pannelloOp;
	private Banca banca;
	
	public ControllerPannelloOp(PanelOp panel, Banca banca) {
		pannelloOp=panel;
		this.banca=banca;
		initComponent();
	}
	
	public void initComponent() {
		ActionListener act1 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String result;
					if (banca.operazione(pannelloOp.getIban().getText().trim(),Double.parseDouble(pannelloOp.getAmmontare().getText().trim())))
						result="Operazione effettuata correttamente";
					else
						result="Operazione non effettuata";
					
					pannelloOp.getInfo().setText(result);
				}		
		};
		pannelloOp.getConferma().addActionListener(act1);
		
		FocusListener act4 = new FocusListener() {
			public void focusGained(FocusEvent e) {
				pannelloOp.getAmmontare().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}			
		};
		pannelloOp.getAmmontare().addFocusListener(act4);
		
		FocusListener act5 = new FocusListener() {
			public void focusGained(FocusEvent e) {
				pannelloOp.getIban().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}			
		};
		pannelloOp.getIban().addFocusListener(act5);

	}
}
