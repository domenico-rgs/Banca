package lab.banca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import lab.banca.Banca;
import lab.conti.*;
import lab.persona.Persona;

/**
 * Programma per la gestione dei conti di una banca
 * @author domenico
 * @version 2.0
 */

public class Main {
		
	public static void main(String[] args) {
		Banca banca = new Banca("Poste",10,"0001"); //creazione banca

		Scanner input = new Scanner(System.in);
		int scelta = 0;
		@SuppressWarnings("unused")
		String prossimo=null;
		do {
			try {
				System.out.println("Operazione desiderata:\n0 - Termina\n1 - Creazione conto\n2 - Operazioni su conto\n3 - Login conto web\n4 - Logout conto web\n5 - Saldo totale\n6 - Stampa lista conti\n");
				System.out.print("Scelta: ");
				scelta = input.nextInt();
				

				switch(scelta) {
					case 1:
						System.out.print("\nInserisci nome, cognome, codice fiscale e tipo di conto (deposito, corrente - default, web): ");
						String nome=input.next();
						String cognome=input.next();
						String cf = input.next();
						String tipo = input.next();
						ContoType type;
						switch(tipo.toLowerCase()) {
							case "deposito":
								type = ContoType.DEPOSITO;
								break;
							case "web":
								type= ContoType.WEB;
								break;
							case "corrente":
								type=ContoType.CORRENTE;
								break;
							default:
								System.out.println("Tipo conto non riconosciuto, creazione conto corrente di default");
								type=ContoType.CORRENTE;
					
						}
						Conto conto1=banca.aggiungiConto(nome, cognome, cf, type);
						if(conto1!=null) {
							System.out.println("Conto creato correttamente!\nIban: "+conto1.getIban());
							if(type==ContoType.WEB)
								System.out.println("Password iniziale: changeme");
						}else
							System.out.println("Errore: raggiunto numero massimo di conti realizzabili\n");
						break;
					case 2:
						System.out.print("\nInserisci iban e quantità  di denaro (+ se deposito, - se prelievo): ");
						String iban = input.next();
						double denaro = input.nextDouble();
						if (banca.operazione(iban, denaro))
							System.out.println("Operazione effettuata correttamente\n");
						else
							System.out.println("Operazione non effettuata\n");
						break;
					case 3:
						System.out.print("Inserisci iban: ");
						Conto c = banca.getConto(input.next());
						if(c instanceof ContoWeb) {
							System.out.print("Inserisci password: ");
							((ContoWeb) c).login(input.next());
						}else {
							System.out.println("Non è stato trovato alcun conto web corrispondente");
						}
						break;
					case 4:
						System.out.print("Inserisci iban: ");
						Conto c2 = banca.getConto(input.next());
						if(c2 instanceof ContoWeb) {
							((ContoWeb) c2).logout();
						}else {
							System.out.println("Non è stato trovato alcun conto web corrispondente");
						}
						break;
					case 5:
						System.out.println("\nTotale saldi: "+banca.totaleSaldi()+"\n");
						break;
					case 6:
						System.out.println("");
						stampaConti(banca);
						break;
					}
			}catch(InputMismatchException e) {
				System.out.println("Input non riconosciuto");
				prossimo = input.next();
			}
		}while(scelta != 0);
		
		input.close();
		System.exit(0);	
	}
	
	/**
	 * Metodo per la stampa di tutti i conti della banca con relativi dati cliente
	 * @param banca banca in uso
	 */
	public static void stampaConti(Banca banca) {
		ArrayList<Conto> conti = new ArrayList<Conto>(banca.getConti().values());
		HashSet<Persona> arrayPersone = banca.getArrayPersone();
		Iterator<Persona> i = arrayPersone.iterator();
		Persona p;
		while(i.hasNext()) {
			p=i.next();
			System.out.println("Conti di "+p+":");
			for(int j=0; j<banca.getNumeroContiAttivi(); j++) {
				if(p.getCf().equalsIgnoreCase(conti.get(j).getCf()))
					System.out.println(conti.get(j));
			}
		}
		System.out.println();
	}
}
