package lab.view.banchiere;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 * Interfaccia grafica per le operazioni sui conti effettuate da un banchiere
 * permette di modificare CC e visualizzarne lo stato e effettuare operazioni su di essi
 * @author Domenico
 *
 */
@SuppressWarnings("serial")
public class BanchiereGUI extends JFrame {
	//attributi usati nella parte di controller
	private JMenuItem newConto;
	private JMenuItem esci;
	private JMenuItem operazioni;
	private JMenuItem stampaSaldo;
	private JMenuItem stampaConti;
	private JTextPane labelNan;
	
	public BanchiereGUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(600,400);
		setResizable(false);
		setLocationRelativeTo(null); //finestra al centro dello schermo
		setIconImage(kit.getImage("assets/icon.png"));
		setTitle("Banchiere");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//creazione menu superiore
		JMenuBar menuBanchiere = new JMenuBar();
		JMenu conto = new JMenu("Gestione Conto"); //prima voce
		newConto = new JMenuItem("Nuovo Conto");
		operazioni = new JMenuItem("Operazioni sul conto");
		esci = new JMenuItem("Esci");
		JSeparator sep = new JSeparator();
		conto.add(newConto);
		conto.add(operazioni);
		conto.add(sep);
		conto.add(esci);
		menuBanchiere.add(conto);
		
		JMenu banca = new JMenu("Gestione Banca"); //seconda voce
		stampaSaldo = new JMenuItem("Stampa il saldo totale");
		stampaConti = new JMenuItem("Stampa la lista dei conti");
		banca.add(stampaSaldo);
		banca.add(stampaConti);
		menuBanchiere.add(banca);
		
		getContentPane().add(menuBanchiere, BorderLayout.NORTH);
		
		//label usata per la stampa del saldo e dei conti
		labelNan = new JTextPane();
		labelNan.setEditable(false); //solo visualizzazione
		
		JLabel label = new JLabel("Banca 3.0 - Interfaccia Banchiere");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.CENTER);
		
		validate();
		
	}
	
	public JMenuItem getNewConto() {
		return newConto;
	}
	
	public JMenuItem getEsci() {
		return esci;
	}


	public JMenuItem getOperazioni() {
		return operazioni;
	}


	public JMenuItem getStampaSaldo() {
		return stampaSaldo;
	}


	public JMenuItem getStampaConti() {
		return stampaConti;
	}


	public JTextPane getLabelNan() {
		return labelNan;
	}
}
