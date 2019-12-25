package lab.model.banca.conti;

/**
 * Classe per la gestione di un conto.
 * Permette di creare un conto corrente, depositare e prelevare
 * @author domenico
 * @version 3.0
 */

public class ContoCorrente implements Conto, Comparable<Conto> {
	final private String iban;
	private String cf;
	private double saldo;
	
	/** Costruttore classe Conto 
	 * @param numeroConto numero progressivo conto
	 * @param cf codice fiscale
	 * @param radiceIban radice iban IT0001T0001
	 */
	public ContoCorrente(int numeroConto, String cf, String radiceIban) {
		this.iban=radiceIban+numeroConto;
		this.setCf(cf);
		saldo=0;
		}
	
	@Override
	public int compareTo(Conto c) {
		return this.cf.compareTo(c.getCf());
	}

	/** Metodo per la gestione del prelievo
	 * @param quantitaPrelievo quantità  da prelevare dal conto, se positivo non è un prelievo
	 * @return false o true a seconda che il prelievo avvenga correttamente
	 */
	protected boolean preleva(double quantitaPrelievo) {
		if(-quantitaPrelievo<saldo && quantitaPrelievo<=0) {
				saldo+=quantitaPrelievo; //prelievo indicato da numero negativo
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Metodo per la gestione del deposito
	 * @param quantitaDeposito quantità  da depositare, deve essere positiva
	 * @return false o true a seconda che il deposito avvenga correttamente
	 */
	protected boolean deposita(double quantitaDeposito){
		if(quantitaDeposito>=0) {
				saldo+=quantitaDeposito;
			return true ;
		}else {
			return false;
		}
	}

	/**
	* @param denaro ammontare di denaro da prelevare (negativo) o depositare (positivo)
	* @return true se l'operazione va a buon fine, false altrimenti
	*/
	@Override
	public boolean operazione(double denaro) {
		if(denaro<0) {
			return preleva(denaro);
		}else {
			return deposita(denaro);
		}
	}

	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getIban() {
		return iban.toUpperCase();
	}


	public String getCf() {
		return cf.toUpperCase();
	}


	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public String toString() {
		return getIban()+", saldo: "+getSaldo()+", tipo: Conto Corrente";
	}
	
}


