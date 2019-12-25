package lab.model.banca.conti;

/**
 * Il conto web è come il conto corrente ma è possibile effettuare operazioni se è stato effettuato il login
 * @author Domenico
 * @version 3.0
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
	 * return true se è stato effettuato il login false altrimenti
	 */
	public boolean login(String password) {
		if(this.password.equals(password))
			isLogged=true;
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
	 * @param oldPassword se corretto è l'utente giusto e può cambiarla
	 * @param newPassword nuova password da impostare
	 * @return true se la password è stata cambiata, false altrimenti
	 */
	public boolean setPassword(String oldPassword, String newPassword) {
		if(this.password.equals(oldPassword)) {
			this.password=newPassword;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	* Operazione da conto web, permesso solo se è stato effettuato il login
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
			return false;
		}
	}
	
	/**
	 * Controlla se è il primo login e restituisce lo stato di login
	 * @return true se è attivo il login
	 */
	public boolean isLogged() {
		return isLogged;
	}

	/**
	 * Gestione del primo login
	 * @param vecchiaPw vecchia password da sostituire
	 * @param nuovaPw nuova password sostituta
	 * @return false se non è il primo login e se la password viene cambiata correttamente
	 */
	public boolean isFirstLogin(String vecchiaPw, String nuovaPw) {
		if(firstLogin) {
			setPassword(vecchiaPw, nuovaPw);
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
