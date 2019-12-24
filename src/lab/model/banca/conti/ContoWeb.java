package lab.model.banca.conti;

/**
 * Il conto web � come il conto corrente ma � possibile effettuare operazioni se � stato effettuato il login
 * @author Domenico
 * @version 1.0
 */

public class ContoWeb extends ContoCorrente implements LoginObject{
	private boolean isLogged;
	private String password;
	private boolean firstLogin;
	
	/*
	 * Password di default = changeme
	 * firstLogin true indica che occorre cambiare la password al primo accesso
	 */
	public ContoWeb(int numeroConto, String cf, String radiceIban) {
		super(numeroConto, cf, radiceIban);
		password="changeme";
		firstLogin=true;
		isLogged=false;
	}
	
	/**
	 * Metodo per la gestione del login
	 * @param password password per il login nel conto
	 * return true se � stato effettuato il login false altrimenti
	 */
	public boolean login(String password) {
		if(this.password.equals(password)) {
			isLogged=true;
			System.out.println("Accesso effettuato!");
		}else
			System.out.println("Accesso non effettuato");
		return isLogged;
	}
	
	/**
	 * Effettua il logout dal conto web
	 * @return stato di login
	 */
	public boolean logout() {
		isLogged=false;
		return isLogged;
	}
	
	/**
	 * Cambio della password
	 * @param oldPassword se corretto � l'utente giusto e pu� cambiarla
	 * @param newPassword nuova password da impostare
	 * @return true se la password � stata cambiata, false altrimenti
	 */
	public boolean setPassword(String oldPassword, String newPassword) {
		if(this.password.equals(oldPassword)) {
			this.password=newPassword;
			System.out.println("Password cambiata correttamente.");
			return true;
		}else {
			System.out.println("La vecchia password non � corretta.");
			return false;
		}
	}
	
	/**
	* Operazione da conto web, permesso solo se � stato effettuato il login
	* @param denaro ammontare di denaro da prelevare (negativo) o depositare (positivo)
	* @return true se l'operazione va a buon fine, false altrimenti
	*/
	@Override
	public boolean operazione(double denaro) {
		if(isLogged) {
			if(denaro<0) {
				return preleva(denaro);
			}else {
				return deposita(denaro);
			}
		}else {
			System.out.println("Utente non connesso");
			return false;
		}
	}
	
	/**
	 * Controlla se � il primo login e restituisce lo stato di login
	 * @return true se � attivo il login
	 */
	public boolean isLogged() {
		return isLogged;
	}

	/**
	 * Gestione del primo login
	 * @return false se non � il primo login e se la password viene cambiata correttamente
	 */
	public boolean isFirstLogin(String vecchiaPw, String NuovaPw) {
		if(firstLogin) {
			setPassword(vecchiaPw, NuovaPw);
			firstLogin=false;
		}
		return false;
			
	}
	
	public boolean getFirstLogin() {
		return firstLogin;
	}
	
	public String getPassword() {
		return password;
	}

	public String toString() {
		return getIban()+", saldo: "+getSaldo()+", tipo: Conto Web";
	}
	
}
