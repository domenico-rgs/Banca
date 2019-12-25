package lab.model.banca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import lab.model.banca.conti.*;
import lab.model.persona.Persona;

/**
 * Classe per la gestione della banca.
 * Permette di creare la banca, aggiungere un conto, effettuare operazioni sul conto e calcolare il totale dei saldi
 * @author domenico
 * @version 3.0
 *
 */

public class Banca {
	private final String nomeBanca, radiceIban; //una volta impostati non possono essere modificati (modificatore final)
	private Map<String, Conto> conti;
	private HashSet<Persona> arrayPersone; //aggiunta al progetto
	
	/**
	 * * Costruttore classe conto
	 * Permette di definire la banca dato il nome, il numero massimo di conti possibili e un numero identificativo
	 * dal quale viene estratta la radice dell'iban
	 * @param nome nome cliente
	 * @param maxConti numero massimo conti per la banca
	 * @param numeroBanca codice identificativo della banca
	 */
	public Banca(String nome, int maxConti, String numeroBanca) {
		nomeBanca=nome;
		conti = new HashMap<String, Conto>();
		arrayPersone = new HashSet<Persona>();
		radiceIban="IT"+"0001"+"T"+numeroBanca; //iban formato da IT + cod. controllo + CIN + id. banca + numero conto
	}
	
	/**
	 * Metodo per l'aggiunta di un conto in banca
	 * @param cf codice fiscale
	 * @param nome nome cliente
	 * @param cognome cognome cliente
	 * @param type tipo di conto corrente: Deposito, Corrente, Web
	 * @return ritorna il conto creato oppure null se non è stato possibile generarlo
	 */
	public Conto aggiungiConto(String nome, String cognome, String cf, ContoType type) {
		Conto c = null;
		switch(type) {
		case DEPOSITO:
			c = new ContoDeposito(conti.size(), cf, radiceIban);
			break;
		case CORRENTE:
			c = new ContoCorrente(conti.size(), cf, radiceIban);
			break;
		case WEB:
			c = new ContoWeb(conti.size(), cf, radiceIban);
			break;
		}
		
		conti.put(c.getIban(), c);
		if((getPersona(c.getCf())==null))
			arrayPersone.add(new Persona(nome, cognome, cf));
		return c;
	}
	
	
	/**
	 * Ordinamento conti per saldo e poi per iban
	 * @return arraylist di conti ordinato
	 */
	public ArrayList<Conto> ordinamentoSaldoIban() {
		ArrayList<Conto> array = new ArrayList<Conto>(conti.values());
		array.sort(new ContoComparatorSI());
		return array;
	}
	
	/**
	 * Ordinamento conti per iban
	 * @return arraylist di conti ordinato
	 */
	public ArrayList<Conto> ordinamentoIban() {
		ArrayList<Conto> array = new ArrayList<Conto>(conti.values());
		array.sort(new ContoComparator());
		return array;
	}
	
	/**
	 * Funzione per ottenere un conto dato l'iban
	 * @param iban iban conto da cercare
	 * @return il conto o null se non è stato trovato
	 */
	public Conto getConto(String iban) {
		for(int i=0; i<conti.size(); i++) {
			if (conti.containsKey(iban))
				return conti.get(iban);
		}
		return null;
		
	}
	
	/**
	 * Funzione per ottere una persona dato il suo codice fiscale
	 * @param cf codice fiscale della persona
	 * @return la persona o null se non è stato trovato
	 */
	public Persona getPersona(String cf) {
		Iterator<Persona> i = arrayPersone.iterator();
		Persona p;
		while(i.hasNext()) {
			p=i.next();
			if(p.getCf().equalsIgnoreCase(cf))
				return p;
		}
		return null;
	}
	
	/**
	 * Calcolo del totale dei saldi dei conti in banca
	 * @return ritorna il totale dei saldi
	 */
	public double totaleSaldi() {
		double totSaldi=0;
		ArrayList<Conto> array = new ArrayList<Conto>(conti.values()); //converto i conti nella mappa in un arraylist così da poterli scandire e prendere il saldo
		for(int i=0; i<conti.size(); i++) {
			totSaldi+= (array.get(i)).getSaldo();
		}
		return totSaldi;
	}
	
	/**
	 * Metodo per effettuare le operazioni su un conto, richiamando i metodi della classe Conto
	 * @param iban iban conto
	 * @param denaro quantita di denaro da depositare (se positiva) o prelevare (se negativa)
	 * @return true o false a seconda che l'operazione avviene correttamente o meno
	 */
	public boolean operazione(String iban, double denaro) {
		if(conti.containsKey(iban))
				return conti.get(iban).operazione(denaro);
		return false;
	}

	/**
	 * Metodo per la stampa di tutti i conti della banca con relativi dati cliente
	 * @return ritorna la lista di tutti i conti in formato stringa
	 */
	public String stampaConti() {
		ArrayList<Conto> conti = new ArrayList<Conto>(getConti().values());
		HashSet<Persona> arrayPersone = getArrayPersone();
		Iterator<Persona> i = arrayPersone.iterator();
		Persona p;
		StringBuilder result = new StringBuilder();
		while(i.hasNext()) {
			p=i.next();
			result.append("Conti di "+p+":\n");
			for(int j=0; j<getNumeroContiAttivi(); j++) {
				if(p.getCf().equalsIgnoreCase(conti.get(j).getCf()))
					result.append(conti.get(j)+"\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
	
	public int getNumeroContiAttivi() {
		return conti.size();
	}

	public String getRadiceIban() {
		return radiceIban;
	}

	public Map<String, Conto> getConti() {
		return conti;
	}

	public HashSet<Persona> getArrayPersone() {
		return arrayPersone;
	}

	public String getNomeBanca() {
		return nomeBanca;
	}
}

