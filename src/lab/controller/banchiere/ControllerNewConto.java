package lab.controller.banchiere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import lab.model.banca.Banca;
import lab.model.banca.conti.Conto;
import lab.model.banca.conti.ContoType;
import lab.view.banchiere.NewContoPanel;

/**
 * Controller per il pannello dei nuovi conti
 * @author Domenico
 *
 */
public class ControllerNewConto {
	private NewContoPanel pannelloNuovoConto;
	private ContoType type;
	private Banca banca;
	
	public ControllerNewConto(NewContoPanel panel, Banca banca) {
		type=ContoType.CORRENTE;
		pannelloNuovoConto=panel;
		this.banca=banca;
		initComponent(); //inizializzazione dei componenti
	}
	
	private void initComponent() {
		//creazione nuovo conto (tasto "apri conto")
		ActionListener act1 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Conto conto1=banca.aggiungiConto(pannelloNuovoConto.getNome().getText(), pannelloNuovoConto.getCognome().getText(), pannelloNuovoConto.getCf().getText(), type);
					String esito;
					if(conto1!=null)
						esito="Conto creato correttamente!  -  Iban: "+conto1.getIban();
					else
						esito="Errore nella creazione del conto";
					pannelloNuovoConto.getInfo().setText(esito);
					pannelloNuovoConto.revalidate();
					pannelloNuovoConto.repaint();
				}		
		};
		pannelloNuovoConto.getSave().addActionListener(act1);
		
		ActionListener act2 = new ActionListener() {
			//gestione radio button conto corrente
			public void actionPerformed(ActionEvent e) {
				pannelloNuovoConto.getTipoCC().setSelected(false);
				pannelloNuovoConto.getTipoCD().setSelected(true);
				type=ContoType.CORRENTE; //setto il tipo di conto
			}			
		};
		pannelloNuovoConto.getTipoCD().addActionListener(act2);
		
		ActionListener act3 = new ActionListener() {
			//gestione radio button conto deposito
			public void actionPerformed(ActionEvent e) {
				pannelloNuovoConto.getTipoCC().setSelected(true);
				pannelloNuovoConto.getTipoCD().setSelected(false);
				type=ContoType.DEPOSITO; //setto tipo di conto
			}			
		};
		pannelloNuovoConto.getTipoCC().addActionListener(act3);
		
		ActionListener act7 = new ActionListener() {
			//gestione radio button conto web
			public void actionPerformed(ActionEvent e) {
				pannelloNuovoConto.getTipoCC().setSelected(false);
				pannelloNuovoConto.getTipoCD().setSelected(false);
				pannelloNuovoConto.getTipoWeb().setSelected(true);
				type=ContoType.WEB; //setto tipo di conto
			}			
		};
		pannelloNuovoConto.getTipoWeb().addActionListener(act7);
		
		//Aggiungo focus listener ai campi di testo
		//così eliminio ciò che c'è già quando gli clicco sopra
		FocusListener act4 = new FocusListener() {
			public void focusGained(FocusEvent e) {
				pannelloNuovoConto.getNome().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {		
			}			
		};
		pannelloNuovoConto.getNome().addFocusListener(act4);
		
		FocusListener act5 = new FocusListener() {
			public void focusGained(FocusEvent e) {
				pannelloNuovoConto.getCognome().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}			
		};
		pannelloNuovoConto.getCognome().addFocusListener(act5);

		FocusListener act6 = new FocusListener() {
			public void focusGained(FocusEvent e) {
				pannelloNuovoConto.getCf().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
			}			
		};
		pannelloNuovoConto.getCf().addFocusListener(act6);
	}
}
