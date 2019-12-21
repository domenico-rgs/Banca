package lab.conti;

import java.util.Scanner;

/**
 * Il conto web è come il conto corrente ma è possibile effettuare operazioni se è stato effettuato il login
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
	 * return true se è stato effettuato il login false altrimenti
	 */
	public boolean login(String password) {
		if(firstLogin) {
			firstLogin=isFirstLogin();
			return false;
		}
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
	 * @param oldPassword se corretto è l'utente giusto e può cambiarla
	 * @param newPassword nuova password da impostare
	 * @return true se la password è stata cambiata, false altrimenti
	 */
	public boolean setPassword(String oldPassword, String newPassword) {
		if(this.password.equals(oldPassword)) {
			this.password=newPassword;
			System.out.println("Password cambiata correttamente.");
			return true;
		}else {
			System.out.println("La vecchia password non è corretta.");
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
			System.out.println("Utente non connesso");
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
	 * @return false se non è il primo login e se la password viene cambiata correttamente
	 */
	public boolean isFirstLogin() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String oldPw, newPw;
		if(firstLogin) {
			System.out.println("E' il primo login, occorre cambiare la password");
			System.out.print("Vecchia password: ");
			oldPw=input.next();
			System.out.print("Nuova password: ");
			newPw=input.next();
			setPassword(oldPw, newPw);
			return false;
		}
		return false;
			
	}
	
	public String toString() {
		return getIban()+", saldo: "+getSaldo()+", tipo: Conto Web";
	}
	
}
