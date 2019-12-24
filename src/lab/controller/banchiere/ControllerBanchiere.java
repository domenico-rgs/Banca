package lab.controller.banchiere;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab.model.banca.Banca;
import lab.view.banchiere.BanchiereGUI;
import lab.view.banchiere.NewContoPanel;
import lab.view.banchiere.PanelOp;

public class ControllerBanchiere {
	private BanchiereGUI banchiere;
	private NewContoPanel pannelloNewConto;
	private PanelOp pannelloOp;
	private Banca banca;
	
	public ControllerBanchiere(BanchiereGUI banca, Banca banca1) {
		this.banca=banca1;
		pannelloNewConto = new NewContoPanel();
		pannelloOp = new PanelOp();
		banchiere=banca;
		initComponents();
	}
	
	public void initComponents() {
		ActionListener act1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banchiere.remove((((BorderLayout)banchiere.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				banchiere.getContentPane().add((pannelloNewConto).getPannelloNewConto(), BorderLayout.CENTER);
				banchiere.getContentPane().revalidate();
				banchiere.getContentPane().repaint();
			}
		};
		(banchiere.getNewConto()).addActionListener(act1);
		
		ActionListener act2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		(banchiere.getEsci()).addActionListener(act2);
		
		ActionListener act3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banchiere.remove((((BorderLayout)banchiere.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				banchiere.getContentPane().add((pannelloOp.getPannelloOp()), BorderLayout.CENTER);
				banchiere.getContentPane().revalidate();
				banchiere.getContentPane().repaint();

			}
		};
		(banchiere.getOperazioni()).addActionListener(act3);
		
		ActionListener act4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banchiere.remove((((BorderLayout)banchiere.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				banchiere.getLabelNan().setText("Saldo totale: "+((Double)banca.totaleSaldi()).toString());
				banchiere.getContentPane().add(banchiere.getLabelNan(), BorderLayout.CENTER);
				banchiere.getContentPane().revalidate();
				banchiere.getContentPane().repaint();
			}
		};
		(banchiere.getStampaSaldo()).addActionListener(act4);
		
		ActionListener act5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banchiere.remove((((BorderLayout)banchiere.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)));
				banchiere.getLabelNan().setText(banca.stampaConti());
				banchiere.getContentPane().add(banchiere.getLabelNan(), BorderLayout.CENTER);
				banchiere.getContentPane().revalidate();
				banchiere.getContentPane().repaint();
			}
		};
		(banchiere.getStampaConti()).addActionListener(act5);

		
	}

	public NewContoPanel getPannelloNewConto() {
		return pannelloNewConto;
	}

	public PanelOp getPannelloOp() {
		return pannelloOp;
	}
	
}
