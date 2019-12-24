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
		initComponents();
	}
	
	public void initComponents() {
		ActionListener act1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.remove((((BorderLayout)cliente.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
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
				cliente.remove((((BorderLayout)cliente.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				try {
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
				cliente.remove((((BorderLayout)cliente.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				cliente.getContentPane().add(login.getPannello(), BorderLayout.CENTER);
				cliente.getContentPane().revalidate();
				cliente.getContentPane().repaint();
			}
		};
		(cliente.getLogin()).addActionListener(act5);
		
		ActionListener act6 = new ActionListener() {
			Conto c=null;
			public void actionPerformed(ActionEvent e) {
				try {
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
