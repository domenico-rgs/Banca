package lab.controller.cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab.model.banca.Banca;
import lab.model.banca.conti.Conto;
import lab.model.banca.conti.ContoWeb;
import lab.view.banchiere.PanelOp;
import lab.view.utente.ClienteGUI;
import lab.view.utente.Login;
import lab.view.utente.Logout;
import lab.view.utente.NewPass;

/**
 * Controller per la gui del cliente
 * @author Domenico
 *
 */
public class ControllerCliente {
	private ClienteGUI cliente;
	private PanelOp pannelloOp;
	private Banca banca;
	private String iban;
	private Login login;
	
	public ControllerCliente(ClienteGUI cliente, Banca banca) {
		this.banca = banca;
		iban=null;
		this.cliente=cliente;
		pannelloOp=new PanelOp();
		login = new Login();
		initComponents(); //aggiunta listener
	}
	
	/**
	 * Creo i vari listener da aggiungere agli item del menu
	 * quelli che dovrebbero visualizzare un nuovo pannello eliminano inizialmente tutto quello che c'è nella posizione che dovrebbero occupare
	 */
	private void initComponents() {
		ActionListener act1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				cliente.getContentPane().add((pannelloOp).getPannelloOp(), BorderLayout.CENTER);
				cliente.getContentPane().revalidate();
				cliente.getContentPane().repaint();
			}
		};
		(cliente.getOperazioni()).addActionListener(act1);
		
		ActionListener act2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		(cliente.getEsci()).addActionListener(act2);
		
		ActionListener act3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logout logout = new Logout(banca);
				logout.setVisible(true);
			}
		};
		(cliente.getLogout()).addActionListener(act3);
		
		ActionListener act4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try { //se l'iban non è stato inizializzato potrebbe generare un eccezione
					cliente.getLabelNan().setText(banca.getConto(iban).toString());
				}catch(Exception ex) {
					System.out.println("Iban nullo");
				}
				finally {
				cliente.getContentPane().add(cliente.getLabelNan(), BorderLayout.CENTER);
				cliente.getContentPane().revalidate();
				cliente.getContentPane().repaint();
				}
			}
		};
		(cliente.getVisualizzaInfo()).addActionListener(act4);
		
		ActionListener act5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				cliente.getContentPane().add(login.getPannello(), BorderLayout.CENTER);
				cliente.getContentPane().revalidate();
				cliente.getContentPane().repaint();
			}
		};
		(cliente.getLogin()).addActionListener(act5);
		
		ActionListener act6 = new ActionListener() {
			Conto c=null;
			public void actionPerformed(ActionEvent e) {
				try { //se l'iban non è stato inizializzato potrebbe generare un eccezione
					c = banca.getConto(iban);
					if(c instanceof ContoWeb) {
						NewPass nuova = new NewPass((ContoWeb)c);
						nuova.setVisible(true);
					}
				}catch(Exception ex) {
						System.out.println("Iban nullo");
				}
					
			}
		};
		(cliente.getCambio()).addActionListener(act6);
	}

	private void clear() {
		cliente.remove((((BorderLayout)cliente.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}

	public Login getLogin() {
		return login;
	}

	public PanelOp getPannelloOp() {
		return pannelloOp;
	}
	
}
