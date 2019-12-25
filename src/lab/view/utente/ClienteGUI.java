package lab.view.utente;

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
 * Interfaccia grafica per le operazioni sui conti web effettuate da un cliente
 * permette di modificare CW, visualizzarne lo stato e effettuare operazioni su di esso
 * @author Domenico
 *
 */
@SuppressWarnings("serial")
public class ClienteGUI extends JFrame {
		//attributi usati per la parte di controllo
		private JMenuItem login;
		private JMenuItem esci;
		private JMenuItem operazioni;
		private JMenuItem cambio;
		private JMenuItem visualizzaInfo;
		private JTextPane labelNan;
		private JMenuItem logout;
		
		public ClienteGUI() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			setSize(600,400);
			setResizable(false);
			setLocationRelativeTo(null);
			setIconImage(kit.getImage("assets/icon.png"));
			setTitle("Cliente");
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			//menu superiore
			JMenuBar menuCliente = new JMenuBar();
			JMenu conto = new JMenu("Gestione Conto"); //voce principale 1
			login = new JMenuItem("Login");
			logout = new JMenuItem("Logout");
			operazioni = new JMenuItem("Operazioni sul conto");
			cambio = new JMenuItem("Cambia password");
			esci = new JMenuItem("Esci");
			JSeparator sep = new JSeparator();
			JSeparator sep2 = new JSeparator();
			conto.add(login);
			conto.add(logout);
			conto.add(sep);
			conto.add(operazioni);
			conto.add(cambio);
			conto.add(sep2);
			conto.add(esci);
			menuCliente.add(conto);
			
			JMenu info = new JMenu("Informazioni Conto"); //voce principale 2
			visualizzaInfo = new JMenuItem("Visualizza Informazioni Conto");
			info.add(visualizzaInfo);
			menuCliente.add(info);
			
			getContentPane().add(menuCliente, BorderLayout.NORTH);
			
			//label usata per la visualizzazione delle informazioni sul conto
			labelNan = new JTextPane();
			labelNan.setEditable(false);
			
			JLabel label = new JLabel("Banca 3.0 - Interfaccia Cliente");
			label.setFont(new Font("Arial", Font.BOLD, 20));
			label.setHorizontalAlignment(JLabel.CENTER);
			add(label, BorderLayout.CENTER);
			
			validate();
		}
		
		public JMenuItem getLogin() {
			return login;
		}
		
		public JMenuItem getEsci() {
			return esci;
		}

		public JMenuItem getOperazioni() {
			return operazioni;
		}

		public JMenuItem getVisualizzaInfo() {
			return visualizzaInfo;
		}

		public JTextPane getLabelNan() {
			return labelNan;
		}
		
		public JMenuItem getLogout() {
			return logout;
		}

		public JMenuItem getCambio() {
			return cambio;
		}
	}
