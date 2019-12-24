package lab.view.banchiere;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelOp extends JPanel{
	private JPanel pannelloOp;
	private JTextField ammontare;
	private JTextField iban;
	private JLabel info;
	private JButton conferma;
	
	public PanelOp() {
		pannelloOp=new JPanel();
		pannelloOp.setLayout(new GridLayout(5,1));
		JLabel info1 = new JLabel("Inserisci ammontare positivo per deposito, negativo per prelievo");
		info1.setHorizontalAlignment(JLabel.CENTER);
		ammontare = new JTextField("Ammontare in euro");
		ammontare.setPreferredSize(new Dimension(50,20));
		iban = new JTextField("IBAN");
		ammontare.setPreferredSize(new Dimension(50,20));
		conferma = new JButton("Conferma operazioni");
		conferma.setPreferredSize(new Dimension(40,30));
		info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		
		pannelloOp.add(info1);
		pannelloOp.add(iban);
		pannelloOp.add(ammontare);
		pannelloOp.add(conferma);
		pannelloOp.add(info);
	}

	public JPanel getPannelloOp() {
		return pannelloOp;
	}

	public JTextField getAmmontare() {
		return ammontare;
	}

	public JTextField getIban() {
		return iban;
	}

	public JLabel getInfo() {
		return info;
	}

	public JButton getConferma() {
		return conferma;
	}
	
	
	
}
