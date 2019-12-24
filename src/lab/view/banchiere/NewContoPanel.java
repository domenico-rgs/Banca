package lab.view.banchiere;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewContoPanel extends JPanel {
	private JPanel pannelloNewConto;
	private JTextField nome;
	private JTextField cognome;
	private JTextField cf;
	private JButton save;
	private JRadioButton tipoCC;
	private JRadioButton tipoCD;
	private JRadioButton tipoWeb;
	private JLabel info;
	
	public NewContoPanel() {
		pannelloNewConto = new JPanel();
		pannelloNewConto.setLayout(new GridLayout(11,1));
		JLabel insert = new JLabel("Compila i seguenti campi");
		insert.setHorizontalAlignment(JLabel.CENTER);
		nome = new JTextField("Nome");
		nome.setPreferredSize(new Dimension(100,50));
		cognome = new JTextField("Cognome");
		cognome.setPreferredSize(new Dimension(100,50));
		cf = new JTextField("Codice Fiscale");
		cf.setPreferredSize(new Dimension(100,50));
		pannelloNewConto.add(insert);
		pannelloNewConto.add(nome);
		pannelloNewConto.add(cognome);
		pannelloNewConto.add(cf);
		
		JLabel tipoConto = new JLabel("Tipo Conto:");
		tipoCC = new JRadioButton("Corrente");
		tipoCC.setSelected(true);
		tipoCC.setPreferredSize(new Dimension(50,20));
		tipoCD = new JRadioButton("Deposito");
		tipoCD.setPreferredSize(new Dimension(50,20));
		tipoWeb = new JRadioButton("Web");
		tipoWeb.setPreferredSize(new Dimension(50,20));
		pannelloNewConto.add(tipoConto);
		pannelloNewConto.add(tipoCC);
		pannelloNewConto.add(tipoCD);
		pannelloNewConto.add(tipoWeb);
		
		save = new JButton("Apri Conto");
		pannelloNewConto.add(save);
		
		info = new JLabel();
		pannelloNewConto.add(info);


	}

	
	public JTextField getNome() {
		return nome;
	}


	public JTextField getCognome() {
		return cognome;
	}


	public JTextField getCf() {
		return cf;
	}

	public JButton getSave() {
		return save;
	}


	public JPanel getPannelloNewConto() {
		return pannelloNewConto;
	}


	public JRadioButton getTipoCC() {
		return tipoCC;
	}


	public JRadioButton getTipoCD() {
		return tipoCD;
	}


	public JLabel getInfo() {
		return info;
	}


	public JRadioButton getTipoWeb() {
		return tipoWeb;
	}
	
}
