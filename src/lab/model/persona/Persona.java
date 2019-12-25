package lab.model.persona;

/**
 * Classe per la gestione dei proprietari di un conto
 * @author domenico
 * @version 3.0
 */

public class Persona {
	private String nome, cognome, cf;
	
	/**
	 * Costruttore classe Persona
	 * @param nome nome cliente
	 * @param cognome cognome cliente
	 * @param cf codice fiscale
	 */
	public Persona(String nome, String cognome, String cf) {
		this.nome=nome;
		this.cognome=cognome;
		this.cf=cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf.toUpperCase();
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public String toString() {
		return nome+" "+cognome+", "+getCf();
	}
	
	public boolean equals(Object p) {
		Persona p1 = (Persona)p;
		if(cf.equalsIgnoreCase(p1.getCf()))
			return true;
		else 
			return false;
				
	}
}
